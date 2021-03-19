<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/layout/toplayout.jsp"/>
	<c:if test="${result==0 }">
		<script>
			alert("비밀번호 오류");
			history.go(-1);
		</script>
	</c:if>
	<c:if test="${result==1 }">
		<c:redirect url="/"/>
	</c:if>
<jsp:include page="/WEB-INF/views/layout/bottomlayout.jsp"/>