<%@page import="java.sql.ResultSet"%>
<%@page import="dao.PhieuMuonChiTiet_DAO"%>
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
    context.setAttribute("context", "pay_pm");
    DocGia dg = (DocGia) context.getAttribute("docgia");
    db_connection db = new db_connection();
    PhieuMuonChiTiet_DAO pmctdao = new PhieuMuonChiTiet_DAO(db);
    ResultSet rs = null;
    String tt = "1";
    try {
        tt = request.getParameter("tt").toString();
    } catch (Exception e) {
    }
    rs = (ResultSet) request.getAttribute("rs_pm");//get from Search_PhieuMuon_Servlet
    
    if (rs == null) {//chua search
        if (tt.equals("1")) {
            rs = pmctdao.display_ChuaTra(dg.getMaDocGia());//fill in rs
            
        } else {
            if (tt.equals("2")) {
                rs = pmctdao.display_DaTra(dg.getMaDocGia());
            } else {
                if (tt.equals("3")) {
                    rs = pmctdao.display_LamMat(dg.getMaDocGia());
                }
                else{
                    if (tt.equals("4")) {
                        rs = pmctdao.display_QuaHan(dg.getSoNgayMuon(), dg.getMaDocGia());
                    }
                    else{
                        if (tt.equals("5")) {
                            rs = pmctdao.displayAll(dg.getMaDocGia());
                        }
                    }
                }
            }
        }
        
    }
    
    String mapm="";
    String searched="";
    try {
            searched = context.getAttribute("searched").toString();//kiem tra xem da chay vao search_sevlet hay chua
        }
    catch (Exception e){
    }
    if(searched.equals("true")){//kiem tra xem da chay vao search_sevlet hay chua <true == roi>
        mapm=request.getAttribute("search_mapm").toString();//lay mapm tu search_sevlet tra lai
        context.removeAttribute("searched");
        
        context.setAttribute("flag_key", "true");//flag search hay chua
        context.setAttribute("mapm", mapm);//chuyen mapm vao sevlet_tra, giu giao dien sau khi tra
        context.setAttribute("tt", tt);//chuyen tt comboselect vao sevlet_tra, giu giao dien sau khi tra
    }
    else{//chua search 
        mapm="";
        context.setAttribute("flag_key", "false");
        context.setAttribute("tt", tt);//chuyen tt comboselect vao sevlet_tra
    }
    
    String disable_Combo="";
    String disable_Button="";
    if(mapm!=""){
         rs = pmctdao.display_MaPM(dg.getMaDocGia(), mapm);
         disable_Combo="display: none";
         disable_Button="display: block";
    }
    else{
        disable_Combo="display: block";
        disable_Button="display: none";
    }
    String disabled_table="";
    try{
        disabled_table   = request.getAttribute("mess_notfind").toString().equals("Not Find")?"display: none":"";
    }
    catch(Exception e){
        
    }
    
    String quaHan="";
    if (tt.equals("4")) {
        quaHan="Quá Hạn";
    }
    
