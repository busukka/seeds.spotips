<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
/* 기본 설정*/
a {
	text-decoration: none;
	color: #000000;
}

a:hover {
	color: #ff0000;
}

/* nav tag */
nav ul {
	padding-top: 10px;
} /*  상단 여백 10px  */
nav ul li {
	display: inline; /*  세로나열을 가로나열로 변경 */
	border-left: 1px solid #999; /* 각 메뉴의 왼쪽에 "|" 표시(분류 표시) */
	font: bold 12px Dotum; /* 폰트 설정 - 12px의 돋움체 굵은 글씨로 표시 */
	padding: 0 10px; /* 각 메뉴 간격 */
}

nav ul li:first-child {
	border-left: none;
} /* 메뉴 분류중 제일 왼쪽의 "|"는 삭제*/
</style>
<title>nav.jsp</title>
</head>
<body>
	<!-- 로고, 프로필사진, 이름, 알림, 친구추천, 채팅, 개인정보수정 -->
	<nav class="nav">
		<img src="upload/Spotips_Logo.png" />
		<!-- 로고 -->
		<ul>
			<li><a href="wow.jsp"><img src="관리자프로필사진" />이름</a></li>
			<li><a>알림</a></li>
			<!-- ajax -->
			<li><a>친구추천</a></li>
			<!-- ajax -->
			<li><a>채팅</a></li>
			<!-- ajax -->
			<li><a href="wow.jsp">개인정보수정</a></li>
		</ul>
	</nav>

</body>
</html>