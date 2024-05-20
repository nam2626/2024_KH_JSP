<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구구단</title>
</head>
<body>
	<!--
		02_gugudan_input.jsp에서 보낸 dan을 받아서
		해당 구구단을 출력
	  -->
	  <%
			int dan = Integer.parseInt(request.getParameter("dan"));
		%>
			<h2>--<%=dan %>단--</h2>
		<%
			for(int i=1;i<10;i++){
		%>
			<p><%=dan %> * <%=i %> = <%=dan*i %></p>
		<%
			}
		%>
</body>
</html>




