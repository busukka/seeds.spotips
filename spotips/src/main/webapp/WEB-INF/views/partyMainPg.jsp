<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="resources/js/jquery.serializeObject.js"></script>
<style>
</style>
<title>모임 메인 페이지</title>
</head>
<body>
<h1>partyMainPg.jsp</h1>
<div id="main-Wrap">
	<div class="pgName"><h4>모임 페이지</h4></div>
	<div class="partyBtn-Wrap">
		<button onclick="location.href='#'">모임정보관리</button>
		<button onclick="location.href='goPartyInsertPg'">새모임 만들기</button>
	</div>
	<div id="partyList-Wrap">
		<div id="partyList1">
		
		</div>
		
		<div id="partyList2">
		
		</div>
	</div>
</div>
</body>
<script type="text/javascript">
$(document).ready(function() {
	$.ajax({
		url: 'ajax/getPartyList',
		type: 'POST',
		dataType:'html',
		success: function(data){
			//alert("로딩 성공.");
			$('#partyList1').html(data);
			},
		error: function(error){
			alert("error"); 
			}
		});  // ajax end

});
</script>
</html>