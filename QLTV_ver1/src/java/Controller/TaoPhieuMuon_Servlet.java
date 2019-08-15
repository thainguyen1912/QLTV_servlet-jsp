/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import dao.DocGia_DAO;
import dao.PhieuMuonChiTiet_DAO;
import dao.PhieuMuon_DAO;
import dao.TaiLieu_DAO;
import dao.db_connection;
import enity.PhieuMuon;
import enity.PhieuMuonChiTiet;
import enity.TaiLieuMuon;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
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
public class TaoPhieuMuon_Servlet extends HttpServlet {

    db_connection db=new db_connection();
    TaiLieu_DAO tldao=new TaiLieu_DAO(db);
    PhieuMuon_DAO pmdao=new PhieuMuon_DAO(db);
    PhieuMuonChiTiet_DAO pmctdao=new PhieuMuonChiTiet_DAO(db);
    DocGia_DAO dgdao=new DocGia_DAO(db);
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        ServletContext context = getServletContext();
        ArrayList<TaiLieuMuon> list_tlm = (ArrayList<TaiLieuMuon>) context.getAttribute("list_tlm");
        System.out.println(list_tlm.size());
        if(list_tlm.size()>=1){
            String mapm=request.getParameter("mapm");
            String madg=request.getParameter("madg");
            String manv=request.getParameter("manv");
            String date=request.getParameter("ngaymuon");
            Date datenow=Date.valueOf(date);
            PhieuMuon pm=new PhieuMuon(mapm, madg, datenow, manv);
            pmdao.add_PhieuMuon(pm);
            for(int i=0;i<list_tlm.size();i++){
                PhieuMuonChiTiet pmct=new PhieuMuonChiTiet(mapm, list_tlm.get(i).getMaTaiLieu(), list_tlm.get(i).getSoLuong(), 0);
                pmctdao.add_PhieuMuonChiTiet(pmct);
                int slcon=tldao.getSoLuongCon(list_tlm.get(i).getMaTaiLieu());
                tldao.update_slTaiLieu(list_tlm.get(i).getMaTaiLieu(), slcon-list_tlm.get(i).getSoLuong());
            }
            int stlcdm=Integer.valueOf(context.getAttribute("stlcdm").toString());
            double soDu=Double.valueOf(context.getAttribute("sodu").toString());
            dgdao.update_SoLuongTaiLieu_SoDuTaiKhoan(stlcdm, soDu, madg);
            list_tlm.clear();
            context.setAttribute("list_tlm", list_tlm);
//            response.sendRedirect("trangchu_muonsach.jsp");
            request.setAttribute("mapm", mapm);
            RequestDispatcher rd=request.getRequestDispatcher("Export_TaoPhieuMuon_Servlet");
            rd.forward(request, response);
            
        }
        else{
            request.setAttribute("save_err", "Bạn chưa đăng ký mượn tài liệu nào. Xin kiểm tra lại!");
            RequestDispatcher rd=request.getRequestDispatcher("trangchu_muonsach.jsp");
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
