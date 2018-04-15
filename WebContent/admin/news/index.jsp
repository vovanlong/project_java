<%@page import="java.text.SimpleDateFormat"%>
<%@page import="model.Bean.News"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/templates/admin/inc/index/leftbar.jsp"%>

<!-- top navigation -->
<%@include file="/templates/admin/inc/index/header.jsp"%>
<!-- /top navigation -->
<%
	String msg = request.getParameter("msg");
	if ("3".equals(msg)) {
		out.print("<div id='msg' style='display:none'>Thêm tin thành công</div>");
	}
	if ("2".equals(msg)) {
		out.print("<div id='msg' style='display:none'>Sửa tin thành công</div>");
	}
	if ("1".equals(msg)) {
		out.print("<div id='msg' style='display:none'>Xóa tin thành công</div>");
	}
	if ("-1".equals(msg)) {
		out.print("<div id='msgerr' style='display:none'>Xóa tin Thất bại</div>");
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
						action="<%=request.getContextPath()%>/admin/news" method="get">
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
				<h4>Tin tức</h4>
				<a class="btn btn-app" href="<%=request.getContextPath()%>/admin/news/add"> <i class="glyphicon glyphicon-plus"></i>
					Thêm
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
							<th>Lượt Xem</th>
							<th>Người tạo</th>
							<th>Danh Mục</th>
							<th>Chức Năng</th>
						</tr>
					</thead>


					<tbody>
						<%
							ArrayList<News> itemNews = (ArrayList<News>) request.getAttribute("items");
							if (itemNews != null && itemNews.size() > 0) {
								for (News item : itemNews) {
						%>
						<tr>
							<td><%=item.getId()%></td>
							<td><%=item.getName()%></td>
							<td>
								<%
									if (!"".equals(item.getPicture())) {
								%> <a> <span class="image"><img
										src="<%=request.getContextPath()%>/files/<%=item.getPicture()%>"
										alt="Profile Image" height=70px width=120px /></span>
							</a> <%
 	} else {
 %> <a> <span class="image"><img
										src="<%=request.getContextPath()%>/templates/admin/build/images/Rhymastic.png"
										alt="Profile Image" height=70px width=120px /></span>
							</a> <%
 	}
 %>
							</td>
							<td><%=item.getDate_create()%></td>
							<td><%=item.getCount_number()%></td>
							<td><%=item.getUser().getFullname()%></td>
							<td><%=item.getCategory().getName()%></td>
							<td><a
								href="<%=request.getContextPath()%>/admin/news/edit?id=<%=item.getId()%>"
								class="btn btn-primary btn-xs"><i
									class="glyphicon glyphicon-edit"></i> Sửa </a> <a
								href="<%=request.getContextPath()%>/admin/news/del?did=<%=item.getId()%>"
								class="btn btn-danger btn-xs"><i class="fa fa-trash-o"></i>
									Delete </a></td>
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
								int current_Page = (Integer) request.getAttribute("curent_Page");
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
						<a href="<%=request.getContextPath()%>/admin/news?page=<%=back%>"
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
						<a href="<%=request.getContextPath()%>/admin/news?page=<%=i%>"
							class="btn btn-info <%=active%>" type="button"><%=i%></a>
						<%
							}
						%>
						<%
							if (current_Page < sumPage && sumPage > 1) {
									next = current_Page + 1;
						%>
						<a href="<%=request.getContextPath()%>/admin/news?page=<%=next%>"
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
			</div>
		</div>
	</div>


</div>
<!-- /page content -->

<!-- footer content -->
<%@include file="/templates/admin/inc/index/footer.jsp"%>

</body>
</html>
