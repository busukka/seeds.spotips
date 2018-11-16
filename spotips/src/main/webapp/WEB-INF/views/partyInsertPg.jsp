<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="resources/js/jquery.serializeObject.js"></script>

<script>
	/* 모임 생성 실패/성공 메시지 */
	if(${insertCheck}){
		alert("모임 만들기 끝.");
	}else{
		alert("모임 만들기 실패.");
	}
</script>

<!-- 체크박스 단일선택 -->
<script type="text/javascript">
$(document).ready(function() {
    //라디오 요소처럼 동작시킬 체크박스 그룹 셀렉터
    $('input[type="checkbox"][name="fl_no"]').click(function(){
        //클릭 이벤트 발생한 요소가 체크 상태인 경우
        if ($(this).prop('checked')) {
            //체크박스 그룹의 요소 전체를 체크 해제후 클릭한 요소 체크 상태지정
            $('input[type="checkbox"][name="fl_no"]').prop('checked', false);
            $(this).prop('checked', true);
        }
    });
});
</script>
<!-- 부트3 -->
<!-- 합쳐지고 최소화된 최신 CSS -->
<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous"> -->
<!-- 부가적인 테마 -->
<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous"> -->
<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<!-- <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script> -->

<%-- <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/datepicker3.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/bootstrap-datepicker.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/bootstrap-datepicker.kr.js"></script> --%>
<!-- 부트4 -->
<!-- <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script> -->

<meta charset="UTF-8">
<style>
</style>
<title>새 모임 만들기페이지</title>
</head>
<body>
<h1>partyInsertPg.jsp</h1>
	<form action="insertParty" method="post" enctype="multipart/form-data">
		<table>
			<tr align="center">
				<td colspan="2"><h3>새모임 만들기</h3></td>
			</tr>
			<tr>
				<td><span>모임명:</span></td>
				<td><input type="text" name="p_name"  /></td>
			</tr>
			<tr>
				<td>모임분야</td>
				<td>
					${FLCheckBoxHTML}
				</td>
			</tr>
			<tr>
				<td>파일 첨부</td>
				<td><input type="file" name="bu_files" id="bu_files"  multiple /></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea name="p_content"></textarea></td>
			</tr>
			<tr>
				<td>모임시작시간</td>
				<td><input id="fromDate" type="date" name="p_sdate"></td>
				<td><input id="fromDate" type="time" name="p_sdate"></td>
			</tr>
			<tr>
				<td>모임종료시간</td>
				<td><input id="toDate" type="date" name="p_edate"></td>
				<td><input id="toDate" type="time" name="p_edate"></td>
			</tr>
			<tr>
				<td>모임장소</td>
				<td><input type="text" id="sample5_address" name="p_place" placeholder="주소"></td>
				<td><input type="button" onclick="sample5_execDaumPostcode()" value="주소 검색"><br></td>
			</tr>
		</table>
			<div id="map" style="width:300px;height:300px;margin-top:10px;display:none"></div>
			<div>
			<table>
				<tr>
					<td>모임 총 인원:</td>
					<td><input type="number" name="p_total" min="2"></td>
				</tr>
				<tr>
					<td>
						<input type="submit" value="만들기"/>
						<input type="button" value="뒤로가기" onclick="goPartyMainPg()"/>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<div id="image-holder"></div>
					</td>
				</tr>				
				
			</table>
			</div>
	</form>
	
	
</body>
<script type="text/javascript">
	function goPartyMainPg() {
		location.href="goPartyMainPg";
		}
</script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script src="//dapi.kakao.com/v2/maps/sdk.js?appkey=69eb5951c78c6e30d13371423dd58389&libraries=services"></script>
<script type="text/javascript">
$("#bu_files").on('change', function () {
	
    //Get count of selected files
    var countFiles = $(this)[0].files.length;

    var imgPath = $(this)[0].value;
    var extn = imgPath.substring(imgPath.lastIndexOf('.') + 1).toLowerCase();
    var image_holder = $("#image-holder");
    image_holder.empty();

    if (extn == "gif" || extn == "png" || extn == "jpg" || extn == "jpeg" ){
        if (typeof (FileReader) != "undefined") {//파일리더는 익스플로러9이상이나 크롬에서만 지원한다.

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

</script>
<script>
    var mapContainer = document.getElementById('map'), // 지도를 표시할 div
        mapOption = {
            center: new daum.maps.LatLng(37.537187, 127.005476), // 지도의 중심좌표
            level: 5 // 지도의 확대 레벨
        };

    //지도를 미리 생성
    var map = new daum.maps.Map(mapContainer, mapOption);
    //주소-좌표 변환 객체를 생성
    var geocoder = new daum.maps.services.Geocoder();
    //마커를 미리 생성
    var marker = new daum.maps.Marker({
        position: new daum.maps.LatLng(37.537187, 127.005476),
        map: map
    });


    function sample5_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var fullAddr = data.address; // 최종 주소 변수
                var extraAddr = ''; // 조합형 주소 변수

                // 기본 주소가 도로명 타입일때 조합한다.
                if(data.addressType === 'R'){
                    //법정동명이 있을 경우 추가한다.
                    if(data.bname !== ''){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있을 경우 추가한다.
                    if(data.buildingName !== ''){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
                    fullAddr += (extraAddr !== '' ? ' ('+ extraAddr +')' : '');
                }

                // 주소 정보를 해당 필드에 넣는다.
                document.getElementById("sample5_address").value = fullAddr;
                // 주소로 상세 정보를 검색
                geocoder.addressSearch(data.address, function(results, status) {
                    // 정상적으로 검색이 완료됐으면
                    if (status === daum.maps.services.Status.OK) {

                        var result = results[0]; //첫번째 결과의 값을 활용

                        // 해당 주소에 대한 좌표를 받아서
                        var coords = new daum.maps.LatLng(result.y, result.x);
                        // 지도를 보여준다.
                        mapContainer.style.display = "block";
                        map.relayout();
                        // 지도 중심을 변경한다.
                        map.setCenter(coords);
                        // 마커를 결과값으로 받은 위치로 옮긴다.
                        marker.setPosition(coords)
                    }
                });
            }
        }).open();
    }
</script>
</html>