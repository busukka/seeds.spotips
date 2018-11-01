<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
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
				관리자 ml_mid
			</div>
			<div>
				<ul>
					<li>목록</li>
					<li><a href="genManagement">일반회원관리</a></li>
					<!-- ajax -->
					<li><a href="busManagement">기업회원관리</a></li>
					<!-- ajax -->
					<li><a href="adminConcern">관심분야관리</a></li>
					<!-- ajax -->
					<li><a href="genBlackList">일반회원 블랙리스트 관리</a></li>
					<!-- ajax -->
					<li><a href="busBlackList">기업회원 블랙리스트 관리</a></li>
					<!-- ajax -->
					<li><a href="reportManagement">신고관리</a></li>
					<!-- ajax -->
					<li><a href="partyManagement">모임관리</a></li>
					<!-- ajax -->
				</ul>
			</div>




	</div>

	<div>
		<jsp:include page="showView.jsp"></jsp:include>
	</div>

</body>
</html>
























