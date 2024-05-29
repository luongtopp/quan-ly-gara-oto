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
import src.com.organization.model.NguoiDung;

/**
 *
 * @author luongtopp
 */
public class ThongKeDAO {
    public List<NguoiDung> getAll() {
        List<NguoiDung> nguoiDungList = new ArrayList<>();
        String query = "SELECT * FROM NguoiDung";
        try {
            ResultSet rs = JdbcHelper.executeQuery(query);
            while (rs.next()) {
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nguoiDungList;
    }
    
}
