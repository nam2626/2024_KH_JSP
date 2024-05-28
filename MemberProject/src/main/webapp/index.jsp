<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 로그인이 안되어있으면 로그인 페이지로 이동하게끔 처리  -->
	<c:if test="${sessionScope.user == null }">
		<!--로그인이 안되었을때 -->
		<script>
			alert('로그인 하셔야 이용하실 수 있습니다.');
			location.href = './login.jsp';
		</script>
	</c:if>
	<ul>
		<li><a href="./allMember">전체회원정보 조회</a></li>
		<li><a href="./member_register.jsp">회원정보 등록</a></li>
	</ul>
</body>
</html>