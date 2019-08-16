<%@page import="enity.NhanVien"%>
<%@page import="java.util.ArrayList"%>
<%
    ArrayList<NhanVien> list_nv = (ArrayList<NhanVien>) request.getAttribute("list_nv");
    ServletContext context=getServletContext();
    context.setAttribute("context", "delete_nv");
    
    
    String disable_table="display: block";
    String mess="";
    if(list_nv.size()==0){
        disable_table="display: none";
        mess="Không Tìm Thấy. Xin Kiểm Tra Lại!";
    }
    String manv_search="";
    String manv="";
    String disable_butmess="";
    try{
        manv=request.getAttribute("manv_search").toString();
    }   
    catch(Exception e){
    }
    if(manv!=""){
        manv_search=manv;
        disable_butmess="display: block";
    }
    else{
        disable_butmess="display: none";
    }

%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <%@ page contentType="text/html; charset=UTF-8" %>
        <title>Quản Lý Nhân Viên</title>
        <jsp:include page="head.jsp" />
    </head>
    <body>
        <jsp:include page="title_admin.jsp" />
        <div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar">
            <jsp:include page="user_status.jsp" />
            <ul class="nav menu" style="margin: 0px">
                <li class="table_hover"><a href="thongtin_admin.jsp"><span class="glyphicon glyphicon-user"></span> Thông Tin Cá Nhân</a></li>
                <li class="table_hover"><a href="suathongtin_admin.jsp"><span class="glyphicon glyphicon-pencil"></span> Sửa Thông Tin Cá Nhân</a></li>
                <li class="table_hover"><a href="TheLoai_Servlet"><span class="glyphicon glyphicon-th-list"></span> Quản Lý Thể Loại</a></li>
                <li class="table_hover"><a href="TaiLieu_Servlet"><span class="glyphicon glyphicon-book"></span> Quản Lý Tài Liệu</a></li>
                <li class="active table_hover"><a href="NhanVien_Servlet"><span class="glyphicon glyphicon-briefcase"></span> Quản Lý Nhân Viên</a></li>
                <li class="table_hover"><a href="DocGia_Servlet"><span class="glyphicon glyphicon-education"></span> Quản Lý Độc Giả</a></li>
                <li class="table_hover"><a  onclick="return xacNhan()" href="Logout_Servlet"><span class="glyphicon glyphicon-off"></span> Đăng Xuất</a></li>
            </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
            <div class="row">
                <ol class="breadcrumb">
                    <li><a href="NhanVien_Servlet">
                            <em class="fa fa-home"></em>
                        </a></li>
                    <li class="active">Quản Lý Nhân Viên</li>
                </ol>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <h1 style="width: 40%" class="page-header">Quản Lý Nhân Viên</h1>
                </div>
            </div>
        </div>	
        <div style="margin-left: 226px; width: 1100px" class="container">
            <div class="table-wrapper">
                <div class="table-title">
                    <div class="row">
                        <div style="width: 40%; float: left" class="col-sm-8"><h2>Danh Sách <b>Nhân Viên</b></h2></div>
                        <form action="Search_NhanVien_Servlet">
                            <div style="width:48%; float: left">
                                <input value="<%=manv_search %>" id="manv" type="text" name="manv_search" style="font-size: 14px;border-radius: 4px;height: 30px;border-style: groove;width: 220px; margin-left: 38%;" placeholder="  search here.. " required> 
                                <a><button style="background-color: #30a5ff" type="" class="btn btn-info add-new"><span class="fa fa-search"></span>  Tìm</button></a>
                            </div>
                        </form>
                        <div style="width: 12%" class="col-sm-4">
                            <a href="them_nhanvien.jsp"><button style="background-color: #30a5ff" type="button" class="btn btn-info add-new"><i class="fa fa-plus"></i> Thêm</button></a>
                        </div>
                    </div>
                </div>
                <div  style=" <%=disable_table %>">
                <table class="table table-bordered table_hover" id="table" style="border-radius:14px;border-style: hidden ">
                    <thead>
                        <tr>
                            <th>Mã Nhân Viên</th>
                            <th>Họ Tên</th>
                            <th>Chức Vụ</th>
                            <th>Tài Khoản</th>
                            <th>Mật Khẩu</th>
                            <th>Quyền</th>
                            <th style="width: 17%">Thao Tác</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%for (NhanVien nhanvien : list_nv) {%>
                        <tr>
                            <td><%=nhanvien.getMaNhanVien()%></td>
                            <td><%=nhanvien.getHoTen()%></td>
                            <td><%=nhanvien.getChucVu()%></td>
                            <td><%=nhanvien.getTaiKhoan()%></td>
                            <td><%=nhanvien.getMatKhau()%></td>
                            <td><%=nhanvien.getQuyen()%></td>
                            <td>
                                <a href="sua_nhanvien.jsp?manv=<%=nhanvien.getMaNhanVien()%>&hoten=<%=nhanvien.getHoTen()%>&chucvu=<%=nhanvien.getChucVu()%>&taikhoan=<%=nhanvien.getTaiKhoan()%>&matkhau=<%=nhanvien.getMatKhau()%>&quyen=<%=nhanvien.getQuyen()%>" class="edit" title="Edit" data-toggle="tooltip">
                                    <button type="button" class="btn btn-warning">
                                        <span class="fa fa-pencil mr-5"></span>Sửa
                                    </button>
                                </a>
                                <a onclick="return xacNhan()" href="Manager_NhanVien_Servlet?manv=<%=nhanvien.getMaNhanVien()%>"class="delete" title="Delete" data-toggle="tooltip">
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
                <a href="NhanVien_Servlet"><button style="height: 32px;line-height: 0px;margin:0px 0px 8px 2px;" type="" class="btn btn-primary add-new"><span class="glyphicon glyphicon-chevron-left"></span>  Quay Lại</button></a>
            </div>
        </div> 
        </div>
    </body>
</html>
