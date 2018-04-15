
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Sports</title>
    <!-- Goole Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Oswald:400,700|Roboto:400,500" rel="stylesheet"> 

    <!-- Bootstrap -->
    <link href="<%=request.getContextPath()%>/templates/public/css/bootstrap.min.css" rel="stylesheet">

    <!-- Font Awesome -->
    <link href="<%=request.getContextPath()%>/templates/public/fonts/font-awesome/css/font-awesome.min.css" rel="stylesheet">
	
    <!-- Owl carousel -->
    <link href="<%=request.getContextPath()%>/templates/public/css/owl.carousel.css" rel="stylesheet">
	 <link href="<%=request.getContextPath()%>/templates/public/css/owl.theme.default.min.css" rel="stylesheet">

    <!-- Off Canvas Menu -->
    <link href="<%=request.getContextPath()%>/templates/public/css/offcanvas.min.css" rel="stylesheet">

    <!--Theme CSS -->
    <link href="<%=request.getContextPath()%>/templates/public/css/style.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
<body>
<div id="main-wrapper">

    <!-- Header Section -->
	<header>
	    <div class="container">
	     	<div class="top_ber">
				<div class="row">
		    		<div class="col-md-6">
						<div class="top_ber_left">
							20 August. Thursday 2015. 2:00 PM.
						</div><!--top_ber_left-->
		    		</div><!--col-md-6-->
		    		<div class="col-md-6">
		    			<div class="top_ber_right">
		    				<div class="top-menu">
		    					<ul class="nav navbar-nav">    
			                        <li><a href="#">Login</a></li>
			                        <li><a href="#">Register</a></li>
	                    		</ul>
		    				</div><!--top-menu-->
		    			</div><!--top_ber_left-->
		    		</div><!--col-md-6-->
		    	</div><!--row-->
	     	</div><!--top_ber-->
	     	
	     	<div class="header-section">
				<div class="row">
		    	 	<div class="col-md-3">
						<div class="logo">
						<a  href="index.html"><img class="img-responsive" src="<%=request.getContextPath()%>/templates/public/img/logo.png" alt=""></a>
						</div><!--logo-->
		    	 	</div><!--col-md-3-->
		    	 	
		    	 	<div class="col-md-6">
						<div class="header_ad_banner">
						<a  href="#"><img class="img-responsive" src="<%=request.getContextPath()%>/templates/public/img/img_ad.jpg" alt=""></a>
						</div>
		    	 	</div><!--col-md-6-->
		    	 	
		    	 	<div class="col-md-3">
						<div class="social_icon1">
								<a class="icons-sm fb-ic"><i class="fa fa-facebook"></i></a>
								<!--Twitter-->
								<a class="icons-sm tw-ic"><i class="fa fa-twitter"></i></a>
								<!--Google +-->
								<a class="icons-sm gplus-ic"><i class="fa fa-google-plus"> </i></a>
								<!--Linkedin-->
								<a class="icons-sm li-ic"><i class="fa fa-linkedin"> </i></a> 
								<!--Pinterest-->
								<a class="icons-sm pin-ic"><i class="fa fa-pinterest"> </i></a>
						</div> <!--social_icon1-->
		    	 	</div><!--col-md-3-->
		    	</div> <!--row-->	
	     	</div><!--header-section-->    	      
	    </div><!-- /.container -->   

		<nav class="navbar main-menu navbar-inverse navbar-static-top" role="navigation">
			<div class="container">
				<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed pull-left" data-toggle="offcanvas">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				</div>
				<div id="navbar" class="collapse navbar-collapse sidebar-offcanvas">
				<ul class="nav navbar-nav">
					<li class="hidden"><a href="#page-top"></a></li>
					<li><a class="page-scroll" href="category.html">Baseball</a></li>
					<li><a class="page-scroll" href="category.html">Football</a></li>
					<li><a class="page-scroll" href="category.html">Hockey</a></li>
					<li><a class="page-scroll" href="category.html">Basketball</a></li>
					<li><a class="page-scroll" href="category.html">Boxing</a></li>
					<li><a class="page-scroll" href="category.html">Golf</a></li>
					<li><a class="page-scroll" href="category.html">Tennis</a></li>
					<li><a class="page-scroll" href="category.html">Horse racing</a></li>
					<li><a class="page-scroll" href="category.html">Track & Field</a></li>

					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown">More <b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="#">Action</a></li>
							<li><a href="#">Another action</a></li>
							<li><a href="#">Something else here</a></li>
						</ul>
					</li>
				</ul>
				<div class="pull-right">
					<form class="navbar-form" role="search">
						<div class="input-group">
							<input class="form-control" placeholder="Search" name="q" type="text">
							<div class="input-group-btn">
								<button class="btn btn-default" type="submit"><i class="fa fa-search" aria-hidden="true"></i></button>
							</div>
						</div>
					</form>
				</div>
				</div>
			</div>
		</nav> 
		<!-- .navbar -->
	</header>

    <!-- Feature Carousel Section -->
    <section id="feature_news_section" class="feature_news_section section_wrapper">
	<div class="container">   
	    <div class="row">
	    	<div class="col-md-6">
	    		<div class="feature_news_carousel">
					<div id="featured-news-carousal" class="carousel slide" data-ride="carousel">
					    <!-- Wrapper for slides -->
						<div class="carousel-inner" role="listbox">					    
							<div class="item active feature_news_item">
								<div class="item_wrapper">
									<div class="item_img">
										<img class="img-responsive" src="<%=request.getContextPath()%>/templates/public/img/img-carousel1.jpg" alt="Chania">
									</div> <!--item_img-->
									<div class="item_title_date">
										<div class="news_item_title">
											<h2><a href="single.html">Seamlessly embrace B2C catalysts for change vis-a-vis economically sound communities.</a></h2>
										</div>
										<div class="item_meta"><a href="#">20Aug- 2015,</a> by:<a href="#">Jhonson</a></div>
									</div> <!--item_title_date-->
								</div>	<!--item_wrapper-->
							    <div class="item_content">Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque.</div>

							</div><!--feature_news_item-->

							<div class="item feature_news_item">
								<div class="item_wrapper">
									<div class="item_img">
										<img class="img-responsive" src="<%=request.getContextPath()%>/templates/public/img/img-carousel2.jpg" alt="Chania">
									</div> <!--item_img--> 
									<div class="item_title_date">
										<div class="news_item_title">
											<h2><a href="#">Manchester United want to Back Cristiano Ronaldo natus error sit.</a></h2>
										</div>
                                        <div class="item_meta"><a href="#">20Aug- 2015,</a> by:<a href="#">Jhonson</a></div>
									</div> <!--item_title_date-->
								</div> <!--item_wrapper-->	
								
								<div class="item_content">Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque.
								</div>

							</div><!--feature_news_item-->
							 

					  		<!-- Left and right controls -->
							<div class="control-wrapper">
								<a class="left carousel-control" href="#featured-news-carousal" role="button" data-slide="prev">
									<i class="fa fa-chevron-left" aria-hidden="true"></i>
								</a>
								<a class="right carousel-control" href="#featured-news-carousal" role="button" data-slide="next">
									<i class="fa fa-chevron-right" aria-hidden="true"></i>
								</a>
							</div>
						</div><!--carousel-inner-->
	    			</div><!--carousel-->
	    		</div><!--feature_news_carousel-->
	    	</div><!--col-md-6-->
	    	
	    	<div class="col-md-6">
	    		<div class="feature_news_static">
		    		<div class="row">								 
						<div class="col-md-6">
							<div class="feature_news_item">
	                			<div class="item active">
									<div class="item_wrapper">
										<div class="item_img">
											<img class="img-responsive" src="<%=request.getContextPath()%>/templates/public/img/img_feature.jpg" alt="Chania">
										</div> <!--item_img-->
										<div class="item_title_date">
											<div class="news_item_title">
												<h2><a href="single.html">Track Roboto the Real Tracker.</a></h2>
											</div>
                                            <div class="item_meta"><a href="#">20Aug- 2015,</a> by:<a href="#">Jhonson</a></div>
										</div><!--item_title_date-->
									</div> <!--item_wrapper-->
								    <div class="item_content">Sed ut perspiciatis unde omnis iste natus error sit  
								    </div>

								</div><!--item-->               			 
	            			</div><!--feature_news_item-->
						</div>
						
						<div class="col-md-6">
							<div class="feature_news_item">
	                			<div class="item active">
									<div class="item_wrapper">
										<div class="item_img">
											<img class="img-responsive" src="<%=request.getContextPath()%>/templates/public/img/img_feature2.jpg" alt="Chania">
										</div> <!--item_img-->
										<div class="item_title_date">
											<div class="news_item_title">
												<h2><a href="single.html">David villa change his team last year.</a></h2>
											</div>
                                            <div class="item_meta"><a href="#">20Aug- 2015,</a> by:<a href="#">Jhonson</a></div>
                                        </div><!--item_title_date-->
									</div> <!--item_wrapper-->
								    <div class="item_content">Sed ut perspiciatis unde omnis iste natus error sit  
								    </div>

								</div><!--item-->               			 
	            			</div><!--feature_news_item-->
						</div><!--col-xs-6-->
					</div><!--row-->
	    		</div><!--feature_news_static-->
	    	</div><!--col-md-6-->
	    </div><!--row-->
	</div><!--container-->   	
