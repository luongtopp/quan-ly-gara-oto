/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.com.organization.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author luongtopp
 */
public class VatTu {

    private int maVatTu;
    private String tenVatTu;
    private int soLuong;
    private BigDecimal donGia;
    private String nhaCungCap;
    private Date ngayNhap;
    private String trangThai;

    // Constructors, getters, and setters
    public VatTu(int maVatTu, String tenVatTu, int soLuong, BigDecimal donGia, String nhaCungCap, Date ngayNhap, String trangThai) {
        this.maVatTu = maVatTu;
        this.tenVatTu = tenVatTu;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.nhaCungCap = nhaCungCap;
        this.ngayNhap = ngayNhap;
        this.trangThai = trangThai;
    }

    public VatTu() {
    }

    public VatTu(String tenVatTu, int soLuong, BigDecimal donGia, String nhaCungCap, Date ngayNhap, String trangThai) {
        this.tenVatTu = tenVatTu;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.nhaCungCap = nhaCungCap;
        this.ngayNhap = ngayNhap;
        this.trangThai = trangThai;
    }

    public int getMaVatTu() {
        return maVatTu;
    }

    public void setMaVatTu(int maVatTu) {
        this.maVatTu = maVatTu;
    }

    public String getTenVatTu() {
        return tenVatTu;
    }

    public void setTenVatTu(String tenVatTu) {
        this.tenVatTu = tenVatTu;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public BigDecimal getDonGia() {
        return donGia;
    }

    public void setDonGia(BigDecimal donGia) {
        this.donGia = donGia;
    }

    public String getNhaCungCap() {
        return nhaCungCap;
    }

    public void setNhaCungCap(String nhaCungCap) {
        this.nhaCungCap = nhaCungCap;
    }

    public Date getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(Date ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

}
