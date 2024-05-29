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
import src.com.organization.model.NguoiDung; // Đảm bảo import đúng lớp NguoiDung từ gói phù hợp với ứng dụng của bạn

public class NguoiDungDAO {

    public List<NguoiDung> getAll() {
        List<NguoiDung> nguoiDungList = new ArrayList<>();
        String query = "SELECT * FROM NguoiDung";
        try {
            ResultSet rs = JdbcHelper.executeQuery(query);
            while (rs.next()) {
                NguoiDung nguoiDung = mapResultSetToNguoiDung(rs);
                nguoiDungList.add(nguoiDung);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nguoiDungList;
    }

    public NguoiDung getByUsername(String tenDangNhap) {
        String query = "SELECT * FROM NguoiDung WHERE TenDangNhap=?";
        try {
            ResultSet rs = JdbcHelper.executeQuery(query, tenDangNhap);
            if (rs.next()) {
                return mapResultSetToNguoiDung(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean insert(NguoiDung nguoiDung) {
        String query = "INSERT INTO NguoiDung (TenDangNhap, MatKhau, VaiTro, TenNguoiDung, Email, SoDienThoai) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            JdbcHelper.executeUpdate(query, nguoiDung.getTenDangNhap(), nguoiDung.getMatKhau(), nguoiDung.getVaiTro(),
                    nguoiDung.getTenNguoiDung(), nguoiDung.getEmail(), nguoiDung.getSoDienThoai());
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(NguoiDung nguoiDung) {
        String query = "UPDATE NguoiDung SET MatKhau=?, VaiTro=?, TenNguoiDung=?, Email=?, SoDienThoai=? WHERE MaNguoiDung=?";
        try {
            JdbcHelper.executeUpdate(query, nguoiDung.getMatKhau(), nguoiDung.getVaiTro(),
                    nguoiDung.getTenNguoiDung(), nguoiDung.getEmail(), nguoiDung.getSoDienThoai(), nguoiDung.getMaNguoiDung());
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(int maNguoiDung) {
        String query = "DELETE FROM NguoiDung WHERE MaNguoiDung=?";
        try {
            JdbcHelper.executeUpdate(query, maNguoiDung);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public NguoiDung authenticate(String tenDangNhap, String matKhau) {
        String query = "SELECT * FROM NguoiDung WHERE TenDangNhap=? AND MatKhau=?";
        try {
            ResultSet rs = JdbcHelper.executeQuery(query, tenDangNhap, matKhau);
            if (rs.next()) {
                return mapResultSetToNguoiDung(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean isTenDangNhapExists(String tenDangNhap) {
        try {
            String sql = "SELECT COUNT(*) FROM NguoiDung WHERE TenDangNhap = ?";
            ResultSet resultSet = JdbcHelper.executeQuery(sql, tenDangNhap);
            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private NguoiDung mapResultSetToNguoiDung(ResultSet rs) throws SQLException {
        NguoiDung nguoiDung = new NguoiDung();
        nguoiDung.setMaNguoiDung(rs.getInt("maNguoiDung"));
        nguoiDung.setTenDangNhap(rs.getString("tenDangNhap"));
        nguoiDung.setMatKhau(rs.getString("matKhau"));
        nguoiDung.setVaiTro(rs.getString("vaiTro"));
        nguoiDung.setTenNguoiDung(rs.getString("tenNguoiDung"));
        nguoiDung.setEmail(rs.getString("email"));
        nguoiDung.setSoDienThoai(rs.getString("soDienThoai"));
        return nguoiDung;
    }
}