</section><!--feature_news_section-->

    <!-- Feature Category Section & sidebar -->
    <section id="feature_category_section" class="feature_category_section section_wrapper">
	<div class="container">   
		<div class="row">
		   	<div class="col-md-9">
		   		<div class="category_layout">
			   		<div class="item_caregory red"><h2><a href="category.html">Football</a></h2></div>
						<div class="row">
				   			<div class="col-md-7">
								<div class="item feature_news_item">
									<div class="item_wrapper">
										<div class="item_img">
											<img class="img-responsive" src="<%=request.getContextPath()%>/templates/public/img/img_feature_news.jpg" alt="Chania">
										</div><!--item_img--> 
										<div class="item_title_date">
											<div class="news_item_title">
												<h2><a href="#">22Leo Messi is boss of the bosses of the football world.</a></h2>
											</div><!--news_item_title-->
                                            <div class="item_meta"><a href="#">20Aug- 2015,</a> by:<a href="#">Jhonson</a></div>
										</div><!--item_title_date-->
									</div><!--item_wrapper-->	
								    <div class="item_content">Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque.
								    </div><!--item_content-->

								</div><!--feature_news_item-->
				   			</div><!--col-md-7-->
				   			
				   			<div class="col-md-5">
								<div class="media_wrapper">
									<div class="media">
										<div class="media-left">
											<a href="#"><img class="media-object" src="<%=request.getContextPath()%>/templates/public/img/img-list.jpg" alt="Generic placeholder image"></a>
										</div><!--media-left-->
										<div class="media-body">
											<h3 class="media-heading"><a href="#">Machester United start the player
											</a></h3>

											<p>Sed perspiciatis unde omnis iste natus voluptatem.</p>

										</div><!--media-body-->
									</div><!--media-->

									<div class="media">
										<div class="media-left">
											<a href="#"><img class="media-object" src="<%=request.getContextPath()%>/templates/public/img/img-list2.jpg" alt="Generic placeholder image"></a>
										</div><!--media-left-->
										<div class="media-body">
											<h3 class="media-heading"><a href="#">Machester United start the player
											</a></h3>

											<p>Sed perspiciatis unde omnis iste natus voluptatem.</p>

										</div><!--media-body-->
									</div><!--media-->

									<div class="media">
										<div class="media-left">
											<a href="#"><img class="media-object" src="<%=request.getContextPath()%>/templates/public/img/img-list3.jpg" alt="Generic placeholder image"></a>
										</div><!--media-left-->
										<div class="media-body">
											<h3 class="media-heading"><a href="#">Machester United start the player
											</a></h3>

											<p>Sed perspiciatis unde omnis iste natus voluptatem.</p>

										</div><!--media-body-->
									</div><!--media-->

									<div class="media">
										<div class="media-left">
											<a href="#"><img class="media-object" src="<%=request.getContextPath()%>/templates/public/img/img-list4.jpg" alt="Generic placeholder image"></a>
										</div><!--media-left-->
										<div class="media-body">
											<h3 class="media-heading"><a href="#">Machester United start the player
											</a></h3>

											<p>Sed perspiciatis unde omnis iste natus voluptatem.</p>

										</div><!--media-body-->
									</div><!--media-->
								</div><!--media_wrapper-->
								 
				   			</div><!--col-md-5-->
				   		</div><!--row-->
			   		</div><!--category_layout-->

		   		<div class="category_layout">
		   			<div class="item_caregory blue"><h2><a href="#">Hockey</a></h2></div>
					<div class="row">
			   			<div class="col-md-7">
							<div class="item active feature_news_item">
								<div class="item_wrapper">
									<div class="item_img">
										<img class="img-responsive" src="<%=request.getContextPath()%>/templates/public/img/img-hockey.jpg" alt="Chania">
									</div><!--item_img-->  
									<div class="item_title_date">
										<div class="news_item_title">
											<h2><a href="#">Argentia ahead two step playing hockey tournament</a></h2>
										</div><!--news_item_title-->
                                        <div class="item_meta"><a href="#">20Aug- 2015,</a> by:<a href="#">Jhonson</a></div>
									</div><!--item_title_date-->
								</div><!--item_wrapper-->	
							    <div class="item_content">Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque.
							    </div>

							</div><!--feature_news_item-->
			   			</div><!--col-md-7-->
			   			
			   			<div class="col-md-5">
							<div class="media_wrapper">
								<div class="media">
									<div class="media-left">
										<a href="#"><img class="media-object" src="<%=request.getContextPath()%>/templates/public/img/img-list5.jpg" alt="Generic placeholder image"></a>
									</div><!--media-left-->
									<div class="media-body">
										<h3 class="media-heading"><a href="#">Machester United start the player
										</a></h3>

										<p>Sed perspiciatis unde omnis iste natus voluptatem.</p>

									</div><!--media-body-->
								</div><!--media-->

								<div class="media">
									<div class="media-left">
										<a href="#"><img class="media-object" src="<%=request.getContextPath()%>/templates/public/img/img-list6.jpg" alt="Generic placeholder image"></a>
									</div><!--media-left-->
									<div class="media-body">
										<h3 class="media-heading"><a href="#">Machester United start the player
										</a></h3>

										<p>Sed perspiciatis unde omnis iste natus voluptatem.</p>

									</div><!--media-body-->
								</div><!--media-->

								<div class="media">
									<div class="media-left">
										<a href="#"><img class="media-object" src="<%=request.getContextPath()%>/templates/public/img/img-list7.jpg" alt="Generic placeholder image"></a>
									</div><!--media-left-->
									<div class="media-body">
										<h3 class="media-heading"><a href="#">Machester United start the player
										</a></h3>

										<p>Sed perspiciatis unde omnis iste natus voluptatem.</p>

									</div><!--media-body-->
								</div><!--media-->

								<div class="media">
									<div class="media-left">
										<a href="#"><img class="media-object" src="<%=request.getContextPath()%>/templates/public/img/img-list4.jpg" alt="Generic placeholder image"></a>
									</div><!--media-left-->
									<div class="media-body">
										<h3 class="media-heading"><a href="#">Machester United start the player
										</a></h3>

										<p>Sed perspiciatis unde omnis iste natus voluptatem.</p>

									</div><!--media-body-->
								</div><!--media-->
							</div><!--media_wrapper-->
			   			</div><!--col-md-5-->
			   		</div><!--row-->
		   		</div><!--category_layout-->

		   		<div class="category_layout">
		   			<div class="item_caregory teal"><h2><a href="#">Tennis</a></h2></div>
					<div class="row">
			   			<div class="col-md-7">
							<div class="item active feature_news_item">
								<div class="item_wrapper">
									<div class="item_img">
										<img class="img-responsive" src="<%=request.getContextPath()%>/templates/public/img/img_feature_news3.jpg" alt="Chania">
									</div><!--item_img-->  
									<div class="item_title_date">
										<div class="news_item_title">
											<h2><a href="#">Leo Messi is boss of the bosses of the football world.</a></h3>
										</div><!--news_item_title-->
                                        <div class="item_meta"><a href="#">20Aug- 2015,</a> by:<a href="#">Jhonson</a></div>
									</div><!--item_title_date-->
								</div><!--item_wrapper-->	
							    <div class="item_content">Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque.
							    </div>

							</div><!--feature_news_item-->
			   			</div><!--col-md-7-->
			   			
			   			<div class="col-md-5">
							<div class="media_wrapper">
								<div class="media">
									<div class="media-left">
										<a href="#"><img class="media-object" src="<%=request.getContextPath()%>/templates/public/img/img-list7.jpg" alt="Generic placeholder image"></a>
									</div><!--media-left-->
									<div class="media-body">
										<h3 class="media-heading"><a href="#">Machester United start the player
										</a></h3>

										<p>Sed perspiciatis unde omnis iste natus voluptatem.</p>

									</div><!--media-body-->
								</div><!--media-->

								<div class="media">
									<div class="media-left">
										<a href="#"><img class="media-object" src="<%=request.getContextPath()%>/templates/public/img/img-list8.jpg" alt="Generic placeholder image"></a>
									</div><!--media-left-->
									<div class="media-body">
										<h3 class="media-heading"><a href="#">Machester United start the player
										</a></h3>

										<p>Sed perspiciatis unde omnis iste natus voluptatem.</p>

									</div><!--media-body-->
								</div><!--media-->

								<div class="media">
									<div class="media-left">
										<a href="#"><img class="media-object" src="<%=request.getContextPath()%>/templates/public/img/img-list9.jpg" alt="Generic placeholder image"></a>
									</div><!--media-left-->
									<div class="media-body">
										<h3 class="media-heading"><a href="#">Machester United start the player
										</a></h3>

										<p>Sed perspiciatis unde omnis iste natus voluptatem.</p>

									</div><!--media-body-->
								</div><!--media-->

								<div class="media">
									<div class="media-left">
										<a href="#"><img class="media-object" src="<%=request.getContextPath()%>/templates/public/img/img-list4.jpg" alt="Generic placeholder image"></a>
									</div><!--media-left-->
									<div class="media-body">
										<h3 class="media-heading"><a href="#">Machester United start the player
										</a></h3>

										<p>Sed perspiciatis unde omnis iste natus voluptatem.</p>

									</div><!--media-body-->
								</div><!--media-->
							</div><!--media_wrapper-->
			   			</div><!--col-md-5-->
			   		</div><!--row-->
		   		</div><!--category_layout-->
		   		
		   		<div id="more_news_item" class="more_news_item">
					<div class="more_news_heading"><h2><a href="#">More News</a></h2></div>
					<div class="row">
						<div class="col-md-4">
							<div class="feature_news_item">
	                			<div class="item">
									<div class="item_wrapper">
										<div class="item_img">
											<img class="img-responsive" src="<%=request.getContextPath()%>/templates/public/img/img-news.jpg" alt="Chania">
										</div><!--item_img--> 
										<div class="item_title_date">
											<div class="news_item_title">
												<h3><a href="#">Track Roboto the Real Tracker.</a></h3>
											</div><!--news_item_title-->
                                            <div class="item_meta"><a href="#">20Aug- 2015,</a> by:<a href="#">Jhonson</a></div>
										</div><!--item_title_date-->
									</div><!--item_wrapper-->
								    <div class="item_content">Sed ut perspiciatis unde omnis iste natus error sit  
								    </div><!--item_content-->

								</div><!--item-->               			 
	            			</div><!--feature_news_item-->
						</div><!--col-xs-4-->
							
						<div class="col-md-4">
							<div class="feature_news_item">
	                			<div class="item active">
									<div class="item_wrapper">
										<div class="item_img">
											<img class="img-responsive" src="<%=request.getContextPath()%>/templates/public/img/img-news1.jpg" alt="Chania">
										</div><!--item_img--> 
										<div class="item_title_date">
											<div class="news_item_title">
												<h3><a href="#">Track Roboto the Real Tracker.</a></h3>
											</div><!--news_item_title-->
                                            <div class="item_meta"><a href="#">20Aug- 2015,</a> by:<a href="#">Jhonson</a></div>
										</div><!--item_title_date-->
									</div><!--item_wrapper-->
								    <div class="item_content">Sed ut perspiciatis unde omnis iste natus error sit  
								    </div><!--item_content-->

								</div><!--item-->               			 
	            			</div><!--feature_news_item-->
						</div><!--col-xs-4-->

						<div class="col-md-4">
							<div class="feature_news_item">
	                			<div class="item active">
									<div class="item_wrapper">
										<div class="item_img">
											<img class="img-responsive" src="<%=request.getContextPath()%>/templates/public/img/img-news2.jpg" alt="Chania">
										</div><!--item_img--> 
										<div class="item_title_date">
											<div class="news_item_title">
												<h3><a href="#">Track Roboto the Real Tracker.</a></h3>
											</div><!--news_item_title-->
                                            <div class="item_meta"><a href="#">20Aug- 2015,</a> by:<a href="#">Jhonson</a></div>
										</div><!--item_title_date-->
									</div><!--item_wrapper-->
								    <div class="item_content">Sed ut perspiciatis unde omnis iste natus error sit  
								    </div><!--item_content-->

								</div><!--item-->               			 
	            			</div><!--feature_news_item-->
						</div><!--col-xs-4-->
					</div><!--row-->	
				</div><!--more_news_item-->	
		   	</div><!--col-md-9-->

		   	<div class="col-md-3">

				<div class="tab sitebar">
					<ul class="nav nav-tabs">
						<li class="active"><a  href="#1" data-toggle="tab">Latest</a></li>
						<li><a href="#2" data-toggle="tab">Populer</a></li>
					</ul>

					<div class="tab-content">
						<div class="tab-pane active" id="1">
							<div class="media">
								<div class="media-left">
									<a href="#"><img class="media-object" src="<%=request.getContextPath()%>/templates/public/img/img-list.jpg" alt="Generic placeholder image"></a>
								</div><!--media-left-->
								<div class="media-body">
									<h4 class="media-heading"><a href="#">Spain going to made class football</a></h4>
									<span class="rating">
										<i class="fa fa-star"></i>
										<i class="fa fa-star"></i>
										<i class="fa fa-star"></i>
										<i class="fa fa-star"></i>
										<i class="fa fa-star-half-full"></i>
									</span>
								</div><!--media-body-->
							</div><!--media-->

							<div class="media">
								<div class="media-left">
									<a href="#"><img class="media-object" src="<%=request.getContextPath()%>/templates/public/img/img-list5.jpg" alt="Generic placeholder image"></a>
								</div><!--media-left-->
								<div class="media-body">
									<h4 class="media-heading"><a href="#">Spain going to made class football</a></h4>
									<span class="rating">
										<i class="fa fa-star"></i>
										<i class="fa fa-star"></i>
										<i class="fa fa-star"></i>
										<i class="fa fa-star"></i>
										<i class="fa fa-star-half-full"></i>
									</span>
								</div><!--media-body-->
							</div><!--media-->

							<div class="media">
								<div class="media-left">
									<a href="#"><img class="media-object" src="<%=request.getContextPath()%>/templates/public/img/img-list2.jpg" alt="Generic placeholder image"></a>
								</div><!--media-left-->
								<div class="media-body">
									<h3 class="media-heading"><a href="#">Spain going to made class football</a></h3>
									<span class="rating">
										<i class="fa fa-star"></i>
										<i class="fa fa-star"></i>
										<i class="fa fa-star"></i>
										<i class="fa fa-star"></i>
										<i class="fa fa-star-half-full"></i>
									</span>
								</div><!--media-body-->
							</div><!--media-->

							<div class="media">
								<div class="media-left">
									<a href="#"><img class="media-object" src="<%=request.getContextPath()%>/templates/public/img/img-list3.jpg" alt="Generic placeholder image"></a>
								</div><!--media-left-->
								<div class="media-body">
									<h3 class="media-heading"><a href="#">Spain going to made class football</a></h3>
									<span class="rating">
										<i class="fa fa-star"></i>
										<i class="fa fa-star"></i>
										<i class="fa fa-star"></i>
										<i class="fa fa-star"></i>
										<i class="fa fa-star-half-full"></i>
									</span>
								</div><!--media-body-->
							</div><!--media-->
						</div><!--tab-pane-->

						<div class="tab-pane" id="2">
							<div class="media">
								<div class="media-left">
									<a href="#"><img class="media-object" src="<%=request.getContextPath()%>/templates/public/img/img-list4.jpg" alt="Generic placeholder image"></a>
								</div><!--media-left-->
								<div class="media-body">
									<h3 class="media-heading"><a href="#">Spain going to made class football</a></h3>
									<span class="rating">
										<i class="fa fa-star"></i>
										<i class="fa fa-star"></i>
										<i class="fa fa-star"></i>
										<i class="fa fa-star"></i>
										<i class="fa fa-star-half-full"></i>
									</span>
								</div><!--media-body-->
							</div><!--media-->

							<div class="media">
								<div class="media-left">
									<a href="#"><img class="media-object" src="<%=request.getContextPath()%>/templates/public/img/img-list.jpg" alt="Generic placeholder image"></a>
								</div><!--media-left-->
								<div class="media-body">
									<h3 class="media-heading"><a href="#">Spain going to made class football</a></h3>
									<span class="rating">
										<i class="fa fa-star"></i>
										<i class="fa fa-star"></i>
										<i class="fa fa-star"></i>
										<i class="fa fa-star"></i>
										<i class="fa fa-star-half-full"></i>
									</span>
								</div><!--media-body-->
							</div><!--media-->
						</div><!--tab-pane-->
					</div><!--tab-content-->
				</div><!--tab-->

				<div class="ad">
					<img class="img-responsive" src="<%=request.getContextPath()%>/templates/public/img/img-sitebar.jpg" alt="img" />
					<img class="img-responsive" src="<%=request.getContextPath()%>/templates/public/img/img-sitebar.jpg" alt="img" />
					<img class="img-responsive" src="<%=request.getContextPath()%>/templates/public/img/img-sitebar.jpg" alt="img" />
					<img class="img-responsive" src="<%=request.getContextPath()%>/templates/public/img/img-sitebar.jpg" alt="img" />
				</div><!--ad-->
				
				<div class="ad">
					<img class="img-responsive" src="<%=request.getContextPath()%>/templates/public/img/img-ad.jpg" alt="img" />
				</div>

				<div class="ad">
					<img class="img-responsive" src="<%=request.getContextPath()%>/templates/public/img/img-ad2.jpg" alt="img" />
				</div>

                <div class="most_comment">
                    <div class="sidebar_title">
                        <h2>Most Commented</h2>
                    </div>
                    <div class="media">
                        <div class="media-left">
                            <a href="#"><img class="media-object" src="<%=request.getContextPath()%>/templates/public/img/img-list.jpg" alt="Generic placeholder image"></a>
                        </div><!--media-left-->
                        <div class="media-body">
                            <h3 class="media-heading"><a href="#">Spain going to made class football</a></h3>
                             <div class="comment_box">
                                <div class="comments_icon"> <i class="fa fa-comments" aria-hidden="true"></i></div>
                                 <div class="comments"><a href="#">9 Comments</a></div>
                             </div><!--comment_box-->
                        </div><!--media-body-->
                    </div><!--media-->
                    <div class="media">
                        <div class="media-left">
                            <a href="#"><img class="media-object" src="<%=request.getContextPath()%>/templates/public/img/img-list2.jpg" alt="Generic placeholder image"></a>
                        </div><!--media-left-->
                        <div class="media-body">
                            <h3 class="media-heading"><a href="#">Spain going to made class football</a></h3>
                            <div class="comment_box">
                                <div class="comments_icon"> <i class="fa fa-comments" aria-hidden="true"></i></div>
                                <div class="comments"><a href="#">20 Comments</a></div>
                            </div><!--comment_box-->
                        </div><!--media-body-->
                    </div><!--media-->
                    <div class="media">
                        <div class="media-left">
                            <a href="#"><img class="media-object" src="<%=request.getContextPath()%>/templates/public/img/img-list3.jpg" alt="Generic placeholder image"></a>
                        </div><!--media-left-->
                        <div class="media-body">
                            <h3 class="media-heading"><a href="#">Spain going to made class football</a></h3>
                            <div class="comment_box">
                                <div class="comments_icon"> <i class="fa fa-comments" aria-hidden="true"></i></div>
                                <div class="comments"><a href="#">23 Comments</a></div>
                            </div><!--comment_box-->
                        </div><!--media-body-->
                    </div><!--media-->
                    <div class="media">
                        <div class="media-left">
                            <a href="#"><img class="media-object" src="<%=request.getContextPath()%>/templates/public/img/img-list3.jpg" alt="Generic placeholder image"></a>
                        </div><!--media-left-->
                        <div class="media-body">
                            <h3 class="media-heading"><a href="#">Spain going to made class football</a></h3>
                            <div class="comment_box">
                                <div class="comments_icon"> <i class="fa fa-comments" aria-hidden="true"></i></div>
                                <div class="comments"><a href="#">44 Comments</a></div>
                            </div><!--comment_box-->
                        </div><!--media-body-->
                    </div><!--media-->
                </div><!--most_comment-->
			</div>
		</div>	   	
