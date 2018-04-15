<%@page import="model.Bean.Rank"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/templates/admin/inc/edit/leftbar.jsp"%>

<!-- top navigation -->
<%@include file="/templates/admin/inc/edit/header.jsp"%>
<!-- /top navigation -->
<%
	String msg = request.getParameter("msg");
	if ("-8".equals(msg)) {
		out.print("<div id='msg' style='display:none'>Mật khẩu Không trùng nhau</div>");
	}
	if ("-9".equals(msg)) {
		out.print("<div id='msg' style='display:none'>Đã user đã tồn tại</div>");
	}
	if ("-3".equals(msg)) {
		out.print("<div id='msg' style='display:none'>Thêm User không thành công</div>");
	}
%>
<!-- page content -->
<div class="right_col" role="main">
	<div class="">

		<div class="row">

			<div class="col-md-6 col-xs-12">
				<div class="x_panel">
					<div class="x_title">
						<h2>Thêm User</h2>

						<div class="clearfix"></div>
					</div>
					<div class="x_content">
						<br />
						<form class="form-horizontal form-label-left" method="post">
							<div class="form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12">Tên
									Đăng Nhập</label>
								<div class="col-md-9 col-sm-9 col-xs-12">
									<input type="text" name="username" class="form-control"
										placeholder="Default Input">
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12">Nhập
									tên đầy đủ</label>
								<div class="col-md-9 col-sm-9 col-xs-12">
									<input type="text" name="fullname" class="form-control"
										placeholder="Default Input">
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12">Nhập
									Password</label>
								<div class="col-md-9 col-sm-9 col-xs-12">
									<input type="password" name="password" class="form-control"
										placeholder="Default Input">
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12">Nhập
									lại Password</label>
								<div class="col-md-9 col-sm-9 col-xs-12">
									<input type="password" name="repassword" class="form-control"
										placeholder="Default Input">
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12">Cấp
									bậc</label>
								<div class="col-md-9 col-sm-9 col-xs-12">
									<select name="id_rank" class="form-control">
										<%
											ArrayList<Rank> itemRanks = (ArrayList<Rank>) request.getAttribute("itemsRank");
											if (itemRanks != null && itemRanks.size() > 0) {
												for (Rank itemRank : itemRanks) {
										%>
										<option value="<%=itemRank.getId()%>"><%=itemRank.getName()%></option>
										<%
											}
											}
										%>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12">Nhập
									Email</label>
								<div class="col-md-9 col-sm-9 col-xs-12">
									<input type="text" name="email" class="form-control"
										placeholder="Default Input">
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
