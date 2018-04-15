<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/templates/admin/inc/edit/leftbar.jsp"%>

<!-- top navigation -->
<%@include file="/templates/admin/inc/edit/header.jsp"%>
<!-- /top navigation -->
<%
	String nameAdv = request.getParameter("nameAdv");
	String nameLink = request.getParameter("nameLink");
	if (nameAdv == null || nameLink == null) {
		nameAdv = "";
		nameLink = "";
	}
%>
<%
	String msg = request.getParameter("msg");
	if ("3".equals(msg)) {
		out.print("<div id='msg' style='display:none'>Thêm Quảng Cáo Thành Công</div>");
	}
	if ("2".equals(msg)) {
		out.print("<div id='msg' style='display:none'>Sửa Quảng Cáo Thành Công</div>");
	}
	if ("1".equals(msg)) {
		out.print("<div id='msg' style='display:none'>Xóa Quảng Cáo thành công</div>");
	}
	if ("-1".equals(msg)) {
		out.print("<div id='msgerr' style='display:none'>Xóa Quảng Cáo Thất bại</div>");
	}
%>
<!-- page content -->
<div class="right_col" role="main">
	<div class="">

		<div class="row">

			<div class="col-md-6 col-xs-12">
				<div class="x_panel">
					<div class="x_title">
						<h2>Thêm Quảng Cáo</h2>

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
										<%=nameAdv%> placeholder="Default Input">
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12">Link</label>
								<div class="col-md-9 col-sm-9 col-xs-12">
									<input type="text" class="form-control" name="nameLink"
										<%=nameLink%> placeholder="http://...">
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
