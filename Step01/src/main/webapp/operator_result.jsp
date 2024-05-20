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
		03_operator_input.jsp에서 보낸 숫자와 연산자를 가지고
		n1, n2, op
		해당 연산 결과를 출력
	  -->
	  <%
		int n1 = Integer.parseInt(request.getParameter("n1"));
		int n2 = Integer.parseInt(request.getParameter("n2"));
		String op = request.getParameter("op");
		int result = 0;	
		switch(op){
		case "+":
			result = n1 + n2;
			break;
		case "-":
			result = n1 - n2;
			break;
		case "*":
			result = n1 * n2;
			break;
		case "/":
			result = n1 / n2;
			break;
		default:
			result = n1 % n2;
		}
	%>
	<p><%=n1 %> <%=op %> <%=n2 %> = <%=result %></p>
</body>
</html>









