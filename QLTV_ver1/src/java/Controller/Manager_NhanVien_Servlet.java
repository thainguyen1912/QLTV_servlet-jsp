/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import dao.NhanVien_DAO;
import dao.db_connection;
import enity.NhanVien;
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
public class Manager_NhanVien_Servlet extends HttpServlet {

    
    db_connection db=new db_connection();
    NhanVien_DAO nvdao=new NhanVien_DAO(db);
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        ServletContext context=getServletContext();
        String chucnang=context.getAttribute("context").toString();
        
        
        
        if(chucnang.equals("add_nv")){
            String manv=request.getParameter("manv");
            String hoten=request.getParameter("hoten");
            String chucvu=request.getParameter("chucvu");
            String taikhoan=request.getParameter("taikhoan");
            String matkhau=request.getParameter("matkhau");
            String quyen=request.getParameter("quyen");
            nvdao.add_NhanVien(new NhanVien(manv, hoten, chucvu, taikhoan, matkhau, quyen));
            response.sendRedirect("NhanVien_Servlet");
        }
        
        if(chucnang.equals("edit_nv")){
            String manv=request.getParameter("manv");
            String hoten=request.getParameter("hoten");
            String chucvu=request.getParameter("chucvu");
            String taikhoan=request.getParameter("taikhoan");
            String matkhau=request.getParameter("matkhau");
            String quyen=request.getParameter("quyen");
            nvdao.update_NhanVien(new NhanVien(manv, hoten, chucvu, taikhoan, matkhau, quyen));
            response.sendRedirect("NhanVien_Servlet");
        }
        
        if(chucnang.equals("delete_nv")){
            String manv=request.getParameter("manv");
            nvdao.delete_NhanVien(manv);
            response.sendRedirect("NhanVien_Servlet");
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
