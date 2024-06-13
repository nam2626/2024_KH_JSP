<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	window.onload = () => {
		document.querySelector("#button").onclick = () => {
			const txt = document.querySelector("#txt").value;
			
			fetch("./newsSerach.do?txt="+txt).then(response => response.json())
			.then(result => {
				console.log(result);
				let tag = '';
				result.items.forEach((item) => {
					tag += `<p>\${item.title}</p>`;
				});
				document.querySelector("#area").innerHTML = tag;
			});
		}	
	}
</script>
</head>
<body>
	<!-- 검색어를 받아서 AJAX로 서블릿 호출 -->
	<input type="text" id="txt"><button id="button">검색</button>
	<!-- 해당 결과를 화면에 출력 -->
	<div id="area">
		
	</div>
</body>
</html>