<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spotips 관리자 페이지</title>
</head>
<body>

	<jsp:include page="nav.jsp"></jsp:include>
	<div>
		<h3>Spotips 관리자 페이지</h3>
		
			<div>
				<img src="" width="" height="">
				<!-- 관리자 프로필 사진 -->
				<%-- ${mg_id } --%>
			</div>
			<div>
				<ul>
					<li>목록</li> <!-- 경로 잡리스트 기능이름으로 바꿔주기 -->
					<li><a href="loadGenList">일반회원관리</a></li> <!-- 하는중 // (일반회원 조회(검색) 해야 함!!!! -->
					<!-- ajax -->
					<li><a href="busManagementPg">기업회원관리</a></li>
					<!-- ajax -->
					<li><a href="adminConcernPg">관심분야관리</a></li>
					<!-- ajax -->
					<li><a href="genBlackListPg">일반회원 블랙리스트 관리</a></li>
					<!-- ajax -->
					<li><a href="busBlackListPg">기업회원 블랙리스트 관리</a></li>
					<!-- ajax -->
					<li><a href="reportManagementPg">신고관리</a></li>
					<!-- ajax -->
					<li><a href="partyManagementPg">모임관리</a></li>
					<!-- ajax -->
				</ul>
			</div>

		<jsp:include page="showView.jsp"></jsp:include>
	</div>

</body>
</html>
























