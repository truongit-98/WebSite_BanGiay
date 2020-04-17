<%-- 
    Document   : nav-bar
    Created on : Apr 6, 2020, 10:37:09 AM
    Author     : Truong98
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                    <ul>
                        <li class="active"><a href="">Home</a></li>
                        <li class="has-dropdown">
                            <a href="#">Brand</a>
                            <ul class="dropdown">
                            </ul>
                        </li>
                        <li><a href="">Men</a></li>
                        <li><a href="">Women</a></li>
                        <li><a href="">About</a></li>
                        <li><a href="">Contact</a></li>
                        <li class="cart" style="font-size: 18px;"><a href="/WebSite_BanGiay/cart"><i class="icon-shopping-cart"></i> Cart [<span id="cart-quantity">0</span>]</a></li>

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
