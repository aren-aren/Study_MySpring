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
			<form action="./update" method="post">
				<div>
					<label for="region_id" class="form-label">Region Id</label> 
					<input 
						type="text" 
						class="form-control" 
						name="region_id" 
						value="${dto.region_id}" 
						readOnly
					>
				</div>
				<div class="mb-3">
					<label for="region-name" class="form-label">Region Name</label> 
					<input 
						type="text" 
						class="form-control" 
						id="region-name" 
						name="region_name" 
						placeholder="Region Name"
						value="${dto.region_name}"
					>
				</div>
				<button type="submit" class="btn btn-primary">UPDATE</button>
			</form>
		</div>
	</section>

	<c:import url="../templates/bootstrap_js.jsp"></c:import>
</body>
</html>