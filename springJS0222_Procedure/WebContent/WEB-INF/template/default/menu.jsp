<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%--bg-dark navbar-dark --%>
<nav class="navbar navbar-expand-sm mybgColor">
	<div class="container-fluid">
		<ul class="navbar-nav">
			<!-- 
			<li class="nav-item">
			<a class="nav-link active" aria-current="page" href="#">Home</a></li> -->
			<li class="nav-item"><a href="${pageContext.request.contextPath}/web/mail/emailForm" class="nav-link">Contact</a></li>	
			<!--  -->
			<li class="nav-item dropdown">
			<a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false"> Board</a>
				<ul class="dropdown-menu">
					<li><a class="dropdown-item" href="${pageContext.request.contextPath}/web/board/boardList">Board</a></li>
					<li><a class="dropdown-item" href="${pageContext.request.contextPath}/web/board/boardSearchList">SearchBoard</a></li>
					<li><a class="dropdown-item" href="${pageContext.request.contextPath}/web/upload/upboardList?&searchType=&searchValue=?cPage=1">UpLoad</a></li>
				</ul></li>
			<!--  -->
			<li class="nav-item dropdown">
			 <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">Sawon</a> 
				<ul class="dropdown-menu">
					<li><a class="dropdown-item" href="${pageContext.request.contextPath}/web/deptForm" class="nav-link">deptList</a></li>
					<li><a class="dropdown-item" href="${pageContext.request.contextPath}/web/sPhoneList" class="nav-link">SawonPhoneList</a></li>
					<li><a class="dropdown-item" href="${pageContext.request.contextPath}/web/testProcedure" class="nav-link">testProcedure</a></li>
				</ul></li>
			<!--  -->
			<li class="nav-item dropdown">
			<a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false"> survey</a>
				<ul class="dropdown-menu">
					<li><a class="dropdown-item" href="${pageContext.request.contextPath}/web//survey/surveyForm" class="nav-link">survey</a></li>
					<li><a class="dropdown-item" href="${pageContext.request.contextPath}/web/survey/surveychForm" class="nav-link">surveyDetail</a></li>
				</ul></li>
			<!--  -->
			<li class="nav-item dropdown">
			<a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false"> chart</a>
			<ul class="dropdown-menu">
			<li><a class="dropdown-item" href="${pageContext.request.contextPath}/web/mychart/bar">Bar</a></li>
			<li><a class="dropdown-item" href="${pageContext.request.contextPath}/web/mychart/donut">Donut</a></li>
			<li><a class="dropdown-item" href="${pageContext.request.contextPath}/web/mychart/donut2">Donut(noname)</a></li>
			<li><a class="dropdown-item" href="${pageContext.request.contextPath}/web/mychart/deptJsonDemo">deptJsonDemo</a></li>
			<li><a class="dropdown-item" href="${pageContext.request.contextPath}/web/mychart/memberListJsonDemo">memberListJsonDemo</a></li>
			<li><a class="dropdown-item" href="${pageContext.request.contextPath}/web/mychart/memberPageJson">memberPageJson</a></li>
			<li><a class="dropdown-item" href="${pageContext.request.contextPath}/web/mychart/surveyDonutchartAjax?num=21">surveyDonutchartAjax</a></li>
			<li><a class="dropdown-item" href="${pageContext.request.contextPath}/web/mychart/surveyChartAjaxTitle?num=21">surveyJsonObjTitle</a></li>
		<!-- 	<li><a class="dropdown-item" href="${pageContext.request.contextPath}/web/mychart/">AjaxChart</a></li>
		 -->
			</ul></li>
			<!--  -->
		</ul>
	</div>

	<!--  		<li class="nav-item"><a href="#" class="nav-link">Profile</a></li>-->

	<form class="d-flex">
		<input class="form-control me-2" type="text" placeholder="Search"
			name="searchv" id="searchv">
		<button class="btn btn-primary" type="button">Search</button>
	</form>

</nav>