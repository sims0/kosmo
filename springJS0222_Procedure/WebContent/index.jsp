<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>�̵� ���Դϴ�. ��ø� ��ٷ�</h1>
	<script>
		//�Լ� ����� �̸�����
		function deviceCheck() {
			alert("test");
			//javascript����:
			//javascript : Ŭ���̾�Ʈ���� �ؼ��Ǵ� ���������� ����̰�, ��ü���� ����̴�. �ҽ������ϸ� ����
			//���������� ������ �ٸ��� ������ �ణ�� �Ľ��� ���̰� ������ �ִ�.
			//html5���� ���� ǥ��ȭ �� ���� => ECMA5~7�ø���: �ڹٽ�ũ��Ʈ�� ǥ������ �� ���� ����
			//���������� var, let���� �Ѵ�. 
			var userAgent = navigator.userAgent.toLowerCase(); //�ҹ��ڷ� ���
			var platform = navigator.platform.toLowerCase();
			//alert(userAgent);
			//mozilla/5.0 (windows nt 10.0; win64; x64) applewebkit/537.36 (khtml, like gecko) chrome/108.0.0.0 safari/537.36
			//console.log ���â���� ���� �����'��'
			console.log("userAgent:" + userAgent);
			//console.log("platform:"+platform);
			//indexOf()-> ã�� ���ϸ� -1
			console.log("indexOf:" + userAgent.indexOf('android'));
			if (userAgent.indexOf('android') > -1
					|| userAgent.indexOf('iphone') > -1) {
				console.log("mobile");
				//location="�̵��� url";
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