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
					<tfoot id="page"></tfoot>
				</table>
			</div>
		</div>
	</div>
</article>

<script>
	//JQuery시작
	const paging = {
			page:1,
			count:5,
			bar:''
		
	}
	$(function() {
		$('#listBtn').click(
				function() {
					$.ajaxSetup({ 
						cache : false
					});
					$.ajax({
						url : "../memberJasonV3",
						success : function(jsonData) {
							$('#target').html(""); //비우기
							$.each(jsonData, function(k, v) {
								let htmlTag = "<tr>";
								$.each(v, function(k, v) {
								//console.log(k);
								if(v !== null && k !=='rn')
									htmlTag += "<td>" + v + "</td>"
								});
								htmlTag += "</tr>";
								$('#target').append(htmlTag);
							});
							
							$('#target>tr>td').css("background", "maroon").css(
									"text-align", "center").css("color",
									"#ffffff");
							
							$('#page').html("");
							let htmlTag = "<tr><td colspane='6' style = 'text-align:center'>";
							$.each(jsonData, function(k,v){
								//console.log(v);
								$.each(v, function(k, v) {
									if(k ==='rn')
									htmlTag += "[" + v + "]"
									});
							});
								htmlTag += "</td></tr>";
								$('#page').append(htmlTag);
						}
					});
					$('#target').html("<tr><td colspane='6'>test</td></tr>");
				});
	});
</script>