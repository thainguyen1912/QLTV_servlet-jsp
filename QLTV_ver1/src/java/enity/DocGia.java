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
public class DocGia {
    private String maDocGia, hoTen; 
    private short gioiTinh;
    private Date ngaySinh;
    private String doiTuong;
    private Date ngayCap, ngayHetHan;
    private String MatKhau;
    private int soLuongTaiLieu, soLuongMoiTaiLieu, soNgayMuon;
    private double soDuTaiKhoan;

    public DocGia(String maDocGia, String hoTen, short gioiTinh, Date ngaySinh, String doiTuong, Date ngayCap, Date ngayHetHan, String MatKhau, int soLuongTaiLieu, int soLuongMoiTaiLieu, int soNgayMuon, double soDuTaiKhoan) {
        this.maDocGia = maDocGia;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.doiTuong = doiTuong;
        this.ngayCap = ngayCap;
        this.ngayHetHan = ngayHetHan;
        this.MatKhau = MatKhau;
        this.soLuongTaiLieu = soLuongTaiLieu;
        this.soLuongMoiTaiLieu = soLuongMoiTaiLieu;
        this.soNgayMuon = soNgayMuon;
        this.soDuTaiKhoan = soDuTaiKhoan;
    }

    public DocGia(String maDocGia, String hoTen, short gioiTinh, Date ngaySinh, String doiTuong, Date ngayCap, Date ngayHetHan, int soLuongTaiLieu, int soLuongMoiTaiLieu, int soNgayMuon) {
        this.maDocGia = maDocGia;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.doiTuong = doiTuong;
        this.ngayCap = ngayCap;
        this.ngayHetHan = ngayHetHan;
        this.soLuongTaiLieu = soLuongTaiLieu;
        this.soLuongMoiTaiLieu = soLuongMoiTaiLieu;
        this.soNgayMuon = soNgayMuon;
    }

    
    
    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }

    

    public double getSoDuTaiKhoan() {
        return soDuTaiKhoan;
    }

    public void setSoDuTaiKhoan(double soDuTaiKhoan) {
        this.soDuTaiKhoan = soDuTaiKhoan;
    }

    

   

    

    public int getSoLuongTaiLieu() {
        return soLuongTaiLieu;
    }

    public void setSoLuongTaiLieu(int soLuongTaiLieu) {
        this.soLuongTaiLieu = soLuongTaiLieu;
    }

    public int getSoLuongMoiTaiLieu() {
        return soLuongMoiTaiLieu;
    }

    public void setSoLuongMoiTaiLieu(int soLuongMoiTaiLieu) {
        this.soLuongMoiTaiLieu = soLuongMoiTaiLieu;
    }

    public int getSoNgayMuon() {
        return soNgayMuon;
    }

    public void setSoNgayMuon(int soNgayMuon) {
        this.soNgayMuon = soNgayMuon;
    }

    

    public String getMaDocGia() {
        return maDocGia;
    }

    public void setMaDocGia(String maDocGia) {
        this.maDocGia = maDocGia;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public short getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(short gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDoiTuong() {
        return doiTuong;
    }

    public void setDoiTuong(String doiTuong) {
        this.doiTuong = doiTuong;
    }

    public Date getNgayCap() {
        return ngayCap;
    }

    public void setNgayCap(Date ngayCap) {
        this.ngayCap = ngayCap;
    }

    public Date getNgayHetHan() {
        return ngayHetHan;
    }

    public void setNgayHetHan(Date ngayHetHan) {
        this.ngayHetHan = ngayHetHan;
    }
    
}
