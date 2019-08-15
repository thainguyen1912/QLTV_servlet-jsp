/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import enity.PhieuMuon;
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
public class PhieuMuon_DAO {
    private db_connection dbcon;
    private Connection conn;
    public PhieuMuon_DAO(db_connection db){
        this.dbcon = db;
        this.conn=db.getConnection();
    }
    public ArrayList<PhieuMuon> getAll(){
        ArrayList<PhieuMuon> list = new ArrayList<>();
        String sql="select * from PhieuMuon";
        try {
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
                String maPM = rs.getString("MaPhieuMuon");
                String maDG = rs.getString("MaDocGia");
                Date ngayMuon = rs.getDate("NgayMuon");
                String maNhanVien = rs.getString("MaNhanVien");
                PhieuMuon pm=new PhieuMuon(maPM, maDG, ngayMuon, maNhanVien);
                list.add(pm);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PhieuMuon_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    public int add_PhieuMuon(PhieuMuon pm){
        int n=0;
        String sql="insert into PhieuMuon values(?, ?, ?, ?)";
        try {
            PreparedStatement pre=conn.prepareStatement(sql);
            pre.setString(1, pm.getMaPhieuMuon());
            pre.setString(2, pm.getMaDocGia());
            pre.setDate(3, pm.getNgayMuon());
            pre.setString(4, pm.getMaNhanVien());
            n=pre.executeUpdate();
        }
        catch (SQLException ex) {
            Logger.getLogger(PhieuMuon_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
}
