<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>일반회원관리</title>
</head>
<body>
	<h3>일반회원 관리</h3>
	<br>
	<br>
	<br>
	<br>
	<br>
	<select>
		<option>회원 닉네임</option>
		<option>회원 이메일</option>
	</select>
	<input type="text">
	<input type="button" value="검색">
	<form>
		<table id="loadGenList">
			<tr >
				<th>회원닉네임</th>
				<th>이메일</th>
			</tr>
			${gmlist}
			</table>
	</form>




	<div></div>
</body>
</html>