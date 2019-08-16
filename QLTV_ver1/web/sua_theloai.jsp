<%@page import="dao.db_connection"%>
<%@page import="dao.TheLoai_DAO"%>
<%@page import="enity.TheLoai"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <%@ page contentType="text/html; charset=UTF-8" %>
        <title>Sửa Thể Loại</title>
        <jsp:include page="head.jsp" />
    </head>
    <body>
        <jsp:include page="title_admin.jsp" />
        <div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar">
            <jsp:include page="user_status.jsp" />
            <ul class="nav menu" style="margin: 0px">
                <li class="active table_hover"><a><em class="fa fa-dashboard">&nbsp;</em>Sửa Thể Loại</a></li>
            </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
            <div class="row">
                <ol class="breadcrumb">
                    <li><a href="TheLoai_Servlet">
                            <em class="fa fa-home"></em>
                        </a></li>
                    <li class="active">Quản Lý Thể Loại / Sửa Thể Loại</li>
                </ol>
            </div>
            <div class="container" style="width: 1100px">
                <div class="table-wrapper" >
                    <div class="table-title">
                        <div class="row">
                            <div class="row">
                                <div class="col-lg-12">
                                    <h1 style="margin-bottom: 5px" class="page-header">Sửa Thể Loại</h1>
                                </div>
                            </div>
                            <form action="Manager_TheLoai_Servlet" onsubmit="return xacNhan()">
                                <table class="table table-bordered table_hover" style="border-radius:14px;border-style: hidden ">
                                    <thead>
                                        <tr>
                                            <th style="width: 20%">Mã Thể Loại</th>
                                            <th>Tên Thể Loại</th>
                                            <th style="width: 50%">Ghi Chú</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td><input type="text" class="form-control" name="maTL" value="<%=request.getParameter("matl")%>" readonly="true" required></td>
                                            <td><input type="text" class="form-control" name="tenTL" id="tenTL" value="<%=request.getParameter("tentl")%>" required></td>
                                            <td><input type="text" class="form-control" name="ghiChu" id="ghiChu" value="<%=request.getParameter("ghichu")%>" required></td>
                                        </tr> 
                                    </tbody>
                                </table>    
                                <%ServletContext context = getServletContext();
                                    context.setAttribute("context", "edit_thl");
                                %>
                                <div class="col-sm-4" style="margin-left: 17%; float: left">
                                    <a href="TheLoai_Servlet"><button style="background-color: #30a5ff;border-radius: 40px;" type="button" class="btn btn-info add-new"><span class="glyphicon glyphicon-menu-left"></span> Quay Lại</button></a>
                                </div>
                                <div class="col-sm-4" style="margin-left: 0%; float: left; width: 12%">
                                    <a><button style="background-color: #30a5ff;border-radius: 40px;" type="submit" class="btn btn-info add-new"><span class="glyphicon glyphicon-pencil"></span> Sửa Đổi</button></a>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>  
        </div>	
    </body>
</html>