<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<%-- <head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#postUploadDiv{
	float: center;
	align-content: center;

}

#articleView_layer {
	display: none;
	position: fixed;
	position: absolute;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%
}

#articleView_layer.open {
	display: block;
	color: red
}

#articleView_layer #bg_layer {
	position: absolute;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
	background: #000;
	opacity: .5;
	filter: alpha(opacity = 50);
	z-index: 100
}

#contents_layer {
	position: absolute;
	top: 40%;
	left: 40%;
	width: 400px;
	height: 400px;
	margin: -150px 0 0 -194px;
	padding: 28px 28px 0 28px;
	border: 2px solid #555;
	background: #fff;
	font-size: 12px;
	z-index: 200;
	color: #767676;
	line-height: normal;
	white-space: normal;
	overflow: scroll
}
</style>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="resources/js/jquery.serializeObject.js"></script>
</head>
<body>	
		<div id="postUploadDiv">
	<form action="board/postUpload" name="puform" id="puform" method="post" enctype="multipart/form-data">
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
	${makeBList}
	</div>
	
	<div align="center">${paging}</div>
	<div id="articleView_layer">
		<div id="bg_layer"></div>
		<div id="contents_layer"></div>
	</div>
	
	
	
</body>  --%>

	<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta name="description" content="This is social network html5 template available in themeforest......" />
		<meta name="keywords" content="Social Network, Social Media, Make Friends, Newsfeed, Profile Page" />
		<meta name="robots" content="index, follow" />
		<title>News Feed | Check what your friends are doing</title>
	
	<!-- 이미지 슬라이드
	================================================= -->
	<link href="${pageContext.request.contextPath}/resources/css/js-image-slider.css" rel="stylesheet" type="text/css" />
    <script src="<c:url value="/resources/js/js-image-slider.js" />" type="text/javascript"></script>
    <link href="${pageContext.request.contextPath}/resources/css/generic.css" rel="stylesheet" type="text/css" />
		
	
	
    <!-- Stylesheets
    ================================================= -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/ionicons.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/font-awesome.min.css">
      <link href="${pageContext.request.contextPath}/resources/css/emoji.css" rel="stylesheet">
      
    
    <!--Google Font-->
    <link href="https://fonts.googleapis.com/css?family=Lato:300,400,400i,700,700i" rel="stylesheet">
    
    <!--Favicon-->
    <link rel="shortcut icon" type="image/png" href="${pageContext.request.contextPath}/resources/images/fav.png"/>
	<style>
	.imgSelect {
		cursor: pointer;
	}

	.popupLayer {
		position: absolute;
		display: none;
		background-color: #ffffff;
		border: solid 2px #d0d0d0;
		width: 150px;
		height: 100px;
		padding: 10px;
	}
	.popupLayer div {
		position: absolute;
		top: 5px;
		right: 5px
	}
	#bu_files {
		 display:none;
	}
	#bu_filesimg {
		 cursor:pointer;
	}
	</style>
	
	
	</head>
  <body>

    

    <div id="page-contents">
    	<div class="container">
    		<div class="row">

          <!-- Newsfeed Common Side Bar Left
          ================================================= -->
    			<div class="col-md-3 static">
            <div class="profile-card">
            	<img src="http://placehold.it/300x300" alt="user" class="profile-photo" />
            	<h5><a href="timeline.html" class="text-white">Sarah Cruiz</a></h5>
            	<a href="#" class="text-white"><i class="ion ion-android-person-add"></i> 1,299 followers</a>
            </div><!--profile card ends-->
            <ul class="nav-news-feed">
              <li><i class="icon ion-ios-paper"></i><div><a href="newsfeed.html">My Newsfeed</a></div></li>
              <li><i class="icon ion-ios-people"></i><div><a href="newsfeed-people-nearby.html">People Nearby</a></div></li>
              <li><i class="icon ion-ios-people-outline"></i><div><a href="newsfeed-friends.html">Friends</a></div></li>
              <li><i class="icon ion-chatboxes"></i><div><a href="newsfeed-messages.html">Messages</a></div></li>
              <li><i class="icon ion-images"></i><div><a href="newsfeed-images.html">Images</a></div></li>
              <li><i class="icon ion-ios-videocam"></i><div><a href="newsfeed-videos.html">Videos</a></div></li>
            </ul><!--news-feed links ends-->
            <div id="chat-block">
              <div class="title">Chat online</div>
              <ul class="online-users list-inline">
                <li><a href="newsfeed-messages.html" title="Linda Lohan"><img src="http://placehold.it/300x300" alt="user" class="img-responsive profile-photo" /><span class="online-dot"></span></a></li>
                <li><a href="newsfeed-messages.html" title="Sophia Lee"><img src="http://placehold.it/300x300" alt="user" class="img-responsive profile-photo" /><span class="online-dot"></span></a></li>
                <li><a href="newsfeed-messages.html" title="John Doe"><img src="http://placehold.it/300x300" alt="user" class="img-responsive profile-photo" /><span class="online-dot"></span></a></li>
                <li><a href="newsfeed-messages.html" title="Alexis Clark"><img src="http://placehold.it/300x300" alt="user" class="img-responsive profile-photo" /><span class="online-dot"></span></a></li>
                <li><a href="newsfeed-messages.html" title="James Carter"><img src="http://placehold.it/300x300" alt="user" class="img-responsive profile-photo" /><span class="online-dot"></span></a></li>
                <li><a href="newsfeed-messages.html" title="Robert Cook"><img src="http://placehold.it/300x300" alt="user" class="img-responsive profile-photo" /><span class="online-dot"></span></a></li>
                <li><a href="newsfeed-messages.html" title="Richard Bell"><img src="http://placehold.it/300x300" alt="user" class="img-responsive profile-photo" /><span class="online-dot"></span></a></li>
                <li><a href="newsfeed-messages.html" title="Anna Young"><img src="http://placehold.it/300x300" alt="user" class="img-responsive profile-photo" /><span class="online-dot"></span></a></li>
                <li><a href="newsfeed-messages.html" title="Julia Cox"><img src="http://placehold.it/300x300" alt="user" class="img-responsive profile-photo" /><span class="online-dot"></span></a></li>
              </ul>
            </div><!--chat block ends-->
          </div>
          
    			<div class="col-md-8">

            <!-- Post Create Box
            ================================================= -->
            <div id="image-holder"></div>
            <form action="/postUpload" name="puform" id="puform" method="post" enctype="multipart/form-data">
             <div class="create-post">
            	<div class="row">
            		<div class="col-md-7 col-sm-7">
                  <div class="form-group">
                    <img src="http://placehold.it/300x300" alt="" class="profile-photo-md" />
                    <textarea name="b_content" id="exampleTextarea" cols="30" rows="1" class="form-control" placeholder="Write what you wish"></textarea>
                  </div>
                </div>
            		<div class="col-md-5 col-sm-5">
                  <div class="tools">
                    <ul class="publishing-tools list-inline">
                      <li><a class="imgSelect"><i class="ion-compose"></i></a></li>	
                      <li><a onclick="check()" id="bu_filesimg"><i class="ion-images"></i></a>
                      <input type="file" name="bu_files" id="bu_files"  multiple />
                      </li>
                      <li><a onclick="check()"><i class="ion-ios-videocam"></i></a></li>
                      <li><a href="#"><i class="ion-map"></i></a></li>
                    </ul>
                    <div class="popupLayer">
								<div>
									<span onClick="closeLayer(this)" style="cursor:pointer; font-size:1.5em;;" title="닫기">X</span>
								</div>
							 	<input type="radio" name="b_openlv" value=0 />공개 <br/>
								<input type="radio" name="b_openlv" value=1 />친구만 공개 <br/>
								<input type="radio" name="b_openlv" value=2 />비공개
						</div> 
                    <button class="btn btn-primary pull-right">글쓰기</button>
                  </div>
                </div>
            	</div>
            </div>
            </form>
          <!--  Post Create Box End -->
				
			<div id="postUploadDiv">
	<form action="/postUpload" name="puform" id="puform" method="post" enctype="multipart/form-data">
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
			<!-- <div id="image-holder"></div> -->
			<!-- <img id="blah" src="#" alt="your image" /> -->
			</td>
			<tr>
		</table>
	</form>
	</div>
				
            <!-- Post Content
            ================================================= -->
           
			<%-- <div class="col-md-12 col-sm-12" id="boardPeed" style="float:right; width:700;">
					${makeBList}
			</div> --%>
            <c:forEach var="b" items="${blist}">
          <div class='post-content'>
          	<%--  <c:forEach var="bu" items="${bulist}">
               <c:set var="code" value="${bu.bu_code}" />
          		 <c:if test="${b.b_no eq code}">
					<img width='200' height='200' src='${bu.bu_path}${bu.bu_filesys}' alt='post-image' class='img-responsive post-image' />
				 </c:if> 
			</c:forEach>  --%>
              <div class='post-container'>
                <img src='http://placehold.it/300x300' alt='user' class='profile-photo-md pull-left' />
                <div class='post-detail'>
                  <div class='user-info'>
                    <h5><a href='timeline.html' class='profile-link'>${b.b_mbid}</a> <span class='following'>${b.b_flno}</span></h5>
                    <p class='text-muted'>${b.b_date}</p>
                  </div>
                  <div class='reaction'>
                    <a class='btn text-green'><i class='icon ion-thumbsup'></i>숫자 정리</a>
                  </div> 
                  <div class='line-divider'></div>
                   <c:forEach var="bu" items="${bulist}">
              			 <c:set var="code" value="${bu.bu_code}" />
          					 <c:if test="${b.b_no eq code}">
								<img src='${bu.bu_path}${bu.bu_filesys}' alt='post-image' class='img-responsive post-image' />
							 </c:if> 
					</c:forEach> 
                  <div class='post-text'>
                    <p>${b.b_content}</p>
                  </div>
                  <div class="line-divider"><h5>댓글</h5></div>
                  <div id=replyList>
                  <c:forEach var="r" items="${rList}">
          				 <c:if test="${r.r_bno eq b.b_no}">
                   				<div class="post-comment">
                   				 <img src="http://placehold.it/300x300" alt="" class="profile-photo-sm" />
                 				   <p><a href="timeline.html" class="profile-link">${r.r_mbid}</a>${r.r_content}</p>
                 				 </div>
                		  </c:if> 
					</c:forEach> 
					</div>
					&nbsp;&nbsp;
					<form id="rForm" name='rForm'>
					<div class="post-comment">
                    <img src="http://placehold.it/300x300" alt="" class="profile-photo-sm" />
                    <input type="text" name="r_content" id="r_content" class="form-control" placeholder="Post a comment">
                  	<span><input type="button" value="입력" id="btn" onclick="replyInsert('${b .b_no}')"
							style="width: 60px; height: 45px"></span>
                  </div>
					</form>

		<%-- onclick="reply(${b.b_no})" --%>
	
                </div>
              </div>
            </div>
		</c:forEach>
		</div>
		</div>
		</div>
		</div>
		
    <!-- Scripts
    ================================================= -->
   <!-- <script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCTMXfmDn0VlqWIyoOxK8997L-amWbUPiQ&callback=initMap"></script> -->
   <script src="<c:url value="/resources/js/jquery-3.1.1.min.js" />"></script>
   <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
   <script src="<c:url value="/resources/js/jquery.sticky-kit.min.js" />"></script>
   <script src="<c:url value="/resources/js/jquery.scrollbar.min.js" />"></script>
   <script src="<c:url value="/resources/js/script.js" />"></script>
 
 	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="resources/js/jquery.serializeObject.js"></script>
 
 
 	<!-- div 뛰우기~~~ -->
 	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
 
  </body>
