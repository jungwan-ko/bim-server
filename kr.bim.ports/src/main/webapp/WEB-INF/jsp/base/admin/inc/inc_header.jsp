<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="Booster is a Responsive Bootstrap 4 Admin Dashboard, UI Kits with SCSS.">
<meta name="keywords" content="admin template, dashboard template, ui kits, web app, crm, cms, responsive, bootstrap 4, html, sass support, scss">
<meta name="author" content="xPanther Solutions">
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
<title>Noaa Admin - Bootstrap 4 & Vuejs</title>
<!-- Fevicon -->
<link rel="shortcut icon" href="${pageContext.request.contextPath}/static/design_templates/vertical/assets/images/noaa.ico">
<!-- Start CSS -->
<!-- Summernote CSS -->
<link href="${pageContext.request.contextPath}/static/design_templates/vertical/assets/plugins/summernote/summernote-bs4.css" rel="stylesheet" />
<!-- jstree CSS -->
<link href="${pageContext.request.contextPath}/static/design_templates/vertical/assets/plugins/jstree/jstree.min.css" rel="stylesheet" type="text/css">
<!-- Dropzone CSS -->
<link href="${pageContext.request.contextPath}/static/design_templates/vertical/assets/plugins/dropzone/dist/dropzone.css" rel="stylesheet" type="text/css">
<!-- Sweet Alert -->
<link href="${pageContext.request.contextPath}/static/design_templates/vertical/assets/plugins/sweet-alert2/sweetalert2.min.css" rel="stylesheet" type="text/css">
<!-- Datepicker CSS -->
<link href="${pageContext.request.contextPath}/static/design_templates/vertical/assets/plugins/datepicker/datepicker.min.css" rel="stylesheet" type="text/css">
<!-- Chartist Chart CSS -->
<%-- <link rel="stylesheet" href="${pageContext.request.contextPath}/static/design_templates/vertical/assets/plugins/chartist-js/chartist.min.css"> --%>
<link href="${pageContext.request.contextPath}/static/design_templates/vertical/assets/plugins/jquery-confirm/css/jquery-confirm.css" rel="stylesheet" type="text/css">

<link href="${pageContext.request.contextPath}/static/design_templates/vertical/assets/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/static/design_templates/vertical/assets/css/icons.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/static/design_templates/vertical/assets/css/style.css" rel="stylesheet" type="text/css">
<!-- End CSS -->

<style>
#chartTree {
	background: #fff;
	font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
	width: 100%;
	height: 100%;
}

.title {
	font-weight: bold;
	font-size: 24px;
	text-align: center;
	margin-top: 6px;
	margin-bottom: 6px;
}

text {
	pointer-events: none;
}

.grandparent text {
	font-weight: bold;
}

rect {
	fill: none;
	stroke: #fff;
}

rect.parent, .grandparent rect {
	stroke-width: 2px;
}

rect.parent {
	pointer-events: none;
}

.grandparent rect {
	fill: orange;
}

.grandparent:hover rect {
	fill: #ee9700;
}

.children rect.parent, .grandparent rect {
	cursor: pointer;
}

.children rect.parent {
	fill: #bbb;
	fill-opacity: .5;
}

.children:hover rect.child {
	fill: #bbb;
}
</style>