<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/layout/toplayout.jsp"/>
	<script type="text/javascript" src="/seektam/resources/js/group.js"></script>
	<div id="mine">
		<jsp:include page="/WEB-INF/views/html/myGroup.jsp"/>
	</div>
	<br/><br/><br/>
	<div id="joinedGr">
		<h3>내가 가입한 그룹</h3>
		<table class="table">
				<thead>
					<tr>
						<td>그룹명</td>
						<td>활동지역</td>
						<td>회원수</td>
						<td>가입일</td>
						<td></td>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="joinedGr" items="${groupMap.joinedGrList}">
					<tr>
						<td>${joinedGr.name}</td>
						<td>${joinedGr.area}</td>
						<td>${joinedGr.num_of_mem}</td>
						<td>${joinedGr.reg}</td>
						<td><input type="button" onclick="" value="탈퇴"/></td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
	</div>
	<br/><br/><br/>
	<div id="searchGroup">
		<h3>그룹 검색하기</h3>
		<table class="table">
			<thead>
				<tr>
					<td colspan="8">
						<select name="search" id="search">
							<option value="name">그룹명</option>
							<option value="area">지역명</option>
						</select>
						<input type="text" name="keyword" id="keyword"/>
						<input type="button" class="btn btn-primary pull-right" id="searchExe" value="검색"/>
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
					<td>가입/탈퇴</td>
				</tr>
			</thead>
			<tbody id="searchResult"></tbody>
		</table>
	</div>
<jsp:include page="/WEB-INF/views/layout/bottomlayout.jsp"/>
