<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	window.onload = () => {
		//검색 버튼 클릭 이벤트
		//   Ajax로 /member/list 호출
		const button = document.querySelector("#button");
		button.onclick = () => {
			fetch('./member/list').then((response) => {
				//응답이 정상인 체크
				/* if(response.status == 200){
					//정상 일때
				}else{
					//비정상 일때
				} */
				//결과 데이터 전달
				console.log(response);
				return response.json();
			}).then((result) => {
				//받아온 데이터 html로 출력
				//result 영역에 출력
				console.log(result);
			}).catch((error) => {
				//에러 처리부분
				console.log(error);
			});
		}
	}
</script>
</head>
<body>
	<h2>회원정보 Ajax 테스트 페이지</h2>
	<input type="text" id="txt"><button id="button">검색</button>
	<hr>
	<div id="result">
	</div>
	
</body>
</html>