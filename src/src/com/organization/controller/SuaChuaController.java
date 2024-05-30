package src.com.organization.controller;

import src.com.organization.dao.SuaChuaDAO;
import src.com.organization.dao.XeDAO;
import src.com.organization.dao.VatTuDAO;
import src.com.organization.dao.KyThuatVienDAO;
import src.com.organization.model.SuaChua;
import src.com.organization.view.SuaChuaView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

public class SuaChuaController {

    private final SuaChuaDAO suaChuaDAO;
    private final XeDAO xeDAO;
    private final VatTuDAO vatTuDAO;
    private final KyThuatVienDAO kyThuatVienDAO;
    private final SuaChuaView suaChuaView;

    public SuaChuaController(SuaChuaView suaChuaView, SuaChuaDAO suaChuaDAO, XeDAO xeDAO, VatTuDAO vatTuDAO, KyThuatVienDAO kyThuatVienDAO) {
        this.suaChuaView = suaChuaView;
        this.suaChuaDAO = suaChuaDAO;
        this.xeDAO = xeDAO;
        this.vatTuDAO = vatTuDAO;
        this.kyThuatVienDAO = kyThuatVienDAO;

        suaChuaView.getBtnThem().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addSuaChua();
            }
        });

        suaChuaView.getBtnSua().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
                if (editSuaChua()) {
                    suaChuaView.getBtnSua().setEnabled(false);
                    suaChuaView.getBtnThem().setEnabled(true);
                } else {
                    
                }
            }
        });
        
         suaChuaView.getBtnHuy().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                suaChuaView.getBtnSua().setEnabled(false);
                suaChuaView.getBtnThem().setEnabled(true);

                clearFields();
            }
        });

        suaChuaView.getMenuItemSua2().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadSuaChuaForEditing();
                
            }
        });

        suaChuaView.getMenuItemXoa().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteSuaChua();
            }
        });

        updateTable();
    }

    private void addSuaChua() {
        try {
            int maXe = Integer.parseInt(suaChuaView.getTxtMaXe().getText());
            String moTaSuaChua = suaChuaView.getTxtMoTaSuaChua().getText();
            Date ngaySuaChua = suaChuaView.getDateNgaySuaChua().getDate();
            int maVatTu = Integer.parseInt(suaChuaView.getTxtMaVatTu().getText());
            int soLuongSuDung = Integer.parseInt(suaChuaView.getTxtSoLuongSuDung().getText());
            int maKyThuatVien = Integer.parseInt(suaChuaView.getTxtMaKyThuatVien().getText());
            BigDecimal chiPhi = new BigDecimal(suaChuaView.getTxtChiPhi().getText());

            if (!xeDAO.isXeExists(maXe)) {
                JOptionPane.showMessageDialog(suaChuaView, "Mã xe không tồn tại.");
                return;
            }

            if (!vatTuDAO.isVatTuExists(maVatTu)) {
                JOptionPane.showMessageDialog(suaChuaView, "Mã vật tư không tồn tại.");
                return;
            }

            if (!kyThuatVienDAO.isKyThuatVienExists(maKyThuatVien)) {
                JOptionPane.showMessageDialog(suaChuaView, "Mã kỹ thuật viên không tồn tại.");
                return;
            }

            SuaChua suaChua = new SuaChua();
            suaChua.setMaXe(maXe);
            suaChua.setMoTaSuaChua(moTaSuaChua);
            suaChua.setNgaySuaChua(ngaySuaChua);
            suaChua.setMaVatTu(maVatTu);
            suaChua.setSoLuongSuDung(soLuongSuDung);
            suaChua.setMaKyThuatVien(maKyThuatVien);
            suaChua.setChiPhi(chiPhi);

            suaChuaDAO.insert(suaChua);

            updateTable();
            clearFields();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(suaChuaView, "Mã, số lượng, và chi phí phải là số.");
        }
    }

    private boolean editSuaChua() {
        int selectedRow = suaChuaView.getTblSuaChua().getSelectedRow();
        if (selectedRow != -1) {
            try {
                int maSuaChua = Integer.parseInt(suaChuaView.getTblSuaChua().getValueAt(selectedRow, 0).toString());
                int maXe = Integer.parseInt(suaChuaView.getTxtMaXe().getText());
                String moTaSuaChua = suaChuaView.getTxtMoTaSuaChua().getText();
                Date ngaySuaChua = suaChuaView.getDateNgaySuaChua().getDate();
                int maVatTu = Integer.parseInt(suaChuaView.getTxtMaVatTu().getText());
                int soLuongSuDung = Integer.parseInt(suaChuaView.getTxtSoLuongSuDung().getText());
                int maKyThuatVien = Integer.parseInt(suaChuaView.getTxtMaKyThuatVien().getText());
                BigDecimal chiPhi = new BigDecimal(suaChuaView.getTxtChiPhi().getText());

                if (!xeDAO.isXeExists(maXe)) {
                    JOptionPane.showMessageDialog(suaChuaView, "Mã xe không tồn tại.");
                    return false;
                }

                if (!vatTuDAO.isVatTuExists(maVatTu)) {
                    JOptionPane.showMessageDialog(suaChuaView, "Mã vật tư không tồn tại.");
                    return false;
                }

                if (!kyThuatVienDAO.isKyThuatVienExists(maKyThuatVien)) {
                    JOptionPane.showMessageDialog(suaChuaView, "Mã kỹ thuật viên không tồn tại.");
                    return false;
                }

                SuaChua suaChua = new SuaChua();
                suaChua.setMaSuaChua(maSuaChua);
                suaChua.setMaXe(maXe);
                suaChua.setMoTaSuaChua(moTaSuaChua);
                suaChua.setNgaySuaChua(ngaySuaChua);
                suaChua.setMaVatTu(maVatTu);
                suaChua.setSoLuongSuDung(soLuongSuDung);
                suaChua.setMaKyThuatVien(maKyThuatVien);
                suaChua.setChiPhi(chiPhi);

                suaChuaDAO.update(suaChua);

                updateTable();
                clearFields();
                return true;
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(suaChuaView, "Mã, số lượng, và chi phí phải là số.");
            }
        } else {
            JOptionPane.showMessageDialog(suaChuaView, "Vui lòng chọn một dòng để sửa.");
        }
        return false;
    }

    private void loadSuaChuaForEditing() {
        int selectedRow = suaChuaView.getTblSuaChua().getSelectedRow();
        if (selectedRow != -1) {
            int maSuaChua = Integer.parseInt(suaChuaView.getTblSuaChua().getValueAt(selectedRow, 0).toString());
            int maXe = Integer.parseInt(suaChuaView.getTblSuaChua().getValueAt(selectedRow, 1).toString());
            String moTaSuaChua = suaChuaView.getTblSuaChua().getValueAt(selectedRow, 2).toString();
            Date ngaySuaChua = (Date) suaChuaView.getTblSuaChua().getValueAt(selectedRow, 3);
            int maVatTu = Integer.parseInt(suaChuaView.getTblSuaChua().getValueAt(selectedRow, 4).toString());
            int soLuongSuDung = Integer.parseInt(suaChuaView.getTblSuaChua().getValueAt(selectedRow, 5).toString());
            int maKyThuatVien = Integer.parseInt(suaChuaView.getTblSuaChua().getValueAt(selectedRow, 6).toString());
            BigDecimal chiPhi = new BigDecimal(suaChuaView.getTblSuaChua().getValueAt(selectedRow, 7).toString());

            suaChuaView.getTxtMaXe().setText(String.valueOf(maXe));
            suaChuaView.getTxtMoTaSuaChua().setText(moTaSuaChua);
            suaChuaView.getDateNgaySuaChua().setDate(ngaySuaChua);
            suaChuaView.getTxtMaVatTu().setText(String.valueOf(maVatTu));
            suaChuaView.getTxtSoLuongSuDung().setText(String.valueOf(soLuongSuDung));
            suaChuaView.getTxtMaKyThuatVien().setText(String.valueOf(maKyThuatVien));
            suaChuaView.getTxtChiPhi().setText(String.valueOf(chiPhi));
        } else {
            JOptionPane.showMessageDialog(suaChuaView, "Vui lòng chọn một dòng để sửa.");
        }
    }

    private void deleteSuaChua() {
        int selectedRow = suaChuaView.getTblSuaChua().getSelectedRow();
        if (selectedRow != -1) {
            int confirm = JOptionPane.showConfirmDialog(suaChuaView, "Bạn có chắc chắn muốn xóa?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                int maSuaChua = Integer.parseInt(suaChuaView.getTblSuaChua().getValueAt(selectedRow, 0).toString());

                suaChuaDAO.delete(maSuaChua);
                updateTable();
                clearFields();
            }
        } else {
            JOptionPane.showMessageDialog(suaChuaView, "Vui lòng chọn một dòng để xóa.");
        }
    }

    private void clearFields() {
        suaChuaView.getTxtMaXe().setText("");
        suaChuaView.getTxtMoTaSuaChua().setText("");
        suaChuaView.getDateNgaySuaChua().setDate(new Date());
        suaChuaView.getTxtMaVatTu().setText("");
        suaChuaView.getTxtSoLuongSuDung().setText("");
        suaChuaView.getTxtMaKyThuatVien().setText("");
        suaChuaView.getTxtChiPhi().setText("");
    }

    private void updateTable() {
        List<SuaChua> suaChuaList = suaChuaDAO.getAll();

        Object[][] data = new Object[suaChuaList.size()][8];
        for (int i = 0; i < suaChuaList.size(); i++) {
            SuaChua suaChua = suaChuaList.get(i);
            data[i] = new Object[]{
                suaChua.getMaSuaChua(),
                suaChua.getMaXe(),
                suaChua.getMoTaSuaChua(),
                suaChua.getNgaySuaChua(),
                suaChua.getMaVatTu(),
                suaChua.getSoLuongSuDung(),
                suaChua.getMaKyThuatVien(),
                suaChua.getChiPhi()
            };
        }

        Object[] columnNames = {"Mã sửa chữa", "Mã xe", "Mô tả sửa chữa", "Ngày sửa chữa", "Mã vật tư", "Số lượng sử dụng", "Mã kỹ thuật viên", "Chi phí"};

        suaChuaView.updateTable(data, columnNames);
    }
}
