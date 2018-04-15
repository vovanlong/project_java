<%@page import="model.Dao.CategoryDao"%>
<%@page import="com.sun.scenario.effect.Flood"%>
<%@page import="model.Bean.Category"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/templates/admin/inc/index/leftbar.jsp"%>

<!-- top navigation -->
<%@include file="/templates/admin/inc/index/header.jsp"%>
<!-- /top navigation -->
<%
	CategoryDao categoryDao = new CategoryDao();
	ArrayList<Category> ItemCats = (ArrayList<Category>) categoryDao.getItem();
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
						action="<%=request.getContextPath()%>/admin/cats" method="get">
						<div class="form-group">
							<input type="text" name="search" class="form-control"
								placeholder="Search for...">
						</div>
						<button class="btn btn-default" type="submit">Go!</button>
					</form>

				</div>
			</div>
		</div>
		<%-- <script
			src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<script type="text/javascript"
			src="<%=request.getContextPath()%>/templates/admin/build/js/sweetalert.min.js"></script> --%>
		<%
			String msg = request.getParameter("msg");
			if ("3".equals(msg)) {
				out.print("<div id='msg' style='display:none'>Thêm Danh Mục Thành Công</div>");
			}
			if ("2".equals(msg)) {
				out.print("<div id='msg' style='display:none'>Sửa Danh Mục Thành Công</div>");
			}
			if ("1".equals(msg)) {
				out.print("<div id='msg' style='display:none'>Xóa Danh Mục Thành Công</div>");
			}
			if ("-1".equals(msg)) {
				out.print("<div id='msgerr' style='display:none'>Xóa Danh Mục Thất Bại</div>");
			}
		%>
		<div class="x_panel">
			<!-- Chừ sao, anh coi thử dòng e làm ri đúng k thường thì nó ra cái succes mà hắn k hiện ra -->
			<div class="x_content">
				<h4>Danh mục</h4>
				<a href="<%=request.getContextPath()%>/admin/cat/add"
					class="btn btn-app"> <i class="glyphicon glyphicon-plus"></i>
					Thêm
				</a>
			</div>
			<div class="x_content">

				<table id="datatable-buttons"
					class="table table-striped table-bordered">
					<thead>
						<tr>
							<th>ID Danh Mục</th>
							<th>Tên Danh Mục</th>
							<th>Chức Năng</th>
						</tr>
					</thead>


					<tbody>
						<%
							ArrayList<Category> items = (ArrayList<Category>) request.getAttribute("categories");
							if (items != null && items.size() > 0) {
								String getCatParent = "";
								for (Category item : items) {
									if (item.getId_Parent() == 0) {
						%>
						<tr>
							<td><%=item.getId()%></td>
							<td><%=item.getName()%></td>
							<td>
								<%
									if ("admin".equals(userGet1.getRank().getName())
														|| "manager".equals(userGet1.getRank().getName())) {
								%><a
								href="<%=request.getContextPath()%>/admin/cat/edit?id=<%=item.getId()%>"
								class="btn btn-primary btn-xs"><i
									class="glyphicon glyphicon-edit"></i> Sửa </a> <a
								href="<%=request.getContextPath()%>/admin/cat/del?did=<%=item.getId()%>"
								class="btn btn-danger btn-xs"><i class="fa fa-trash-o"></i>
									Delete </a> <%
 	}
 %>
							</td>
						</tr>
						<%
							} else {
										String nameCat = "";
										for (Category getItem : ItemCats) {
											if (item.getId_Parent() == getItem.getId() && getItem.getId_Parent() == 0) {
												nameCat = getItem.getName();
											}
										}
						%>
						<tr>
							<td><%=item.getId()%></td>
							<td><i class="fa fa-angle-double-right"></i><i
								class="fa fa-angle-double-rdight"></i><i
								class="fa fa-angle-double-right"></i><%=item.getName()%>,Trong danh mục: <%=nameCat %></td>
							<td>
								<%
									if ("admin".equals(userGet1.getRank().getName())
														|| "manager".equals(userGet1.getRank().getName())) {
								%> <a
								href="<%=request.getContextPath()%>/admin/cat/edit?id=<%=item.getId()%>"
								class="btn btn-primary btn-xs"><i
									class="glyphicon glyphicon-edit"></i> Sửa </a> <a
								href="<%=request.getContextPath()%>/admin/cat/del?did=<%=item.getId()%>"
								class="btn btn-danger btn-xs"><i class="fa fa-trash-o"></i>
									Delete </a> <%
 	}
 %>
							</td>
						</tr>
						<%
							}

								}
							}
						%>
					</tbody>
				</table>
				<div class="row">
					<div class="btn-toolbar">
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
							<a href="<%=request.getContextPath()%>/admin/cats?page=<%=back%>"
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
							<a href="<%=request.getContextPath()%>/admin/cats?page=<%=i%>"
								class="btn btn-info <%=active%>" type="button"><%=i%></a>
							<%
								}
							%>
							<%
								if (current_Page < sumPage && sumPage > 1) {
									next = current_Page + 1;
							%>
							<a href="<%=request.getContextPath()%>/admin/cats?page=<%=next%>"
								class="btn btn-danger" type="button"><i
								class="fa fa-long-arrow-right"></i></a>
							<%
								}
							%>
						</div>
					</div>
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
