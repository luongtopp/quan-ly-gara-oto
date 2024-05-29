/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.com.organization.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import jdcbhepler.JdbcHelper;
import src.com.organization.model.KeToan;

public class KeToanDAO {

    public List<KeToan> getAll() {
        List<KeToan> keToanList = new ArrayList<>();
        String query = "SELECT * FROM KeToan";
        try {
            ResultSet rs = JdbcHelper.executeQuery(query);
            while (rs.next()) {
                KeToan keToan = mapResultSetToKeToan(rs);
                keToanList.add(keToan);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return keToanList;
    }

    public List<KeToan> search(int maHoaDon) {
        List<KeToan> keToanList = new ArrayList<>();
        String query = "SELECT * FROM KeToan WHERE MaHoaDon = ?";
        try {
            ResultSet rs = JdbcHelper.executeQuery(query, maHoaDon);
            while (rs.next()) {
                KeToan keToan = mapResultSetToKeToan(rs);
                keToanList.add(keToan);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return keToanList;
    }

    public boolean insert(KeToan keToan) {
        String query = "INSERT INTO KeToan (MaSuaChua, NgayLapHoaDon, TongTien, TrangThaiThanhToan) VALUES (?, ?, ?, ?)";
        try {
            JdbcHelper.executeUpdate(query, keToan.getMaSuaChua(), keToan.getNgayLapHoaDon(), keToan.getTongTien(), keToan.getTrangThaiThanhToan());
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(KeToan keToan) {
        String query = "UPDATE KeToan SET MaSuaChua=?, NgayLapHoaDon=?, TongTien=?, TrangThaiThanhToan=? WHERE MaHoaDon=?";
        try {
            JdbcHelper.executeUpdate(query, keToan.getMaSuaChua(), keToan.getNgayLapHoaDon(), keToan.getTongTien(), keToan.getTrangThaiThanhToan(), keToan.getMaHoaDon());
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(int maHoaDon) {
        String query = "DELETE FROM KeToan WHERE MaHoaDon=?";
        try {
            JdbcHelper.executeUpdate(query, maHoaDon);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private KeToan mapResultSetToKeToan(ResultSet rs) throws SQLException {
        KeToan keToan = new KeToan();
        keToan.setMaHoaDon(rs.getInt("MaHoaDon"));
        keToan.setMaSuaChua(rs.getInt("MaSuaChua"));
        keToan.setNgayLapHoaDon(rs.getDate("NgayLapHoaDon"));
        keToan.setTongTien(rs.getDouble("TongTien"));
        keToan.setTrangThaiThanhToan(rs.getString("TrangThaiThanhToan"));
        return keToan;
    }
    
}

