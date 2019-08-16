/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import dao.DocGia_DAO;
import dao.db_connection;
import enity.DocGia;
import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author thain
 */
public class Manager_DocGia_Servlet extends HttpServlet {

    db_connection db=new db_connection();
    DocGia_DAO dgdao=new DocGia_DAO(db);
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        ServletContext context=getServletContext();
        String chucnang=context.getAttribute("context").toString();
        if(chucnang.equals("add_dg")){
            String madg=request.getParameter("madg");
            String hoten=request.getParameter("hoten");
            short gioitinh=Short.valueOf(request.getParameter("gioitinh"));
            Date ngaysinh=Date.valueOf(request.getParameter("ngaysinh"));
            String doituong=request.getParameter("doituong");
            Date ngaycap=Date.valueOf(request.getParameter("ngaycap"));
            Date ngayhethan=Date.valueOf(request.getParameter("ngayhethan"));
            String matKhau = request.getParameter("matkhau");
            int soLuongTaiLieu=Integer.valueOf(request.getParameter("soluongtailieu"));
            int soLuongMoiTaiLieu=Integer.valueOf(request.getParameter("soluongmoitailieu"));
            int soNgayMuon=Integer.valueOf(request.getParameter("songaymuon"));
            double soDuTaiKhoan=Double.valueOf(request.getParameter("sodutaikhoan"));
            DocGia dg=new DocGia(madg, hoten, gioitinh, ngaysinh, doituong, ngaycap, ngayhethan, matKhau, soLuongTaiLieu, soLuongMoiTaiLieu, soNgayMuon, soDuTaiKhoan);
            dgdao.add_DocGia(dg);
            response.sendRedirect("DocGia_Servlet");
        }
        
        if(chucnang.equals("edit_dg")){
            String madg=request.getParameter("madg");
            String hoten=request.getParameter("hoten");
            short gioitinh=Short.valueOf(request.getParameter("gioitinh"));
            Date ngaysinh=Date.valueOf(request.getParameter("ngaysinh"));
            String doituong=request.getParameter("doituong");
            Date ngaycap=Date.valueOf(request.getParameter("ngaycap"));
            Date ngayhethan=Date.valueOf(request.getParameter("ngayhethan"));
            int soLuongTaiLieu=Integer.valueOf(request.getParameter("soluongtailieu"));
            int soLuongMoiTaiLieu=Integer.valueOf(request.getParameter("soluongmoitailieu"));
            int soNgayMuon=Integer.valueOf(request.getParameter("songaymuon"));
            DocGia dg=new DocGia(madg, hoten, gioitinh, ngaysinh, doituong, ngaycap, ngayhethan, soLuongTaiLieu, soLuongMoiTaiLieu, soNgayMuon);
            dgdao.update_DocGia(dg);
            response.sendRedirect("DocGia_Servlet");
        }
        
        if(chucnang.equals("delete_dg")){
            String madg=request.getParameter("madg");
            dgdao.delete_Docia(madg);
            response.sendRedirect("DocGia_Servlet");
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
