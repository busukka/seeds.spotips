<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
<style>
table,tr,td {
border: 1px solid black;
border-collapse: collapse;
}
</style>
</head>
<body>
<h1>
home.jsp(로그인)
</h1>

<form action="access" name="logForm" method="post">
	<table>
	<tr>
		<td colspan="2" align="center" bgcolor="skyblue">로그인</td>
	</tr>
	
	<tr>
		<td><input type="text" name="mb_id"/></td>
		<td rowspan="2"><button>로그인</button></td>
	</tr>
	
	<tr>
		<td><input type="password" name="mb_pw"></td>
	</tr>
	
	<tr>
	<td colspan="2" align="center" bgcolor="skyblue" > 
	com.board.zyz
	</td>
	
	<tr>
	<td colspan="2" align="center"> <a href="./joinForm">회원가입</a> </td>
	</tr>
	
	</table>
</form>
</body>
</html>
