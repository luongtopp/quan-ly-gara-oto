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
import src.com.organization.model.BaoCaoKinhDoanh;
import src.com.organization.model.NguoiDung;

/**
 *
 * @author luongtopp
 */
public class BaoCaoKinhDoanhDAO {

    public List<BaoCaoKinhDoanh> getAll() {
        List<BaoCaoKinhDoanh> baoCaoKinhDoanhList = new ArrayList<>();
        String query = "SELECT \n"
                + "    Xe.ChuSoHuu AS TenKhachHang, \n"
                + "    SuaChua.MoTaSuaChua AS DichVuSuaXe, \n"
                + "    SuaChua.NgaySuaChua, \n"
                + "    SuaChua.ChiPhi, \n"
                + "    SuaChua.SoLuongSuDung\n"
                + "FROM \n"
                + "    Xe\n"
                + "JOIN \n"
                + "    SuaChua ON Xe.MaXe = SuaChua.MaXe";
        try {
            ResultSet rs = JdbcHelper.executeQuery(query);
            while (rs.next()) {
                BaoCaoKinhDoanh baoCaoKinhDoanh = mapResultSetToSuaChuaXe(rs);
                baoCaoKinhDoanhList.add(baoCaoKinhDoanh);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return baoCaoKinhDoanhList;
    }

    public List<BaoCaoKinhDoanh> timKiemKhachHang(String tenKhachHang) {
        List<BaoCaoKinhDoanh> baoCaoKinhDoanhList = new ArrayList<>();
        String query = "SELECT Xe.ChuSoHuu AS TenKhachHang, "
                + "SuaChua.MoTaSuaChua AS DichVuSuaXe, "
                + "SuaChua.NgaySuaChua, "
                + "SuaChua.ChiPhi, "
                + "SuaChua.SoLuongSuDung "
                + "FROM Xe "
                + "JOIN SuaChua ON Xe.MaXe = SuaChua.MaXe "
                + "WHERE Xe.ChuSoHuu LIKE ? OR Xe.BienSo LIKE ?";
        try {
            ResultSet rs = JdbcHelper.executeQuery(query, tenKhachHang, tenKhachHang);
            while (rs.next()) {
                BaoCaoKinhDoanh baoCaoKinhDoanh = mapResultSetToSuaChuaXe(rs);
                baoCaoKinhDoanhList.add(baoCaoKinhDoanh);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return baoCaoKinhDoanhList;
    }

    private BaoCaoKinhDoanh mapResultSetToSuaChuaXe(ResultSet rs) throws SQLException {
        BaoCaoKinhDoanh baoCaoKinhDoanh = new BaoCaoKinhDoanh();
        baoCaoKinhDoanh.setTenNguoiDung(rs.getString("TenKhachHang"));
        baoCaoKinhDoanh.setMoTaSuaChua(rs.getString("DichVuSuaXe"));
        baoCaoKinhDoanh.setNgaySuaChua(rs.getString("NgaySuaChua"));
        baoCaoKinhDoanh.setChiPhi(rs.getDouble("ChiPhi"));
        baoCaoKinhDoanh.setSoLuongSuDung(rs.getInt("SoLuongSuDung"));
        return baoCaoKinhDoanh;
    }
}
