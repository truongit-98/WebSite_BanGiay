<%-- 
    Document   : sider
    Created on : Apr 22, 2020, 10:19:09 AM
    Author     : Quang Vinh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

       <div id="wrapper">

		<!-- Sidebar -->
		<ul class="sidebar navbar-nav">
			<li class="nav-item"><a class="nav-link"
				href="/FreshFood/quan-tri/san-pham/danh-sach?page=1&limit=5"> <i
					class="fas fa-apple-alt"></i> <span>Sản Phẩm</span>
			</a></li>

			<li class="nav-item"><a class="nav-link" href="charts.html">
					<i class="fas fa-file-invoice-dollar"></i> <span>Hóa Đơn</span>
			</a></li>
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#" id="pagesDropdown"
				role="button" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false"> <i class="fas fa-user-tie"></i> <span>Người
						Dùng</span>
			</a>
				<div class="dropdown-menu" aria-labelledby="pagesDropdown">
					<h6 class="dropdown-header">Quyền :</h6>
					<a class="dropdown-item" href="/FreshFood/quan-tri/user/danh-sach-admin?page=1&limit=5">Admin</a> <a
						class="dropdown-item" href="#">Khách hàng</a>
				</div></li>
			<li class="nav-item active"><a class="nav-link"
				href="tables.html"> <i class="fas fa-industry"></i> <span>Nhà
						Sản Xuất</span></a></li>

			<li class="nav-item active"><a class="nav-link"
				href="tables.html"> <i class="far fa-clone"></i> <span>Loại
						Sản Phẩm</span></a></li>

		</ul>

		<div id="content-wrapper">

			<div class="container-fluid">

				<dec:body />

			</div>
			<!-- /.container-fluid -->

		</div>
		<!-- /.content-wrapper -->

	</div>
