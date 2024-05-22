<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//세션을 무력화
	session.invalidate();
	response.sendRedirect("session_result.jsp");
%>