<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
</head>

<body>
	<c:forEach var="b" items="${blist}">
		<div class='post-content' style="z-index: 2;">
			<div class='post-container'>
				<img src='http://placehold.it/300x300' alt='user'
					class='profile-photo-md pull-left' />
				<div class='post-detail'>
					<div class='user-info'>
						<h5>
							<a href='timeline.html' class='profile-link'>${b.b_mbid}</a> 
							<span class='following'>${b.b_flno}</span>
						</h5>
						<p class='text-muted'>${b.b_date}</p>
					</div>
					<div class='reaction'>
						<a class='btn text-green'><i class='icon ion-thumbsup'></i>likes 숫자</a>
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
					<div class="line-divider">
						<h5>댓글</h5>
					</div>
					<div id="${b.b_no}replyList">
						<c:forEach var="r" items="${rList}">
							<c:if test="${r.r_bno eq b.b_no}">
								<div class="post-comment">
									<img src="http://placehold.it/300x300" alt=""
										class="profile-photo-sm" />
										<a href="timeline.html" class="profile-link">${r.r_mbid}</a>
										<p style="text-align: right">${r.r_date}</p><br/>
										${r.r_content}<br/>
										<a href='#'>답글달기</a>&nbsp;&nbsp;<a href='#'>신고하기</a>
								</div>
							</c:if>
						</c:forEach>
					</div>
					&nbsp;&nbsp;
					<form id="rForm" name='rForm'>
						<div class="post-comment">
							<img src="http://placehold.it/300x300" alt=""
								class="profile-photo-sm" /> <input type="text" name="r_content"
								id="r_content" class="form-control" placeholder="Post a comment">
							<span><input type="button" value="입력" id="btn"
								onclick="replyInsert('${b.b_no}')"
								style="width: 60px; height: 45px"></span>
						</div>
					</form>
				</div>
			</div>
		</div>
	</c:forEach>

</body>

</html>