<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%--2023. 1. 17./ Kosmo --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title></title>
<style></style>
<script src="${pageContext.request.contextPath}/resources/js/d3-5.8.2.min.js" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/resources/js/c3.min.js"></script>
</head>
<body>
<article>
	<div id="chart"></div>
	<script>
//������ json�� �Ľ��� ������
const student=[];
student.push({name:'����',kor:'87', eng:'98', math:'88',scien:'90'});
student.push({name:'����',kor:'92', eng:'98', math:'96',scien:'88'});
student.push({name:'�ܿ�',kor:'76', eng:'96', math:'94',scien:'86'});
student.push({name:'�ٴ�',kor:'98', eng:'52', math:'98',scien:'92'});
console.log(student);

//bar��Ʈ: �����Ϳ��� ������� �̸��� axis.x.category 
var chart = c3.generate({
	bindto: '#chart',
	//data.json
	data:{
	    json: student,
	    keys: {
	        // x: 'name', // it's possible to specify 'x' when category axis
	        value: ['kor', 'eng','math','scien']
	      },
	      type:'bar'
	},
	   axis: {
	        x: {
	            type: 'category',
	            categories: [student[0].name, student[1].name, student[2].name, student[3].name]
	        }
	    }
});
</script>
</article>
</body>
</html>