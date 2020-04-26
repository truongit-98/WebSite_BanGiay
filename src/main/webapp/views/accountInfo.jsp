<%-- 
    Document   : accountInfo
    Created on : Apr 20, 2020, 8:07:53 PM
    Author     : Truong98
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shoes Shop</title>
        <%@include file="/shared/head.jsp" %>
    </head>
    <body>
        <style>
            .error{
                color: red;
                margin-bottom: 5px;
            }
        </style>
        <div id="page">
            <%@include file="/shared/nav-bar.jsp" %>
            <div class="ftco-navbar-light" style="display: flex; margin-left: 75px; margin-top: 15px;">
                <%@include file="/shared/accountMenu.jsp" %>
                <div class="row" style="margin-left: 15px;">
                    <div class="col-xl ftco-animate">
                        <form action="/WebSite_BanGiay/customer/edit" method="post" autocomplete='off'>
                            <div class="text-success">
                                <c:if test="${!success.isEmpty()}">
                                    <c:out value="${success}"></c:out>
                                </c:if>
                            </div>
                            <div class="error">
                                <c:if test="${!errorMessage.isEmpty()}">
                                    <c:out value="${errorMessage}"></c:out>
                                        <script>
                                            $(document).ready(function () {
                                                disPlay();
                                            })
                                        </script>
                                </c:if>
                            </div>
                            <div class="row align-items-end">
                                <div class="w-100"></div>
                                <div class="col-md-12">
                                    <div class="form-group">
                                        <label for="fullname">Họ tên</label>
                                        <input id="fullname" name="FullName" required="required" minlength="24" type="tel" class="form-control" value="${customer.tenKH}" style="width: 60%;">
                                    </div>
                                </div>
                                <div class="col-md-12">
                                    <div class="form-group">
                                        <label for="Email">Email</label>
                                        <input id="Email" name="Email" type="email" class="form-control" value="${customer.email}" readonly style="width: 60%;">
                                    </div>
                                </div>
                                <div class="w-100"></div>
                                <div class="col-md-12">
                                    <div class="form-group">
                                        <label for="phone">SĐT</label>
                                        <input id="phone" name="Phone" type="tel" class="form-control" value="${customer.sdt}" readonly style="width: 60%;">
                                    </div>
                                </div>

                                <div class="w-100"></div>
                                <div class="col-md-12">
                                    <div class="form-group" style="display: inline-block;">
                                        <label class="checkbox" style="height:21px;">
                                            <input type="checkbox" value="checked" onclick="disPlay()" style="width: 50px; height: 15px; margin-top: 7px;">
                                            Thay đổi mật khẩu
                                        </label>

                                    </div>
                                </div>
                                <div class="col-md-12 password-group" style="display: none;">
                                    <div class="w-100"></div>
                                     <div class="form-group" style="display: none;">
                                        <label for="password"></label>
                                        <input id="password" type="password" tabindex="-1"  class="form-control" style="width: 60%;">
                                    </div>
                                    <div class="form-group">
                                        <label for="password">Mật khẩu cũ</label>
                                        <input id="password" name="PassWord" type="password" class="form-control" style="width: 60%;">
                                    </div>
                                    <div class="w-100"></div>
                                    <div class="form-group">
                                        <label for="password">Mật khẩu mới</label>
                                        <input id="password" name="NewPassWord" type="password" class="form-control" style="width: 60%;">
                                    </div>
                                    <div class="w-100"></div>
                                    <div class="form-group">
                                        <label for="password2">Xác nhận mật khẩu</label>
                                        <input id="password2" name="ConfirmPass" type="password" class="form-control" style="width: 60%;">
                                    </div>
                                </div>
                                <div class="w-100"></div>
                                <div class="col-md-12">
                                    <button type="submit" style="width: 150px;" class="btn btn-primary px-4"> Cập nhật</button>
                                </div>  
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <%@include file="/shared/footer.jsp" %>
        </div>
        <script type="text/javascript">
            function disPlay() {
                debugger
                $(".password-group").slideToggle("fast");
                
            }
            var element = document.querySelector('#profile-id');
            element.style.background = 'rgb(236, 236, 236)';

        </script>
        <script src="<c:url value="/resources/js/myjs.js"/>"></script>
    </body>
</html>
