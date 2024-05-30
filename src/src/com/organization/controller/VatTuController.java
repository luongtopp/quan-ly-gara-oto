package src.com.organization.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import src.com.organization.dao.VatTuDAO;
import src.com.organization.model.VatTu;
import src.com.organization.view.VatTuView;

public class VatTuController {

    private final VatTuDAO vatTuDAO;
    private final VatTuView vatTuView;

    public VatTuController(VatTuView vatTuView, VatTuDAO vatTuDAO) {
        this.vatTuView = vatTuView;
        this.vatTuDAO = vatTuDAO;

        vatTuView.getBtnThem().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addVatTu();
            }
        });

        vatTuView.getBtnSua().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (editVatTu()) {
                    vatTuView.getBtnSua().setEnabled(false);
                    vatTuView.getBtnThem().setEnabled(true);
                }
            }
        });
        
         vatTuView.getBtnHuy().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                vatTuView.getBtnSua().setEnabled(false);
                vatTuView.getBtnThem().setEnabled(true);

                clearFields();
            }
        });

        vatTuView.getMenuItemSua2().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadVatTuForEditing();
            }
        });

        vatTuView.getMenuItemXoa().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteVatTu();
            }
        });

        updateTable();
    }

    private void addVatTu() {
       
        try {
            String tenVatTu = vatTuView.getTxtTenVatTu().getText().trim();
            String soLuongStr = vatTuView.getTxtSoLuong().getText().trim();
            String donGiaStr = vatTuView.getTxtDonGia().getText().trim();
            String nhaCungCap = vatTuView.getTxtNhaCungCap().getText().trim();
            String ngayNhapStr = vatTuView.getTxtNgayNhap().getText().trim();
            String trangThai = vatTuView.getCboTrangThai().getSelectedItem().toString();

            if (tenVatTu.isEmpty() || soLuongStr.isEmpty() || donGiaStr.isEmpty() || nhaCungCap.isEmpty() || ngayNhapStr.isEmpty() || trangThai.isEmpty()) {
                JOptionPane.showMessageDialog(vatTuView, "Vui lòng nhập đầy đủ thông tin các trường.");
                return;
            }
            int soLuong = Integer.parseInt(soLuongStr);
            BigDecimal donGia = new BigDecimal(donGiaStr);

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date ngayNhap = dateFormat.parse(ngayNhapStr);

            VatTu vatTu = new VatTu(tenVatTu, soLuong, donGia, nhaCungCap, ngayNhap, trangThai);

            vatTuDAO.insert(vatTu);

            updateTable();
            clearFields();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(vatTuView, "Số lượng và đơn giá phải là số hợp lệ.");
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(vatTuView, "Ngày nhập phải có định dạng dd/MM/yyyy.");
        }
    }

    private boolean editVatTu() {
        int selectedRow = vatTuView.getTblVatTu().getSelectedRow();
        if (selectedRow != -1) {
            try {
                int maVatTu = Integer.parseInt(vatTuView.getTblVatTu().getValueAt(selectedRow, 0).toString());
                String tenVatTu = vatTuView.getTxtTenVatTu().getText().trim();
                String soLuongStr = vatTuView.getTxtSoLuong().getText().trim();
                String donGiaStr = vatTuView.getTxtDonGia().getText().trim();
                String nhaCungCap = vatTuView.getTxtNhaCungCap().getText().trim();
                String ngayNhapStr = vatTuView.getTxtNgayNhap().getText().trim();
                String trangThai = vatTuView.getCboTrangThai().getSelectedItem().toString();

                if (tenVatTu.isEmpty() || soLuongStr.isEmpty() || donGiaStr.isEmpty() || nhaCungCap.isEmpty() || ngayNhapStr.isEmpty() || trangThai.isEmpty()) {
                    JOptionPane.showMessageDialog(vatTuView, "Vui lòng nhập đầy đủ thông tin các trường.");
                    return false;
                }
                int soLuong = Integer.parseInt(soLuongStr);
                BigDecimal donGia = new BigDecimal(donGiaStr);

                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                Date ngayNhap = dateFormat.parse(ngayNhapStr);

                VatTu vatTu = new VatTu(maVatTu, tenVatTu, soLuong, donGia, nhaCungCap, ngayNhap, trangThai);

                vatTuDAO.update(vatTu);

                updateTable();
                clearFields();
                return true;
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(vatTuView, "Số lượng và đơn giá phải là số hợp lệ.");
                return false;
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(vatTuView, "Ngày nhập phải có định dạng dd/MM/yyyy.");
                return false;
            }
        } else {

            JOptionPane.showMessageDialog(vatTuView, "Vui lòng chọn một dòng để sửa.");
            return false;
        }
    }

    private void loadVatTuForEditing() {
        int selectedRow = vatTuView.getTblVatTu().getSelectedRow();
        if (selectedRow != -1) {
            int maVatTu = Integer.parseInt(vatTuView.getTblVatTu().getValueAt(selectedRow, 0).toString());
            String tenVatTu = vatTuView.getTblVatTu().getValueAt(selectedRow, 1).toString();
            int soLuong = Integer.parseInt(vatTuView.getTblVatTu().getValueAt(selectedRow, 2).toString());
            BigDecimal donGia = new BigDecimal(vatTuView.getTblVatTu().getValueAt(selectedRow, 3).toString());
            String nhaCungCap = vatTuView.getTblVatTu().getValueAt(selectedRow, 4).toString();
            Date ngayNhap = (Date) vatTuView.getTblVatTu().getValueAt(selectedRow, 5);
            String trangThai = vatTuView.getTblVatTu().getValueAt(selectedRow, 6).toString();

            vatTuView.getTxtTenVatTu().setText(tenVatTu);
            vatTuView.getTxtSoLuong().setText(String.valueOf(soLuong));
            vatTuView.getTxtDonGia().setText(donGia.toString());
            vatTuView.getTxtNhaCungCap().setText(nhaCungCap);
            vatTuView.getTxtNgayNhap().setText(new SimpleDateFormat("dd/MM/yyyy").format(ngayNhap));
            vatTuView.getCboTrangThai().setSelectedItem(trangThai);
        } else {
            JOptionPane.showMessageDialog(vatTuView, "Vui lòng chọn một dòng để sửa.");
        }
    }

    private void deleteVatTu() {
        int selectedRow = vatTuView.getTblVatTu().getSelectedRow();
        if (selectedRow != -1) {
            int maVatTu = (int) vatTuView.getTblVatTu().getValueAt(selectedRow, 0);

            int confirm = JOptionPane.showConfirmDialog(vatTuView, "Bạn có chắc chắn muốn xóa?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                vatTuDAO.delete(maVatTu);
                updateTable();
                clearFields();
            }
        } else {
            JOptionPane.showMessageDialog(vatTuView, "Vui lòng chọn một dòng để xóa.");
        }
    }

    private void updateTable() {
        List<VatTu> vatTuList = vatTuDAO.getAll();

        Object[][] data = new Object[vatTuList.size()][7];
        for (int i = 0; i < vatTuList.size(); i++) {
            VatTu vatTu = vatTuList.get(i);
            data[i] = new Object[]{
                vatTu.getMaVatTu(),
                vatTu.getTenVatTu(),
                vatTu.getSoLuong(),
                vatTu.getDonGia(),
                vatTu.getNhaCungCap(),
                vatTu.getNgayNhap(),
                vatTu.getTrangThai()
            };
        }

        Object[] columnNames = {"Mã vật tư", "Tên vật tư", "Số lượng", "Đơn giá", "Nhà cung cấp", "Ngày nhập", "Trạng thái"};

        vatTuView.updateTable(data, columnNames);
    }

    private void clearFields() {
        vatTuView.getTxtTenVatTu().setText("");
        vatTuView.getTxtSoLuong().setText("");
        vatTuView.getTxtDonGia().setText("");
        vatTuView.getTxtNhaCungCap().setText("");
        vatTuView.getTxtNgayNhap().setText("");
        vatTuView.getCboTrangThai().setSelectedIndex(-1);
    }
}
