/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.com.organization.model;

/**
 *
 * @author luongtopp
 */
public class BaoCaoKinhDoanh {

    private String tenNguoiDung;
    private String moTaSuaChua;
    private String ngaySuaChua;
    private double chiPhi;
    private int soLuongSuDung;

    // Constructor
    public BaoCaoKinhDoanh(String tenNguoiDung, String moTaSuaChua, String ngaySuaChua, double chiPhi, int soLuongSuDung) {
        this.tenNguoiDung = tenNguoiDung;
        this.moTaSuaChua = moTaSuaChua;
        this.ngaySuaChua = ngaySuaChua;
        this.chiPhi = chiPhi;
        this.soLuongSuDung = soLuongSuDung;
    }

    public BaoCaoKinhDoanh() {
    }

    // Getters and setters
    public String getTenNguoiDung() {
        return tenNguoiDung;
    }

    public void setTenNguoiDung(String tenNguoiDung) {
        this.tenNguoiDung = tenNguoiDung;
    }

    public String getMoTaSuaChua() {
        return moTaSuaChua;
    }

    public void setMoTaSuaChua(String moTaSuaChua) {
        this.moTaSuaChua = moTaSuaChua;
    }

    public String getNgaySuaChua() {
        return ngaySuaChua;
    }

    public void setNgaySuaChua(String ngaySuaChua) {
        this.ngaySuaChua = ngaySuaChua;
    }

    public double getChiPhi() {
        return chiPhi;
    }

    public void setChiPhi(double chiPhi) {
        this.chiPhi = chiPhi;
    }

    public int getSoLuongSuDung() {
        return soLuongSuDung;
    }

    public void setSoLuongSuDung(int soLuongSuDung) {
        this.soLuongSuDung = soLuongSuDung;
    }
}
