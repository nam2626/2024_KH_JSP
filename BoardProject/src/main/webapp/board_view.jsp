<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#container{
		/* background-color: lime; */
		width:1200px;
		margin:0 auto;
	}
	#container table{
		width:600px;
		border-collapse: collapse;
		margin:0 auto;
	}
	#container th{
		width:150px !important;
		text-align: right;
		padding:5px;
	}
	#container td{
		width: 500px;
		padding:5px;
		height: 40px;
	}
	#container input{
		width: 100%;
		height:40px;
		box-sizing:border-box;
		border-width : 1px;
		border-radius: 5px;
	}
	h2{
		text-align: center;
	}
	.btn{
		text-decoration: none;
		background-color: #e8e8e8;
		min-width: 80px;
		display: inline-block;
		padding:5px 10px;
		font-weight:normal;
		border : 1px solid #585858;
		text-align:center;
		color : black;
		font-size:14px;
		box-sizing: border-box;
	}
	.btn:hover{
		background-color: #282828;
		color:#FFFFFF
	}
	.hate{
		transform: rotate(0.5turn);
	}
	.text_center{
		text-align: center;
	}
	.btn_like{
		width:64px;
		display: inline-block;
		color:black;
		text-decoration: none;
	}
	.comment_form{
		width:100%;
		border :1px solid black;
	}
	.writer{
		width: 100%;
		display: inline-block;
		font-weight: bold;
		padding-left: 30px;
	}
	.comment_form textarea{
		width:100%;
		height: 80px;
		margin-top:10px;
		font-size: 18px;
		padding-left: 30px;
		padding-right: 30px;
		outline:none;
		border: none;
		resize: none;
		box-sizing: border-box;

	}
	.comment_form button{
		width: 100px;
		height: 40px;
		font-weight: bold;
		background-color: #ffff00;
		outline:none;
		border: none;
	}
	.comment_form button:hover{
		background-color: #dfdf25;
	}
	.length{
		text-align: right;
		padding:10px 30px;
	}
	hr{
	margin:0;
	}
	.comment_form p {
		margin:0;
	}
</style>
<script>
	window.onload = () => {
		//좋아요 링크 클릭 -> 경고창 띄우기
		document.querySelector('#btn_like').onclick = () => {
			//alert('좋아요 클릭')
			fetch('./boardLike.do?bno=${board.boardNo}')
			.then(response => response.json())
			.then((result) => {
				console.log(result);
				if(result.code == 2){
					if(confirm(result.msg))	location.href='./index.jsp';
				}
				else alert(result.msg);
				//좋아요 개수 갱신
				document.querySelector("#like_count").innerHTML = result.count;
			})
			.catch((error) => {
				console.log(error);
			})
		}
		document.querySelector('#btn_hate').onclick = () => {
			fetch('./boardHate.do?bno=${board.boardNo}')
			.then(response => response.json())
			.then((result) => {
				console.log(result);
				if(result.code == 2){
					if(confirm(result.msg))	location.href='./index.jsp';
				}
				else alert(result.msg);
				document.querySelector("#hate_count").innerHTML = result.count;
			})
			.catch((error) => {
				console.log(error);
			})
		}
	}

</script>
</head>
<body>
<div id="container">
  <h2>글조회 페이지</h2>
	<table>
		<tr>
			<th>글번호</th>
			<td>${board.boardNo}</td>
		</tr>
		<tr>
			<th>제목 : </th>
			<td>${board.boardTitle }</td>
		</tr>
		<tr>
			<th>작성자 : </th>
			<td>${board.boardMemberNick }</td>
		</tr>
		<tr>
			<th>조회수 : </th>
			<td>${board.boardCount }</td>
		</tr>
		<tr>
			<td colspan="2"> 
				${board.boardContent }
			</td>
		</tr>
		<tr>
			<td colspan="2"> 
				<a href="#" id="btn_like">좋아요 : <span id="like_count">${board.boardLike }</span> </a>
				<a href="#" id="btn_hate">싫어요 : <span id="hate_count">${board.boardHate }</span> </a>
			</td>
		</tr>
		<!-- 
			해당 글을 쓴 작성자에게만 수정, 삭제 버튼이 나오게끔 처리
		 -->
		 <c:if test="${sessionScope.user.boardMemberId == board.boardMemberId }">
		 <tr>
			 <td colspan="2">
			 	<button id="btn_update">수정</button>
			 	<button id="btn_delete">삭제</button>
			 	<script>
			 		document.querySelector("#btn_update").onclick = () =>{
			 			location.href='./boardUpdateView.do?bno=${board.boardNo}';
			 		}
			 		document.querySelector("#btn_delete").onclick = () =>{
			 			location.href='./boardDelete.do?bno=${board.boardNo}';
			 		}
			 	</script>
			 </td>
	 	</tr>
		 </c:if>
		 <tr>
		 	<td colspan="2">
		 		<!-- 댓글 입력 폼 -->
		 		<div class="comment_form">
					<form action="commentWrite.do" method="post">
						<input type="hidden" name="bno" value="${board.boardNo }">
						<textarea name="comment" placeholder="댓글을 입력하세요"></textarea>
						<button>댓글작성</button>
					</form>
				</div>
		 	</td>
		 </tr>
	</table>
	<hr>
	<!-- 
		댓글 내용을 출력, 댓글 번호(hidden), 작성일, 좋아요, 싫어요, 작성자, 댓글 내용 
		댓글 삭제 버튼 -> 작성자와 로그인한 사람이 일치할때
		
		작성자, 작성일, 좋아요, 싫어요
		댓글 내용
		삭제버튼
	 -->
	 <c:forEach var="comment" items="${commentList}">
	 	<div class="comment">
	 		<p>
	 			<input type="hidden" name="cno" value="${comment.cno }"/>
	 			<span>${comment.writer }</span>
	 			<span>작성일 : ${comment.cdate }</span>
	 			<span><a href="#" class="btn_comment_like">좋아요 : <span>${comment.clike }</span></a></span>
	 			<span><a href="#" class="btn_comment_hate">싫어요 : <span>${comment.chate}</span></a></span>
	 		</p>
	 		<p>${comment.comment }</p>
	 		<c:if test="${sessionScope.user.boardMemberId == comment.writer }">
	 			<a href="./boardCommentDelete.do?cno=${comment.cno }&bno=${comment.bno}">댓글 삭제</a>
	 		</c:if>
	 	</div>
	 </c:forEach>
	</div>
</body>
</html>








