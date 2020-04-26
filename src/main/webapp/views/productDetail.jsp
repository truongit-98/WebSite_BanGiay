<%-- 
    Document   : producDetail
    Created on : Apr 12, 2020, 5:10:19 PM
    Author     : ThongPVT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="/shared/head.jsp" %>
    </head>
    <body>

        <style>
            .addcart {
                background: #616161;
                border-radius: 5px;
                box-shadow: none;
                border: none;
                color: #FFF;
                cursor: pointer;
                padding: 8px 20px;
            }

            .addcart:hover {
                background: black;
            }
            .product-entry {
                width: 600px;
                height: auto;
            }
        </style>
        <div id="loader" class="">
            <div class="icon-load">
                
            </div>
        </div>
        <div id="page">
            <%@include file="/shared/nav-bar.jsp" %>
            <div class="breadcrumbs">
                <div class="container">
                    <div class="row">
                        <div class="col">
                         
                        </div>
                    </div>
                </div>
            </div>


            <div class="colorlib-product">
                <div class="container">
                    <div class="row row-pb-lg product-detail-wrap">
                        <div class="col-sm-7">
                            <img src="<c:url value="/resources/images/${product.anh}"/>" class="img-fluid" alt="${item.anh}">
                        </div>
                        <div class="col-sm-4">
                            <div class="product-desc" >
                                <h3>${product.tensp}</h3>
                                <p class="price">

                                <div>Giá: <span><fmt:formatNumber pattern="#,##0" value = "${product.dongia}" />đ</span></div>
                                </p>
                                <span class="rate">
                                    <c:if test="${product.soluongtong == 0}">
                                        <div style="display:flex">
                                            <div style="font-weight:"> Tình trạng: </div>
                                            <span style="color:red">Hết hang</span> 
                                        </div>
                                    </c:if>
                                    <c:if test="${product.soluongtong > 0}">
                                        <div style="display:flex">
                                            <div>Tình trạng: </div> 
                                            <span style="font-weight: 700;color:#88c8bc" class="ml-2">Còn hàng</span>
                                        </div> 
                                    </c:if>
                                </span>

                                <p>${product.mota}</p>
                                <div class="size-wrap">
                                    <div class="block-26 mb-2">
                                        <h4>Size</h4>
                                        <ul>
                                            <c:forEach items="${product.listSanPhamSize}" var="item">
                                                <li class="li-size" quantity="${item.soluong}"  data-id="${item.id.masize}"><a href="#">${item.size.size}</a></li>
                                                </c:forEach>
                                        </ul>
                                    </div>
                                    <div><strong id="size-quantity" style="font-weight: bold !important; "></strong></div>
                                </div>
                            </div>
                            <div class="input-group mb-4">
                                <span class="input-group-btn">
                                    <button type="button" class="quantity-left-minus btn btn-number" data-type="minus" data-field="quantity">
                                        <i class="icon-minus2"></i>
                                    </button>
                                </span>
                                <input type="text" id="quantity" name="quantity" class="form-control input-number " value="1" min="1" max="100">
                                <span class="input-group-btn ml-1">
                                    <button type="button" class="quantity-right-plus btn btn-number" data-type="plus" data-field="quantity">
                                        <i class="icon-plus2"></i>
                                    </button>
                                </span>
                            </div>            
                            <div class="row">
                                <div class="col-sm-12 text-center">
                                    <input type="submit" name="name" data-id="${product.masp}" loading="false" value="Thêm vào giỏ hàng" class="addcart" />
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="modal fade success-popup" id="SuccessMD" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                <div class="modal-dialog modal-sm" role="document">
                    <div class="modal-content">
                        <div class="modal-header text-center" style="display:block;">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
                            <h4 class="modal-title " id="myModalLabel">Thank You !</h4>
                        </div>
                        <div class="modal-body text-center">
                            <i class="fa fa-check-square-o" style="font-size: 50px;color: #88c8bc;"></i>
                            <p class="lead">Sản phẩm đã thêm vào giỏ hàng</p>
                            <a href="/WebSite_BanGiay/cart" style="background: #88c8bc;" class="btn">Đến giỏ hàng</a>
                        </div>

                    </div>
                </div>
            </div>                   
        </div>

        <%@include file="/shared/partner.jsp" %>
        <%@include file="/shared/footer.jsp" %>
    </div>
    <script src="<c:url value="/resources/js/myjs.js"/>"></script>
</body>
</html>
