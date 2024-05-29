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
import src.com.organization.model.VatTu;

public class VatTuDAO {
    
    public List<VatTu> getAll() {
        List<VatTu> vatTuList = new ArrayList<>();
        String query = "SELECT * FROM VatTu";
        try {
            ResultSet rs = JdbcHelper.executeQuery(query);
            while (rs.next()) {
                VatTu vatTu = mapResultSetToVatTu(rs);
                vatTuList.add(vatTu);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vatTuList;
    }

    public List<VatTu> search(String keyword) {
        List<VatTu> vatTuList = new ArrayList<>();
        String query = "SELECT * FROM VatTu WHERE TenVatTu LIKE ?";
        try {
            ResultSet rs = JdbcHelper.executeQuery(query, "%" + keyword + "%");
            while (rs.next()) {
                VatTu vatTu = mapResultSetToVatTu(rs);
                vatTuList.add(vatTu);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vatTuList;
    }

    public boolean insert(VatTu vatTu) {
        String query = "INSERT INTO VatTu (TenVatTu, SoLuong, DonGia, NhaCungCap, NgayNhap, TrangThai) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            JdbcHelper.executeUpdate(query, vatTu.getTenVatTu(), vatTu.getSoLuong(), vatTu.getDonGia(),
                    vatTu.getNhaCungCap(), vatTu.getNgayNhap(), vatTu.getTrangThai());
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(VatTu vatTu) {
        String query = "UPDATE VatTu SET TenVatTu=?, SoLuong=?, DonGia=?, NhaCungCap=?, NgayNhap=?, TrangThai=? WHERE MaVatTu=?";
        try {
            JdbcHelper.executeUpdate(query, vatTu.getTenVatTu(), vatTu.getSoLuong(), vatTu.getDonGia(),
                    vatTu.getNhaCungCap(), vatTu.getNgayNhap(), vatTu.getTrangThai(), vatTu.getMaVatTu());
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(int maVatTu) {
        String query = "DELETE FROM VatTu WHERE MaVatTu=?";
        try {
            JdbcHelper.executeUpdate(query, maVatTu);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
     public boolean isVatTuExists(int maVatTu) {
        try {
            String sql = "SELECT COUNT(*) FROM VatTu WHERE MaVatTu = ?";
            ResultSet resultSet = JdbcHelper.executeQuery(sql, maVatTu);
            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private VatTu mapResultSetToVatTu(ResultSet rs) throws SQLException {
        VatTu vatTu = new VatTu();
        vatTu.setMaVatTu(rs.getInt("MaVatTu"));
        vatTu.setTenVatTu(rs.getString("TenVatTu"));
        vatTu.setSoLuong(rs.getInt("SoLuong"));
        vatTu.setDonGia(rs.getBigDecimal("DonGia"));
        vatTu.setNhaCungCap(rs.getString("NhaCungCap"));
        vatTu.setNgayNhap(rs.getDate("NgayNhap"));
        vatTu.setTrangThai(rs.getString("TrangThai"));
        return vatTu;
    }
}
