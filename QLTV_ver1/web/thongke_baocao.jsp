<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <%@ page contentType="text/html; charset=UTF-8" %>
        <title>Thống Kê - Báo Cáo</title>
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
                <li class="table_hover"><a href="trasach_madocgia.jsp"><span class="glyphicon glyphicon-transfer"></span> Quản Lý Trả Sách</a></li>
                <li class="active table_hover"><a href="thongke_baocao.jsp"><span class="glyphicon glyphicon-indent-right"></span> Thống Kê, Báo Cáo</a></li>
                <li class="table_hover"><a  onclick="return xacNhan()" href="Logout_Servlet"><span class="glyphicon glyphicon-off"></span> Đăng Xuất</a></li>
            </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
            <div class="row">
                <ol class="breadcrumb">
                    <li><a href="thongke_baocao.jsp">
                            <em class="fa fa-home"></em>
                        </a></li>
                    <li class="active">Thống Kê - Báo Cáo</li>
                </ol>
            </div>
        </div>
        <div>
            <jsp:include page="main_tk_bc.jsp" />
        </div>
    </body>
</html>