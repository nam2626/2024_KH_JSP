<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--
	아이디와 비밀번호가 admin, 1234이면 로그인 성공 페이지(login_success.jsp)로 이동
	로그인 실패시 login_fail.jsp로 이동
-->
<%
	//1. 데이터를 받음
	String id = request.getParameter("id");
	String pass = request.getParameter("pass");
	
	//2. 데이터 처리 및 페이지 이동 처리
	if(id.equals("admin") && pass.equals("1234")){
//		out.write("<script>location.href='login_success.jsp';</script>");
		response.sendRedirect("login_success.jsp");//새로운 요청
	}else{
		//out.write("<script>location.href='login_fail.jsp';</script>");
%>
		<jsp:forward page="login_fail.jsp"></jsp:forward>
<%
	}
%>