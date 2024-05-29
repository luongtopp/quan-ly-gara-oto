/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.com.organization.model;

/**
 *
 * @author luongtopp
 */
public class Xe {
    private int maXe;
    private String bienSo;
    private String chuSoHuu;
    private String model;
    private int namSanXuat;
    private String mauSac;

    public Xe(int maXe, String bienSo, String chuSoHuu, String model, int namSanXuat, String mauSac) {
        this.maXe = maXe;
        this.bienSo = bienSo;
        this.chuSoHuu = chuSoHuu;
        this.model = model;
        this.namSanXuat = namSanXuat;
        this.mauSac = mauSac;
    }

    public Xe() {
    }

    public Xe(String bienSo, String chuSoHuu, String model, int namSanXuat, String mauSac) {
        this.bienSo = bienSo;
        this.chuSoHuu = chuSoHuu;
        this.model = model;
        this.namSanXuat = namSanXuat;
        this.mauSac = mauSac;
    }

    public int getMaXe() {
        return maXe;
    }

    public void setMaXe(int maXe) {
        this.maXe = maXe;
    }

    public String getBienSo() {
        return bienSo;
    }

    public void setBienSo(String bienSo) {
        this.bienSo = bienSo;
    }

    public String getChuSoHuu() {
        return chuSoHuu;
    }

    public void setChuSoHuu(String chuSoHuu) {
        this.chuSoHuu = chuSoHuu;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getNamSanXuat() {
        return namSanXuat;
    }

    public void setNamSanXuat(int namSanXuat) {
        this.namSanXuat = namSanXuat;
    }

    public String getMauSac() {
        return mauSac;
    }

    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }
    
}
