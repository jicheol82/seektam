<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<table class="table" id="makeMyGrTb">
	<thead>
		<tr>
			<td>그룹명</td>
			<td>활동지역</td>
			<td>공개여부</td>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td><input type="text" id="grName"></td>
			<td><input type="text" id="grArea"></td>
			<td>
				<select >
					<option id="grOpen" value="0">신청제</option>
					<option id="grOpen" value="1">허가제</option>
				</select>
			</td>
		</tr>
		<tr>
			<td colspan="3"><input type="button" id="makeMyGrExe" value="만들기"></td>
		</tr>
	</tbody>
</table>