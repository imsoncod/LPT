<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="css/style.css?after">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />
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
		<img  src=<%=session.getAttribute("eng") %>> <br>
		<span id="positon"><%=session.getAttribute("result") %></span> <br><br>
		<span id="positon_text"><%=session.getAttribute("message") %></span> <br><br>
		
		<input id = "a" type = "hidden" value = <%=session.getAttribute("a") %>>
		<input id = "b" type = "hidden" value = <%=session.getAttribute("b") %>>
		<input id = "c" type = "hidden" value = <%=session.getAttribute("c") %>>
		<input id = "d" type = "hidden" value = <%=session.getAttribute("d") %>>
		<input id = "e" type = "hidden" value = <%=session.getAttribute("e") %>>
		<script>
			var a = document.getElementById('a').value;
			var b = document.getElementById('b').value;
			var c = document.getElementById('c').value;
			var d = document.getElementById('d').value;
			var e = document.getElementById('e').value;
			graph(Number(a), Number(b), Number(c), Number(d), Number(e));
		</script>
		<div id="graph"></div><br>
		<span id="graph_text">[포지션별 나의 성향]</span> <br>
		<button id="btn_mainpage" type = "button" onclick="mainpage()">메인 페이지</button>
	</div>
</body>
</html>