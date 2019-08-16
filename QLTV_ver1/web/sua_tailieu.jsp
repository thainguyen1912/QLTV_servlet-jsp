<%@page import="dao.TheLoai_DAO"%>
<%@page import="dao.db_connection"%>
<%@page import="dao.TaiLieu_DAO"%>
<%@page import="enity.TaiLieu"%>
<%@page import="java.util.ArrayList"%>
<%
    db_connection db = new db_connection();
    TheLoai_DAO tlodao = new TheLoai_DAO(db);

    ArrayList<String> list_matlo = tlodao.getAllMaTheLoai();

    ArrayList<String> list_tentlo = tlodao.getAllTenTheLoai();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <%@ page contentType="text/html; charset=UTF-8" %>
        <title>Sửa Tài Liệu</title>
        <jsp:include page="head.jsp" />
    </head>
    <body>
        <jsp:include page="title_admin.jsp" />
        <div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar">
            <jsp:include page="user_status.jsp" />
            <ul class="nav menu" style="margin: 0px">
                <li class="active table_hover"><a><em class="fa fa-dashboard">&nbsp;</em>Sửa Tài Liệu</a></li>
            </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
            <div class="row">
                <ol class="breadcrumb">
                    <li><a href="TaiLieu_Servlet">
                            <em class="fa fa-home"></em>
                        </a></li>
                    <li class="active">Quản Lý Tài Liệu / Sửa Tài Liệu</li>
                </ol>
            </div>
            <div class="container" style="width: 1100px">
                <div class="table-wrapper" >
                    <div class="table-title">
                        <div class="row">
                            <div class="row">
                                <div class="col-lg-12">
                                    <h1 style="margin-bottom: 5px" class="page-header">Sửa Tài Liệu</h1>
                                </div>
                            </div>
                            <form action="Manager_TaiLieu_Servlet" onsubmit="return xacNhan()">
                                <table class="table table-bordered table_hover" style="border-radius:14px;border-style: hidden ">
                                    <thead>
                                        <tr>
                                            <th>Mã Tài Liệu</th>
                                            <th>Tên Tài Liệu</th>
                                            <th>Tên Thể Loại</th>
                                            <th>Số Lượng</th>
                                            <th>Nhà Xuất Bản</th>
                                            <th>Năm Xuất Bản</th>
                                            <th style="width: 16%">Tác Giả</th>
                                            <th style="width: 10%">Giá Tiền</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td><input type="text" class="form-control" name="matli" id="matli" value="<%=request.getParameter("matli")%>" readonly="true"></td>
                                            <td><input type="text" class="form-control" name="tentli" id="tentli" value="<%=request.getParameter("tentli")%>" required></td>
                                            <td>
                                                <select   name="matlo" id="matlo" style="border: 1px solid #ddd; height: 46px;width: 100%;border-radius: 5px">
                                                    <%
                                                        String mathl = request.getParameter("mathl");
                                                        String selected = "";
                                                    %>
                                                    <%for (int i = 0; i < list_matlo.size(); i++) {%>
                                                    <%
                                                        if (list_matlo.get(i).toString().equals(mathl)) {
                                                            selected = "selected";
                                                        } else {
                                                            selected = "";
                                                        }
                                                    %>
                                                    <option <%=selected%> value="<%=list_matlo.get(i)%>"><%=list_tentlo.get(i)%></option>
                                                    <%}%>
                                                </select> 
                                            </td>
                                            <td><input type="number" min="0" class="form-control" name="soluong" id="soluong" value="<%=request.getParameter("sl")%>" required></td>
                                            <td><input type="text" class="form-control" name="nhaxb" id="nhaxb" value="<%=request.getParameter("nhaxb")%>" required></td>
                                            <td><input type="number" min="1970" class="form-control" name="namxb" id="namxb" value="<%=request.getParameter("namxb")%>" required></td>
                                            <td><input type="text" class="form-control" name="tacgia" id="tacgia" value="<%=request.getParameter("tg")%>" required></td>
                                            <td><input type="number" min="0" class="form-control" name="giatien" id="giatien" value="<%=request.getParameter("giatien")%>" required></td>
                                        </tr> 
                                    </tbody>
                                </table>    
                                <div class="col-sm-4" style="margin-left: 17%; float: left">
                                    <a href="TaiLieu_Servlet"><button style="background-color: #30a5ff;border-radius: 40px;" type="button" class="btn btn-info add-new"><span class="glyphicon glyphicon-menu-left"></span> Quay Lại</button></a>
                                </div>
                                <div class="col-sm-4" style="margin-left: 0%; float: left; width: 12%">
                                    <a><button style="background-color: #30a5ff;border-radius: 40px;" type="submit" class="btn btn-info add-new"><span class="glyphicon glyphicon-pencil"></span> Sửa Đổi</button></a>
                                </div>
                            </form>
                            <%
                                ServletContext context = getServletContext();
                                context.setAttribute("context", "edit_tli");
                            %>  
                            
                        </div>
                    </div>
                </div>
            </div>  
        </div>
    </body>
</html>