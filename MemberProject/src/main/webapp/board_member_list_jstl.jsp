<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>전체 회원 리스트</h2>
	<hr>
	<table>
		<thead>
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>닉네임</th>
				<th>암호</th>
				<th>비고</th>
			</tr>
		</thead>
		<tbody>
			<!-- 2. 반복문을 이용하여 데이터를 태그와 함께 출력  -->
			<c:forEach var="member" items="${requestScope.member_list }">
				<tr>
					<td>${member.boardMemberId }</td>
					<td>${member.boardMemberName }</td>
					<td>${member.boardMemberNick }</td>
					<td>${member.boardMemberPasswd }</td>
					<td>
						<a href="./updateMemberView?memberId=${member.boardMemberId }">수정</a>
						<a href="./deleteMember?memberId=${member.boardMemberId }">삭제</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="./index.jsp">메인 페이지로 이동</a>
</body>
</html>








