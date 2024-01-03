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
	<section class="container-fluid mt-3">
		<div>
			<c:if test="${not empty dto}">
				<h3>${ dto.region_id }</h3>
				<div>${ dto.region_name }</div>
			</c:if>
			<c:if test="${empty dto }">
				<h3>없는 번호입니다.</h3>
			</c:if>
		</div>
	</section>

<c:import url="../templates/bootstrap_js.jsp"></c:import>
</body>
</html>