<%@page import="enity.DocGia"%>
<%@page import="dao.DocGia_DAO"%>
<%@page import="dao.db_connection"%>
<%@page import="java.util.ArrayList"%>

<%
    db_connection db = new db_connection();
    DocGia_DAO dgdao = new DocGia_DAO(db);
    ArrayList<DocGia> dg = dgdao.getAll();
    String maDocGiaMoi = "";
    String maDocGiaCu = dg.get(dg.size() - 1).getMaDocGia().toString();
    int soDocGiaMoi = Integer.valueOf(maDocGiaCu.substring(3, maDocGiaCu.length()).toString()) + 1;
    if (soDocGiaMoi <= 9) {
        maDocGiaMoi = "DG_000" + soDocGiaMoi;
    }
    if (soDocGiaMoi >= 10 && soDocGiaMoi <= 99) {
        maDocGiaMoi = "DG_00" + soDocGiaMoi;
    }
    if (soDocGiaMoi >= 100 && soDocGiaMoi <= 999) {
        maDocGiaMoi = "DG_0" + soDocGiaMoi;
    }
    if (soDocGiaMoi >= 1000) {
        maDocGiaMoi = "DG_" + soDocGiaMoi;
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <%@ page contentType="text/html; charset=UTF-8" %>
        <title>Thêm Độc Giả</title>
        <jsp:include page="head.jsp" />
    </head>
    <body>
        <jsp:include page="title_admin.jsp" />
        <div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar">
            <jsp:include page="user_status.jsp" />
            <ul class="nav menu" style="margin: 0px">
                <li class="active table_hover"><a><em class="fa fa-dashboard">&nbsp;</em>Thêm Độc Giả</a></li>
            </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
            <div class="row">
                <ol class="breadcrumb">
                    <li><a href="DocGia_Servlet">
                            <em class="fa fa-home"></em>
                        </a></li>
                    <li class="active">Quản Lý Độc Giả / Thêm Độc Giả</li>
                </ol>
            </div>
            <div class="container" style="width: 1100px">
                <div class="table-wrapper" >
                    <div class="table-title">
                        <div class="row">
                            <div class="row">
                                <div class="col-lg-12">
                                    <h1 style="margin-bottom: 5px" class="page-header">Thêm Độc Giả</h1>
                                </div>
                            </div>
                            <form action="Manager_DocGia_Servlet" onsubmit="return kiemtra_form_themdocgia()">
                                <table class="table table-bordered table_hover" style="border-radius:14px;border-style: hidden ">
                                    <thead>
                                        <tr>
                                            <th>
                                                Thông Tin
                                            </th>
                                            <th style="width: 60%">
                                                Điền Thông Tin
                                            </th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td>Mã Độc Giả</td>
                                            <td><input type="text" class="form-control" name="madg" id="madg" value="<%=maDocGiaMoi%>" readonly="true"></td>
                                        </tr>
                                        <tr>
                                            <td>Tên Độc Giả</td>
                                            <td><input type="text" class="form-control" name="hoten" id="hoten" required></td>
                                        </tr>
                                        <tr>
                                            <td>Giới Tính</td>
                                            <td>
                                                <select name="gioitinh" style="border: 1px solid #ddd; height: 46px;width: 100%;border-radius: 5px">
                                                    <option value="1">Nam</option>
                                                    <option value="0">Nữ</option>
                                                </select> 
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>Ngày Sinh</td>
                                            <td>
                                                <input type="date" name="ngaysinh" id="ngaysinh" style="height: 46px; border-radius: 4px; border-style: ridge; width: 100%" required>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>Đối Tượng</td>
                                            <td>
                                                <select name="doituong" style="border: 1px solid #ddd; height: 46px;width: 100%;border-radius: 5px">
                                                    <option value="Sinh Viên">Sinh Viên</option>
                                                    <option value="Giảng Viên">Giảng Viên</option>
                                                </select> 
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>Ngày Cấp</td>
                                            <td>
                                                <input type="date" name="ngaycap" id="ngaycap" style="height: 46px; border-radius: 4px; border-style: ridge; width: 100%" required>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>Ngày Hết Hạn</td>
                                            <td>
                                                <input type="date" name="ngayhethan" id="ngayhethan" style="height: 46px; border-radius: 4px; border-style: ridge; width: 100%" required>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>Mật Khẩu</td>
                                            <td><input type="text" class="form-control" name="matkhau" id="matkhau" required></td>
                                        </tr>
                                        <tr>
                                            <td>Số Lượng Tài Liệu Còn Được Mượn</td>
                                            <td>
                                                <input type="number" min="0" max="20" name="soluongtailieu" id="soluongtailieu" style="height: 46px; border-radius: 4px; border-style: ridge; width: 100%" required>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>Số Lượng Mượn Tối Đa Mỗi Tài Liệu</td>
                                            <td>
                                                <input type="number" min="0" max="5" name="soluongmoitailieu" id="soluongmoitailieu" style="height: 46px; border-radius: 4px; border-style: ridge; width: 100%" required>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>Số Ngày Mượn Tối Đa</td>
                                            <td>
                                                <input type="number" min="0" max="150" name="songaymuon" id="songaymuon" style="height: 46px; border-radius: 4px; border-style: ridge; width: 100%" required>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>Số Dư Tài Khoản</td>
                                            <td>
                                                <input type="number" min="0" name="sodutaikhoan" id="sodutaikhoan" style="height: 46px; border-radius: 4px; border-style: ridge; width: 100%" required>
                                            </td>
                                        </tr> 
                                    </tbody>
                                </table>    
                                <div class="col-sm-4" style="margin-left: 17%; float: left">
                                    <a href="DocGia_Servlet"><button style="background-color: #30a5ff;border-radius: 40px;" type="button" class="btn btn-info add-new"><span class="glyphicon glyphicon-menu-left"></span> Quay Lại</button></a>
                                </div>
                                <div class="col-sm-4" style="margin-left: 0%; float: left; width: 12%">
                                    <a><button style="background-color: #30a5ff;border-radius: 40px;" type="submit" class="btn btn-info add-new"><i class="fa fa-plus add"></i> Thêm</button></a>
                                </div>
                            </form>
                            <%
                                ServletContext context = getServletContext();
                                context.setAttribute("context", "add_dg");
                            %>                     
                        </div>
                    </div>
                </div>
            </div>  
        </div>	
    </body>
</html>