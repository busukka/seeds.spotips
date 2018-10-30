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

<h1>gbSelectPg.jsp</h1>

<table>
<tr>
<td colspan="2"> <a href="./joinGenPg">일반회원가입</a> </td>
</tr>
<tr>
<td colspan="2"> <a href="./joinBusPg">기업회원가입</a> </td>
</tr>
<tr>
<td colspan="2"> <a href="./remindGenPwPg">일반회원비번찾기</a> </td>
</tr>
<tr>
<td colspan="2"> <a href="./remindBusPwPg">기업회원비번찾기</a> </td>
</tr>

</table>

</body>
</html>