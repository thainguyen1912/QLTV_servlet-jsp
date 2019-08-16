<%@page import="dao.PhieuMuonChiTiet_DAO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="enity.TaiLieu"%>
<%@page import="enity.DocGia"%>
<%@page import="dao.DocGia_DAO"%>
<%@page import="dao.db_connection"%>
<%@page import="java.util.ArrayList"%>
<%
    db_connection db=new db_connection();
    DocGia_DAO dgdao=new DocGia_DAO(db);
    String maDocGia = session.getAttribute("user").toString();
    DocGia dg=dgdao.getOneDocGia(maDocGia);
    PhieuMuonChiTiet_DAO pmctdao=new PhieuMuonChiTiet_DAO(db);
    ResultSet rs=null;
    rs = pmctdao.display_ChuaTra(maDocGia);//fill in rs
    double tongTienMuon=0;
%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <%@ page contentType="text/html; charset=UTF-8" %>
        <title>Tài Liệu Đang Mượn</title>
        <jsp:include page="head.jsp" />
    </head>
    <body>
            
        <jsp:include page="title_readers.jsp" />
        <div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar">
            <jsp:include page="docgia_status.jsp" />
            <ul class="nav menu" style="margin: 0px">
                <li class="table_hover"><a href="thongtin_docgia.jsp"><span class="glyphicon glyphicon-user"></span> Thông Tin Độc Giả</a></li>
                <li class="table_hover"><a href="suathongtin_docgia.jsp"><span class="glyphicon glyphicon-edit"></span> Sửa Thông Tin Độc Giả</a></li>
                <li class="active table_hover"><a href="danhsach_tailieu_docgia.jsp"><span class="glyphicon glyphicon-list-alt"></span> Tài Liệu Đang Mượn</a></li>
                <li class="table_hover"><a href="docgia_naptaikhoan.jsp"><span class="glyphicon glyphicon-usd"></span> Nạp Tài Khoản</a></li>
                <li class="table_hover"><a  onclick="return xacNhan()" href="Logout_Servlet"><span class="glyphicon glyphicon-off"></span> Đăng Xuất</a></li>
            </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
            <div class="row">
                <ol class="breadcrumb">
                    <li><a href="TaiLieu_Servlet">
                            <em class="fa fa-home"></em>
                        </a></li>
                    <li class="active">Tài Liệu Đang Mượn</li>
                </ol>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <h1 style="width: 60%; margin-left: 22%" class="page-header">Danh Sách Tài Liệu Đang Mượn</h1>
                </div>
            </div>
        </div>
        <div class="container" style="margin-left: 226px; width: 1100px">
            <div class="table-wrapper">
                
                <table class="table table-bordered table_hover" id="table" style="border-radius:14px;border-style: hidden ">
                    <thead>
                            <tr>
                                <th style="">Mã Phiếu Mượn</th>
                                <th style="">Mã Tài Liệu</th>
                                <th>Tên Tài Liệu</th>
                                <th style="width: 90px">Số Lượng Mượn</th>
                                <th style="">Giá Tiền</th>
                                <th style="">Ngày Mượn</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%while (rs.next()) {%>
                            <tr>
                                <td><%=rs.getString("MaPhieuMuon")%></td>
                                <td><%=rs.getString("MaTaiLieu")%></td>
                                <td><%=rs.getString("TenTaiLieu")%></td>
                                <td><%=rs.getString("SoluongMuon")%></td>
                                <td><%=rs.getString("GiaTien")%></td>
                                <td><%=rs.getString("NgayMuon")%></td>
                                <%
                                    tongTienMuon+=Double.valueOf(rs.getString("GiaTien")) * Integer.valueOf(rs.getString("SoLuongMuon").toString());
                                %>
                            </tr>
                            <%}%>
                        </tbody>
                </table>
                    <div style="margin-left: 1%">
                        Tổng Tiền Đang Mượn:&emsp;<%=tongTienMuon  %>
                        
                    </div>
            </div>
        </div> 
    </body>
</html>
