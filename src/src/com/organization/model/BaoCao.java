/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.com.organization.model;

/**
 *
 * @author luongtopp
 */
import java.sql.Date;

public class BaoCao {
    private int MaBaoCao;
    private Date NgayLapBaoCao;
    private String NoiDung;
    private int MaGiamDoc;

    // Constructors, getters, and setters

    public BaoCao(int MaBaoCao, Date NgayLapBaoCao, String NoiDung, int MaGiamDoc) {
        this.MaBaoCao = MaBaoCao;
        this.NgayLapBaoCao = NgayLapBaoCao;
        this.NoiDung = NoiDung;
        this.MaGiamDoc = MaGiamDoc;
    }

    public BaoCao(Date NgayLapBaoCao, String NoiDung, int MaGiamDoc) {
        this.NgayLapBaoCao = NgayLapBaoCao;
        this.NoiDung = NoiDung;
        this.MaGiamDoc = MaGiamDoc;
    }

    public BaoCao() {
    }

    public int getMaBaoCao() {
        return MaBaoCao;
    }

    public void setMaBaoCao(int MaBaoCao) {
        this.MaBaoCao = MaBaoCao;
    }

    public Date getNgayLapBaoCao() {
        return NgayLapBaoCao;
    }

    public void setNgayLapBaoCao(Date NgayLapBaoCao) {
        this.NgayLapBaoCao = NgayLapBaoCao;
    }

    public String getNoiDung() {
        return NoiDung;
    }

    public void setNoiDung(String NoiDung) {
        this.NoiDung = NoiDung;
    }

    public int getMaGiamDoc() {
        return MaGiamDoc;
    }

    public void setMaGiamDoc(int MaGiamDoc) {
        this.MaGiamDoc = MaGiamDoc;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.MaBaoCao;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final BaoCao other = (BaoCao) obj;
        return this.MaBaoCao == other.MaBaoCao;
    }
    
    
}