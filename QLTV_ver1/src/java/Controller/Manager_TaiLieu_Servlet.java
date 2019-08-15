/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import dao.TaiLieu_DAO;
import dao.db_connection;
import enity.TaiLieu;
import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author thain
 */
public class Manager_TaiLieu_Servlet extends HttpServlet {

    
    db_connection db=new db_connection();
    TaiLieu_DAO tlidao=new TaiLieu_DAO(db);
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        ServletContext context=getServletContext();
        String chucnang=context.getAttribute("context").toString();
        
        
        if(chucnang.equals("add_tli")){
            String matli=request.getParameter("matli");
            String tentli=request.getParameter("tentli");
            String matlo=request.getParameter("matlo");
            int soluong=Integer.valueOf(request.getParameter("soluong"));
            String nhaxb=request.getParameter("nhaxb");
            int namxb=Integer.valueOf(request.getParameter("namxb"));
            String tacgia=request.getParameter("tacgia");
            double giaTien=Double.valueOf(request.getParameter("giatien"));
            tlidao.add_TaiLieu(new TaiLieu(matli, tentli, matlo, soluong, nhaxb, namxb, tacgia, giaTien));
            response.sendRedirect("TaiLieu_Servlet");
        }
        
        if(chucnang.equals("edit_tli")){
            String matli=request.getParameter("matli");
            String tentli=request.getParameter("tentli");
            String matlo=request.getParameter("matlo");
            int soluong=Integer.valueOf(request.getParameter("soluong"));
            String nhaxb=request.getParameter("nhaxb");
            int namxb=Integer.valueOf(request.getParameter("namxb"));
            String tacgia=request.getParameter("tacgia");
            double giaTien=Double.valueOf(request.getParameter("giatien"));
            tlidao.update_TaiLieu(new TaiLieu(matli, tentli, matlo, soluong, nhaxb, namxb, tacgia, giaTien));
            response.sendRedirect("TaiLieu_Servlet");
        }
        
        if(chucnang.equals("delete_tli")){
            String maTLI=request.getParameter("maTLI");
            tlidao.delete_TaiLieu(maTLI);
            response.sendRedirect("TaiLieu_Servlet");
        }

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
