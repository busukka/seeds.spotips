<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>일반회원관리</title>
</head>
<body>
	<jsp:include page="nav.jsp"></jsp:include>

	<h3>일반회원 관리</h3>
	<br>
	<br>
	<br>
	<br>
	<br>
	<form action="" id="searchForm">
		<select name="SearchGmlist" id="SearchGmlist">
			<option id="gm_name" name="gm_name">닉네임</option>
			<option id="gm_id" name="gm_id">이메일</option>
		</select>
		<input type="hidden" value="" id="hide">
		<input type="text" name="key">
		<input type="button" value="검색" onclick="search()">
	</form>
	<form>
		<table id="loadGenList" border="1">
			<tr>
				<th>닉네임</th>
				<th>이메일</th>
			</tr>
			${gmlist}
			${searchGmlist}
		</table>
	</form>
</body>
<script src="http://code.jquery.com/jquery.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<script type="text/javascript">
	function search(){
		var langSelect = document.getElementById("SearchGmlist"); //select태그의 id
		var selectValue = langSelect.options[langSelect.selectedIndex].value; //option태그의 text값 이메일, 닉네임
		console.log("검색구분은 회원의"+selectValue); //찍혔어
		//alert(langSelect.options[langSelect.selectedIndex].value); 
		
		//var form = document.searchForm;
		var form=$("#searchForm"); //Form태그의 id
		var hide=$("#hide");
		console.log(hide);
		
		form.attr("action","generalSearch");
		form.submit();
	}
</script>

</html>