<script type="text/javascript">
function replyInsert(bno) {
	var obj = $('#rForm').serializeObject(); //{속성:값,속성:값}
	obj.r_bno = bno;
	console.log(obj);
	$.ajax({
		type : 'post', //json으로 넘길땐 get은 안됨.
		url : 'ajax/replyInsert',
		data : obj,
		dataType : 'json',
		success : function(data) {
			console.log(data);
			console.log(data.rList);
			var rlist='';
			for(var i=0;i<data.rList.length;i++){
				rlist+=' 아이디 : '+data.rList[i].r_mbid
					+' 내용 : '+data.rList[i].r_content
					+' 날짜 : '+data.rList[i].r_date+'<br/>'
					+"<a href='#'>답글달기</a>"
					+"<a href='#'>신고하기</a><br/><hr>";
				//var parsed = $.parseHTML(data);
				/* console.log(parsed);
				console.log(parsed[39]);
				$('#replyList').html(parsed[39]);
				alert("가져왔어용 ㅎㅎ"); */
			};
			$('#replyList').html(rlist);
		},
		error : function(error,xhr,status) {
			alert("error")
			console.log(xhr);
			console.log(status);
		}
	});//ajax End
};


        //The following script is for the group 2 navigation buttons.
         function switchAutoAdvance() {
            imageSlider.switchAuto();
            switchPlayPauseClass();
        }
        function switchPlayPauseClass() {
            var auto = document.getElementById('auto');
            var isAutoPlay = imageSlider.getAuto();
            auto.className = isAutoPlay ? "group2-Pause" : "group2-Play";
            auto.title = isAutoPlay ? "Pause" : "Play";
        }
        switchPlayPauseClass();
    </script> 

