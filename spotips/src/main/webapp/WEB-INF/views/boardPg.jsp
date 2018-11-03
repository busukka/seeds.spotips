<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>

<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<head>
<meta charset="UTF-8">
</head>

<body>
<h5>보드페이지!</h5>
<a href="gopostUploadPg">게시판 생성!</a><br/>
${makeBList}

</body>
</html>