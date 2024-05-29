/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.com.organization.dao;

/**
 *
 * @author luongtopp
 */
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import jdcbhepler.JdbcHelper;
import src.com.organization.model.Xe; // Đảm bảo import đúng lớp Xe từ gói phù hợp với ứng dụng của bạn

public class XeDAO {
    
    public List<Xe> getAll() {
        List<Xe> xeList = new ArrayList<>();
        String query = "SELECT * FROM Xe";
        try {
            ResultSet rs = JdbcHelper.executeQuery(query);
            while (rs.next()) {
                Xe xe = mapResultSetToXe(rs);
                xeList.add(xe);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return xeList;
    }

    public List<Xe> search(String keyword) {
        List<Xe> xeList = new ArrayList<>();
        String query = "SELECT * FROM Xe WHERE bienSo LIKE ?";
        try {
            ResultSet rs = JdbcHelper.executeQuery(query, "%" + keyword + "%");
            while (rs.next()) {
                Xe xe = mapResultSetToXe(rs);
                xeList.add(xe);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return xeList;
    }

    public boolean insert(Xe xe) {
        String query = "INSERT INTO Xe (bienSo, chuSoHuu, model, namSanXuat, mauSac) VALUES (?, ?, ?, ?, ?)";
        try {
            JdbcHelper.executeUpdate(query, xe.getBienSo(), xe.getChuSoHuu(), xe.getModel(),
                    xe.getNamSanXuat(), xe.getMauSac());
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(Xe xe) {
        String query = "UPDATE Xe SET bienSo=?, chuSoHuu=?, model=?, namSanXuat=?, mauSac=? WHERE maXe=?";
        try {
            JdbcHelper.executeUpdate(query, xe.getBienSo(), xe.getChuSoHuu(), xe.getModel(),
                    xe.getNamSanXuat(), xe.getMauSac(), xe.getMaXe());
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(int maXe) {
        String query = "DELETE FROM Xe WHERE maXe=?";
        try {
            JdbcHelper.executeUpdate(query, maXe);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean isXeExists(int maXe) {
         try {
            String sql = "SELECT COUNT(*) FROM Xe WHERE MaXe = ?";
            ResultSet resultSet = JdbcHelper.executeQuery(sql, maXe);
            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private Xe mapResultSetToXe(ResultSet rs) throws SQLException {
        Xe xe = new Xe();
        xe.setMaXe(rs.getInt("maXe"));
        xe.setBienSo(rs.getString("bienSo"));
        xe.setChuSoHuu(rs.getString("chuSoHuu"));
        xe.setModel(rs.getString("model"));
        xe.setNamSanXuat(rs.getInt("namSanXuat"));
        xe.setMauSac(rs.getString("mauSac"));
        return xe;
    }
}
