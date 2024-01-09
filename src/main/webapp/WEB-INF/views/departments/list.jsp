<%@page import="com.moveone.app.departments.DepartmentDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
	<h1>Departments List</h1>

	<table class="table table-hover">
		<thead>
			<tr>
				<th>ID</th>
				<th>NAME</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${requestScope.list }" var="dto">
				<tr>
					<td>${pageScope.dto.department_id }</td>
					<td><a href="/departments/detail?department_id=${dto.department_id }">${pageScope.dto.department_name }</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div>
		<nav aria-label="Page navigation example">
			<ul class="pagination justify-content-center">
				<c:if test="${!pager.start }">
					<li class='page-item'>
						<a class="page-link" href="?page=${pager.startNum-1 }" aria-label="Previous"> 
							<span aria-hidden="true">&laquo;</span>
						</a>
					</li>
				</c:if>
				
				<c:forEach begin="${pager.startNum }" end="${pager.lastNum}" var="i">
					<li class="page-item">
						<a class="page-link" href="?page=${i}"> ${i} </a>
					</li>
				</c:forEach>
				
				<c:if test="${!pager.last }">
					<li class='page-item'>
						<a class="page-link" href="?page=${pager.lastNum+1 }" aria-label="Next"> 
							<span aria-hidden="true">&raquo;</span>
						</a>
					</li>
				</c:if>
			</ul>
		</nav>
	</div>
	<a class="btn btn-outline-secondary" href="/departments/add">Add</a>
	<c:import url="../templates/bootstrap_js.jsp"></c:import>
</body>
</html>