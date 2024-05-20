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
		/* 
			사용자가 보낸 데이터는 request 객체가 저장
			사용자가 보낸 데이터는 getParameter("name속성값") 뽑음
		*/
		String data = request.getParameter("data");
	%>
	
	<p>사용자가 보낸 데이터 : <%=data %></p>	
	
</body>
</html>






