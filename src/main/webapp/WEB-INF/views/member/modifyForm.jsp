<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/layout/toplayout.jsp"/>
	<h1 align="center"> 회원가입 </h1>
	<form action="/seektam/myaccountpro" method="post">
		<table>
			<tr>
				<td>아이디*</td>
				<td>${member.id}</td>
			</tr>	
			<tr>
				<td>비밀번호*</td>
				<td><input type="password" name="pw" value="${member.pw}" /></td>
			</tr>		
			<tr>
				<td>비밀번호 확인*</td>
				<td><input type="password" name="pwch" value="${member.pw}" /></td>
			</tr>		
			<tr>
				<td>email</td>
				<td><input type="text" name="email" value="${member.email}"/></td>
			</tr>		
			<tr>
				<td>전화</td>
				<td><input type="text" name="mobile" value="${member.mobile}"/></td>
			</tr>		
			<tr>
				<td>활동지역1</td>
				<td><input type="text" name="area1" value="${member.area1}"/></td>
			</tr>		
			<tr>
				<td>활동지역2</td>
				<td><input type="text" name="area2" value="${member.area2}"/></td>
			</tr>		
			<tr>
				<td>생일</td>
				<td><input type="text" name="birth" value="${member.birth}"/></td>
			</tr>		
			
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="수정" /> 
					<input type="reset" value="재작성" /> 
					<input type="button" value="취소" onclick="window.location='/'"/> 
				</td>
			</tr>		
		</table>
	</form>
<jsp:include page="/WEB-INF/views/layout/bottomlayout.jsp"/>