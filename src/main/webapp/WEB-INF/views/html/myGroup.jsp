<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${groupMap.groupsDTO==null}">
	<h3><input type="button" id="makeMyGr" value="그룹생성"></h3>
</c:if>
<c:if test="${groupMap.groupsDTO!=null}">
	<h3>내가 생성한 그룹</h3>
	<table class="table">
		<thead>
			<tr>
				<td>그룹명</td>
				<td>활동지역</td>
				<td>회원수</td>
				<td>가입방법</td>
				<td>생성일</td>
				<td></td>
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
				<td><input type="button" onclick="" value="관리"/></td>
			</tr>
		</tbody>
	</table>
</c:if>