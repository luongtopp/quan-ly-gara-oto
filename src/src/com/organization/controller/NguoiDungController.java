package src.com.organization.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import src.com.organization.dao.NguoiDungDAO;
import src.com.organization.model.NguoiDung;
import src.com.organization.view.NguoiDungView;

public class NguoiDungController {

    private final NguoiDungDAO nguoiDungDAO;
    private final NguoiDungView nguoiDungView;

    public NguoiDungController(NguoiDungView nguoiDungView, NguoiDungDAO nguoiDungDAO) {
        this.nguoiDungView = nguoiDungView;
        this.nguoiDungDAO = nguoiDungDAO;

        nguoiDungView.getBtnThem().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addUser();
            }
        });

        nguoiDungView.getBtnSua().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editUser();
            }
        });

        nguoiDungView.getMenuItemSua().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadUserForEditing();
            }
        });

        nguoiDungView.getMenuItemXoa().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteUser();
            }
        });

        updateTable();
    }

    private void addUser() {
        try {
            String tenDangNhap = nguoiDungView.getTxtTenTaiKhoan().getText();
            String matKhau = nguoiDungView.getTxtMatKhau().getText();
            String vaiTro = handleRoleChange(nguoiDungView.getCboVaiTro().getSelectedItem().toString());
            String tenNguoiDung = nguoiDungView.getTxtTenNguoiDung().getText();
            String email = nguoiDungView.getTxtEmail().getText();
            String soDienThoai = nguoiDungView.getTxtSoDienThoai().getText();
            if (tenDangNhap.isEmpty() || matKhau.isEmpty() || vaiTro.isEmpty() || tenNguoiDung.isEmpty() || email.isEmpty() || soDienThoai.isEmpty()) {
                JOptionPane.showMessageDialog(nguoiDungView, "Vui lòng nhập đầy đủ thông tin.");
                return;
            }

            if (nguoiDungDAO.isTenDangNhapExists(tenDangNhap)) {
                JOptionPane.showMessageDialog(nguoiDungView, "Tên tài khoản đã tồn tại.");
                return;
            }

            NguoiDung nguoiDung = new NguoiDung(tenDangNhap, matKhau, vaiTro, tenNguoiDung, email, soDienThoai);

            nguoiDungDAO.insert(nguoiDung);

            updateTable();
            clearFields();
        } catch (NumberFormatException ex) {
            System.err.println("Thông tin nhập vào không hợp lệ.");
        }
    }

    private void editUser() {
        int selectedRow = nguoiDungView.getTblNguoiDung().getSelectedRow();
        if (selectedRow != -1) {
            try {
                int maNguoiDung = Integer.parseInt(nguoiDungView.getTblNguoiDung().getValueAt(selectedRow, 0).toString());
                String tenDangNhap = nguoiDungView.getTxtTenTaiKhoan().getText();
                String matKhau = nguoiDungView.getTxtMatKhau().getText();
                String vaiTro = handleRoleChange(nguoiDungView.getCboVaiTro().getSelectedItem().toString());
                String tenNguoiDung = nguoiDungView.getTxtTenNguoiDung().getText();
                String email = nguoiDungView.getTxtEmail().getText();
                String soDienThoai = nguoiDungView.getTxtSoDienThoai().getText();
                if (tenDangNhap.isEmpty() || matKhau.isEmpty() || vaiTro.isEmpty() || tenNguoiDung.isEmpty() || email.isEmpty() || soDienThoai.isEmpty()) {
                    JOptionPane.showMessageDialog(nguoiDungView, "Vui lòng nhập đầy đủ thông tin.");
                    return;
                }
                NguoiDung nguoiDung = new NguoiDung(maNguoiDung, tenDangNhap, matKhau, vaiTro, tenNguoiDung, email, soDienThoai);

                nguoiDungDAO.update(nguoiDung);

                updateTable();
                clearFields();
            } catch (NumberFormatException ex) {
                System.err.println("Thông tin nhập vào không hợp lệ.");
            }
        } else {
            JOptionPane.showMessageDialog(nguoiDungView, "Vui lòng chọn một dòng để sửa.");
        }
    }

    private void loadUserForEditing() {
        int selectedRow = nguoiDungView.getTblNguoiDung().getSelectedRow();
        if (selectedRow != -1) {
            int maNguoiDung = Integer.parseInt(nguoiDungView.getTblNguoiDung().getValueAt(selectedRow, 0).toString());
            String tenDangNhap = nguoiDungView.getTblNguoiDung().getValueAt(selectedRow, 1).toString();
            String matKhau = nguoiDungView.getTblNguoiDung().getValueAt(selectedRow, 2).toString();
            String vaiTro = nguoiDungView.getTblNguoiDung().getValueAt(selectedRow, 3).toString();
            String tenNguoiDung = nguoiDungView.getTblNguoiDung().getValueAt(selectedRow, 4).toString();
            String email = nguoiDungView.getTblNguoiDung().getValueAt(selectedRow, 5).toString();
            String soDienThoai = nguoiDungView.getTblNguoiDung().getValueAt(selectedRow, 6).toString();

            nguoiDungView.getTxtTenTaiKhoan().setText(tenDangNhap);
            nguoiDungView.getTxtMatKhau().setText(matKhau);
            nguoiDungView.getCboVaiTro().setSelectedItem(vaiTro);
            nguoiDungView.getTxtTenNguoiDung().setText(tenNguoiDung);
            nguoiDungView.getTxtEmail().setText(email);
            nguoiDungView.getTxtSoDienThoai().setText(soDienThoai);
        } else {
            JOptionPane.showMessageDialog(nguoiDungView, "Vui lòng chọn một dòng để sửa.");
        }
    }

    private void deleteUser() {
        int selectedRow = nguoiDungView.getTblNguoiDung().getSelectedRow();
        if (selectedRow != -1) {
            int confirm = JOptionPane.showConfirmDialog(nguoiDungView, "Bạn có chắc chắn muốn xóa?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                int maNguoiDung = Integer.parseInt(nguoiDungView.getTblNguoiDung().getValueAt(selectedRow, 0).toString());

                nguoiDungDAO.delete(maNguoiDung);
                updateTable();
                clearFields();
            }
        } else {
            JOptionPane.showMessageDialog(nguoiDungView, "Vui lòng chọn một dòng để xóa.");
        }
    }

    private void updateTable() {
        List<NguoiDung> nguoiDungList = nguoiDungDAO.getAll();

        Object[][] data = new Object[nguoiDungList.size()][7];
        for (int i = 0; i < nguoiDungList.size(); i++) {
            NguoiDung nguoiDung = nguoiDungList.get(i);
            data[i] = new Object[]{
                nguoiDung.getMaNguoiDung(),
                nguoiDung.getTenDangNhap(),
                nguoiDung.getMatKhau(),
                nguoiDung.getVaiTro(),
                nguoiDung.getTenNguoiDung(),
                nguoiDung.getEmail(),
                nguoiDung.getSoDienThoai()
            };
        }

        Object[] columnNames = {"Mã người dùng", "Tên đăng nhập", "Mật khẩu", "Vai trò", "Tên người dùng", "Email", "Số điện thoại"};

        nguoiDungView.updateTable(data, columnNames);
    }

    private void clearFields() {
        nguoiDungView.getTxtTenTaiKhoan().setText("");
        nguoiDungView.getTxtMatKhau().setText("");
        nguoiDungView.getTxtTenNguoiDung().setText("");
        nguoiDungView.getTxtEmail().setText("");
        nguoiDungView.getTxtSoDienThoai().setText("");
        nguoiDungView.getCboVaiTro().setSelectedIndex(-1);
    }

    private String handleRoleChange(String vaiTro) {
        switch (vaiTro) {
            case "Nhân viên":
                return "NhanVien";
            case "Quản lý":
                return "QuanLy";
            case "Kỹ thuật viên":
                return "KyThuatVien";
            default:
                return null;
        }
    }
}
