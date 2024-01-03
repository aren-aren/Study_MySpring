<%@page import="com.moveone.app.regions.RegionDTO"%>
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
	<h1>Regions List</h1>

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
	<a class="btn btn-outline-secondary" href="/regions/add">Add</a>
	<c:import url="../templates/bootstrap_js.jsp"></c:import>
</body>
</html>