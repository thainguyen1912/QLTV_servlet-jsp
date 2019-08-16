<%@page import="dao.db_connection"%>
<%@page import="dao.DocGia_DAO"%>
<%@page import="enity.DocGia"%>
<%
    ServletContext context=getServletContext();
    context.setAttribute("key", "naptk");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <%@ page contentType="text/html; charset=UTF-8" %>
        <title>Nạp Tài Khoản</title>
        <jsp:include page="head.jsp" />
    </head>
    <body>
        <jsp:include page="title_readers.jsp" />
        <div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar">
            <jsp:include page="docgia_status.jsp" />
            <ul class="nav menu" style="margin: 0px">
                <li class="table_hover"><a href="thongtin_docgia.jsp"><span class="glyphicon glyphicon-user"></span> Thông Tin Độc Giả</a></li>
                <li class="table_hover"><a href="suathongtin_docgia.jsp"><span class="glyphicon glyphicon-edit"></span> Sửa Thông Tin Độc Giả</a></li>
                <li class="table_hover"><a href="danhsach_tailieu_docgia.jsp"><span class="glyphicon glyphicon-list-alt"></span> Tài Liệu Đang Mượn</a></li>
                <li class="active table_hover"><a href="docgia_naptaikhoan.jsp"><span class="glyphicon glyphicon-usd"></span> Nạp Tài Khoản</a></li>
                <li class="table_hover"><a  onclick="return xacNhan()" href="Logout_Servlet"><span class="glyphicon glyphicon-off"></span> Đăng Xuất</a></li>
            </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
            <div class="row">
                <ol class="breadcrumb">
                    <li><a href="docgia_naptaikhoan.jsp">
                            <em class="fa fa-home"></em>
                        </a></li>
                    <li class="active">Nạp Tài Khoản</li>
                </ol>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <h1 style="width: 40%; margin-left: 34%" class="page-header">Nạp Tài Khoản</h1>
                </div>
            </div>
            <form action="ThongTin_DocGia_Servlet">
                <div style="margin-left: 31%">
                    <div style="overflow: auto;margin-bottom: 8px;">
                        <p style="float: left; margin: 6px; font-size: 16px">Mã Thẻ Nạp</p>
                        <input value="" id="madg" name="mathe" style="width: 174px; border-style: groove;border-radius: 4px;height: 32px;float: left" type="text" placeholder=" type here.." required>
                        <div style="float: left; margin-left: 10px">
                            <a><button style="height: 31px;line-height: 2px;" type="submit" class="btn btn-primary"><span class="glyphicon glyphicon-ok"></span>  Nạp</button></a>
                        </div>
                    </div>
                    <div style="clear: both; margin-left: 7%"><p style="color: deeppink;"> <%= (request.getAttribute("mess_f") == null ? "" : request.getAttribute("mess_f"))%></p></div>
                    <div style="clear: both; margin-left: -7%"><p style="color: deeppink;"> <%= (request.getAttribute("mess_t") == null ? "" : request.getAttribute("mess_t"))%></p></div>
                </div>
            </form>
                
                <div style="float: left; margin-left: 41.7%; margin-top: 2%;">
                    <a href="thongtin_docgia.jsp"><button style="background-color: #30a5ff;height: 31px;line-height: 2px;" type="submit" class="btn btn-info add-new"><span class="glyphicon glyphicon-home"></span>  Trang Thông Tin</button></a>
                </div>
                
        </div>
    </body>
</html>