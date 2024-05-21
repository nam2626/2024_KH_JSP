<%@page import="vo.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>person_result.jsp</h2>
	<%
		//request에 저장한 person을 꺼내기
		Person person = (Person) request.getAttribute("person");
	
	%>
	<%= person.toString() %>
</body>
</html>