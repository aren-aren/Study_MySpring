<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Bootstrap demo</title>
<c:import url="../templates/boot_css.jsp"></c:import>
</head>
<body>
	<c:import url="../templates/header.jsp"></c:import>
	<section id="contents" class="container-fluid">
		<div class="row mt-4">
			<form action="/departments/add" method="post">
				<div class="mb-3">
					<label for="department-id" class="form-label">Department ID</label> 
					<input type="text" class="form-control" id="department-id" name="department_id" placeholder="department Id">
					<div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
				</div>
				<div class="mb-3">
					<label for="department-name" class="form-label">Department Name</label> 
					<input type="text" class="form-control" id="department-name" name="department_name" placeholder="department Name">
				</div>
				<div class="mb-3">
					<label for="manager-id" class="form-label">Manager Id</label> 
					<input type="text" class="form-control" id="manager-id" name="manager_id" placeholder="manager Name">
				</div>
				<div class="mb-3">
					<label for="location-id" class="form-label">Location Id</label> 
					<input type="text" class="form-control" id="location-id" name="location_id" placeholder="location Name">
				</div>
				<button type="submit" class="btn btn-primary">Add</button>
			</form>
		</div>
	</section>

	<c:import url="../templates/bootstrap_js.jsp"></c:import>
</body>
</html>