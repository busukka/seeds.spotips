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

<form action="memberInsert" name="joinForm" method="post">
	<table border="1">
		<tr>
			<td colspan="2" class="subject">회원가입</td>
		</tr>
		
		<tr>
			<td width="100">ID </td>
			<td><input type="text" name="mb_id"/></td>
		</tr>
		
		<tr>
			<td width="100">PW </td>
			<td><input type="password" name="mb_pw"/></td>
		</tr>
		
		<tr>
			<td width="100">Name </td>
			<td><input type="text" name="mb_name"/></td>
		</tr>
		
		<tr>
			<td colspan="2"><input type="submit" value="회원가입" ></td>
		</tr>
		</table>
		</form>
		

</body>
</html>