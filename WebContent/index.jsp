<%@page import="model.Dao.IndexPublicDao"%>
<%@page import="model.Bean.News"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/templates/public/inc/header.jsp"%>

<!-- Feature Carousel Section -->
<section id="feature_news_section"
	class="feature_news_section section_wrapper">
	<div class="container">
		<div class="row">
			<div class="col-md-6">
				<div class="feature_news_carousel">
					<div id="featured-news-carousal" class="carousel slide"
						data-ride="carousel">
						<!-- Wrapper for slides -->
						<div class="carousel-inner" role="listbox">
							<%
								News getItemSlideMain = (News) request.getAttribute("itemSlideMain");
								String image1 = "";
								if(getItemSlideMain.getPicture() !=null ){
									image1 = getItemSlideMain.getPicture();
								}else{
									image1 = "";
								}
							%>
							<div class="item active feature_news_item">
								<div class="item_wrapper">
									<div class="item_img">
										<img class="img-responsive"
											src="<%=request.getContextPath()%>/files/<%=image1%>"
											alt="Chania">
									</div>
									<!--item_img-->
									<div class="item_title_date">
										<div class="news_item_title">
											<h2>
												<a
													href="<%=request.getContextPath()%>/detail?did=<%=getItemSlideMain.getId()%>"><%=getItemSlideMain.getName()%></a>
											</h2>
										</div>
										<div class="item_meta">
											<a href="#"><%=getItemSlideMain.getDate_create()%></a> by:<a
												href="#"><%=getItemSlideMain.getUser().getFullname()%></a>
										</div>
									</div>
									<!--item_title_date-->
								</div>
								<!--item_wrapper-->
								<div class="item_content"><%=getItemSlideMain.getPreview()%></div>

							</div>
							<!--feature_news_item-->
							<%
								ArrayList<News> itemSlides = (ArrayList<News>) request.getAttribute("itemSlide");
								if (itemSlides != null && itemSlides.size() > 0) {
									for (News itemSlide : itemSlides) {
										String image = "";
										if(itemSlide.getPicture() != null){
											image = itemSlide.getPicture();
										}else{
											image = "";
										}
							%>
							<div class="item feature_news_item">
								<div class="item_wrapper">
									<div class="item_img">
										<img class="img-responsive"
											src="<%=request.getContextPath()%>/files/<%=image%>"
											alt="Chania">
									</div>
									<!--item_img-->
									<div class="item_title_date">
										<div class="news_item_title">
											<h2>
												<a
													href="<%=request.getContextPath()%>/detail?did=<%=itemSlide.getId()%>"><%=itemSlide.getName()%></a>
											</h2>
										</div>
										<div class="item_meta">
											<a href="#"><%=itemSlide.getDate_create()%></a> by: <a
												href="#"><%=itemSlide.getUser().getFullname()%></a>
										</div>
									</div>
									<!--item_title_date-->
								</div>
								<!--item_wrapper-->

								<div class="item_content"><%=itemSlide.getPreview()%></div>

							</div>
							<%
								}
								}
							%>
							<!--feature_news_item-->


							<!-- Left and right controls -->
							<div class="control-wrapper">
								<a class="left carousel-control" href="#featured-news-carousal"
									role="button" data-slide="prev"> <i
									class="fa fa-chevron-left" style="padding-top: 9px"
									aria-hidden="true"></i>
								</a> <a class="right carousel-control"
									href="#featured-news-carousal" role="button" data-slide="next">
									<i class="fa fa-chevron-right" style="padding-top: 9px"
									aria-hidden="true"></i>
								</a>
							</div>
						</div>
						<!--carousel-inner-->
					</div>
					<!--carousel-->
				</div>
				<!--feature_news_carousel-->
			</div>
			<!--col-md-6-->

			<div class="col-md-6">
				<div class="feature_news_static">
					<div class="row">
						<%
							ArrayList<News> itemTwoNews = (ArrayList<News>) request.getAttribute("itemTwoNews");
							if (itemTwoNews != null && itemTwoNews.size() > 0) {
								for (News getItemTwoNews : itemTwoNews) {
						%>
						<div class="col-md-6">
							<div class="feature_news_item">
								<div class="item active">
									<div class="item_wrapper">
										<div class="item_img">
											<img class="img-responsive"
												style="width: 383px; height: 400px;"
												src="<%=request.getContextPath()%>/files/<%=getItemTwoNews.getPicture()%>"
												alt="Chania">
										</div>
										<!--item_img-->
										<div class="item_title_date">
											<div class="news_item_title">
												<h2>
													<a
														href="<%=request.getContextPath()%>/detail?did=<%=getItemTwoNews.getId()%>"><%=getItemTwoNews.getName()%></a>
												</h2>
											</div>
											<div class="item_meta">
												<a href="#"><%=getItemTwoNews.getDate_create()%></a> by:<a
													href="#"><%=getItemTwoNews.getUser().getFullname()%></a>
											</div>
										</div>
										<!--item_title_date-->
									</div>
									<!--item_wrapper-->
									<div class="item_content"><%=getItemTwoNews.getPreview()%></div>

								</div>
								<!--item-->
							</div>
							<!--feature_news_item-->
						</div>
						<%
							}
							}
						%>


						<!--col-xs-6-->
					</div>
					<!--row-->
				</div>
				<!--feature_news_static-->
			</div>
			<!--col-md-6-->
		</div>
		<!--row-->
	</div>
	<!--container-->
