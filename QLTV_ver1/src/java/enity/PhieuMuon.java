/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enity;

import java.sql.Date;

/**
 *
 * @author thain
 */
public class PhieuMuon {
    private String maPhieuMuon, maDocGia;
    private Date ngayMuon;
    private String maNhanVien;

    public PhieuMuon(String maPhieuMuon, String maDocGia, Date ngayMuon, String maNhanVien) {
        this.maPhieuMuon = maPhieuMuon;
        this.maDocGia = maDocGia;
        this.ngayMuon = ngayMuon;
        this.maNhanVien = maNhanVien;
    }

    public String getMaPhieuMuon() {
        return maPhieuMuon;
    }

    public void setMaPhieuMuon(String maPhieuMuon) {
        this.maPhieuMuon = maPhieuMuon;
    }

    public String getMaDocGia() {
        return maDocGia;
    }

    public void setMaDocGia(String maDocGia) {
        this.maDocGia = maDocGia;
    }

    public Date getNgayMuon() {
        return ngayMuon;
    }

    public void setNgayMuon(Date ngayMuon) {
        this.ngayMuon = ngayMuon;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }
    
}
