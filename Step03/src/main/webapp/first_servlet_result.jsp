<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	서블릿에서 셋팅한 데이터<br>
	<!-- 서블릿에서 셋팅한 데이터를 html 태그와 함께 출력 -->
	<%=request.getAttribute("txt") %>
</body>
</html>