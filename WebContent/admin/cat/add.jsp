<%@page import="model.Bean.Category"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/templates/admin/inc/edit/leftbar.jsp"%>

<!-- top navigation -->
<%@include file="/templates/admin/inc/edit/header.jsp"%>
<!-- /top navigation -->
<%
	String msg = request.getParameter("msg");
	if ("-3".equals(msg)) {
		out.print("<div id='msgerr' style='display:none'>Thêm Danh Mục Thất bại</div>");
	}
	if ("-9".equals(msg)) {
		out.print("<div id='msgerr' style='display:none'>Trùng Danh Mục</div>");
	}
%>
<!-- page content -->
<div class="right_col" role="main">
	<div class="">

		<div class="row">

			<div class="col-md-6 col-xs-12">
				<div class="x_panel">
					<div class="x_title">
						<h2>Thêm Danh Mục</h2>

						<div class="clearfix"></div>
					</div>
					<div class="x_content">
						<br />
						<form class="form-horizontal form-label-left" method="post">

							<div class="form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12">Tên
									Danh Mục</label>
								<div class="col-md-9 col-sm-9 col-xs-12">
									<input type="text" name="category" class="form-control"
										placeholder="Default Input">
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12">Danh
									mục Cha</label>
								<div class="col-md-9 col-sm-9 col-xs-12">
									<select name="parent_id" class="form-control">
										<option value="0">--Chọn danh mục--</option>
										<%
											ArrayList<Category> itemCats = (ArrayList<Category>) request.getAttribute("category");
											if (itemCats != null && itemCats.size() > 0) {
												for (Category itemCat : itemCats) {
													if (itemCat.getId_Parent() == 0) {
										%>
										<option value="<%=itemCat.getId()%>"><%=itemCat.getName()%></option>
										<%
											}
												}
											}
										%>
									</select>
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
<footer>
	<div class="pull-right">
		Gentelella - Bootstrap Admin Template by <a
			href="https://colorlib.com">Colorlib</a>
	</div>
	<div class="clearfix"></div>
</footer>
<!-- /footer content -->
</div>
</div>

<!-- jQuery -->
<script
	src="<%=request.getContextPath()%>/templates/admin/vendors/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap -->
<script
	src="<%=request.getContextPath()%>/templates/admin/vendors/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- FastClick -->
<script
	src="<%=request.getContextPath()%>/templates/admin/vendors/fastclick/lib/fastclick.js"></script>
<!-- NProgress -->
<script
	src="<%=request.getContextPath()%>/templates/admin/vendors/nprogress/nprogress.js"></script>
<!-- bootstrap-progressbar -->
<script
	src="<%=request.getContextPath()%>/templates/admin/vendors/bootstrap-progressbar/bootstrap-progressbar.min.js"></script>
<!-- iCheck -->
<script
	src="<%=request.getContextPath()%>/templates/admin/vendors/iCheck/icheck.min.js"></script>
<!-- bootstrap-daterangepicker -->
<script
	src="<%=request.getContextPath()%>/templates/admin/vendors/moment/min/moment.min.js"></script>
<script
	src="<%=request.getContextPath()%>/templates/admin/vendors/bootstrap-daterangepicker/daterangepicker.js"></script>
<!-- bootstrap-wysiwyg -->
<script
	src="<%=request.getContextPath()%>/templates/admin/vendors/bootstrap-wysiwyg/js/bootstrap-wysiwyg.min.js"></script>
<script
	src="<%=request.getContextPath()%>/templates/admin/vendors/jquery.hotkeys/jquery.hotkeys.js"></script>
<script
	src="<%=request.getContextPath()%>/templates/admin/vendors/google-code-prettify/src/prettify.js"></script>
<!-- jQuery Tags Input -->
<script
	src="<%=request.getContextPath()%>/templates/admin/vendors/jquery.tagsinput/src/jquery.tagsinput.js"></script>
<!-- Switchery -->
<script
	src="<%=request.getContextPath()%>/templates/admin/vendors/switchery/dist/switchery.min.js"></script>
<!-- Select2 -->
<script
	src="<%=request.getContextPath()%>/templates/admin/vendors/select2/dist/js/select2.full.min.js"></script>
<!-- Parsley -->
<script
	src="<%=request.getContextPath()%>/templates/admin/vendors/parsleyjs/dist/parsley.min.js"></script>
<!-- Autosize -->
<script
	src="<%=request.getContextPath()%>/templates/admin/vendors/autosize/dist/autosize.min.js"></script>
<!-- jQuery autocomplete -->
<script
	src="<%=request.getContextPath()%>/templates/admin/vendors/devbridge-autocomplete/dist/jquery.autocomplete.min.js"></script>
<!-- starrr -->
<script
	src="<%=request.getContextPath()%>/templates/admin/vendors/starrr/dist/starrr.js"></script>
<!-- Custom Theme Scripts -->
<script
	src="<%=request.getContextPath()%>/templates/admin/build/js/custom.min.js"></script>

</body>
</html>
