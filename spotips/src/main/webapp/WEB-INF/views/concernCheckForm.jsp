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
			<input id="cancelBtn" type="button" value="취소"
			onclick="window.close()"><br>
			<input id="useBtn"
			type="button" value="사용하기" onclick="sendCheckValue()">
		</div>
	</div>
</body>
<script type="text/javascript">
	
	function pValue() { // 회원가입창의 아이디 입력란의 값을 가져온다.
		document.getElementById("username").value = opener.document.userInfo.id.value;
	}
	
	// 관심분야 중복체크
    function conCheck(){
        var conName = document.getElementById("username").value;
        //var reg= /^[가-힣]{2,4}$/;
        if (!conName) {
            alert("아이디를 입력하지 않았습니다.");
            return false;
        } 
        else if( conName<"가" || conName > "힣" ){ //한글만 허용
            alert("분야명은 한글로 입력해 주세요.");
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
        }
    }
    function callback(){
        if(httpRequest.readyState == 4){
            // 결과값을 가져온다.
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
	
	
	
	
	
	
	
	
	
	
	
	
	

	
</script>
</html>