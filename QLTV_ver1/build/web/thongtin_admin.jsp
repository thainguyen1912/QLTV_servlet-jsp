<%@page import="enity.NhanVien"%>
<%@page import="dao.NhanVien_DAO"%>
<%@page import="dao.db_connection"%>
<%@page import="dao.DocGia_DAO"%>
<%@page import="enity.DocGia"%>
<%
    db_connection db=new db_connection();
    NhanVien_DAO nvdao=new NhanVien_DAO(db);
    String maNhanVien = session.getAttribute("user").toString();
    NhanVien nv=nvdao.getOneNhanVien(maNhanVien);
    
%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <%@ page contentType="text/html; charset=UTF-8" %>
        <title>Thông Tin Admin</title>
        <jsp:include page="head.jsp" />
    </head>
    <body>
        <jsp:include page="title_admin.jsp" />
        <div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar">
            <jsp:include page="user_status.jsp" />
            <ul class="nav menu" style="margin: 0px">
                <li class="active table_hover"><a href="thongtin_admin.jsp"><span class="glyphicon glyphicon-user"></span> Thông Tin Cá Nhân</a></li>
                <li class="table_hover"><a href="suathongtin_admin.jsp"><span class="glyphicon glyphicon-pencil"></span> Sửa Thông Tin Cá Nhân</a></li>
                <li class="table_hover"><a href="TheLoai_Servlet"><span class="glyphicon glyphicon-th-list"></span> Quản Lý Thể Loại</a></li>
                <li class="table_hover"><a href="TaiLieu_Servlet"><span class="glyphicon glyphicon-book"></span> Quản Lý Tài Liệu</a></li>
                <li class="table_hover"><a href="NhanVien_Servlet"><span class="glyphicon glyphicon-briefcase"></span> Quản Lý Nhân Viên</a></li>
                <li class="table_hover"><a href="DocGia_Servlet"><span class="glyphicon glyphicon-education"></span> Quản Lý Độc Giả</a></li>
                <li class="table_hover"><a  onclick="return xacNhan()" href="Logout_Servlet"><span class="glyphicon glyphicon-off"></span> Đăng Xuất</a></li>
            </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
            <div class="row">
                <ol class="breadcrumb">
                    <li><a href="thongtin_docgia.jsp">
                            <em class="fa fa-home"></em>
                        </a></li>
                    <li class="active">Thông Tin Admin</li>
                </ol>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <h1 style="width: 40%; margin-left: 30%" class="page-header">Thông Tin Admin</h1>
                </div>
            </div>
                <div style="overflow: auto; margin-left: 30%">
                    <div style="float: left">
                        <div style="margin: 20px">
                            Mã Nhân Viên:&emsp; <%=nv.getMaNhanVien() %>
                        </div>
                        <div style="margin: 20px">
                            Tên Nhân Viên:&emsp; <%=nv.getHoTen() %>
                        </div>
                        <div style="margin: 20px">
                            Chức Vụ:&emsp; <%=nv.getChucVu() %>
                        </div>
                        <div style="margin: 20px">
                            Tài Khoản:&emsp; <%=nv.getTaiKhoan() %>
                        </div>
                        <div style="margin: 20px">
                            Mật Khẩu:&emsp; <%=nv.getMatKhau() %>
                        </div>
                        <div style="margin: 20px">
                            Quyền:&emsp; <%=nv.getQuyen() %>
                        </div>
                    </div>
                </div>  
                <div style="float: left; margin-left: 39%; margin-top: 2%;">
                    <a href="suathongtin_admin.jsp">
                        <button style="background-color: #30a5ff;height: 31px;line-height: 2px;" type="submit" class="btn btn-info add-new">
                            <span class="glyphicon glyphicon-pencil"></span>  Sửa Đổi Thông Tin
                        </button>
                    </a>
                </div>
                
        </div>
    </body>
</html>