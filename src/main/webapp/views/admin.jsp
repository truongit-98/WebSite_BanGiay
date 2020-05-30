<%-- 
    Document   : admin
    Created on : Apr 21, 2020, 10:16:51 AM
    Author     : Quang Vinh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="/shared/head.jsp" %>
    </head>
    <body>
        <div id="page">
            <%@include file="/admin/header.jsp" %>
            
          
            <aside>
                <div class="container">
                    <h2>Thông tin tất cả các sản phẩm</h2>
                    <div class="card border-info">
                        <div class="card-header bg-info text-while">
                            <a class="btn btn-primary" href="#">Thêm mới sản phẩm</a>
                        </div>
                        <table class="table table-hover" style="text-align: center">
                            <thead>
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
            </aside>
                        <%@include file="../admin/sider.jsp" %>

            <%@include file="/admin/footer.jsp" %>
        </div>
    </body>
</html>
