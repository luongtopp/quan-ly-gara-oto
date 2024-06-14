/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.com.organization.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import src.com.organization.dao.BaoCaoKinhDoanhDAO;
import src.com.organization.model.BaoCaoKinhDoanh;
import src.com.organization.view.BaoCaoKinhDoanhView;
import src.com.organization.view.TrangChuView;

/**
 *
 * @author luongtopp
 */
public class TrangChuController {
    
    
 TrangChuView trangChuView;
    BaoCaoKinhDoanhDAO baoCaoKinhDoanhDAO;

    TrangChuController(TrangChuView trangChuView, BaoCaoKinhDoanhDAO baoCaoKinhDoanhDAO) {
        this.trangChuView = trangChuView;
        this.baoCaoKinhDoanhDAO = baoCaoKinhDoanhDAO;
        updateTable(baoCaoKinhDoanhDAO.getAll());

        trangChuView.getBtnRefresh().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                baoCaoKinhDoanhDAO.getAll();
                updateTable(baoCaoKinhDoanhDAO.getAll());
            }
        });
        trangChuView.getBtnTimKiem().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timKiemKhachHang(trangChuView.getTxtTimKiem().getText());
            }
        });

    }

    private void timKiemKhachHang(String tenKhachHang) {
        updateTable(baoCaoKinhDoanhDAO.timKiemKhachHang(tenKhachHang));
    }

    private void updateTable( List<BaoCaoKinhDoanh> giamDocList) {
        Object[][] data = new Object[giamDocList.size()][4];
        for (int i = 0; i < giamDocList.size(); i++) {
            BaoCaoKinhDoanh giamDoc = giamDocList.get(i);
            data[i] = new Object[]{
                giamDoc.getTenNguoiDung(),
                giamDoc.getMoTaSuaChua(),
            };
        }

        Object[] columnNames = {"Tên khách hàng", "Mô tả sửa chữa"};

        trangChuView.updateTable(data, columnNames);
    }
}
