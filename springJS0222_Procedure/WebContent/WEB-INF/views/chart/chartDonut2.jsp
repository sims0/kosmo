<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%--2023. 1. 17./ Kosmo --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>도넛차트-배열</title>
<style></style>
<script src="${pageContext.request.contextPath}/resources/js/d3-5.8.2.min.js" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/resources/js/c3.min.js"></script>
</head>
<body>
<article>
	<div id="chart"></div>
	<script>
//서버측 json을 파싱한 데이터
let jsondata=[];
jsondata.push({관심없음:120, 모릅니다:666, 비가옵니다:500, 안옵니다:200,태풍이옵니다:54});
console.log(jsondata[0]);

//bar차트: 데이터에서 사용자의 이름을 axis.x.category 
let chart = c3.generate({
	bindto: '#chart',
	//data.json
	data:{
		 json:jsondata,
	      keys: {
	      value: ['관심없음','모릅니다','비가옵니다','안옵니다','태풍이옵니다']
	      },
	      type:'donut',
	      onclick: function (d, i) { console.log("onclick", d, i); },
	      onmouseover: function (d, i) { console.log("onmouseover", d, i); },
	      onmouseout: function (d, i) { console.log("onmouseout", d, i); }
	},
	donut:{
		title: '날씨 설문조사 내용'
	}
});
</script>
</article>
</body>
</html>