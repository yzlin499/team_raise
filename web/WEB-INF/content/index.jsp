<%@ page import="top.yzlin.teamraise.entity.MemberInfo" %>
<%@ page import="java.util.List" %>
<%@ page import="top.yzlin.teamraise.pool.RaisePool" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<!--[if IE 8 ]><html class="ie" xmlns="http://www.w3.org/1999/xhtml" xml:lang="en-US" lang="en-US"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!--><html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en-US" lang="en-US"><!--<![endif]-->
<head>
    <!-- Basic Page Needs -->
    <meta charset="utf-8">
    <!--[if IE]>
    <meta http-equiv='X-UA-Compatible' content='IE=edge,chrome=1'><![endif]-->
    <title>Mountain html template</title>

    <meta name="author" content="themesflat.com">

    <!-- Mobile Specific Metas -->
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

    <!-- Bootstrap  -->
    <link rel="stylesheet" type="text/css" href="stylesheets/bootstrap.css">

    <!-- Theme Style -->
    <link rel="stylesheet" type="text/css" href="stylesheets/style.css">

    <!-- Responsive -->
    <link rel="stylesheet" type="text/css" href="stylesheets/responsive.css">

    <!-- Colors -->
    <link rel="stylesheet" type="text/css" href="stylesheets/colors/color1.css" id="colors">

    <!-- Favicon and touch icons  -->
    <link href="icon/apple-touch-icon-48-precomposed.png" rel="apple-touch-icon-precomposed" sizes="48x48">
    <link href="icon/apple-touch-icon-32-precomposed.png" rel="apple-touch-icon-precomposed">
    <link href="icon/favicon.ico" rel="shortcut icon">

    <!--[if lt IE 9]>
    <script src="javascript/html5shiv.js"></script>
    <script src="javascript/respond.min.js"></script>
    <![endif]-->
</head>
<body class="header-sticky">
<div class="loader">
    <span class="loader1 block-loader"></span>
    <span class="loader2 block-loader"></span>
    <span class="loader3 block-loader"></span>
</div>
<div class="site-wrapper ">
    <!-- Header -->
    <header id="header" class="header clearfix">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="header-wrap clearfix">
                        <div id="logo" class="logo">
                            <a href="index.html" rel="home">
                                <img src="images/logo.svg" alt="image">
                            </a>
                        </div><!-- /.logo -->
                        <div class="nav-wrap">
                            <div class="btn-menu"></div>
                            <nav id="mainnav" class="mainnav">
                                <%--此处用于做头部的列表--%>
                                <ul class="menu">
                                    <li class="home">
                                        <a href="index.html">成员</a>
                                        <ul class="submenu">
                                            <li><a href="#">Demo 1</a></li>
                                        </ul>
                                    </li>
                                </ul>
                            </nav><!-- /.mainnav -->
                        </div><!-- /.nav-wrap -->

                        <%--此处是右方小控件的列表--%>
                        <ul class="menu-extra">
                            <li id="s" class="search-box">
                                <a href="#"><i class="fa fa-search"></i></a>
                                <div class="submenu">
                                    <div class="widget widget_search">
                                        <form role="search" method="get" class="search-form" action="#">
                                            <label>
                                                <span class="screen-reader-text">Search for:</span>
                                                <input type="search" class="search-field" placeholder="Search …"
                                                       value="" name="s" title="Search for:">
                                            </label>
                                            <input type="submit" class="search-submit" value="Search">
                                        </form>
                                    </div>
                                </div>
                            </li>
                        </ul>
                    </div><!-- /.header-wrap -->
                </div>
            </div> <!-- /.row -->
        </div> <!--  /.container -->
    </header><!-- /.header -->

    <!-- Gallery alt layout -->
    <div class="gallery-alt-layout">
        <div class="container">
            <div class="row">
                <div class="flat-project flat-animation" data-animation="fadeInUp" data-animation-delay="0"
                     data-animation-offset="75%">
                    <div class="controlnav-folio">
                        <a class="projects-filter-toggler">
                            <span>Toggle Filter</span>
                        </a>
                        <%--此处是成员列表--%>
                        <ul class="project-filter">
                            <li class="active"><a data-filter="*" href="#">All</a></li>
                            <li><a data-filter=".success" href="#">未完成</a></li>
                            <li><a data-filter=".false" href="#">已完成</a></li>
                            <c:forEach items="${requestScope.memberInfoList}" var="memberInfo">
                                <li><a data-filter=".member${memberInfo.id}" href="#">${memberInfo.name}</a></li>
                            </c:forEach>
                            <%--<li><a data-filter=".design" href="#">Design</a></li>--%>
                        </ul><!-- /.project-filter -->
                    </div>
                    <div class="project-wrap three-columns ">


                        <c:forEach items="${requestScope.raiseInfoList}" var="raiseInfo">
                            <div class="entry project-item member${raiseInfo.memberID} ">
                                <div class="item-wrap">
                                    <div class="project-thumb">
                                        <img src="${raiseInfo.cover}" alt="image">
                                    </div>
                                    <div class="project-info">
                                        <div class="project-info-wrap">
                                            <h3 class="project-title">
                                                <a href="${raiseInfo.url}">${raiseInfo.title}</a>
                                            </h3>
                                            <ul class="project-categories">
                                                <li><p>${raiseInfo.alreadyRaiseMoney}/${raiseInfo.goalMoney}元</p></li>
                                                <li><p>${raiseInfo.alreadyRaiseMoney}/${raiseInfo.goalMoney}元</p></li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>


                    </div><!-- /.project-wrap -->
                </div><!-- /.flat-project -->
            </div><!-- /.row -->
        </div><!-- /.container -->
    </div>

    <!-- Footer -->
    <div class="flat-footer">
        <div class="footer-widgets">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div id="text-3" class="widget widget_text">
                            <div class="textwidget">
                                <img src="images/logo.svg" alt="Mountain">
                            </div>
                        </div>
                    </div>
                </div><!-- /.row -->
            </div><!-- /.container -->
        </div><!-- /#page-footer -->

        <div class="footer-content">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="social-links">
                            <a href="#"><i class="fa fa-twitter"></i></a>
                            <a href="#"><i class="fa fa-facebook"></i></a>
                            <a href="#"><i class="fa fa-instagram"></i></a>
                            <a href="#"><i class="fa fa-behance"></i></a>
                            <a href="#"><i class="fa fa-rss"></i></a>
                        </div>
                    </div>
                    <div class="col-md-12">
                        <div class="copyright">
                            <div class="copyright-content">© Mountain 2015<span>•</span>15 Nicholson Street, New York
                                <span>•</span> Tel: 1-888-345-6789<br>
                                <span>Copyright © 2015
                                        <a href="#">Themesflat</a>, Inc.</span>
                            </div><!-- /.copyright-content -->
                        </div><!-- /.copyright -->
                    </div>
                </div> <!-- /.row -->
            </div><!-- /.container -->
        </div>
    </div>
