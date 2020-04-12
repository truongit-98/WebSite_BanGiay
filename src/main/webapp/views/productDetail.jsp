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
                        <!--<p class="bread"><span><a href="@Url.Action("Index","Home")">Home</a></span> / <span>@brandName</span></p>-->
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

                            <div class="row">
                                <div class="col-sm-12 text-center">
                                    <input type="submit" name="name" value="Thêm vào giỏ hàng" class="addcart" />
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-sm-12">
                        <div class="row">
                            <div class="col-md-12 pills">
                                <div class="bd-example bd-example-tabs">
                                    <ul class="nav nav-pills mb-3" id="pills-tab" role="tablist">

                                        <li class="nav-item">
                                            <a class="nav-link active" id="pills-description-tab" data-toggle="pill" href="#pills-description" role="tab" aria-controls="pills-description" aria-expanded="true">Mô tả</a>
                                        </li>
                                        <!--                                        <li class="nav-item">
                                                                                    <a class="nav-link" id="pills-manufacturer-tab" data-toggle="pill" href="#pills-manufacturer" role="tab" aria-controls="pills-manufacturer" aria-expanded="true">Manufacturer</a>
                                                                                </li>-->
                                        <li class="nav-item">
                                            <a class="nav-link" id="pills-review-tab" data-toggle="pill" href="#pills-review" role="tab" aria-controls="pills-review" aria-expanded="true">Đánh giá</a>
                                        </li>
                                    </ul>

                                    <div class="tab-content" id="pills-tabContent">
                                        <div class="tab-pane border fade show active" id="pills-description" role="tabpanel" aria-labelledby="pills-description-tab">
                                            <p>Even the all-powerful Pointing has no control about the blind texts it is an almost unorthographic life One day however a small line of blind text by the name of Lorem Ipsum decided to leave for the far World of Grammar.</p>
                                            <p>When she reached the first hills of the Italic Mountains, she had a last view back on the skyline of her hometown Bookmarksgrove, the headline of Alphabet Village and the subline of her own road, the Line Lane. Pityful a rethoric question ran over her cheek, then she continued her way.</p>
                                            <ul>
                                                <li>The Big Oxmox advised her not to do so</li>
                                                <li>Because there were thousands of bad Commas</li>
                                                <li>Wild Question Marks and devious Semikoli</li>
                                                <li>She packed her seven versalia</li>
                                                <li>tial into the belt and made herself on the way.</li>
                                            </ul>
                                        </div>

                                        <div class="tab-pane border fade" id="pills-manufacturer" role="tabpanel" aria-labelledby="pills-manufacturer-tab">
                                            <p>Even the all-powerful Pointing has no control about the blind texts it is an almost unorthographic life One day however a small line of blind text by the name of Lorem Ipsum decided to leave for the far World of Grammar.</p>
                                            <p>When she reached the first hills of the Italic Mountains, she had a last view back on the skyline of her hometown Bookmarksgrove, the headline of Alphabet Village and the subline of her own road, the Line Lane. Pityful a rethoric question ran over her cheek, then she continued her way.</p>
                                        </div>

                                        <div class="tab-pane border fade" id="pills-review" role="tabpanel" aria-labelledby="pills-review-tab">
                                            <div class="row">
                                                <div class="col-md-8">
                                                    <h3 class="head">23 Reviews</h3>
                                                    <div class="review">
                                                        <div class="user-img" style="background-image: url(images/person1.jpg)"></div>
                                                        <div class="desc">
                                                            <h4>
                                                                <span class="text-left">Jacob Webb</span>
                                                                <span class="text-right">14 March 2018</span>
                                                            </h4>
                                                            <p class="star">
                                                                <span>
                                                                    <i class="icon-star-full"></i>
                                                                    <i class="icon-star-full"></i>
                                                                    <i class="icon-star-full"></i>
                                                                    <i class="icon-star-half"></i>
                                                                    <i class="icon-star-empty"></i>
                                                                </span>
                                                                <span class="text-right"><a href="#" class="reply"><i class="icon-reply"></i></a></span>
                                                            </p>
                                                            <p>When she reached the first hills of the Italic Mountains, she had a last view back on the skyline of her hometown Bookmarksgrov</p>
                                                        </div>
                                                    </div>
                                                    <div class="review">
                                                        <div class="user-img" style="background-image: url(images/person2.jpg)"></div>
                                                        <div class="desc">
                                                            <h4>
                                                                <span class="text-left">Jacob Webb</span>
                                                                <span class="text-right">14 March 2018</span>
                                                            </h4>
                                                            <p class="star">
                                                                <span>
                                                                    <i class="icon-star-full"></i>
                                                                    <i class="icon-star-full"></i>
                                                                    <i class="icon-star-full"></i>
                                                                    <i class="icon-star-half"></i>
                                                                    <i class="icon-star-empty"></i>
                                                                </span>
                                                                <span class="text-right"><a href="#" class="reply"><i class="icon-reply"></i></a></span>
                                                            </p>
                                                            <p>When she reached the first hills of the Italic Mountains, she had a last view back on the skyline of her hometown Bookmarksgrov</p>
                                                        </div>
                                                    </div>
                                                    <div class="review">
                                                        <div class="user-img" style="background-image: url(images/person3.jpg)"></div>
                                                        <div class="desc">
                                                            <h4>
                                                                <span class="text-left">Jacob Webb</span>
                                                                <span class="text-right">14 March 2018</span>
                                                            </h4>
                                                            <p class="star">
                                                                <span>
                                                                    <i class="icon-star-full"></i>
                                                                    <i class="icon-star-full"></i>
                                                                    <i class="icon-star-full"></i>
                                                                    <i class="icon-star-half"></i>
                                                                    <i class="icon-star-empty"></i>
                                                                </span>
                                                                <span class="text-right"><a href="#" class="reply"><i class="icon-reply"></i></a></span>
                                                            </p>
                                                            <p>When she reached the first hills of the Italic Mountains, she had a last view back on the skyline of her hometown Bookmarksgrov</p>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-4">
                                                    <div class="rating-wrap">
                                                        <h3 class="head">Give a Review</h3>
                                                        <div class="wrap">
                                                            <p class="star">
                                                                <span>
                                                                    <i class="icon-star-full"></i>
                                                                    <i class="icon-star-full"></i>
                                                                    <i class="icon-star-full"></i>
                                                                    <i class="icon-star-full"></i>
                                                                    <i class="icon-star-full"></i>
                                                                    (98%)
                                                                </span>
                                                                <span>20 Reviews</span>
                                                            </p>
                                                            <p class="star">
                                                                <span>
                                                                    <i class="icon-star-full"></i>
                                                                    <i class="icon-star-full"></i>
                                                                    <i class="icon-star-full"></i>
                                                                    <i class="icon-star-full"></i>
                                                                    <i class="icon-star-empty"></i>
                                                                    (85%)
                                                                </span>
                                                                <span>10 Reviews</span>
                                                            </p>
                                                            <p class="star">
                                                                <span>
                                                                    <i class="icon-star-full"></i>
                                                                    <i class="icon-star-full"></i>
                                                                    <i class="icon-star-full"></i>
                                                                    <i class="icon-star-empty"></i>
                                                                    <i class="icon-star-empty"></i>
                                                                    (70%)
                                                                </span>
                                                                <span>5 Reviews</span>
                                                            </p>
                                                            <p class="star">
                                                                <span>
                                                                    <i class="icon-star-full"></i>
                                                                    <i class="icon-star-full"></i>
                                                                    <i class="icon-star-empty"></i>
                                                                    <i class="icon-star-empty"></i>
                                                                    <i class="icon-star-empty"></i>
                                                                    (10%)
                                                                </span>
                                                                <span>0 Reviews</span>
                                                            </p>
                                                            <p class="star">
                                                                <span>
                                                                    <i class="icon-star-full"></i>
                                                                    <i class="icon-star-empty"></i>
                                                                    <i class="icon-star-empty"></i>
                                                                    <i class="icon-star-empty"></i>
                                                                    <i class="icon-star-empty"></i>
                                                                    (0%)
                                                                </span>
                                                                <span>0 Reviews</span>
                                                            </p>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <%@include file="/shared/partner.jsp" %>
        <%@include file="/shared/footer.jsp" %>

    </body>
</html>
