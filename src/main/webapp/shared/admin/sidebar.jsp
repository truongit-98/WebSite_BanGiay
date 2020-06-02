<%-- 
    Document   : sidebar
    Created on : May 20, 2020, 11:28:41 PM
    Author     : Quang Vinh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div id="sidebar" class="sidebar                  responsive">
    <script type="text/javascript">
        try {
            ace.settings.check('sidebar', 'fixed')
        } catch (e) {
        }
    </script>
    <ul class="nav nav-list">
        <li class="active">
            <a href="/WebSite_BanGiay/admin/home">
                <i class="menu-icon fa fa-tachometer"></i>
                <span class="menu-text"> Danh sách sản phẩm </span>
            </a>

            <b class="arrow"></b>
        </li>

        <li class="">
            <a href="#">
                <i class="menu-icon fa fa-filter"></i>
                <span class="menu-text"> Loại sản phẩm </span>
            </a>

            <b class="arrow"></b>
        </li>	
        
        <li class="">
            <a href="#" class="dropdown-toggle">
                <i class="menu-icon fa fa-pencil-square-o"></i>
                <span class="menu-text">
                    Quản lý đơn hàng
                </span>

                <b class="arrow fa fa-angle-down"></b>
            </a>

            <b class="arrow"></b>
            <ul class="submenu">
                <li class="">
                    <a href="/WebSite_BanGiay/admin/orders" class="">
                        <i class="menu-icon fa fa-caret-right"></i>
                        Danh sách đơn hàng
                        <b class="arrow fa fa-angle-down"></b>
                    </a>

                    <b class="arrow"></b>
                </li>
                <li class="">
                    <a href="/WebSite_BanGiay/admin/orderDetails" class="">
                        <i class="menu-icon fa fa-caret-right"></i>
                        Danh sách chi tiết đơn hàng
                        <b class="arrow fa fa-angle-down"></b>
                    </a>

                    <b class="arrow"></b>
                </li>
            </ul>
        </li>
	<li>
            <a href="/WebSite_BanGiay/admin/staff">
                <i class="menu-icon fa fa-user"></i>
                <span class="menu-text"> Nhân viên </span>
            </a>

            <b class="arrow"></b>
        </li>	
        
        <li class="">
            <a href="/WebSite_BanGiay/admin/customer">
                <i class="menu-icon fa fa fa-users"></i>
                <span class="menu-text"> Khách hàng </span>
            </a>

            <b class="arrow"></b>
        </li>	
        
    </ul><!-- /.nav-list -->

    <div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
        <i class="ace-icon fa fa-angle-double-left" data-icon1="ace-icon fa fa-angle-double-left" data-icon2="ace-icon fa fa-angle-double-right"></i>
    </div>

    <script type="text/javascript">
        try {
            ace.settings.check('sidebar', 'collapsed')} catch (e) {
        }
    </script>
</div>
