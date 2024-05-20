<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
   table{
   border-collapse: collapse;
   }
   td{
   border : 1px solid black;
   padding:20px;
   }
</style>
</head>
<body>
<!-- 
	04_table_generator.jsp에서 보낸 행, 열 값을 받아서
	크기에 해당하는 테이블을 출력
	row, col으로 데이터를 받아서 처리`
 -->
 <%
	int row = Integer.parseInt(request.getParameter("row"));
	int col= Integer.parseInt(request.getParameter("col"));
	int n = 1;
%>
	<table>
<%
	for(int i=0;i<row;i++){
%>
		<tr>
<%
		for(int j=0;j<col;j++){
%>
				<td><%=n %></td>			
<%
			n++;
		}
%>
		</tr>
<%
	}
%>	
	</table>
</body>
</html>













