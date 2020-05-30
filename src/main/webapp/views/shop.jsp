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
        <%@include file="/shared/head.jsp" %>
    </head>
    <body>
        <div id="page">
            <%@include file="/shared/nav-bar.jsp" %>
            <form method="post" action="${urlPost}"  class="colorlib-form">
                <div class="d-flex" style="justify-content: center;">
                    <div class="d-flex" style="width: 1140px; padding: 0 15px;align-items: center;">
                        <div class="filter d-flex" style="width: 1058px;align-items: center;">
                            <label class="mb-0">Hãng sản xuất: </label>
                            <select name="mansx"  class="ml-2">
                                <option value="0">--chọn--</option>
                                <c:forEach items="${producers}"  var="item" >
                                    <option value="${item.mansx}" ${item.mansx == mansx ? 'selected="selected"' : ''}>${item.tennsx}</option>
                                </c:forEach>
                            </select>

                            <label class="mb-0 ml-3" >Giá:</label>
                            <select name="gia"  class="ml-2">
                                <option value="0">--chọn--</option>
                                <option value="1" ${gia==1 ? 'selected="selected"' : ''}>Dưới 1,000,000đ</option>
                                <option value="3" ${gia==3 ? 'selected="selected"' : ''}>1,000,000đ - 3,000,000đ</option>
                                <option value="5" ${gia==5 ? 'selected="selected"' : ''}>3,000,000đ - 5,000,000đ</option>
                                <option value="7" ${gia==7 ? 'selected="selected"' : ''}>5,000,000đ - 7,000,000đ</option>
                                <option value="9" ${gia==9 ? 'selected="selected"' : ''}>7,000,000đ - 9,000,000đ</option>
                                <option value="10" ${gia==10 ? 'selected="selected"' : ''}>Trên 10,000,000đ</option>
                            </select>

                            <label class="mb-0 ml-3" >Size: </label>
                            <select name="size" class="ml-2">
                                <option value="0">--chọn--</option>
                                <c:forEach items="${sizes}"  var="item" >
                                    <c:if test="${item.maSize != masize}">
                                        <option value="${item.maSize}">${item.size}</option>
                                    </c:if>
                                    <c:if test="${item.maSize == masize}">
                                        <option value="${item.maSize}" selected>${item.size}</option>
                                    </c:if>
                                </c:forEach>
                            </select><br />

                            <!--                            <div class="d-flex" style="flex: 1;justify-content: center;">
                                                            <input style="border-radius: 30px;padding: 0 24px;width: 250px;" type="text" name="txtSearch" value="${valSearch}" class="ml-5 form-control search" placeholder="Tìm kiếm">
                                                        </div>-->
                        </div>
                        <div class="text-center">
                            <input type="submit" class="btn btn-primary" value="Lọc"></input>
                        </div>
                    </div>

                </div>

            </form>

            <div class="colorlib-product">
                <c:if test="${fn:length(products)>0}">
                    <div class="container">
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
                        <form method="post" action="${urlPost}"  class="">
                            <div class="d-flex" style="justify-content: center;display: none !important">
                                <div class="d-flex" style="width: 1140px; padding: 0 15px;align-items: center;">
                                    <div class="filter d-flex" style="width: 1058px;align-items: center;">
                                        <label class="mb-0">Hãng sản xuất: </label>
                                        <select name="mansx"  class="ml-2">
                                            <option value="0">--chọn--</option>
                                            <c:forEach items="${producers}"  var="item" >
                                                <option value="${item.mansx}" ${item.mansx == mansx ? 'selected="selected"' : ''}>${item.tennsx}</option>
                                            </c:forEach>
                                        </select>

                                        <label class="mb-0 ml-3" >Giá:</label>
                                        <select name="gia"  class="ml-2">
                                            <option value="0">--chọn--</option>
                                            <option value="1" ${gia==1 ? 'selected="selected"' : ''}>Dưới 1,000,000đ</option>
                                            <option value="3" ${gia==3 ? 'selected="selected"' : ''}>1,000,000đ - 3,000,000đ</option>
                                            <option value="5" ${gia==5 ? 'selected="selected"' : ''}>3,000,000đ - 5,000,000đ</option>
                                            <option value="7" ${gia==7 ? 'selected="selected"' : ''}>5,000,000đ - 7,000,000đ</option>
                                            <option value="9" ${gia==9 ? 'selected="selected"' : ''}>7,000,000đ - 9,000,000đ</option>
                                            <option value="10" ${gia==10 ? 'selected="selected"' : ''}>Trên 10,000,000đ</option>
                                        </select>

                                        <label class="mb-0 ml-3" >Size: </label>
                                        <select name="size" class="ml-2">
                                            <option value="0">--chọn--</option>
                                            <c:forEach items="${sizes}"  var="item" >
                                                <option value="${item.maSize}" ${item.maSize == masize ? 'selected="selected"' : ''}>${item.size}</option>
                                            </c:forEach>
                                        </select><br />

                                        <!--                            <div class="d-flex" style="flex: 1;justify-content: center;">
                                                                        <input style="border-radius: 30px;padding: 0 24px;width: 250px;" type="text" name="txtSearch" value="${valSearch}" class="ml-5 form-control search" placeholder="Tìm kiếm">
                                                                    </div>-->
                                    </div>
                                    <div class="text-center">
                                        <input type="submit" class="btn btn-primary" value="Lọc"></input>
                                    </div>
                                </div>
                                <input name="page" class="btn btn-primary pagePost" value="page"></input>
                            </div>
                            <div class="row">
                                <div class="col-md-12 text-center">
                                    <div style="display:flex;justify-content: center;align-items: center;height: 27px;">
                                        <div class="d-flex" >
                                            <c:if test="${page > 1 }">
                                                <button type="submit" style="cursor: pointer" class="mr-3 page-change" value="1" >Trang đầu</button>
                                                <button type="submit" style="cursor: pointer" class="mr-2 page-change" value="${page-1}" ><<</button>
                                            </c:if>
                                        </div>


                                        <c:forEach var="i" begin="1" end="${pageMax}" step="1">
                                            <c:if test="${page == i}">
                                                <div style="background-color: #82777759;width: 30px;height: 26px;border: 1px solid;margin-right: 4px;">${i}</div>
                                            </c:if>
                                            <c:if test="${page != i}">
                                                <button type="submit" style="width: 30px;height: 26px;border: 1px solid;margin-right: 4px;cursor: pointer;background-color: #fff;" class=" page-change" value="${i}" >${i}</button>
                                            </c:if>
                                        </c:forEach>
                                        <div class="d-flex">
                                            <c:if test="${page < pageMax}">
                                                <button type="submit" style="cursor: pointer" class="mr-3 ml-1 page-change" value="${page+1}" >>></button>
                                                <button type="submit" style="cursor: pointer" class="mr-3 page-change" value="${pageMax}" >Trang cuối</button>
                                            </c:if>
                                        </div>

                                    </div>

                                </div>
                            </div>
                        </form>
                    </div>
                </c:if>


                <c:if test="${fn:length(products)==0}">
                    <div class="container" style="align-items: center;display: flex;justify-content: center;height: 400px;font-size: 35px;font-weight: 700;">
                        Không có dữ liệu!
                    </div>
                </c:if>

            </div> 
            <%@include file="/shared/partner.jsp" %>
            <%@include file="/shared/footer.jsp" %>
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
