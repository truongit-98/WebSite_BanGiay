<%-- 
    Document   : home_admin
    Created on : May 21, 2020, 6:23:33 AM
    Author     : Quang Vinh
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
        <%@include file="/admin/shared/header.jsp" %>
        <div class='main-container' id='main-container'>
            <script type="text/javascript">
                try {
                    ace.settings.check('main-container', 'fixed')
                } catch (e) {
                }
            </script>
            <%@include file="/admin/shared/sidebar.jsp" %>
            <div class='main-content'>
                <div class="main-content-inner">
                    <div class="page-content">
                        <h1>Thông tin sản phẩm</h1>
                        <div class="card border-info">
                            <div style="margin-bottom: 10px">
                                <a class="btn btn-primary" href="#">Thêm mới sản phẩm</a>
                            </div>
                            <table id="dynamic-table" class="table table-striped table-bordered table-hover center" >
                                <thead style="text-align: center">
                                    <tr>
                                        <th>Mã SP</th>
                                        <th>Tên sản phẩm</th>
                                        <th>Số lượng</th>
                                        <th>Đơn giá</th>
                                        <th>Ngày cập nhật</th>
                                        <th></th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="product" items="${products}">
                                        <tr>
                                            <td>${product.masp}</td>
                                            <td>${product.tensp}</td>
                                            <td>${product.soluongtong}</td>
                                            <td>${product.dongia}</td>
                                            <td>${product.ngaycapnhat}</td>
                                            <td style="color: white;">
                                                <a class="btn btn-warning">Sửa</a>
                                                <a class="btn btn-danger">Xóa</a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
            <%@include file="/admin/shared/footer.jsp" %>
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
