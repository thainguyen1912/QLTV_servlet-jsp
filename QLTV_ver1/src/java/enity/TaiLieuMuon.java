/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enity;

/**
 *
 * @author thain
 */
public class TaiLieuMuon {
    private String maTaiLieu;
    private String tenTaiLieu;
    private int soLuong;
    private double giaTien;

    public double getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(double giaTien) {
        this.giaTien = giaTien;
    }

    public TaiLieuMuon(String maTaiLieu, String tenTaiLieu, int soLuong, double giaTien) {
        this.maTaiLieu = maTaiLieu;
        this.tenTaiLieu = tenTaiLieu;
        this.soLuong = soLuong;
        this.giaTien = giaTien;
    }

    

    public String getMaTaiLieu() {
        return maTaiLieu;
    }

    public void setMaTaiLieu(String maTaiLieu) {
        this.maTaiLieu = maTaiLieu;
    }

    public String getTenTaiLieu() {
        return tenTaiLieu;
    }

    public void setTenTaiLieu(String tenTaiLieu) {
        this.tenTaiLieu = tenTaiLieu;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    @Override
    public String toString() {
        return "TaiLieuMuon{" + "maTaiLieu=" + maTaiLieu + ", tenTaiLieu=" + tenTaiLieu + ", soLuong=" + soLuong + '}';
    }

    
    
}
