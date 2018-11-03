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
SPOTIPS
</h1>

<form action="loginAccess" name="loginForm" method="post">
	<table>
	<tr>
		<td colspan="2"><input type="text" name="mb_id" placeholder="이메일"/></td>
	</tr>
	
	<tr>
		<td colspan="2"><input type="password" name="mb_pw" placeholder="비밀번호"></td>
	</tr>
	
	
	<tr>
	<td align="center" bgcolor="green"><input type="submit" value="로그인" /> </td>
	<td colspan="1" align="center" bgcolor="purple"> <a href="./gdSelectPg?select=remind">비밀번호찾기</a> </td>
	</tr>
	
	
	<tr>
	<td colspan="2" align="center" background="green"> <a href="./gdSelectPg?select=join">스포팁스 시작하기</a> </td>
	</tr>
	
	<tr>
	<td colspan="2" align="center" background="red"> <a href="./googleLogin">구글계정으로 로그인</a> </td>
	</tr>
	
	</table>
</form>
</body>
</html>
