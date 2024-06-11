<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>파일 업로드 테스트</h1>
    <form action="./fileUpload.do" method="post" enctype="multipart/form-data">
        파일 : <input type="file" name="file"><br>
        파일 : <input type="file" name="file"><br>
        파일 : <input type="file" name="file"><br>
        <input type="submit" value="업로드">
    </form>
</body>
</html>