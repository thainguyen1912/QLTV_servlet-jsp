<%@page import="enity.NhanVien"%>
<%@page import="dao.NhanVien_DAO"%>
<%@page import="dao.db_connection"%>
<%@page import="java.util.ArrayList"%>

<%
    db_connection db = new db_connection();
    NhanVien_DAO nvdao = new NhanVien_DAO(db);
    ArrayList<NhanVien> list_nv = nvdao.getAll();
    String maNhanVienMoi = "";
    String maNhanVienCu = list_nv.get(list_nv.size() - 1).getMaNhanVien().toString();
    int soNhanVienMoi = Integer.valueOf(maNhanVienCu.substring(3, maNhanVienCu.length()).toString()) + 1;

    if (soNhanVienMoi <= 9) {
        maNhanVienMoi = "NV_000" + soNhanVienMoi;
    }
    if (soNhanVienMoi >= 10 && soNhanVienMoi <= 99) {
        maNhanVienMoi = "NV_00" + soNhanVienMoi;
    }
    if (soNhanVienMoi >= 100 && soNhanVienMoi <= 999) {
        maNhanVienMoi = "NV_0" + soNhanVienMoi;
    }
    if (soNhanVienMoi >= 1000) {
        maNhanVienMoi = "NV_" + soNhanVienMoi;
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <%@ page contentType="text/html; charset=UTF-8" %>
        <title>Thêm Nhân Viên</title>
        <jsp:include page="head.jsp" />
    </head>
    <body>
        <jsp:include page="title_admin.jsp" />
        <div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar">
            <jsp:include page="user_status.jsp" />
            <ul class="nav menu" style="margin: 0px">
                <li class="active table_hover"><a><em class="fa fa-dashboard">&nbsp;</em>Thêm Nhân Viên</a></li>
            </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
            <div class="row">
                <ol class="breadcrumb">
                    <li><a href="NhanVien_Servlet">
                            <em class="fa fa-home"></em>
                        </a></li>
                    <li class="active">Quản Lý Nhân Viên / Thêm Nhân Viên</li>
                </ol>
            </div>
            <div class="container" style="width: 1100px">
                <div class="table-wrapper" >
                    <div class="table-title">
                        <div class="row">
                            <div class="row">
                                <div class="col-lg-12">
                                    <h1 style="margin-bottom: 5px" class="page-header">Thêm Nhân Viên</h1>
                                </div>
                            </div>
                            <form action="Manager_NhanVien_Servlet" onsubmit="return kiemtra_form_themnhanvien()">
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
                                            <td><input type="text" class="form-control" name="manv" id="manv" value="<%=maNhanVienMoi%>" readonly="true"></td>
                                            <td><input type="text" class="form-control" name="hoten" id="hoten" required></td>
                                            <td>
                                                <select name="chucvu" style="border: 1px solid #ddd; height: 46px;width: 100%;border-radius: 5px">
                                                    <option selected>Giảng Viên</option>
                                                    <option>Kế Toán</option>
                                                </select> 
                                            </td>
                                            <td><input type="text" class="form-control" name="taikhoan" id="taikhoan" required></td>
                                            <td><input type="text" class="form-control" name="matkhau" id="matkhau" required></td>
                                            <td>
                                                <select name="quyen" style="border: 1px solid #ddd; height: 46px;width: 100%;border-radius: 5px">
                                                    <option >Admin</option>
                                                    <option selected>Thủ Thư</option>
                                                </select> 
                                            </td>
                                        </tr> 
                                    </tbody>
                                </table>    
                                <div class="col-sm-4" style="margin-left: 17%; float: left">
                                    <a href="NhanVien_Servlet"><button style="background-color: #30a5ff;border-radius: 40px;" type="button" class="btn btn-info add-new"><span class="glyphicon glyphicon-menu-left"></span> Quay Lại</button></a>
                                </div>
                                <div class="col-sm-4" style="margin-left: 0%; float: left; width: 12%">
                                    <a><button style="background-color: #30a5ff;border-radius: 40px;" type="submit" class="btn btn-info add-new"><i class="fa fa-plus add"></i> Thêm</button></a>
                                </div>
                            </form>
                            <%ServletContext context = getServletContext();
                                context.setAttribute("context", "add_nv");
                            %>                      
                        </div>
                    </div>
                </div>
            </div>  
        </div>	
    </body>
</html>