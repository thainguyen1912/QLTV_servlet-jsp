<%@page import="dao.db_connection"%>
<%@page import="dao.DocGia_DAO"%>
<%@page import="enity.DocGia"%>
<%
    db_connection db=new db_connection();
    ServletContext context = getServletContext();
    DocGia dg=(DocGia)context.getAttribute("docgia");
    DocGia_DAO dgdao=new DocGia_DAO(db);
    
    int soTaiLieuConDuocMuon=dg.getSoLuongTaiLieu() /*-  dgdao.getSoLuongTaiLieu(dg.getMaDocGia())*/;
    
    int SoTaiLieuQuaHan=dgdao.getSoTaiLieuQuaHan(dg.getMaDocGia());
    int SoNgayHetHan=dgdao.getSoNgayHetHan(dg.getMaDocGia());
    double soDuTaiKhoan=dg.getSoDuTaiKhoan();
    String disabled="";
    if(soTaiLieuConDuocMuon<=0 || SoTaiLieuQuaHan >0 ||  SoNgayHetHan > 0 || soDuTaiKhoan <=0){
        disabled="display: none";
    }
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
        <title>Quản Lý Mượn Sách</title>
        <jsp:include page="head.jsp" />
    </head>
    <body>
        <jsp:include page="title_librarian.jsp" />
        <div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar">
            <jsp:include page="user_status.jsp" />
            <ul class="nav menu" style="margin: 0px">
                <li class="table_hover"><a href="thongtin_thuthu.jsp"><span class="glyphicon glyphicon-user"></span> Thông Tin Cá Nhân</a></li>
                <li class="table_hover"><a href="suathongtin_thuthu.jsp"><span class="glyphicon glyphicon-pencil"></span> Sửa Thông Tin Cá Nhân</a></li>
                <li class="active table_hover"><a href="muonsach_madocgia.jsp"><span class="glyphicon glyphicon-tasks"></span> Quản Lý Mượn Sách</a></li>
                <li class="table_hover"><a href="trasach_madocgia.jsp"><span class="glyphicon glyphicon-transfer"></span> Quản Lý Trả Sách</a></li>
                <li class="table_hover"><a href="thongke_baocao.jsp"><span class="glyphicon glyphicon-indent-right"></span> Thống Kê, Báo Cáo</a></li>
                <li class="table_hover"><a  onclick="return xacNhan()" href="Logout_Servlet"><span class="glyphicon glyphicon-off"></span> Đăng Xuất</a></li>
            </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
            <div class="row">
                <ol class="breadcrumb">
                    <li><a href="muonsach_madocgia.jsp">
                            <em class="fa fa-home"></em>
                        </a></li>
                    <li class="active">Quản Lý Mượn Sách</li>
                </ol>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <h1 style="width: 40%; margin-left: 30%" class="page-header">Quản Lý Mượn Sách</h1>
                </div>
            </div>
            <form action="Check_DocGia_Servlet">
                <div style="margin-left: 31%">
                    <div style="overflow: auto;margin-bottom: 8px;">
                        <p style="float: left; margin: 6px; font-size: 16px">Mã Độc Giả</p>
                        <input value="<%=dg.getMaDocGia() %>" id="madg" name="madg" style="width: 174px; border-style: groove;border-radius: 4px;height: 32px;float: left" type="text" placeholder=" search here.." required>
                        <div style="float: left; margin-left: 10px">
                            <a><button style="height: 31px;line-height: 2px;" type="submit" class="btn btn-primary"><span class="fa fa-search"></span>  Kiểm Tra</button></a>
                        </div>
                    </div>
                    <div style="clear: both; margin-left: 13.5%"><p style="color: deeppink;"> <%= (request.getAttribute("mess") == null ? "" : request.getAttribute("mess"))%></p></div>
                </div>
            </form>
                <div style="overflow: auto; margin-left: 30%">
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
                <div style="float: left; margin-left: 72.5%; margin-top: 2%; <%=disabled %>">
                    <a href="trangchu_muonsach.jsp">
                        <button style="background-color: #30a5ff;height: 31px;line-height: 2px;" type="submit" class="btn btn-info add-new">
                            Xác Nhận <span class="glyphicon glyphicon-chevron-right"></span>
                        </button>
                    </a>
                </div>
                
        </div>
    </body>
</html>