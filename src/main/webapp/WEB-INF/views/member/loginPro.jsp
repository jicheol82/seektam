<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>loginPro</title>
	<!-- <link rel="icon" href="../../favicon.ico"> -->
	<title>Welcome 식탐</title>
	<!-- Bootstrap core CSS -->
	<link href="/seektam/resources/css/bootstrap.min.css" rel="stylesheet">
	<!-- Custom styles for this template -->
	<link href="/seektam/resources/dashboard/dashboard.css" rel="stylesheet">
</head>
<body>
	<c:if test="${result != 1}">
		<script>
			alert("아이디 또는 비밀번호를 확인해주세요.");
			history.go(-1);
		</script>
	</c:if>
	<c:if test="${result == 1}">
		<c:redirect url="/home"/>
	</c:if>
	
<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://code.jquery.com/jquery-1.12.4.js" integrity="sha256-Qw82+bXyGq6MydymqBxNPYTaUXXq7c8v3CwiYwLLNXU=" crossorigin="anonymous"></script>
<script src="/seektam/resources/js/bootstrap.min.js"></script>
<!-- <script src="../../assets/js/docs.min.js"></script>
IE10 viewport hack for Surface/desktop Windows 8 bug 
<script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>-->
</body>
</html>