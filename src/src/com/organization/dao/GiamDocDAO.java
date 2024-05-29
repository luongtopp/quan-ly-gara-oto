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
import src.com.organization.model.GiamDoc;

public class GiamDocDAO {

    public List<GiamDoc> getAll() {
        List<GiamDoc> giamDocList = new ArrayList<>();
        String query = "SELECT * FROM GiamDoc";
        try {
            ResultSet rs = JdbcHelper.executeQuery(query);
            while (rs.next()) {
                GiamDoc giamDoc = mapResultSetToGiamDoc(rs);
                giamDocList.add(giamDoc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return giamDocList;
    }

    public List<GiamDoc> search(int maGiamDoc) {
        List<GiamDoc> giamDocList = new ArrayList<>();
        String query = "SELECT * FROM GiamDoc WHERE MaGiamDoc = ?";
        try {
            ResultSet rs = JdbcHelper.executeQuery(query, maGiamDoc);
            while (rs.next()) {
                GiamDoc giamDoc = mapResultSetToGiamDoc(rs);
                giamDocList.add(giamDoc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return giamDocList;
    }

    public boolean insert(GiamDoc giamDoc) {
        String query = "INSERT INTO GiamDoc (TenGiamDoc, Email, SoDienThoai) VALUES (?, ?, ?)";
        try {
            JdbcHelper.executeUpdate(query, giamDoc.getTenGiamDoc(), giamDoc.getEmail(), giamDoc.getSoDienThoai());
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(GiamDoc giamDoc) {
        String query = "UPDATE GiamDoc SET TenGiamDoc=?, Email=?, SoDienThoai=? WHERE MaGiamDoc=?";
        try {
            JdbcHelper.executeUpdate(query, giamDoc.getTenGiamDoc(), giamDoc.getEmail(), giamDoc.getSoDienThoai(), giamDoc.getMaGiamDoc());
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(int maGiamDoc) {
        String query = "DELETE FROM GiamDoc WHERE MaGiamDoc=?";
        try {
            JdbcHelper.executeUpdate(query, maGiamDoc);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private GiamDoc mapResultSetToGiamDoc(ResultSet rs) throws SQLException {
        GiamDoc giamDoc = new GiamDoc();
        giamDoc.setMaGiamDoc(rs.getInt("MaGiamDoc"));
        giamDoc.setTenGiamDoc(rs.getString("TenGiamDoc"));
        giamDoc.setEmail(rs.getString("Email"));
        giamDoc.setSoDienThoai(rs.getString("SoDienThoai"));
        return giamDoc;
    }
    
    public boolean isDependentDataExist(int maGiamDoc) {
    try {
        String checkQuery = "SELECT COUNT(*) FROM BaoCao WHERE MaGiamDoc = ?";
        ResultSet rs = JdbcHelper.executeQuery(checkQuery, maGiamDoc);
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

}
