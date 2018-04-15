<%@page import="model.Bean.News"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/templates/public/inc/header.jsp"%>

<!-- Feature Category Section & sidebar -->
<section id="feature_category_section"
	class="feature_category_section category_page section_wrapper">
	<div class="container">
		<div class="row">
			<div class="col-md-9">
				<div class="row">
					<div class="col-md-12">
						<div class="feature_news_item category_item">
							<%
								News itemOneNewsByCat = (News) request.getAttribute("itemOneNewsMain");
							%>
							<div class="item">
								<div class="item_wrapper">
									<div class="item_img">
										<img class="img-responsive"
											src="<%=request.getContextPath()%>/files/<%=itemOneNewsByCat.getPicture()%>"
											alt="Chania">
									</div>
									<!--item_img-->
									<div class="item_title_date">
										<div class="news_item_title">
											<h1>
												<a href="<%=request.getContextPath()%>/detail?did=<%=itemOneNewsByCat.getId()%>"><%=itemOneNewsByCat.getName()%></a>
											</h1>
										</div>
										<!--news_item_title-->
										<div class="item_meta">
											<a href="#"><%=itemOneNewsByCat.getDate_create()%></a> by:<a
												href="#"><%=itemOneNewsByCat.getUser().getFullname()%></a>
										</div>
									</div>
									<!--item_title_date-->
								</div>
								<!--item_wrapper-->
								<div class="item_content"><%=itemOneNewsByCat.getPreview()%></div>
								<!--item_content-->

							</div>
							<!--item-->
						</div>
						<!--feature_news_item-->
					</div>
					<!--col-md-6-->
				</div>
				<div class="row">
					<%
						ArrayList<News> itemNewsByCat = (ArrayList<News>) request.getAttribute("itemNewsByIdCat");
						if (itemNewsByCat != null && itemNewsByCat.size() > 0) {
							for (News getItemNewsByCat : itemNewsByCat) {
					%>
					<div class="col-md-6">
						<div class="feature_news_item">
							<div class="item">
								<div class="item_wrapper">
									<div class="item_img">
										<img class="img-responsive"
											src="<%=request.getContextPath()%>/files/<%=getItemNewsByCat.getPicture()%>"
											alt="Chania">
									</div>
									<!--item_img-->
									<div class="item_title_date">
										<div class="news_item_title">
											<h2>
												<a href="<%=request.getContextPath()%>/detail?did=<%=getItemNewsByCat.getId()%>"><%=getItemNewsByCat.getName()%></a>
											</h2>
										</div>
										<div class="item_meta">
											<a href="#"><%=getItemNewsByCat.getDate_create()%></a> by:<a
												href="#"><%=getItemNewsByCat.getUser().getFullname()%></a>
										</div>
									</div>
									<!--item_title_date-->
								</div>
								<!--item_wrapper-->
								<div class="item_content"><%=getItemNewsByCat.getPreview()%></div>

							</div>
							<!--item-->
						</div>
						<!--feature_news_item-->
					</div>
					<%
						}
						}
					%>



				</div>
				<!--row-->
			</div>
			<!--col-md-9-->

			<%@include file="/templates/public/inc/rightbar.jsp"%>
		</div>
</section>
<!--feature_category_section-->

<!-- Footer Section -->
<%@include file="/templates/public/inc/footer.jsp"%>

</body>
</html>