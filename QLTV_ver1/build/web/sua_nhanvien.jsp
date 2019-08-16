<%@page import="dao.NhanVien_DAO"%>
<%@page import="dao.db_connection"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <%@ page contentType="text/html; charset=UTF-8" %>
        <title>Sửa Nhân Viên</title>
        <jsp:include page="head.jsp" />
    </head>
    <body>
        <jsp:include page="title_admin.jsp" />
        <div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar">
            <jsp:include page="user_status.jsp" />
            <ul class="nav menu" style="margin: 0px">
                <li class="active table_hover"><a><em class="fa fa-dashboard">&nbsp;</em>Sửa Nhân Viên</a></li>
            </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
            <div class="row">
                <ol class="breadcrumb">
                    <li><a href="NhanVien_Servlet">
                            <em class="fa fa-home"></em>
                        </a></li>
                    <li class="active">Quản Lý Nhân Viên / Sửa Nhân Viên</li>
                </ol>
            </div>
            <div class="container" style="width: 1100px">
                <div class="table-wrapper" >
                    <div class="table-title">
                        <div class="row">
                            <div class="row">
                                <div class="col-lg-12">
                                    <h1 style="margin-bottom: 5px" class="page-header">Sửa Nhân Viên</h1>
                                </div>
                            </div>
                            <form action="Manager_NhanVien_Servlet" onsubmit="return xacNhan()">
                                <table class="table table-bordered table_hover" style="border-radius:14px;border-style: hidden ">
                                    <thead>
                                        <tr>
                                            <th>Mã Nhân Viên</th>
                                            <th>Họ Tên</th>
                                            <th style="width: 130px">Chức Vụ</th>
                                            <th>Tài Khoản</th>
                                            <th>Mật Khẩu</th>
                                            <th style="width: 110px">Quyền</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td><input type="text" class="form-control" name="manv" id="manv" value="<%=request.getParameter("manv")%>" readonly="true"></td>
                                            <td><input type="text" class="form-control" name="hoten" id="hoten" value="<%=request.getParameter("hoten")%>" required></td>
                                                <%
                                                    String chucvu = request.getParameter("chucvu");
                                                    String quyen = request.getParameter("quyen");
                                                %>
                                            <td>
                                                <select name="chucvu" style="border: 1px solid #ddd; height: 46px;width: 100%;border-radius: 5px">
                                                    <option <%=chucvu.equals("Giảng Viên") ? "selected" : ""%>>Giảng Viên</option>
                                                    <option <%=chucvu.equals("Kế Toán") ? "selected" : ""%>>Kế Toán</option>
                                                </select> 
                                            </td>
                                            <td><input type="text" class="form-control" name="taikhoan" id="taikhoan" value="<%=request.getParameter("taikhoan")%>" required></td>
                                            <td><input type="text" class="form-control" name="matkhau" id="matkhau" value="<%=request.getParameter("matkhau")%>" required></td>
                                            <td>
                                                <select name="quyen" style="border: 1px solid #ddd; height: 46px;width: 100%;border-radius: 5px">
                                                    <option <%=quyen.equals("Admin") ? "selected" : ""%>>Admin</option>
                                                    <option <%=quyen.equals("Thủ Thư") ? "selected" : ""%>>Thủ Thư</option>
                                                </select> 
                                            </td>
                                        </tr> 
                                    </tbody>
                                </table>    
                                <div class="col-sm-4" style="margin-left: 17%; float: left">
                                    <a href="NhanVien_Servlet"><button style="background-color: #30a5ff;border-radius: 40px;" type="button" class="btn btn-info add-new"><span class="glyphicon glyphicon-menu-left"></span> Quay Lại</button></a>
                                </div>
                                <div class="col-sm-4" style="margin-left: 0%; float: left; width: 12%">
                                    <a><button style="background-color: #30a5ff;border-radius: 40px;" type="submit" class="btn btn-info add-new"><span class="glyphicon glyphicon-pencil"></span> Sửa Đổi</button></a>
                                </div>
                            </form>
                            <%ServletContext context = getServletContext();
                                context.setAttribute("context", "edit_nv");
                            %>                      
                        </div>
                    </div>
                </div>
            </div>  
        </div>	
    </body>
</html>