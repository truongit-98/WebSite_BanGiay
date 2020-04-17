<%-- 
    Document   : producDetail
    Created on : Apr 12, 2020, 5:10:19 PM
    Author     : ThongPVT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                            <p><fmt:formatNumber pattern="#,##0" value = "${product.dongia}" /></p>
                            <div>Giá: ${product.dongia}</div>
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
                                    <ul >
                                        <c:forEach items="${sizes}" var="item">
                                            <li class="li-size" data-id="${item.masize}"><a href="#">${item.size}</a></li>
                                        </c:forEach>
                                    </ul>
                                </div>
                              
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
                                <input type="submit" name="name" data-id="${product.masp}" value="Thêm vào giỏ hàng" class="addcart" />
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <d
        </div>
    </div>

    <%@include file="/shared/partner.jsp" %>
    <%@include file="/shared/footer.jsp" %>
    <script src="<c:url value="/resources/js/myjs.js"/>"></script>
</body>
</html>
