<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/layout/toplayout.jsp"/>
	<div id="map" style="width:100%;height:350px;"></div>
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=8d19f274a104af5193c72c668adac30a&libraries=services"></script>
	<script type="text/javascript" src="/seektam/resources/js/home.js"></script>
	<a href="javascript:void();" onclick="callComment('1118826861')">소담촌 봉천현대시장직영점</a>
<jsp:include page="/WEB-INF/views/layout/bottomlayout.jsp"/>
