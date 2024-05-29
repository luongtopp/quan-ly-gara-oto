/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.com.organization.dao;

/**
 *
 * @author luongtopp
 */
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import jdcbhepler.JdbcHelper;
import src.com.organization.model.SuaChua; // Đảm bảo import đúng lớp SuaChua từ gói phù hợp với ứng dụng của bạn

public class SuaChuaDAO {
    
    public List<SuaChua> getAll() {
        List<SuaChua> suaChuaList = new ArrayList<>();
        String query = "SELECT * FROM SuaChua";
        try {
            ResultSet rs = JdbcHelper.executeQuery(query);
            while (rs.next()) {
                SuaChua suaChua = mapResultSetToSuaChua(rs);
                suaChuaList.add(suaChua);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return suaChuaList;
    }

    public List<SuaChua> search(int maXe) {
        List<SuaChua> suaChuaList = new ArrayList<>();
        String query = "SELECT * FROM SuaChua WHERE maXe = ?";
        try {
            ResultSet rs = JdbcHelper.executeQuery(query, maXe);
            while (rs.next()) {
                SuaChua suaChua = mapResultSetToSuaChua(rs);
                suaChuaList.add(suaChua);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return suaChuaList;
    }

    public boolean insert(SuaChua suaChua) {
        String query = "INSERT INTO SuaChua (maXe, moTaSuaChua, ngaySuaChua, maVatTu, soLuongSuDung, maKyThuatVien, chiPhi) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            JdbcHelper.executeUpdate(query, suaChua.getMaXe(), suaChua.getMoTaSuaChua(), suaChua.getNgaySuaChua(),
                    suaChua.getMaVatTu(), suaChua.getSoLuongSuDung(), suaChua.getMaKyThuatVien(), suaChua.getChiPhi());
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(SuaChua suaChua) {
        String query = "UPDATE SuaChua SET maXe=?, moTaSuaChua=?, ngaySuaChua=?, maVatTu=?, soLuongSuDung=?, maKyThuatVien=?, chiPhi=? WHERE maSuaChua=?";
        try {
            JdbcHelper.executeUpdate(query, suaChua.getMaXe(), suaChua.getMoTaSuaChua(), suaChua.getNgaySuaChua(),
                    suaChua.getMaVatTu(), suaChua.getSoLuongSuDung(), suaChua.getMaKyThuatVien(), suaChua.getChiPhi(), suaChua.getMaSuaChua());
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(int maSuaChua) {
        String query = "DELETE FROM SuaChua WHERE maSuaChua=?";
        try {
            JdbcHelper.executeUpdate(query, maSuaChua);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
     public boolean isSuaChuaExists(int maSuaChua) {
        try {
            String sql = "SELECT COUNT(*) FROM SuaChua WHERE MaSuaChua = ?";
            ResultSet resultSet = JdbcHelper.executeQuery(sql, maSuaChua);
            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private SuaChua mapResultSetToSuaChua(ResultSet rs) throws SQLException {
        SuaChua suaChua = new SuaChua();
        suaChua.setMaSuaChua(rs.getInt("maSuaChua"));
        suaChua.setMaXe(rs.getInt("maXe"));
        suaChua.setMoTaSuaChua(rs.getString("moTaSuaChua"));
        suaChua.setNgaySuaChua(rs.getDate("ngaySuaChua"));
        suaChua.setMaVatTu(rs.getInt("maVatTu"));
        suaChua.setSoLuongSuDung(rs.getInt("soLuongSuDung"));
        suaChua.setMaKyThuatVien(rs.getInt("maKyThuatVien"));
        suaChua.setChiPhi(rs.getBigDecimal("chiPhi"));
        return suaChua;
    }
}
