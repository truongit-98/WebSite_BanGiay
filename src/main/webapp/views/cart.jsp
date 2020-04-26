<%-- 
    Document   : cart
    Created on : Apr 12, 2020, 4:20:17 PM
    Author     : Truong98
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page import="com.nhom12.Database.Models.CartModel" %>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="/shared/head.jsp"%>
    </head>
    <body>
        <style>
            .addcart {
                background: #616161;
                border-radius: 5px;
                box-shadow: none;
                border: none;
                color: #FFF;
                cursor: pointer;
                padding: 8px 20px;
            }

            .addcart:hover {
                background: black;
            }
        </style>
        <div id="page">
            <%@include file="/shared/nav-bar.jsp" %>   
            <div class="breadcrumbs">
                <div class="container">
                    <div class="row">
                        <div class="col">
                        </div>
                    </div>
                </div>
            </div>
            <div class="container">
                <div class="row row-pb-lg">
                    <div class="col-md-10 offset-md-1">
                        <div class="process-wrap">
                            <div class="process text-center active">
                                <p><span>01</span></p>
                                <h3>Shopping Cart</h3>
                            </div>
                            <div class="process text-center">
                                <p><span>02</span></p>
                                <h3>Checkout</h3>
                            </div>
                            <div class="process text-center">
                                <p><span>03</span></p>
                                <h3>Order Complete</h3>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row row-pb-lg">
                    <div class="col-md-12">
                        <div class="product-name d-flex">
                            <div class="one-forth text-left px-4">
                                <span>Product Details</span>
                            </div>
                            <div class="one-eight text-center">
                                <span>Price</span>
                            </div>
                            <div class="one-eight text-center">
                                <span>Quantity</span>
                            </div>
                            <div class="one-eight text-center">
                                <span>Total</span>
                            </div>
                            <div class="one-eight text-center px-4">
                                <span>Remove</span>
                            </div>
                        </div>
                        <c:forEach items="${cartModels}" var="item">
                            <div class="product-cart d-flex">
                                <div class="one-forth">
                                    <div class="product-img" style="background-image: url('<c:url value="/resources/images/${item.urlImg}"/>');">
                                    </div>
                                    <div class="display-tc">
                                        <h3>${item.productName} (Size ${item.sizeName})</h3>
                                    </div>
                                </div>
                                <div class="one-eight text-center">
                                    <div class="display-tc">
                                        <span><span class="price"><fmt:formatNumber type = "number" 
                                                          maxFractionDigits = "3" value = "${item.price}" /><span>đ</span></span></span>
                                    </div>
                                </div>
                                <div class="one-eight text-center" s>
                                    <div class="display-tc" >
                                        <input type="number" class="quantity-cart" name="quantity" data-id="${item.productId}" data-size="${item.sizeId}" class="form-control input-number text-center" value="${item.quantity}" min="1" max="100">
                                    </div>
                                </div> 
                                <div class="one-eight text-center">
                                    <div class="display-tc">
                                        <span><span class="totals"><fmt:formatNumber type = "number" 
                                                          maxFractionDigits = "3" value = "${item.price * item.quantity}" /><span>đ</span></span></span>
                                    </div>
                                </div>                           
                                <div class="one-eight text-center">
                                    <div class="display-tc">
                                        <a href="#" class="closed" data-id="${item.productId}" data-size="${item.sizeId}"></a>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
                <div class="row row-pb-lg">
                    <div class="col-md-12">
                        <div class="total-wrap">
                            <div class="row">
                                <div class="col-sm-8">

                                </div>
                                <div class="col-sm-4 text-center">
                                    <div class="total">
                                        <div class="sub">

                                            <%  List<CartModel> carts = (List<CartModel>) session.getAttribute("cartSession");
                                                long totalCart = 0;
                                                for (CartModel c : carts) {
                                                    totalCart += c.getPrice() * c.getQuantity();
                                                }
                                            %>
                                            <p><span>Subtotal:</span> <span class="sub-totals"><fmt:formatNumber type = "number" 
                                                    maxFractionDigits = "3" value = "<%= totalCart%>" />đ</span></p>
                                            <p><span>Delivery:</span> <span>0</span></p>
                                            <p><span>Discount:</span> <span>0</span></p>
                                        </div>
                                        <div class="grand-total">
                                            <p><span><strong>Total:</strong></span> <span class="cart-totals"><fmt:formatNumber type = "number" 
                                                    maxFractionDigits = "3" value = "<%= totalCart%>" />đ</span></p>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-12 center">
                                            <a href ="/WebSite_BanGiay/customer/checkout" class="btn btn-primary">Đặt hàng</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-8 offset-sm-2 text-center colorlib-heading colorlib-heading-sm">
                        <h2>Sản phẩm bán chạy</h2>
                    </div>
                </div>
                <div class="row">
                    <c:if test="${sellingProducts.size() == 4}">
                        <c:forEach items="${sellingProducts}" var="item"> 
                            <div class="col-md-3 col-lg-3 mb-4 text-center">
                            <div class="product-entry border">
                                <a href="#" class="prod-img">
                                    <img src="<c:url value="/resource/images/${item.anh}"/>" class="img-fluid" alt="Free html5 bootstrap 4 template">
                                </a>
                                <div class="desc">
                                    <h2><a href="#">${item.tensp}</a></h2>
                                    <span class="price"><fmt:formatNumber pattern="#,##0" value = "${item.dongia}" />đ</span>
                                </div>
                            </div>
                        </div>
                        </c:forEach>
                    </c:if>
                </div>
            </div>
            <%@include file="/shared/footer.jsp" %>
        </div>
        <script src="<c:url value="/resources/js/myjs.js"/>"></script>
    </body>
</html>
