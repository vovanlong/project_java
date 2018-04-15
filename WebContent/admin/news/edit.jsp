<%@page import="model.Bean.News"%>
<%@page import="model.Bean.Category"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/templates/admin/inc/edit/leftbar.jsp"%>

<!-- top navigation -->
<%@include file="/templates/admin/inc/edit/header.jsp"%>
<!-- /top navigation -->
<%
	News itemOld = (News) request.getAttribute("getItemNews");
	String msg = request.getParameter("msg");
	
	if ("-2".equals(msg)) {
		out.print("<div id='msgerr' style='display:none'>Sửa Tin thất bại</div>");
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
										value="<%=itemOld.getName()%>" placeholder="Default Input">
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12">Danh
									mục</label>
								<div class="col-md-9 col-sm-9 col-xs-12">

									<select class="form-control" name="id_category">
										<%
											String selected = "";
											ArrayList<Category> itemCategories = (ArrayList<Category>) request.getAttribute("itemCategories");
											if (itemCategories != null && itemCategories.size() > 0) {
												for (Category itemCategory : itemCategories) {
													if (itemCategory.getId_Parent() == 0) {
														if (itemOld.getId_Cat() == itemCategory.getId()) {
															selected = "selected='selected'";
														} else {
															selected = "";
														}
										%>
										<option value="<%=itemCategory.getId()%>" <%=selected%>><%=itemCategory.getName()%></option>
										<%
											} else {
														if (itemOld.getId_Cat() == itemCategory.getId()) {
															selected = "selected='selected'";
														} else {
															selected = "";
														}
										%>
										<option value="<%=itemCategory.getId()%>" <%=selected%>>>>>>><%=itemCategory.getName()%></option>
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
										<%
											String checked = "";
											if (1 == itemOld.getId_Slide()) {
												checked = "checked";
											} else {
												checked = "";
											}
										%>
										<label> <input type="checkbox" class="js-switch"
											name="slide" <%=checked%> />
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
									<div class="thumbnail">
										<img style="width: 100%; display: block;"
											src="<%=request.getContextPath()%>/files/<%=itemOld.getPicture()%>"
											alt="image" />
									</div>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12">Mô
									tả</label>
								<div class="col-md-9 col-sm-9 col-xs-12">
									<input type="text" class="form-control" name="preview"
										value="<%=itemOld.getPreview()%>">
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12">Chi
									tiết </label>
								<div class="col-md-9 col-sm-9 col-xs-12">
									<textarea class="form-control" name="detail" rows="3"><%=itemOld.getDetail()%></textarea>
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
