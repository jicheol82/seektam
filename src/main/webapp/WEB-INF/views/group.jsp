<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/layout/toplayout.jsp"/>
	<script type="text/javascript" src="/seektam/resources/js/group.js"></script>
	<div id="mine">
		<c:if test="${groupMap.groupsDTO}==null">
			<h3><input type="button" onclick="그룹생성페이지이동" value="그룹생성"></h3>
		</c:if>
		<c:if test="${groupMap.groupsDTO}!=null">
			<table class="table">
				<thead>
					<tr>
						<td>그룹명</td>
						<td>활동지역</td>
						<td>회원수</td>
						<td>가입방법</td>
						<td>생성일</td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>${groupMap.groupsDTO.name}</td>
						<td>${groupMap.groupsDTO.area}</td>
						<td>${groupMap.groupsDTO.num_of_mem}</td>
						<td>
							<c:if test="${groupMap.groupsDTO.open}==0">신청제</c:if>
							<c:if test="${groupMap.groupsDTO.open}==1">허가제</c:if>
						</td>
						<td>${groupMap.groupsDTO.reg}</td>
					</tr>
				</tbody>
			</table>
		</c:if>
	</div>
	<div id="myGroup">
		<table class="table">
				<thead>
					<tr>
						<td>그룹명</td>
						<td>활동지역</td>
						<td>회원수</td>
						<td>가입일</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="myGroup" items="groupMap.myGroups">
					<tr>
						<td>${myGroup.name}</td>
						<td>${myGroup.area}</td>
						<td>${myGroup.num_of_mem}</td>
						<td>${myGroup.reg}</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
	</div>
	<div id="searchGroup">
		<table class="table">
			<thead>
				<tr>
					<td colspan="7">
						<select name="search" id="search">
							<option value="name">그룹명</option>
							<option value="area">지역명</option>
						</select>
						<input type="text" name="keyword" id="keyword"/>
					</td>
				</tr>
				<tr>
					<td>그룹명</td>
					<td>활동지역</td>
					<td>그룹장</td>
					<td>회원수</td>
					<td>활동성</td>
					<td>공개여부</td>
					<td>등록일</td>
				</tr>
			</thead>
			<tbody id="searchResult"></tbody>
		</table>
	</div>
<jsp:include page="/WEB-INF/views/layout/bottomlayout.jsp"/>
