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
	<%
		//이름 나이 읽어옴
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		
		//Person 생성
		Person p = new Person(name,age);
		//Person 객체를 request 영역에 저장
		request.setAttribute("person", p);
		//person_result.jsp로 이동 - forward
		request.getRequestDispatcher("person_result.jsp").forward(request, response);
	%>
	
	<%=p.toString() %>
</body>
</html>







