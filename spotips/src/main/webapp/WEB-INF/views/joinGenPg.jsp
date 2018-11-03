<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="resources/js/jquery.serializeObject.js"></script>
</head>
<body>
<h1>joinGenPg.jsp</h1>

<form action="insertGm" method="post" name="gmJoinForm">
	<table border="1">
		<tr>
			<td colspan="2" class="subject">일반회원가입</td>
		</tr>
		
		
		<tr>
			<td width="100">ID </td>
			<td><input type="text" name="gm_id" id="mb_id"/></td>
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
			<td><input type="password" name="gm_pw"/></td>
		</tr>
		
		<tr>
			<td width="100">Name </td>
			<td><input type="text" name="gm_name" id="mb_name" placeholder="(대소문자 구분)"/></td>
			<td><input type="button" value="중복체크" onclick="nameCheck()" 
			onMouseOver="this.style.backgroundColor='red'"
			onMouseOut="this.style.backgroundColor='white'" /></td>
		</tr>
		
		<tr>
			<td width="100">Birth </td>
			<td><input type="text" name="gm_birth"/></td>
		</tr>
		
		<tr>
			<td width="100">Gender </td>
			<td>
			남<input type="radio" name="gm_gender" value="남자" checked/>
			여<input type="radio" name="gm_gender" value="여자"/>
			</td>
		</tr>
		<tr>
			<td width="100">addr(선택사항)</td>
			<!-- <td><input type="text" name="ma_addr"/></td> -->
			<td><input type="text" name="addr1" id="addr1" placeholder="우편번호"></td>
			<td><input type="text" name="addr2" id="addr2" placeholder="도로명주소"></td>
			<td><input type="text" name="addr3" id="addr3" placeholder="지번주소"></td>
			<td><input type="button" onclick=" searchAddr()" value="우편번호 찾기"><br></td>
		</tr>
		
		<tr>
			<td colspan="2"><input type="submit" value="회원가입"/> </td>
		</tr>
</table>
<span id="guide" style="color:#999"></span>

</form>



</body>
<!-- [JS]다음 주소검색 API --> 
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script> 
<!-- <script>
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
            // 예제를 참고하여 다양한 활용법을 확인해 보세요.
        }
    }).open();
</script> -->
<script>
    //본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
    function  searchAddr() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 도로명 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var fullRoadAddr = data.roadAddress; // 도로명 주소 변수
                var extraRoadAddr = ''; // 도로명 조합형 주소 변수

                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 도로명, 지번 조합형 주소가 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }
                // 도로명, 지번 주소의 유무에 따라 해당 조합형 주소를 추가한다.
                if(fullRoadAddr !== ''){
                    fullRoadAddr += extraRoadAddr;
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('addr1').value = data.zonecode; //5자리 새우편번호 사용
                document.getElementById('addr2').value = fullRoadAddr;
                document.getElementById('addr3').value = data.jibunAddress;

                // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
                if(data.autoRoadAddress) {
                    //예상되는 도로명 주소에 조합형 주소를 추가한다.
                    var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                    document.getElementById('guide').innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';

                } else if(data.autoJibunAddress) {
                    var expJibunAddr = data.autoJibunAddress;
                    document.getElementById('guide').innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';

                } else {
                    document.getElementById('guide').innerHTML = '';
                }
            }
        }).open();
    }
</script>
<script>
function mailCheck() {
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

function nameCheck() {
	var name=document.getElementById("mb_name").value
	console.log(name);
	$.ajax({
		type : 'post',
		url : 'ajax/nameCheck',
		data : {name:name},
		dataType : 'JSON',
		success: function(data,status,xhr){
			console.log(data)
			console.log(status)
			console.log(xhr)
			
			 if(data){
				alert('중복없음!')
			}else {
				alert('중복!');
				$('#mb_name').focus();
				
			}  
			
			
		},
		error : function(xhr,status) {
			alert("error");
			alert(xhr);
			alert(status);
			
		}
	})
	
}//mailCheck() End
</script>

</html>