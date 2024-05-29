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
public class KyThuatVien {

    private int maKyThuatVien;
    private String tenKyThuatVien;
    private String chuyenMon;
    private Date ngayThue;
    private String soDienThoai;

    public KyThuatVien(int maKyThuatVien, String tenKyThuatVien, String chuyenMon, Date ngayThue, String soDienThoai) {
        this.maKyThuatVien = maKyThuatVien;
        this.tenKyThuatVien = tenKyThuatVien;
        this.chuyenMon = chuyenMon;
        this.ngayThue = ngayThue;
        this.soDienThoai = soDienThoai;
    }

    public KyThuatVien() {
    }

    public KyThuatVien(String tenKyThuatVien, String chuyenMon, Date ngayThue, String soDienThoai) {
        this.tenKyThuatVien = tenKyThuatVien;
        this.chuyenMon = chuyenMon;
        this.ngayThue = ngayThue;
        this.soDienThoai = soDienThoai;
    }

    public int getMaKyThuatVien() {
        return maKyThuatVien;
    }

    public void setMaKyThuatVien(int maKyThuatVien) {
        this.maKyThuatVien = maKyThuatVien;
    }

    public String getTenKyThuatVien() {
        return tenKyThuatVien;
    }

    public void setTenKyThuatVien(String tenKyThuatVien) {
        this.tenKyThuatVien = tenKyThuatVien;
    }

    public String getChuyenMon() {
        return chuyenMon;
    }

    public void setChuyenMon(String chuyenMon) {
        this.chuyenMon = chuyenMon;
    }

    public Date getNgayThue() {
        return ngayThue;
    }

    public void setNgayThue(Date ngayThue) {
        this.ngayThue = ngayThue;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

}
