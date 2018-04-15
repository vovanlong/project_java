<%@page import="model.Dao.IndexPublicDao"%>
<%@page import="model.Bean.Advertisement"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="col-md-3">

	<div class="tab sitebar">
		<ul class="nav nav-tabs">
			<li class="active"><a href="#1" data-toggle="tab">Latest</a></li>
			<li><a href="#2" data-toggle="tab">Populer</a></li>
		</ul>

		<div class="tab-content">
			<div class="tab-pane active" id="1">
				<div class="media">
					<div class="media-left">
						<a href="#"><img class="media-object"
							src="<%=request.getContextPath()%>/templates/public/img/img-list.jpg"
							alt="Generic placeholder image"></a>
					</div>
					<!--media-left-->
					<div class="media-body">
						<h4 class="media-heading">
							<a href="#">Spain going to made class football</a>
						</h4>
						<span class="rating"> <i class="fa fa-star"></i> <i
							class="fa fa-star"></i> <i class="fa fa-star"></i> <i
							class="fa fa-star"></i> <i class="fa fa-star-half-full"></i>
						</span>
					</div>
					<!--media-body-->
				</div>
				<!--media-->

				<div class="media">
					<div class="media-left">
						<a href="#"><img class="media-object"
							src="<%=request.getContextPath()%>/templates/public/img/img-list5.jpg"
							alt="Generic placeholder image"></a>
					</div>
					<!--media-left-->
					<div class="media-body">
						<h4 class="media-heading">
							<a href="#">Spain going to made class football</a>
						</h4>
						<span class="rating"> <i class="fa fa-star"></i> <i
							class="fa fa-star"></i> <i class="fa fa-star"></i> <i
							class="fa fa-star"></i> <i class="fa fa-star-half-full"></i>
						</span>
					</div>
					<!--media-body-->
				</div>
				<!--media-->

				<div class="media">
					<div class="media-left">
						<a href="#"><img class="media-object"
							src="<%=request.getContextPath()%>/templates/public/img/img-list2.jpg"
							alt="Generic placeholder image"></a>
					</div>
					<!--media-left-->
					<div class="media-body">
						<h3 class="media-heading">
							<a href="#">Spain going to made class football</a>
						</h3>
						<span class="rating"> <i class="fa fa-star"></i> <i
							class="fa fa-star"></i> <i class="fa fa-star"></i> <i
							class="fa fa-star"></i> <i class="fa fa-star-half-full"></i>
						</span>
					</div>
					<!--media-body-->
				</div>
				<!--media-->

				<div class="media">
					<div class="media-left">
						<a href="#"><img class="media-object"
							src="<%=request.getContextPath()%>/templates/public/img/img-list3.jpg"
							alt="Generic placeholder image"></a>
					</div>
					<!--media-left-->
					<div class="media-body">
						<h3 class="media-heading">
							<a href="#">Spain going to made class football</a>
						</h3>
						<span class="rating"> <i class="fa fa-star"></i> <i
							class="fa fa-star"></i> <i class="fa fa-star"></i> <i
							class="fa fa-star"></i> <i class="fa fa-star-half-full"></i>
						</span>
					</div>
					<!--media-body-->
				</div>
				<!--media-->
			</div>
			<!--tab-pane-->

			<div class="tab-pane" id="2">
				<div class="media">
					<div class="media-left">
						<a href="#"><img class="media-object"
							src="<%=request.getContextPath()%>/templates/public/img/img-list4.jpg"
							alt="Generic placeholder image"></a>
					</div>
					<!--media-left-->
					<div class="media-body">
						<h3 class="media-heading">
							<a href="#">Spain going to made class football</a>
						</h3>
						<span class="rating"> <i class="fa fa-star"></i> <i
							class="fa fa-star"></i> <i class="fa fa-star"></i> <i
							class="fa fa-star"></i> <i class="fa fa-star-half-full"></i>
						</span>
					</div>
					<!--media-body-->
				</div>
				<!--media-->

				<div class="media">
					<div class="media-left">
						<a href="#"><img class="media-object"
							src="<%=request.getContextPath()%>/templates/public/img/img-list.jpg"
							alt="Generic placeholder image"></a>
					</div>
					<!--media-left-->
					<div class="media-body">
						<h3 class="media-heading">
							<a href="#">Spain going to made class football</a>
						</h3>
						<span class="rating"> <i class="fa fa-star"></i> <i
							class="fa fa-star"></i> <i class="fa fa-star"></i> <i
							class="fa fa-star"></i> <i class="fa fa-star-half-full"></i>
						</span>
					</div>
					<!--media-body-->
				</div>
				<!--media-->
			</div>
			<!--tab-pane-->
		</div>
		<!--tab-content-->
	</div>
	<!--tab-->

	<div class="ad">
		<%
			IndexPublicDao indexPublicDaoAdv = new IndexPublicDao();
			ArrayList<Advertisement> itemFourAdv = indexPublicDaoAdv.getItemFourAdv();
			for (Advertisement getItemFourAdv : itemFourAdv) {
		%>
		<a href="<%=getItemFourAdv.getLink()%>"><img
			class="img-responsive" style="width: 125px; height: 125px"
			src="<%=request.getContextPath()%>/files/<%=getItemFourAdv.getPicture()%>"
			alt="img" /></a>
		<%
			}
		%>
	</div>
	<!--ad-->

	<div class="ad">
		<img class="img-responsive"
			src="<%=request.getContextPath()%>/templates/public/img/img-ad.jpg"
			alt="img" />
	</div>

	<div class="ad">
		<img class="img-responsive"
			src="<%=request.getContextPath()%>/templates/public/img/img-ad2.jpg"
			alt="img" />
	</div>

	<div class="most_comment">
		<div class="sidebar_title">
			<h2>Most Commented</h2>
		</div>
		<div class="media">
			<div class="media-left">
				<a href="#"><img class="media-object"
					src="<%=request.getContextPath()%>/templates/public/img/img-list.jpg"
					alt="Generic placeholder image"></a>
			</div>
			<!--media-left-->
			<div class="media-body">
				<h3 class="media-heading">
					<a href="#">Spain going to made class football</a>
				</h3>
				<div class="comment_box">
					<div class="comments_icon">
						<i class="fa fa-comments" aria-hidden="true"></i>
					</div>
					<div class="comments">
						<a href="#">9 Comments</a>
					</div>
				</div>
				<!--comment_box-->
			</div>
			<!--media-body-->
		</div>
		<!--media-->
		<div class="media">
			<div class="media-left">
				<a href="#"><img class="media-object"
					src="<%=request.getContextPath()%>/templates/public/img/img-list2.jpg"
					alt="Generic placeholder image"></a>
			</div>
			<!--media-left-->
			<div class="media-body">
				<h3 class="media-heading">
					<a href="#">Spain going to made class football</a>
				</h3>
				<div class="comment_box">
					<div class="comments_icon">
						<i class="fa fa-comments" aria-hidden="true"></i>
					</div>
					<div class="comments">
						<a href="#">20 Comments</a>
					</div>
				</div>
				<!--comment_box-->
			</div>
			<!--media-body-->
		</div>
		<!--media-->
		<div class="media">
			<div class="media-left">
				<a href="#"><img class="media-object"
					src="<%=request.getContextPath()%>/templates/public/img/img-list3.jpg"
					alt="Generic placeholder image"></a>
			</div>
			<!--media-left-->
			<div class="media-body">
				<h3 class="media-heading">
					<a href="#">Spain going to made class football</a>
				</h3>
				<div class="comment_box">
					<div class="comments_icon">
						<i class="fa fa-comments" aria-hidden="true"></i>
					</div>
					<div class="comments">
						<a href="#">23 Comments</a>
					</div>
				</div>
				<!--comment_box-->
			</div>
			<!--media-body-->
		</div>
		<!--media-->
		<div class="media">
			<div class="media-left">
				<a href="#"><img class="media-object"
					src="<%=request.getContextPath()%>/templates/public/img/img-list3.jpg"
					alt="Generic placeholder image"></a>
			</div>
			<!--media-left-->
			<div class="media-body">
				<h3 class="media-heading">
					<a href="#">Spain going to made class football</a>
				</h3>
				<div class="comment_box">
					<div class="comments_icon">
						<i class="fa fa-comments" aria-hidden="true"></i>
					</div>
					<div class="comments">
						<a href="#">44 Comments</a>
					</div>
				</div>
				<!--comment_box-->
			</div>
			<!--media-body-->
		</div>
		<!--media-->
	</div>
	<!--most_comment-->
</div>