</section>
<!--feature_news_section-->

<!-- Feature Category Section & sidebar -->
<section id="feature_category_section"
	class="feature_category_section section_wrapper">
	<div class="container">
		<div class="row">
			<div class="col-md-9">
				<%
					ArrayList<Category> itemNewsByCat = (ArrayList<Category>) request.getAttribute("itemOneNewsMain");
					if (itemNewsByCat != null && itemNewsByCat.size() > 0) {
						for (Category getItemNewsByCat : itemNewsByCat) {
							News itemOneNewsMain = getItemNewsByCat.getMainNew();
							ArrayList<News> itemFourNews = getItemNewsByCat.getSubNews();
				%>
				<div class="category_layout">
					<div class="item_caregory red">
						<h2>
							<a href="category.html"><%=getItemNewsByCat.getName()%></a>
						</h2>
					</div>
					<div class="row">
						<div class="col-md-7">
							<div class="item feature_news_item">
								<div class="item_wrapper">
									<div class="item_img">
										<img class="img-responsive"
											src="<%=request.getContextPath()%>/files/<%=itemOneNewsMain.getPicture()%>"
											alt="Chania">
									</div>
									<!--item_img-->
									<div class="item_title_date">
										<div class="news_item_title">
											<h2>
												<a
													href="<%=request.getContextPath()%>/detail?did=<%=itemOneNewsMain.getId()%>"><%=itemOneNewsMain.getName()%></a>
											</h2>
										</div>
										<!--news_item_title-->
										<div class="item_meta">
											<a href="#"><%=itemOneNewsMain.getDate_create()%></a> by:<a
												href="#"><%=itemOneNewsMain.getUser().getFullname()%></a>
										</div>
									</div>
									<!--item_title_date-->
								</div>
								<!--item_wrapper-->
								<div class="item_content"><%=itemOneNewsMain.getPreview()%></div>
								<!--item_content-->

							</div>
							<!--feature_news_item-->
						</div>
						<!--col-md-7-->

						<div class="col-md-5">
							<div class="media_wrapper">
								<%
									for (News getFourNewsItem : itemFourNews) {
								%>
								<div class="media">
									<div class="media-left">
										<a href="#"><img class="media-object"
											style="width: 50px; height: 50px;"
											src="<%=request.getContextPath()%>/files/<%=getFourNewsItem.getPicture()%>"
											alt="Generic placeholder image"></a>
									</div>
									<!--media-left-->
									<div class="media-body">
										<h3 class="media-heading">
											<a
												href="<%=request.getContextPath()%>/detail?did=<%=getFourNewsItem.getId()%>"><%=getFourNewsItem.getName()%>
											</a>
										</h3>

										<p><%=getFourNewsItem.getPreview()%></p>

									</div>
									<!--media-body-->
								</div>
								<%
									}
								%>
							</div>
							<!--media_wrapper-->

						</div>
						<!--col-md-5-->
					</div>
					<!--row-->
				</div>
				<!--category_layout-->
				<%
					}
					}
				%>
				<!--category_layout-->

				<!--category_layout-->


				<!--more_news_item-->
			</div>
			<!--col-md-9-->

			<%@include file="/templates/public/inc/rightbar.jsp"%>
		</div>
</section>
<!--feature_category_section-->

