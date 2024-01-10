<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Bootstrap demo</title>
<c:import url="../templates/boot_css.jsp"></c:import>
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
</head>
<body>
	<c:import url="../templates/header.jsp"></c:import>
	<section id="contents" class="container-fluid">
		<div class="row mt-4">
			<form action="/regions/add" method="post" enctype="multipart/form-data">
				<div class="mb-3">
					<label for="region-id" class="form-label">Region ID</label> 
					<!-- <input type="text" class="form-control" id="region-id" name="region_id" placeholder="Region Id"> -->
					<div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
				</div>
				<div class="mb-3">
					<label for="region-name" class="form-label">Region Content</label>
					<div class="form-floating">
						<!-- <textarea name="region_name" class="form-control" placeholder="Region Name" id="regionContents"></textarea> -->
						<input type="text" name="region_name">
					</div>
				</div>
				<div class="mb-3">
					<input name="photo" type="file">
				</div>
				<button type="submit" class="btn btn-primary">Add</button>
			</form>
		</div>
	</section>

	<c:import url="../templates/bootstrap_js.jsp"></c:import>

	<script type="text/javascript">
		$('#regionContents').summernote();
	</script>
</body>
</html>