/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
    
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class db_connection {
    Connection conn = null;
    
    public Connection getConnection(){
        return conn;
    }

    public db_connection(String url , String username, String password) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(url, username, password);
            
        } catch (SQLException ex) {
            Logger.getLogger(db_connection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(db_connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public db_connection() {
        this("jdbc:sqlserver://localhost:1433;databasename=qltv_servlet", "sa", "123456789");
    }
    
    public ResultSet getData(String sql){
        ResultSet rs = null;

        try {
          Statement  st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE );
          rs = st.executeQuery(sql);
          return rs;
        } catch (SQLException ex) {
            Logger.getLogger(db_connection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    } 
}
