<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="resources/js/jquery.serializeObject.js"></script>
<title>관리자 계정관리페이지</title>
<style>
ol, ul {
    list-style: none;
    margin:0px; padding:0px;
}
#gmMemberList-wrap{
	width: 300px;
	heigt: 150px;
	float: center;
	align-content: center;

}

#insertForm-Wrap_layer {
	display: none;
	position: fixed;
	position: absolute;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%
}

#insertForm-Wrap_layer.open {
	display: block;
	color: red
}

#insertForm-Wrap_layer #bg_layer {
	position: absolute;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
	background: #000;
	opacity: .5;
	filter: alpha(opacity = 50);
	z-index: 100
}

#insertForm_layer{
	position: absolute;
	top: 40%;
	left: 40%;
	width: 400px;
	height: 400px;
	margin: -150px 0 0 -194px;
	padding: 28px 28px 0 28px;
	border: 2px solid #555;
	background: #fff;
	font-size: 12px;
	z-index: 200;
	color: #767676;
	line-height: normal;
	white-space: normal;
	overflow: scroll
}
</style>
</head>
<body>
<h1>adminMbManagerPg.jsp</h1>
<h2>${id} ${serial}</h2>
	<div id="gmMemberList-wrap">
		${mgListHTML}
	</div>
	<div>
		<button onclick="insertForm('${serial}')">관리자 계정생성</button>
		<button onclick="insertForm('${serial}')">관리자 권한부여</button>
	</div>
		
<div id="insertForm-Wrap_layer">
	<div id="bg_layer"></div>
	<div id="insertForm_layer"></div>
</div>	

</body>
<script>
	function insertForm(serial) {
		alert(serial);
		 if(serial==5){ 
			$('#insertForm-Wrap_layer').addClass('open');
			$.ajax({
				type : 'get',
				url : 'ajax/mgInsertForm',
				dataType: "html",
				success : function(data){
					alert(data);
					console.log(data);
					$('#insertForm_layer').html(data);
					
				},
				error: function(error) {
					alert('error');
				}
			});// ajax END
			
		 }else if(serial==4){
			alert("운영진만 관리자를 생성할 수 있습니다.");
		}else{
			alert("관리자도 아니면서 어딜");
		} 
	}

</script>
</html>