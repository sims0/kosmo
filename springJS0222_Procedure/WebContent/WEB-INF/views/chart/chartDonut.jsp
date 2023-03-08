<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%--2023. 1. 17./ Kosmo --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>������Ʈ-��ü</title>
<style></style>
<script
	src="${pageContext.request.contextPath}/resources/js/d3-5.8.2.min.js"
	charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/resources/js/c3.min.js"></script>
</head>
<body>
	<article>
		<div id="chart"></div>
		<script>
			//������ json�� �Ľ��� ������
			let jsondata = {
				���ɾ��� : 120,
				�𸨴ϴ� : 666,
				�񰡿ɴϴ� : 500,
				�ȿɴϴ� : 200,
				��ǳ�̿ɴϴ� : 54
			}
			console.log(jsondata);
			
			var chart = c3.generate({
				bindto : '#chart',
				//data.json
				data : {
					json : jsondata,
					type : 'donut',
					onclick: function (d, i) { console.log("onclick", d, i); },
			        onmouseover: function (d, i) { console.log("onmouseover", d, i); },
			        onmouseout: function (d, i) { console.log("onmouseout", d, i); }
				},
				donut : {
					title : '���� �������� ����'
				}
			});
		</script>
	</article>
</body>
</html>