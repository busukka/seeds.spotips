<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관심분야 추가페이지</title>
</head>
<body>
	<h4>관심분야 추가화면</h4>

	<table border="1">
		<tr colspan='3'>
			<td>신규 관심분야</td>
		</tr>
		<tr>
			<th>분야번호</th>
			<th>분야명</th>
			<th>분야이미지</th>
		</tr>
		<tr>
			<td><input type="text" name="fl_no" ></td>
			<td><input type="text" name="fl_name" ><input type="button" onclick="overlapTest()"></td>
			<td><input type="text" name="fl_imgsysname" ></td>
		</tr>
		<tr colspan='3'>
			<td><input type="button" value="등록" onclick="sucInsert()"></td>
		</tr>
	</table>
</body>
<script type="text/javascript">
	function overlapTest(){
		
	}
	
	function sucInsert(){
		
	}
</script>

































</html>