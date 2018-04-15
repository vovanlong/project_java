<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/templates/admin/inc/index/leftbar.jsp"%>

<!-- top navigation -->
<%@include file="/templates/admin/inc/index/header.jsp"%>
<!-- /top navigation -->

<!-- page content -->
<div class="right_col" role="main">
	<!-- top tiles -->

	<!-- /top tiles -->
	<div class="col-md-12 col-sm-12 col-xs-12">
		<div class="title_right">
			<div
				class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">
				<div class="input-group">
					<input type="text" class="form-control" placeholder="Search for...">
					<span class="input-group-btn">
						<button class="btn btn-default" type="button">Go!</button>
					</span>
				</div>
			</div>
		</div>

		<div class="x_panel">

			<div class="x_content">
				<h4>Thêm tin tức</h4>
				<a class="btn btn-app"> <i class="glyphicon glyphicon-plus"></i>
					sửa
				</a>
			</div>
			<div class="x_content">

				<table id="datatable-buttons"
					class="table table-striped table-bordered">
					<thead>
						<tr>
							<th>ID</th>
							<th>Tên Bài Viết</th>
							<th>Hình Ảnh</th>
							<th>Ngày Tạo</th>
							<th>Danh Mục</th>
							<th>Chức Năng</th>
						</tr>
					</thead>


					<tbody>
						<tr>
							<td>1</td>
							<td>Tổng Thống OBAMA</td>
							<td><a> <span class="image"><img
										src="<%=request.getContextPath()%>/templates/admin/production/images/img.jpg"
										alt="Profile Image"  /></span>
							</a></td>
							<td>2010/07/14</td>
							<td>Thời sự</td>
							<td><a href="#" class="btn btn-primary btn-xs"><i
									class="glyphicon glyphicon-edit"></i> Sửa </a> <a href="#"
								class="btn btn-danger btn-xs"><i class="fa fa-trash-o"></i>
									Delete </a></td>
						</tr>
						<tr>
							<td>1</td>
							<td>Tổng Thống OBAMA</td>
							<td><a> <span class="image"><img
										src="<%=request.getContextPath()%>/templates/admin/production/images/img.jpg"
										alt="Profile Image" /></span>
							</a></td>
							<td>2010/07/14</td>
							<td>Thời sự</td>
							<td><a href="#" class="btn btn-primary btn-xs"><i
									class="glyphicon glyphicon-edit"></i> Sửa </a> <a href="#"
								class="btn btn-danger btn-xs"><i class="fa fa-trash-o"></i>
									Delete </a></td>
						</tr>
						<tr>
							<td>1</td>
							<td>Tổng Thống OBAMA</td>
							<td><a> <span class="image"><img
										src="<%=request.getContextPath()%>/templates/admin/production/images/img.jpg"
										alt="Profile Image" /></span>
							</a></td>
							<td>2010/07/14</td>
							<td>Thời sự</td>
							<td><a href="#" class="btn btn-primary btn-xs"><i
									class="glyphicon glyphicon-edit"></i> Sửa </a> <a href="#"
								class="btn btn-danger btn-xs"><i class="fa fa-trash-o"></i>
									Delete </a></td>
						</tr>
						<tr>
							<td>1</td>
							<td>Tổng Thống OBAMA</td>
							<td><a> <span class="image"><img
										src="<%=request.getContextPath()%>/templates/admin/production/images/img.jpg"
										alt="Profile Image" /></span>
							</a></td>
							<td>2010/07/14</td>
							<td>Thời sự</td>
							<td><a href="#" class="btn btn-primary btn-xs"><i
									class="glyphicon glyphicon-edit"></i> Sửa </a> <a href="#"
								class="btn btn-danger btn-xs"><i class="fa fa-trash-o"></i>
									Delete </a></td>
						</tr>
						<tr>
							<td>1</td>
							<td>Tổng Thống OBAMA</td>
							<td><a> <span class="image"><img
										src="<%=request.getContextPath()%>/templates/admin/production/images/img.jpg"
										alt="Profile Image" /></span>
							</a></td>
							<td>2010/07/14</td>
							<td>Thời sự</td>
							<td><a href="#" class="btn btn-primary btn-xs"><i
									class="glyphicon glyphicon-edit"></i> Sửa </a> <a href="#"
								class="btn btn-danger btn-xs"><i class="fa fa-trash-o"></i>
									Delete </a></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>


</div>
<!-- /page content -->

<!-- footer content -->

<%@include file="/templates/admin/inc/index/footer.jsp"%>

</body>
</html>
