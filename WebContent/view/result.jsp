<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="css/style.css?after">
<head>
<meta charset="UTF-8">
<script src="js/script.js"></script>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script>graph();</script>
<title>LPT : 롤 포지션 테스트</title>
</head>
<body>
	<div class="layout">
		<h1 style="text-align: center;">Logo</h1>
	</div>

	<div class ="result" >
		<img  src="img/top.png"> <br>
		<span id="positon">탑</span> <br><br>
		<span id="positon_text">당신은 독고다이 탑신병자입니다!</span> <br><br>
		<div id="graph"></div>
	</div>
</body>
</html>