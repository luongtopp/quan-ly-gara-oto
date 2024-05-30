package src.com.organization.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import src.com.organization.dao.XeDAO;
import src.com.organization.model.Xe;
import src.com.organization.view.XeView;

public class XeController {

    private final XeDAO xeDAO;
    private final XeView quanLyXeView;

    public XeController(XeView quanLyXeView, XeDAO xeDAO) {
        this.quanLyXeView = quanLyXeView;
        this.xeDAO = xeDAO;

        // Gán sự kiện cho nút thêm
        quanLyXeView.getBtnThem().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addXe();
            }
        });

        // Gán sự kiện cho nút sửa
        quanLyXeView.getBtnSua().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (editXe()) {
                    quanLyXeView.getBtnSua().setEnabled(false);
                    quanLyXeView.getBtnThem().setEnabled(true);
                }
            }
        });
        
         quanLyXeView.getBtnHuy().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                quanLyXeView.getBtnSua().setEnabled(false);
                quanLyXeView.getBtnThem().setEnabled(true);

                clearFields();
            }
        });
        quanLyXeView.getMenuItemSua().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadXeForEditing();
            }
        });

        // Gán sự kiện cho nút xóa
        quanLyXeView.getMenuItemXoa().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteXe();
            }
        });

        updateTable();
    }

    private void addXe() {
        try {
            // Lấy thông tin xe từ giao diện
            String bienSo = quanLyXeView.getTxtBienSo().getText().trim();
            String chuSoHuu = quanLyXeView.getTxtChuSoHuu().getText().trim();
            String model = quanLyXeView.getTxtModel().getText().trim();
            String namSanXuatStr = quanLyXeView.getTxtNamSanXuat().getText().trim();
            String mauSac = quanLyXeView.getTxtMauSac().getText().trim();

            // Kiểm tra các trường bắt buộc
            if (bienSo.isEmpty() || chuSoHuu.isEmpty() || model.isEmpty() || namSanXuatStr.isEmpty() || mauSac.isEmpty()) {
                JOptionPane.showMessageDialog(quanLyXeView, "Vui lòng nhập đầy đủ thông tin các trường.");
                return;
            }

            // Chuyển đổi giá trị từ chuỗi sang số
            int namSanXuat = Integer.parseInt(namSanXuatStr);

            // Tạo đối tượng Xe mới
            Xe xe = new Xe(bienSo, chuSoHuu, model, namSanXuat, mauSac);

            // Thêm xe vào cơ sở dữ liệu
            xeDAO.insert(xe);

            // Cập nhật bảng xe
            updateTable();

            // Xóa các trường thông tin sau khi thêm xe
            clearFields();
        } catch (NumberFormatException ex) {
            // Xử lý khi năm sản xuất không phải là số
            JOptionPane.showMessageDialog(quanLyXeView, "Năm sản xuất phải là số.");
        }
    }

    private boolean editXe() {
        int selectedRow = quanLyXeView.getTblXe().getSelectedRow();
        if (selectedRow != -1) {
            try {
                int maXe = Integer.parseInt(quanLyXeView.getTblXe().getValueAt(selectedRow, 0).toString());
                String bienSo = quanLyXeView.getTxtBienSo().getText().trim();
                String chuSoHuu = quanLyXeView.getTxtChuSoHuu().getText().trim();
                String model = quanLyXeView.getTxtModel().getText().trim();
                String namSanXuatStr = quanLyXeView.getTxtNamSanXuat().getText().trim();
                String mauSac = quanLyXeView.getTxtMauSac().getText().trim();

                if (bienSo.isEmpty() || chuSoHuu.isEmpty() || model.isEmpty() || namSanXuatStr.isEmpty() || mauSac.isEmpty()) {
                    JOptionPane.showMessageDialog(quanLyXeView, "Vui lòng nhập đầy đủ thông tin các trường.");
                    return false;
                }

                int namSanXuat = Integer.parseInt(namSanXuatStr);
                // Tạo đối tượng Xe mới
                Xe xe = new Xe(maXe, bienSo, chuSoHuu, model, namSanXuat, mauSac);

                // Sửa thông tin xe trong cơ sở dữ liệu
                xeDAO.update(xe);

                // Cập nhật bảng xe
                updateTable();

                // Xóa các trường thông tin sau khi sửa xe
                clearFields();
                return true;

            } catch (NumberFormatException ex) {
                // Xử lý khi năm sản xuất không phải là số
                JOptionPane.showMessageDialog(quanLyXeView, "Năm sản xuất phải là số.");

            }
        } else {
            JOptionPane.showMessageDialog(quanLyXeView, "Vui lòng chọn một dòng để sửa.");
        }
        return false;
    }

    private void deleteXe() {
        int selectedRow = quanLyXeView.getTblXe().getSelectedRow();
        if (selectedRow != -1) {
            int confirm = JOptionPane.showConfirmDialog(quanLyXeView, "Bạn có chắc chắn muốn xóa?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                int maXe = Integer.parseInt(quanLyXeView.getTblXe().getValueAt(selectedRow, 0).toString());

                // Xóa xe từ cơ sở dữ liệu
                xeDAO.delete(maXe);

                // Cập nhật bảng xe
                updateTable();

                // Xóa các trường thông tin sau khi xóa xe
                clearFields();
            }
        } else {
            JOptionPane.showMessageDialog(quanLyXeView, "Vui lòng chọn một dòng để xóa.");
        }
    }

    private void loadXeForEditing() {
        int selectedRow = quanLyXeView.getTblXe().getSelectedRow();
        if (selectedRow != -1) {
            String bienSo = quanLyXeView.getTblXe().getValueAt(selectedRow, 1).toString();
            String chuSoHuu = quanLyXeView.getTblXe().getValueAt(selectedRow, 2).toString();
            String model = quanLyXeView.getTblXe().getValueAt(selectedRow, 3).toString();
            int namSanXuat = Integer.parseInt(quanLyXeView.getTblXe().getValueAt(selectedRow, 4).toString());
            String mauSac = quanLyXeView.getTblXe().getValueAt(selectedRow, 5).toString();

            quanLyXeView.getTxtBienSo().setText(bienSo);
            quanLyXeView.getTxtChuSoHuu().setText(chuSoHuu);
            quanLyXeView.getTxtModel().setText(model);
            quanLyXeView.getTxtNamSanXuat().setText(String.valueOf(namSanXuat));
            quanLyXeView.getTxtMauSac().setText(mauSac);
        } else {
            JOptionPane.showMessageDialog(quanLyXeView, "Vui lòng chọn một dòng để sửa.");
        }
    }

    private void clearFields() {
        quanLyXeView.getTxtBienSo().setText("");
        quanLyXeView.getTxtChuSoHuu().setText("");
        quanLyXeView.getTxtModel().setText("");
        quanLyXeView.getTxtNamSanXuat().setText("");
        quanLyXeView.getTxtMauSac().setText("");
    }

    private void updateTable() {
        List<Xe> xeList = xeDAO.getAll();

        Object[][] data = new Object[xeList.size()][6];
        for (int i = 0; i < xeList.size(); i++) {
            Xe xe = xeList.get(i);
            data[i] = new Object[]{
                xe.getMaXe(),
                xe.getBienSo(),
                xe.getChuSoHuu(),
                xe.getModel(),
                xe.getNamSanXuat(),
                xe.getMauSac()
            };
        }

        Object[] columnNames = {"Mã xe", "Biển số", "Chủ sở hữu", "Model", "Năm sản xuất", "Màu sắc"};

        quanLyXeView.updateTable(data, columnNames);
    }
}
