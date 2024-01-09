<%@page import="com.moveone.app.regions.RegionDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Bootstrap demo</title>
<c:import url="../templates/boot_css.jsp"></c:import>
</head>
<body>
	<c:import url="../templates/header.jsp"></c:import>
	<h1>Regions List</h1>

	<div>
		<form class="row g-3" action="./list" method="get">
			<div class="col-auto">
				<select class="form-select" name="kind" aria-label="Default select example">
					<option value="kind1">Title</option>
					<option value="kind2">Content</option>
					<option value="kind3">Writer</option>
					<option value="kind4">Title+Content+Writer</option>
				</select>
			</div>
			<div class="col-auto">
				<label for="search" class="visually-hidden">Search</label> <input type="text" name="search" class="form-control" id="search">
			</div>
			<div class="col-auto">
				<button type="submit" class="btn btn-primary mb-3">search</button>
			</div>
		</form>
	</div>

	<table class="table table-hover">
		<thead>
			<tr>
				<th>ID</th>
				<th>NAME</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${ requestScope.list }" var="dto">
				<tr>
					<td>${ pageScope.dto.region_id }</td>
					<td><a href="/regions/detail?region_id=${ dto.region_id }">${ pageScope.dto.region_name }</a></td>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot>

		</tfoot>
	</table>
	<div>
		<nav aria-label="Page navigation example">
			<ul class="pagination justify-content-center">
				<c:if test="${!pager.start }">
					<li class='page-item'><a class="page-link" href="?page=${pager.startNum-1 }&search=${pager.search}&kind=${pager.kind}" aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
					</a></li>
				</c:if>

				<c:forEach begin="${pager.startNum }" end="${pager.lastNum}" var="i">
					<li class="page-item"><a class="page-link" href="?page=${i}&search=${pager.search}&kind=${pager.kind}"> ${i} </a></li>
				</c:forEach>

				<c:if test="${!pager.last }">
					<li class='page-item'><a class="page-link" href="?page=${pager.lastNum+1 }&search=${pager.search}&kind=${pager.kind}" aria-label="Next"> <span aria-hidden="true">&raquo;</span>
					</a></li>
				</c:if>
			</ul>
		</nav>
	</div>
	<a class="btn btn-outline-secondary" href="/regions/add">Add</a>
	<c:import url="../templates/bootstrap_js.jsp"></c:import>
</body>
</html>