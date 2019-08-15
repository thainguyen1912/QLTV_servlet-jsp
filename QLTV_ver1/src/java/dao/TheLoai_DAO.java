/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import enity.TheLoai;
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
public class TheLoai_DAO {
    private Connection conn;
    private db_connection dbcon;

    public TheLoai_DAO(db_connection dbcon) {
        this.dbcon = dbcon;
        this.conn = dbcon.getConnection();
    }
    public ArrayList<TheLoai> getAll(){
        ArrayList<TheLoai> list = new ArrayList<>();
        String sql="select * from TheLoai";
        try {
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
                String ma = rs.getString("MaTheLoai");
                String ten = rs.getString("TenTheLoai");
                String ghiChu = rs.getString("GhiChu");
                TheLoai tl=new TheLoai(ma, ten, ghiChu);
                list.add(tl);
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(TheLoai_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    public ArrayList<String> getAllMaTheLoai(){
        ArrayList<String> list = new ArrayList<>();
        String sql="select MaTheLoai from TheLoai";
        try {
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
                String ma = rs.getString("MaTheLoai");
                list.add(ma);
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(TheLoai_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    public ArrayList<String> getAllTenTheLoai(){
        ArrayList<String> list = new ArrayList<>();
        String sql="select TenTheLoai from TheLoai";
        try {
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
                String ten = rs.getString("TenTheLoai");
                list.add(ten);
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(TheLoai_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    public int add_theloai(TheLoai tlo) {
        int n = 0;
        String sql = "insert into TheLoai(MaTheLoai, TenTheLoai, GhiChu) values(?, ? ,?)";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, tlo.getMaTheLoai());
            pre.setString(2, tlo.getTenTheLoai());
            pre.setString(3, tlo.getGhiChu());
            n = pre.executeUpdate();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }
    public int update_theLoai(TheLoai tlo) {
        int n = 0;
        String sql = "update TheLoai set TenTheLoai=?, GhiChu=? where MaTheLoai=?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, tlo.getTenTheLoai());
            pre.setString(2, tlo.getGhiChu());
            pre.setString(3, tlo.getMaTheLoai());
            n = pre.executeUpdate();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }
    public int delete_TheLoai(String ma) {
        int n = 0;
        String sql = "delete from TheLoai where MaTheLoai='" + ma + "'";
        try {
            Statement st=conn.createStatement();
            n=st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(TheLoai_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
    public String getTenTheLoai(String ma){
        String ten="";
        String sql="select TenTheLoai from TheLoai where MaTheLoai='"+ma+"'";
        try {
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(sql);
            if(rs.next()) ten=rs.getString("TenTheLoai");
            return ten;
        } catch (SQLException ex) {
            Logger.getLogger(TheLoai_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ten;
    }
    public ArrayList<TheLoai> getTheLoai(String mathl){
        ArrayList<TheLoai> list = new ArrayList<>();
        String sql="select * from TheLoai where MaTheLoai='"+mathl+"'";
        try {
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
                String ma = rs.getString("MaTheLoai");
                String ten = rs.getString("TenTheLoai");
                String ghiChu = rs.getString("GhiChu");
                TheLoai tl=new TheLoai(ma, ten, ghiChu);
                list.add(tl);
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(TheLoai_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
