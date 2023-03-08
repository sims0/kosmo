<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%--2023. 1. 17./ Kosmo --%>

<article>
	<header>
		<h1>[회원찾기]deptJsonDemo</h1>
	</header>
	<ul class="list-unstyled">
		<li class="border-top my-3"></li>
	</ul>
	<div class="container">
		<div class="row">
			ID: <input type="text" id="id" name="id" placeholder="id를 입력하시오">
			<hr>
			<button id="jsonAjaxTest" class="btn btn-outline-secondary">Click</button>
			<div id="target">target!</div>
		</div>
	</div>
</article>

<script>
	//JQuery시작
	$(function() {
		//$('#target') jquery객체
		$('#jsonAjaxTest').click(
				function() {
					alert("Test" + $('#id').val());
					$.ajaxSetup({ //ajax캐시 삭제
						cache : false
					});
					$.ajax({ //json을 부르자
						url : "../deptJsonView1?id=" + $('#id').val(),
						success : function(jsonData) {
							$('#target').html(""); //비우기
							console.log(jsonData);
							console.log(Object.keys(jsonData));
							console.log(Object.valueOf(jsonData));
							$.each(jsonData, function(k, v) {
								console.log(k + ":" + v);
								$('#target').append(
										"<p>" + k + " : " + v + "</p>");
							});
							$('#target>p').css("background", "maroon").css(
									"text-align", "center").css("color",
									"#ffffff");
						}
					});
				});
	});
</script>