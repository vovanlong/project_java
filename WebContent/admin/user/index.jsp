<%@page import="model.Bean.User"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/templates/admin/inc/index/leftbar.jsp"%>
<%
	User getUsername = (User) session.getAttribute("userLogin");
%>
<!-- top navigation -->
<%@include file="/templates/admin/inc/index/header.jsp"%>
<!-- /top navigation -->
<%
	String msg = request.getParameter("msg");
	if ("3".equals(msg)) {
		out.print("<div id='msg' style='display:none'>Thêm Users Thành Công</div>");
	}
	if ("2".equals(msg)) {
		out.print("<div id='msg' style='display:none'>Sửa Users Thành Công</div>");
	}
	if ("1".equals(msg)) {
		out.print("<div id='msg' style='display:none'>Xóa Users Thành Công</div>");
	}
	if ("-1".equals(msg)) {
		out.print("<div id='msgerr' style='display:none'>Xóa Users Thất Bại</div>");
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
					<form class="form-inline"
						action="<%=request.getContextPath()%>/admin/users" method="get">
						<div class="form-group">
							<input type="text" name="search" class="form-control"
								placeholder="Search for...">
						</div>
						<button class="btn btn-default" type="submit">Go!</button>
					</form>

				</div>
			</div>
		</div>

		<div class="x_panel">

			<div class="x_content">
				<h4>Thành viên</h4>
				<a href="<%=request.getContextPath()%>/admin/user/add"
					class="btn btn-app"> <i class="glyphicon glyphicon-plus"></i>
					Thêm
				</a>
			</div>
			<div class="x_content">

				<table id="datatable-buttons"
					class="table table-striped table-bordered">
					<thead>
						<tr>
							<th>ID</th>
							<th>Username</th>
							<th>FullName</th>
							<th>Email</th>
							<th>Active</th>
							<th>Cấp bậc</th>
							<th>Chức Năng</th>
						</tr>
					</thead>


					<tbody>
						<%
							ArrayList<User> items = (ArrayList<User>) request.getAttribute("items");
							if (items != null && items.size() > 0) {
								for (User item : items) {
						%>
						<tr>
							<td><%=item.getId()%></td>
							<td><%=item.getUsername()%></td>
							<td><%=item.getFullname()%></td>
							<td><%=item.getEmail()%></td>
							<td>
								<div class="form-group">
									<div class="col-md-9 col-sm-9 col-xs-12">
										<div class="">
											<a href="javascript:void(0)"
												onclick="return changeActive(<%=item.getId()%>,<%=item.getActive()%>)">
												<%
													String checked = "";
															if (item.getActive() == 1) {
																checked = "checked = 'checked'";
															} else {
																checked = "";
															}
												%> 
												<%
													if("admin".equals(getUsername.getRank().getName())){
												%>
												<label class="switch"> <input type="checkbox"
													id="id_slide" name="id_slide" <%=checked%>> <span
													class="slider round"></span>
											</label>
											<%} %>
											</a>
										</div>

									</div>
								</div>
							</td>
							<td><%=item.getRank().getName()%></td>
							<td>
							<%
								if("admin".equals(getUsername.getRank().getName())){
							%>
								<a
								href="<%=request.getContextPath()%>/admin/user/edit?id=<%=item.getId()%>"
								class="btn btn-primary btn-xs"><i
									class="glyphicon glyphicon-edit"></i> Sửa 
								</a>
								 <a href="<%=request.getContextPath()%>/admin/user/del?did=<%=item.getId()%>"
								class="btn btn-danger btn-xs"><i class="fa fa-trash-o"></i>
									Delete 
								</a>
								<%} %>
							</td>
						</tr>
						<%
							}
							}
						%>
					</tbody>
				</table>
				<div class="row">
					<%
						String search = request.getParameter("search");
						if (null == search) {
					%>

					<div class="btn-group">
						<%
							int back = 0;
								int next = 0;
								int page_Num = 5;
								int page_Start = 0;
								int page_End;
								int num_Link;
								int current_Page = (Integer) request.getAttribute("current_Page");
								int sumPage = (Integer) request.getAttribute("sumPage");
								num_Link = (page_Num / 2);

								/* if (current_Page > 1 && sumPage > 0) {
									back = current_Page - 1;
								}
								if (current_Page < sumPage && sumPage > 1) {
									next = current_Page + 1;
								} */
						%>
						<%
							if (current_Page > 1 && sumPage > 0) {
									back = current_Page - 1;
						%>
						<a href="<%=request.getContextPath()%>/admin/users?page=<%=back%>"
							class="btn btn-danger" type="button"><i
							class="fa fa-long-arrow-left"></i></a>
						<%
							}
						%>
						<%
							if (current_Page > page_Num) {
									page_Start = current_Page - num_Link;
									if (sumPage > (current_Page + num_Link)) {
										page_End = current_Page + num_Link;
									} else if (current_Page <= sumPage && current_Page > sumPage - (page_Num - 1)) {
										page_Start = sumPage - (page_Num - 1);
										page_End = sumPage;
									} else {
										page_End = sumPage;
									}
								} else {
									page_Start = 1;
									if (sumPage > page_Num) {
										page_End = page_Num;
									} else {
										page_End = sumPage;
									}
								}
						%>

						<%
							String active = "";
								for (int i = page_Start; i <= page_End; i++) {
									if (current_Page == i) {
										active = "active";
									} else {
										active = "";
									}
						%>
						<a href="<%=request.getContextPath()%>/admin/users?page=<%=i%>"
							class="btn btn-info <%=active%>" type="button"><%=i%></a>
						<%
							}
						%>
						<%
							if (current_Page < sumPage && sumPage > 1) {
									next = current_Page + 1;
						%>
						<a href="<%=request.getContextPath()%>/admin/users?page=<%=next%>"
							class="btn btn-danger" type="button"><i
							class="fa fa-long-arrow-right"></i></a>
						<%
							}
						%>
					</div>
					<%
						}
					%>
				</div>
				<script type="text/javascript">
  function changeActive(id, active){
    $.ajax({
      url: "<%=request.getContextPath()%>/admin/users",
      type: 'POST',
      cache: false,
      data: {
        uactive : active,
        uid: id
      },

      success: function(data){
        $(".change"+'-'+id).html(data); 
      },
      error: function (){
        alert('Có lỗi');
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