<script> 

/**이벤트 발생 (크롬,파이어폭스,사파이어 OK!) **/
 function eventOccur(evEle, evType){
 	if (evEle.fireEvent) {
	 evEle.fireEvent('on' + evType);
 	} else {
 	//MouseEvents가 포인트 그냥 Events는 안됨~ ??
	 var mouseEvent = document.createEvent('MouseEvents');
	//  API문서 initEvent(type,bubbles,cancelable) 
 	mouseEvent.initEvent(evType, true, false);
	 var transCheck = evEle.dispatchEvent(mouseEvent);
	 if (!transCheck) {
	 //만약 이벤트에 실패했다면
 	console.log("클릭 이벤트 발생 실패!");
 	}
  }
} 
/** 대체버튼 클릭시 강제 이벤트 발생**/
function check(){
	 eventOccur(document.getElementById('bu_files'),'click');
 	/* alert(orgFile.value); 이벤트 처리가 끝나지 않은 타이밍이라 값 확인 안됨! 시간차 문제 */
}

function closeLayer( obj ) {
	$(obj).parent().parent().hide();
}

$(function(){

	/* 클릭 클릭시 클릭을 클릭한 위치 근처에 레이어가 나타난다. */
	$('.imgSelect').click(function(e)
	{
		var sWidth = window.innerWidth;
		var sHeight = window.innerHeight;

		var oWidth = $('.popupLayer').width();
		var oHeight = $('.popupLayer').height();

		// 레이어가 나타날 위치를 셋팅한다.
		var divLeft = e.clientX + 10;
		var divTop = e.clientY + 5;

		// 레이어가 화면 크기를 벗어나면 위치를 바꾸어 배치한다.
		if( divLeft + oWidth > sWidth ) divLeft -= oWidth;
		if( divTop + oHeight > sHeight ) divTop -= oHeight;

		// 레이어 위치를 바꾸었더니 상단기준점(0,0) 밖으로 벗어난다면 상단기준점(0,0)에 배치하자.
		if( divLeft < 0 ) divLeft = 0;
		if( divTop < 0 ) divTop = 0;

		$('.popupLayer').css({
			"top": '10',
			"left": '10',
			"position": "absolute"
		}).show();
	});

});

