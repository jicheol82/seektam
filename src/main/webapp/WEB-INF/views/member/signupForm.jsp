<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<!-- 
<c:if test="${sessionScope.memId != null}">
	<script>
		alert("로그아웃하고 가입해주세요.");
		window.location="/spring/member/main.do";
	</script>
</c:if>
 -->
	<h1 align="center"> 회원가입 </h1>
	<form action="/seektam/signupPro" method="post" name="inputForm" >
		<table>
			<tr>
				<td>아이디*</td>
				<td><input type="text" name="id" id="id" /></td>
			</tr>	
			<tr>
				<td>아이디 사용 가능 여부</td>
				<td><input type="text" id="idChRes" disabled/></td>
			</tr>	
			<tr>
				<td></td>
				<td><input type="button" value="아이디 중복 확인" onclick="openConfirmId(this.form)" /> </td>
			</tr>	
			<tr>
				<td>비밀번호*</td>
				<td><input type="password" name="pw" /></td>
			</tr>		
			<tr>
				<td>비밀번호 확인*</td>
				<td><input type="password" name="pwch" /></td>
			</tr>		
			<tr>
				<td>email</td>
				<td><input type="text" name="email" /></td>
			</tr>
			<tr>
				<td>전화</td>
				<td><input type="text" name="mobile" /></td>
			</tr>		
			<tr>
				<td>활동지역1</td>
				<td><input type="text" name="area1" /></td>
			</tr>		
			<tr>
				<td>생일</td>
				<td><input type="text" name="birth" /></td>
			</tr>		
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="가입" /> 
					<input type="reset" value="재작성" /> 
				</td>
			</tr>		
		</table>
	</form>
	
<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://code.jquery.com/jquery-1.12.4.js" integrity="sha256-Qw82+bXyGq6MydymqBxNPYTaUXXq7c8v3CwiYwLLNXU=" crossorigin="anonymous"></script>
<script src="/seektam/resources/js/bootstrap.min.js"></script>
<script src="/seektam/resources/js/signupEffect.js"></script>
<!-- <script src="../../assets/js/docs.min.js"></script>
IE10 viewport hack for Surface/desktop Windows 8 bug 
<script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>-->
</body>
</html>
