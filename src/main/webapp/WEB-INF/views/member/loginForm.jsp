<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<!-- <link rel="icon" href="../../favicon.ico"> -->
	<title>Welcome 식탐</title>
	<!-- Bootstrap core CSS -->
	<link href="/seektam/resources/css/bootstrap.min.css" rel="stylesheet">
	<!-- Custom styles for this template -->
	<link href="/seektam/resources/dashboard/dashboard.css" rel="stylesheet">
</head>
<body>
	<br/>
	<h1 align="center">로그인</h1>
	<h2>memid: ${sessionScope.memId}</h2>
	<form action="/seektam/loginpro" method="post">
		<table>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="id"/></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="pw"/></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="로그인"/>
					<input type="button" value="회원가입" onclick="location='/seektam/signup'"/>
				</td>
			</tr>
		</table>
	</form>
	
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