$(document).ready(function() {
	$.ajax({
		url: 'getBoardList',
		type: 'POST',
		dataType:'html',
		success: function(data){
			//alert("로딩 성공.");
			$('#boardPeed').append(data);
			},
		error: function(error){
			alert("error"); 
			}
		});  // ajax end
});

function postInfo(b_no){
	$('#articleView_layer').addClass('open');
	$.ajax({
		type:'get',
		url:'postInfo',
		data:{b_no:b_no},
		dataType:'html',
		success:function(data){
			//alert(data);
			$('#contents_layer').html(data); 
		},
		error:function(error){
			alert('error');
			console.log(error);
		}
	}); //ajax End
}//function End


//LightBox 해제
var $layerWindow=$('#articleView_layer');
$layerWindow.find('#bg_layer').on('mousedown',function(event){
	$layerWindow.removeClass('open');
	location.reload();
	$(window).scrollTop(window.oriScroll);
	return;
});//on End
$(document).keydown(function(event){
	console.log(event);
	if(event.keyCode!=27) return;
	if($layerWindow.hasClass('open')){
		$layerWindow.removeClass('open');
		location.reroad();
	}
});//keydown End




/* $(function(){ $("#btn").click(function(){
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
	
}); */


/* $(document).on("change", ".file_multi_video", function(evt) {
	  var $source = $('#video_here');
	  $source[0].src = URL.createObjectURL(this.files[0]);
	  $source.parent()[0].load();
	}); */
	
function back(){
		var form = $('#pufrom');
		form.attr("action","gopostUploadPg");
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