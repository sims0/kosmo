<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>이동 중입니다. 잠시만 기다려</h1>
	<script>
		//함수 만들기 미리보기
		function deviceCheck() {
			alert("test");
			//javascript영역:
			//javascript : 클라이언트에서 해석되는 인터프리터 언어이고, 객체지향 언어이다. 소스보기하면 나옴
			//브라우저마다 인젠이 다르기 때문에 약간의 파싱의 차이가 있을수 있다.
			//html5에서 부터 표준화 된 버전 => ECMA5~7시리즈: 자바스크립트를 표준으로 한 통합 버전
			//변수선언은 var, let으로 한다. 
			var userAgent = navigator.userAgent.toLowerCase(); //소문자로 출력
			var platform = navigator.platform.toLowerCase();
			//alert(userAgent);
			//mozilla/5.0 (windows nt 10.0; win64; x64) applewebkit/537.36 (khtml, like gecko) chrome/108.0.0.0 safari/537.36
			//console.log 경고창으로 자주 사용했'던'
			console.log("userAgent:" + userAgent);
			//console.log("platform:"+platform);
			//indexOf()-> 찾지 못하면 -1
			console.log("indexOf:" + userAgent.indexOf('android'));
			if (userAgent.indexOf('android') > -1
					|| userAgent.indexOf('iphone') > -1) {
				console.log("mobile");
				//location="이동할 url";
				location = "mobile/";
			} else {
				console.log("PC");
				location = "web/";
			}
		}
		deviceCheck();
	</script>
</body>
</html>