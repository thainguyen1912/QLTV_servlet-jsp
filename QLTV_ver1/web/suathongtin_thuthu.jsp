<%@page import="enity.NhanVien"%>
<%@page import="dao.DocGia_DAO"%>
<%@page import="java.sql.Date"%>
<%@page import="enity.DocGia"%>
<%@page import="dao.NhanVien_DAO"%>
<%@page import="dao.db_connection"%>
<%@page import="java.util.ArrayList"%>
<%request.setCharacterEncoding("UTF-8");%>
<%
    ServletContext context = getServletContext();
    context.setAttribute("key", "edit_detail");
    db_connection db = new db_connection();
    NhanVien_DAO nvdao = new NhanVien_DAO(db);
    NhanVien nv = nvdao.getOneNhanVien(session.getAttribute("user").toString());
%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <%@ page contentType="text/html; charset=UTF-8" %>
        <title>Sửa Thông Tin Admin</title>
        <jsp:include page="head.jsp" />
    </head>
    <body>
        <jsp:include page="title_readers.jsp" />
        <div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar">
            <jsp:include page="user_status.jsp" />
            <ul class="nav menu" style="margin: 0px">
                <li class="table_hover"><a href="thongtin_thuthu.jsp"><span class="glyphicon glyphicon-user"></span> Thông Tin Cá Nhân</a></li>
                <li class="active table_hover"><a href="suathongtin_thuthu.jsp"><span class="glyphicon glyphicon-pencil"></span> Sửa Thông Tin Cá Nhân</a></li>
                <li class="table_hover"><a href="muonsach_madocgia.jsp"><span class="glyphicon glyphicon-tasks"></span> Quản Lý Mượn Sách</a></li>
                <li class="table_hover"><a href="trasach_madocgia.jsp"><span class="glyphicon glyphicon-transfer"></span> Quản Lý Trả Sách</a></li>
                <li class="table_hover"><a href="thongke_baocao.jsp"><span class="glyphicon glyphicon-indent-right"></span> Thống Kê, Báo Cáo</a></li>
                <li class="table_hover"><a  onclick="return xacNhan()" href="Logout_Servlet"><span class="glyphicon glyphicon-off"></span> Đăng Xuất</a></li>
            </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
            <div class="row">
                <ol class="breadcrumb">
                    <li><a href="suathongtin_docgia.jsp">
                            <em class="fa fa-home"></em>
                        </a></li>
                    <li class="active">Sửa Thông Tin Thủ Thư</li>
                </ol>
            </div>
            <div class="container" style="width: 1100px">
                <div class="table-wrapper" >
                    <div class="table-title">
                        <div class="row">
                            <div class="row">
                                <div class="col-lg-12">
                                    <h1 style="margin-bottom: 5px" class="page-header">Sửa Thông Tin Thủ Thư</h1>
                                </div>
                            </div>
                            <form action="ThongTin_ThuThu_Servlet" onsubmit="return xacNhan()">
                                <table class="table table-bordered table_hover" style="border-radius:14px;border-style: hidden;">
                                    <thead>
                                        <tr>
                                            <th>Thông Tin</th>
                                            <th style="width: 60%">Điền Thông Tin</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td>
                                                Họ Tên
                                            </td>
                                            <td>
                                                <input
                                                    type="text" class="form-control" name="hoten" id="hoten"
                                                    value="<%=nv.getHoTen()%>" required
                                                    >
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                Chức Vụ
                                            </td>
                                            <td>
                                                <select name="chucvu" style="border: 1px solid #ddd; height: 46px;width: 100%;border-radius: 5px;">
                                                    <option value="Giảng Viên" <%=nv.getChucVu().equals("Giảng Viên")? "selected" : ""%>>Giảng Viên</option>
                                                    <option value="Kế Toán" <%=nv.getChucVu().equals("Kế Toán")? "selected" : ""%>>Kế Toán</option>
                                                </select> 
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                Tài Khoản
                                            </td>
                                            <td>
                                                <input
                                                    type="text" class="form-control" name="taikhoan" id="ngaysinh"
                                                    value="<%=nv.getTaiKhoan()%>"
                                                    required
                                                >
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                Mật Khẩu
                                            </td>
                                            <td>
                                                <input
                                                    type="text" class="form-control" name="matkhau" id="matkhau"
                                                    value="<%=nv.getMatKhau() %>" required
                                                    >
                                            </td>
                                        </tr>
                                    </tbody>
                                </table>    
                                <div class="col-sm-4" style="margin-left: 26%">
                                    <a>
                                        <button style="background-color: #30a5ff;border-radius: 40px;" type="submit" class="btn btn-info add-new">
                                            <span class="glyphicon glyphicon-ok"></span> Cập Nhật
                                        </button>
                                    </a>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>  
        </div>	
    </body>
</html>