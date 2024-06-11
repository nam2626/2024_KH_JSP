<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	window.onload = () => {
		document.querySelector("#frm").onsubmit = (e) => {
			e.preventDefault();
			let fileList = document.querySelectorAll('input[type="file"]');
			const formData = new FormData();
			
			fileList.forEach((item) => {
				formData.append('file',item.files[0]);
			});
			
			fetch("./fileUpload.do", {
		         method: 'POST',
		         body: formData
		    })
		    .then((response) => response.json())
		    .then((result) => {
		      console.log('Success:', result);
		    })
		    .catch((error) => {
		      console.error('Error:', error);
		    });
		}
	}
</script>
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