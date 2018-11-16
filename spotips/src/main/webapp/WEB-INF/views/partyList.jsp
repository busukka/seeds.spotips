<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="resources/js/jquery.serializeObject.js"></script>
<style>
table, tr, td {
	border: 1px solid black;
	border-collapse: collapse;
}
</style>
</head>
<body>
	<h2>partyList.jsp</h2>
	<table>
		<tr bgcolor="aqua" height="30">
			<th width="100">모임명</th>
			<th width="100">모임장</th>
			<th width="100">분야</th>
			<th width="100">내용</th>
			<th width="100">모임시간</th>
			<th width="300">이미지</th>

		</tr>

		<c:forEach var="party" items="${pList}" varStatus="status">
			<tr height="25">
				<td align="center">${party.p_name}</td>
				<td align="center">${party.p_leader }</td>
				<td align="center">${party.fl_no }
					${pfList[status.index].fl_name}</td>
				<td align="center">${party.p_content }</td>
				<td align="center">${party.p_sdate }</td>
				<td align="center" height="300">
				<c:forEach var="bu"
						items="${buList}">
						<c:set var="code" value="${bu.bu_code}" />
							<c:if test="${party.p_no eq code}">
								<img width="100" height="100" src='${bu.bu_path}${bu.bu_filesys}' />
							</c:if>
				</c:forEach> 
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>