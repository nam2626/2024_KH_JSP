<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
</body>
</html>








