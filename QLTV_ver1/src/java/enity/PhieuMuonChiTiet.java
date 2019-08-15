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
public class PhieuMuonChiTiet {
    private String maPhieuMuon, maTaiLieu;
    private int soLuongMuon;
    private Date ngayTra;
    private int mat;

    public int getMat() {
        return mat;
    }

    public void setMat(int mat) {
        this.mat = mat;
    }

    public PhieuMuonChiTiet(String maPhieuMuon, String maTaiLieu, int soLuongMuon, int mat) {
        this.maPhieuMuon = maPhieuMuon;
        this.maTaiLieu = maTaiLieu;
        this.soLuongMuon = soLuongMuon;
        this.mat = mat;
    }

    

    public String getMaPhieuMuon() {
        return maPhieuMuon;
    }

    public void setMaPhieuMuon(String maPhieuMuon) {
        this.maPhieuMuon = maPhieuMuon;
    }

    public String getMaTaiLieu() {
        return maTaiLieu;
    }

    public void setMaTaiLieu(String maTaiLieu) {
        this.maTaiLieu = maTaiLieu;
    }

    public int getSoLuongMuon() {
        return soLuongMuon;
    }

    public void setSoLuongMuon(int soLuongMuon) {
        this.soLuongMuon = soLuongMuon;
    }

    public Date getNgayTra() {
        return ngayTra;
    }

    public void setNgayTra(Date ngayTra) {
        this.ngayTra = ngayTra;
    }
    
    
    
}
