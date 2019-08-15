/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import enity.DocGia;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author thain
 */
public class DocGia_DAO {
    private db_connection dbcon;
    private Connection conn;
    public DocGia_DAO(db_connection db){
        this.dbcon=db;
        this.conn=db.getConnection();
    }
    public ArrayList<DocGia> getAll(){
        ArrayList<DocGia> list = new ArrayList<>();
        String sql="select * from DocGia";
        try {
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
                String maDocGia = rs.getString("MaDocGia");
                String hoTen = rs.getString("HoTen");
                Short gioiTinh = rs.getShort("GioiTinh");
                Date ngaySinh = rs.getDate("NgaySinh");
                String doiTuong = rs.getString("DoiTuong");
                Date ngayCap = rs.getDate("NgayCap");
                Date ngayHetHan = rs.getDate("NgayHetHan");
                String matKhau = rs.getString("MatKhau");
                int soLuongTaiLieu=rs.getInt("SoLuongTaiLieu");
                int soLuongMoiTaiLieu=rs.getInt("SoLuongMoiTaiLieu");
                int soNgayMuon=rs.getInt("SoNgayMuon");
                double soDuTaiKhoan=rs.getDouble("SoDuTaiKhoan");
                DocGia dg=new DocGia(maDocGia, hoTen, gioiTinh, ngaySinh, doiTuong, ngayCap, ngayHetHan,matKhau, soLuongTaiLieu, soLuongMoiTaiLieu, soNgayMuon, soDuTaiKhoan);
                list.add(dg);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DocGia_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    public int add_DocGia(DocGia dg) {
        int n = 0;
        String sql = "insert into DocGia values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, dg.getMaDocGia());
            pre.setString(2, dg.getHoTen());
            pre.setShort(3, dg.getGioiTinh());
            pre.setDate(4, dg.getNgaySinh());
            pre.setString(5, dg.getDoiTuong());
            pre.setDate(6, dg.getNgayCap());
            pre.setDate(7, dg.getNgayHetHan());
            pre.setString(8, dg.getMatKhau());
            pre.setInt(9, dg.getSoLuongTaiLieu());
            pre.setInt(10, dg.getSoLuongMoiTaiLieu());
            pre.setInt(11, dg.getSoNgayMuon());
            pre.setDouble(12, dg.getSoDuTaiKhoan());
            n = pre.executeUpdate();
        }
        catch (SQLException ex) {
            Logger.getLogger(DocGia_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return n;

    }
    public int update_DocGia(DocGia dg) {
        int n = 0;
        String sql = "update DocGia set HoTen=?, GioiTinh=?, NgaySinh=?,"
                + " DoiTuong=?, NgayCap=?, NgayHetHan=?, MatKhau=?, SoLuongTaiLieu=?, SoLuongMoiTaiLieu=?, SoNgayMuon=?, SoDuTaiKhoan=? where MaDocGia=?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, dg.getHoTen());
            pre.setShort(2, dg.getGioiTinh());
            pre.setDate(3, dg.getNgaySinh());
            pre.setString(4, dg.getDoiTuong());
            pre.setDate(5, dg.getNgayCap());
            pre.setDate(6, dg.getNgayHetHan());
            pre.setString(7, dg.getMatKhau());
            pre.setInt(8, dg.getSoLuongTaiLieu());
            pre.setInt(9, dg.getSoLuongMoiTaiLieu());
            pre.setInt(10, dg.getSoNgayMuon());
            pre.setDouble(11, dg.getSoDuTaiKhoan());
            pre.setString(12, dg.getMaDocGia());
            n = pre.executeUpdate();
        }
        catch (SQLException ex) {
            Logger.getLogger(DocGia_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public int delete_Docia(String ma) {
        int n = 0;
        String sql = "delete from DocGia where MaDocGia='" + ma + "'";
        try {
            Statement st = conn.createStatement();
            n = st.executeUpdate(sql);
        }
        catch (SQLException ex) {
            Logger.getLogger(DocGia_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
    public ArrayList<DocGia> getDocGia(String madg){
        ArrayList<DocGia> list = new ArrayList<>();
        String sql="select * from DocGia where MaDocGia='"+madg+"'";
        try {
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
                String maDocGia = rs.getString("MaDocGia");
                String hoTen = rs.getString("HoTen");
                Short gioiTinh = rs.getShort("GioiTinh");
                Date ngaySinh = rs.getDate("NgaySinh");
                String doiTuong = rs.getString("DoiTuong");
                Date ngayCap = rs.getDate("NgayCap");
                Date ngayHetHan = rs.getDate("NgayHetHan");
                String matKhau = rs.getString("MatKhau");
                int soLuongTaiLieu=rs.getInt("SoLuongTaiLieu");
                int soLuongMoiTaiLieu=rs.getInt("SoLuongMoiTaiLieu");
                int soNgayMuon=rs.getInt("SoNgayMuon");
                double soDuTaiKhoan=rs.getDouble("SoDuTaiKhoan");
                DocGia dg=new DocGia(maDocGia, hoTen, gioiTinh, ngaySinh, doiTuong, ngayCap, ngayHetHan, matKhau, soLuongTaiLieu, soLuongMoiTaiLieu, soNgayMuon, soDuTaiKhoan);
                list.add(dg);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DocGia_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    public boolean checkmadocgia(String madocgia){
        String sql="select * from DocGia where MaDocGia='"+madocgia+"'";
        try {
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(sql);
            if(rs.next()) return true;
        } catch (SQLException ex) {
            Logger.getLogger(DocGia_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
//    public int getSoLuongTaiLieu(String madocgia){
//        String sql="select sum(PhieuMuonChiTiet.SoLuongMuon) as 'TongSoLuongSach' from PhieuMuonChiTiet, PhieuMuon where\n" +
//" PhieuMuonChiTiet.MaPhieuMuon=PhieuMuon.MaPhieuMuon and PhieuMuonChiTiet.NgayTra is null and PhieuMuon.MaDocGia='"+madocgia+"'";
//        try {
//            Statement st=conn.createStatement();
//            ResultSet rs=st.executeQuery(sql);
//            if(rs.next()) return rs.getInt("TongSoLuongSach");
//        } catch (SQLException ex) {
//            Logger.getLogger(DocGia_DAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return 0;
//    }
    
    public int getSoTaiLieuQuaHan(String madocgia){
        String sql="select count(PhieuMuonChiTiet.MaTaiLieu) as 'SoTaiLieuQuaHan'  from PhieuMuonChiTiet, PhieuMuon, DocGia where\n" +
"PhieuMuonChiTiet.MaPhieuMuon=PhieuMuon.MaPhieuMuon and PhieuMuon.MaDocGia=DocGia.MaDocGia\n" +
" and PhieuMuonChiTiet.NgayTra is null and DocGia.SoNgayMuon < DATEDIFF(day,PhieuMuon.NgayMuon, GETDATE()) and PhieuMuon.MaDocGia='"+madocgia+"'";
        try {
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(sql);
            if(rs.next()) return rs.getInt("SoTaiLieuQuaHan");
        } catch (SQLException ex) {
            Logger.getLogger(DocGia_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    public int getSoLuongMoiTaiLieuDuocMuon(String madocgia, String matailieu){
        String sql="select count(PhieuMuonChiTiet.MaTaiLieu) as 'SoLuong' from DocGia, PhieuMuonChiTiet, PhieuMuon where\n" +
" PhieuMuonChiTiet.MaPhieuMuon=PhieuMuon.MaPhieuMuon and PhieuMuon.MaDocGia=DocGia.MaDocGia and\n" +
"PhieuMuonChiTiet.NgayTra is null and\n" +
"DocGia.MaDocGia='"+madocgia+"' and PhieuMuonChiTiet.MaTaiLieu='"+matailieu+"'";
        try {
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(sql);
            if(rs.next()) return rs.getInt("SoLuong");
        } catch (SQLException ex) {
            Logger.getLogger(DocGia_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    
    public int getSoNgayHetHan(String madocgia){
        String sql=" select DATEDIFF(day, DocGia.NgayHetHan, GETDATE()) as 'SoNgayHetHan' from DocGia where DocGia.MaDocGia='"+madocgia+"'";
        try {
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(sql);
            if(rs.next()) return rs.getInt("SoNgayHetHan");
        } catch (SQLException ex) {
            Logger.getLogger(DocGia_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    public DocGia getOneDocGia(String madg){
        String sql="select * from DocGia where MaDocGia='"+madg+"'";
        try {
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(sql);
            if(rs.next()){
                String maDocGia = rs.getString("MaDocGia");
                String hoTen = rs.getString("HoTen");
                Short gioiTinh = rs.getShort("GioiTinh");
                Date ngaySinh = rs.getDate("NgaySinh");
                String doiTuong = rs.getString("DoiTuong");
                Date ngayCap = rs.getDate("NgayCap");
                Date ngayHetHan = rs.getDate("NgayHetHan");
                String matKhau = rs.getString("MatKhau");
                int soLuongTaiLieu=rs.getInt("SoLuongTaiLieu");
                int soLuongMoiTaiLieu=rs.getInt("SoLuongMoiTaiLieu");
                int soNgayMuon=rs.getInt("SoNgayMuon");
                double soDuTaiKhoan=rs.getDouble("SoDuTaiKhoan");
                DocGia dg=new DocGia(maDocGia, hoTen, gioiTinh, ngaySinh, doiTuong, ngayCap, ngayHetHan, matKhau, soLuongTaiLieu, soLuongMoiTaiLieu, soNgayMuon, soDuTaiKhoan);
                return dg;
            } 
        } catch (SQLException ex) {
            Logger.getLogger(DocGia_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public int update_SoLuongTaiLieu_SoDuTaiKhoan(int sltl, double sdtk, String madg) {
        int n = 0;
        String sql = "update DocGia set SoLuongTaiLieu=?, SoDuTaiKhoan=? where MaDocGia=?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, sltl);
            pre.setDouble(2, sdtk);
            pre.setString(3, madg);
            n = pre.executeUpdate();
        }
        catch (SQLException ex) {
            Logger.getLogger(TaiLieu_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
    
    
    public int update_SoLuongTaiLieu_SoDuTaiKhoan(int sltl, String madg) {
        int n = 0;
        String sql = "update DocGia set SoLuongTaiLieu=? where MaDocGia=?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, sltl);
            pre.setString(2, madg);
            n = pre.executeUpdate();
        }
        catch (SQLException ex) {
            Logger.getLogger(TaiLieu_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
    
    
    public DocGia getDocGiaLogin(String madg, String matkhau){
        DocGia dg=null;
        try{
            String sql="select * from DocGia where MaDocGia='"+  madg +"' and MatKhau='"+ matkhau +"' ";
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(sql);
            if(rs.next()){
                String maDocGia = rs.getString("MaDocGia");
                String hoTen = rs.getString("HoTen");
                Short gioiTinh = rs.getShort("GioiTinh");
                Date ngaySinh = rs.getDate("NgaySinh");
                String doiTuong = rs.getString("DoiTuong");
                Date ngayCap = rs.getDate("NgayCap");
                Date ngayHetHan = rs.getDate("NgayHetHan");
                String matKhau = rs.getString("MatKhau");
                int soLuongTaiLieu=rs.getInt("SoLuongTaiLieu");
                int soLuongMoiTaiLieu=rs.getInt("SoLuongMoiTaiLieu");
                int soNgayMuon=rs.getInt("SoNgayMuon");
                double soDuTaiKhoan=rs.getDouble("SoDuTaiKhoan");
                dg=new DocGia(maDocGia, hoTen, gioiTinh, ngaySinh, doiTuong, ngayCap, ngayHetHan,matKhau, soLuongTaiLieu, soLuongMoiTaiLieu, soNgayMuon, soDuTaiKhoan);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVien_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return dg;
    }
    public int update_ThongTin_DocGia(String hoten, Short gioitinh, Date ngaysinh, String matkhau, String madg) {//trang docgia
        int n = 0;
        String sql = "update DocGia set HoTen=?, GioiTinh=?, NgaySinh=?, MatKhau=? where MaDocGia=?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, hoten);
            pre.setShort(2, gioitinh);
            pre.setDate(3, ngaysinh);
            pre.setString(4, matkhau);
            pre.setString(5, madg);
            n = pre.executeUpdate();
        }
        catch (SQLException ex) {
            Logger.getLogger(TaiLieu_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
    
    public int update_SoDuTaiKhoan(double sodu, String madg) {
        int n = 0;
        String sql = "update DocGia set SoDuTaiKhoan=? where MaDocGia=?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setDouble(1, sodu);
            pre.setString(2, madg);
            n = pre.executeUpdate();
        }
        catch (SQLException ex) {
            Logger.getLogger(TaiLieu_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
}
