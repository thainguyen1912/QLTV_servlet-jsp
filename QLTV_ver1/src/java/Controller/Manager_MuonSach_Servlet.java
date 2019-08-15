/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import dao.DocGia_DAO;
import dao.TaiLieu_DAO;
import dao.db_connection;
import enity.DocGia;
import enity.TaiLieuMuon;
import java.io.IOException;
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
public class Manager_MuonSach_Servlet extends HttpServlet {

    db_connection db = new db_connection();
    TaiLieu_DAO tldao = new TaiLieu_DAO(db);
    DocGia_DAO dgdao=new DocGia_DAO(db);
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        ServletContext context = getServletContext();
        String hanhdong = "";
        DocGia docGia=(DocGia)context.getAttribute("docgia");
        hanhdong = context.getAttribute("hanhdong").toString();

        if (hanhdong.equals("themtailieu")) {
            String matl = request.getParameter("matl");
            String tentl = tldao.getTenTL(matl);
            int slmuon = Integer.valueOf(request.getParameter("slmuon"));
            double giaTien = Double.valueOf(request.getParameter("giatien"));
            ArrayList<TaiLieuMuon> list_tlm = (ArrayList<TaiLieuMuon>) context.getAttribute("list_tlm");
            boolean check = true;
            for (TaiLieuMuon tlm : list_tlm) {
                if (tlm.getMaTaiLieu().equals(matl)) {
                    check = false;
                }
            }
            if (check == false) {
                request.setAttribute("mess_choosed", "Tài Liệu này đã được chọn. Xin vui lòng chọn tài liệu khác");
                RequestDispatcher rd = request.getRequestDispatcher("muonsach_themtailieu.jsp");
                rd.forward(request, response);
            } else {
                int soLuongMoiTaiLieuConDuocMuon=docGia.getSoLuongMoiTaiLieu() - dgdao.getSoLuongMoiTaiLieuDuocMuon(docGia.getMaDocGia(), matl);
                if(soLuongMoiTaiLieuConDuocMuon <= 0){
                    String slmtl=String.valueOf(docGia.getSoLuongMoiTaiLieu());
                    String mess="Tài Liệu này đã đến giới hạn mượn là: " + slmtl +" . Bạn không thể mượn thêm. Xin vui lòng chọn tài liệu khác";
                    request.setAttribute("mess_over", mess);
                    RequestDispatcher rd = request.getRequestDispatcher("muonsach_themtailieu.jsp");
                    rd.forward(request, response);
                } 
                else{
                    if(giaTien * slmuon > Double.valueOf(context.getAttribute("sodu").toString())){
                        request.setAttribute("mess_money", "Số dư tài khoản không đủ để đăng ký mượn tài liệu này. Hãy thử giảm bớt số lượng mượn hoặc đăng ký mượn tài liệu khác");
                        RequestDispatcher rd = request.getRequestDispatcher("muonsach_themtailieu.jsp");
                        rd.forward(request, response);
                    }
                    else{
                        double soDuBanDau=Double.valueOf(context.getAttribute("sodu").toString());
                        context.setAttribute("sodu", soDuBanDau - giaTien * slmuon);
                        TaiLieuMuon tlm = new TaiLieuMuon(matl, tentl, slmuon, giaTien);
                        list_tlm.add(tlm);
                        double tongTien=Double.valueOf(context.getAttribute("tongtien").toString());
                        context.setAttribute("tongtien", tongTien+giaTien*slmuon);
                        request.setAttribute("tlm", list_tlm);
                        int soTaiLieuConDuocMuon=Integer.valueOf(context.getAttribute("stlcdm").toString());
                        context.setAttribute("stlcdm", soTaiLieuConDuocMuon - slmuon);
                        RequestDispatcher rd = request.getRequestDispatcher("trangchu_muonsach.jsp");
                        rd.forward(request, response);
                    }
                }
            }
        }
        
        if (hanhdong.equals("xoatailieu")) {
            ArrayList<TaiLieuMuon> list_tlm = (ArrayList<TaiLieuMuon>) context.getAttribute("list_tlm");
            for (int i = 0; i < list_tlm.size(); i++) {
                if (list_tlm.get(i).getMaTaiLieu().equals(request.getParameter("xoatlm"))) {
                    double tongTien=(Double)context.getAttribute("tongtien");
                    context.setAttribute("tongtien", tongTien-(list_tlm.get(i).getGiaTien() *list_tlm.get(i).getSoLuong()));
                    
                    int stlcdm=(int)context.getAttribute("stlcdm");
                    context.setAttribute("stlcdm", stlcdm + Integer.valueOf(request.getParameter("slm")));
                    
                    double soDu=(double)context.getAttribute("sodu");
                    context.setAttribute("sodu", soDu + Integer.valueOf(request.getParameter("slm")) * Double.valueOf(request.getParameter("giaTien")));
                    
                    list_tlm.remove(i);
                }
            }
            request.setAttribute("tlm", list_tlm);
            RequestDispatcher rd = request.getRequestDispatcher("trangchu_muonsach.jsp");
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
