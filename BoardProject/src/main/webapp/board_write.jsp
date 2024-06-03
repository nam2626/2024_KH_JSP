<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>글쓰기</h2>
	<form action="./boardWrite.do" method="post">
		<input type="text" name="title" placeholder="제목을 입력하세요">
		<textarea name="content" placeholder="내용을 입력하세요"></textarea>
		<input type="hidden" name="writer" value="${sessionScope.user.boardMemberId }"> 
		<div class="form_bar">
			<button type="submit" class="btn_submit">글쓰기</button>
			<button type="button" class="btn_back">뒤로가기</button>
		</div>
	</form>
</body>
</html>





