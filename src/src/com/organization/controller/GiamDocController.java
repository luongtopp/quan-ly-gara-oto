package src.com.organization.controller;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import src.com.organization.dao.GiamDocDAO;
import src.com.organization.model.GiamDoc;
import src.com.organization.view.GiamDocView;

public class GiamDocController {

    private final GiamDocDAO giamDocDAO;
    private final GiamDocView giamDocView;

    public GiamDocController(GiamDocView giamDocView, GiamDocDAO giamDocDAO) {
        this.giamDocView = giamDocView;
        this.giamDocDAO = giamDocDAO;

        giamDocView.getBtnThem().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addGiamDoc();
            }
        });

        giamDocView.getBtnSua().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (editGiamDoc()) {
                    giamDocView.getBtnSua().setEnabled(false);
                    giamDocView.getBtnThem().setEnabled(true);
                }
            }
        });

        giamDocView.getMenuItemSua().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lấy hàng được chọn trong bảng
                int selectedRow = giamDocView.getTblGiamDoc().getSelectedRow();

                // Kiểm tra xem có hàng nào được chọn không
                if (selectedRow != -1) {
                    // Lấy thông tin từ các ô trong hàng đã chọn
                    int maGiamDoc = (int) giamDocView.getTblGiamDoc().getValueAt(selectedRow, 0);
                    String tenGiamDoc = (String) giamDocView.getTblGiamDoc().getValueAt(selectedRow, 1);
                    String email = (String) giamDocView.getTblGiamDoc().getValueAt(selectedRow, 2);
                    String soDienThoai = (String) giamDocView.getTblGiamDoc().getValueAt(selectedRow, 3);

                    // Điền thông tin vào các trường tương ứng trên giao diện
                    giamDocView.getTxtTenGiamDoc().setText(tenGiamDoc);
                    giamDocView.getTxtEmail().setText(email);
                    giamDocView.getTxtSoDienThoai().setText(soDienThoai);
                } else {
                    JOptionPane.showMessageDialog(giamDocView, "Vui lòng chọn một dòng để sửa.");
                }
            }
        });

        giamDocView.getMenuItemXoa().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteGiamDoc();
            }
        });

        updateTable();
    }

    private void addGiamDoc() {
        try {
            String tenGiamDoc = giamDocView.getTxtTenGiamDoc().getText();
            String email = giamDocView.getTxtEmail().getText();
            String soDienThoai = giamDocView.getTxtSoDienThoai().getText();

            if (tenGiamDoc.isEmpty() || email.isEmpty() || soDienThoai.isEmpty()) {
                JOptionPane.showMessageDialog(giamDocView, "Vui lòng nhập đầy đủ thông tin.");
                return;
            }

            GiamDoc giamDoc = new GiamDoc();
            giamDoc.setTenGiamDoc(tenGiamDoc);
            giamDoc.setEmail(email);
            giamDoc.setSoDienThoai(soDienThoai);

            giamDocDAO.insert(giamDoc);

            updateTable();
            clearFields();
        } catch (Exception ex) {
            System.err.println("Thông tin nhập vào không hợp lệ.");
        }
    }

    private boolean editGiamDoc() {
        int selectedRow = giamDocView.getTblGiamDoc().getSelectedRow();
        if (selectedRow != -1) {
            try {
                String tenGiamDoc = giamDocView.getTxtTenGiamDoc().getText();
                String email = giamDocView.getTxtEmail().getText();
                String soDienThoai = giamDocView.getTxtSoDienThoai().getText();

                if (tenGiamDoc.isEmpty() || email.isEmpty() || soDienThoai.isEmpty()) {
                    JOptionPane.showMessageDialog(giamDocView, "Vui lòng nhập đầy đủ thông tin.");
                    return false;
                }

                int maGiamDoc = (int) giamDocView.getTblGiamDoc().getValueAt(selectedRow, 0);

                GiamDoc giamDoc = new GiamDoc();
                giamDoc.setMaGiamDoc(maGiamDoc);
                giamDoc.setTenGiamDoc(tenGiamDoc);
                giamDoc.setEmail(email);
                giamDoc.setSoDienThoai(soDienThoai);

                giamDocDAO.update(giamDoc);

                updateTable();
                clearFields();
                return true;
            } catch (Exception ex) {
                System.err.println("Thông tin nhập vào không hợp lệ.");
            }
        } else {
            JOptionPane.showMessageDialog(giamDocView, "Vui lòng chọn một dòng để sửa.");
        }
        return false;
    }

    private void deleteGiamDoc() {
        int selectedRow = giamDocView.getTblGiamDoc().getSelectedRow();
        if (selectedRow != -1) {
            int maGiamDoc = (int) giamDocView.getTblGiamDoc().getValueAt(selectedRow, 0);

            if (giamDocDAO.isDependentDataExist(maGiamDoc)) {
                JOptionPane.showMessageDialog(giamDocView, "Không thể xóa dữ liệu này vì có dữ liệu phụ thuộc vào nó.");
                return;
            }

            int confirm = JOptionPane.showConfirmDialog(giamDocView, "Bạn có chắc chắn muốn xóa?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                giamDocDAO.delete(maGiamDoc);
                updateTable();
                clearFields();
            }
        } else {
            JOptionPane.showMessageDialog(giamDocView, "Vui lòng chọn một dòng để xóa.");
        }
    }

    private void updateTable() {
        List<GiamDoc> giamDocList = giamDocDAO.getAll();

        Object[][] data = new Object[giamDocList.size()][4];
        for (int i = 0; i < giamDocList.size(); i++) {
            GiamDoc giamDoc = giamDocList.get(i);
            data[i] = new Object[]{
                giamDoc.getMaGiamDoc(),
                giamDoc.getTenGiamDoc(),
                giamDoc.getEmail(),
                giamDoc.getSoDienThoai()
            };
        }

        Object[] columnNames = {"Mã Giám Đốc", "Tên Giám Đốc", "Email", "Số Điện Thoại"};

        giamDocView.updateTable(data, columnNames);
    }

    private void clearFields() {
        giamDocView.getTxtTenGiamDoc().setText("");
        giamDocView.getTxtEmail().setText("");
        giamDocView.getTxtSoDienThoai().setText("");
    }
}
