<%@page import="dto.BoardMemberDTO"%>
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
	<!-- 1. request영역에 저장된 list를 읽어옴  -->
	<%
		ArrayList<BoardMemberDTO> list = 
			(ArrayList<BoardMemberDTO>)request.getAttribute("member_list");		
	%>
	<table>
		<thead>
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>닉네임</th>
				<th>암호</th>
			</tr>
		</thead>
		<tbody>
			<!-- 2. 반복문을 이용하여 데이터를 태그와 함께 출력  -->
			<%
				for(int i=0;i<list.size();i++){
					%>
					<tr>
						<td><%=list.get(i).getBoardMemberId() %></td>
						<td><%=list.get(i).getBoardMemberName() %></td>
						<td><%=list.get(i).getBoardMemberNick() %></td>
						<td><%=list.get(i).getBoardMemberPasswd() %></td>
					</tr>
					<%
				}
			%>
			
		</tbody>
	</table>
</body>
</html>








