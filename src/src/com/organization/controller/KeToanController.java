package src.com.organization.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import src.com.organization.dao.KeToanDAO;
import src.com.organization.dao.SuaChuaDAO;
import src.com.organization.model.KeToan;
import src.com.organization.view.KeToanView;

public class KeToanController {

    private final KeToanDAO keToanDAO;
    private final SuaChuaDAO suaChuaDAO;

    private final KeToanView keToanView;

    public KeToanController(KeToanView keToanView, KeToanDAO keToanDAO, SuaChuaDAO suaChuaDAO) {
        this.keToanView = keToanView;
        this.keToanDAO = keToanDAO;
        this.suaChuaDAO = suaChuaDAO;

        keToanView.getBtnThem().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addKeToan();
            }
        });

        keToanView.getBtnSua().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (editKeToan()) {
                    keToanView.getBtnSua().setEnabled(false);
                    keToanView.getBtnThem().setEnabled(true);
                }

            }
        });

        keToanView.getMenuItemSua().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadKeToanForEditing();
            }
        });

        keToanView.getMenuItemXoa().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteKeToan();
            }
        });

        updateTable();
    }

    private void addKeToan() {
        try {
            int maSuaChua = Integer.parseInt(keToanView.getTxtMaSuaChua().getText());
            Date ngayLapHoaDon = keToanView.getDateNgayLapHoaDon().getDate();
            double tongTien = Double.parseDouble(keToanView.getTxtTongTien().getText());
            String trangThaiThanhToan = keToanView.getCboTrangThai().getSelectedItem().toString();
            if (maSuaChua == 0 || ngayLapHoaDon == null || tongTien == 0.0 || trangThaiThanhToan.isEmpty()) {
                JOptionPane.showMessageDialog(keToanView, "Vui lòng nhập đầy đủ thông tin.");
                return;
            }
            if (!suaChuaDAO.isSuaChuaExists(maSuaChua)) {
                JOptionPane.showMessageDialog(keToanView, "Mã vật tư không tồn tại.");
                return;
            }

            KeToan keToan = new KeToan(maSuaChua, ngayLapHoaDon, tongTien, trangThaiThanhToan);

            keToanDAO.insert(keToan);

            updateTable();
            clearFields();

        } catch (NumberFormatException ex) {
            System.err.println("Thông tin nhập vào không hợp lệ.");
        }
    }

    private boolean editKeToan() {
        int selectedRow = keToanView.getTblKeToan().getSelectedRow();
        if (selectedRow != -1) {
            try {
                int maHoaDon = Integer.parseInt(keToanView.getTblKeToan().getValueAt(selectedRow, 0).toString());
                int maSuaChua = Integer.parseInt(keToanView.getTxtMaSuaChua().getText());
                Date ngayLapHoaDon = keToanView.getDateNgayLapHoaDon().getDate();
                String tongTienStr = keToanView.getTxtTongTien().getText();
                double tongTien;
                if ("".equals(tongTienStr)) {
                    tongTien = 0.0;
                } else {
                    tongTien = Double.parseDouble(tongTienStr);
                }
                String trangThaiThanhToan = keToanView.getCboTrangThai().getSelectedItem().toString();

                if (maSuaChua == 0 || ngayLapHoaDon == null || tongTien == 0.0 || trangThaiThanhToan.isEmpty()) {
                    JOptionPane.showMessageDialog(keToanView, "Vui lòng nhập đầy đủ thông tin.");
                    return false;
                } else {
                    if (!suaChuaDAO.isSuaChuaExists(maSuaChua)) {
                        JOptionPane.showMessageDialog(keToanView, "Mã vật tư không tồn tại.");
                        return false;
                    }
                    KeToan keToan = new KeToan(maHoaDon, maSuaChua, ngayLapHoaDon, tongTien, trangThaiThanhToan);

                    keToanDAO.update(keToan);

                    updateTable();
                    clearFields();
                    return true;
                }

            } catch (NumberFormatException ex) {
                System.err.println("Thông tin nhập vào không hợp lệ.");
            }
        } else {
            JOptionPane.showMessageDialog(keToanView, "Vui lòng chọn một dòng để sửa.");
        }
        return false;
    }

    private void loadKeToanForEditing() {
        int selectedRow = keToanView.getTblKeToan().getSelectedRow();
        if (selectedRow != -1) {
            int maHoaDon = Integer.parseInt(keToanView.getTblKeToan().getValueAt(selectedRow, 0).toString());
            int maSuaChua = Integer.parseInt(keToanView.getTblKeToan().getValueAt(selectedRow, 1).toString());
            Date ngayLapHoaDon = (Date) keToanView.getTblKeToan().getValueAt(selectedRow, 2);
            double tongTien = Double.parseDouble(keToanView.getTblKeToan().getValueAt(selectedRow, 3).toString());
            String trangThaiThanhToan = (String) keToanView.getTblKeToan().getValueAt(selectedRow, 4);

            keToanView.getTxtMaSuaChua().setText(String.valueOf(maSuaChua));
            keToanView.getDateNgayLapHoaDon().setDate(ngayLapHoaDon);
            keToanView.getTxtTongTien().setText(String.valueOf(tongTien));
            keToanView.getCboTrangThai().setSelectedItem(trangThaiThanhToan);
        } else {
            JOptionPane.showMessageDialog(keToanView, "Vui lòng chọn một dòng để sửa.");
        }
    }

    private void deleteKeToan() {
        int selectedRow = keToanView.getTblKeToan().getSelectedRow();
        if (selectedRow != -1) {
            int confirm = JOptionPane.showConfirmDialog(keToanView, "Bạn có chắc chắn muốn xóa?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                int maHoaDon = Integer.parseInt(keToanView.getTblKeToan().getValueAt(selectedRow, 0).toString());

                keToanDAO.delete(maHoaDon);
                updateTable();
                clearFields();
            }
        } else {
            JOptionPane.showMessageDialog(keToanView, "Vui lòng chọn một dòng để xóa.");
        }
    }

    private void updateTable() {
        List<KeToan> keToanList = keToanDAO.getAll();

        Object[][] data = new Object[keToanList.size()][5];
        for (int i = 0; i < keToanList.size(); i++) {
            KeToan keToan = keToanList.get(i);
            data[i] = new Object[]{
                keToan.getMaHoaDon(),
                keToan.getMaSuaChua(),
                keToan.getNgayLapHoaDon(),
                keToan.getTongTien(),
                keToan.getTrangThaiThanhToan()
            };
        }

        Object[] columnNames = {"Mã hóa đơn", "Mã sửa chữa", "Ngày lập hóa đơn", "Tổng tiền", "Trạng thái thanh toán"};

        keToanView.updateTable(data, columnNames);
    }

    private void clearFields() {
        keToanView.getTxtMaSuaChua().setText("");
        keToanView.getDateNgayLapHoaDon().setDate(new Date());
        keToanView.getTxtTongTien().setText("");
        keToanView.getCboTrangThai().setSelectedIndex(-1);
    }
}
