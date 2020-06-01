<%-- 
    Document   : order_history
    Created on : Apr 20, 2020, 2:15:22 PM
    Author     : Truong98
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shoes Shop</title>
        <%@include file="/shared/customer/head.jsp" %>
    </head>

    <body>

        <style>
            .nav-item-active{
                background-color: rgb(236, 236, 236);
            }
        </style>

        <div id="page">
            <%@include file="/shared/customer/nav-bar.jsp" %>
            <div class="ftco-navbar-light" style="display: flex; margin-left: 75px; margin-top: 15px;">
                <%@include file="/shared/customer/accountMenu.jsp" %>

                <div class="row" style="margin-left: 15px; ">
                    <div class="col-md-12 ftco-animate">
                        <div class="cart-list" style="width: 887px;">
                            <table class="table" style="display: block; min-width: 887px !important; overflow: hidden;" >
                                <thead class="thead-primary" style="width: 100%;">
                                    <tr class="text-center">
                                        <th style="padding: 20px 15px;">Mã đơn hàng</th>
                                        <th style="padding: 20px 15px;">Ngày mua</th>
                                        <th style="padding: 20px 15px; width: 200px !important;">Sản phẩm</th>
                                        <th style="padding: 20px 15px;">Số lượng</th>
                                        <th style="padding: 20px 15px;">Giá tiền</th>
                                        <th style="padding: 20px 15px; width: 200px;">Trạng thái đơn hàng</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${orders}" var="item">
                                          <c:forEach items="${item.listOrderDetail}" var="item2">
                                            <tr class="text-center">
                                                <td class="total" style="padding: 20px 15px;">${item2.id.madh}</td>
                                                <td class="total" style="padding: 20px 15px;"><fmt:formatDate value="${item.ngayDat}" pattern="dd-MM-yyyy"/></td>
                                                 <td class="total" style="padding: 20px 15px;">${item2.product.tensp}</td>
                                                <td class="total" style="padding: 20px 15px;">${item2.soluong}</td>
                                                <td class="price" style="padding: 20px 15px;"><fmt:formatNumber type = "number" 
                                                                                     maxFractionDigits = "3" value = "${item2.gia}" />đ</td>
                                                <td class="total" style="padding: 20px 15px; width: 200px !important;">${item.tinhTrang}</td>
                                            </tr><!-- END TR-->
                                        </c:forEach>
                                      
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
            <%@include file="/shared/customer/footer.jsp" %>
        </div>
        <script type="text/javascript">

            var element = document.querySelector('#manage-id');
            element.style.background = 'rgb(236, 236, 236)';
        </script>
    </body>
</html>
