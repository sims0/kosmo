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
		<script>
		//data.json
		//Ajax로 받아서 처리해 봅시다.
	
			$.ajaxSetup({
				cache : false
			});
			$.ajax({
				url : "../surveyJsonObj?num=21",
				success : function(data) {
							//----------------------------
					var chart = c3.generate({
						bindto : '#chart',
						data : {
								json : [data],
								keys:{
									value:Object.keys(data),
								},
								type : 'donut'
							},
							donut : {
							title : 'surveyChartAjax'
							},
						});	
		//----------------------------
				},
				error : function(e){
					console.log("error"+e);
				}
			});
		</script>
	</article>
</body>
</html>