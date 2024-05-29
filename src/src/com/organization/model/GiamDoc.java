/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.com.organization.model;

/**
 *
 * @author luongtopp
 */
public class GiamDoc {
    private int maGiamDoc;
    private String tenGiamDoc;
    private String email;
    private String soDienThoai;

    // Constructors, getters, and setters

    public GiamDoc(int maGiamDoc, String tenGiamDoc, String email, String soDienThoai) {
        this.maGiamDoc = maGiamDoc;
        this.tenGiamDoc = tenGiamDoc;
        this.email = email;
        this.soDienThoai = soDienThoai;
    }

    public GiamDoc(String tenGiamDoc, String email, String soDienThoai) {
        this.tenGiamDoc = tenGiamDoc;
        this.email = email;
        this.soDienThoai = soDienThoai;
    }

    public GiamDoc() {
    }

    public int getMaGiamDoc() {
        return maGiamDoc;
    }

    public void setMaGiamDoc(int maGiamDoc) {
        this.maGiamDoc = maGiamDoc;
    }

    public String getTenGiamDoc() {
        return tenGiamDoc;
    }

    public void setTenGiamDoc(String tenGiamDoc) {
        this.tenGiamDoc = tenGiamDoc;
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
