<%-- 
    Document   : checkout
    Created on : Apr 16, 2020, 10:14:31 PM
    Author     : Truong98
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shoes Shop</title>
        <%@include file="/shared/head.jsp" %>
    </head>
    <body>
        <div id="page">
            <%@include file="/shared/nav-bar.jsp" %>
            <div class="colorlib-product">
                <div class="container">
                    <div class="row row-pb-lg">
                        <div class="col-sm-10 offset-md-1">
                            <div class="process-wrap">
                                <div class="process text-center active">
                                    <p><span>01</span></p>
                                    <h3>Shopping Cart</h3>
                                </div>
                                <div class="process text-center active">
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
                    <div class="row">
                        <div class="col-lg-8">
                            <div class="info"  style="display:block; padding: 10px; width: 100%; margin: auto;">
                                <b>Tên người nhận: ${customer.tenKH}</b>
                                <p>SĐT: ${customer.sdt}</p>
                                <P>Địa chỉ giao hàng: ${customer.diaChi}</p>
                            </div>
                        </div>
                        <div class="col-lg-4">
                            <div class="row">
                                <div class="col-md-18">
                                    <div class="cart-detail">
                                        <h2>Cart Total</h2>
                                        <ul>
                                            <li>
                                                <span>Subtotal</span> <span>$100.00</span>
                                                <ul>
                                                    <c:forEach items="${cartModels}" var="item">
                                                        <li><span>${item.quantity} x ${item.productName}</span> <span>${item.price * item.quantity}</span></li>
                                                        </c:forEach>
                                                </ul>
                                            </li>
                                            <li><span>Shipping</span> <span>$0.00</span></li>
                                            <li><span>Order Total</span> <span>${total}</span></li>
                                        </ul>
                                    </div>
                                </div>
                                <div class="w-100"></div>
                                <form>
                                    <div class="col-md-18">
                                        <div class="cart-detail">
                                            <h2>Payment Method</h2>
                                            <div class="form-group">
                                                <div class="col-md-12">
                                                    <div class="radio">
                                                        <label><input type="radio" required  name="bankTranfer">Chuyển khoản ngân hàng</label>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-md-12">
                                                    <div class="radio">
                                                        <label><input type="radio" name="payment"> Check Payment</label>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-md-12">
                                                    <div class="radio">
                                                        <label><input type="radio" name="paypal"> Paypal</label>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-12 text-center">
                                            <p><input  type="submit" class="btn btn-primary" value="Tiến hành đặt hàng"></input></p>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <%@include file="/shared/footer.jsp" %>
        </div>
    </body>
</html>
