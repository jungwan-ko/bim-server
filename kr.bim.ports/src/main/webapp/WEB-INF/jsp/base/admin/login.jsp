<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="description" content="Booster is a Responsive Bootstrap 4 Admin Dashboard, UI Kits with SCSS.">
    <meta name="keywords" content="admin template, dashboard template, ui kits, web app, crm, cms, responsive, bootstrap 4, html, sass support, scss">
    <meta name="author" content="xPanther Solutions">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">

    <title>Noaa Admin - Bootstrap 4 & Vuejs</title>

    <!-- Fevicon -->
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/static/design_templates/vertical/assets/images/noaa.ico">
    
    
    <!-- Sweet Alert -->
    <link href="${pageContext.request.contextPath}/static/design_templates/vertical/assets/plugins/sweet-alert2/sweetalert2.min.css" rel="stylesheet" type="text/css">
    

    <!-- Start CSS -->
    <link href="${pageContext.request.contextPath}/static/design_templates/vertical/assets/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/static/design_templates/vertical/assets/css/icons.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/static/design_templates/vertical/assets/css/style.css" rel="stylesheet" type="text/css">
    <!-- End CSS -->
</head>
<body class="xp-vertical"> 
	<div class="xp-authenticate-bg"></div>
    <div id="xp-container" class="xp-container">
		<div class="container" id="scope-login" v-cloak>
			<div class="row vh-100 align-items-center">
				<div class="col-lg-12 ">
					<div class="xp-auth-box">
						<div class="card">
							<div class="card-body">
								<h3 class="text-center mt-0 m-b-15">
									<a href="index.html" class="xp-web-logo"><img src="${pageContext.request.contextPath}/design_templates/vertical/assets/images/noaa-logo.png" class="img-fluid" alt="logo" style="width: 180px"></a>
								</h3>
								<div class="p-3">
									<form method="post" name="mainForm"	action="<c:url value="/account/login"/>">
										<div class="form-group">
											<input type="text" class="form-control" id="username" placeholder="Username" v-model="detailUser.user_id" required>
										</div>
										<div class="form-group">
											<input type="password" class="form-control" id="password" placeholder="Password" v-model="detailUser.user_pwd" v-on:keyup.enter="fnOnClickBtnLogin" required>
										</div>
										<div class="form-group" v-show="isAdmin">
											<input type="text" class="form-control" id="email" placeholder="E-Mail" v-model="detailUser.user_email" required>
										</div>
										<div class="form-row">
											<div class="form-group col-6"></div>
											<div class="form-group col-6 text-right">
												<label class="forgot-psw"><a id="forgot-psw" href="page-forgotpsw.html">비밀번호를 잊어버리셨나요?</a></label>
											</div>
										</div>
										<a href="#" class="btn btn-primary btn-rounded btn-lg btn-block" v-show="!isAdmin" v-on:click="fnOnClickBtnLogin">로 그 인</a>
										<a href="#" class="btn btn-primary btn-rounded btn-lg btn-block" v-show="isAdmin" v-on:click="fnOnCreateAdmin">관리자 계정생성</a>
										<div class="login-or"><h6 class="text-muted">OR</h6></div>
										<div class="text-center mb-3">
											<p class="text-muted">처음 접속이신가요? <a href="page-register.html">회원가입</a></p>											
										</div>
										<input type="hidden" id="keyM" name="loginInfo.keyModule" value="${vm.keyModule }" />
										<input type="hidden" id="keyEx" name="loginInfo.keyExponent" value="${vm.keyExponent }"/>
										<input type="hidden" id="encUserID" name="loginInfo.id" value=""/>
										<input type="hidden" id="encUserPwd" name="loginInfo.password" value=""/>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>		
	</div>
	

    <!-- Start JS -->        
    <script src="${pageContext.request.contextPath}/static/design_templates/vertical/assets/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/design_templates/vertical/assets/js/popper.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/design_templates/vertical/assets/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/design_templates/vertical/assets/js/modernizr.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/design_templates/vertical/assets/js/detect.js"></script>
    <script src="${pageContext.request.contextPath}/static/design_templates/vertical/assets/js/jquery.slimscroll.js"></script>
    <script src="${pageContext.request.contextPath}/static/design_templates/vertical/assets/js/sidebar-menu.js"></script>
    
    <!-- Sweet-Alert JS -->
    <script src="${pageContext.request.contextPath}/static/design_templates/vertical/assets/plugins/sweet-alert2/sweetalert2.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/design_templates/vertical/assets/js/init/sweet-alert-init.js"></script>
    
    <!-- Main JS -->
    <script src="${pageContext.request.contextPath}/static/design_templates/vertical/assets/js/main.js"></script>
    
    <script	src="${pageContext.request.contextPath}/static/contents/noaa/js/utils/rsa/jsbn.js"></script>
	<script	src="${pageContext.request.contextPath}/static/contents/noaa/js/utils/rsa/rsa.js"></script>
	<script	src="${pageContext.request.contextPath}/static/contents/noaa/js/utils/rsa/prng4.js"></script>
	<script	src="${pageContext.request.contextPath}/static/contents/noaa/js/utils/rsa/rng.js"></script>
	
	<script	src="${pageContext.request.contextPath}/static/contents/noaa/js/utils/bluebird.js"></script>
    
    <!-- End JS -->
    
    
	<script type="text/javascript">
    	var vueObj = null;
    	function pageLoad(obj) {
    		
    		vueObj = obj;
    		obj.fnPageInit();    	
    	}
	</script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/contents/noaa/js/model/vue/login-controller.min.js"></script>
</body>
</html>