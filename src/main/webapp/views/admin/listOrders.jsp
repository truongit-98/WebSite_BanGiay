<%-- 
    Document   : home_admin
    Created on : May 21, 2020, 6:23:33 AM
    Author     : Quang Vinh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
       <%@include file="/shared/admin/head.jsp" %>
    </head>
    <body class="no-skin">
        <style>
            .page-item{
                cursor: pointer;
            }
        </style>
        <%@include file="/shared/admin/header.jsp" %>
        <div class='main-container' id='main-container'>
            <script type="text/javascript">
                try {
                    ace.settings.check('main-container', 'fixed')
                } catch (e) {
                }
            </script>
            <%@include file="/shared/admin/sidebar.jsp" %>
            <div class='main-content'>
                <div class="main-content-inner">
                    <div class="page-content">
                        <h1>Danh sách đơn hàng</h1>
                        <div class="card border-info">
                            <div style="margin-bottom: 10px">
                                <form method="GET" action="/WebSite_BanGiay/admin/orders">
                                    <input name="search" style="width: 20%;" value="${not empty keySearch ? keySearch: ''}" type="text" placeholder="Nhập tên hoặc mã ĐH...">
                                    <label style="margin: 10px">Từ Ngày</label> 
                                    <input name="startDate" value="${not empty startDate ? startDate : ''}" type="date">
                                    <label style="margin: 10px">Đến Ngày</label> 
                                    <input name="toDate" value="${not empty toDate ? toDate : ''}}" type="date">
                                    <button style="height: 40px; width: 100px" type="submit"><i style="font-size: 16px" class="fa fa-search"></i>Tìm kiếm</button>
                                </form>

                            </div>
                            <table id="dynamic-table" class="table table-striped table-bordered table-hover center" >
                                <thead style="text-align: center">
                                    <tr>
                                        <th>Mã ĐH</th>
                                        <th>Người Đặt</th>
                                        <th>Ngày Đặt</th>
                                        <th>Tình trạng</th>
                                        <th>Tổng tiền</th>
                                        <th>Hình thức thanh toán</th>
                                        <th></th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="order" items="${orders}">
                                        <tr>
                                            <td>${order.maDH}</td>
                                            <td>${order.hoTen}</td>
                                            <td>${order.ngayDat}</td>
                                            <td>${order.tinhTrang}</td>
                                            <td>${order.tongTien}</td>
                                            <td>${order.thanhToan}</td>
                                            <td style="color: white;">
                                                <a href="/WebSite_BanGiay/admin/orders/${order.maDH}" class="btn btn-warning">Sửa</a>
                                                <a href="/WebSite_BanGiay/admin/orders/delete/${order.maDH}" class="btn btn-danger">Xóa</a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                        <div class="row">
                            <div class="col-md-12 text-center">

                                <div style="display:flex;justify-content: center;">
                                    <div >
                                        <c:if test="${page > 1 }">
                                            <div class="d-flex" style="height: 27px;">
                                                <button class="mr-2">
                                                    <a data-page="${page-1}" class="mr-2 page-item" ><<</a>
                                                </button>
                                            </div>
                                        </c:if>
                                    </div>
                                    <c:forEach var="i" begin="1" end="${pageMax}" step="1">
                                        <c:if test="${page == i}">
                                            <div style="background-color: #82777759;width: 30px;height: 26px;border: 1px solid;margin-right: 4px;">${i}</div>
                                        </c:if>
                                        <c:if test="${page != i}">
                                            <a class="page-item"  data-page="${i}"  style="width: 30px;height: 26px;border: 1px solid;margin-right: 4px;">${i}</a>
                                        </c:if>
                                    </c:forEach>
                                    <div>
                                        <c:if test="${page < pageMax}">
                                            <div class="d-flex" style="height: 27px;">
                                                <button class="mr-3 ml-2" >
                                                    <a data-page="${page + 1}"  class="page-item" > >></a>
                                                </button>
                                            </div>
                                        </c:if>
                                    </div>

                                </div>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <%@include file="/shared/admin/footer.jsp" %>
        </div>
        
       
        <script>
            $(document).ready(function(){
                
               $('.page-item').on('click', function(e){
                   e.preventDefault();
                   debugger
                   const regex = /\?/;
                   var href = window.location.href.replace(/[\?\&]{1}page=\d*/g, "");
                   
                   if(regex.test(href, 'g')){
                       href += '&page=' + $(this).attr('data-page');
                   } else {
                       href += '?page=' + $(this).attr('data-page');
                   }
                   window.location.href = href;
               });
            });
        </script>
    </body>
</html>
