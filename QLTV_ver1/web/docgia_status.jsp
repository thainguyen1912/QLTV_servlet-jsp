<%@page import="dao.db_connection"%>
<%@page import="dao.DocGia_DAO"%>
<%@page import="enity.DocGia"%>
<%@ page import="enity.NhanVien"%>
<div class="profile-sidebar">
    <div class="profile-userpic">
        <img src="images/meo1.jpg" class="img-responsive  table_hover" alt="">
    </div>
    <div class="profile-usertitle">
        <div class="profile-usertitle-name" style="font-size: 14px">
            <%
                db_connection db=new db_connection();
                String maDocGia = session.getAttribute("user").toString();
                DocGia_DAO dgdao=new DocGia_DAO(db);
                DocGia dg = dgdao.getOneDocGia(maDocGia);
            %>
            <%=dg.getHoTen()%>
        </div>
        <div class="profile-usertitle-status"><span class="indicator label-success"></span>Online</div>
    </div>
    <div class="clear"></div>
</div>