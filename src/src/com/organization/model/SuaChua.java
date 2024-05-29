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
public class SuaChua {

    private int maSuaChua;
    private int maXe;
    private String moTaSuaChua;
    private Date ngaySuaChua;
    private int maVatTu;
    private int soLuongSuDung;
    private int maKyThuatVien;
    private BigDecimal chiPhi;

    public SuaChua(int maSuaChua, int maXe, String moTaSuaChua, Date ngaySuaChua, int maVatTu, int soLuongSuDung, int maKyThuatVien, BigDecimal chiPhi) {
        this.maSuaChua = maSuaChua;
        this.maXe = maXe;
        this.moTaSuaChua = moTaSuaChua;
        this.ngaySuaChua = ngaySuaChua;
        this.maVatTu = maVatTu;
        this.soLuongSuDung = soLuongSuDung;
        this.maKyThuatVien = maKyThuatVien;
        this.chiPhi = chiPhi;
    }

    public SuaChua() {
    }

    public SuaChua(int maXe, String moTaSuaChua, Date ngaySuaChua, int maVatTu, int soLuongSuDung, int maKyThuatVien, BigDecimal chiPhi) {
        this.maXe = maXe;
        this.moTaSuaChua = moTaSuaChua;
        this.ngaySuaChua = ngaySuaChua;
        this.maVatTu = maVatTu;
        this.soLuongSuDung = soLuongSuDung;
        this.maKyThuatVien = maKyThuatVien;
        this.chiPhi = chiPhi;
    }

    public int getMaSuaChua() {
        return maSuaChua;
    }

    public void setMaSuaChua(int maSuaChua) {
        this.maSuaChua = maSuaChua;
    }

    public int getMaXe() {
        return maXe;
    }

    public void setMaXe(int maXe) {
        this.maXe = maXe;
    }

    public String getMoTaSuaChua() {
        return moTaSuaChua;
    }

    public void setMoTaSuaChua(String moTaSuaChua) {
        this.moTaSuaChua = moTaSuaChua;
    }

    public Date getNgaySuaChua() {
        return ngaySuaChua;
    }

    public void setNgaySuaChua(Date ngaySuaChua) {
        this.ngaySuaChua = ngaySuaChua;
    }

    public int getMaVatTu() {
        return maVatTu;
    }

    public void setMaVatTu(int maVatTu) {
        this.maVatTu = maVatTu;
    }

    public int getSoLuongSuDung() {
        return soLuongSuDung;
    }

    public void setSoLuongSuDung(int soLuongSuDung) {
        this.soLuongSuDung = soLuongSuDung;
    }

    public int getMaKyThuatVien() {
        return maKyThuatVien;
    }

    public void setMaKyThuatVien(int maKyThuatVien) {
        this.maKyThuatVien = maKyThuatVien;
    }

    public BigDecimal getChiPhi() {
        return chiPhi;
    }

    public void setChiPhi(BigDecimal chiPhi) {
        this.chiPhi = chiPhi;
    }

}
