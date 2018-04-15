<%@page import="model.Bean.Advertisement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/templates/admin/inc/edit/leftbar.jsp"%>

<!-- top navigation -->
<%@include file="/templates/admin/inc/edit/header.jsp"%>
<!-- /top navigation -->
<%
	Advertisement adv = (Advertisement) request.getAttribute("adv_Old");
%>
<%
	String msg = request.getParameter("msg");
	if ("-2".equals(msg)) {
		out.print("<div id='msgerr' style='display:none'>Sửa Thất Bại</div>");
	}
	if ("-7".equals(msg)) {
		out.print("<div id='msgerr' style='display:none'>Chưa nhập đầy đủ</div>");
	}
%>
<!-- page content -->
<div class="right_col" role="main">
	<div class="">

		<div class="row">

			<div class="col-md-6 col-xs-12">
				<div class="x_panel">
					<div class="x_title">
						<h2>Sửa bài viết</h2>

						<div class="clearfix"></div>
					</div>
					<div class="x_content">
						<br />
						<form class="form-horizontal form-label-left"
							enctype="multipart/form-data" method="post">

							<div class="form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12">Tên
									Quảng Cáo</label>
								<div class="col-md-9 col-sm-9 col-xs-12">
									<input type="text" class="form-control" name="nameAdv"
										value="<%=adv.getName()%>" placeholder="Default Input">
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12">Link</label>
								<div class="col-md-9 col-sm-9 col-xs-12">
									<input type="text" class="form-control" name="nameLink"
										value="<%=adv.getLink()%>" placeholder="Default Input">
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12">Xóa
									Ảnh</label>
								<div class="col-md-9 col-sm-9 col-xs-12">
									<div class="">
										<label> <input type="checkbox" class="js-switch"
											name="delpicture"  />
										</label>
									</div>

								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12">Hình
									ảnh</label>
								<div class="col-md-9 col-sm-9 col-xs-12">
									<div class="btn-group">
										<a class="btn" title="Insert picture (or just drag & drop)"
											id="pictureBtn"><i class="fa fa-picture-o"></i></a> <input
											type="file" data-role="magic-overlay" name="picture"
											data-target="#pictureBtn" data-edit="insertImage" />
									</div>
									<div class="thumbnail">
										<img style="width: 100%; display: block;"
											src="<%=request.getContextPath()%>/files/<%=adv.getPicture()%>"
											alt="image" />
									</div>
								</div>
							</div>

							<div class="ln_solid"></div>
							<div class="form-group">
								<div class="col-md-9 col-sm-9 col-xs-12 col-md-offset-3">
									<button type="submit" class="btn btn-success">Submit</button>
									<button type="reset" class="btn btn-primary">Reset</button>
								</div>
							</div>

						</form>
					</div>
				</div>
			</div>




		</div>
	</div>







</div>
</div>
<!-- /page content -->

<!-- footer content -->
<%@include file="/templates/admin/inc/edit/footer.jsp"%>

</body>
</html>
