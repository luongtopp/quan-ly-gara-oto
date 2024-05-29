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
import java.util.Date;
import java.util.List;
import jdcbhepler.JdbcHelper;
import src.com.organization.model.KyThuatVien; // Đảm bảo import đúng lớp KyThuatVien từ gói phù hợp với ứng dụng của bạn

public class KyThuatVienDAO {

    public List<KyThuatVien> getAll() {
        List<KyThuatVien> kyThuatVienList = new ArrayList<>();
        String query = "SELECT * FROM KyThuatVien";
        try {
            ResultSet rs = JdbcHelper.executeQuery(query);
            while (rs.next()) {
                KyThuatVien kyThuatVien = mapResultSetToKyThuatVien(rs);
                kyThuatVienList.add(kyThuatVien);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return kyThuatVienList;
    }

    public KyThuatVien getById(int maKyThuatVien) {
        String query = "SELECT * FROM KyThuatVien WHERE maKyThuatVien=?";
        try {
            ResultSet rs = JdbcHelper.executeQuery(query, maKyThuatVien);
            if (rs.next()) {
                return mapResultSetToKyThuatVien(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean insert(KyThuatVien kyThuatVien) {
        String query = "INSERT INTO KyThuatVien (tenKyThuatVien, chuyenMon, ngayThue, soDienThoai) VALUES (?, ?, ?, ?)";
        try {
            JdbcHelper.executeUpdate(query, kyThuatVien.getTenKyThuatVien(), kyThuatVien.getChuyenMon(),
                    kyThuatVien.getNgayThue(), kyThuatVien.getSoDienThoai());
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(KyThuatVien kyThuatVien) {
        String query = "UPDATE KyThuatVien SET tenKyThuatVien=?, chuyenMon=?, ngayThue=?, soDienThoai=? WHERE maKyThuatVien=?";
        try {
            JdbcHelper.executeUpdate(query, kyThuatVien.getTenKyThuatVien(), kyThuatVien.getChuyenMon(),
                    kyThuatVien.getNgayThue(), kyThuatVien.getSoDienThoai(), kyThuatVien.getMaKyThuatVien());
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(int maKyThuatVien) {
        String query = "DELETE FROM KyThuatVien WHERE maKyThuatVien=?";
        try {
            JdbcHelper.executeUpdate(query, maKyThuatVien);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private KyThuatVien mapResultSetToKyThuatVien(ResultSet rs) throws SQLException {
        KyThuatVien kyThuatVien = new KyThuatVien();
        kyThuatVien.setMaKyThuatVien(rs.getInt("maKyThuatVien"));
        kyThuatVien.setTenKyThuatVien(rs.getString("tenKyThuatVien"));
        kyThuatVien.setChuyenMon(rs.getString("chuyenMon"));
        kyThuatVien.setNgayThue(rs.getDate("ngayThue"));
        kyThuatVien.setSoDienThoai(rs.getString("soDienThoai"));
        return kyThuatVien;
    }

    public boolean isDependentDataExist(int maKyThuatVien) {
        try {
            String checkQuery = "SELECT COUNT(*) FROM SuaChua WHERE MaKyThuatVien = ?";
            ResultSet rs = JdbcHelper.executeQuery(checkQuery, maKyThuatVien);
            if (rs.next()) {
                int count = rs.getInt(1);
                // Nếu count > 0, có dữ liệu phụ thuộc
                return count > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Xử lý nếu có lỗi xảy ra trong quá trình thực hiện truy vấn
        }
        return false;
    }
     public boolean isKyThuatVienExists(int maKyThuatVien) {      
        try {
            String sql = "SELECT COUNT(*) FROM KyThuatVien WHERE MaKyThuatVien = ?";
            ResultSet resultSet = JdbcHelper.executeQuery(sql, maKyThuatVien);
            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
     
}
