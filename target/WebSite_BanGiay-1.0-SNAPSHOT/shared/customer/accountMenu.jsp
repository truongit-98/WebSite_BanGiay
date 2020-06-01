<%-- 
    Document   : accountMenu
    Created on : Apr 20, 2020, 8:13:17 PM
    Author     : Truong98
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
    li.nav-item > a{
        padding: 10px;
      
    }
</style>
<div class="left-menu" id="main-menu" style=" padding: 10px; display: block; width: 300px; margin-right: 10px; border-right-style: outset;">
    <div class="profile" style="display:inline-block; width: 100%;">
        <p style="float: left;"><img src="<c:url value="/resources/images/avatar.png" />" style="border-radius: 50%; margin-right: 10px; padding: 10px" /></p>
        <p>Tài khoản của</p>
        <h6>${customer.tenKH}</h6>
    </div>
    <div class="collapse navbar-collapse" style="display: block;">
        <ul class="navbar-nav ml-auto" >
            <li class="nav-item"><a href="/WebSite_BanGiay/customer/edit" class="nav-link" id="profile-id" style="color: #808080;">Thông tin tài khoản</a></li>
            <li class="nav-item"><a href="/WebSite_BanGiay/order/history" class="nav-link" id="manage-id" style="color: #808080;">Quản lý đơn hàng</a></li>
            <li class="nav-item"><a href="/WebSite_BanGiay/customer/address" class="nav-link" id="address-id" style="color: #808080;"> Số địa chỉ</a></li>
        </ul>
    </div>
</div>