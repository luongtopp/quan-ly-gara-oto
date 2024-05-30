/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.com.organization.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import jdcbhepler.JdbcHelper;
import src.com.organization.dao.ThongKeDAO;
import src.com.organization.view.ThongKeView;

/**
 *
 * @author luongtopp
 */
public class ThongKeController {

    ThongKeView thongKeView;

    ThongKeController(ThongKeView thongKeView) {

    }

    ThongKeController(ThongKeView thongKeView, ThongKeDAO thongKeDAO) {
        this.thongKeView = thongKeView;

        thongKeView.getBtnStatistics().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedOption = (String) thongKeView.getComboBox().getSelectedItem();
                if (selectedOption.equals("Theo ngày")) {
                    // Thống kê theo ngày
                    showRevenueByDay();
                } else if (selectedOption.equals("Theo tháng")) {
                    // Thống kê theo tháng
                    showRevenueByMonth();
                } else if (selectedOption.equals("Theo năm")) {
                    // Thống kê theo năm
                    showRevenueByYear();
                }
            }
        });
    }

    private void showRevenueByDay() {
        String sql = "SELECT NgayLapHoaDon AS 'Ngày', SUM(TongTien) AS 'Doanh thu', COUNT(*) AS 'Số lượng' FROM KeToan WHERE TrangThaiThanhToan = 'Đã thanh toán' GROUP BY Ngày";
        ResultSet rs = JdbcHelper.executeQuery(sql);
        displayResultSet(rs);
    }

    private void showRevenueByMonth() {
        String sql = "SELECT MONTH(NgayLapHoaDon) AS 'Tháng', SUM(TongTien) AS 'Doanh thu', COUNT(*) AS 'Số lượng' FROM KeToan WHERE TrangThaiThanhToan = 'Đã thanh toán' GROUP BY Tháng";
        ResultSet rs = JdbcHelper.executeQuery(sql);
        displayResultSet(rs);
    }

    private void showRevenueByYear() {
        String sql = "SELECT YEAR(NgayLapHoaDon) AS 'Năm', SUM(TongTien) AS 'Doanh thu', COUNT(*) AS 'Số lượng' FROM KeToan WHERE TrangThaiThanhToan = 'Đã thanh toán' GROUP BY Năm";
        ResultSet rs = JdbcHelper.executeQuery(sql);
        displayResultSet(rs);
    }

    private void displayResultSet(ResultSet rs) {
        try {
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            // Tạo một mô hình dữ liệu mới
            DefaultTableModel model = new DefaultTableModel();

            // Thêm các tên cột tiếng Việt vào mô hình dữ liệu
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                model.addColumn(getColumnName(metaData.getColumnName(columnIndex)));
            }

            // Thêm dữ liệu từ ResultSet vào mô hình dữ liệu
            while (rs.next()) {
                Object[] rowData = new Object[columnCount];
                for (int i = 0; i < columnCount; i++) {
                    rowData[i] = rs.getObject(i + 1);
                }
                model.addRow(rowData);
            }

            // Đặt mô hình dữ liệu mới vào bảng
            thongKeView.getTblThongKe().setModel(model);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private String getColumnName(String columnName) {
        switch (columnName) {
            case "Ngày":
                return "Ngày";
            case "Tháng":
                return "Tháng";
            case "Năm":
                return "Năm";
            case "TongTien":
                return "Doanh thu";
            default:
                return columnName;
        }
    }

}
