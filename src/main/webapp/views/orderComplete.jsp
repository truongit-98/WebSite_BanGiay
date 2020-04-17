<%-- 
    Document   : orderComplete
    Created on : Apr 17, 2020, 7:27:14 PM
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
                                <div class="process text-center active">
                                    <p><span>03</span></p>
                                    <h3>Order Complete</h3>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-10 offset-sm-1 text-center">
                            <p class="icon-addcart"><span><i class="icon-check"></i></span></p>
                            <h2 class="mb-4">Cảm ơn bạn đã mua hàng, đơn hàng của bạn đang được xử lý !!!</h2>
                            <p>
                                <a href="/WebSite_BanGiay/home" class="btn btn-primary btn-outline-primary">Home</a>
                                <a href="/WebSite_BanGiay/home" class="btn btn-primary btn-outline-primary"><i class="icon-shopping-cart"></i> Continue Shopping</a>
                            </p>
                        </div>
                    </div>
                </div>
            </div>

            <%@include file="/shared/footer.jsp" %>
        </div>
    </body>
</html>
