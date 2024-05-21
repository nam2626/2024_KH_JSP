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
		String stdNo = request.getParameter("hak");
		String name = request.getParameter("name");
		String major = request.getParameter("major");
	
	%>
	
	<%=stdNo %>,<%=name %>,<%=major %>
</body>
</html>