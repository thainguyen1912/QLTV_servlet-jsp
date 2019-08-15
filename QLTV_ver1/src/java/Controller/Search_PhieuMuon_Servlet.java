/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import dao.PhieuMuonChiTiet_DAO;
import dao.TaiLieu_DAO;
import dao.db_connection;
import enity.DocGia;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author thain
 */
public class Search_PhieuMuon_Servlet extends HttpServlet {

    db_connection db = new db_connection();
    PhieuMuonChiTiet_DAO pmctdao = new PhieuMuonChiTiet_DAO(db);
    TaiLieu_DAO tldao = new TaiLieu_DAO(db);
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        ServletContext context = getServletContext();
        DocGia dg = (DocGia) context.getAttribute("docgia");
        String mapm = request.getParameter("mapm").toString().trim();
        String madg = dg.getMaDocGia();
        
        
        ResultSet rs = pmctdao.display_MaPM(madg, mapm);
        String notFind="";
        try {
            if(rs.next()==false){
                notFind="Not Find";
                request.setAttribute("mess_notfind", notFind);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Search_PhieuMuon_Servlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("rs_pm", rs);
        
        request.setAttribute("search_mapm", mapm);
        context.setAttribute("searched", "true");
        RequestDispatcher rd = request.getRequestDispatcher("trangchu_trasach.jsp");
        rd.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
