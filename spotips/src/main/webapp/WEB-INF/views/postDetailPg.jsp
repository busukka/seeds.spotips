<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>

<body>
	<a href='likes?b_no=${b.b_no}'>좋아요</a>
	<a href='reportSend?b_no=${r_bno},r_no=${r_no}'></a>
	<hr>
	<br />
	<c:forEach var="file" items="${bu}">
		<img width='200' height='200' src='${file.bu_path}${file.bu_filesys}' />
	</c:forEach>
	<br /> 번호 : ${b.b_no}
	<br /> 아이디 : ${b.b_mbid}
	<br /> 관련분야번호: ${b.b_flno}
	<br /> 내용: ${b.b_content}
	<br /> 날짜: ${b.b_date}
	<br /> 공개여부: ${b.b_openlv}
	<br /> 임시저장여부: ${b.b_temsave}
	<br />
	<br />
	<br />
	<hr>
	<form id="rForm" name='rForm'>
		댓글달기
		<textarea rows="3" cols="50" name="r_content" id="r_content"></textarea>
		<input type="button" value="입력" id="btn" onclick="reply('${b.b_no}')"
			style="width: 70px; height: 50px">
		<%-- onclick="reply(${b.b_no})" --%>
	</form>
	<hr>
	<div id="replyList">
		${rList}
	</div>


</body>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="resources/js/jquery.serializeObject.js"></script>
<script>
	function reply(bno) {
		var obj = $('#rForm').serializeObject(); //{속성:값,속성:값}
		obj.r_bno = bno;
		console.log(obj);
		$.ajax({
			type : 'post', //json으로 넘길땐 get은 안됨.
			url : 'ajax/replyInsert',
			data : obj,
			success : function() {
				alert('replyInsertOk');
				 $("#replyList").html("${rList}");  
				/* var data = JSON.parse(obj);
				$("#replyList").html(data); */
				/* $("#replyList").reload; */
			},
			error : function(error) {
				alert("error")
				console.log(xhr);
				console.log(status);
			}
		});//ajax End
	};
</script>






</html>