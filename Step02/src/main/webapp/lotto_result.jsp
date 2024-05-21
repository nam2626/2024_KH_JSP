<%@page import="java.util.HashSet"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage="error.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table{
		margin: 0 auto;
		border-collapse: collapse;
	}
	td{
		border : 1px solid black;
		padding:30px;
	}
</style>
</head>
<body>
<%
	ArrayList<HashSet<Integer>> list = 
					(ArrayList<HashSet<Integer>>)request.getAttribute("list");
%>
	<table>
<%
	for(int i=0;i<list.size();i++){
%>
		<tr>
<%
		for(int n : list.get(i)){
%>
			<td><%=n %></td>
<%
		}
%>
		</tr>		
<%
	}
%>		
	</table>
</body>
</html>




