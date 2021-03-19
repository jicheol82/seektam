<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/layout/toplayout.jsp"/>
	<h1 align="center"> 회원탈퇴 </h1>
	<form action="/seektam/deletePro" method="post">
		<table>
			<tr>
				<td>탈퇴를 원하시면 비밀번호를 입력하세요</td>
			</tr>
			<tr>
				<td><input type="password" name="pw"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="탈퇴"/></td>
			</tr>
		</table>
	</form>
<jsp:include page="/WEB-INF/views/layout/bottomlayout.jsp"/>