<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%=session.getId()%>
<%
	request.setAttribute("str", "request 영역에 저장된 내용");

	//세션 설정
	session.setAttribute("session", "session 영역에 저장된 내용");
	session.setMaxInactiveInterval(300);
	
	//페이지 이동
	//request.getRequestDispatcher("session_result.jsp").forward(request, response);
	response.sendRedirect("session_result.jsp");
%>