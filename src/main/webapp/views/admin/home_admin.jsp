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
      <%@include file="/shared/admin/head.jsp" %>
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
            <%@include file="/shared/admin/footer.jsp" %>
        </div>
       
    </body>
</html>
