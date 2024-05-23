<%@page import="dto.EmployeeDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>전체 사원정보 리스트</h2>

<table>
	<thead>
		<tr>
			<th>사번</th>
			<th>사원명</th>
			<th>직급</th>
			<th>부서</th>
			<th>급여</th>
			<th>입사일</th>
		</tr>
	</thead>
	<tbody>
		<%
			ArrayList<EmployeeDTO> list = (ArrayList<EmployeeDTO>) request.getAttribute("empList");
		
			for(int i=0;i<list.size();i++){
				out.println("<tr>");	
				out.println("<td>"+list.get(i).getEmpNo()+"</td>");
				out.println("<td>"+list.get(i).getEmpName()+"</td>");
				out.println("<td>"+list.get(i).getEmpPosition()+"</td>");
				out.println("<td>"+list.get(i).getEmpDepartment()+"</td>");
				out.println("<td>"+list.get(i).getEmpSalary()+"</td>");
				out.println("<td>"+list.get(i).getEmpCourseDate()+"</td>");
				out.println("</tr>");	
			}		
		%>
	</tbody>	
</table>
<a href="./index.jsp">메인으로 이동</a>
</body>
</html>




