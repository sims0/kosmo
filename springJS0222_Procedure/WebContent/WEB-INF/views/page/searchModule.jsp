<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

<c:set var="pageurl"
	value="?&searchType=${searchType}&searchValue=${searchValue}?cPage" />
<form action="?cPage">
	<nav aria-label="Page navigation example">
		<ul class="pagination justify-content-center">
			<c:choose>
				<c:when test="${startPage <= pagePerBlock }">
					<li class="page-item disabled"><a class="page-link" href="#"
						tabindex="-1" aria-disabled="true">Previous</a></li>
				</c:when>
				<c:otherwise>
					<li class="page-item active"><a class="page-link"
						href="${pageurl }=${startPage -1 }" tabindex="-1">Previous</a></li>
				</c:otherwise>
			</c:choose>
			<c:forEach varStatus="i" begin="${startPage }" end="${endPage }"
				step="1">
				<c:choose>
					<c:when test="${i.index == nowPage }">
						<li class="page-item active"><a class="page-link" href="#">${i.index}</a></li>
					</c:when>
					<c:otherwise>
						<li class="page-item "><a class="page-link"
							href="${pageurl }=${i.index }">${i.index}</a></li>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<%-- NextPage --%>
			<c:choose>
				<c:when test="${endPage >= totalPage }">
					<li class="page-item"><a href="" class="page-link"
						aria-disabled="true">Next</a></li>
				</c:when>
				<c:otherwise>
					<li class="page-item active"><a class="page-link"
						href="${pageurl }=${endPage + 1 }">Next</a></li>
				</c:otherwise>
			</c:choose>
	
			<div class="row g-3 align-middle text-center">
				<div class="col-auto">
					<select class="form-select" aria-label="Default select example"
						name="searchType" id="searchType">
						<option selected value="">검색</option>
						<option value="1">작성자</option>
						<option value="2">제목</option>
					</select>
				</div>
				<div class="col-auto">
					<label for="searchValue" class="visually-hidden">Password</label> <input
						type="text" class="form-control" id="searchValue"
						name="searchValue" placeholder="searchValue" />
				</div>
				<div class="col-auto">
					<button type="submit" class="btn btn-primary mb-3">Search</button>
				</div>
			</div>
</form>

</ul>
</nav>
