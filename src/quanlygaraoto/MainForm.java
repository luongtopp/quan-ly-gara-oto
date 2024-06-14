package quanlygaraoto;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import jdcbhepler.JdbcHelper;

public class MainForm extends JFrame {

    private JTable dataTable;
    private DefaultTableModel tableModel;
    private JTextField searchField;

    public MainForm() {
        setTitle("Quản lý sửa chữa xe");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel contentPane = new JPanel(new BorderLayout());
        setContentPane(contentPane);

        // Tạo panel trên cùng để chứa nút và ô tìm kiếm
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        contentPane.add(topPanel, BorderLayout.PAGE_START);

        // Ô tìm kiếm
        JLabel searchLabel = new JLabel("Tìm kiếm:");
        topPanel.add(searchLabel);

        searchField = new JTextField(20);
        topPanel.add(searchField);

        // Nút tìm kiếm
        JButton searchButton = new JButton("Tìm");
        searchButton.addActionListener(e -> {
            String keyword = searchField.getText().trim();
            searchTableData(keyword);
        });
        topPanel.add(searchButton);

        // Nút làm mới
        JButton refreshButton = new JButton("Làm mới");
        refreshButton.addActionListener(e -> {
            loadTableData();
            searchField.setText(""); // Xóa nội dung ô tìm kiếm
        });
        topPanel.add(refreshButton);

        // Tạo bảng để hiển thị dữ liệu
        tableModel = new DefaultTableModel();
        dataTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(dataTable);
        contentPane.add(scrollPane, BorderLayout.CENTER);

        // Button để load dữ liệu
        JButton loadDataButton = new JButton("Load Data");
        loadDataButton.addActionListener(e -> {
            loadTableData();
        });
        contentPane.add(loadDataButton, BorderLayout.PAGE_END);
    }

    private void loadTableData() {
        // Xóa dữ liệu cũ trong bảng
        tableModel.setRowCount(0);

        // Thực hiện truy vấn để lấy dữ liệu từ cơ sở dữ liệu
        String sql = "SELECT TenNguoiDung, MoTaSuaChua, NgaySuaChua, ChiPhi, SoLuongSuDung " +
                     "FROM NguoiDung JOIN Xe ON NguoiDung.TenNguoiDung = Xe.ChuSoHuu " +
                     "JOIN SuaChua ON Xe.MaXe = SuaChua.MaXe";
        try {
            ResultSet rs = JdbcHelper.executeQuery(sql);

            while (rs.next()) {
                String tenKhachHang = rs.getString("TenNguoiDung");
                String moTaSuaChua = rs.getString("MoTaSuaChua");
                String ngaySuaChua = rs.getString("NgaySuaChua");
                double chiPhi = rs.getDouble("ChiPhi");
                int soLuongSuDung = rs.getInt("SoLuongSuDung");

                tableModel.addRow(new Object[]{tenKhachHang, moTaSuaChua, ngaySuaChua, chiPhi, soLuongSuDung});
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Lỗi khi tải dữ liệu: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void searchTableData(String keyword) {
        // Xóa dữ liệu cũ trong bảng
        tableModel.setRowCount(0);

        // Thực hiện truy vấn để tìm kiếm dữ liệu từ cơ sở dữ liệu
        String sql = "SELECT TenNguoiDung, MoTaSuaChua, NgaySuaChua, ChiPhi, SoLuongSuDung " +
                     "FROM NguoiDung JOIN Xe ON NguoiDung.TenNguoiDung = Xe.ChuSoHuu " +
                     "JOIN SuaChua ON Xe.MaXe = SuaChua.MaXe " +
                     "WHERE TenNguoiDung LIKE ?";
        try {
            ResultSet rs = JdbcHelper.executeQuery(sql, "%" + keyword + "%");

            while (rs.next()) {
                String tenKhachHang = rs.getString("TenNguoiDung");
                String moTaSuaChua = rs.getString("MoTaSuaChua");
                String ngaySuaChua = rs.getString("NgaySuaChua");
                double chiPhi = rs.getDouble("ChiPhi");
                int soLuongSuDung = rs.getInt("SoLuongSuDung");

                tableModel.addRow(new Object[]{tenKhachHang, moTaSuaChua, ngaySuaChua, chiPhi, soLuongSuDung});
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Lỗi khi tìm kiếm dữ liệu: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

}
