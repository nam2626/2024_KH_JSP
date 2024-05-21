<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String data = request.getParameter("data");

	request.setAttribute("result", data);
	//redirect 방식으로 페이지 이동
	//redirect는 새로운 경로를 요청하는 것이기 때문에 기존의 request는 사라짐, 새 request가 만들어짐
	//그래서 주소창에 url이 바뀐것을 볼 수 있음
	response.sendRedirect("redirect_result.jsp");
%>