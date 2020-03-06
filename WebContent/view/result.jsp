<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="css/style.css?after">
<head>
<meta charset="UTF-8">
<script src="js/script.js"></script>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<title>LPT : 롤 포지션 테스트</title>
</head>
<body>
	<div class="layout">
		<img  src="img/logoname.png"> <br>
	</div>

	<div class ="result">
		<img  src="img/top.png"> <br>
		<span id="positon"><%=session.getAttribute("result") %></span> <br><br>
		<span id="positon_text">당신은 독고다이 탑신병자입니다!</span> <br><br>
		
		<input id = "a" type = "hidden" value = <%=session.getAttribute("graph0") %>>
		<input id = "b" type = "hidden" value = <%=session.getAttribute("graph1") %>>
		<input id = "c" type = "hidden" value = <%=session.getAttribute("graph2") %>>
		<input id = "d" type = "hidden" value = <%=session.getAttribute("graph3") %>>
		<input id = "e" type = "hidden" value = <%=session.getAttribute("graph4") %>>
		<script>
			var a = document.getElementById('a').value;
			var b = document.getElementById('b').value;
			var c = document.getElementById('c').value;
			var d = document.getElementById('d').value;
			var e = document.getElementById('e').value;
			graph(Number(a), Number(b), Number(c), Number(d), Number(e));
		</script>
		<div id="graph"></div>
	</div>
</body>
</html>