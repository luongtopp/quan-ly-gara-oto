/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.com.organization.model;

/**
 *
 * @author luongtopp
 */
public class NguoiDung {
    private int maNguoiDung;
    private String tenDangNhap;
    private String matKhau;
    private String vaiTro;
    private String tenNguoiDung;
    private String email;
    private String soDienThoai;

    public NguoiDung(int maNguoiDung, String tenDangNhap, String matKhau, String vaiTro, String tenNguoiDung, String email, String soDienThoai) {
        this.maNguoiDung = maNguoiDung;
        this.tenDangNhap = tenDangNhap;
        this.matKhau = matKhau;
        this.vaiTro = vaiTro;
        this.tenNguoiDung = tenNguoiDung;
        this.email = email;
        this.soDienThoai = soDienThoai;
    }

    public NguoiDung() {
    }

    public NguoiDung(String tenDangNhap, String matKhau, String vaiTro, String tenNguoiDung, String email, String soDienThoai) {
        this.tenDangNhap = tenDangNhap;
        this.matKhau = matKhau;
        this.vaiTro = vaiTro;
        this.tenNguoiDung = tenNguoiDung;
        this.email = email;
        this.soDienThoai = soDienThoai;
    }

    public int getMaNguoiDung() {
        return maNguoiDung;
    }

    public void setMaNguoiDung(int maNguoiDung) {
        this.maNguoiDung = maNguoiDung;
    }

    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getVaiTro() {
        return vaiTro;
    }

    public void setVaiTro(String vaiTro) {
        this.vaiTro = vaiTro;
    }

    public String getTenNguoiDung() {
        return tenNguoiDung;
    }

    public void setTenNguoiDung(String tenNguoiDung) {
        this.tenNguoiDung = tenNguoiDung;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }
    

}
