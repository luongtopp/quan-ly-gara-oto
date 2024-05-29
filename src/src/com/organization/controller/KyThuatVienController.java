package src.com.organization.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import src.com.organization.dao.KyThuatVienDAO;
import src.com.organization.model.KyThuatVien;
import src.com.organization.view.KyThuatVienView;

public class KyThuatVienController {

    private final KyThuatVienDAO kyThuatVienDAO;
    private final KyThuatVienView kyThuatVienView;

    public KyThuatVienController(KyThuatVienView kyThuatVienView, KyThuatVienDAO kyThuatVienDAO) {
        this.kyThuatVienView = kyThuatVienView;
        this.kyThuatVienDAO = kyThuatVienDAO;

        kyThuatVienView.getBtnThem().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addKyThuatVien();
            }
        });

        kyThuatVienView.getBtnSua().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editKyThuatVien();
            }
        });

        kyThuatVienView.getMenuItemSua().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadKyThuatVienForEditing();
            }
        });

        kyThuatVienView.getMenuItemXoa().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteKyThuatVien();
            }
        });

        updateTable();
    }

    private void addKyThuatVien() {
        try {
            String tenKyThuatVien = kyThuatVienView.getTxtHoVaTen().getText();
            String chuyenMon = kyThuatVienView.getTxtChuyenMon().getText();
            Date ngayThue = kyThuatVienView.getDateNgayThue().getDate();
            String soDienThoai = kyThuatVienView.getTxtSoDienThoai().getText();

            if (tenKyThuatVien.isEmpty() || chuyenMon.isEmpty() || ngayThue == null || soDienThoai.isEmpty()) {
                JOptionPane.showMessageDialog(kyThuatVienView, "Vui lòng nhập đầy đủ thông tin.");
                return;
            }

            KyThuatVien kyThuatVien = new KyThuatVien();
            kyThuatVien.setTenKyThuatVien(tenKyThuatVien);
            kyThuatVien.setChuyenMon(chuyenMon);
            kyThuatVien.setNgayThue(ngayThue);
            kyThuatVien.setSoDienThoai(soDienThoai);

            kyThuatVienDAO.insert(kyThuatVien);

            updateTable();
            clearFields();
        } catch (NumberFormatException ex) {
            System.err.println("Thông tin nhập vào không hợp lệ.");
        }
    }

    private void editKyThuatVien() {
        int selectedRow = kyThuatVienView.getTblKyThuatVien().getSelectedRow();
        if (selectedRow != -1) {
            try {
                int maKyThuatVien = Integer.parseInt(kyThuatVienView.getTblKyThuatVien().getValueAt(selectedRow, 0).toString());
                String tenKyThuatVien = kyThuatVienView.getTxtHoVaTen().getText();
                String chuyenMon = kyThuatVienView.getTxtChuyenMon().getText();
                Date ngayThue = kyThuatVienView.getDateNgayThue().getDate();
                String soDienThoai = kyThuatVienView.getTxtSoDienThoai().getText();

                if (tenKyThuatVien.isEmpty() || chuyenMon.isEmpty() || ngayThue == null || soDienThoai.isEmpty()) {
                    JOptionPane.showMessageDialog(kyThuatVienView, "Vui lòng nhập đầy đủ thông tin.");
                    return;
                }

                KyThuatVien kyThuatVien = new KyThuatVien();
                kyThuatVien.setMaKyThuatVien(maKyThuatVien);
                kyThuatVien.setTenKyThuatVien(tenKyThuatVien);
                kyThuatVien.setChuyenMon(chuyenMon);
                kyThuatVien.setNgayThue(ngayThue);
                kyThuatVien.setSoDienThoai(soDienThoai);

                kyThuatVienDAO.update(kyThuatVien);

                updateTable();
                clearFields();
            } catch (NumberFormatException ex) {
                System.err.println("Thông tin nhập vào không hợp lệ.");
            }
        } else {
            JOptionPane.showMessageDialog(kyThuatVienView, "Vui lòng chọn một dòng để sửa.");
        }
    }

    private void loadKyThuatVienForEditing() {
        int selectedRow = kyThuatVienView.getTblKyThuatVien().getSelectedRow();
        if (selectedRow != -1) {
            int maKyThuatVien = Integer.parseInt(kyThuatVienView.getTblKyThuatVien().getValueAt(selectedRow, 0).toString());
            String tenKyThuatVien = kyThuatVienView.getTblKyThuatVien().getValueAt(selectedRow, 1).toString();
            String chuyenMon = kyThuatVienView.getTblKyThuatVien().getValueAt(selectedRow, 2).toString();
            Date ngayThue = (Date) kyThuatVienView.getTblKyThuatVien().getValueAt(selectedRow, 3);
            String soDienThoai = kyThuatVienView.getTblKyThuatVien().getValueAt(selectedRow, 4).toString();

            kyThuatVienView.getTxtHoVaTen().setText(tenKyThuatVien);
            kyThuatVienView.getTxtChuyenMon().setText(chuyenMon);
            kyThuatVienView.getDateNgayThue().setDate(ngayThue);
            kyThuatVienView.getTxtSoDienThoai().setText(soDienThoai);
        } else {
            JOptionPane.showMessageDialog(kyThuatVienView, "Vui lòng chọn một dòng để sửa.");
        }
    }

    private void deleteKyThuatVien() {
        int selectedRow = kyThuatVienView.getTblKyThuatVien().getSelectedRow();
        if (selectedRow != -1) {
            int maKyThuatVien = (int) kyThuatVienView.getTblKyThuatVien().getValueAt(selectedRow, 0);

            if (kyThuatVienDAO.isDependentDataExist(maKyThuatVien)) {
                JOptionPane.showMessageDialog(kyThuatVienView, "Không thể xóa dữ liệu này vì có dữ liệu phụ thuộc vào nó.");
                return;
            }
            
            int confirm = JOptionPane.showConfirmDialog(kyThuatVienView, "Bạn có chắc chắn muốn xóa?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                kyThuatVienDAO.delete(maKyThuatVien);
                updateTable();
                clearFields();
            }
        } else {
            JOptionPane.showMessageDialog(kyThuatVienView, "Vui lòng chọn một dòng để xóa.");
        }
    }

    private void updateTable() {
        List<KyThuatVien> kyThuatVienList = kyThuatVienDAO.getAll();

        Object[][] data = new Object[kyThuatVienList.size()][5];
        for (int i = 0; i < kyThuatVienList.size(); i++) {
            KyThuatVien kyThuatVien = kyThuatVienList.get(i);
            data[i] = new Object[]{
                kyThuatVien.getMaKyThuatVien(),
                kyThuatVien.getTenKyThuatVien(),
                kyThuatVien.getChuyenMon(),
                kyThuatVien.getNgayThue(),
                kyThuatVien.getSoDienThoai()
            };
        }

        Object[] columnNames = {"Mã kỹ thuật viên", "Tên kỹ thuật viên", "Chuyên môn", "Ngày thuê", "Số điện thoại"};

        kyThuatVienView.updateTable(data, columnNames);
    }

    private void clearFields() {
        kyThuatVienView.getTxtHoVaTen().setText("");
        kyThuatVienView.getTxtChuyenMon().setText("");
        kyThuatVienView.getDateNgayThue().setDate(new Date());
        kyThuatVienView.getTxtSoDienThoai().setText("");
    }
}
