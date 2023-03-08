<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<article>
	<header>
		<h1>내 정보</h1>
	</header>

	<form action="memberup" method="post">
		<input type="hidden" name="reip" value="<%=request.getRemoteAddr()%>">
		<input type="hidden" name="num" value="${vo.num }">
		<ul class="list-unstyled">
			<li class="border-top my-3"></li>
		</ul>
		<div class="container">
			<div class="form-group" style="margin: 10px">
				<label for="id">ID : ${vo.id} </label>
			</div>
			<div class="form-group" style="margin: 10px">
				<label for="name">이름 </label> <input type="text"
					class="form-control" id="name" placeholder="${vo.name}" name="name"
					required="required">
			</div>
			<div class="form-group" style="margin: 10px">
				<label for="age">나이 </label> <input type="text" class="form-control"
					id="age" placeholder="${vo.age}" name="age" required="required">
			</div>
			<div class="form-group" style="margin: 10px">
				<label for="gender">성별</label>
				<select class="form-select" aria-label="Default select example" name="gender">
					<option selected style="color: red">${vo.gender }</option>
					<option value="남자"> 남자</option>
					<option value="여자">여자</option>
				</select>
			</div>
		</div>
		<ul class="list-unstyled">
			<li class="border-top my-3"></li>
		</ul>
		<div class="form-group" style="text-align: right; margin-right: 10px;">
			<button type="submit" class="btn btn-secondary">수정</button>
		</div>
	</form>

</article>
<%--편집 구간 끝 --%>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
	function chooseGender(gen) {
		$('#gender').val(gen);
		//		console.log("gender=>" + $('#gender').val(gen))
		console.log("gender=>" + gen)
	}
</script>