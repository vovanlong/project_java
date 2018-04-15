<%@page import="model.Bean.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Meta, title, CSS, favicons, etc. -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>LongIT</title>

<!-- Bootstrap -->
<link
	href="<%=request.getContextPath()%>/templates/admin/vendors/bootstrap/dist/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Font Awesome -->
<link
	href="<%=request.getContextPath()%>/templates/admin/vendors/font-awesome/css/font-awesome.min.css"
	rel="stylesheet">
<!-- NProgress -->
<link
	href="<%=request.getContextPath()%>/templates/admin/vendors/nprogress/nprogress.css"
	rel="stylesheet">
<!-- iCheck -->
<link
	href="<%=request.getContextPath()%>/templates/admin/vendors/iCheck/skins/flat/green.css"
	rel="stylesheet">
<!-- bootstrap-wysiwyg -->
<link
	href="<%=request.getContextPath()%>/templates/admin/vendors/google-code-prettify/bin/prettify.min.css"
	rel="stylesheet">
<!-- Select2 -->
<link
	href="<%=request.getContextPath()%>/templates/admin/vendors/select2/dist/css/select2.min.css"
	rel="stylesheet">
<!-- Switchery -->
<link
	href="<%=request.getContextPath()%>/templates/admin/vendors/switchery/dist/switchery.min.css"
	rel="stylesheet">
<!-- starrr -->
<link
	href="<%=request.getContextPath()%>/templates/admin/vendors/starrr/dist/starrr.css"
	rel="stylesheet">
<!-- bootstrap-daterangepicker -->
<link
	href="<%=request.getContextPath()%>/templates/admin/vendors/bootstrap-daterangepicker/daterangepicker.css"
	rel="stylesheet">

<!-- Custom Theme Style -->
<link
	href="<%=request.getContextPath()%>/templates/admin/build/css/custom.min.css"
	rel="stylesheet">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/templates/admin/build/js/sweetalert.min.js"></script>
</head>
<%
	User userGet3 = (User) session.getAttribute("userLogin");
%>
<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<div class="col-md-3 left_col">
				<div class="left_col scroll-view">
					<div class="navbar nav_title" style="border: 0;">
						<a href="index.html" class="site_title"><i class="fa fa-paw"></i>
							<span>LONGIT</span></a>
					</div>

					<div class="clearfix"></div>

					<!-- menu profile quick info -->
					<div class="profile clearfix">
						<div class="profile_pic">
							<img
								src="<%=request.getContextPath()%>/templates/admin/production/images/img.jpg"
								alt="..." class="img-circle profile_img">
						</div>
						<div class="profile_info">
							<span>Welcome,</span>
							<h2><%=userGet3.getFullname()%></h2>
						</div>
					</div>
					<!-- /menu profile quick info -->

					<br />

					<!-- sidebar menu -->
					<div id="sidebar-menu"
						class="main_menu_side hidden-print main_menu">
						<div class="menu_section">
							<h3>General</h3>
							<ul class="nav side-menu">
								<li><a href="<%=request.getContextPath()%>/admin/cats"><i
										class="fa fa-home"></i> Danh Mục </a></li>
								<li><a href="<%=request.getContextPath()%>/admin/news"><i
										class="fa fa-edit"></i> Bài Viết </span></a></li>
								<li><a href="<%=request.getContextPath()%>/admin/comment"><i
										class="fa fa-desktop"></i>Bình Luận </span></a></li>
								<li><a href="<%=request.getContextPath()%>/admin/users"><i
										class="fa fa-table"></i> Quản trị viên</span></a></li>
								<li><a href="<%=request.getContextPath()%>/admin/advs"><i
										class="fa fa-bar-chart-o"></i> Quảng cáo</span></a></li>

							</ul>
						</div>


					</div>
					<!-- /sidebar menu -->
					<script type="text/javascript">
						$(document).ready(function() {

							var msg = $('#msg').html();

							if (msg != "") {
								swal(msg, "", "success");
							}

						});
						$(document).ready(function() {
							var msgerr = $('#msgerr').html();
							if (msgerr != "") {
								swal(msgerr, "", "error");
							}
						});
					</script>
					<!-- /menu footer buttons -->
					<div class="sidebar-footer hidden-small">
						<a data-toggle="tooltip" data-placement="top" title="Logout"
							href="<%=request.getContextPath()%>/auth/logout""> <span
							class="glyphicon glyphicon-off" aria-hidden="true"></span>
						</a>
					</div>
					<!-- /menu footer buttons -->
				</div>
			</div>