</div>  <!-- /.site-wrapper -->

<!-- Canvas -->
<div id="off-canvas">
    <div class="off-canvas-wrap">
        <div id="text-5" class="widget widget_text">
            <h3 class="widget-title">About Mountain</h3>
            <div class="textwidget">
                <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the
                    industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type
                    and scrambled it to make a type specimen book. It has survived</p>
                <div class="social-links">
                    <a target="_blank" href="https://twitter.com/themesflat">
                        <i class="fa fa-twitter"></i></a>
                    <a target="_blank" href="https://facebook.com/themesflat"><i class="fa fa-facebook"></i></a>
                    <a target="_blank" href="#"><i class="fa fa-instagram"></i></a>
                    <a target="_blank" href="#"><i class="fa fa-behance"></i></a>
                    <a target="_blank" href="#"><i class="fa fa-rss"></i></a>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Go Top -->
<a class="go-top">
</a>

<!-- Javascript -->
<script type="text/javascript" src="javascript/jquery.min.js"></script>
<script type="text/javascript" src="javascript/bootstrap.min.js"></script>
<script type="text/javascript" src="javascript/owl.carousel.js"></script>
<script type="text/javascript" src="javascript/jquery.flexslider-min.js"></script>
<script type="text/javascript" src="javascript/jquery.magnific-popup.min.js"></script>
<script type="text/javascript" src="javascript/smoothscroll.js"></script>
<script type="text/javascript" src="javascript/jquery.easing.js"></script>
<script type="text/javascript" src="javascript/parallax.js"></script>
<script type="text/javascript" src="javascript/imagesloaded.min.js"></script>
<script type="text/javascript" src="javascript/jquery.isotope.min.js"></script>
<script type="text/javascript" src="javascript/jquery.cookie.js"></script>
<script type="text/javascript" src="javascript/jquery-waypoints.js"></script>
<script type="text/javascript" src="javascript/main.js"></script>

<!-- Revolution Slider -->
<script type="text/javascript" src="javascript/jquery.themepunch.tools.min.js"></script>
<script type="text/javascript" src="javascript/jquery.themepunch.revolution.min.js">
</script>
<script type="text/javascript" src="javascript/slider.js"></script>
</body>
</html>