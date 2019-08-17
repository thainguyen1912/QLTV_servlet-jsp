/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

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
public class Cancel_Edit_TaiLieuMuon_Servlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        ServletContext context = getServletContext();
        ArrayList<TaiLieuMuon> list_tlm = (ArrayList<TaiLieuMuon>) context.getAttribute("list_tlm");
        
        int cancel_stlcdm =Integer.valueOf(context.getAttribute("cancel_stlcdm").toString());
        double cancel_tongtien =Double.valueOf(context.getAttribute("cancel_tongtien").toString());
        double cancel_sodu = Double.valueOf(context.getAttribute("cancel_sodu").toString());
        String cancel_matlm = context.getAttribute("cancel_matlm").toString();
        String cancel_tentlm = context.getAttribute("cancel_tentlm").toString();
        int cancel_slm =Integer.valueOf(context.getAttribute("cancel_slm").toString());
        double cancel_giatien = Double.valueOf(context.getAttribute("cancel_giatien").toString());
        
        context.setAttribute("tongtien", cancel_tongtien);
        context.setAttribute("stlcdm", cancel_stlcdm);
        context.setAttribute("sodu", cancel_sodu);
        
        TaiLieuMuon tlm = new TaiLieuMuon(cancel_matlm, cancel_tentlm, cancel_slm, cancel_giatien);
        list_tlm.add(tlm);
        context.setAttribute("list_tlm", list_tlm);
        RequestDispatcher rd = request.getRequestDispatcher("trangchu_muonsach.jsp");
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
