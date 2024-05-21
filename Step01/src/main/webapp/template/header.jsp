<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 메뉴바에 해당하는 html tag, 항목 5개 -->
<nav>
	<ul>
		<li><a href="#">메뉴1</a></li>
		<li><a href="#">메뉴2</a></li>
		<li><a href="#">메뉴3</a></li>
		<li><a href="#">메뉴4</a></li>
		<li><a href="#">메뉴5</a></li>
	</ul>
</nav>

<!-- CSS 작업 -->
<style>
	nav {
		width: 1200px;
		margin:0 auto;
	}
	ul{
		list-style-type: none;
		display: flex;
		flex-flow:row nowrap;
	}
	li{
		text-align: center;
		padding:20px 0px;
		border:1px solid black;
	}
</style>






