/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import enity.NhanVien;
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
 * @author dell
 */
public class NhanVien_DAO {
    private db_connection dbcon;
    private Connection conn;
    public NhanVien_DAO(db_connection db){
        this.dbcon=db;
        this.conn=db.getConnection();
    }
    public NhanVien getTaiKhoan(String tenTK, String matKhau){
        NhanVien nv=null;
        try{
            String sql="select * from NhanVien where TaiKhoan='"+tenTK+"' and MatKhau='"+matKhau+"' ";
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(sql);
            if(rs.next()){
                String ma=rs.getString("MaNhanVien");
                String ten=rs.getString("HoTen");
                String chucvu=rs.getString("ChucVu");
                String tk=rs.getString("TaiKhoan");
                String mk=rs.getString("MatKhau");
                String quyen=rs.getString("Quyen");
                nv=new NhanVien(ma, ten, chucvu, tk, mk, quyen);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVien_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return nv;
    }
    public ArrayList<NhanVien> getAll(){
        ArrayList<NhanVien> list = new ArrayList<>();
        String q="Thủ Thư";
        String sql="select * from NhanVien where Quyen=N'"+q+"'";
        try {
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
                String maNV = rs.getString("MaNhanVien");
                String hoTen = rs.getString("HoTen");
                String chucVu = rs.getString("ChucVu");
                String taiKhoan = rs.getString("TaiKhoan");
                String matKhau = rs.getString("MatKhau");
                String quyen = rs.getString("Quyen");
                NhanVien nv=new NhanVien(maNV, hoTen, chucVu, taiKhoan, matKhau, quyen);
                list.add(nv);
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(TaiLieu_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return list;
    }
    public int add_NhanVien(NhanVien nv){
        int n=0;
        String sql="insert into NhanVien values(?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement pre=conn.prepareStatement(sql);
            pre.setString(1, nv.getMaNhanVien());
            pre.setString(2, nv.getHoTen());
            pre.setString(3, nv.getChucVu());
            pre.setString(4, nv.getTaiKhoan());
            pre.setString(5, nv.getMatKhau());
            pre.setString(6, nv.getQuyen());
            n=pre.executeUpdate();
        }
        catch (SQLException ex) {
            Logger.getLogger(NhanVien_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
    public int update_NhanVien(NhanVien nv){
        int n=0;
        String sql="update NhanVien set HoTen=?, ChucVu=?, TaiKhoan=?, MatKhau=?, Quyen=? where MaNhanVien=?";
        try {
            PreparedStatement pre=conn.prepareStatement(sql);
            pre.setString(1, nv.getHoTen());
            pre.setString(2, nv.getChucVu());
            pre.setString(3, nv.getTaiKhoan());
            pre.setString(4, nv.getMatKhau());
            pre.setString(5, nv.getQuyen());
            pre.setString(6, nv.getMaNhanVien());
            n=pre.executeUpdate();
        }
        catch (SQLException ex) {
            Logger.getLogger(NhanVien_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
    public int delete_NhanVien(String ma){
        int n=0;
        String sql="delete from NhanVien where MaNhanVien='"+ma+"'";
        try {
            Statement st=conn.createStatement();
            n=st.executeUpdate(sql);
        }
        catch (SQLException ex) {
            Logger.getLogger(NhanVien_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }      
        return n;
    }
    public ArrayList<NhanVien> getNhanVien(String manv){
        ArrayList<NhanVien> list = new ArrayList<>();
        String sql="select * from NhanVien where MaNhanVien='"+manv+"'";
        try {
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
                String maNV = rs.getString("MaNhanVien");
                String hoTen = rs.getString("HoTen");
                String chucVu = rs.getString("ChucVu");
                String taiKhoan = rs.getString("TaiKhoan");
                String matKhau = rs.getString("MatKhau");
                String quyen = rs.getString("Quyen");
                NhanVien nv=new NhanVien(maNV, hoTen, chucVu, taiKhoan, matKhau, quyen);
                list.add(nv);
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(TaiLieu_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return list;
    }
    public NhanVien getOneNhanVien(String manv){
        String sql="select * from NhanVien where MaNhanVien='"+manv+"'";
        try {
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(sql);
            if(rs.next()){
                String maNV = rs.getString("MaNhanVien");
                String hoTen = rs.getString("HoTen");
                String chucVu = rs.getString("ChucVu");
                String taiKhoan = rs.getString("TaiKhoan");
                String matKhau = rs.getString("MatKhau");
                String quyen = rs.getString("Quyen");
                NhanVien nv=new NhanVien(maNV, hoTen, chucVu, taiKhoan, matKhau, quyen);
                return nv;
            } 
        } catch (SQLException ex) {
            Logger.getLogger(DocGia_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
