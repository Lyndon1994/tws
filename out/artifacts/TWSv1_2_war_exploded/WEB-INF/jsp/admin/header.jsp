<%--
  Created by IntelliJ IDEA.
  User: wuhul
  Date: 2016/3/27
  Time: 14:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>TWS</title>
	<meta name="description" content="" />
	<meta name="keywords" content="" />
	<meta name="robots" content="" />
	<meta name="viewport" content="width=device-width, minimum-scale=1.0, maximum-scale=1.0">
	<!-- 新 Bootstrap 核心 CSS 文件 -->
	<%--<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">--%>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/myscc.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" media="all" />
	<!--[if IE]><link rel="stylesheet" href="${pageContext.request.contextPath}/css/ie.css" media="all" /><![endif]-->
	<!--[if lt IE 9]><link rel="stylesheet" href="${pageContext.request.contextPath}/css/lt-ie-9.css" media="all" /><![endif]-->
</head>
<body>
<div class="testing">
<header class="main">
	<h1><strong>TWS</strong></h1>
	<input id="search" type="text" value="search" onchange="search()" />
</header>
<section class="user">
	<div class="profile-img">
		<p><img src="${pageContext.request.contextPath}/images/uiface2.png" alt="" height="40" width="40" /> Welcome back ${sessionScope.employee.name}</p>
	</div>
	<div class="buttons">
		<button class="ico-font">&#9206;</button>
		<span class="button dropdown">
			<a href="#">Notifications <span class="pip">4</span></a>
			<ul class="notice">
				<li>
					<hgroup>
						<h1>You have a new task</h1>
						<h2>Report web statistics week by week.</h2> 
					</hgroup>
					<p><span>14:24</span></p>
				</li>
			</ul>
		</span>
		<span class="button">Help</span>
		<span class="button blue"><a href="index.jsp">Logout</a></span>
	</div>
</section>
</div>
<nav>
	<ul>
		<li><a href="admin_alltools.action"><span class="icon">&#128196;</span> Tools </a>
			<ul class="submenu">
				<li><a href="admin_robot.action">Robots</a></li>
			</ul>
		</li>
		<li><a href="admin_allRequest.action"><span class="icon">&#128202;</span> Application</a></li>
		<li><a href="user.action"><span class="icon">&#128101;</span> Users </a></li>
	</ul>
</nav>

<section class="alert">
	<div class="green">	
		<p>Hi Lee, you have <a href="#">3 new pages</a> and <a href="#">16 comments</a> to approve, better get going!</p>
		<span class="close">&#10006;</span>
	</div>
</section>


