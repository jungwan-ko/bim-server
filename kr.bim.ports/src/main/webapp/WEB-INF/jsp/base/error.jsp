<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>ERROR</title>
		<link href="${pageContext.request.contextPath}/contents/base/css/bootstrap.min.css"	rel="stylesheet">
		<link href="${pageContext.request.contextPath}/contents/base/fonts/css/font-awesome.min.css"	rel="stylesheet">
		<link type="text/css" rel="stylesheet"	href="${pageContext.request.contextPath}/contents/base/css/custom.css" />
	</head>
	<body class="nav-md">
		error
		<%-- <div class="container body">
			<div class="main_container">
				<div class="col-md-12">
					<div class="col-middle">
						<div class="text-center text-center">
							<h1 class="error-number">${statusCode}</h1>
							<h2>${message}</h2>
							<p>${reason}</p>
							<p>이전화면으로 이동하시겠습니까? <input type="button" class="btn btn-default btn-xs" value="BACK" onClick="history.go(-1)"></p>
							<div class="mid_center">
                				<h3><a class="btn btn-default" type="button" href="/account/logout?returnURI=/">MAIN</a></h3>
                			</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<script src="${pageContext.request.contextPath}/contents/base/js/jquery.min.js"></script>
		<script src="${pageContext.request.contextPath}/contents/base/js/bootstrap.min.js"></script>
		<script src="${pageContext.request.contextPath}/contents/base/js/"></script>
		<script src="${pageContext.request.contextPath}/contents/base/js/custom.js"></script> --%>
	</body>
</html>