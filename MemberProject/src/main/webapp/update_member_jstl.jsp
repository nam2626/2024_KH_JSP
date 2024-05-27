<%@page import="dto.BoardMemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		BoardMemberDTO dto = (BoardMemberDTO)request.getAttribute("dto");
	%>
	<h2>회원정보 수정 페이지</h2>
	<form action="./updateMember" method="post">
		<!-- 아이디 암호 이름 닉네임, submit button -->
		<input type="text" name="member_id" placeholder="아이디 입력" value="<%=dto.getBoardMemberId()%>" readonly><br>
		<input type="password" name="member_passwd" placeholder="암호 입력"><br>
		<input type="text" name="member_name" placeholder="이름 입력" value="<%=dto.getBoardMemberName()%>"><br>
		<input type="text" name="member_nick" placeholder="닉네임 입력" value="<%=dto.getBoardMemberNick()%>"><br>
		<button>등록하기</button> <button type="button" id="btn_back">뒤로가기</button>
	</form>
	<script>
		document.querySelector('#btn_back').onclick = () => {
			history.back();
		}
	</script>
</body>
</html>