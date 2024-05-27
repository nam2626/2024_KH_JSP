<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl, el</title>
<style type="text/css">
	body{
		height: 3000px;
	}
</style>
</head>
<body>
	<h2>el 태그 테스트</h2>
	<p>request 영역에 저장된 내용은 requestScope를 사용해서 뽑음</p>
	<p>age : ${requestScope.age }</p>	
	<p>seesion 영역에 저장된 내용은 sessionScope를 사용해서 뽑음</p>
	<p>msg : ${sessionScope.msg }</p>
	<!-- session에 저장된 dto를 출력 -->
	<p>${sessionScope.dto }<br>${sessionScope.dto.boardMemberId },
		${sessionScope.dto.boardMemberName },
		${sessionScope.dto.boardMemberPasswd },
		${sessionScope.dto.boardMemberNick }</p>
	<h2>jstl</h2>
	<!-- set : 변수 선언해서 초기화 -->
	<p><c:set var="tnum" value="1000"></c:set></p>
	<!-- out : 해당 데이터를 출력-->
	<p><c:out value="${tnum}"></c:out>, ${tnum }</p>
	<!-- if문, test에 조건식, 단 else, elseif가 없음 -->
	<h2>if문</h2>
	<c:if test="${requestScope.age < 20 }">
		<p>미성년자 입니다</p>
	</c:if>
	<c:if test="${requestScope.age >= 20 }">
		<p>성인 입니다</p>
	</c:if>
	<!-- choose, 여러개의 조건문 -->
	<h2>여러개 조건문</h2>
	<c:choose>
		<c:when test="${requestScope.age >= 20 && requestScope.age < 30 }">
			<p>20대 입니다</p>
		</c:when>
		<c:when test="${requestScope.age >= 30 && requestScope.age < 40 }">
			<p>30대 입니다</p>		
		</c:when>
		<c:otherwise>
			<p>40대 입니다.</p>
		</c:otherwise>
	</c:choose>
	<h2>반복문</h2>
	<ul>
		<!-- var : 반복문 제어변수, begin : 시작값, end : 마지막 값, step : 증감값  -->
		<c:forEach var="i" begin="1" end="10" step="1">
			<li>${i}</li>
		</c:forEach>
	</ul>
	<hr>
	<ul>
		<c:forEach var="i" begin="1" end="10" step="1" varStatus="status">
			<li>${i}, ${status.current }, ${status.begin }, ${status.end }</li>
		</c:forEach>
	</ul>
	<hr>
	<!-- 리스트 꺼내는 부분  -->
	<ul>
		<c:forEach var="member" items="${requestScope.list }" varStatus="status">
			<li>${member.toString() },${status.count }</li>
		</c:forEach>
	</ul>
	<!--
			상태변수
				current : 현재 아이템 값
				index : 인덱스 값 - 0부터 시작
				count : 1부터 순서값 시작
				first : 해당 순서가 첫번째인지 확인
				last : 해당 순서가 마지막인지 확인
				begin : 시작값
				end : 마지막값
				step : 증가값
		-->
</body>
</html>








