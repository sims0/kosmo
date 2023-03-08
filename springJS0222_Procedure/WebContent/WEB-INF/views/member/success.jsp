<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>success!</title>
</head>
<body>
<p>회원가입축하</p>
<hr>
<h2>회원 정보 확인</h2>
<ul>
<li> ID		: ${vo.id }</li>
<li> PWD	: ${vo.pwd }</li>
<li> NAME	: ${vo.uname }</li>
<li> DATE	: ${vo.rdate }</li>
</ul>
</body>
</html>