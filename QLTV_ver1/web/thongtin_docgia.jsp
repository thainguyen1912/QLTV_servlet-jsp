<%@page import="dao.db_connection"%>
<%@page import="dao.DocGia_DAO"%>
<%@page import="enity.DocGia"%>
<%
    db_connection db=new db_connection();
    DocGia_DAO dgdao=new DocGia_DAO(db);
    String maDocGia = session.getAttribute("user").toString();
    DocGia dg=dgdao.getOneDocGia(maDocGia);
    
    
    int soTaiLieuConDuocMuon=dg.getSoLuongTaiLieu() /*-  dgdao.getSoLuongTaiLieu(dg.getMaDocGia())*/;
    
    int SoTaiLieuQuaHan=dgdao.getSoTaiLieuQuaHan(dg.getMaDocGia());
    int SoNgayHetHan=dgdao.getSoNgayHetHan(dg.getMaDocGia());
    double soDuTaiKhoan=dg.getSoDuTaiKhoan();
    
    String colorNgayHetHan="";
    String colorSoTaiLieuConDuocMuon="";
    String colorSoTaiLieuQuaHan="";
    String colorSoDuTaiKhoan="";
    if(SoNgayHetHan > 0) colorNgayHetHan="color: red";
    if(soTaiLieuConDuocMuon <=0) colorSoTaiLieuConDuocMuon="color: red";
    if(SoTaiLieuQuaHan > 0) colorSoTaiLieuQuaHan="color: red";
    if(soDuTaiKhoan <= 0) colorSoDuTaiKhoan="color: red";
%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <%@ page contentType="text/html; charset=UTF-8" %>
        <title>Thông Tin Độc Giả</title>
        <jsp:include page="head.jsp" />
    </head>
    <body>
        <jsp:include page="title_readers.jsp" />
        <div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar">
            <jsp:include page="docgia_status.jsp" />
            <ul class="nav menu" style="margin: 0px">
                <li class="active table_hover"><a href="thongtin_docgia.jsp"><span class="glyphicon glyphicon-user"></span> Thông Tin Độc Giả</a></li>
                <li class="table_hover"><a href="suathongtin_docgia.jsp"><span class="glyphicon glyphicon-edit"></span> Sửa Thông Tin Độc Giả</a></li>
                <li class="table_hover"><a href="danhsach_tailieu_docgia.jsp"><span class="glyphicon glyphicon-list-alt"></span> Tài Liệu Đang Mượn</a></li>
                <li class="table_hover"><a href="docgia_naptaikhoan.jsp"><span class="glyphicon glyphicon-usd"></span> Nạp Tài Khoản</a></li>
                <li class="table_hover"><a  onclick="return xacNhan()" href="Logout_Servlet"><span class="glyphicon glyphicon-off"></span> Đăng Xuất</a></li>
            </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
            <div class="row">
                <ol class="breadcrumb">
                    <li><a href="thongtin_docgia.jsp">
                            <em class="fa fa-home"></em>
                        </a></li>
                    <li class="active">Thông Tin Độc Giả</li>
                </ol>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <h1 style="width: 40%; margin-left: 30%" class="page-header">Thông Tin Độc Giả</h1>
                </div>
            </div>
                <div style="overflow: auto; margin-left: 26%">
                    <div style="float: left">
                        <div style="margin: 20px">
                            Tên Độc Giả: <%=dg.getHoTen()%>
                        </div>
                        <div style="margin: 20px">
                            Giới Tính: <%=dg.getGioiTinh()==1?"Nam":"Nữ"%>
                        </div>
                        <div style="margin: 20px">
                            Ngày Sinh: <%=dg.getNgaySinh()%>
                        </div>
                        <div style="margin: 20px">
                            Đối Tượng: <%=dg.getDoiTuong()%>
                        </div>
                        <div style="margin: 20px">
                            Mật Khẩu: <%=dg.getMatKhau()%>
                        </div>
                        <div style="margin: 20px">
                            Ngày Cấp: <%=dg.getNgayCap()%>
                        </div>
                    </div>
                    <div style="float: left">
                        <div style="margin: 20px; <%=colorNgayHetHan %>">
                            Ngày Hết Hạn: <%=dg.getNgayHetHan()%>
                        </div>
                        <div style="margin: 20px; <%=colorSoTaiLieuConDuocMuon %>">
                            Số Quyển Sách Còn Được Mượn: <%=soTaiLieuConDuocMuon %>
                        </div>
                        <div style="margin: 20px; <%=colorSoTaiLieuQuaHan %>">
                            Số Tài Liệu Mượn Quá Hạn: <%=SoTaiLieuQuaHan %>
                        </div>
                        <div style="margin: 20px; <%=colorSoDuTaiKhoan %>">
                            Số Dư Tài Khoản: <%=soDuTaiKhoan %>
                        </div>
                    </div>
                </div>  
                <div style="float: left; margin-left: 41%; margin-top: 2%;">
                    <a href="suathongtin_docgia.jsp"><button style="background-color: #30a5ff;height: 31px;line-height: 2px;" type="submit" class="btn btn-info add-new"><span class="glyphicon glyphicon-pencil"></span>  Sửa Đổi Thông Tin</button></a>
                </div>
                
        </div>
    </body>
</html>