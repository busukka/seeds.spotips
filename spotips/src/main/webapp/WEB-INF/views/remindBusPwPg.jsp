<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="resources/js/jquery.serializeObject.js"></script>
<style>
.container {
    height: 100%;
    display: flex; 
    justify-content: center; 
    align-items: center; 
}
#inputCertNo{
	display: none;
} 
#sendPw{
	 display: none; 
}
</style>
</head>
<body>
<h1 align="center">remindBusPwPg.jsp </h1>
	<div class="container bg-primary">
		<input type="email" placeholder="회원 이메일을 입력하세요." id="mb_id" name="mb_id" class="bg-success text-white" />
		<input type="text" placeholder="사업자번호를 입력하세요." id="mb_busno" name="mb_busno" class="bg-success text-white">
	</div>
	<div class="container bg-primary">
		<input id="btn1" type="button" value="이메일 인증하기" onclick="mailBusCheck()" 
		class="bg-info"/>
	</div>
	<div class="container bg-primary" id="inputCertNo">
		<input type="text" id="certNo" placeholder="인증번호 입력란">
		<input id="btn2" type="button" value="인증완료" onclick="certNoCheck()" 
		class="bg-info"/>
	</div>
	
	<div class="container bg-primary" id="sendPw">
		<input id="btn3" class="bg-info" type="button" value="임시비밀번호발송" onclick="sendPw()"/>
	</div>
</body>
<script>
function mailBusCheck() {
	
var mail=document.getElementById("mb_id").value;
var busno=document.getElementById("mb_busno").value;
console.log(mail);
console.log(busno);

$.ajax({
	type : 'post',
	url : 'ajax/mailBusnoCheck',
	data : {mail:mail,busno:busno},
	dataType : 'JSON',
	success: function(data,status,xhr){
		console.log(data)
		if(data.busnoCheckNo==1){
			alert("해당메일은 가입회원이 아닙니다.");
		}else if(data.busnoCheckNo==2){
			alert("사업자번호가 일치하지 않습니다.");
		}else if(data.busnoCheckNo==3){
			
			$.ajax({
				type : 'post',
				url : 'mail/sendCertMail',
				data : {mail:mail},
				dataType : 'JSON',
				success: function(data,status,xhr){
					console.log(data)
					console.log(status)
					console.log(xhr)
					if(data){
					$('#inputCertNo').css("display","block");
					$('#mb_id').attr("readonly","readonly");
					$('#mb_busno').attr("readonly","readonly");
					$('#btn1').attr("value","이메일 다시 인증하기");
					$('#sendPw').attr("display","none");
					alert('인증번호가'+mail+'로 발송되었습니다.');
					}else{
						alert('메일전송실패')
					}
				},
				error : function(xhr,status) {
					alert('이메일을 다시 확인해주세요.')
			
				}
			}); //인증번호 메일 전송 ajax END
		}		
	},
	error : function(xhr,status) {
		alert("error");
		alert(xhr);
		alert(status);
		
	}
});



}//mailBusCheck() End

function certNoCheck() {
	var certNo = document.getElementById('certNo').value;
	console.log(certNo);
	$.ajax({
		type : 'post',
		url : 'ajax/certNoCheck',
		data : {certNo:certNo},
		dataType : 'JSON',
		success: function(data,status,xhr){
			console.log(data)
			console.log(status)
			console.log(xhr)
			if(data){ //session영역상태 : setAttribute("certStatus", true)
			alert('인증이가 완료.');
			$('#inputCertNo').css("display","none");
			$('#sendPw').css("display","block");s
			}else{
				alert('인증번호가 틀렸습니다.')
				$('#certNo').focus();
			}
		},
		error : function(xhr,status) {
			 alert("error");
			alert(xhr);
			alert(status); 
			
	
		}
	});
	
}//certNoCheck() END

function sendPw() {
	var mail=document.getElementById("mb_id").value
	$.ajax({
		type : 'post',
		url : 'mail/sendPw',
		data : {mail:mail},
		dataType : 'JSON',
		success: function(data,status,xhr){
			console.log(data)
			if(data){
				alert("임시비밀번호 발급이 완료되었습니다. 로그인해주세요.");
				location.href = "/spotips/";
			}else{
				alert("임시비밀번호 발급오류 관리자에게 연락바랍니다.");
			}

			
		},
		error : function(xhr,status) {
			alert("error");
			alert(xhr);
			alert(status);
			
		}
	});
}

</script>

</html>