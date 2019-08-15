/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import dao.DocGia_DAO;
import dao.PhieuMuonChiTiet_DAO;
import dao.TaiLieu_DAO;
import dao.db_connection;
import enity.DocGia;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
public class MatSach_Servlet extends HttpServlet {

    db_connection db = new db_connection();
    PhieuMuonChiTiet_DAO pmctdao = new PhieuMuonChiTiet_DAO(db);
    TaiLieu_DAO tldao = new TaiLieu_DAO(db);
    DocGia_DAO dgdao=new DocGia_DAO(db);
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        ServletContext context = getServletContext();
        
        String mapm = request.getParameter("mapm");
        String mdg=request.getParameter("mdg");
        String matl = request.getParameter("matl");
        int slm = Integer.valueOf(request.getParameter("slm"));
        Calendar cl = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateNow = sdf.format(cl.getTime()).toString();
        double giaTien=Double.valueOf(request.getParameter("giatien"));
        DocGia dg=dgdao.getOneDocGia(mdg);

        pmctdao.update_NgayTra(mapm, matl, dateNow);
        pmctdao.update_Mat(mapm, matl);

        dgdao.update_SoLuongTaiLieu_SoDuTaiKhoan(dg.getSoLuongTaiLieu() + slm, mdg);
        
        
        
        String flag_key="";
            try{
                flag_key=context.getAttribute("flag_key").toString();//kiem tra la tra tai lieu sau khi search hay khonog
            }
            catch(Exception e){
                
            }
            if(flag_key.equals("false")){//chua search
                String tt=context.getAttribute("tt").toString();//tra lai tt, giu nguyen giao dien
                context.removeAttribute("tt");
                RequestDispatcher rd = request.getRequestDispatcher("trangchu_trasach.jsp?tt="+tt+"");//getparam o trang chu tra
                rd.forward(request, response);
            }
            if(flag_key.equals("true")){//da search
                request.setAttribute("search_mapm", context.getAttribute("mapm").toString());//tra mapm lai cho trang chu tra
                context.removeAttribute("mapm");
                //tra lai pm vi da search
                
                String tt=context.getAttribute("tt").toString();//nhu tren
                context.removeAttribute("tt");
                
                context.setAttribute("searched", "true");//tra lai search hay chua if-else trong trang chu tra
                RequestDispatcher rd = request.getRequestDispatcher("trangchu_trasach.jsp?tt="+tt+"");//nhu tren
                rd.forward(request, response);
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
