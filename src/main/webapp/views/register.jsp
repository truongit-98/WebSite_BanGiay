<%-- 
    Document   : register
    Created on : Apr 16, 2020, 3:56:29 PM
    Author     : Truong98
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                margin-left: 15px;
                margin-bottom: 5px;
            }
        </style>
        <div id="page">
            <%@include file="/shared/nav-bar.jsp" %>
            <div class="row">
                <div class="col-lg-8" style="margin: auto;">
                    <form method="post"  accept-charset="UTF-8" action="/WebSite_BanGiay/customer/register" class="colorlib-form" >
                        <h2>Đăng ký</h2>
                        <div class="row">
                            <c:if test="${!errorMessage.isEmpty()}">
                                <div class="error">
                                    <c:out value="${errorMessage}"></c:out>
                                    </div>
                            </c:if>
                            <div class="col-md-12">
                                <div class="form-group">
                                    <label for="fullName">Họ và tên</label>
                                    <input type="text" minlength="16" maxlength="50" required name="tenKH" id="fullName" class="form-control" placeholder="Họ và tên" >
                                </div>
                            </div>

                            <div class="col-md-12">
                                <div class="form-group">
                                    <label for="email">Email</label>
                                    <input type="email" minlength="12" maxlength="50" required name="email" id="email" class="form-control" placeholder="Email">
                                </div>
                            </div>

                            <div class="col-md-12">
                                <div class="form-group">
                                    <label for="password">Mật khẩu</label>
                                    <input type="password" minlength="12" minlength="16"  required name="matKhau" id="password" class="form-control" placeholder="Mật khẩu">

                                </div>
                            </div>

                            <div class="col-md-12">
                                <div class="form-group">
                                    <label for="phone">SĐT</label>
                                    <input type="text" minlength="10" maxlength="10" required name="sdt" id="phone" class="form-control" placeholder="SĐT" >

                                </div>
                            </div>

                            <div class="col-md-12">
                                <div class="form-group">
                                    <div class="radio">
                                        <label for="">Giới tính</label>
                                        <input style="margin: 20px;" type="radio" required  name="gioiTinh" value="Nam">Nam
                                        <input style="margin: 20px;" type="radio" name="gioiTinh" value="Nữ">Nu

                                    </div>
                                </div>

                            </div>
                            <div class="col-md-12">
                                <div class="form-group">
                                    <label for="country">Tỉnh/TP</label>
                                    <div class="form-field">
                                        <i class="icon icon-arrow-down3"></i>
                                        <select name="city" id="city" class="form-control">
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
                                        <select name="district" id="district" class="form-control">
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
                                        <select name="ward" id="ward" class="form-control">
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
                                <p><input type="submit"  class="btn btn-primary" value="Đăng ký"></input></p>
                            </div>
                    </form>

                </div>
            </div>
        </div>
    </div>    
    <%@include file="/shared/footer.jsp" %>
    <script src="<c:url value="/resources/js/myjs.js"/>"></script>
</body>
</html>