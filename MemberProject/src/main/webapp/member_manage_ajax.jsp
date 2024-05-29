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
			//검색어 저장
			const txt = document.querySelector("#txt").value;
			fetch('./member/list?txt='+txt).then((response) => {
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
				let tag = '';
				result.forEach((item) => {
					tag += '<ul>';
					tag += '<li>' + item.boardMemberId + '</li>';
					tag += '<li>' + item.boardMemberName + '</li>';
					tag += '<li>' + item.boardMemberPasswd + '</li>';
					tag += '<li>' + item.boardMemberNick + '</li>';
					tag += `<li><a href='#'>삭제</a></li>`;
					tag += '</ul>';
				});
				document.querySelector("#result").innerHTML = tag;	
				document.querySelectorAll('a').forEach((item)=>{
					item.onclick = function(){
						//클릭이벤트 처리
						/*
							parentNode : 부모 요소
							childNodes : 자식 요소들(배열)
							nextSibling : 동생 요소
							previousSibling : 형 요소
							firstChild:첫번째 자식요소
							lastChild : 마지막 자식요소
						*/
						console.log(item.parentNode.parentNode.childNodes[0]);
						console.log(item.parentNode.parentNode.firstChild);
						console.log(item.parentNode.parentNode.lastChild);
						let id = item.parentNode.parentNode.firstChild.innerText;
						//alert(id);
						let params = {memberId : id};
						console.log(JSON.stringify(params))
						//ajax 호출
						fetch('./member/delete',{
							method:"post",
							body : JSON.stringify(params)
						}).then((response) => {
							return response.json();
						}).then((result) => {
							//선택한 태그 삭제 방법
							//item.parentNode.parentNode.remove();
							//결과값으로 받은 list를 다시 화면에 출력하는 코드
							let tag = '';
							result.list.forEach((item) => {
								tag += '<ul>';
								tag += '<li>' + item.boardMemberId + '</li>';
								tag += '<li>' + item.boardMemberName + '</li>';
								tag += '<li>' + item.boardMemberPasswd + '</li>';
								tag += '<li>' + item.boardMemberNick + '</li>';
								tag += `<li><a href='#'>삭제</a></li>`;
								tag += '</ul>';
							});
							document.querySelector("#result").innerHTML = tag;	
							console.log(result);
						}).catch((error)=>{
							console.log(error);
						})
					}
				});
				console.log(result);
			}).catch((error) => {
				//에러 처리부분
				console.log(error);
			});
		}
	}
</script>
<style type="text/css">
	#result ul {
		list-style-type: none;
		display: flex;
		flex-flow: row nowrap;
		width: 1200px;
		gap : 20px;
	}
	#result ul > li{
		max-width: 25%;
		text-overflow: ellipsis;
		overflow: hidden;
	}
</style>
</head>
<body>
	<h2>회원정보 Ajax 테스트 페이지</h2>
	<input type="text" id="txt"><button id="button">검색</button>
	<hr>
	<div id="result">
	</div>
	
</body>
</html>