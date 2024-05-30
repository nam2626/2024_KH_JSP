<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<!-- 로그인이 되어있으면 index.jsp로 이동하게끔 처리 -->
	<c:if test="${sessionScope.user != null }">
		<script>
			location.href = './index.jsp';
		</script>
	</c:if>
	<form action="./login.do" method="post">
		<input type="text" name="id"><br>
		<input type="password" name="passwd"><br>
		<button>로그인</button>
		<button type="button">회원가입</button>
	</form>
	<!-- 회원가입 버튼을 클릭하면 member_register.jsp로 이동 -->
	<script>
		document.querySelector("button[type=button]").onclick = () =>{
			//alert('회원가입 버튼 클릭');
			location.href = './member_register.jsp';
		};
	</script>
	
</body>
</html>