<!-- Feature Video Item -->
<section id="feature_video_item"
	class="feature_video_item section_wrapper">
	<div class="container">
		<div class="row">
			<div class="col-xs-12">
				<div class="feature_video_wrapper">
					<div class="feature_video_title">
						<h2>Featured Videos</h2>
					</div>

					<div id="feature_video_slider" class="owl-carousel">
						<%
							ArrayList<News> itemMostNews = (ArrayList<News>) request.getAttribute("itemMostNews");
							if (itemMostNews != null && itemMostNews.size() > 0) {
								for (News getItemMostNews : itemMostNews) {
						%>
						<div class="item">
							<div class="video_thumb">
								<img
									src="<%=request.getContextPath()%>/files/<%=getItemMostNews.getPicture()%>"
									alt="Owl Image">
							</div>
							<div class="video_info">
								<div class="video_item_title">
									<h3>
										<a
											href="<%=request.getContextPath()%>/detail?did=<%=getItemMostNews.getId()%>"><%=getItemMostNews.getName()%></a>
									</h3>
								</div>
								<!--video_item_title-->
								<div class="item_meta">
									<a href="#"><%=getItemMostNews.getDate_create()%></a>
								</div>
								<!--item_meta-->
							</div>
							<!--video_info-->
						</div>
						<%
							}
							}
						%>
						<div class="item">
							<div class="video_thumb">
								<img
									src="<%=request.getContextPath()%>/templates/public/img/video.jpg"
									alt="Owl Image">
							</div>
							<div class="video_info">
								<div class="video_item_title">
									<h3>
										<a href="#">Track & Fiels famous still in the craze of
											Runner world</a>
									</h3>
								</div>
								<!--video_item_title-->
								<div class="item_meta">
									<a href="#">20Aug- 2015</a>
								</div>
								<!--item_meta-->
							</div>
							<!--video_info-->
						</div>
						<div class="item">
							<div class="video_thumb">
								<img
									src="<%=request.getContextPath()%>/templates/public/img/video2.jpg"
									alt="Owl Image">
							</div>
							<div class="video_info">
								<div class="video_item_title">
									<h3>
										<a href="#">Track & Fiels famous still in the craze of
											Runner world</a>
									</h3>
								</div>
								<!--video_item_title-->
								<div class="item_meta">
									<a href="#">20Aug- 2015</a>
								</div>
								<!--item_meta-->
							</div>
							<!--video_info-->
						</div>
						<div class="item">
							<div class="video_thumb">
								<img
									src="<%=request.getContextPath()%>/templates/public/img/video3.jpg"
									alt="Owl Image">
							</div>
							<div class="video_info">
								<div class="video_item_title">
									<h3>
										<a href="#">Track & Fiels famous still in the craze of
											Runner world</a>
									</h3>
								</div>
								<!--video_item_title-->
								<div class="item_meta">
									<a href="#">20Aug- 2015</a>
								</div>
								<!--item_meta-->
							</div>
							<!--video_info-->
						</div>
						<div class="item">
							<div class="video_thumb">
								<img
									src="<%=request.getContextPath()%>/templates/public/img/video2.jpg"
									alt="Owl Image">
							</div>
							<div class="video_info">
								<div class="video_item_title">
									<h3>
										<a href="#">Track & Fiels famous still in the craze of
											Runner world</a>
									</h3>
								</div>
								<!--video_item_title-->
								<div class="item_meta">
									<a href="#">20Aug- 2015</a>
								</div>
								<!--item_meta-->
							</div>
							<!--video_info-->
						</div>
						<div class="item">
							<div class="video_thumb">
								<img
									src="<%=request.getContextPath()%>/templates/public/img/video.jpg"
									alt="Owl Image">
							</div>
							<div class="video_info">
								<div class="video_item_title">
									<h3>
										<a href="#">Track & Fiels famous still in the craze of
											Runner world</a>
									</h3>
								</div>
								<!--video_item_title-->
								<div class="item_meta">
									<a href="#">20Aug- 2015</a>
								</div>
								<!--item_meta-->
							</div>
							<!--video_info-->
						</div>
						<div class="item">
							<div class="video_thumb">
								<img
									src="<%=request.getContextPath()%>/templates/public/img/video3.jpg"
									alt="Owl Image">
							</div>
							<div class="video_info">
								<div class="video_item_title">
									<h3>
										<a href="#">Track & Fiels famous still in the craze of
											Runner world</a>
									</h3>
								</div>
								<!--video_item_title-->
								<div class="item_meta">
									<a href="#">20Aug- 2015</a>
								</div>
								<!--item_meta-->
							</div>
							<!--video_info-->
						</div>
					</div>
					<!--feature_video_slider-->


				</div>
				<!--col-xs-12-->
			</div>
			<!--row-->
		</div>
		<!--feature_video_wrapper-->
	</div>
	<!--container-->
</section>

<!-- Footer Section -->
<%@include file="/templates/public/inc/footer.jsp"%>

</body>
</html>