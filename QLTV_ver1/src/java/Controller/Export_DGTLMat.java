/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import dao.PhieuMuonChiTiet_DAO;
import dao.db_connection;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author thain
 */
public class Export_DGTLMat extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/pdf;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        OutputStream out=response.getOutputStream();
        Calendar cl = Calendar.getInstance();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String dateNow =sdf.format(cl.getTime()).toString();
        try{
            try{
                Document doc = new Document(PageSize.A5.rotate(), 10f, 10f, 100f, 0f);
                PdfWriter.getInstance(doc, out);
                doc.open();
                Paragraph para=new Paragraph();
                
                BaseFont bf1 = BaseFont.createFont("D:\\E\\netbean_workspace\\netbean_jsp-sevlet\\QLTV_servlet-jsp\\QLTV_ver1\\web\\ttf\\arrusb.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
                BaseFont bf2 = BaseFont.createFont("D:\\E\\netbean_workspace\\netbean_jsp-sevlet\\QLTV_servlet-jsp\\QLTV_ver1\\web\\ttf\\UVNHuongQue_R.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
                BaseFont bf3 = BaseFont.createFont("D:\\E\\netbean_workspace\\netbean_jsp-sevlet\\QLTV_servlet-jsp\\QLTV_ver1\\web\\ttf\\UVNSaigon_R.TTF", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
                
                
                Font font1=new Font(Font.FontFamily.TIMES_ROMAN,16,Font.NORMAL);
                Font font2=new Font(Font.FontFamily.TIMES_ROMAN,12,Font.NORMAL);
                para.add(new Phrase("Danh Sách Thống Kê Độc Giả Và Tài Liệu Bị Mất", new Font(bf1,20)));
                para.add(new Phrase(Chunk.NEWLINE));
                para.add(new Phrase("Ngày "+ dateNow, new Font(bf1,12)));
                para.add(new Phrase(Chunk.NEWLINE));
                para.add(new Phrase("-----------------------------------------------", font1));
                para.setAlignment(Element.ALIGN_CENTER);
                para.add(new Phrase(Chunk.NEWLINE));
                para.add(new Phrase(Chunk.NEWLINE));
                doc.add(para);
                PdfPTable table=new PdfPTable(7);
                table.setWidthPercentage(100);
                PdfPCell cell1=new PdfPCell(new Paragraph("Mã Độc Giả", new Font(bf1, 12)));
                table.addCell(cell1);
                PdfPCell cell2=new PdfPCell(new Paragraph("Tên Độc Giả", new Font(bf1, 12)));
                table.addCell(cell2);
                PdfPCell cell3=new PdfPCell(new Paragraph("Mã Tài Liệu", new Font(bf1, 12)));
                table.addCell(cell3);
                PdfPCell cell4=new PdfPCell(new Paragraph("Tên Tài Liệu", new Font(bf1, 12)));
                table.addCell(cell4);
                PdfPCell cell5=new PdfPCell(new Paragraph("Giá Tiền", new Font(bf1, 12)));
                table.addCell(cell5);
                PdfPCell cell6=new PdfPCell(new Paragraph("Số Lượng Mất", new Font(bf1, 12)));
                table.addCell(cell6);
                PdfPCell cell7=new PdfPCell(new Paragraph("Ngày Báo Mất", new Font(bf1, 12)));
                table.addCell(cell7);
                db_connection db=new db_connection();
                PhieuMuonChiTiet_DAO pmctdao=new PhieuMuonChiTiet_DAO(db);
                ResultSet rs=pmctdao.DanhSachMatSach();
                while(rs.next()){
                    table.addCell(new PdfPCell(new Paragraph(rs.getString(1).toString(), new Font(bf3,12))));
                    table.addCell(new PdfPCell(new Paragraph(rs.getString(2).toString(), new Font(bf3,12))));
                    table.addCell(new PdfPCell(new Paragraph(rs.getString(3).toString(), new Font(bf3,12))));
                    table.addCell(new PdfPCell(new Paragraph(rs.getString(4).toString(), new Font(bf3,12))));
                    table.addCell(new PdfPCell(new Paragraph(rs.getString(5).toString(), new Font(bf3,12))));
                    table.addCell(new PdfPCell(new Paragraph(rs.getString(6).toString(), new Font(bf3,12))));
                    table.addCell(new PdfPCell(new Paragraph(rs.getString(7).toString(), new Font(bf3,12))));
                    
                }
                doc.add(table);
                Paragraph para1=new Paragraph();
                para1.add(new Phrase(Chunk.NEWLINE));
                para1.add(new Phrase("                                                                                                                                     Thủ Thư Ký Tên  ", new Font(bf3, 10)));
                doc.add(para1);
                doc.close();
            }
            catch(Exception e ){
                e.printStackTrace();
            }
        }
        finally{
            out.close();
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
