<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="resources/js/jquery.serializeObject.js"></script>
<script src="resources/js/NameMailCertNoCheck.js"></script>
<head>
<meta charset="UTF-8">
<style>
table,tr,td {
border: 1px solid black;
border-collapse: collapse;
}
#sendCertificationNo{
	display: none;
} 
#sendCertificationNo.open{
	display: block;
} 
#inputCertNo{
	 display: none; 
}
#inputCertNo.open{
	 display: block; 
}
</style>
</head>
<body>

<h1>joinBusPg.jsp</h1>

<form action="insertBm" method="post" name="bmJoinForm">
	<table border="1">
	
		<tr>
			<td colspan="2" class="subject">기업회원가입</td>
		</tr>
	
		<tr>
			<td width="100">기업형태 </td>
			<td><select name="bm_busform" size='1'>				
				<option value="기업">기업</option>
				<option value="단체">단체</option>
				<option value="개인">개인</option>
				<option value="기타">기타</option>
				<option></option>
			</select></td>
		</tr>
		
		<tr>
			<td width="100">ID </td>
			<td><input type="text" name="bm_id" id="mb_id"/></td>
			<td><input type="button" value="중복체크" onclick="mailCheck()" 
			onMouseOver="this.style.backgroundColor='red'"
		onMouseOut="this.style.backgroundColor='white'"/></td>
		</tr>
		
		<tr id="sendCertificationNo">
			<td colspan="2" ><input type="button" value="인증메일발송" onclick="sendCerMail()"/></td>
		</tr>
		
		<tr id="inputCertNo">
			<td align="center" colspan="2"><input type="text" id="certNo" placeholder="인증번호 입력란"/></td>
			<td><input type="button" value="인증완료" onclick=" certNoCheck()" 
			onMouseOver="this.style.backgroundColor='purple'"
		onMouseOut="this.style.backgroundColor='white'"/></td>
		</tr>
		
		<tr>
			<td width="100">PW </td>
			<td><input type="password" name="bm_pw"/></td>
		</tr>
		
		<tr>
			<td width="100">Name </td>
			<td><input type="text" name="bm_name" id="mb_name"/></td>
			<td><input type="button" value="중복체크" onclick="nameCheck()" 
			onMouseOver="this.style.backgroundColor='red'"
			onMouseOut="this.style.backgroundColor='white'" /></td>
		</tr>
		
		<tr>
			<td width="100">기업번호 </td>
			<td><input type="text" name="bm_busno"/></td>
		</tr>
		<tr>
			<td width="100">기업대표 </td>
			<td><input type="text" name="bm_busRepre"/></td>
		</tr>
		
		<tr>
			<td width="100">기업연락처 </td>
			<td><input type="text" name="bm_busTel"/></td>
		</tr>
		
		<tr>
			<td width="100">기업주소 </td>
			<td><input type="text" name="bm_addr"/></td>
		</tr>
		
		<tr>
			<td colspan="2"><input type="submit" value="회원가입"/> </td>
		</tr>
</table>
</form>

</body>
<script>
/* function mailCheck() {
	var mail=document.getElementById("mb_id").value
	console.log(mail);
	console.log($('#sendCertificationNo').value);
	$.ajax({
		type : 'post',
		url : 'ajax/mailCheck',
		data : {mail:mail},
		dataType : 'JSON',
		success: function(data,status,xhr){
			console.log(data)
			console.log(status)
			console.log(xhr)
			
			 if(data.mailCheckNo==2){
				alert('중복!');
				$('#sendCertificationNo').removeClass('open');
				$('#mb_id').focus();
			}else {
				alert('중복없음!')
				$('#sendCertificationNo').addClass('open');
			}  
			
			
		},
		error : function(xhr,status) {
			alert("error");
			alert(xhr);
			alert(status);
			
		}
	})
	
}//mailCheck() End

function sendCerMail() {
	var mail=document.getElementById('mb_id').value;
	console.log(mail);

	$.ajax({
		type : 'post',
		url : 'sendCertMail',
		data : {mail:mail},
		dataType : 'JSON',
		success: function(data,status,xhr){
			console.log(data)
			console.log(status)
			console.log(xhr)
			if(data){
			alert('인증번호가'+mail+'로 발송되었습니다.');
			$('#inputCertNo').addClass('open');
			}else{
				alert('이메일을 다시 확인해주세요.')
			}
		},
		error : function(xhr,status) {
			/* alert("error");
			alert(xhr);
			alert(status); */
			alert('이메일을 다시 확인해주세요.')
	
		}
	})
}//sendCerMail() End

function certNoCheck() {
	var certNo = document.getElementById('certNo').value;
	console.log(certNo);
	$.ajax({
		type : 'post',
		url : 'certNoCheck',
		data : {certNo:certNo},
		dataType : 'JSON',
		success: function(data,status,xhr){
			console.log(data)
			console.log(status)
			console.log(xhr)
			if(data){ //session영역상태 : setAttribute("certStatus", true)
			alert('인증이가 완료.');
			$('#inputCertNo').removeClass('open');
			$('#sendCertificationNo').removeClass('open');
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
	})
	
}//certNoCheck() End
 */

</script>

</html>