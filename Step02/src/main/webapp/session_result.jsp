<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%=session.getId() %><br>
	session 데이터 : <%=session.getAttribute("session") %> <br>
	request 데이터 : <%=request.getAttribute("str") %><br>
	<a href="invalid.jsp">세션 정보 초기화</a>
</body>
</html>