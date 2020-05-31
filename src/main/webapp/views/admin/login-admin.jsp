<%-- 
    Document   : login-admin
    Created on : Apr 19, 2020, 3:05:29 PM
    Author     : Quang Vinh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix= "form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shoes Shop</title>
        <%@include file="/shared/customer/head.jsp" %>
    </head>
    <body>
        <style>
            .error{
                color: red;
                margin-left: 15px;
                margin-bottom: 5px;
            }
            .colorlib-form{
                margin: 30px;
                width: 500px;
            }
        </style>
        <div class="col-lg-8" style="margin: auto; width: fit-content;">
            <form title="ADMIN" method="post" action="http://localhost:8080/WebSite_BanGiay/admin" class="colorlib-form">
                <div class="title" style="color: black;text-align: center;">ADMIN</div> 
                <div class="row">
                    <c:if test="${!errorMessage.isEmpty()}">
                        <div class="error">
                            <c:out value="${errorMessage}"></c:out>
                            </div>
                    </c:if>
                    <div class="col-md-12">
                        <div class="form-group">
                            <label for="email">Email</label>
                            <input type="email" name="email" id="email" class="form-control" placeholder="Email">
                        </div>
                    </div>
                    <div class="col-md-12">
                        <div class="form-group">
                            <label for="password">Mật khẩu</label>
                            <input type="password" name="password" id="password" class="form-control" placeholder="Mật khẩu">
                        </div>
                    </div>
                    <div class="col-md-12 text-center">
                        <input type="submit" class="btn btn-primary" value="Đăng nhập"></input>
                    </div>
                </div>
            </form>
        </div>
    </body>
</html>
