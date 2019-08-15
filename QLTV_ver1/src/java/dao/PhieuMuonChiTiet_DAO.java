/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import enity.PhieuMuonChiTiet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author thain
 */
public class PhieuMuonChiTiet_DAO {

    private db_connection dbcon;
    private Connection conn;

    public PhieuMuonChiTiet_DAO(db_connection db) {
        this.dbcon = db;
        this.conn = db.getConnection();
    }

    public int add_PhieuMuonChiTiet(PhieuMuonChiTiet pmct) {
        int n = 0;
        String sql = "insert into PhieuMuonChiTiet(MaPhieuMuon, MaTaiLieu, SoLuongMuon, Mat) values(?, ?, ?, ?)";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, pmct.getMaPhieuMuon());
            pre.setString(2, pmct.getMaTaiLieu());
            pre.setInt(3, pmct.getSoLuongMuon());
            pre.setInt(4, pmct.getMat());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PhieuMuonChiTiet_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public ResultSet displayAll(String ma) {
        String sql = "select PhieuMuonChiTiet.MaPhieuMuon, PhieuMuonChiTiet.MaTaiLieu, TaiLieu.TenTaiLieu, NhanVien.HoTen, SoLuongMuon, TaiLieu.GiaTien, NgayMuon, NgayTra, Mat from PhieuMuon, PhieuMuonChiTiet, DocGia, NhanVien, TaiLieu\n"
                + "where  PhieuMuon.MaPhieuMuon=PhieuMuonChiTiet.MaPhieuMuon\n"
                + "and  PhieuMuon.MaDocGia=DocGia.MaDocGia\n"
                + "and  PhieuMuon.MaNhanVien=NhanVien.MaNhanVien\n"
                + "and PhieuMuonChiTiet.MaTaiLieu=TaiLieu.MaTaiLieu"
                + " and PhieuMuon.MaDocGia='" + ma + "'";
        ResultSet rs = null;
        try {
            Statement st = conn.createStatement();
            rs = st.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(TheLoai_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public ResultSet display_DaTra(String ma) {
        String sql = "select PhieuMuonChiTiet.MaPhieuMuon, PhieuMuonChiTiet.MaTaiLieu, TaiLieu.TenTaiLieu, NhanVien.HoTen, SoLuongMuon, TaiLieu.GiaTien, NgayMuon, NgayTra, Mat from PhieuMuon, PhieuMuonChiTiet, DocGia, NhanVien, TaiLieu\n"
                + "where  PhieuMuon.MaPhieuMuon=PhieuMuonChiTiet.MaPhieuMuon\n"
                + "and  PhieuMuon.MaDocGia=DocGia.MaDocGia\n"
                + "and  PhieuMuon.MaNhanVien=NhanVien.MaNhanVien\n"
                + "and PhieuMuonChiTiet.MaTaiLieu=TaiLieu.MaTaiLieu"
                + " and PhieuMuon.MaDocGia='" + ma + "' and PhieuMuonChiTiet.NgayTra is not null and PhieuMuonChiTiet.Mat= '0'";
        ResultSet rs = null;
        try {
            Statement st = conn.createStatement();
            rs = st.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(TheLoai_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public ResultSet display_ChuaTra(String ma) {
        String sql = "select PhieuMuonChiTiet.MaPhieuMuon, PhieuMuonChiTiet.MaTaiLieu, TaiLieu.TenTaiLieu, NhanVien.HoTen, SoLuongMuon, TaiLieu.GiaTien, NgayMuon, NgayTra, Mat from PhieuMuon, PhieuMuonChiTiet, DocGia, NhanVien, TaiLieu\n"
                + "where  PhieuMuon.MaPhieuMuon=PhieuMuonChiTiet.MaPhieuMuon\n"
                + "and  PhieuMuon.MaDocGia=DocGia.MaDocGia\n"
                + "and  PhieuMuon.MaNhanVien=NhanVien.MaNhanVien\n"
                + "and PhieuMuonChiTiet.MaTaiLieu=TaiLieu.MaTaiLieu"
                + " and PhieuMuon.MaDocGia='" + ma + "' and PhieuMuonChiTiet.NgayTra is null";
        ResultSet rs = null;
        try {
            Statement st = conn.createStatement();
            rs = st.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(TheLoai_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    public ResultSet display_LamMat(String ma) {
        String sql = "select PhieuMuonChiTiet.MaPhieuMuon, PhieuMuonChiTiet.MaTaiLieu, TaiLieu.TenTaiLieu, NhanVien.HoTen, SoLuongMuon, TaiLieu.GiaTien, NgayMuon, NgayTra, Mat from PhieuMuon, PhieuMuonChiTiet, DocGia, NhanVien, TaiLieu\n"
                + "where  PhieuMuon.MaPhieuMuon=PhieuMuonChiTiet.MaPhieuMuon\n"
                + "and  PhieuMuon.MaDocGia=DocGia.MaDocGia\n"
                + "and  PhieuMuon.MaNhanVien=NhanVien.MaNhanVien\n"
                + "and PhieuMuonChiTiet.MaTaiLieu=TaiLieu.MaTaiLieu"
                + " and PhieuMuon.MaDocGia='" + ma + "' and PhieuMuonChiTiet.Mat= '1'";
        ResultSet rs = null;
        try {
            Statement st = conn.createStatement();
            rs = st.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(TheLoai_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    public ResultSet display_QuaHan(int soNgayQuaHan, String ma) {
        String sql = "select PhieuMuonChiTiet.MaPhieuMuon, PhieuMuonChiTiet.MaTaiLieu, TaiLieu.TenTaiLieu, NhanVien.HoTen, SoLuongMuon, TaiLieu.GiaTien, NgayMuon, NgayTra, Mat from PhieuMuon, PhieuMuonChiTiet, DocGia, NhanVien, TaiLieu\n"
                + "where  PhieuMuon.MaPhieuMuon=PhieuMuonChiTiet.MaPhieuMuon\n"
                + "and  PhieuMuon.MaDocGia=DocGia.MaDocGia\n"
                + "and  PhieuMuon.MaNhanVien=NhanVien.MaNhanVien\n"
                + "and PhieuMuonChiTiet.MaTaiLieu=TaiLieu.MaTaiLieu"
                + " and PhieuMuon.MaDocGia='" + ma + "' and PhieuMuonChiTiet.NgayTra is NULL"
                + " and DATEDIFF(day,PhieuMuon.NgayMuon,GetDate()) > '"+ soNgayQuaHan +"'";
        ResultSet rs = null;
        try {
            Statement st = conn.createStatement();
            rs = st.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(TheLoai_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    

    public ResultSet display_MaPM(String madg, String mapm) {
        String sql = "select PhieuMuonChiTiet.MaPhieuMuon, PhieuMuonChiTiet.MaTaiLieu, TaiLieu.TenTaiLieu, NhanVien.HoTen, SoLuongMuon,TaiLieu.GiaTien,  NgayMuon, NgayTra, Mat from PhieuMuon, PhieuMuonChiTiet, DocGia, NhanVien, TaiLieu\n"
                + "where  PhieuMuon.MaPhieuMuon=PhieuMuonChiTiet.MaPhieuMuon\n"
                + "and  PhieuMuon.MaDocGia=DocGia.MaDocGia\n"
                + "and  PhieuMuon.MaNhanVien=NhanVien.MaNhanVien\n"
                + "and PhieuMuonChiTiet.MaTaiLieu=TaiLieu.MaTaiLieu"
                + " and PhieuMuon.MaDocGia='" + madg + "' and PhieuMuonChiTiet.MaPhieuMuon='" + mapm + "'";
        ResultSet rs = null;
        try {
            Statement st = conn.createStatement();
            rs = st.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(TheLoai_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public int update_NgayTra(String mapm, String matl, String ngayTra) {
        String sql = "update PhieuMuonChiTiet set NgayTra='" + ngayTra + "' where MaPhieuMuon='" + mapm + "' and MaTaiLieu='" + matl + "'";
        try {
            Statement st = conn.createStatement();
            return st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(PhieuMuonChiTiet_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    public int update_Mat(String mapm, String matl) {
        String sql = "update PhieuMuonChiTiet set Mat='1' from PhieuMuonChiTiet where MaPhieuMuon='"+ mapm +"' and MaTaiLieu='"+ matl +"'";
        try {
            Statement st = conn.createStatement();
            return st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(PhieuMuonChiTiet_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    

    public ResultSet displayTLQuaHan() {
        String sql = "select  DocGia.MaDocGia,DocGia.HoTen,PhieuMuonChiTiet.MaPhieuMuon,TenTaiLieu,PhieuMuonChiTiet.SoLuongMuon,NgayMuon, (DATEDIFF(day,PhieuMuon.NgayMuon,GetDate()) - 30) as 'SoNgayQuaHan'"
                + " from DocGia inner join PhieuMuon on PhieuMuon.MaDocGia = DocGia.MaDocGia "
                + " inner join PhieuMuonChiTiet on PhieuMuonChiTiet.MaPhieuMuon= PhieuMuon.MaPhieuMuon"
                + " inner join TaiLieu on TaiLieu.MaTaiLieu = PhieuMuonChiTiet.MaTaiLieu"
                + " where (DATEDIFF(day,PhieuMuon.NgayMuon,GetDate()) - 30) >0  and PhieuMuonChiTiet.NgayTra is null"
                + " ORDER BY [SoNgayQuaHan] DESC";
        ResultSet rs = null;
        try {
            Statement st = conn.createStatement();
            rs = st.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(TheLoai_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    public ResultSet displayTopTL(int songay) {
        String sql="";
        if(songay==0){
            sql = "select PhieuMuonChiTiet.MaTaiLieu,TenTaiLieu,count(PhieuMuonChiTiet.MaTaiLieu) as 'SoLanMuon',sum(SoLuongMuon) as'SoLuongMuon' \n" +
" from PhieuMuonChiTiet inner join TaiLieu on  PhieuMuonChiTiet.MaTaiLieu = TaiLieu.MaTaiLieu \n" +
"inner join PhieuMuon on PhieuMuon.MaPhieuMuon = PhieuMuonChiTiet.MaPhieuMuon \n" +
" group by PhieuMuonChiTiet.MaTaiLieu, TaiLieu.TenTaiLieu\n" +
"  ORDER BY sum(SoLuongMuon) DESC";
        }
        else{
            sql = "select PhieuMuonChiTiet.MaTaiLieu,TenTaiLieu,count(PhieuMuonChiTiet.MaTaiLieu) as 'SoLanMuon',sum(SoLuongMuon) as'SoLuongMuon' \n" +
" from PhieuMuonChiTiet inner join TaiLieu on  PhieuMuonChiTiet.MaTaiLieu = TaiLieu.MaTaiLieu \n" +
"inner join PhieuMuon on PhieuMuon.MaPhieuMuon = PhieuMuonChiTiet.MaPhieuMuon \n" +
"where DATEDIFF(day,PhieuMuon.NgayMuon,GetDate())  <= '"+songay+"'\n" +
" group by PhieuMuonChiTiet.MaTaiLieu, TaiLieu.TenTaiLieu\n" +
"  ORDER BY sum(SoLuongMuon) DESC";
        }
        
        ResultSet rs=null;
        try {
            Statement st=conn.createStatement();
            rs=st.executeQuery(sql);
        }
        catch (SQLException ex) {
            Logger.getLogger(TheLoai_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    public ResultSet displayHoaDon( String mapm) {
        String sql = "select PhieuMuonChiTiet.MaPhieuMuon, PhieuMuon.MaDocGia, DocGia.HoTen, TaiLieu.MaTaiLieu, TaiLieu.TenTaiLieu, PhieuMuonChiTiet.SoLuongMuon, TaiLieu.GiaTien \n" +
"from PhieuMuonChiTiet, PhieuMuon, DocGia, TaiLieu where PhieuMuonChiTiet.MaPhieuMuon=PhieuMuon.MaPhieuMuon and\n" +
"PhieuMuon.MaDocGia=DocGia.MaDocGia and PhieuMuonChiTiet.MaTaiLieu=TaiLieu.MaTaiLieu and PhieuMuon.MaPhieuMuon='"+ mapm +"'";
        ResultSet rs = null;
        try {
            Statement st = conn.createStatement();
            rs = st.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(TheLoai_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
}
