<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<script>
	window.onload=function(){
		  if(${mb.mb_serial==2}){  
			location.href="#businessMsg";
		  }  
		  if(${selectCon==0}){
				$('#msg').html("관심분야를 아직 선택하지 않으셨어요!");
			}
	}
</script>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<style>
.white_content {
    position: fixed;
    top: 0;
    right: 0;
    bottom: 0;
    left: 0;
    background: rgba(0, 0, 0, 0.8);
    opacity:0;
    -webkit-transition: opacity 400ms ease-in;
    -moz-transition: opacity 400ms ease-in;
    transition: opacity 400ms ease-in;
    pointer-events: none;
}
.white_content:target {
    opacity:1;
    pointer-events: auto;
}
.white_content > div {
	position: absolute;
	top: 25%;
	left: 25%;
	width: 50%;
	height: 50%;
	padding: 16px;
	border: 16px solid #04B4AE;
	background-color:white;
	overflow: auto;	
}

</style>
</head>
<body>
<h1>selectConcern.jsp</h1>
<div class="content">
<div class="d-flex justify-content-center h-100">
<h3 class="msg" id="msg">시리얼=${mb.mb_serial} ${mb.mb_name}님 가입을 환영합니다. 관심분야를 골라주세요.</h3>
</div>
</div>

<form action="selectConcern" method="post">
<div class="container text-white bg-primary">
	${FLCheckBoxHTML}
	<input type="submit" value="선택완료" />
</div>
</form>

    <div class="white_content" id="businessMsg">
        <div align="center">
        	<p class="text-center text-danger display-4">${mb.mb_name}님의 기업회원 승인 요청이 완료 되었습니다.</p>
        	</hr>
        	<p class="text-center text-danger display-5">관리자가 승인 후 기업회원 서비스를 이용하실 수 있습니다.</p>
            <p><a href="#close" class="display-5">닫기</a></p>
        </div>
    </div>

</body>
</html>