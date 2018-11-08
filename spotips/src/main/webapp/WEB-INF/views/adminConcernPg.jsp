<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="http://ajax.googleapis.com/ajax/libs/jquery.min.js">
	
</script>


<title>adminConcern.jsp</title>
</head>
<body>
	<jsp:include page="nav.jsp"></jsp:include>

	<header>관심분야 관리페이지</header>

	<h4>관심분야 목록</h4>
	<!-- 관심분야 목록 Bean에서 가져오기 -->
	<table border="1">
		<tr>
			<th>분야번호</th>
			<th>분야명</th>
			<th>분야이미지</th>
		</tr>
		${flist }
	</table>

	<input type="button" id="conInsert" value="관심분야 추가" onclick="conInsert();passInsert()">
	<!-- 관심분야 추가 버튼을 누르면 sucInsert()로 관심분야추가화면을 include 로딩한다 -->
		<div class="showJsp" style="display: none;"><!-- 버튼에 의해 숨김-보이기 -->
			<jsp:include page="concernInsertPg.jsp"></jsp:include>
		</div>
	<input type="button" id="concernUpd" value="관심분야 수정">
	<!-- onclick="concernUpd()" -->
	<input type="button" id="concernDel" value="관심분야 삭제">
	<!-- onclick="concernDel()" -->

</body>
<script src="http://code.jquery.com/jquery.min.js"></script>
<script type="text/javascript">
	
	$("#conInsert").click(function sucInsert(){ /* 관심분야추가화면 include 보이기 */
		$(".showJsp").show();
	});
	$("#conInsert").click(function passInsert(){ /* 관심분야추가화면 include 숨기기 */
		$(".showJsp").hide();
	});

</script>



<!-- <script type="text/javascript">
	$("#sucInsert").click(function() { //관심분야 추가 완료된 내용 받아보는 ajax
		$.ajax({
			type : "POST", //GET이랑 POST 중에서 선택
			url : "/concernInsert", //경로설정 // ./wow.jsp 또는 컨트롤러 url
			dataType : "html",
			success : function(data) {
				var result = data.result;
				$('sucInsert').html(result);
			},
			error : function(error) {
				alert(error);
			}
		});
	});
</script> -->

</html>





















