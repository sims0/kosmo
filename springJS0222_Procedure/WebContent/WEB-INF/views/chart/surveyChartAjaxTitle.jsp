<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%--2023. 1. 17./ Kosmo --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>도넛차트-Ajax</title>
<style></style>
<script
	src="${pageContext.request.contextPath}/resources/js/d3-5.8.2.min.js"
	charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/resources/js/c3.min.js"></script>
</head>
<body>
	<article>
		<header>
			<h1>[ChartJson Demo]surveyChart</h1>
		</header>
		<ul class="list-unstyled">
			<li class="border-top my-3"></li>
		</ul>
		<div class="container">
			<div id="chart"></div>
		</div>
		<div>
		<input type="button" value="list" 
		onclick="location='${pageContext.request.contextPath}/web/survey/surveylist'">
		</div>
		<script>
		//data.json
		//Ajax로 받아서 처리해 봅시다.
	$.ajax({
	url : "../surveyJsonObj2?num=${num}",
	success : function(jsondata) {
		console.log(jsondata[0].sub);
		console.log("---------------------");
		console.log(jsondata[1]);
		console.log("---------------------");
		var chart = c3.generate({
			bindto : '#chart',
			data : {
				json : [jsondata[1]],
				keys : {
					value : Object.keys(jsondata[1]),
				},
				type : 'donut'
			},
			donut : {
				title : jsondata[0].sub,
			},
		});
		//----------------------
	},
	error : function(e) {
		console.log("error:" + e);
	}
});
		</script>
	</article>
</body>
</html>