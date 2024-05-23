<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>사원정보 등록 페이지</h2>
	<form action="./insertEmployee" method="post">
		<input type="text" name="empNo" placeholder="사원번호 입력"><br>
		<input type="text" name="empName" placeholder="사원이름 입력"><br>
		<input type="text" name="empPosition" placeholder="사원 직급 입력"><br>
		<input type="text" name="empDepartment" placeholder="사원 부서 입력"><br>
		<input type="text" name="empSalary" placeholder="사원 급여 입력"><br>
		<input type="date" name="empDate"><br>
		<button>등록하기</button>
		<button type="button" onclick="history.back();">뒤로가기</button>
	</form>
</body>
</html>






