<%-- 
    Document   : header
    Created on : Apr 22, 2020, 10:18:27 AM
    Author     : Quang Vinh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<header class="colorlib-nav" role="navigation">
    <div class="top-menu">
        <div class="container">
            <div class="row">
                <div class="col-sm-10 col-md-11">
                    <div id="colorlib-logo"><a href="">Footwear</a></div>
                </div>
                <div class="col-sm-2 col-md-1">
                    <div class="dropdown" >
                        <button id ="avatar"  type="button" data-toggle="dropdown" style="width: 50px; height: 50px; border-radius: 50%; ">
                            <!--<img class="img-thumbnail" alt="avatar"/>-->
                        </button>
                        <div class="dropdown-menu" aria-labelledby="avatar">
                            <a class="dropdown-item" href="${pageContext.request.contextPath}/admin/logout">Đăng xuất</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</header>

