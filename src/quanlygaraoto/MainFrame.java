import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Vector;
import jdcbhepler.JdbcHelper;

public class MainFrame extends JFrame {
    private JComboBox<Integer> monthComboBox;
    private JTable table;

    public MainFrame() {
        setTitle("Doanh Thu Theo Thang");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Tạo combobox để chọn tháng
        monthComboBox = new JComboBox<>();
        for (int i = 1; i <= 12; i++) {
            monthComboBox.addItem(i);
        }
        monthComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedMonth = (int) monthComboBox.getSelectedItem();
                updateTable(selectedMonth);
            }
        });

        // Bảng để hiển thị dữ liệu
        table = new JTable();

        // Đặt combobox và bảng vào frame
        add(monthComboBox, BorderLayout.NORTH);
        add(new JScrollPane(table), BorderLayout.CENTER);

        // Hiển thị dữ liệu của tháng đầu tiên khi khởi động
        updateTable(1);
    }

    private void updateTable(int month) {
        try {
            String query = "SELECT " +
                           "    MONTH(k.NgayLapHoaDon) AS Thang, " +
                           "    DATE(k.NgayLapHoaDon) AS Ngay, " +
                           "    kt.TenNguoiDung AS TenKeToan, " +
                           "    s.MoTaSuaChua AS TenSuaChua, " +
                           "    ktv.TenKyThuatVien AS TenKyThuatVien, " +
                           "    SUM(k.TongTien) AS DoanhThu " +
                           "FROM " +
                           "    KeToan k " +
                           "JOIN " +
                           "    SuaChua s ON k.MaSuaChua = s.MaSuaChua " +
                           "JOIN " +
                           "    KyThuatVien ktv ON s.MaKyThuatVien = ktv.MaKyThuatVien " +
                           "JOIN " +
                           "    NguoiDung kt ON kt.MaNguoiDung = k.MaHoaDon " +
                           "WHERE " +
                           "    MONTH(k.NgayLapHoaDon) = ? " +
                           "GROUP BY " +
                           "    DATE(k.NgayLapHoaDon), kt.TenNguoiDung, s.MoTaSuaChua, ktv.TenKyThuatVien " +
                           "ORDER BY " +
                           "    Ngay";

            ResultSet rs = JdbcHelper.executeQuery(query, month);

            // Chuyển đổi ResultSet thành DefaultTableModel
            DefaultTableModel tableModel = buildTableModel(rs);

            // Cập nhật bảng
            table.setModel(tableModel);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }

    private DefaultTableModel buildTableModel(ResultSet rs) throws SQLException {
        ResultSetMetaData metaData = rs.getMetaData();

        // Tên cột
        int columnCount = metaData.getColumnCount();
        Vector<String> columnNames = new Vector<>(columnCount);
        for (int column = 1; column <= columnCount; column++) {
            columnNames.add(metaData.getColumnName(column));
        }

        // Dữ liệu hàng
        Vector<Vector<Object>> data = new Vector<>();
        while (rs.next()) {
            Vector<Object> vector = new Vector<>(columnCount);
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                vector.add(rs.getObject(columnIndex));
            }
            data.add(vector);
        }

        return new DefaultTableModel(data, columnNames);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainFrame frame = new MainFrame();
            frame.setVisible(true);
        });
    }
}
