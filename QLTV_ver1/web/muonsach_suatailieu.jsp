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
    //
    String matlm = "";
    matlm = request.getParameter("matlm");
    int slcon_edit = tldao.getSoLuongCon(matlm);
    double gt=Double.valueOf(request.getParameter("giaTien"));
    //
    ArrayList<Integer> list_slmuon = new ArrayList<Integer>();
    if (slcon >= 2 || slcon_edit >= 2) {
        list_slmuon.add(1);
        list_slmuon.add(2);
    }
    if (slcon == 1 || slcon_edit == 1) {
        list_slmuon.add(1);
    }

    String selected = "";
    String selected_edit = "";
    String slm = "";
    
    double tongTien=Double.valueOf(context.getAttribute("tongtien").toString());
    int stlcdm = Integer.valueOf(context.getAttribute("stlcdm").toString());
    double soDu=Double.valueOf(context.getAttribute("sodu").toString());
    
    
    ArrayList<TaiLieuMuon> list_tlm = null;
    list_tlm = (ArrayList<TaiLieuMuon>) context.getAttribute("list_tlm");
    for (int i = 0; i < list_tlm.size(); i++) {
        if (list_tlm.get(i).getMaTaiLieu().equals(matlm)) {
            
            context.setAttribute("tongtien", tongTien-(list_tlm.get(i).getGiaTien() *list_tlm.get(i).getSoLuong()));
            
            context.setAttribute("stlcdm", stlcdm + Integer.valueOf(request.getParameter("slm")));
            
            context.setAttribute("sodu", soDu + Integer.valueOf(request.getParameter("slm")) * Double.valueOf(request.getParameter("giaTien")));
            
            list_tlm.remove(i);
        }
    }
    
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
                <li class="table_hover"><a href="thongtin_thuthu.jsp"><span class="glyphicon glyphicon-th-list"></span> Thông Tin Cá Nhân</a></li>
                <li class="table_hover"><a href="suathongtin_thuthu.jsp"><span class="glyphicon glyphicon-th-list"></span> Sửa Thông Tin Cá Nhân</a></li>
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
        <div style="float:left; margin: 2% 0% 0% 50%;">
            Số Tài Liệu Còn Được Mượn:&emsp;<%=Integer.valueOf(context.getAttribute("stlcdm").toString()) %>
        </div>
        <div style="float:left; margin: 2% 0% 0% 50%;">
            Số Dư Trong Tài Khoản:&emsp;<%=Double.valueOf(context.getAttribute("sodu").toString()) %>
        </div>
        <div style="margin-left: 226px; width: 1100px" class="container">
            <div id="create_second" style="float: left; margin-top: 40px; display: block; margin-left: 8%">
                <form action="Manager_MuonSach_Servlet" onsubmit="return checkAdd_muonsach_suatailieu()">
                    <div id="left" style="float: left; margin-left: -4%">
                        <div style="margin-left: 30px; margin-bottom: 10px; float: left">
                            Tên Tài Liệu
                            <select id="tentl" name="matl" style="height: 32px; border-radius: 4px; width: 168px" onchange="selectTL_muonsach_suatailieu(this)">
                                <option value="" disabled selected hidden> select here..</option>    
                                <%for (int i = 0; i < list_matli.size(); i++) {%>
                                <%
                                    if (list_matli.get(i).toString().equals(matl)) {
                                        selected = "selected";
                                    } else {
                                        selected = "";
                                    }
                                    if (list_matli.get(i).toString().equals(request.getParameter("matlm"))) {
                                        selected_edit = "selected";
                                    } else {
                                        selected_edit = "";
                                    }
                                %>
                                <option <%=selected%> <%=selected_edit%> value="<%=list_matli.get(i)%>"><%=list_tentli.get(i)%></option>
                                <%}%>
                            </select>
                        </div>
                        <div style="margin-left: 56px;margin-bottom: 10px; float: left">
                            Số Lượng Còn
                            <input name="slcon" value="<%=slcon_edit%>" id="slcon" style="border-style: groove;border-radius: 4px;height: 32px; text-align: center; width: 80px" type="text" readonly="true">
                        </div>
                        <div style="margin-left: 56px; margin-bottom: 10px; float: left">
                            Số Lượng Mượn
                            <select name="slmuon" style="height: 32px; border-radius: 4px; width: 80px">
                                <%for (int i = 0; i < list_slmuon.size(); i++) {%>
                                <%
                                    if (list_slmuon.get(i).toString().equals(request.getParameter("slm"))) {
                                        slm = "selected";
                                    } else {
                                        slm = "";
                                    }
                                %>
                                <option <%=slm%> value="<%=list_slmuon.get(i)%>"><%=list_slmuon.get(i)%></option>
                                <%}%>
                            </select>
                        </div>
                        <div style="margin-left: 56px;margin-bottom: 10px; float: left">
                            Giá Tiền
                            <input name="giatien" value="<%=gt%>" id="slcon" style="border-style: groove;border-radius: 4px;height: 32px; text-align: center; width: 80px" type="text" readonly="true">
                        </div>  
                    </div>
                    <div class="col-sm-4" style="margin-left: 35%; margin-top: 16px; margin-bottom: 8px;">
                        <a href="Cancel_Edit_TaiLieuMuon_Servlet"><button style="background-color: #30a5ff; margin-right: 22%" type="button" class="btn btn-primary"><span class="glyphicon glyphicon-chevron-left"></span> Cancel</button></a>
                        <button style="background-color: #30a5ff;" type="submit" class="btn btn-primary"><i class="fa fa-plus add"></i> Confirm</button>
                    </div>
                </form>
            </div>
        </div>
    </div>	
</body>
</html>