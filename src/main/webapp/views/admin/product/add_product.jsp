<%-- 
    Document   : addProduct
    Created on : Jun 2, 2020, 6:18:43 AM
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
                        <h1>Thêm mới sản phẩm</h1>
                        <form method="POST" action="/WebSite_BanGiay/admin/addProduct"  class="colorlib-form">
                            <div style="display: flex;align-items: center;margin-bottom: 12px;">
                                <div style="width: 110px;">Tên sản phẩm</div>
                                <div><input style="width: 500px;"  name="tensp" type="text" class="" required="true"></input></div>
                            </div>
                            <div style="display: flex;align-items: center;margin-bottom: 12px;">
                                <div style="width: 110px;">Số lượng</div>
                                <div><input style="width: 500px;"  name="soluongtong" type="number" class="" ></input></div>
                            </div><!--
-->                            <div style="display: flex;align-items: center;margin-bottom: 12px;">
                                <div style="width: 110px;">Đơn giá</div>
                                <div><input style="width: 500px;"  name="dongia" type="number" class="" ></input></div>
                            </div><!--
-->                            <div style="display: flex;align-items: center;margin-bottom: 12px;">
                                <div style="width: 110px;">Ngày Cập Nhật</div>
                                <div><input style="width: 500px;"  name="NgayCapNhat" type="date" class="" ></input></div>
                            </div><!--
-->                            <div style="display: flex;align-items: center;margin-bottom: 12px;">
                                <div style="width: 110px;">Mô tả</div>
                                <div><input  style="width: 500px;" name="mota" type="text" ></input></div>
                            </div>
                            <div style="display: flex;align-items: center;margin-bottom: 12px;">
                                <div style="width: 110px;">Nhà sản xuất</div>
                                <div><select  style="width: 500px;" name="mansx">
                                        <c:forEach var="producer" items="${producer}">
                                            <option value="${producer.mansx}">${producer.tennsx}</option>
                                        </c:forEach>
                                    </select></div>
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
