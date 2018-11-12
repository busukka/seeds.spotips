<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
</style>
<title>관리자 계정 생성</title>
</head>
<body>
<form action="insertMg" method="post">
		<table>
			<tr>
				<td colspan="2">관리자 계성 정보 입력</td>
			</tr>
			<tr>
				<td>관리자 ID</td>
				<td><input type="text" name="mb_id"/></td>
			</tr>
			<tr>
				<td>관리자 PW</td>
				<td><input type="password" name="mb_pw"/></td>
			</tr>
			<tr>
				<td>관리자 Name</td>
				<td><input type="text" name="mb_name"/></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="관리자 생성"/></td>
			</tr>
		</table>
	</form>		
</body>
</html>