<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<article>
	<header>
		<h1>�� ����</h1>
	</header>
	<ul class="list-unstyled">
		<li class="border-top my-3"></li>
	</ul>
	<div class="container">
		<div class="form-group">
			<label for="id">���̵� : </label>${vo.id}</div>
		<div class="form-group">
			<label for="name">�̸� : </label>${vo.name}</div>
		<div class="form-group">
			<label for="age">���� : </label>${vo.age}</div>
		<div class="form-group">
			<label for="age">���� : </label>${vo.gender}</div>
		<div class="form-group">
			<label for="age">���Գ�¥ : </label>${vo.mdate}</div>
		<!-- </form> -->
	</div>
	<ul class="list-unstyled">
		<li class="border-top my-3"></li>
	</ul>
	<table class="table table-bordered" style="text-align: center">
		<thead>
			<tr>
				<th>�α��� ������</th>
				<th>��¥</th>
				<th>����</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="e" items="${list }">
				<tr>
					<td>${e.reip }</td>
					<td>${e.sstime }</td>
					<td>${e.cnt }ȸ �α���</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<div>
		<a href="memberupform?id=${vo.id }"><button type="button"
				class="btn btn-primary">����</button></a>
	</div>
</article>
<%--���� ���� �� --%>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
	function chooseGender(gen) {
		$('#gender').val(gen);
		//		console.log("gender=>" + $('#gender').val(gen))
		console.log("gender=>" + gen)
	}
	$(function() {
		$('#btn1').click(
				function() {
					let param = $('#id').val();
					//alert("param"+param)
					$.ajax({
						url : "idcheck?id=" + param,
						success : function(data) {
							console.log(data);
							if (data == 1) {
								$('#target').css('background-color', 'red')
										.css('color', 'white').html(
												'������� ���̵� �Դϴ�.');
							} else {
								$('#target').css('background-color', 'blue')
										.css('color', 'white').html(
												'��밡���� ���̵� �Դϴ�.');
							}
						}
					});
				});
	});
</script>