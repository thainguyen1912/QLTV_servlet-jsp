<%@page import="java.sql.ResultSet"%>
<%@page import="dao.PhieuMuonChiTiet_DAO"%>
<%@page import="dao.db_connection"%>
<%
    db_connection db = new db_connection();
    PhieuMuonChiTiet_DAO pmctdao = new PhieuMuonChiTiet_DAO(db);
    ResultSet rs = pmctdao.displayTLQuaHan();
    ResultSet rs_dstlm = pmctdao.DanhSachMatSach();//danh sach doc gia + tai lieu mat 
    String tt = "1";
    try {
        tt = request.getParameter("tt").toString();
    } catch (Exception e) {
    }
    ResultSet rs1 = pmctdao.displayTopTL(Integer.valueOf(tt));
%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <%@ page contentType="text/html; charset=UTF-8" %>
        <meta content="IE=edge" http-equiv="X-UA-Compatible">
        <meta name="author" content="John Uberbacher">
        <jsp:include page="head.jsp" />
    </head>
    <body>
        <div class="container">	
            <div class="tab-wrap" style="margin-left: 12%;width: 96%;">
                <input type="radio" id="tab1" name="tabGroup1" class="tab" checked>
                <label for="tab1">Tài Liệu Mượn Nhiều</label>
                <input type="radio" id="tab2" name="tabGroup1" class="tab">
                <label for="tab2">Tài Liệu Mượn Quá Hạn</label>
                <input type="radio" id="tab3" name="tabGroup1" class="tab">
                <label for="tab3">Độc Giả Và Tài Liệu Mất</label>
                <div class="tab__content">
                    <div class="row">
                        <div class="col-lg-12">
                            <h1 style=" margin-left: 26%; font-size: 32px" class="page-header">Danh Sách Tài Liệu Mượn Nhiều</h1>
                        </div>
                    </div>
                    <div>
                        <div>
                            <div style="float: left; width: 63%">
                                <select onchange="selectTT_main_tk_bc(this)" name="matlo" style="border: 1px solid #ddd; height: 34px;width: 14.2%;border-radius: 5px; margin-bottom: 10px;">
                                    <option value="1" <%=tt.equals("1") ? "selected" : ""%>>1  Ngày</option>
                                    <option value="7" <%=tt.equals("7") ? "selected" : ""%>>1  Tuần</option>
                                    <option value="30" <%=tt.equals("30") ? "selected" : ""%>>1  Tháng</option>
                                    <option value="365" <%=tt.equals("365") ? "selected" : ""%>>1  Năm</option>
                                    <option value="0" <%=tt.equals("0") ? "selected" : ""%>>Tất Cả</option>
                                </select>
                            </div>
                            <div style="float: right; margin-right: 1px">    
                                <a target="_blank" onclick="return search_check()" href="Export_Pdf?tt=<%=tt%>"><button style="background-color: #30a5ff" type="" class="btn btn-info add-new">
                                        <span class="fa fa-print mr-5"></span>In PDF
                                    </button></a>
                            </div>                        
                        </div>
                        <table class="table table-bordered" id="table" style="border-radius: 10px;border-style: double;">
                            <thead>
                                <tr>
                                    <th style="">Mã Tài Liệu</th>
                                    <th style="">Tên Tài Liệu</th>
                                    <th style="">Số Lần Đã Được Mượn</th>
                                    <th>Số Lượng Đã Được Mượn</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%while (rs1.next()) {%>
                                <tr>
                                    <td><%=rs1.getString("MaTaiLieu")%></td>
                                    <td><%=rs1.getString("TenTaiLieu")%></td>
                                    <td><%=rs1.getString("SoLanMuon")%></td>
                                    <td><%=rs1.getString("SoLuongMuon")%></td>
                                </tr>
                                <%}%>
                            </tbody>
                        </table>
                    </div>
                </div>
                <div class="tab__content">
                    <div class="row">
                        <div class="col-lg-12">
                            <h1 style=" margin-left: 26%; font-size: 32px" class="page-header">Danh Sách Tài Liệu Mượn Quá Hạn</h1>
                        </div>
                    </div>
                    <div style="float: right; margin-right: 1px;margin-bottom: 10px">    
                        <a target="_blank" onclick="return search_check()" href="Export_Pdf_QuaHan"><button style="background-color: #30a5ff" type="" class="btn btn-info add-new">
                                <span class="fa fa-print mr-5"></span>In PDF
                            </button></a>
                    </div> 
                    <table class="table table-bordered" id="table" style="border-radius: 10px;border-style: double;">
                        <thead>
                            <tr>
                                <th style="">Mã Đôc Giả</th>
                                <th style="">Tên Độc Giả</th>
                                <th style="">Mã Phiếu Mượn</th>
                                <th>Tên Tài Liệu</th>
                                <th>Số Lượng Mượn</th>
                                <th>Ngày Mượn</th>
                                <th style="">Số Ngày Quá Hạn</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%while (rs.next()) {%>
                            <tr>
                                <td><%=rs.getString("MaDocGia")%></td>
                                <td><%=rs.getString("HoTen")%></td>
                                <td><%=rs.getString("MaPhieuMuon")%></td>
                                <td><%=rs.getString("TenTaiLieu")%></td>
                                <td><%=rs.getString("SoluongMuon")%></td>
                                <td><%=rs.getString("NgayMuon")%></td>
                                <td><%=rs.getString("SoNgayQuaHan")%></td>
                            </tr>
                            <%}%>
                        </tbody>
                    </table>
                </div>
                        
                <div class="tab__content">
                    <div class="row">
                        <div class="col-lg-12">
                            <h1 style=" margin-left: 26%; font-size: 32px" class="page-header">Danh Sách Độc Giả Và Tài Liệu Bị Mất</h1>
                        </div>
                    </div>
                    <div style="float: right; margin-right: 1px;margin-bottom: 10px">    
                        <a target="_blank" onclick="return search_check()" href="Export_DGTLMat"><button style="background-color: #30a5ff" type="" class="btn btn-info add-new">
                                <span class="fa fa-print mr-5"></span>In PDF
                            </button></a>
                    </div> 
                    <table class="table table-bordered" id="table" style="border-radius: 10px;border-style: double;">
                        <thead>
                            <tr>
                                <th style="">Mã Đôc Giả</th>
                                <th style="">Tên Độc Giả</th>
                                <th style="">Mã Tài Liệu</th>
                                <th>Tên Tài Liệu</th>
                                <th>Giá Tiền</th>
                                <th>Số Lượng Mất</th>
                                <th>Ngày Báo Mất</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%while (rs_dstlm.next()) {%>
                            <tr>
                                <td><%=rs_dstlm.getString("MaDocGia")%></td>
                                <td><%=rs_dstlm.getString("HoTen")%></td>
                                <td><%=rs_dstlm.getString("MaTaiLieu")%></td>
                                <td><%=rs_dstlm.getString("TenTaiLieu")%></td>
                                <td><%=rs_dstlm.getString("GiaTien")%></td>
                                <td><%=rs_dstlm.getString("SoLuongMat")%></td>
                                <td><%=rs_dstlm.getString("NgayTra")%></td>
                            </tr>
                            <%}%>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>	
    </body>