%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <%@ page contentType="text/html; charset=UTF-8" %>
        <title>Quản Lý Trả Sách</title>
        <jsp:include page="head.jsp" />
    </head>
    <body>
        <jsp:include page="title_librarian.jsp" />
        <div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar">
            <jsp:include page="user_status.jsp" />
            <ul class="nav menu" style="margin: 0px">
                <li class="table_hover"><a href="thongtin_thuthu.jsp"><span class="glyphicon glyphicon-user"></span> Thông Tin Cá Nhân</a></li>
                <li class="table_hover"><a href="suathongtin_thuthu.jsp"><span class="glyphicon glyphicon-pencil"></span> Sửa Thông Tin Cá Nhân</a></li>
                <li class="table_hover"><a href="muonsach_madocgia.jsp"><span class="glyphicon glyphicon-tasks"></span> Quản Lý Mượn Sách</a></li>
                <li class="active table_hover"><a href="trasach_madocgia.jsp"><span class="glyphicon glyphicon-transfer"></span> Quản Lý Trả Sách</a></li>
                <li class="table_hover"><a href="thongke_baocao.jsp"><span class="glyphicon glyphicon-indent-right"></span> Thống Kê, Báo Cáo</a></li>
                <li class="table_hover"><a  onclick="return xacNhan()" href="Logout_Servlet"><span class="glyphicon glyphicon-off"></span> Đăng Xuất</a></li>
            </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
            <div class="row">
                <ol class="breadcrumb">
                    <li><a href="trasach_madocgia.jsp">
                            <em class="fa fa-home"></em>
                        </a></li>
                    <li class="active">Quản Lý Trả Sách</li>
                </ol>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <h1 style="width: 40%; margin-left: 32%" class="page-header">Quản Lý Trả Sách</h1>
                </div>
            </div>
        </div>
        <div style="margin-left: 226px; width: 1100px" class="container">
            <div id="create_first">
                <div style="float: left; margin-left: 11%; margin-bottom: 2%">
                    <form style="float: left;" action="Search_PhieuMuon_Servlet">
                        <div style="margin: 10px 10px 10px 0px; float: left">
                            Mã Phiếu Mượn
                            <input name="mapm" value="<%=mapm %>" id="mapm"  style="width: 171px ;border-style: groove;border-radius: 4px;height: 32px" type="text" required>
                            <a>
                                <button style="background-color: #30a5ff; height: 32px;line-height: 0px;margin-bottom: 4px;" type="" class="btn btn-info add-new">
                                    <span class="fa fa-search"></span>  Tìm
                                </button>
                            </a>
                        </div>
                    </form>
                    <div style="margin: 10px 10px 10px 22px; float: left">
                        Tên Độc Giả
                        <input name="tendg" value="<%=dg.getHoTen()%>"  style="border-style: groove;border-radius: 4px;height: 32px" type="text" readonly="true">
                        <a  onclick="return xacNhan()" href="trasach_madocgia.jsp">
                            <button style="height: 32px;line-height: 0px;margin-bottom: 4px;" type="" class="btn btn-warning">
                                <span class="glyphicon glyphicon-repeat"></span>  Chọn Độc Giả Khác
                            </button>
                        </a>
                    </div>
                </div>
            </div>
        </div>
        <div id="create_second" style="display: block; margin-left: 17.8%; margin-right: 1%">
            <div>
                <div style="<%=disable_Combo %>">
                    <select class="table_hover" onchange="selectTT_trasach(this)" name="matlo" style="border: 1px solid #ddd; height: 34px;width: 14.2%;border-radius: 5px; margin-bottom: 10px;">
                        <option value="1" <%=tt.equals("1") ? "selected" : ""%>>Chưa Trả</option>
                        <option value="2" <%=tt.equals("2") ? "selected" : ""%>>Đã Trả</option>
                        <option value="3" <%=tt.equals("3") ? "selected" : ""%>>Làm Mất</option>
                        <option value="4" <%=tt.equals("4") ? "selected" : ""%>>Quá Hạn</option>
                        <option value="5" <%=tt.equals("5") ? "selected" : ""%>>Tất Cả</option>
                    </select> 
                </div>
                
                    <div style="<%=disabled_table %>;">
                    <table class="table table-bordered table_hover" id="table" style="border-radius: 10px;border-style: hidden;">
                        <thead>
                            <tr>
                                <th style="">Mã Phiếu Mượn</th>
                                <th style="">Mã Tài Liệu</th>
                                <th>Tên Tài Liệu</th>
                                <th>Tên Nhân Viên</th>
                                <th style="width: 90px">Số Lượng Mượn</th>
                                <th style="">Giá Tiền</th>
                                <th style="">Ngày Mượn</th>
                                <th style="">Ngày Trả</th>
                                <th style="">Tình Trạng</th>
                                <th style="width: 17%">Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%while (rs.next()) {%>
                            <tr>
                                <td><%=rs.getString("MaPhieuMuon")%></td>
                                <td><%=rs.getString("MaTaiLieu")%></td>
                                <td><%=rs.getString("TenTaiLieu")%></td>
                                <td><%=rs.getString("hoTen")%></td>
                                <td><%=rs.getString("SoluongMuon")%></td>
                                <td><%=rs.getString("GiaTien")%></td>
                                <td><%=rs.getString("NgayMuon")%></td>
                                <td><%=rs.getString("NgayTra")%></td>
                                <td><%=rs.getString("Mat").equals("1")?"Làm Mất":(rs.getString("NgayTra")!=null?"Đã Trả":(quaHan.equals("")?"Chưa Trả":"Quá Hạn")) %></td>
                                <td>
                                    <a onclick="return xacNhan()" href="Manager_TraSach_Servlet?mapm=<%=rs.getString("MaPhieuMuon")%>&matl=<%=rs.getString("MaTaiLieu")%>&slm=<%=rs.getString("SoluongMuon")%>&mdg=<%=dg.getMaDocGia() %>&giatien=<%=rs.getString("GiaTien")%>">
                                        <button <%=rs.getString("NgayTra") == null ? "" : "disabled"%> class="btn btn-<%=rs.getString("NgayTra") == null ? "primary" : "danger"%>">
                                            <span class="glyphicon glyphicon-shopping-cart"></span>  Trả
                                        </button>
                                    </a>
                                    <a onclick="return xacNhan()" href="MatSach_Servlet?mapm=<%=rs.getString("MaPhieuMuon")%>&matl=<%=rs.getString("MaTaiLieu")%>&slm=<%=rs.getString("SoluongMuon")%>&mdg=<%=dg.getMaDocGia() %>&giatien=<%=rs.getString("GiaTien")%>">
                                       <button <%=rs.getString("NgayTra") == null ? "" : "disabled"%> class="btn btn-<%=rs.getString("NgayTra") == null ? "primary" : "danger"%>">
                                            <span class="glyphicon glyphicon-alert"></span>  Mất
                                       </button>
                                    </a>
                                </td>
                            </tr>
                            <%}%>
                        </tbody>
                    </table>
                </div>
                <div style="<%=disable_Button %>">
                    <!-- khong can thuoc tinh display. "" == display: none-->
                    <p style="margin-left: 43%; color: red"><%=request.getAttribute("mess_notfind")==null?"":request.getAttribute("mess_notfind").toString() %></p>
                    
                    <a href="trangchu_trasach.jsp"><button style="height: 32px;line-height: 0px;margin:0px 0px 8px 2px;" type="" class="btn btn-primary add-new"><span class="glyphicon glyphicon-chevron-left"></span>  Back</button></a>
                </div>
            </div>
        </div>
    </div>
</div>	
</body>
</html>