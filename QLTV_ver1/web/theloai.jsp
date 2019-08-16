<%@page import="javax.swing.text.Document"%>
<%@page import="dao.TaiLieu_DAO"%>
<%@page import="dao.db_connection"%>
<%@page import="dao.TheLoai_DAO"%>
<%@page import="enity.TheLoai"%>
<%@page import="java.util.ArrayList"%>
<%
    ServletContext context = getServletContext();
    context.setAttribute("context", "delete_thl");
    ArrayList<TheLoai> list_tl = (ArrayList<TheLoai>) request.getAttribute("list_tl");
    String disable_table="display: block";
    String mess="";
    if(list_tl.size()==0){
        disable_table="display: none";
        mess="Không Tìm Thấy. Xin Kiểm Tra Lại!";
    }
    String mathl_search="";
    String mathl="";
    String disable_butmess="";
    try{
        mathl=request.getAttribute("mathl_search").toString();
    }   
    catch(Exception e){
    }
    if(mathl!=""){
        mathl_search=mathl;
        disable_butmess="display: block";
    }
    else{
        disable_butmess="display: none";
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <%@ page contentType="text/html; charset=UTF-8" %>
        <%@ page import="enity.NhanVien"%>
        <title>Quản Lý Thể Loại</title>
        <jsp:include page="head.jsp" />
    </head>
    <body>
        <jsp:include page="title_admin.jsp" />
        <div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar">
            <jsp:include page="user_status.jsp" />
            <ul class="nav menu" style="margin: 0px">
                <li class="table_hover"><a href="thongtin_admin.jsp"><span class="glyphicon glyphicon-user"></span> Thông Tin Cá Nhân</a></li>
                <li class="table_hover"><a href="suathongtin_admin.jsp"><span class="glyphicon glyphicon-pencil"></span> Sửa Thông Tin Cá Nhân</a></li>
                <li class="active table_hover"><a href="TheLoai_Servlet"><span class="glyphicon glyphicon-th-list"></span> Quản Lý Thể Loại</a></li>
                <li class="table_hover"><a href="TaiLieu_Servlet"><span class="glyphicon glyphicon-book"></span> Quản Lý Tài Liệu</a></li>
                <li class="table_hover"><a href="NhanVien_Servlet"><span class="glyphicon glyphicon-briefcase"></span> Quản Lý Nhân Viên</a></li>
                <li class="table_hover"><a href="DocGia_Servlet"><span class="glyphicon glyphicon-education"></span> Quản Lý Độc Giả</a></li>
                <li class="table_hover"><a  onclick="return xacNhan()" href="Logout_Servlet"><span class="glyphicon glyphicon-off"></span> Đăng Xuất</a></li>
            </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
            <div class="row">
                <ol class="breadcrumb">
                    <li><a href="TheLoai_Servlet">
                            <em class="fa fa-home"></em>
                        </a></li>
                    <li class="active">Quản Lý Thể Loại</li>
                </ol>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <h1 style="width: 40%" class="page-header">Quản Lý Thể Loại</h1>
                </div>
            </div>
        </div>
        <div class="container" style="margin-left: 226px; width: 1100px">
            <div class="table-wrapper">
                <div class="table-title">
                    <div class="row">
                        <div style="width: 40%; float: left" class="col-sm-8"><h2>Danh Sách <b>Thể Loại</b></h2></div>
                        <form action="Search_TheLoai_Servlet">
                            <div style="width:48%; float: left">
                                <input value="<%=mathl_search %>" id="mathl"  type="text" name="mathl_search" style="font-size: 14px;border-radius: 4px;height: 30px;border-style: groove;width: 220px; margin-left: 38%;" placeholder="  search here.. " required>
                                <a><button style="background-color: #30a5ff" type="submit" class="btn btn-info add-new"><span class="fa fa-search"></span>  Tìm</button></a>
                            </div>
                        </form>
                        <div style="width: 12%" class="col-sm-4">
                            <a href="them_theloai.jsp"><button style="background-color: #30a5ff" type="button" class="btn btn-info add-new"><i class="fa fa-plus"></i>Thêm</button></a>
                        </div>
                    </div>
                </div>
                <div style=" <%=disable_table %>">
                <table class="table table-bordered table_hover" id="table" style="border-radius:14px;border-style: hidden">
                    <thead>
                        <tr>
                            <th>Mã Thể Loại</th>
                            <th>Tên Thể Loại</th>
                            <th>Ghi Chú</th>
                            <th style="width: 180px">Thao Tác</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%for (TheLoai tl : list_tl) {%>
                        <tr>
                            <td><%=tl.getMaTheLoai()%></td>
                            <td><%=tl.getTenTheLoai()%></td>
                            <td><%=tl.getGhiChu()%></td>
                            <td>
                                <a href="sua_theloai.jsp?matl=<%=tl.getMaTheLoai()%>&tentl=<%=tl.getTenTheLoai()%>&ghichu=<%=tl.getGhiChu()%>" class="edit" title="Edit" data-toggle="tooltip">
                                    <button type="button" class="btn btn-warning">
                                        <span class="fa fa-pencil mr-5"></span>Sửa
                                    </button>
                                </a>
                                <a onclick="return xacNhan()" href="Manager_TheLoai_Servlet?maTL=<%=tl.getMaTheLoai().toString()%>"class="delete" title="Delete" data-toggle="tooltip">
                                    <button type="button" class="btn btn-danger">
                                        <span class="fa fa-trash mr-5"></span>Xóa
                                    </button>
                                </a>
                            </td>
                        </tr>
                        <%}%>
                    </tbody>
                </table>
                <%=mess==""?"":mess %>
            </div>
            <div style="margin-left: 48%; <%=disable_butmess %>"> 
                <div style="margin: 10px; color: red; margin-left: -13%"><%=mess==""?"":mess %></div>
                <a href="TheLoai_Servlet"><button style="height: 32px;line-height: 0px;margin:0px 0px 8px 2px;" type="" class="btn btn-primary add-new"><span class="glyphicon glyphicon-chevron-left"></span>  Quay Lại</button></a>
            </div>
            </div>
        </div>  
    </div>	
</body>
</html>