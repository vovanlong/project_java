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
	if ("-2".equals(msg)) {
		out.print("<div id='msgerr' style='display:none'>Sửa Danh Mục Thất bại</div>");
	}
%>
<!-- page content -->
<div class="right_col" role="main">
	<div class="">

		<div class="row">

			<div class="col-md-6 col-xs-12">
				<div class="x_panel">
					<div class="x_title">
						<h2>Sửa Danh Mục</h2>

						<div class="clearfix"></div>
					</div>
					<div class="x_content">
						<br />
						<form class="form-horizontal form-label-left" method="post">

							<div class="form-group">
								<%
									int id_Cat = Integer.parseInt(request.getParameter("id"));
									ArrayList<Category> getItems = (ArrayList<Category>) request.getAttribute("getItems");
									Category getItem = (Category) request.getAttribute("getItem");
								%>
								<label class="control-label col-md-3 col-sm-3 col-xs-12">Tên
									Danh Mục</label>
								<%
									if (getItem != null) {
								%>
								<div class="col-md-9 col-sm-9 col-xs-12">
									<input type="text" class="form-control" name="nameCat"
										value="<%=getItem.getName()%>">
								</div>
								<%
									}
								%>
							</div>
							<div class="form-group">

								<div class="form-group">
									<label class="control-label col-md-3 col-sm-3 col-xs-12">Danh
										mục cha</label>
									<div class="col-md-9 col-sm-9 col-xs-12">
										<select class="form-control" name="category">
											<option value="0">Danh mục cha</option>
											<%
												String selected = "";
												for (Category getItemCat : getItems) {
													if (getItemCat.getId_Parent() == 0) {
														if (getItemCat.getId() == getItem.getId_Parent()) {
															selected = "selected = 'selected'";

														} else {
															selected = " ";
														}
											%>
											<option <%=selected%> value="<%=getItemCat.getId()%>"><%=getItemCat.getName()%></option>
											<%
												}
												}
											%>
										</select>
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
