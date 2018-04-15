<%@page import="model.Bean.User"%>
<%@page import="model.Bean.Advertisement"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/templates/admin/inc/index/leftbar.jsp"%>

<!-- top navigation -->
<%@include file="/templates/admin/inc/index/header.jsp"%>
<!-- /top navigation -->
<%
	User userInfo = (User) session.getAttribute("userLogin");
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
				<h4>Thêm quảng cáo</h4>
				<a class="btn btn-app"
					href="<%=request.getContextPath()%>/admin/adv/add"> <i
					class="glyphicon glyphicon-plus"></i> sửa
				</a>
			</div>
			<div class="x_content">

				<table id="datatable-buttons"
					class="table table-striped table-bordered">
					<thead>
						<tr>
							<th>ID</th>
							<th>Tên Quảng Cáo</th>
							<th>Hình Ảnh</th>
							<th>Active</th>
							<th>Link</th>
							<th>Chức Năng</th>
						</tr>
					</thead>


					<tbody>
						<tr>
							<%
								ArrayList<Advertisement> itemAdvs = (ArrayList<Advertisement>) request.getAttribute("itemAdv");

								if (itemAdvs != null && itemAdvs.size() > 0) {
									for (Advertisement advItem : itemAdvs) {
							%>
							<td><%=advItem.getId()%></td>
							<td><%=advItem.getName()%></td>
							<td><a> <span class="image"><img
										style="width: 100px; height: 40px;"
										src="<%=request.getContextPath()%>/files/<%=advItem.getPicture()%>"
										alt="Profile Image" /></span>
							</a></td>
							<td><div class="form-group">
									<div class="col-md-9 col-sm-9 col-xs-12">
										<div class="">
											<a href="javascript:void(0)"
												onclick="return changeActive(<%=advItem.getId()%>,<%=advItem.getActive()%>)">
												<%
													String checked = "";

															if (advItem.getActive() == 1) {
																checked = "checked = 'checked'";
															} else {
																checked = "";
															}
												%> 
												<%
													if("admin".equals(userInfo.getRank().getName())){
												%>
												<label class="switch" > <input type="checkbox"
													id="id_slide" name="id_slide" 
													<%=checked%>> <span class="slider round"></span>
													
											</label>
											<%} %>
											</a>
										</div>

									</div>
								</div></td>
							<td><%=advItem.getLink()%></td>
							<td><a
								href="<%=request.getContextPath()%>/admin/adv/edit?uid=<%=advItem.getId()%>"
								class="btn btn-primary btn-xs"><i
									class="glyphicon glyphicon-edit"></i> Sửa </a> <a
								href="<%=request.getContextPath()%>/admin/adv/del?did=<%=advItem.getId()%>"
								class="btn btn-danger btn-xs"><i class="fa fa-trash-o"></i>
									Delete </a></td>

						</tr>
						<%
							}
							}
						%>
					</tbody>
				</table>
				<script type="text/javascript">
				function changeActive(id,active) {
					$.ajax({
						url:"<%=request.getContextPath()%>/admin/advs",
						type: 'POST',
						cache: false,
						data:{
							uactive : active,
					        uid: id
						},
						success: function (data) {
							$(".change"+'-'+id).html(data);
						},
						error: function() {
							alert('có lỗi');
						}
					});
				}
				</script>
			</div>
		</div>
	</div>


</div>
<!-- /page content -->

<!-- footer content -->

<%@include file="/templates/admin/inc/index/footer.jsp"%>

</body>
</html>