</section><!--feature_category_section-->

    <!-- Feature Video Item -->
    <section id="feature_video_item" class="feature_video_item section_wrapper">
	<div class="container">
		<div class="row">
			<div class="col-xs-12">
				<div class="feature_video_wrapper">
					<div class="feature_video_title"><h2>Featured Videos</h2></div>

					<div id="feature_video_slider" class="owl-carousel">
						<div class="item">
							<div class="video_thumb"><img   src="<%=request.getContextPath()%>/templates/public/img/video.jpg" alt="Owl Image"></div>
							<div class="video_info">
								<div class="video_item_title"><h3><a href="#">Track & Fiels famous still in the craze of Runner world</a></h3></div><!--video_item_title-->
								<div class="item_meta"><a href="#">20Aug- 2015</a></div><!--item_meta-->
							</div><!--video_info-->
						</div>
						<div class="item">
							<div class="video_thumb"><img   src="<%=request.getContextPath()%>/templates/public/img/video2.jpg" alt="Owl Image"></div>
							<div class="video_info">
								<div class="video_item_title"><h3><a href="#">Track & Fiels famous still in the craze of Runner world</a></h3></div><!--video_item_title-->
								<div class="item_meta"><a href="#">20Aug- 2015</a></div><!--item_meta-->
							</div><!--video_info-->
						</div>
						<div class="item">
							<div class="video_thumb"><img   src="<%=request.getContextPath()%>/templates/public/img/video3.jpg" alt="Owl Image"></div>
							<div class="video_info">
								<div class="video_item_title"><h3><a href="#">Track & Fiels famous still in the craze of Runner world</a></h3></div><!--video_item_title-->
								<div class="item_meta"><a href="#">20Aug- 2015</a></div><!--item_meta-->
							</div><!--video_info-->
						</div>
						<div class="item">
							<div class="video_thumb"><img   src="<%=request.getContextPath()%>/templates/public/img/video2.jpg" alt="Owl Image"></div>
							<div class="video_info">
								<div class="video_item_title"><h3><a href="#">Track & Fiels famous still in the craze of Runner world</a></h3></div><!--video_item_title-->
								<div class="item_meta"><a href="#">20Aug- 2015</a></div><!--item_meta-->
							</div><!--video_info-->
						</div>
						<div class="item">
							<div class="video_thumb"><img   src="<%=request.getContextPath()%>/templates/public/img/video.jpg" alt="Owl Image"></div>
							<div class="video_info">
								<div class="video_item_title"><h3><a href="#">Track & Fiels famous still in the craze of Runner world</a></h3></div><!--video_item_title-->
								<div class="item_meta"><a href="#">20Aug- 2015</a></div><!--item_meta-->
							</div><!--video_info-->
						</div>
						<div class="item">
							<div class="video_thumb"><img   src="<%=request.getContextPath()%>/templates/public/img/video3.jpg" alt="Owl Image"></div>
							<div class="video_info">
								<div class="video_item_title"><h3><a href="#">Track & Fiels famous still in the craze of Runner world</a></h3></div><!--video_item_title-->
								<div class="item_meta"><a href="#">20Aug- 2015</a></div><!--item_meta-->
							</div><!--video_info-->
						</div>
		            </div><!--feature_video_slider-->


		        </div><!--col-xs-12-->
	        </div><!--row-->
        </div><!--feature_video_wrapper-->
	</div><!--container-->
