<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>joinBusPg.jsp</h1>

<form action="insertBm" method="post" name="bmJoinForm">
	<table border="1">
		<tr>
			<td colspan="2" class="subject">기업회원가입</td>
		</tr>
		
		<tr>
			<td width="100">ID </td>
			<td><input type="text" name="bm_id"/></td>
		</tr>
		
		<tr>
			<td width="100">PW </td>
			<td><input type="password" name="bm_pw"/></td>
		</tr>
		
		<tr>
			<td width="100">Name </td>
			<td><input type="text" name="bm_name"/></td>
		</tr>
		
		<tr>
			<td width="100">기업형태 </td>
			<td><input type="text" name="bm_busform"/></td>
		</tr>
		
		<tr>
			<td width="100">기업번호 </td>
			<td><input type="text" name="bm_busno"/></td>
		</tr>
		<tr>
			<td width="100">기업대표 </td>
			<td><input type="text" name="bm_busRepre"/></td>
		</tr>
		
		<tr>
			<td width="100">기업연락처 </td>
			<td><input type="text" name="bm_busTel"/></td>
		</tr>
		
		<tr>
			<td width="100">기업주소 </td>
			<td><input type="text" name="bm_addr"/></td>
		</tr>
		
		<tr>
			<td colspan="2"><input type="submit" value="회원가입"/> </td>
		</tr>
</table>

</form>


</body>
</html>