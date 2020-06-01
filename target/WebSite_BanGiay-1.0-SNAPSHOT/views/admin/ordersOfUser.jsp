<%-- 
    Document   : ordersOfUser
    Created on : Jun 1, 2020, 11:01:00 PM
    Author     : Truong98
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                                                <a class="btn btn-warning">Sửa</a>
                                                <a class="btn btn-danger">Xóa</a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
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

