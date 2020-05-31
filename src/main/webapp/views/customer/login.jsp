<%-- 
    Document   : login
    Created on : Apr 15, 2020, 8:16:48 PM
    Author     : Truong98
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
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
/*            .colorlib-form{
                margin: 30px;
                width: 500px;
            }*/
        </style>
        <div id="page">
            <%@include file="/shared/customer/nav-bar.jsp" %>
            <div class="row">
                <div class="col-lg-8" style="margin: auto;">
                    <form method="post" action="http://localhost:8080/WebSite_BanGiay/customer/login"  class="colorlib-form">
                        <h2>Đăng nhập</h2>
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
                            </div>form
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
            </div>
        </div>    
        <%@include file="/shared/customer/footer.jsp" %>
        <script src="<c:url value="/resources/js/myjs.js"/>"></script>
    </body>
</html>
