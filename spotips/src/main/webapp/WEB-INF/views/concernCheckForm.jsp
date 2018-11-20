<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관심분야 중복체크 화면!</title>
</head>
<body onload="pValue()">
	<div id="wrap">
		<br> <b><font size="4" color="gray">관심분야명 중복체크</font></b>
		<hr size="1" width="460">
		<br>
		<div id="chk">
			<form id="checkForm">
				<input type="text" name="nameinput" id="username">
				<input type="button" value="중복확인" onclick="conCheck()">
			</form>
			<div id="msg"></div>
			<br>
			<input id="cancelBtn" type="button" value="취소" onclick="window.close()">&nbsp;
			<input id="useBtn" type="button" value="사용하기" onclick="sendCheckValue()">
		</div>
	</div>
</body>
<script src="http://code.jquery.com/jquery.min.js"></script>
<script type="text/javascript">
	
	/* 관심분야 추가화면의 분야명 입력란의 값을 가져온다. */
/* 	function pValue() {
		document.getElementById("username").html(opener.document.userInfo.fl_name.value);
	} */
	
	
	/* 관심분야명 한글로만 잘 입력한거 확인 */
	$(document).ready(function() { 
		$("input[name=fl_name]").keydown(function(event) { /* 텍스트 상자에 입력을 했을때 일어나는 이벤트 */
			han = /[a-z0-9]|[ \[\]{}()<>?|`~!@#$%^&*-_+=,.;:\"'\\]/g;
			/* 한글을 제외한 모든 정규식을 han에 설정 */
			v = $(this).val(); /* 텍스트 상자의 value값을 v라고 선언!!(String 형태) */
			if (han.test(v)) {
				$(this).val(v.replace(han, ""));
				/* $("#id").val(var.replace(string, string)) 특정문자열을 찾아 다른 문자열로 바꿔주는 메소드 */ 
				alert("한글만 입력하세요.");
			}
		});
	});	
	
	
	/* 관심분야 중복체크 */
    function conCheck(){
		
        var conName = document.getElementById("username").value;
        
        if (!conName) {
            alert("아이디를 입력하지 않았습니다.");
            return false;
        }
        else
        {
        	var param="conName="+conName
            httpRequest = getXMLHttpRequest();
            httpRequest.onreadystatechange = callback;
            httpRequest.open("POST", "MemberIdCheckAction.do", true);    
            httpRequest.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded'); 
            httpRequest.send(param);
            
            /* POST 방식 전달
            httpRequest = getXMLHttpRequest();
            httpRequest.open("post"."/master.txt",true);
            httpRequest.send("id=woo&pw=1234"); */
        }
    }
	
	/* 결과값을 가져온다. */
    function callback(){
        if(httpRequest.readyState == 4){
            var resultText = httpRequest.responseText;
            if(resultText == 0){
                alert("사용할수없는 아이디입니다.");
                document.getElementById("cancelBtn").style.visibility='visible';
                document.getElementById("useBtn").style.visibility='hidden';
                document.getElementById("msg").innerHTML ="";
            } 
            else if(resultText == 1){ 
                document.getElementById("cancelBtn").style.visibility='hidden';
                document.getElementById("useBtn").style.visibility='visible';
                document.getElementById("msg").innerHTML = "사용 가능한 아이디입니다.";
            }
        }
    }
	
 	/* 사용하기 클릭 시 부모창으로 값 전달 */ 
    function sendCheckValue(){
        // 중복체크 결과인 idCheck 값을 전달한다.
        opener.document.userInfo.idDuplication.value ="idCheck";
        // 회원가입 화면의 ID입력란에 값을 전달
        opener.document.userInfo.fl_name.value = document.getElementById("username").value;
        if (opener != null) {
            opener.ChkForm = null;
            self.close();
        } 
    }    
	

	
	
	
	
	
	
	
	

	
</script>
</html>