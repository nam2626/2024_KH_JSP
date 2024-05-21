<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String param = request.getParameter("data");
	request.setAttribute("result", "request_"+param);
	//사용자의 요청사항을 그대로 가지고 감.
	//최초에 호출했던 URL이 주소창에 남아있음
	RequestDispatcher dispatcher = request.getRequestDispatcher("forward_result.jsp");
	dispatcher.forward(request, response);
%>