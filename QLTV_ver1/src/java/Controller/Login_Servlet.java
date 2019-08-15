/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import dao.DocGia_DAO;
import dao.db_connection;
import dao.NhanVien_DAO;
import enity.DocGia;
import enity.NhanVien;
import java.io.IOException;
import java.sql.Connection;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author dell
 */
public class Login_Servlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        db_connection db=new db_connection();
        Connection con=db.getConnection();
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String user=request.getParameter("username").toString();
        String pass=request.getParameter("password").toString();
        
        
        
        HttpSession session=request.getSession();
        NhanVien_DAO nvdao= new NhanVien_DAO(db);
        NhanVien nv=nvdao.getTaiKhoan(user, pass);
        if(nv!=null){
            session.setAttribute("user", nv.getMaNhanVien());
            if(nv.getQuyen().equals("Admin")){
                RequestDispatcher rq=request.getRequestDispatcher("thongtin_admin.jsp");
                rq.forward(request, response);
            }
            else{
                RequestDispatcher rq=request.getRequestDispatcher("thongtin_thuthu.jsp");
                rq.forward(request, response);
            }
        }
        else{
            DocGia_DAO dgdao=new DocGia_DAO(db);
            DocGia dg=dgdao.getDocGiaLogin(user, pass);
            if(dg!=null){
                session.setAttribute("user", dg.getMaDocGia());
                RequestDispatcher rq=request.getRequestDispatcher("thongtin_docgia.jsp");
                rq.forward(request, response);
            }
            
            else{
                request.setAttribute("mess", "Đăng nhập không thành công!");
                RequestDispatcher rq=request.getRequestDispatcher("dangnhap.jsp");
                rq.forward(request, response);
            }
            
        }
        System.out.println(session.getAttribute("user").toString());
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
