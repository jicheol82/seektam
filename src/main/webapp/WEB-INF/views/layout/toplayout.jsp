<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="">
	<meta name="author" content="">
	<!-- <link rel="icon" href="../../favicon.ico"> -->
	<title>Welcome 식탐</title>
	<!-- Bootstrap core CSS -->
	<link href="/seektam/resources/css/bootstrap.min.css" rel="stylesheet">
	<!-- Custom styles for this template -->
	<link href="/seektam/resources/dashboard/dashboard.css" rel="stylesheet">
</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">식당탐험대</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="/seektam/myaccount">나의계정</a></li>
					<li><a href="/seektam/logout">로그아웃</a></li>
				</ul>
          <!-- <form class="navbar-form navbar-right">
            <input type="text" class="form-control" placeholder="Search...">
          </form> -->
			</div>
		</div>
	</nav>
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
				<ul class="nav nav-sidebar">
				  <li class="active"><a href="/seektam/restaurant">홈 <span class="sr-only">(current)</span></a></li>
				  <li><a href="#">친구</a></li>
				  <li><a href="#">그룹</a></li>
				  <li><a href="#">타임라인</a></li>
				</ul>
			</div>
<!-- 이하 main영역 -->
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">