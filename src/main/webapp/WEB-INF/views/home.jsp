<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/layout/toplayout.jsp"/>
	<div id="map" style="width:100%;height:350px;"></div>
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=8d19f274a104af5193c72c668adac30a&libraries=services"></script>
	<script type="text/javascript" src="/seektam/resources/js/home.js"></script>
	<table class="table" id="resTable">
		<thead>
			<tr>
				<th>상호</th>
				<th>평점</th>
				<th>카테고리</th>
				<th>전화번호</th>
				<th>주소</th>
			</tr>
		</thead>
		<tbody id="resTbBody">
		
		</tbody>
	</table>
	</form>
<jsp:include page="/WEB-INF/views/layout/bottomlayout.jsp"/>