</section>

    <!-- Footer Section -->
    <footer class="footer_section section_wrapper section_wrapper" >
	<div class="footer_top_section">
		<div class="container">
			<div class="row">
				<div class="col-md-3">
					<div class="text_widget footer_widget">
					<div class="footer_widget_title"><h2>About Sports Mag</h2></div>
		         
		         	<div class="footer_widget_content">Collaborativelyadministrate empowered marketsplug-and-play networks. Dynamic procrastinate after.marketsplug-and-play networks. Dynamic procrastinate users after. Dynamic procrastinateafter. marketsplug-and-play networks. Dynamic procrastinate users after...
					</div>
					</div><!--text_widget-->
				</div><!--col-xs-3-->

				<div class="col-md-6">
					<div class="footer_widget">
                        <div class="footer_widget_title"><h2>Discover</h2></div>
					    <div class="footer_menu_item ">
						<div class="row">
							<div class="col-sm-4"> 
								<ul class="nav navbar-nav ">
									<li><a href="../navbar/">Baseball</a></li>
									<li><a href="../navbar-static-top/">Football</a></li>
									<li><a href="./">Cricket</a></li>
									<li><a href="../navbar/">Rugbi</a></li>
									<li><a href="../navbar/">Hockey</a></li>
									<li><a href="../navbar-static-top/">Boxing</a></li>
									<li><a href="./">Golf</a></li>
									<li><a href="../navbar/">Tennis</a></li>
									<li><a href="../navbar/">Horse Racing</a></li>
								</ul>
						    </div><!--col-sm-4-->
					        <div class="col-sm-4 "> 					  						
								<ul class="nav navbar-nav  ">
									<li><a href="../navbar/">Track & Field</a></li>
									<li><a href="../navbar-static-top/">MembershipContact us</a></li>
									<li><a href="./">Newsletter Alerts</a></li>
									<li><a href="../navbar/">Podcast</a></li>
									<li><a href="../navbar/">Blog</a></li>
									<li><a href="../navbar-static-top/">SMS Subscription</a></li>
									<li><a href="./">Advertisement Policy</a></li>
									<li><a href="../navbar/">Jobs</a></li>
								</ul>
					        </div><!--col-sm-4-->
					        <div class="col-sm-4"> 
								<ul class="nav navbar-nav ">
									<li><a href="../navbar/">Report technical issue</a></li>
									<li><a href="../navbar-static-top/">Complaints & Corrections</a></li>
									<li><a href="./">Terms & Conditions</a></li>
									<li><a href="../navbar-static-top/">Privacy Policy</a></li>
									<li><a href="./">Cookie Policy</a></li>
									<li><a href="../navbar/">Securedrop</a></li>
									<li><a href="../navbar/">Archives</a></li>
								</ul>
					        </div><!--col-sm-4-->
				      	</div><!--row-->
			      	</div><!--footer_menu_item-->
                    </div><!--footer_widget-->
				</div><!--col-xs-6-->

				<div class="col-md-3">
 					<div class="text_widget footer_widget">
						<div class="footer_widget_title"><h2>Editor’s Message</h2></div>
						<img src="<%=request.getContextPath()%>/templates/public/img/img-author.jpg" />
						<div class="footer_widget_content">Collaborativelyadministrate empowered marketsplug-and-play networks. Dynamic procrastinate after.marketsplug-and-play networks. Dynamic procrastinate users after. Dynamic procrastinateafter. marketsplug-and-play networks. Dynamic procrastinate users after...</div>
					</div>
				</div><!--col-xs-3-->
			</div><!--row-->
		</div><!--container-->
	</div><!--footer_top_section-->
	<a href="#" class="crunchify-top"><i class="fa fa-angle-up" aria-hidden="true"></i></a>
	
	<div class="copyright-section">
			<div class="container">
				<div class="row">
					<div class="col-md-3">
							Editor: Joshep guinter Grunt
					</div><!--col-xs-3-->
					<div class="col-md-6">
						<div class="copyright">
						© Copyright 2015 - Sports News Mag.com. Design by: <a href="https://uiCookies.com" title="uiCookies">uiCookies</a>
						</div>
					</div><!--col-xs-6-->
					<div class="col-md-3">
						Sports News Magazine
					</div><!--col-xs-3-->
				</div><!--row-->
			</div><!--container-->
		</div><!--copyright-section-->
</footer>

</div> <!--main-wrapper-->
  
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="<%=request.getContextPath()%>/templates/public/js/jquery.min.js"></script>

<!-- Owl carousel -->
<script src="<%=request.getContextPath()%>/templates/public/js/owl.carousel.js"></script>

<!-- Bootstrap -->
<script src="<%=request.getContextPath()%>/templates/public/js/bootstrap.min.js"></script>

<!-- Theme Script File-->
<script src="<%=request.getContextPath()%>/templates/public/js/script.js"></script> 

<!-- Off Canvas Menu -->
<script src="<%=request.getContextPath()%>/templates/public/js/offcanvas.min.js"></script> 


   
</body>
</html>