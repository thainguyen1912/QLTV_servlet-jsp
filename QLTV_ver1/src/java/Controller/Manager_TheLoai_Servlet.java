/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import dao.db_connection;
import dao.TheLoai_DAO;
import enity.TheLoai;
import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Manager_TheLoai_Servlet extends HttpServlet {

    db_connection db=new db_connection();
    TheLoai_DAO tldao=new TheLoai_DAO(db);
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        ServletContext context=getServletContext();
        String chucnang=context.getAttribute("context").toString();
        
        if(chucnang.equals("add_thl")){
            String maTL = request.getParameter("maTL");
            String tenTL = request.getParameter("tenTL");
            String ghiChu = request.getParameter("ghiChu");

            TheLoai theloai = new TheLoai(maTL, tenTL, ghiChu);
            tldao.add_theloai(theloai);
            response.sendRedirect("TheLoai_Servlet");
        }
        if(chucnang.equals("delete_thl")){
            String maTL=request.getParameter("maTL");
            tldao.delete_TheLoai(maTL);   
            response.sendRedirect("TheLoai_Servlet");
        }
        if(chucnang.equals("edit_thl")){
            String maTL=request.getParameter("maTL");
            String tenTL=request.getParameter("tenTL");
            String ghiChu=request.getParameter("ghiChu");
            tldao.update_theLoai(new TheLoai(maTL, tenTL, ghiChu));
            response.sendRedirect("TheLoai_Servlet");
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
