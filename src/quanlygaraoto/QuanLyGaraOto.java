/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package quanlygaraoto;

import src.com.organization.controller.auth.DangNhapController;
import src.com.organization.dao.NguoiDungDAO;
import src.com.organization.view.auth.DangNhapView;
/**
 *
 * @author luongtopp
 */
public class QuanLyGaraOto {

    public static void main(String args[]) {
        DangNhapView dangNhapView = new DangNhapView();        
        NguoiDungDAO nguoiDungDao = new NguoiDungDAO();
        DangNhapController dangNhapController = new DangNhapController(dangNhapView, nguoiDungDao);
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                dangNhapView.setVisible(true);
            }
        });
    }

}
