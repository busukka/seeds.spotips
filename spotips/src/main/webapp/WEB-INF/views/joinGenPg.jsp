<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
table,tr,td {
border: 1px solid black;
border-collapse: collapse;
}
</style>
</head>
<body>
<h1>joinGenPg.jsp</h1>

<form action="insertGm" method="post" name="gmJoinForm">
	<table border="1">
		<tr>
			<td colspan="2" class="subject">일반회원가입</td>
		</tr>
		
		<tr>
			<td width="100">ID </td>
			<td><input type="text" name="gm_id"/></td>
		</tr>
		
		<tr>
			<td width="100">PW </td>
			<td><input type="password" name="gm_pw"/></td>
		</tr>
		
		<tr>
			<td width="100">Name </td>
			<td><input type="text" name="gm_name"/></td>
		</tr>
		
		<tr>
			<td width="100">Birth </td>
			<td><input type="text" name="gm_birth"/></td>
		</tr>
		
		<tr>
			<td width="100">Gender </td>
			<td><input type="text" name="gm_gender"/></td>
		</tr>
		<tr>
			<td width="100">addr </td>
			<td><input type="text" name="ma_addr"/></td>
		</tr>
		
		<tr>
			<td colspan="2"><input type="submit" value="회원가입"/> </td>
		</tr>
</table>

</form>


</body>
</html>