/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.com.organization.model;

import java.util.Date;

/**
 *
 * @author luongtopp
 */

public class KeToan {
    private int maHoaDon;
    private int maSuaChua;
    private Date ngayLapHoaDon;
    private double tongTien;
    private String trangThaiThanhToan;

    // Constructors, getters, and setters

    public KeToan(int maHoaDon, int maSuaChua, Date ngayLapHoaDon, double tongTien, String trangThaiThanhToan) {
        this.maHoaDon = maHoaDon;
        this.maSuaChua = maSuaChua;
        this.ngayLapHoaDon = ngayLapHoaDon;
        this.tongTien = tongTien;
        this.trangThaiThanhToan = trangThaiThanhToan;
    }

    public KeToan(int maSuaChua, Date ngayLapHoaDon, double tongTien, String trangThaiThanhToan) {
        this.maSuaChua = maSuaChua;
        this.ngayLapHoaDon = ngayLapHoaDon;
        this.tongTien = tongTien;
        this.trangThaiThanhToan = trangThaiThanhToan;
    }

    public KeToan() {
    }

    public int getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(int maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public int getMaSuaChua() {
        return maSuaChua;
    }

    public void setMaSuaChua(int maSuaChua) {
        this.maSuaChua = maSuaChua;
    }

    public Date getNgayLapHoaDon() {
        return ngayLapHoaDon;
    }

    public void setNgayLapHoaDon(Date ngayLapHoaDon) {
        this.ngayLapHoaDon = ngayLapHoaDon;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public String getTrangThaiThanhToan() {
        return trangThaiThanhToan;
    }

    public void setTrangThaiThanhToan(String trangThaiThanhToan) {
        this.trangThaiThanhToan = trangThaiThanhToan;
    }

   
  
}