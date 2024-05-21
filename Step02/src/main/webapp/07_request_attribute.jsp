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
	request.setAttribute("key", "data");
%>
<!-- 링크를 클릭하는 행위 및 데이터를 보내는 행위는 서버에 새로운 요청, request가 초기화 됨 -->
<a href='request_attribute_result.jsp'>페이지 이동</a>
<form action="request_attribute_result.jsp">
	<button>전송</button>
</form>




</body>
</html>



