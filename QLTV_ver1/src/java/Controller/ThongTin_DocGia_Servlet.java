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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



public class ThongTin_DocGia_Servlet extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session=request.getSession();
        db_connection db=new db_connection();
        DocGia_DAO dgdao=new DocGia_DAO(db);
        DocGia dg= dgdao.getOneDocGia(session.getAttribute("user").toString());
        String madg=dg.getMaDocGia();
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        ServletContext context=getServletContext();
        String key=context.getAttribute("key").toString();
        if(key.equals("edit_detail")){
            String hoten=request.getParameter("hoten");
            short gioitinh=Short.valueOf(request.getParameter("gioitinh"));
            Date ngaysinh=Date.valueOf(request.getParameter("ngaysinh"));
            String matKhau = request.getParameter("matkhau");
            dgdao.update_ThongTin_DocGia(hoten, gioitinh, ngaysinh, matKhau, madg);
            response.sendRedirect("thongtin_docgia.jsp");
        }
        if(key.equals("naptk")){
            String maThe=request.getParameter("mathe");
            if(maThe.equals("a50")){
                double soDuBanDau=dg.getSoDuTaiKhoan();
                dgdao.update_SoDuTaiKhoan(soDuBanDau + 50000, madg);
                request.setAttribute("mess_t", "Nạp Tiền Thành Công!");
                RequestDispatcher rq=request.getRequestDispatcher("docgia_naptaikhoan.jsp");
                rq.forward(request, response);
            }
            else{
                request.setAttribute("mess_f", "Mã Thẻ Không Hợp Lệ. Xin Kiểm Tra Lại!");
                RequestDispatcher rq=request.getRequestDispatcher("docgia_naptaikhoan.jsp");
                rq.forward(request, response);
            }    
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
