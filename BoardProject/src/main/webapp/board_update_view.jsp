<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	section{
		width: 1200px;
		margin:0 auto;
	}
	
	section form {
		display: flex;
		flex-direction: column;  
	}
	form > * {
		margin-top :10px;
	}
	.form_bar > button{
		width: 50%;
		box-sizing: border-box;
		font-size: 20px;
		height: 50px;
		
	}
	section h2{
		text-align: center;
	}
	section form > input{
		height: 30px;
		font-size: 20px;
	}
	section form > textarea{
		height: 300px;
		font-size: 20px;
		resize: none;
	}
	
</style>
</head>
<body>
	<section>
		<h2>글 수정</h2>
		<form action="./boardUpdate.do" method="post">
			<input type="text" name="title" placeholder="제목을 입력하세요" value="${board.boardTitle }">
			<textarea name="content" placeholder="내용을 입력하세요">${board.boardContent }</textarea>
			<input type="hidden" name="writer"
				value="${sessionScope.user.boardMemberId }">
			<div class="form_bar">
				<button type="submit" class="btn_submit">글수정</button>
				<button type="button" class="btn_back">뒤로가기</button>
			</div>
		</form>
	</section>
</body>
</html>





