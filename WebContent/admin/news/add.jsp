<%@page import="model.Bean.Category"%>
<%@page import="model.Bean.News"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/templates/admin/inc/edit/leftbar.jsp"%>

<!-- top navigation -->
<%@include file="/templates/admin/inc/edit/header.jsp"%>
<!-- /top navigation -->
<%
	String msg = request.getParameter("msg");
	if ("-100".equals(msg)) {
		out.print("<div id='msgerr' style='display:none'>Bạn Chưa chọn danh mục!!!</div>");
	}
	if ("3".equals(msg)) {
		out.print("<div id='msg' style='display:none'>Thêm tin thành công</div>");
	}
	if ("-3".equals(msg)) {
		out.print("<div id='msgerr' style='display:none'>Thêm Tin thất bại</div>");
	}
	String name = request.getParameter("namenews");
	String id_category = request.getParameter("id_category");
	String preview = request.getParameter("preview");
	String detail = request.getParameter("detail");
	String picture = request.getParameter("picture");
	if (name == null && id_category == null || preview == null || detail == null || picture == null) {
		name = "";
		id_category = "";
		preview = "";
		detail = "";
		picture = "";
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
									bài viết</label>
								<div class="col-md-9 col-sm-9 col-xs-12">
									<input type="text" class="form-control" name="namenews"
										value="<%=name%>" placeholder="Default Input">
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12">Danh
									mục</label>
								<div class="col-md-9 col-sm-9 col-xs-12">
									<select class="form-control" name="id_category">
										<option value="-100">>>>Chọn Danh Mục<<<</option>
										<%
											ArrayList<Category> itemCategories = (ArrayList<Category>) request.getAttribute("itemCategories");
											if (itemCategories != null && itemCategories.size() > 0) {
												for (Category itemCategory : itemCategories) {
													if (itemCategory.getId_Parent() == 0) {
										%>
										<option value="<%=itemCategory.getId()%>"
											<%if (id_category.equals(String.valueOf(itemCategory.getId()))) {
							out.print(" selected");
						}%>><%=itemCategory.getName()%></option>
										<%
											} else {
										%>
										<option value="<%=itemCategory.getId()%>"
											<%if (id_category.equals(String.valueOf(itemCategory.getId()))) {
							out.print(" selected");
						}%>>>>>>><%=itemCategory.getName()%></option>
										<%
											}
												}
											}
										%>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12">Slide</label>
								<div class="col-md-9 col-sm-9 col-xs-12">
									<div class="">
										<label> <input type="checkbox" class="js-switch"
											name="slide" checked />
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
											type="file" name="picture" data-role="magic-overlay"
											data-target="#pictureBtn" data-edit="insertImage" />
									</div>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12">Mô
									tả</label>
								<div class="col-md-9 col-sm-9 col-xs-12">
									<input type="text" class="form-control" name="preview"
										value="rhymstic123">
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12">Chi
									tiết </label>
								<div class="col-md-9 col-sm-9 col-xs-12">
									<textarea class="form-control" name="detail" rows="3"></textarea>
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

<!-- /footer content -->
<%@include file="/templates/admin/inc/edit/footer.jsp"%>

</body>
</html>
