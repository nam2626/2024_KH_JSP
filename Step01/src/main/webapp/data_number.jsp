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
		사용자가 보낸 데이터 num을 꺼내서 출력
	 -->
	 <%
	 	int num = Integer.parseInt(request.getParameter("number"));
	 %>
	 
	 사용자가 보낸 값 : <%=num %><br>
	 
	 <%
	 	for(int i=1;i<=num;i++){
	 %>
	 	<p><%=i %></p>
	 <%
	 	}
	 %>
</body>
</html>





