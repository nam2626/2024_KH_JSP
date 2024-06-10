<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	*{
		margin:0;
		padding:0;
	}
	body{
		height:3000px;
	}
	table{
		border-collapse: collapse;
		margin: 20px auto;
		width: 1200px;
	}
	td, th{
		padding:10px;
		border: 1px solid black;
		text-align: center;
	}
</style>
</head>
<body>

<!-- 
	request영역에 저장된 boardList를 테이블 태그로 조립해서 출력
	게시글번호 제목 작성자 조회수 작성일 좋아요 싫어요 
-->
	<table>
		<thead>
			<tr>
				<th>글번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>조회수</th>
				<th>작성일</th>
				<th>좋아요</th>
				<th>싫어요</th>
			</tr>	
		</thead>		
		<tbody>
			<c:forEach var="board" items="${requestScope.boardList }">
				<tr>
					<td>${board.boardNo }</td>
					<td><a href="./boardView.do?bno=${board.boardNo }">${board.boardTitle }</a></td>
					<td>${board.boardMemberNick }</td>
					<td>${board.boardCount }</td>
					<td>${board.boardWriteDate }</td>
					<td>${board.boardLike }</td>
					<td>${board.boardHate}</td>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="7">
				
					<!-- 
						페이징 결과 출력
							PaggingVO에 있는 getStartPageOfPageGroup,
							getEndPageOfPageGroup 메서드를 이용해서
							jstl의 forEach를 이용해서 게시판 페이지 번호를 출력
		
							<a href="./main.do?pageNo=번호">번호</a>	
					
					 -->
					<c:forEach var="i" begin="${pagging.startPageOfPageGroup }" 
												end="${pagging.endPageOfPageGroup }">
						<!-- i가 현재 페이지 번호와 같으면 링크를 걸지 않음 -->
						<c:if test="${i == pagging.currentPage }">
							<a>${i }</a>
						</c:if>
						<c:if test="${i != pagging.currentPage }">
							<a href="./main.do?pageNo=${i }">${i }</a>
						</c:if>
					</c:forEach>
					
					<!--
						다음 페이지 그룹으로 이동 
						다음 페이지 그룹이 있을때만 표시
						▶ 를 클릭시 다음 그룹의 첫번째 페이지로 이동
						마지막 페이지 그룹이면 해당 링크가 나오면 안됨 
						
						1번째 페이지 그룹 1 2 3 4
						2번째 페이지 그룹 5 6 7 8
						5번 페이지로 이동
					 -->
					<c:if test="${pagging.nextPageGroup }">
						<a href="./main.do?pageNo=${pagging.endPageOfPageGroup + 1 }">
							▶
						</a>
					</c:if>
					
					<a href="./board_write.jsp">글쓰기</a>
				</td>
			</tr>
		</tfoot>
	</table>
	${pagging.toString() }
</body>
</html>










