<%@page import="model.Bean.Comment"%>
<%@page import="model.Bean.News"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/templates/public/inc/header.jsp"%>

<!-- Feature Category Section & sidebar -->
<section id="feature_category_section"
	class="feature_category_section single-page section_wrapper">
	<div class="container">
		<div class="row">
			<div class="col-md-9">
				<div class="single_content_layout">
					<%
						News itemDetail = (News) request.getAttribute("itemDetail");
						if (itemDetail != null) {
					%>
					<div class="item feature_news_item">
						<div class="item_img">
							<img class="img-responsive"
								src="<%=request.getContextPath()%>/files/<%=itemDetail.getPicture()%>"
								alt="Chania">
						</div>
						<!--item_img-->
						<div class="item_wrapper">
							<div class="news_item_title">
								<h2>
									<a href="#"><%=itemDetail.getName()%></a>
								</h2>
							</div>
							<!--news_item_title-->
							<div class="item_meta">
								<a href="#"><%=itemDetail.getDate_create()%></a> by:<a href="#"><%=itemDetail.getUser().getFullname()%></a>
							</div>

							<span class="rating"> <i class="fa fa-star"></i> <i
								class="fa fa-star"></i> <i class="fa fa-star"></i> <i
								class="fa fa-star"></i> <i class="fa fa-star-half-full"></i>
							</span>

							<div class="single_social_icon">
								<a class="icons-sm fb-ic" href="#"><i class="fa fa-facebook"></i><span>Facebook</span></a>
								<!--Twitter-->
								<a class="icons-sm tw-ic" href="#"><i class="fa fa-twitter"></i><span>Twitter</span></a>
								<!--Google +-->
								<a class="icons-sm gplus-ic" href="#"><i
									class="fa fa-google-plus"></i><span>Google Plus</span></a>
								<!--Linkedin-->
								<a class="icons-sm li-ic" href="#"><i class="fa fa-linkedin"></i><span>Linkedin</span></a>

							</div>
							<!--social_icon1-->

							<div class="item_content">
								<%=itemDetail.getDetail()%>
							</div>
							<!--item_content-->
							<div class="category_list">
								<a href="#">Messi</a> <a href="#">Leonel</a> <a href="#">Bercelona</a>
								<a href="#">Argentina</a> <a href="#">Football</a>
							</div>
							<!--category_list-->
						</div>
						<!--item_wrapper-->
					</div>
					<%
						}
					%>
					<!--feature_news_item-->

					<div class="single_related_news">
						<div class="single_media_title">
							<h2>Related News</h2>
						</div>
						<div class="media_wrapper">
							<%
								ArrayList<News> itemRelatedNews = (ArrayList<News>) request.getAttribute("itemRelatedNews");
								if (itemRelatedNews != null && itemRelatedNews.size() > 0) {
									for (News RelatedNews : itemRelatedNews) {
							%>
							<div class="media">
								<div class="media-left">
									<a href="#"><img class="media-object" width="80px"
										height="80px"
										src="<%=request.getContextPath()%>/files/<%=RelatedNews.getPicture()%>"
										alt="Generic placeholder image"></a>
								</div>
								<!--media-left-->
								<div class="media-body">
									<h4 class="media-heading">
										<a
											href="<%=request.getContextPath()%>/detail?did=<%=RelatedNews.getId()%>"><%=RelatedNews.getName()%>
										</a>
									</h4>
									<div class="media_meta">
										<a href="#"><%=RelatedNews.getDate_create()%></a> by:<a
											href="#"><%=RelatedNews.getUser().getFullname()%></a>
									</div>
									<div class="media_content">
										<p><%=RelatedNews.getPreview()%></p>
									</div>
									<!--media_content-->
								</div>
								<!--media-body-->
							</div>
							<%
								}
								}
							%>
							<!--media-->

							<!--media-->

							<!--media-->
						</div>
						<!--media_wrapper-->
					</div>
					<!--single_related_news-->


					<div class="ad">
						<img class="img-responsive"
							src="<%=request.getContextPath()%>/templates/public/img/img-single-ad.jpg"
							alt="Chania">
					</div>

					<div class="readers_comment">
						<div class="single_media_title">
							<h2>Related Comments</h2>
						</div>
						<div class="ajax-data">
						<%
							ArrayList<Comment> itemComment = (ArrayList<Comment>) request.getAttribute("itemComments");
							if (itemComment != null && itemComment.size() > 0) {
								for (Comment item : itemComment) {
						%>
						<div class="media">
							<div class="media-left">
								<a href="#"> <img alt="64x64" class="media-object"
									data-src="<%=request.getContextPath()%>/templates/public/img/img-author1.jpg"
									src="<%=request.getContextPath()%>/templates/public/img/img-author1.jpg"
									data-holder-rendered="true">
								</a>
							</div>
							<div class="media-body">
								<h2 class="media-heading"><%=item.getEmail()%></h2>
								<%=item.getContent()%>


								<div class="comment_article_social">
									<a href="#"><i class="fa fa-thumbs-o-up" aria-hidden="true"></i></a>
									<a href="#"><i class="fa fa-thumbs-o-down"
										aria-hidden="true"></i></a> <a href="#"><span class="reply_ic">Reply
									</span></a>
								</div>
							</div>
						</div>
						<%
							}
							}
						%>
						</div>
						<div class="media">
							<div class="media-left">
								<a href="#"> <img alt="64x64" class="media-object"
									data-src="<%=request.getContextPath()%>/templates/public/img/img-author1.jpg"
									src="<%=request.getContextPath()%>/templates/public/img/img-author1.jpg"
									data-holder-rendered="true">
								</a>
							</div>
							<div class="media-body">
								<h2 class="media-heading">S. Joshep</h2>
								But who has any right to find fault with a man who chooses to
								enjoy a pleasure that has no annoying consequences, or one who
								avoids a pain that produces no resultant pleasure?

								<div class="comment_article_social">
									<a href="#"><i class="fa fa-thumbs-o-up" aria-hidden="true"></i></a>
									<a href="#"><i class="fa fa-thumbs-o-down"
										aria-hidden="true"></i></a> <a href="#"><span class="reply_ic">
											Reply </span></a>
								</div>
							</div>
						</div>
					</div>
					<!--readers_comment-->

					<div class="add_a_comment">
						<div class="single_media_title">
							<h2>Add a Comment</h2>
						</div>
						<div class="comment_form">
							<form class="form_cmt">
								<div class="form-group">
									<input type="text" class="form-control" value=""
										id="inputEmail" placeholder="Email">
								</div>
								<div class="form-group comment">
									<textarea class="form-control" id="inputComment"
										placeholder="Comment"></textarea>
								</div>

								<button type="submit" class="btn btn-submit red">
									<a href="javascript:void(0)" onclick="return doComment()">bình
										luận</a>
								</button>
							</form>
						</div>
						<!--comment_form-->
					</div>
					<!--add_a_comment-->
					<script type="text/javascript">
					
					function doComment() {
						var email_comment = $("#inputEmail").val();
						var content_comment = $("#inputComment").val();
						var news_id =<%=itemDetail.getId()%>;
						
						$.ajax({
							url:"<%=request.getContextPath()%>/comment",
								type : "POST",
								cache : false,
								data : {
									email : email_comment,
									content : content_comment,
									deid : news_id,
								},
								success : function(data) {
									// Xử lý thành công
									$('.ajax-data').html(data);
								},
								error : function() {
									// Xử lý nếu có lỗi
									alert('erro');
								}
							});
						}
					</script>
				</div>
				<!--single_content_layout-->
			</div>

			<%@include file="/templates/public/inc/rightbar.jsp"%>
		</div>
</section>
<!--feature_category_section-->

<!-- Footer Section -->
<%@include file="/templates/public/inc/footer.jsp"%>


</body>
</html>