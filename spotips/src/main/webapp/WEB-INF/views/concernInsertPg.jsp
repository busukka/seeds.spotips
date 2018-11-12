<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관심분야 추가페이지</title>
</head>
<body>
	<div id="concernInsertPgDiv">
		<h4>관심분야 추가화면</h4>
		<form action="" name="form" id="conInsert" method="post"
			onsubmit="return concernCheck(this)">
			<!-- concernCheck : 조건에 맞는 입력 여부확인 -->

			<table id="concernInsert" border="1">
				<tr>
					<th colspan='3'>신규 관심분야</th>
				</tr>
				<tr>
					<td colspan='3' align="center">이용자들이 선택할 수 있는 관심분야를 넓혀요</td>
				</tr>
				<tr>
					<th>분야번호</th>
					<th>분야명</th>
					<th>분야이미지</th>
				</tr>
				<tr>
					<td><input type="text" id="fl_no" name="fl_no" value="시퀀스로 표시하기" readonly="readonly"></td>

					<td><input type="text" id="fl_name" name="fl_name" > <!-- onkeydown="inputChk()" -->
					&nbsp;
					<input type="button" name="but" value="중복확인" onclick="overlapTest()">
					<input type="hidden" id="idDuplicatrion" name="idDuplicatrion" value="Uncheck"></td>
					<!-- 관심분야 중복체크했는지 판단하는 부분 value가 UnCheck면 중복체크 안된것~~ -->
					
					<td><input type="text" id="fl_imgsysname" name="fl_imgsysname"></td>
				</tr>
				<tr>
					<td colspan='3'>
					<input type="reset" id="concernInsertPgClose" value="취소">
					<input type="reset" value="다시 입력">
					<input type="submit" value="등록" onclick="goConcernInsert()"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
<script src="http://code.jquery.com/jquery.min.js"></script>
<script type="text/javascript">

	
	// 분야명 중복체크 화면 open
	function overlapTest() {
		var id = document.form.fl_name.value;
		var openWin;
		
		if(id.length<1 || id==null){
			alert("중복체크할 아이디를 입력하십시오.");
			return false;
		}
		
		alert("중복체크 창을 로딩합니다");
		
		//부모창이름 지정해주긔
		window.name="parentForm";
		
		//open할 window의 url, 자식창이름 지정, 팝업창 옵션
		openWin = window.open("conChkForm", "concernCheckForm",
				"width=500, height=300, resizable = no, scrollbars = no");
		
		openWin.document.getElementById("username").value = document.getElementById("fl_name").value;
		//자식창에서 입력된 text값의 id, 부모창에서 전달할 text박스의 id
	}
	//내가 지금하려는건 자식창에서 부모창에서ㅜ 입력한 값을 가져오게끔 하는 것..
	//중복 체크가 완료된 후 아이디 창을 수정했을 때 다시 중복체크를 하도록 alert창을 띄운다.
/*  	function inputChk(){
        document.userInfo.idDuplication.value ="Uncheck";
        ("중복체크를 완료해주세요!!")
    } */

	

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

	/* 취소버튼 누르면 관심분야 추가화면 div 숨기기  */ 
	$(document).ready(function() {
		$("#concernInsertPgClose").click(function() { 
			var state = $('#concernInsertPgDiv').css('display');
			/* state 변수에 ID가 concernInsertPgDiv인 요소의 display의 속성을 '대입' */
			if (state != 'none') { /* display 속성이 'none'이 아니라면 */
				$("#showJsp").hide(); /* 숨겨주세요 */
			}
		});
	});
	 
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

	
	/* 관심분야 추가화면의 입력값 검사 하기 */
	function concernCheck(obj) { //분야번호는 시퀀스로 등록되기 때문에 검사안함
		/* trim()이란 : 공백제거 함수!! 띄어쓰기를 제외하고 길이측정~ */
		if (!obj.fl_name.value || obj.fl_name.value.trim().length == 0) {
			alert("분야명을 입력해주세요!");
			obj.fl_name.value = "";
			obj.fl_name.focus();
			return false;
		}
		if (!obj.fl_imgsysname.value
				|| obj.fl_imgsysname.value.trim().length == 0) {
			alert("분야이미지를 등록해주세요!");
			obj.fl_imgsysname.value = "";
			obj.fl_imgsysname.focus();
			return false;
		}
		return true;
	}
 	/* 컨트롤러로 보내기*/
/* 	function goConcernInsert(){
		var form=$("#conInsert");
		form.attr("action","concernInsert");
		form.submit();
	}
	  */
</script>

































</html>