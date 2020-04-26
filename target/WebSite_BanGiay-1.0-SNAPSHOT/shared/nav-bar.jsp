<%-- 
    Document   : nav-bar
    Created on : Apr 6, 2020, 10:37:09 AM
    Author     : Truong98
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.nhom12.Database.Models.CartModel"%>
<%@page import="com.nhom12.Database.Models.UserCookie"%>
<%@page import="java.util.List"%>
<%@page import="javax.servlet.http.Cookie" %>
<%@page import="java.lang.reflect.Type"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="com.google.gson.reflect.TypeToken" %>
<%@page import="java.net.URLDecoder"%>

<nav class="colorlib-nav" role="navigation">
    <div class="top-menu">
        <div class="container">
            <div class="row">
                <div class="col-sm-7 col-md-9">
                    <div id="colorlib-logo"><a href="">Footwear</a></div>
                </div>
                <div class="col-sm-5 col-md-3">
                    <form action="/WebSite_BanGiay/home/search" class="search-wrap">
                        <div class="form-group">
                            <input type="text" name="txtSearch" value="${valSearch}" class="form-control search" placeholder="Tìm kiếm">
                            <button class="btn btn-primary submit-search text-center" type="submit"><i class="icon-search"></i></button>
                        </div>
                    </form>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-12 text-left menu-1">
                    <ul class="nav-menu">
                        <li class="home-page"><a href="/WebSite_BanGiay/home">Home</a></li>
                        <li class="has-dropdown">
                            <a href="#">Brand</a>
                            <ul class="dropdown"></ul>
                        </li>
                        <li><a href="/WebSite_BanGiay/">Men</a></li>
                        <li><a href="/WebSite_BanGiay/">Women</a></li>
                        <li class="about-page"><a href="/WebSite_BanGiay/about">About</a></li>
                        <li class="contact-page"><a href="/WebSite_BanGiay/contact">Contact</a></li>
                            <%
                                List<CartModel> cartModels = (List<CartModel>) session.getAttribute("cartSession");
                                int total = 0;
                                if (cartModels != null) {
                                    for (CartModel c : cartModels) {
                                        total += c.getQuantity();
                                    }
                                }
                            %>
                        <li class="has-dropdown cart" style="margin-left: 10px; font-size: 20px;  margin-right: 10px;">
                            <%
                                Cookie[] cookies = request.getCookies();
                                UserCookie cookie = null;
                                if (cookies != null) {
                                    for (Cookie ck : cookies) {
                                        if (ck.getName().equals("cookieUser")) {
                                            cookie = new Gson().fromJson(URLDecoder.decode(ck.getValue(), "UTF-8"), new TypeToken<UserCookie>() {
                                            }.getType());
                                        }
                                    }
                                }
                            %>
                            <i class="icon-user2">
                                <%
                                    if (cookie != null) {
                                %>
                                <ul class="dropdown" style="display: none;">
                                    <li><a href="/WebSite_BanGiay/customer/edit">Tài khoản</a></li>
                                    <li><a href="/WebSite_BanGiay/customer/logout">Đăng xuất</a></li>
                                </ul>
                               <span style="margin-left: 10px; font-size: 14px;"><%= cookie.getFullName()%></span>
                                <%
                                } else {
                                %>
                                <ul class="dropdown" style="display: none;">
                                    <li><a href="/WebSite_BanGiay/customer">Đăng nhập</a></li>
                                    <li><a href="/WebSite_BanGiay/customer/register">Đăng ký</a></li>
                                </ul>
                                <%
                                    }
                                %>
                            </i>
                        </li>
                        <li class="cart" style="font-size: 18px;"><a href="/WebSite_BanGiay/cart"><i class="icon-shopping-cart"></i> Cart [<span class="cart-quantity-span"><%=total%></span>]</a></li>

                    </ul>
                </div>
            </div>
        </div>
    </div>
    <div class="sale">
        <div class="container">
            <div class="row">
                <div class="col-sm-8 offset-sm-2 text-center">
                    <div class="row">
                        <div class="owl-carousel2">
                            <div class="item">
                                <div class="col">
                                    <h3><a href="#">25% off (Almost) Everything! Use Code: Summer Sale</a></h3>
                                </div>
                            </div>
                            <div class="item">
                                <div class="col">
                                    <h3><a href="#">Our biggest sale yet 50% off all summer shoes</a></h3>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</nav>
