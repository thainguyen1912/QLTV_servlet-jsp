<%@page import="enity.DocGia"%>
<%@page import="org.apache.tomcat.util.http.fileupload.RequestContext"%>
<%@page import="enity.TaiLieuMuon"%>
<%@page import="enity.TaiLieu"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.TaiLieu_DAO"%>
<%@page import="dao.db_connection"%>
<%
    ServletContext context = getServletContext();
    context.setAttribute("hanhdong", "themtailieu");
    db_connection db = new db_connection();
    TaiLieu_DAO tldao = new TaiLieu_DAO(db);
    ArrayList<String> list_matli = tldao.getAllMaTaiLieu();
    ArrayList<String> list_tentli = tldao.getAllTenTaiLieu();
    String matl = "";
    try {
        matl = request.getParameter("matl").toString();
    } catch (Exception e) {
    }
    int slcon = tldao.getSoLuongCon(matl);
    double giaTien=tldao.getGiaTien(matl);
    ArrayList<Integer> list_slmuon = new ArrayList<Integer>();
    int stlcdm = (int)context.getAttribute("stlcdm");
    if (slcon >= 2) {
        if(stlcdm == 1){
            list_slmuon.add(1);
        }
        if(stlcdm >= 2){
            list_slmuon.add(1);
            list_slmuon.add(2);
        }
    }
    if (slcon == 1) {
        list_slmuon.add(1);
    }
    String selected = "";
    
    DocGia dg=(DocGia)context.getAttribute("docgia");
    
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
                    <h1 style="width: 40%; margin-left: 31%" class="page-header">Quản Lý Mượn Sách</h1>
                </div>
            </div>
        </div>
        <div style="float:left; margin: 2% 0% 0% 50%;">
            Số Tài Liệu Còn Được Mượn:&emsp;<%=stlcdm %>
        </div>
        <div style="float:left; margin: 2% 0% 0% 50%;">
            <a href="muonsach_suatailieu.jsp"></a>
            Số Dư Trong Tài Khoản:&emsp;<%=(double)context.getAttribute("sodu") %>
        </div>
        <div style="margin-left: 226px; width: 1100px" class="container">
            <div id="create_second" style="float: left; margin-top: 40px; display: block; margin-left: 8%">
                <form action="Manager_MuonSach_Servlet" onsubmit="return checkAdd_muonsach_themtailieu()">
                    <div id="left" style="float: left; margin-left: -6%">
                        <div style="margin-left: 30px; margin-bottom: 10px; float: left">
                            Tên Tài Liệu
                            <select id="tentl" name="matl" style="height: 32px; border-radius: 4px; width: 168px" 
                                onchange="selectTL_muonsach_themtailieu(this)"
                            >
                                <option value="" disabled selected hidden> select here..</option>    
                                <%for (int i = 0; i < list_matli.size(); i++) {%>
                                <%
                                    if (list_matli.get(i).toString().equals(matl)) {
                                        selected = "selected";
                                    } else {
                                        selected = "";
                                    }
                                %>
                                <option <%=selected%> value="<%=list_matli.get(i)%>"><%=list_tentli.get(i)%></option>
                                <%}%>
                            </select>
                        </div>
                        <div style="margin-left: 56px;margin-bottom: 10px; float: left">
                            Số Lượng Còn
                            <input name="slcon" value="<%=slcon%>" id="slcon" style="border-style: groove;border-radius: 4px;height: 32px; text-align: center; width: 80px" type="text" readonly="true">
                        </div>
                        <div style="margin-left: 56px; margin-bottom: 10px; float: left">
                            Số Lượng Mượn
                            <select name="slmuon" style="height: 32px; border-radius: 4px; width: 80px">
                                <%for (int i = 0; i < list_slmuon.size(); i++) {%>
                                <option  value="<%=list_slmuon.get(i)%>"><%=list_slmuon.get(i)%></option>
                                <%}%>
                            </select>
                        </div>
                        <div style="margin-left: 56px;margin-bottom: 10px; float: left">
                            Giá Tiền
                            <input name="giatien" value="<%=giaTien%>" id="slcon" style="border-style: groove;border-radius: 4px;height: 32px; text-align: center; width: 80px" type="text" readonly="true">
                        </div>
                    </div>
                    <div class="col-sm-4" style="margin-left: 32%; margin-top: 16px; margin-bottom: 8px;">
                        <a href="trangchu_muonsach.jsp">
                            <button style="background-color: #30a5ff; margin-right: 22%" type="button" class="btn btn-primary">
                                <span class="glyphicon glyphicon-chevron-left"></span> Hủy
                            </button>
                        </a>
                        <button style="background-color: #30a5ff;" type="submit" class="btn btn-primary">
                            <i class="fa fa-plus add"></i> Đăng Ký Mượn
                        </button>
                    </div>
                </form>
            </div>
                <div style="clear: both; margin-left: 18%"><p style="color: deeppink;"> <%= (request.getAttribute("mess_over") == null ? "" : request.getAttribute("mess_over"))%></p></div>
                <div style="clear: both; margin-left: 32%"><p style="color: deeppink;"> <%= (request.getAttribute("mess_choosed") == null ? "" : request.getAttribute("mess_choosed"))%></p></div>
                <div style="clear: both; margin-left: 12%"><p style="color: deeppink;"> <%= (request.getAttribute("mess_money") == null ? "" : request.getAttribute("mess_money"))%></p></div>
            </div>
        </div>
    </div>	
</body>
</html>