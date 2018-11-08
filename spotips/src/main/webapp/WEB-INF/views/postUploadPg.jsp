<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#postUploadDiv{
	float: center;
	align-content: center;

}
</style>

 <script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

</head>
<body>	
		<div id="postUploadDiv">
	<form action="postUpload" name="puform" id="puform" method="post" enctype="multipart/form-data">
		<table>
			<tr align="center">
				<td colspan="2"><h3>게시물 업로드</h3></td>
			<tr>
				<td>공개범위선택</td>
				<td><input type="radio" name="b_openlv" value=0 />공개 
				<input type="radio" name="b_openlv" value=1 />친구만 공개 
				<input type="radio" name="b_openlv" value=2 />비공개</td>
			</tr>
			<tr>
				<td>관련분야 선택</td>
				<td>
				<input type="radio" name="b_flno" value=1 />축구 
				<input type="radio" name="b_flno" value=2 />농구 
				<input type="radio" name="b_flno" value=3 />야구
				</td>
			</tr>
			<tr>
				<td>내용</td>
				<td><input type="text" name="b_content" height="300" width="400" /></td>
			</tr>
			<tr>
				<td>파일 첨부</td>
				<td><input type="file" name="bu_files" id="bu_files"  multiple /></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
				<input type="button" id="btn" value="글작성" />
				<input type="reset" value="취소" />
				<input type="button" onclick="back()" value="리스트 보기" />
				</td>
			</tr>
			<tr>
			<td colspan="2">
			<div id="image-holder"></div>
			<!-- <img id="blah" src="#" alt="your image" /> -->
			</td>
			<tr>
		</table>
	</form>
	</div>
	
	<div id="boardPeed">
	<%-- ${makeBList} --%>
	</div>
	
	
	
	
	
</body>

<script>
$(document).ready(function() { 
	$.ajax({
		url: 'getBoardList',
		type: 'POST',
		dataType:'html',
		success: function(data){
			//alert("로딩 성공.");
			$('#boardPeed').html(data);
			},
		error: function(error){
			alert("error"); 
			}
		});  // ajax end

});



$(function(){ $("#btn").click(function(){
	var formData = new FormData();
	formData.append("b_openlv", $("input[name=b_openlv]").val());
	formData.append("b_flno", $("input[name=b_flno]").val());
	var countFiles = $("input[name=bu_files]")[0].files.length;
	for(var i=0;i<countFiles ;i++){
	formData.append("bu_files", $("input[name=bu_files]")[0].files[i]);
	}
	formData.append("b_content", $("input[name=b_content]").val());
	
	$.ajax({
		url: 'ajax/postUpload',
		data: formData, 
		processData: false, 
		contentType: false, 
		type: 'POST',
		dataType:'html',
		success: function(data){
			//alert("글을 올리는데 성공하셨습니다.");
			$('#boardPeed').html(data);
			var agent = navigator.userAgent.toLowerCase();
	        if ( (navigator.appName == 'Netscape' && navigator.userAgent.search('Trident') != -1) || (agent.indexOf("msie") != -1) ) {
	        	$('#postUpload').replaceWith($('#bu_files').clone(true));
	        } else { // other browser 일때 
	        	$('#postUpload').val('');
	        }//if end
			},
		error: function(error){
			alert("error"); 
			}
		});  // ajax end
	}); 
	
});


/* $(document).on("change", ".file_multi_video", function(evt) {
	  var $source = $('#video_here');
	  $source[0].src = URL.createObjectURL(this.files[0]);
	  $source.parent()[0].load();
	}); */
	
function back(){
		var form = $('#pufrom');
		form.attr("action","getBoardList");
	}
	

$("#bu_files").on('change', function () {
	
    //Get count of selected files
    var countFiles = $(this)[0].files.length;

    var imgPath = $(this)[0].value;
    var extn = imgPath.substring(imgPath.lastIndexOf('.') + 1).toLowerCase();
    var image_holder = $("#image-holder");
    image_holder.empty();

    if (extn == "gif" || extn == "png" || extn == "jpg" || extn == "jpeg" ){
        if (typeof (FileReader) != "undefined") {

            //loop for each file selected for uploaded.
            for (var i = 0; i < countFiles; i++) {
                var reader = new FileReader();
                reader.onload = function (e) {
                    $("<img />", {
                        "src": e.target.result,
                            "class": "thumb-image",
                            "width": "200",
                            "height": "200"
                    }).appendTo(image_holder);
                }
                image_holder.show();
                reader.readAsDataURL($(this)[0].files[i]);
            }
        } else {
            alert("상위 버전의 브라우저를 사용하시면 미리보기를 사용하실수 있습니다.");
        }
    } else {
        alert("이미지 파일 형식만 가능합니다.");
        var agent = navigator.userAgent.toLowerCase();
        if ( (navigator.appName == 'Netscape' && navigator.userAgent.search('Trident') != -1) || (agent.indexOf("msie") != -1) ) {
        	$('#bu_files').replaceWith($('#bu_files').clone(true));
        } else { // other browser 일때 
        	$('#bu_files').val('');
        }//if end
    }
});


	/*  extn == "avi" || extn == "mp3" || extn == "wmv" || extn == "mpeg" || extn == "mpg" ||
     extn == "mov" || extn == "swf" || extn == "flv" || extn == "tp" || extn == "ts"  */
	     

</script>


</html>