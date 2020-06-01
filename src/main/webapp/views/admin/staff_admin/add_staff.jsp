<%-- 
    Document   : admin_User.jsp
    Created on : May 31, 2020, 12:36:40 AM
    Author     : ThongPVT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <c:set var="context" value="${pageContext.request.contextPath}" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
        <meta charset="utf-8" />
        <title>Shoes Shop Admin</title>
        <meta name="description" content="overview &amp; stats" />
        <link href="<c:url value="/resources/css/assets/css/bootstrap.min.css"/>" rel="stylesheet" type="text/css"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
        <link rel="stylesheet" href="<c:url value="/resources/css/assets/css/bootstrap.min.css"/>" />
        <link rel="stylesheet" href="<c:url value="/resources/css/assets/font-awesome/4.2.0/css/font-awesome.min.css"/>" />
        <link rel="stylesheet" href="<c:url value="/resources/css/assets/fonts/fonts.googleapis.com.css"/>" />
        <link rel="stylesheet" href="<c:url value="/resources/css/assets/css/ace.min.css"/>" class="ace-main-stylesheet" id="main-ace-style" />
        <script src="<c:url value="/resources/css/assets/js/ace-extra.min.js"/>"></script>
    </head>
    <body class="no-skin">
        <%@include file="/shared/admin/header.jsp" %>
        <div class='main-container' id='main-container'>
            <script type="text/javascript">
                try {
                    ace.settings.check('main-container', 'fixed')
                } catch (e) {
                }
            </script>
            <%@include file="/shared/admin/sidebar.jsp" %>
            <div class='main-content'>
                <div class="main-content-inner">
                    <div class="page-content">
                        <h1>Thêm mới nhân viên</h1>
                        <form method="POST" action="/WebSite_BanGiay/admin/addStaff"  class="colorlib-form">
                            <div style="display: flex;align-items: center;margin-bottom: 12px;">
                                <div style="width: 110px;">Tên nhân viên</div>
                                <div><input style="width: 500px;"  name="tennv" type="text" class="" required="true"></input></div>
                            </div>
                            <div style="display: flex;align-items: center;margin-bottom: 12px;">
                                <div style="width: 110px;">Địa chỉ</div>
                                <div><input style="width: 500px;"  name="diachi" type="text" class="" ></input></div>
                            </div>
                            <div style="display: flex;align-items: center;margin-bottom: 12px;">
                                <div style="width: 110px;">Email</div>
                                <div><input style="width: 500px;"  name="email" type="text" class="" ></input></div>
                            </div>
                            <div style="display: flex;align-items: center;margin-bottom: 12px;">
                                <div style="width: 110px;">Giới tính</div>
                                <div><input style="width: 500px;"  name="gioitinh" type="text" class="" ></input></div>
                            </div>
                            <div style="display: flex;align-items: center;margin-bottom: 12px;">
                                <div style="width: 110px;">Ngày sinh</div>
                                <div><input  style="width: 500px;" name="born" type="date" class="" ></input></div>
                            </div>
                            <div style="display: flex;align-items: center;margin-bottom: 12px;">
                                <div style="width: 110px;">CMND</div>
                                <div><input  style="width: 500px;" name="cmnd" type="text"  ></input></div>
                            </div>
                            <div style="display: flex;align-items: center;margin-bottom: 12px;">
                                <div style="width: 110px;">Mật khẩu</div>
                                <div><input  style="width: 500px;" name="matkhau" type="text" value="1" readonly="true"></input></div>
                            </div>
                            <div  style="    width: 608px;margin-left: 112px;">
                                <input  type="submit" class="btn btn-primary" value="Lưu"></input>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <%@include file="/shared/admin/footer.jsp" %>
        </div>
        <script src="<c:url value="/resources/css/assets/js/jquery.2.1.1.min.js"/>"></script>
        <script type="text/javascript">
                window.jQuery || document.write("<script src='/resources/css/assets/js/jquery.min.js'>" + "<" + "/script>");
        </script>
        <script type="text/javascript">
            if ('ontouchstart' in document.documentElement)
                document.write("<script src='/resources/css/assets/js/jquery.mobile.custom.min.js'>" + "<" + "/script>");
        </script>
        <script src="<c:url value="/resources/css/assets/js/bootstrap.min.js"/>"></script>
        <script src="<c:url value="/resources/css/assets/js/jquery-ui.custom.min.js"/>"></script>
        <script src="<c:url value="/resources/css/assets/js/jquery.ui.touch-punch.min.js"/>"></script>
        <script src="<c:url value="/resources/css/assets/js/jquery.easypiechart.min.js"/>"></script>
        <script src="<c:url value="/resources/css/assets/js/jquery.sparkline.min.js"/>"></script>
        <script src="<c:url value="/resources/css/assets/js/jquery.flot.min.js"/>"></script>
        <script src="<c:url value="/resources/css/assets/js/jquery.flot.pie.min.js"/>"></script>
        <script src="<c:url value="/resources/css/assets/js/jquery.flot.resize.min.js"/>"></script>
        <script src="<c:url value="/resources/css/assets/js/ace-elements.min.js"/>"></script>
        <script src="<c:url value="/resources/css/assets/js/ace.min.js"/>"></script>
    </body>
</html>
