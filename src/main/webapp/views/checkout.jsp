<%-- 
    Document   : checkout
    Created on : Apr 16, 2020, 10:14:31 PM
    Author     : Truong98
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shoes Shop</title>
        <%@include file="/shared/head.jsp" %>
    </head>
    <body>
        <style>
            a.change-address:hover{
                color: #0044cc !important;
                font-size: 16px;
            }
            a.change-address{
                margin: 0 10px;
            }
        </style>
        <div id="page">
            <%@include file="/shared/nav-bar.jsp" %>
            <div class="colorlib-product">
                <div class="container">
                    <div class="row row-pb-lg">
                        <div class="col-sm-10 offset-md-1">
                            <div class="process-wrap">
                                <div class="process text-center active">
                                    <p><span>01</span></p>
                                    <h3>Shopping Cart</h3>
                                </div>
                                <div class="process text-center active">
                                    <p><span>02</span></p>
                                    <h3>Checkout</h3>
                                </div>
                                <div class="process text-center">
                                    <p><span>03</span></p>
                                    <h3>Order Complete</h3>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <c:if test="${isEdit == 'false'}">
                            <div class="col-lg-8">
                                <div class="info"  style="display:block; padding: 10px; width: 100%; margin: auto;">
                                    <b>Tên người nhận: ${customer.tenKH}</b>
                                    <p>SĐT: ${customer.sdt}</p>
                                    <c:if test="${!shippingAddress.isEmpty()}">
                                        <p>Địa chỉ giao hàng: ${shippingAddress}</p>
                                    </c:if> 
                                    <c:if test="${shippingAddress.isEmpty()}">
                                        <p>Địa chỉ giao hàng: ${customer.diaChi}</p>
                                    </c:if>
                                    <span><a href="/WebSite_BanGiay/customer/checkout?edit=true&isDefault=false" class="change-address" style="color: #88c8bc;  text-decoration: #88c8bc;">Thay đổi địa chỉ nhận</a></span>
                                    <span><a href="/WebSite_BanGiay/customer/checkout" class="change-address" style="color: #88c8bc;  text-decoration: #88c8bc;">Sử dụng địa chỉ mặc định</a></span>
                                </div>
                            </div>
                        </c:if>
                        <c:if test="${isEdit == 'true'}">
                            <div class="col-lg-8" >
                                <form method="post"  accept-charset="UTF-8" action="/WebSite_BanGiay/order/address" class="colorlib-form" >
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label for="country">Tỉnh/TP</label>
                                            <div class="form-field">
                                                <i class="icon icon-arrow-down3"></i>
                                                <select name="city" id="city" required class="form-control">
                                                    <option value="">Chọn Tỉnh/TP</option>
                                                    <option value="01">Hà Nội</option>
                                                    <option value="79">TP.Hồ Chí Minh</option>
                                                    <option value="89">An Giang</option>
                                                    <option value="77">Bà Rịa - Vũng Tàu</option>
                                                    <option value="24">Bắc Giang</option>
                                                    <option value="06">Bắc Kạn</option>
                                                    <option value="95">Bạc Liêu</option>
                                                    <option value="27">Bắc Ninh</option>
                                                    <option value="83">Bến Tre</option>
                                                    <option value="74">Bình Dương</option>
                                                    <option value="70">Bình Phước</option>
                                                    <option value="60">Bình Thuận</option>
                                                    <option value="52">Bình Định</option>
                                                    <option value="96">Cà Mau</option>
                                                    <option value="92">Cần Thơ</option>
                                                    <option value="04">Cao Bằng</option>
                                                    <option value="48">Đà Nẵng</option>
                                                    <option value="66">Đăk Lăk</option>
                                                    <option value="67">Đăk Nông</option>
                                                    <option value="11">Điện Biên</option>
                                                    <option value="75">Đồng Nai</option>
                                                    <option value="87">Đồng Tháp</option>
                                                    <option value="64">Gia Lai</option>
                                                    <option value="02">Hà Giang</option>
                                                    <option value="35">Hà Nam</option>
                                                    <option value="42">Hà Tĩnh</option>
                                                    <option value="30">Hải Dương</option>
                                                    <option value="31">Hải Phòng</option>
                                                    <option value="93">Hậu Giang</option>
                                                    <option value="17">Hòa Bình</option>
                                                    <option value="33">Hưng Yên</option>
                                                    <option value="56">Khánh Hòa</option>
                                                    <option value="91">Kiên Giang</option>
                                                    <option value="62">Kon Tum</option>
                                                    <option value="12">Lai Châu</option>
                                                    <option value="68">Lâm Đồng</option>
                                                    <option value="20">Lạng Sơn</option>
                                                    <option value="10">Lào Cai</option>
                                                    <option value="80">Long An</option>
                                                    <option value="36">Nam Định</option>
                                                    <option value="40">Nghệ An</option>
                                                    <option value="37">Ninh Bình</option>
                                                    <option value="58">Ninh Thuận</option>
                                                    <option value="25">Phú Thọ</option>
                                                    <option value="54">Phú Yên</option>
                                                    <option value="44">Quảng Bình</option>
                                                    <option value="49">Quảng Nam</option>
                                                    <option value="51">Quảng Ngãi</option>
                                                    <option value="22">Quảng Ninh</option>
                                                    <option value="54">Quảng Trị</option>
                                                    <option value="94">Sóc Trăng</option>
                                                    <option value="14">Sơn La</option>
                                                    <option value="72">Tây Ninh</option>
                                                    <option value="34">Thái Bình</option>
                                                    <option value="19">Thái Nguyên</option>
                                                    <option value="38">Thanh Hóa</option>
                                                    <option value="46">Thừa Thiên Huế</option>
                                                    <option value="82">Tiền Giang</option>
                                                    <option value="84">Trà Vinh</option>
                                                    <option value="08">Tuyên Quang</option>
                                                    <option value="86">Vĩnh Long</option>
                                                    <option value="26">Vĩnh Phúc</option>
                                                    <option value="15">Yên Bái</option>
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label for="country">Quận/huyện</label>
                                            <div class="form-field">
                                                <i class="icon icon-arrow-down3"></i>
                                                <select name="district" required id="district" class="form-control">
                                                    <option value="default">Chọn Quận/huyện</option>
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label for="country">Phường/xã</label>
                                            <div class="form-field">
                                                <i class="icon icon-arrow-down3"></i>
                                                <select name="ward" id="ward" required class="form-control">
                                                    <option value="default">Chọn Phường/xã</:option>
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label for="detailAddress">Địa chỉ chi tiết</label>
                                            <input type="text"  required name="detailAddress" id="detailAddress" class="form-control" placeholder="Địa chỉ chi tiết" >

                                        </div>
                                    </div>
                                    <div class="col-md-12 text-center">
                                        <p><input type="submit"  class="btn btn-primary" value="Xác nhận"></input></p>
                                    </div>
                                </form>
                            </div>
                        </c:if>
                        <div class="col-lg-4">
                            <div class="row">
                                <div class="col-md-18">
                                    <div class="cart-detail">
                                        <h2>Cart Total</h2>
                                        <ul>
                                            <li>
                                                <span>Subtotal</span> <span><fmt:formatNumber type = "number" 
                                                                  maxFractionDigits = "3" value = "${total}" />đ</span>
                                                <ul>
                                                    <c:forEach items="${cartModels}" var="item">
                                                        <li><span>${item.quantity} x ${item.productName}</span> <span><fmt:formatNumber type = "number" 
                                                                                                                              maxFractionDigits = "3" value = "${item.price * item.quantity}" />đ</span></li>
                                                            </c:forEach>
                                                </ul>
                                            </li>
                                            <li><span>Shipping</span> <span>$0.00</span></li>
                                            <li><span>Order Total</span> <span><fmt:formatNumber type = "number" 
                                                              maxFractionDigits = "3" value = "${total}" />đ</span></li>
                                        </ul>
                                    </div>
                                </div>
                                <div class="w-100"></div>
                                <form action="/WebSite_BanGiay/customer/checkout" method="post">
                                    <div class="col-md-18">
                                        <div class="cart-detail">
                                            <h2>Payment Method</h2>
                                            <div class="form-group">
                                                <div class="col-md-12">
                                                    <div class="radio">
                                                        <label><input type="radio" required name="payment" value="Thẻ ATM/Internet Banking">Thẻ ATM/Internet Banking</label>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-md-12">
                                                    <div class="radio">
                                                        <label><input type="radio"  name="payment" value="Thanh toán khi nhận hàng"> Thanh toán khi nhận hàng </label>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-md-12">
                                                    <div class="radio">
                                                        <label><input type="radio"  name="payment" value="Thanh toán bằng ZaloPay"> Thanh toán bằng ZaloPay</label>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-md-12">
                                                    <div class="radio">
                                                        <label><input type="radio" name="payment" value="Thanh toán bằng ví MoMo"> Thanh toán bằng ví MoMo</label>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <c:if test="${isEdit == 'false'}">
                                        <div class="row">
                                            <div class="col-md-12 text-center" style="">
                                                <p><input  type="submit" class="btn btn-primary" value="Tiến hành đặt hàng"></input></p>
                                            </div>
                                        </div>
                                    </c:if>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <%@include file="/shared/footer.jsp" %>
        </div>
        <script src="<c:url value="/resources/js/myjs.js"/>"></script>
    </body>
</html>
