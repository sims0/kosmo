<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>survey chooseform</title>
<style>
#container {
	width: 450px;
	margin: auto;
}

table {
	border-collapse: collapse;
	width: 100%
}

th {
	background-color: #ff9933
}

tbody img {
	width: 100px;
}

th, td {
	padding: 8px;
	text-align: left;
	border-bottom: 1px solid #ddd;
}

tr:hover {
	background: #ff9933
}
</style>
</head>
<article>
	<header>
		<h1>Survey Choose</h1>
	</header>
	<ul class="list-unstyled">
		<li class="border-top my-3"></li>
	</ul>
	<div id="container">
		<form action="surveyDetail" method="post">
			<div class="form-group">
				<label for="num">num</label> 
				<input type="number" name="num" id="num" class="form-control"> 
				<input type="submit" value="검색" />
			</div>
		</form>
	</div>
</article>
</html>