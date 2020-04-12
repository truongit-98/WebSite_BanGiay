<%-- 
    Document   : index
    Created on : Apr 6, 2020, 9:43:58 AM
    Author     : Truong98
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="/shared/head.jsp" %>
    </head>
    <body>
        <c:set var="context" value="${pageContext.request.contextPath}" />

        <div id="page">
            <%@include file="/shared/nav-bar.jsp" %>
            <aside id="colorlib-hero">
                <div class="flexslider">
                    <ul class="slides">
                        <li style="background-image: url(<c:url value="/resources/images/img_bg_1.jpg"/>);">
                            <div class="overlay">
                                <img src="<c:url value="/resources/images/img_bg_1.jpg"/>" alt="Alternate Text" />
                            </div>
                            <div class="container-fluid">
                                <div class="row">
                                    <div class="col-sm-6 offset-sm-3 text-center slider-text ">
                                        <div class="slider-text-inner">
                                            <div class="desc">
                                                <h1 class="head-1">Men's</h1>
                                                <h2 class="head-2">Shoes</h2>
                                                <h2 class="head-3">Collection</h2>
                                                <p class="category"><span>New trending shoes</span></p>
                                                <p><a href="#" class="btn btn-primary">Shop Collection</a></p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                        </li>
                        <li style="background-image: url(<c:url value="/resources/images/img_bg_2.jpg"/>);">
                            <div class="overlay">
                                <img src="<c:url value="/resources/images/img_bg_2.jpg"/>" />
                            </div>
                            <div class="container-fluid">
                                <div class="row">
                                    <div class="col-sm-6 offset-sm-3 text-center slider-text">
                                        <div class="slider-text-inner">
                                            <div class="desc">
                                                <h1 class="head-1">Huge</h1>
                                                <h2 class="head-2">Sale</h2>
                                                <h2 class="head-3"><strong class="font-weight-bold">50%</strong> Off</h2>
                                                <p class="category"><span>Big sale sandals</span></p>
                                                <p><a href="#" class="btn btn-primary">Shop Collection</a></p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </li>
                        <li style="background-image: url(<c:url value="/resources/images/img_bg_3.jpg"/>);">
                            <div class="overlay"><img src="<c:url value="/resources/images/img_bg_3.jpg"/>" alt="Alternate Text" /></div>
                            <div class="container-fluid">
                                <div class="row">
                                    <div class="col-sm-6 offset-sm-3 text-center slider-text">
                                        <div class="slider-text-inner">
                                            <div class="desc">
                                                <h1 class="head-1">New</h1>
                                                <h2 class="head-2">Arrival</h2>
                                                <h2 class="head-3">up to <strong class="font-weight-bold">30%</strong> off</h2>
                                                <p class="category"><span>New stylish shoes for men</span></p>
                                                <p><a href="#" class="btn btn-primary">Shop Collection</a></p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </li>
                    </ul>
                </div>
            </aside>


            <div class="colorlib-product">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-8 offset-sm-2 text-center colorlib-heading">
                            <h2>New Products</h2>
                        </div>
                    </div>
                    <div class="row row-pb-md">
                        <c:forEach items="${products}"  var="item" >
                            <div class="col-lg-3 mb-4 text-center">
                                <div class="product-entry border">
                                    <a href="WebSite_BanGiay/home/${item.masp}" class="prod-img">
                                        <img src="<c:url value="/resources/images/${item.anh}"/>" class="img-fluid" alt="${item.anh}">
                                    </a>
                                    <div class="desc">
                                        <h2><a href="WebSite_BanGiay/home/${item.masp}">${item.tensp}</a></h2>
                                        <i class="icon-shopping-cart cart-hover" data-id="${item.masp}" id="cart-id"></i><span class="price">${item.dongia}</span>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                    <div class="row">
                        <div class="col-md-12 text-center">
                            <p><a href="" class="btn btn-primary btn-lg">Shop All Products</a></p>
                        </div>
                    </div>
                </div>
            </div> 
            <%@include file="/shared/partner.jsp" %>
            <%@include file="/shared/footer.jsp" %>
        </div>
        <script>
            $(window).load(function () {
                $('.flexslider').flexslider({
                    animation: "slide"
                });
                $('.slider-text').addClass('animated fadeInUp');
            });

        </script>     
        <script src="<c:url value="/resources/js/myjs.js"/>"></script>
    </body>
</html>
