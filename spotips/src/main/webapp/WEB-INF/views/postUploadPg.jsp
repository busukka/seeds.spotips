<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

	<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta name="description" content="This is social network html5 template available in themeforest......" />
		<meta name="keywords" content="Social Network, Social Media, Make Friends, Newsfeed, Profile Page" />
		<meta name="robots" content="index, follow" />
		<title>News Feed | Check what your friends are doing</title>
		
	
	
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
	.rr_comment{
		display: none;
	}
	.reform-control{
 		 background: #fff;
		  border: 1px solid #f1f2f2;
		  box-shadow: none;
		  border-radius: 4px;
		  color: #939598;
		  width: 85% !important;
	}
	
	.publicSelect {
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
	.fieldSelect {
		cursor: pointer;
	}

	.popupLayer2 {
		position: absolute;
		display: none;
		background-color: #ffffff;
		border: solid 2px #d0d0d0;
		width: 300px;
		height: 150px;
		padding: 10px;
	}
	.popupLayer2 div {
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

 	<jsp:include page="nav.jsp"></jsp:include>

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
              <li><i class="icon ion-ios-paper"></i><div><a href="javascript:void(0)" onclick="showBoardFeed()">게시물</a></div></li>
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

            <form  name="puform" id="puform" method="post" enctype="multipart/form-data">
             <div class="create-post">
            	<div class="row">
            		<div class="col-md-7 col-sm-7">
                  <div class="form-group">
                    <img src="http://placehold.it/300x300" alt="" class="profile-photo-md" />
                    <textarea name="b_content" id="exampleTextarea" cols="30" rows="1" class="form-control" placeholder="당신은 지금
                    	무슨 생각을 하고 있나요?"></textarea>
                  </div>
                </div>
            		<div class="col-md-5 col-sm-5">
                  <div class="tools">
                    <ul class="publishing-tools list-inline">
                      <li><a class="publicSelect"><i class="icon ion-person-stalker"></i></a></li>	
                      <li><a onclick="check()" id="bu_filesimg"><i class="ion-images"></i></a>
                      <input type="file" name="bu_files" id="bu_files"   multiple />
                      </li>
                     <!--  <li><a onclick="check()" id="bu_filesvdo"><i class="ion-ios-videocam"></i></a></li> -->
                      <li><a class="fieldSelect"><i class="ion-ios-football"></i></a></li>
                    </ul>
                    <div class="popupLayer" style="z-index:3;">
								<div>
									<span onClick="closeLayer(this)" style="cursor:pointer; font-size:1.5em;;" title="닫기">X</span>
								</div>
							 	<input type="radio" name="b_openlv" value=0 />공개 <br/>
								<input type="radio" name="b_openlv" value=1 />친구만 공개 <br/>
								<input type="radio" name="b_openlv" value=2 />비공개
						</div>
                    <div class="popupLayer2" style="z-index:4;">
								<div>
									<span onClick="closeLayer(this)" style="cursor:pointer; font-size:1.5em;;" title="닫기">X</span>
								</div>
								${FLCheckBoxHTML}
						</div>
                    <button id="postUp" class="btn btn-primary pull-right">글쓰기</button>
                  </div>
                </div>
            	</div>
            </div>
            </form>
          <!--  Post Create Box End -->

				
            <!-- Post Content
            ================================================= -->
           
			<%-- <div class="col-md-12 col-sm-12" id="boardPeed" style="float:right; width:700;">
					${makeBList}
			</div> --%>
			<div class='feed-content' id='feed-content'>
          
		 </div>
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
 
 	
 
 
 	<!-- div 뛰우기~~~ -->
 	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
 
  </body>

<script> 

function showrere_coment(key){
	/* $('#'+bno+rno+'rr_coment').style.display = 'block'; */
	//console.log($('#'+key+'rr_coment'));
	$('#'+key+'r_comment').show();
	$('#'+key+'r_content').show();
	$('#'+key+'btn').show();
	console.log("$(key+'rr_comment')="+$(key+'r_comment').css('display','block'));
	console.log("$(key+'r_content')="+$(key+'r_content').css('display','block'));
	console.log("$(key+'btn')="+$(key+'btn').css('display','block'));
	/* $(key+'rr_comment').css('display','block');
	$(key+'r_content').css('display','block');
	$(key+'btn').css('display','block'); */
	
};



$(document).ready(function() {
	$.ajax({
		url: 'getBoardList',
		type: 'POST',
		dataType:'html',
		success: function(data){
			//alert("로딩 성공.");
			$('#feed-content').html(data);
			},
		error: function(error){
			alert("error"); 
			}
		});  // ajax end
});

function showBoardFeed(){
	$.ajax({
		url: 'getBoardList',
		type: 'POST',
		dataType:'html',
		success: function(data){
			//alert("로딩 성공.");
			$('#feed-content').html(data);
			},
		error: function(error){
			alert("error"); 
			}
		});  // ajax end
};


function replyInsert(b_no,rCheck) {
	var tagId='#'+b_no+'r_content';
	var r_content = $(tagId).val();
	 $.ajax({
		type : 'post', //json으로 넘길땐 get은 안됨.
		url : 'ajax/replyInsert',
		data : {b_no : b_no , r_content : r_content , rCheck : rCheck},
		dataType : 'json',
		success : function(data) {
			console.log(data);
			console.log(data[0].mList[0].mb_imgsysname);//==mList
			console.log(data[1]);//==rList
			var Member=data[0].mList[0];
			
			var rlist="";
			  for(var i=0;i<data[1].rList.length;i++){
				  if(data[1].rList[i].r_no%1.0==0){
				 var Member;
				 for(var j=0;j<data[0].mList.length;j++){
					if( data[1].rList[i].r_mbid==data[0].mList[j].mb_id){
						Member=data[0].mList[j];
					}//if end
				 }//mList for end
				 var r_no=parseInt(data[1].rList[i].r_no);
				 rlist+="<div class='row' id='"+b_no+data[1].rList[i].r_no+"'>"+
							"<div class='row'> " + 
							"		<div class='col-md-9 col-sm-9' style='float: left;'> " + 
							"			<img src='resources/upload/"+Member.mb_imgsysname+"' alt='' " + 
							"				class='profile-photo-sm' /> <a href='timeline.html' " + 
							"				class='profile-link'>"+Member.mb_name+"</a> " + 
							"	&nbsp;&nbsp;&nbsp;&nbsp;	"+data[1].rList[i].r_content+"</div> " + 
							"		<div class='col-md-3 col-sm-3' style='float: right;'> " + 
							"			<p style='text-align: right'>"+data[1].rList[i].r_date+"<br /> "+ 
							"				 <a href='javascript:void(0)' id='"+b_no+r_no+"showrere_coment' "+ 
							"							onclick=\"showrere_coment("+
							"					'"+b_no+r_no+"')	\" "+
							"					>답글달기</a>&nbsp;&nbsp; " + 
							"				<a href='#'>신고하기</a> " + 
							"			</p> " + 
							"		</div> " + 
							"	</div> "+
							"</div>"+
							"<div id='"+b_no+r_no+"reReplyList'>";
				  };//if end
				 for(var k=0; data[1].rList.length>k;k++) {
						if(parseInt(data[1].rList[i].r_no)==parseInt(data[1].rList[k].r_no))
						if(data[1].rList[k].r_no%1.0!=0) {
							for(var l=0;l<data[0].mList.length;l++){
								if( data[1].rList[k].r_mbid==data[0].mList[l].mb_id){
									Member=data[0].mList[l];
								}//if end
							 }//mList for end
				 rlist+="<div class='row'> " + 
						"		<div class='col-md-1 col-sm-1'></div> " + 
						"		<div class='col-md-3 col-sm-3' style='float: left;'> " +
						"			<i class='icon ion-ios-redo'></i>"+
						"					<img src='"+Member.mb_imgsysname+"' alt='' " + 
						"						class='profile-photo-sm' /> <a href='timeline.html' " + 
						"						class='profile-link'>"+Member.mb_name+"</a> " + 
						"		</div> " + 
						"		<div class='col-md-5 col-sm-5'>"+data[1].rList[k].r_content+"</div> " + 
						"		<div class='col-md-3 col-sm-3' style='float: right;'> " + 
						"			<p style='text-align: right'>"+data[1].rList[k].r_date+"<br /> <a href='#'>신고하기</a> " + 
						"			</p> " + 
						"		</div> " + 
						"	</div> ";
						}// 답글인지
					}//답글 for 문 end
						 rlist+="</div></div>"+
								"<div id='"+b_no+r_no+"rr_comment'"+ 
								"			class='rr_comment' >${id}보드매니지먼트179줄 수정 해서 닉네임으로 바꾸기"+
								"	<input type='text' name='"+b_no+r_no+"r_content'"+
								" 						id='"+b_no+r_no+"r_content' " +
								"	class='reform-control' placeholder='답글을 입력해주세요' style='display:none;'>	"+
								"	<span><input type='button' value='입력' id='"+b_no+r_no+"btn'" + 
								"	onclick=\"replyInsert('"+b_no+r_no+"',"+b_no.length+")\" style='display:none;' ></span> "+ 
								"	</div>	";
			 };//rList for end 
			 $('#'+b_no+'replyList').html(rlist);
		},
		error : function(error,xhr,status) {
			alert("error")
			console.log(xhr);
			console.log(status);
		}
	});//ajax End 
};





/**이벤트 발생 (크롬,파이어폭스,사파이어 OK!) **/
 function eventOccur(files, Type){
	
 	if (files.fireEvent) {
	 files.fireEvent('on' + Type);
 	} else {
 	//MouseEvents가 포인트 그냥 Events는 안됨~ ??
	 var mouseEvent = document.createEvent('MouseEvents');
	//  API문서 initEvent(type,bubbles,cancelable) 
 	mouseEvent.initEvent(Type, true, false);
	 var transCheck = files.dispatchEvent(mouseEvent);
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
	$('.publicSelect').click(function(e)
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
$(function(){
	/* 클릭 클릭시 클릭을 클릭한 위치 근처에 레이어가 나타난다. */
	$('.fieldSelect').click(function(e)
	{
		var sWidth = window.innerWidth;
		var sHeight = window.innerHeight;

		var oWidth = $('.popupLayer2').width();
		var oHeight = $('.popupLayer2').height();

		// 레이어가 나타날 위치를 셋팅한다.
		var divLeft = e.clientX + 10;
		var divTop = e.clientY + 5;

		// 레이어가 화면 크기를 벗어나면 위치를 바꾸어 배치한다.
		if( divLeft + oWidth > sWidth ) divLeft -= oWidth;
		if( divTop + oHeight > sHeight ) divTop -= oHeight;

		// 레이어 위치를 바꾸었더니 상단기준점(0,0) 밖으로 벗어난다면 상단기준점(0,0)에 배치하자.
		if( divLeft < 0 ) divLeft = 0;
		if( divTop < 0 ) divTop = 0;

		$('.popupLayer2').css({
			"top": '10',
			"left": '10',
			"position": "absolute"
		}).show();
	});
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




 $(function(){ $("#postUp").click(function(){
	var formData = new FormData();
	formData.append("b_openlv", $("input[name=b_openlv]:checked").val());
	formData.append("b_flno", $("input[name=b_flno]:checked").val());
	var countFiles = $("input[name=bu_files]")[0].files.length;
	for(var i=0;i<countFiles ;i++){
	formData.append("bu_files", $("input[name=bu_files]")[0].files[i]);
	}
	formData.append("b_content", $("textarea[name=b_content]").val());
	
	
	 $.ajax({
		url: 'ajax/postUpload',
		data: formData, 
		processData: false, 
		contentType: false, 
		type: 'POST',
		dataType:'html',
		success: function(data){
			//alert("글을 올리는데 성공하셨습니다.");
			$('#feed-content').html(data);
			var agent = navigator.userAgent.toLowerCase();
	        if ( (navigator.appName == 'Netscape' && navigator.userAgent.search('Trident') != -1) || (agent.indexOf("msie") != -1) ) {
	        	$('#postUpload').replaceWith($('#bu_files').clone(true));
	        } else { // other browser 일때 
	        	$('#postUpload').val('');
	        }//if end
			},
		error: function(error){
			//alert("error"); 
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
		form.attr("action","gopostUploadPg");
	}
	
	$(document).on("change", ".file_multi_video", function(evt) {
		  
		});
	
/* function deleteImageAction(index){
	console.log("index : "+index);
	var Files = $('#bu_files')[0];
	fileArr.splice(index,1);
	
	var img_id="#img_id_"+index;
	$(img_id).remove();
	console.log(Files);

	
}; */

/* var fileArr=[];  */
$("#bu_files").on('change', function () {
	
    //Get count of selected files
    var countFiles = $(this)[0].files.length;
    
    var imgPath = $(this)[0].value;
    var extn = imgPath.substring(imgPath.lastIndexOf('.') + 1).toLowerCase();
   	console.log('extn='+extn);
     var image_holder = $("#image-holder");
    image_holder.empty(); 
    
    if (typeof (FileReader) != "undefined") {//파일리더는 익스플로러9이상이나 크롬에서만 지원한다.
    if (extn == "gif" || extn == "png" || extn == "jpg" || extn == "jpeg" ){
         
		
            for (var i = 0; i < countFiles; i++) {
                var reader = new FileReader();
                reader.onload = function (e) {
                 /*   var html="<a href='javascript:void(0);' onclick='deleteImageAction("+index+")'"+
                   "id='img_id_"+index+"'><img src='"+e.target.result+"' width='200px' height='200px'"+
                   "class='thumb-image' ></a>";
                   image_holder.append(html);
                   index++; */
                	 $("<img />", {
                        "src": e.target.result,
                            "class": "thumb-image",
                            "width": "200",
                            "height": "200",
                          
                    }).appendTo(image_holder); 
                }
                image_holder.show();
                reader.readAsDataURL($(this)[0].files[i]);
            }
        
        
    }else if(extn == "avi" || extn == "mp3" || extn == "wmv" || extn == "mpeg" || extn == "mpg" ||
    	     extn == "mov" || extn == "swf" || extn == "flv" || extn == "tp" || extn == "ts"){
	 
    	
		 } else {
        alert("이미지나 동영상 파일 형식만 가능합니다.");
        var agent = navigator.userAgent.toLowerCase();
        if ( (navigator.appName == 'Netscape' && navigator.userAgent.search('Trident') != -1) || (agent.indexOf("msie") != -1) ) {
        	$('#bu_files').replaceWith($('#bu_files').clone(true));
        } else { // other browser 일때 
        	$('#bu_files').val('');
        }//if end
    }
    } else {
        alert("상위 버전의 브라우저를 사용하시면 미리보기를 사용하실수 있습니다.");
    }
    
});




	/*  extn == "avi" || extn == "mp3" || extn == "wmv" || extn == "mpeg" || extn == "mpg" ||
     extn == "mov" || extn == "swf" || extn == "flv" || extn == "tp" || extn == "ts"  */
	     

</script>


</html>