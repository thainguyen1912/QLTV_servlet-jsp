<%@page import="dao.NhanVien_DAO"%>
<%@page import="enity.NhanVien"%>
<%@page import="enity.TaiLieuMuon"%>
<%@page import="enity.TaiLieu"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="dao.PhieuMuon_DAO"%>
<%@page import="enity.PhieuMuon"%>
<%@page import="java.util.ArrayList"%>
<%@page import="enity.DocGia"%>
<%@page import="dao.DocGia_DAO"%>
<%@page import="dao.db_connection"%>
<%
    ServletContext context = getServletContext();
    context.setAttribute("hanhdong", "xoatailieu");

    double tongTien = Double.valueOf(context.getAttribute("tongtien").toString());
    int stlcdm = Integer.valueOf(context.getAttribute("stlcdm").toString());
    double soDu = Double.valueOf(context.getAttribute("sodu").toString());

    db_connection db = new db_connection();
    DocGia_DAO dgdao = new DocGia_DAO(db);
    PhieuMuon_DAO pmdao = new PhieuMuon_DAO(db);
    DocGia dg = (DocGia) context.getAttribute("docgia");
    ArrayList<PhieuMuon> list_pm = pmdao.getAll();

    String maPhieuMuonMoi = "";
    if (list_pm.size() == 0) {
        maPhieuMuonMoi = "PM_0001";
    } else {
        String maPhieuMuonCu = list_pm.get(list_pm.size() - 1).getMaPhieuMuon().toString();
        int soPhieuMuonMoi = Integer.valueOf(maPhieuMuonCu.substring(3, maPhieuMuonCu.length()).toString()) + 1;
        if (soPhieuMuonMoi <= 9) {
            maPhieuMuonMoi = "PM_000" + soPhieuMuonMoi;
        }
        if (soPhieuMuonMoi >= 10 && soPhieuMuonMoi <= 99) {
            maPhieuMuonMoi = "PM_00" + soPhieuMuonMoi;
        }
        if (soPhieuMuonMoi >= 100 && soPhieuMuonMoi <= 999) {
            maPhieuMuonMoi = "PM_0" + soPhieuMuonMoi;
        }
        if (soPhieuMuonMoi >= 1000) {
            maPhieuMuonMoi = "PM_" + soPhieuMuonMoi;
        }
    }

    Calendar cl = Calendar.getInstance();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String dateNow = sdf.format(cl.getTime()).toString();
    NhanVien_DAO nvdao=new NhanVien_DAO(db);
    NhanVien user = nvdao.getOneNhanVien(session.getAttribute("user").toString());
    String manv = user.getMaNhanVien();
    String tennv = user.getHoTen();
    ArrayList<TaiLieuMuon> list_tlm = null;
    list_tlm = (ArrayList<TaiLieuMuon>) context.getAttribute("list_tlm");
    if (list_tlm == null) {
        list_tlm = new ArrayList<TaiLieuMuon>();
        context.setAttribute("list_tlm", list_tlm);
    }
    String disabled_add = "";

    if (stlcdm <= 0 || soDu <= 0) {
        disabled_add = "display: none";
    } else {
        disabled_add = "display: block";
    }
    String style = "";
    if (list_tlm.size() >= 1) {
        style = "margin-left: 2.8%; margin-bottom: 8px; margin-top: 3%";
    } else {
        style = "margin-left: 41.5%; margin-bottom: 8px; margin-top: 3%";
    }

    String color_stlcdm = "";
    String color_sodu = "";
    if (stlcdm <= 0) {
        color_stlcdm = "color: red";
    }
    if (soDu <= 0) {
        color_sodu = "color: red";
    }
    
    System.out.println("size tlm" + list_tlm.size());
