<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	request에 저장된 내용 : <%=request.getAttribute("result") %>
	<%
		request.getRequestDispatcher("final_result.jsp").forward(request, response);
	%>
</body>
</html>