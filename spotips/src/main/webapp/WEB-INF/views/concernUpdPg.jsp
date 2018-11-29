<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관심분야 수정</title>
</head>
<body>
		<h4>관심분야 수정화면</h4>
		<form name="form" id="conUpd" method="post"> <!-- onsubmit="return conUpdCheck()" -->
			<table id="concernUpd" border="1">
				<tr><th colspan='6'>관심분야 목록</th></tr>
				<tr><td colspan='6' align="center">
					관심분야의 이름 또는 이미지를 수정하고 삭제할 수 있어요.</td></tr>
				${detailFlist }
			</table>
		</form>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
	/*관심분야 삭제*/
 	function conDelCheck(fl_no,fl_name){
		var form = $('form');
		form.attr("action","conDelForm?fl_no="+fl_no+"&fl_name="+fl_name);
		form.submit();
		alert(fl_name+'삭제완료');
	}
	
	/*관심분야 수정*/
	function conUpdCheck(){
		var form = $('form');
		var dupCheck = $('#dupCheck');
		var flname=$('#fl_name');
		
		var fl_name = $('#fl_name').val();
		var fl_no = $('#fl_no').val();
		
		alert(fl_name);
		if (flname[0].value == null || flname[0].value < 1) {
			console.log(flname[0].value);
			alert("분야명을 입력해주세요!");
			$('#fl_name').focus();
			return false;
		}
 		if(dupCheck[0].value == 'unDupCheck' || dupCheck[0].value != 'dupCheck'){
 			alert("분야명 중복체크를 해주세요!")
 			$('#but').focus();
			return false;
		}
		form.attr("action","conUpdForm? fl_no="+fl_no+"& fl_name="+fl_name);
		form.submit();
	};
	
	/* 관심분야명 한글로만 잘 입력한거 확인 */
$(document).ready(function() { 
	$("input[name=fl_name]").keyup(function(event) { /* 텍스트 상자에 입력을 했을때 일어나는 이벤트 */
		han = /[a-z0-9]|[ \[\]{}()<>?|`~!@#$%^&*-_+=,.;:\"'\\]/g;
		/* 한글을 제외한 모든 정규식을 han에 설정 */
		v = $(this).val(); /* 텍스트 상자의 value값을 v라고 선언!!(String 형태) */
		if (han.test(v)) {
			$(this).val(v.replace(han, "")); /*replace(바꿀 부분, 바꿀 내용) */ 
			alert("한글만 입력하세요.");
		}
	});
});
	/*  분야명 중복체크 하는 ajax */
function overlapTest() {
	var name = document.getElementById("fl_name").value;
	var fl_name = $('#fl_name').val();
	
	if(name.length<1 || name==null){
		alert("중복체크할 분야명을 입력한 후 수정하세요.");
		return false;
	}
	$.ajax({
		type : 'post',
		url : 'ajax/conChkForm',
		data : { 'fl_name' : fl_name },
		dataType : 'json',
		success : function(data,status,xhr){
			console.log(data); //json(basket)
			console.log(status);
			console.log(xhr);
			if(data.fl_name==2){
				alert('중복');
				$('#fl_name').val('');
				$('#fl_name').focus();
			}else{
				$('#idDuplicatrion').show();//중복체크완료 div 뜸.
			}
			$('#dupCheck').val('dupCheck'); //중복이던 중복이 아니던 중복체크 완료!
		},
		error : function(status, xhr){
			alert("error");
			alert(status);
			alert(xhr);				
		}
	});
}
	/* onfocus 속성 마우스 다시 올리면 중복체크 다시 해야함*/
function init(){
	var fl_name = $('#fl_name');
	fl_name.val('');
	$('#idDuplicatrion').val('');
	$('#idDuplicatrion').hide();
	$('#dupCheck').val('unDupCheck');
}
	
		/* 수정
			$ajax({
			type : 'post',
			url : 'ajax/conUpdForm',
			data : {
				'fl_no' : fl_no,
				'fl_name' : fl_name
				//'fl_imgsysname' : fl_imgsysname				
			},
			dataType : 'HTML',
			success : function(data,status,xhr){
				console.log(data);
				console.log(status);
				console.log(xhr);
			},
			error : function(status, xhr){
				alert("error");
				alert(status);
				alert(xhr);		
			}
		}); */
	
	/* 뒤로가기 - 관심분야관리페이지로 이동 */
	function goConcernPg(){
		location.href='goConcernPg';
	}	
	
	
	
</script>
</html>




