%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <%@ page contentType="text/html; charset=UTF-8" %>
        <title>Quản Lý Thể Loại</title>
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
        </div>
        <div style="margin-left: 226px; width: 1100px" class="container">
            <div id="create_first" style="float: left">
                <div style="float: left; margin-left: 16%">
                    <div style="margin: 10px 10px 10px 0px">
                        Mã Phiếu Mượn:&emsp;<%="" + maPhieuMuonMoi%>
                    </div>
                    <div style="margin-left: 9%">
                        Ngày Mượn:&emsp;<%=dateNow%>
                    </div>
                </div>
                <div style="float: left; margin-left: 6%">
                    <div style="margin: 10px 10px 10px 2px">
                        Mã Độc Giả:&emsp;<%=dg.getMaDocGia()%>
                    </div>
                    <div style="margin-left: -1px">
                        Tên Độc Giả:&emsp;<%=dg.getHoTen()%>
                    </div>
                </div>
                <div style="float: left;margin-left: 5%">
                    <div style="margin: 10px 10px 10px 2px">
                        Mã Nhân Viên:&emsp;<%=manv%>
                    </div>
                    <div style="margin-left: -1px">
                        Tên Nhân Viên:&emsp;<%=tennv%>
                    </div>
                </div>
                <div style="float: left; width: 100%">
                    <div style="float:left; margin: 2% 0% 0% 13.5%; <%=color_stlcdm%>">
                        Số Tài Liệu Còn Được Mượn:&emsp;<%=stlcdm%>
                    </div>
                    <div style="float: left; margin: 1% 0% 0% 9%">
                        <a href="muonsach_madocgia.jsp" style="">
                            <button style=""
                                    style="background-color: #30a5ff;"
                                    type="" class="btn btn-warning">
                                <span class="glyphicon glyphicon-refresh"></span> Chọn Độc Giả Khác
                            </button>
                        </a>
                    </div>
                    <div style="float: left; margin: 2% 0% 0% 7.5%; <%=color_sodu%>">
                        Số Dư Trong Tài Khoản:&emsp;<%=(double) context.getAttribute("sodu")%>
                    </div>
                </div>
                <div class="col-sm-4"
                     style="<%=style%>;  clear: both"
                     >

                    <a href="muonsach_themtailieu.jsp" style="float: left">
                        <button style="<%=disabled_add%>"
                                style="background-color: #30a5ff;"
                                type="" class="btn btn-primary">
                            <span class="glyphicon glyphicon-plus-sign"></span> Chọn Tài Liệu Mượn
                        </button>
                    </a>

                </div>

                <div class="col-sm-4" style="margin-left: 49.6%; margin-bottom: 8px; width: 136px; margin-top: 3%">
                    <%if (list_tlm.size() >= 1) {%>
                    <a onclick="return xacNhan()" href="TaoPhieuMuon_Servlet?mapm=<%=maPhieuMuonMoi%>&madg=<%=dg.getMaDocGia()%>&manv=<%=manv%>&ngaymuon=<%=dateNow%>">
                            <button  style="background-color: #30a5ff;" type="submit" class="btn btn-primary">
                                <span class="glyphicon glyphicon-ok-sign"></span> Lưu
                            </button>
                        </a>
                    <%}%>
                </div> 
            </div>

            <div id="create_second" style="float: left; display: block; margin-left: 4%">
                <div id="right">
                    <%if (list_tlm.size() >= 1) { %>
                    <thead>
                        <tr>
                    <table class="table table-bordered table_hover" id="table" style="width: 94%;border-radius: 10px;border-style: hidden;">
                        <th>Mã Tài Liệu</th>
                        <th>Tên Tài Liệu</th>
                        <th>Số Lượng Mượn</th>
                        <th>Giá Tiền</th>
                        <th style="width: 182px">Thao Tác</th>
                        </tr>
                        </thead>
                        <tbody>
                            <%for (TaiLieuMuon tlm : list_tlm) {%>
                            <tr>
                                <td><%=tlm.getMaTaiLieu()%></td>
                                <td><%=tlm.getTenTaiLieu()%></td>
                                <td><%=tlm.getSoLuong()%></td>
                                <td><%=tlm.getGiaTien()%></td>
                                <td>
                                    <a href="muonsach_suatailieu.jsp?matlm=<%=tlm.getMaTaiLieu()%>&tentlm=<%=tlm.getTenTaiLieu()%>&slm=<%=tlm.getSoLuong()%>&giaTien=<%=tlm.getGiaTien()%>" class="edit" title="Edit" data-toggle="tooltip">
                                        <button type="button" class="btn btn-warning">
                                            <span class="fa fa-pencil mr-5"></span>Sửa
                                        </button>
                                    </a>
                                    <a onclick="return xacNhan()" href="Manager_MuonSach_Servlet?xoatlm=<%=tlm.getMaTaiLieu()%>&slm=<%=tlm.getSoLuong()%>&giaTien=<%=tlm.getGiaTien()%>" class="delete" title="Delete" data-toggle="tooltip">
                                        <button type="button" class="btn btn-danger">
                                            <span class="fa fa-trash mr-5"></span>Xóa
                                        </button>
                                    </a>
                                </td>
                            </tr>
                            <%}%>
                        </tbody>
                    </table>

                    <div style="margin-left: 71.6%;">
                        Giá Tiền
                        <input value="<%=tongTien%>" style="text-align: center;border-style: groove;border-radius: 4px;height: 32px" type="text" readonly="true">
                    </div>
                    <%}%>
                    <div style="clear: both; margin-left: 29%"><p style="color: deeppink;"> <%=(request.getAttribute("save_err") == null ? "" : request.getAttribute("save_err"))%></p></div>
                </div>
            </div>
        </div>
    </div>	
</body>
</html>