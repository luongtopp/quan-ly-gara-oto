import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class DatabaseTableExample extends JFrame {

    private JTable table;

    public DatabaseTableExample() {
        setTitle("Database Table Example");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout());

        // Tạo một bảng trống với model mặc định
        table = new JTable();
        panel.add(new JScrollPane(table), BorderLayout.CENTER);

        // Lấy dữ liệu từ cơ sở dữ liệu và hiển thị lên bảng
        displayData();

        add(panel);
    }

    private void displayData() {
        // Kết nối đến cơ sở dữ liệu
        String url = "jdbc:mysql://localhost:3306/QuanLyGaraOto";
        String username = "root";
        String password = "";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "SELECT * FROM KeToan";

            // Tạo statement và thực thi truy vấn
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            // Tạo model cho bảng
            DefaultTableModel model = new DefaultTableModel();

            // Lấy metadata từ resultSet để thêm cột vào model
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                model.addColumn(metaData.getColumnLabel(columnIndex));
            }

            // Thêm dữ liệu từ resultSet vào model
            while (resultSet.next()) {
                Object[] rowData = new Object[columnCount];
                for (int i = 0; i < columnCount; i++) {
                    rowData[i] = resultSet.getObject(i + 1);
                }
                model.addRow(rowData);
            }

            // Đặt model cho bảng
            table.setModel(model);

            // Đóng resultSet và statement
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error retrieving data from database.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new DatabaseTableExample().setVisible(true);
        });
    }
}
