/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import enity.TaiLieu;
import java.sql.Connection;
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
public class TaiLieu_DAO {
    private Connection conn;
    private db_connection dbcon;

    public TaiLieu_DAO(db_connection dbcon) {
        this.dbcon = dbcon;
        this.conn = dbcon.getConnection();
    }
    public ArrayList<TaiLieu> getAll(){
        ArrayList<TaiLieu> list = new ArrayList<>();
        String sql="select * from TaiLieu";
        try {
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
                String maTL = rs.getString("MaTaiLieu");
                String tenTL = rs.getString("TenTaiLieu");
                String maTHL = rs.getString("MaTheLoai");
                int sL=rs.getInt("SoLuong");
                String nhaXB = rs.getString("NhaXuatBan");
                int namXB=rs.getInt("NamXuatBan");
                String tacGia = rs.getString("TacGia");
                double giaTien=rs.getDouble("GiaTien");
                TaiLieu tl=new TaiLieu(maTL, tenTL, maTHL, sL, nhaXB, namXB, tacGia, giaTien);
                list.add(tl);
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(TaiLieu_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return list;
    }
    
    public int delete_TaiLieu(String ma) {
        int n = 0;
        String sql = "delete from TaiLieu where MaTaiLieu='" + ma + "'";
        try {
            Statement st=conn.createStatement();
            n=st.executeUpdate(sql);
        }
        catch (SQLException ex) {
            Logger.getLogger(TaiLieu_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
    public int add_TaiLieu(TaiLieu tli) {
        int n = 0;
        String sql = "insert into TaiLieu(MaTaiLieu, TenTaiLieu, MaTheLoai, SoLuong, NhaXuatBan, NamXuatBan, TacGia, GiaTien) values(?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, tli.getMaTaiLieu());
            pre.setString(2, tli.getTenTaiLieu());
            pre.setString(3, tli.getMaTheLoai());
            pre.setInt(4, tli.getSoLuong());
            pre.setString(5, tli.getNhaXuatBan());
            pre.setInt(6, tli.getNamXuatBan());
            pre.setString(7, tli.getTacGia());
            pre.setDouble(8, tli.getGiaTien());
            n = pre.executeUpdate();
        }
        catch (SQLException ex) {
            Logger.getLogger(TaiLieu_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
    public int check_ForeignKey(String maTheLoai){
        String sql="Select * from TaiLieu where TaiLieu.MaTheLoai='"+maTheLoai+"'";
        try {
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(sql);
            if(rs.next()) return 1;
        } catch (SQLException ex) {
            Logger.getLogger(TaiLieu_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    public int update_TaiLieu(TaiLieu tli) {
        int n = 0;
        String sql = "update TaiLieu set TenTaiLieu=?, MaTheLoai=?, SoLuong=?, NhaXuatBan=?, NamXuatBan=?, TacGia=?, GiaTien=? where MaTaiLieu=?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, tli.getTenTaiLieu());
            pre.setString(2, tli.getMaTheLoai());
            pre.setInt(3, tli.getSoLuong());
            pre.setString(4, tli.getNhaXuatBan());
            pre.setInt(5, tli.getNamXuatBan());
            pre.setString(6, tli.getTacGia());
            pre.setDouble(7, tli.getGiaTien());
            pre.setString(8, tli.getMaTaiLieu());
            n = pre.executeUpdate();
        }
        catch (SQLException ex) {
            Logger.getLogger(TaiLieu_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
    
    public ArrayList<TaiLieu> getTaiLieu(String maTaiLieu){
        ArrayList<TaiLieu> list = new ArrayList<>();
        String sql="select * from TaiLieu where MaTaiLieu='"+maTaiLieu+"'";
        try {
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
                String maTL = rs.getString("MaTaiLieu");
                String tenTL = rs.getString("TenTaiLieu");
                String maTHL = rs.getString("MaTheLoai");
                int sL=rs.getInt("SoLuong");
                String nhaXB = rs.getString("NhaXuatBan");
                int namXB=rs.getInt("NamXuatBan");
                String tacGia = rs.getString("TacGia");
                double giaTien=rs.getDouble("GiaTien");
                TaiLieu tl=new TaiLieu(maTL, tenTL, maTHL, sL, nhaXB, namXB, tacGia, giaTien);
                list.add(tl);
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(TaiLieu_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return list;
    }
    public ArrayList<String> getAllMaTaiLieu(){
        ArrayList<String> list = new ArrayList<>();
        String sql="select MaTaiLieu from TaiLieu";
        try {
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
                String ma = rs.getString("MaTaiLieu");
                list.add(ma);
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(TheLoai_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    public ArrayList<String> getAllTenTaiLieu(){
        ArrayList<String> list = new ArrayList<>();
        String sql="select TenTaiLieu from TaiLieu";
        try {
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
                String ma = rs.getString("TenTaiLieu");
                list.add(ma);
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(TheLoai_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    public int getSoLuongCon(String matl){
        String sql="select * from TaiLieu where MaTaiLieu='"+matl+"'";
        try {
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(sql);
            if(rs.next()){
                int sl=rs.getInt("SoLuong");
                return sl;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TaiLieu_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    public double getGiaTien(String matl){
        String sql="select * from TaiLieu where MaTaiLieu='"+matl+"'";
        try {
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(sql);
            if(rs.next()){
                double giaTien=rs.getInt("GiaTien");
                return giaTien;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TaiLieu_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    public TaiLieu getTaiLieuMuon(String matl, int slmuon){
        String sql="select * from TaiLieu where MaTaiLieu='"+matl+"'";
        try {
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(sql);
            if(rs.next()){
                String maTL = rs.getString("MaTaiLieu");
                String tenTL = rs.getString("TenTaiLieu");
                String maTHL = rs.getString("MaTheLoai");
                String nhaXB = rs.getString("NhaXuatBan");
                int namXB=rs.getInt("NamXuatBan");
                String tacGia = rs.getString("TacGia");
                double giaTien=rs.getDouble("GiaTien");
                TaiLieu tl=new TaiLieu(maTL, tenTL, maTHL, slmuon, nhaXB, namXB, tacGia, giaTien);
                return tl;
            } 
        } catch (SQLException ex) {
            Logger.getLogger(DocGia_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public String getTenTL(String matl){
        String sql="select TenTaiLieu from TaiLieu where MaTaiLieu='"+matl+"'";
        try {
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(sql);
            if(rs.next()) return rs.getString("TenTaiLieu");
        } catch (SQLException ex) {
            Logger.getLogger(TaiLieu_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
    
    public int update_slTaiLieu(String matl, int sl) {
        int n = 0;
        String sql = "update TaiLieu set SoLuong='"+sl+"' where MaTaiLieu='"+matl+"'";
        try {
            Statement st=conn.createStatement();
            n = st.executeUpdate(sql);
        }
        catch (SQLException ex) {
            Logger.getLogger(TaiLieu_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
}
