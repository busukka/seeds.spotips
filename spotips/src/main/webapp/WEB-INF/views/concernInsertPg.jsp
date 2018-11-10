<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관심분야 추가페이지</title>
</head>
<body>
<div>
	<h4>관심분야 추가화면</h4>

<form name="form" id="conInsert" action="" method="post"
		onsubmit="return concernCheck(this)"> <!-- concernCheck : 조건에 맞는 입력 여부확인 -->

	<table id="concernInsert" border="1">
		<tr>
			<th colspan='3' >신규 관심분야</th>
		</tr>
		<tr >
			<td colspan='3' align="center">이용자들이 선택할 수 있는 관심분야를 넓혀요</td>
		</tr>
		<tr>
			<th>분야번호</th>
			<th>분야명</th>
			<th>분야이미지</th>
		</tr>
		<tr>
			<td><input type="text" id="fl_no" name="fl_no"
						value="시퀀스로 표시하기" readonly="readonly"></td>
						
			<td><input type="text" id="fl_name" name="fl_name" >
				<input type="button" value="중복확인" onclick="overlapTest()" > 
				<input type="hidden" id="idDuplicatrion" name="idDuplicatrion" value="Uncheck"></td>
				<!-- 관심분야 중복체크했는지 판단하는 부분 value가 UnCheck면 중복체크 안된것~~ -->
			<td><input type="text" id="fl_imgsysname" name="fl_imgsysname" ></td>
		</tr>
		<tr >
			<td colspan='3'>
			<input type="button" value="취소" onclick=""> <!-- div 숨기고 form.Attr()하깅 -->
			<input type="reset" value="다시 입력">
			<input type="submit" value="등록" >
			</td>
		</tr>
	</table>
</form>
</div>
</body>
<script src="http://code.jquery.com/jquery.min.js"></script>
<script type="text/javascript">
 	$(document).ready(function(){ //관심분야명 한글로만 잘 입력한거 확인
 	$("input[name=fl_name]").keydown(function(event){ //텍스트 상자에 입력을 했을때 일어나는 이벤트
 		han = /[a-z0-9]|[ \[\]{}()<>?|`~!@#$%^&*-_+=,.;:\"'\\]/g;
 		v = $(this).val(); //텍스트 상자의 value값을 v라고 선언!!(String 형태)
 		if(han.test(v)){
 			$(this).val(v.replace(han,"")); //$("#id").val(var.replace(string, string)) 특정문자열을 찾아 다른 문자열로 바꿔주는 메소드 
 			alert("한글만 입력하세요.");	
 		}
 		});
		});

	/* <td><input type="text" id="fl_name" name="fl_name" onkeydown="inputChk()">
		<input type="button" value="중복확인" onclick="overlapTest()" > 
		<input type="hidden" id="idDuplicatrion" name="idDuplicatrion" value="Uncheck"></td> */
		
	//onclick="overlapTest()" 아이디 중복확인으로 아래 메시지 띄우기, 공백 - 중복확인
	//중복 체크가 완료된 후 아이디 창을 수정했을 때 다시 중복체크를 하도록 alert창을 띄운다.
	var openwin;
	function overlapTest(){
		
	}	
		//var match = han.exec(id);
 		//var dup = $('#idDuplicatrion');
		//exec()메소드란?? 정규식 패턴에 맞는 문자열 탐색을 수행하는 메소드로, 끝을 만나면(찾지 못하면) null 끝인데 또 실행하면 다시 처음부터 탐색함
		//var form = $('#conInsert'); //form id
		//var flname = $('#fl_name').val(); //입력한 분야명
		//var flimgsysname = $('#fl_imgsysname').val(); //업로드한 이미지 
		//이미지 업로드는 형진쓰가 도와줄 것
		//------------------------------------------------------------------------------------------
		//아이디입력창에 값입력시 hidden에 idUncheck를 세팅한다.
		//이렇게 하는 이유는 중복체크 후 아이디창을 수정했을때 다시 중복체크를 하도록 한다.
		/* if(!match){
			alert("관심분야명은 한글로만 입력할 수 있습니다.");
			$('#fl_name').val('');
			document.userInfo.fl_name.value="";
			return true;
		}el
 */		
		
		/* v = $(this).val();

		if( !han.test(v) ) {
			alert("분야명은 한글만 입력이 가능합니다.");
			$(this).val(v.replace(han,''));
		}	 */	
		
		
		/* if (hann.test(flname) === false) {
	            alert("분야명은 한글로만 입력해주세요!");
	            document.form.fl_name.value=""
	            document.form.fl_name.focus()
	            return false;
	        }
		form.attr("action","concernInsert"); //form의 action에 controller경로 넣어준다.
		form.submit();
		 */
 		/* });
	}); */

	/* trim()이란 : 공백제거 함수!! 띄어쓰기를 제외하고 길이측정~ */
	//관심분야 추가화면의 입력값 검사 하기
 	function concernCheck(obj){		//분야번호는 시퀀스로 등록되기 때문에 검사안함
		if(!obj.fl_name.value || obj.fl_name.value.trim().length ==0){
			alert("분야명이 입력되지 않았습니다!");
			obj.fl_name.value = "";
			obj.fl_name.focus();
			return false;
		}
		if(!obj.fl_imgsysname.value || obj.fl_imgsysname.value.trim().length ==0){
			alert("분야이미지가 등록되지 않았습니다!");
			obj.fl_imgsysname.value = "";
			obj.fl_imgsysname.focus();
			return false;
		}
		return true;
	}
</script>

































</html>