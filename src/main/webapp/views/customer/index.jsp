<%-- 
    Document   : index
    Created on : Apr 6, 2020, 9:43:58 AM
    Author     : Truong98
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
    <head>
        <%@include file="/shared/customer/head.jsp" %>
    </head>
    <body>
        <div id="page">
            <%@include file="/shared/customer/nav-bar.jsp" %>
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
                <c:if test="${fn:length(products)>0}">
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
                                        <!--<div style="background-color: #686b6b1c;">-->
                                        <a href="/WebSite_BanGiay/shop/product/${item.masp}" class="prod-img" style=" display: flex; align-items: center;overflow: hidden;">
                                            <img src="<c:url value="/resources/images/${item.anh}"/>" class="img-fluid" alt="${item.anh}">
                                        </a>
                                        <!--</div>-->
                                        <div class="desc">
                                            <h2 style="height: 90px;"><a href="/WebSite_BanGiay/shop/product/${item.masp}">${item.tensp}</a></h2>
                                            <div style="height:24px"><i class="icon-shopping-cart cart-hover" data-id="${item.masp}" id="cart-id"></i></div>
                                            <span class="price"><fmt:formatNumber type = "number" 
                                                              maxFractionDigits = "3" value = "${item.dongia}" />đ</span>
                                        </div>

                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                        <div class="row">
                            <div class="col-md-12 text-center">
                                <!--<p><a href="" class="btn btn-primary btn-lg">Shop All Products</a></p>-->

                                <div style="display:flex;justify-content: center;">
                                    <div style="width:170px">
                                        <c:if test="${page > 1 }">

                                            <c:if test="${isSearch == 0}">
                                                <div class="d-flex" style="height: 27px;">
                                                    <button class="mr-3" >
                                                        <a href="/WebSite_BanGiay/home?page=1" class="mr-3" style="white-space: nowrap;" >Trang đầu</a>
                                                    </button>
                                                    <button class="mr-2">
                                                        <a href="/WebSite_BanGiay/home?page=${page-1}" class="mr-2" ><<</a>
                                                    </button>
                                                </div>
                                            </c:if>
                                            <c:if test="${isSearch == 1}">
                                                <button class="mr-3" >
                                                    <a href="/WebSite_BanGiay/home/search?txtSearch=${valSearch}&page=1" style="white-space: nowrap;"  >Trang đầu</a>
                                                </button>
                                                <button class="mr-2">
                                                    <a href="/WebSite_BanGiay/home/search?txtSearch=${valSearch}&page=${page-1}" ><<</a>
                                                </button>
                                            </c:if>
                                        </c:if>
                                    </div>


                                    <c:forEach var="i" begin="1" end="${pageMax}" step="1">
                                        <c:if test="${page == i}">
                                            <div style="background-color: #82777759;width: 30px;height: 26px;border: 1px solid;margin-right: 4px;">${i}</div>
                                        </c:if>
                                        <c:if test="${page != i}">

                                            <c:if test="${isSearch == 0}">
                                                <a href="/WebSite_BanGiay/home?page=${i}"  style="width: 30px;height: 26px;border: 1px solid;margin-right: 4px;">${i}</a>
                                            </c:if>
                                            <c:if test="${isSearch == 1}">
                                                <a href="/WebSite_BanGiay/home/search?txtSearch=${valSearch}&page=${i}"  style="width: 30px;height: 26px;border: 1px solid;margin-right: 4px;">${i}</a>
                                            </c:if>
                                        </c:if>
                                    </c:forEach>
                                    <div style="width:170px">
                                        <c:if test="${page < pageMax}">

                                            <c:if test="${isSearch == 0}">
                                                <div class="d-flex" style="height: 27px;">
                                                    <button class="mr-3 ml-2" >
                                                        <a href="home?page=${page+1}" >>></a>
                                                    </button>
                                                    <button class="mr-3">
                                                        <a href="home?page=${pageMax}" style="white-space: nowrap;">Trang cuối</a>
                                                    </button>
                                                </div>
                                            </c:if>
                                            <c:if test="${isSearch == 1}">
                                                <div class="d-flex" style="height: 27px;">
                                                    <button class="mr-3 ml-2" >
                                                        <a href="/WebSite_BanGiay/home/search?txtSearch=${valSearch}&page=${page+1}" >>></a>    
                                                    </button>
                                                    <button class="mr-3" >
                                                        <a href="/WebSite_BanGiay/home/search?txtSearch=${valSearch}&page=${pageMax}" style="white-space: nowrap;">Trang cuối</a>
                                                    </button>
                                                </div>


                                            </c:if>
                                        </c:if>
                                    </div>

                                </div>

                            </div>
                        </div>
                    </div>
                </c:if>


                <c:if test="${fn:length(products)==0}">
                    <div class="container" style="align-items: center;display: flex;justify-content: center;height: 400px;font-size: 35px;font-weight: 700;">
                        Không có dữ liệu!
                    </div>
                </c:if>

            </div> 
            <%@include file="/shared/customer/partner.jsp" %>
            <%@include file="/shared/customer/footer.jsp" %>
        </div>
        <script>
            $(document).ready(function () {
                $('.flexslider').flexslider({
                    animation: "slide"
                });
                $('.slider-text').addClass('animated fadeInUp');

                $.each($('ul.nav-menu > li'), function (i, e) {

                    e.classList.remove('active');
                });

                $('.home-page').each(function (k, e) {
                    e.classList.add('active');
                })
            })
        </script>
        <script src="<c:url value="/resources/js/myjs.js"/>"></script>
    </body>
</html>
