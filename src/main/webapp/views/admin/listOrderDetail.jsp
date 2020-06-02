<%-- 
    Document   : listOrderDetail
    Created on : Jun 2, 2020, 10:38:24 AM
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
                            </div>
                            <table id="dynamic-table" class="table table-striped table-bordered table-hover center" >
                                <thead style="text-align: center">
                                    <tr>
                                        <th>Mã ĐH</th>
                                        <th>Tên SP</th>
                                        <th>Size</th>
                                        <th>Số lượng</th>
                                        <th>Giá</th>
                                        <th></th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="item" items="${orderDetails}">
                                        <tr>
                                            <td>${item.id.madh}</td>
                                            <td>${item.product.tensp}</td>
                                            <td>${item.size.size}</td>
                                            <td>${item.soluong}</td>
                                            <td>${item.gia}</td>
                                            <td style="color: white;">
                                                 <a href="/WebSite_BanGiay/admin/orderDetails/order/${item.id.madh}/product/${item.id.masp}/size/${item.id.maSize}" class="btn btn-warning">Sửa</a>
                                                <a href="/WebSite_BanGiay/admin/orderDetail/delete/${item.id.madh}/product/${item.id.masp}/size/${item.id.maSize}" class="btn btn-danger">Xóa</a>
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