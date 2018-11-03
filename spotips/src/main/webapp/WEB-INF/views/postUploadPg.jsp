<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<style>
<style>
table, tr, td {
	border: 1px solid black;
	border-collapse: collapse;
}
</style>
</head>
<body>

	<form action="postUpload" method="post" enctype="multipart/form-data">
		<table>

			<tr align="center">
				<td colspan="2"><h3>게시물 업로드</h3></td>
			<tr>
				<td>공개범위선택</td>
				<td><input type="radio" name="b_openlv" value=0 />공개 <input
					type="radio" name="b_openlv" value=1 />친구만 공개 <input type="radio"
					name="b_openlv" value=2 />비공개</td>
			</tr>
			<tr>
				<td>관련분야 선택</td>
				<td><input type="radio" name="b_flno" value=0 />축구 <input
					type="radio" name="b_flno" value=1 />농구 <input type="radio"
					name="b_flno" value=2 />야구</td>
			</tr>
			<tr>
				<td>파일 첨부</td>
				<td><input type="file" name="bu_files" id="bu_files"
					onchange="fileChk(this)" multiple /> <input type="hidden"
					id="fileCheck" value="0" name="fileCheck" /></td>
			</tr>

			<tr>
				<td>내용</td>
				<td><input type="text" name="b_content" /></td>
			</tr>

			<tr>
				<td colspan="2" align="center">
				<input type="submit" value="글작성" />
				<input type="button" onclick="formData()" value="FormData" /> 
				<input type="reset" value="취소" /> <input type="button"
					onclick="location.href='./boardPg'" value="리스트 보기" /></td>
			</tr>

		</table>


	</form>

</body>

<script>
	function fileChk(elem) {
		console.dir(elem.value);
		if (elem.value == "") {
			console.log("empty");
			$("#fileCheck").val(0); //파일 첨부 안했음
		} else {
			console.log("not Empty");
			$("#fileCheck").val(1); //파일 첨부 했음
		}
	}
	function formData(){
		var $obj=$("#files");
		//var $obj=document.getElementById("bfile");
		console.log("이거 오브젝트="+$obj); //주의! 배열로 반환한다
		console.log("오브젝트[0]="+$obj[0]);
		console.log("오브젝트[0].files="+$obj[0].files);
		console.log($obj[0].files.length);
		console.log($obj[0].files[0]);
		console.log($obj[0].files[1]);
		
		var formData=new FormData(document.getElementById("form"));
		//formData.append("btitle",$("#btitle").val());
		//formData.append("bcontents",$("#bcontents").val());
		//formData.append("fileCheck",$("#fileCheck").val());
		
		/* var files=$obj[0].files;
		for(var i=0;i<files.length;i++){   //파일만 추가할 것이므로 for(in)문 사용하지 말것.
			formData.append("files"+i,files[i]);
		} */
		//console.log(formData.get("btitle"));
		console.log(formData.getAll("bu_files")); //배열로 반환
		//console.log(formData.get("files1"));
		
	
			$.ajax({
			url: "postUpload", 		
			type: "post",  //multipart/form-data를 전송시 post
			data: formData,
			processData:false,// application/x-www-form-urlencoded(쿼리스트링 형식) 처리 금지
			contentType:false, // multipart의 경우 contentType을 false로
			//contentType:'application/json; charset=UTF-8', 
			dataType:"html", //생략가능
			success:function(data){
				alert("성공");
				location.href="./boardPg";
				console.log(data);
			},
			error:function(error){
				alert("실패");
				console.log(error);
			}
		}); //ajax End  
	}
		
		
		//console.log($obj.files.length);
		//console.log($obj.files[0]);
		//console.log($obj.files[1]);


</script>
</html>