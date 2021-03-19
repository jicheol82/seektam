<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>중복확인</title>
	<!-- <link rel="icon" href="../../favicon.ico"> -->
	<title>Welcome 식탐</title>
	<!-- Bootstrap core CSS -->
	<link href="/seektam/resources/css/bootstrap.min.css" rel="stylesheet">
	<!-- Custom styles for this template -->
	<link href="/seektam/resources/dashboard/dashboard.css" rel="stylesheet">
</head>
<body>
	<h2 align="center">Confirm Id</h2>
	<!-- id가 존재할 경우 -->
<c:if test="${check == 1 }">
	<table>
		<tr>
			<td>${trialId}, 이미 사용중인 아이디 입니다.</td>
		</tr>
	</table>
	<form action="/spring/member/confirmId.do" method="post">
		<table>
			<tr>
				<td>다른 아이디를 입력하세요<br/>
					<input type="text" name="id" />
					<input type="submit" value="확인"/>
				</td>
			</tr>
		</table>
	</form>
</c:if>
<c:if test="${check == 0 }">
	<table>
		<tr>
			<td>
				입력하신 ${trialId}는 사용하 실 수 있습니다.<br/>
				<input type="button" value="닫기" onclick="setId()"/>
			</td>
		</tr>
	</table>
</c:if>
	<script>
		function setId(){
			opener.document.inputForm.id.value="${trialId}";
			self.close();
		}
	</script>
	
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