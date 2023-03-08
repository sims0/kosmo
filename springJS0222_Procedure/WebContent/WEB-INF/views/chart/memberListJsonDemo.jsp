<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%--2023. 1. 17./ Kosmo --%>

<article>
	<header>
		<h1>memberListJsonDemo</h1>
	</header>
	<ul class="list-unstyled">
		<li class="border-top my-3"></li>
	</ul>
	<div class="container">
		<div class="row">
			<hr>
			<button id="listBtn" class="btn btn-outline-secondary">Click</button>
			<div class="row justify-content-center">
				<table class="table">
					<thead>
						<tr>
							<td>NUM</td>
							<td>ID</td>
							<td>NAME</td>
							<td>AGE</td>
							<td>GENDER</td>
						</tr>
					</thead>
					<tbody id="target"></tbody>
				</table>
			</div>
		</div>
	</div>
</article>

<script>
	//JQuery시작
	$(function() {
		$('#listBtn').click(
				function() {
					$.ajaxSetup({ 
						cache : false
					});
					$.ajax({
						url : "../deptJsonView2",
						success : function(jsonData) {
							$('#target').html(""); //비우기
							$.each(jsonData, function(k, v) {
								let htmlTag = "<tr>";
								$.each(v, function(k, v) {
									if(v !== null)
									htmlTag += "<td>" + v + "</td>"
								});
								htmlTag += "</tr>";
								$('#target').append(htmlTag);
							});
							
							$('#target>tr>td').css("background", "maroon").css(
									"text-align", "center").css("color",
									"#ffffff");
						}
					});
					$('#target').html("<tr><td colspane='6'>test</td></tr>");
				});
	});
</script>