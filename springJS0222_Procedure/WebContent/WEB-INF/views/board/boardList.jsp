<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<article>
	<header>
		<h1>Board Demo</h1>
	</header>
	<ul class="list-unstyled">
		<li class="border-top my-3"></li>
	</ul>
	<div>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>조회수</th>
					<th>작성날짜</th>
				</tr>
			</thead>
			<tbody>
				<%-- for start --%>
				<c:forEach var="e" items="${list }">
					<tr>
						<td>${e.num }</td>
						<td><a href="boardDetail?num=${e.num }">${e.subject }</a></td>
						<td>${e.writer }</td>
						<td>1000</td>
						<td>${e.bdate}</td>
					</tr>
				</c:forEach>
				<%-- for end --%>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="5"><%@include file="../page/searchModule.jsp"%>
					</td>
				</tr>
				<tr>
					<td colspan="5" style="text-align: right;">
						<!-- 
      jQuery로 글작성 폼으로 이동시키기 id를 부여하여 선택자로 selector를 사용해서 이동시키기  footer.jsp에서 작성.
       -->
						<button type="button" class="btn btn-outline-secondary" id="wbtn">글작성</button>
					</td>
				</tr>
			</tfoot>
		</table>
	</div>

</article>
