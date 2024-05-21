<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!--  
		자바로 출력한 내용(html,css, js)들은 실행되는 시점은
		사용자가 해당 내용을 받아야 실행 됨.
		사용자가 받은 내용 서버에서 실행되지 않음(웹브라우저에서 실행).
		이 때 액션 태그 및 자바코드는 서버단에서 우선적으로 실행되기 때문에,
		이때 밑에 출력한 자바스크립트나 문자열 및 내용은 사용자가 이것을 읽기 전에
		액션태그에 설정된 경로 바로 페이지가 이동처리 됨.
	-->
	<%= request.getParameter("name") %>
	<%= request.getParameter("hobby") %>
	<%
		out.println("<script>alert('안녕하세요');</script>");
	%>
	<!-- 사용자의 최초 요청사함이 그대로 전됨(최초로 호출된 url 유지, request객체도 유지됨) -->
	<jsp:forward page="forwardResult.jsp"></jsp:forward>
	
</body>
</html>


