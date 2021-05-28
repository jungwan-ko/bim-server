<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<%@include file="../base/admin/inc/inc_header.jsp"%>
</head>
<body class="xp-vertical">
	<div id="xp-container" v-cloak>
		<div class="xp-leftbar">
			<div class="xp-sidebar">
				<div class="xp-logobar text-center">
					<a href="index.html" class="xp-logo">
						<img src="${pageContext.request.contextPath}/design_templates/vertical/assets/images/noaa-logo.png" class="img-fluid" alt="logo" style="width: 180px">
					</a>
				</div>
				<div class="xp-navigationbar">
					<ul class="xp-vertical-menu">
						<li class="xp-vertical-header">인원</li>
						<li><a href="javaScript:void();"><i class="mdi mdi-account"></i><span>고정완</span></a></li>
						<li>
							<a href="javaScript:void();"> <i class="mdi mdi-account-box-multiple"></i><span>개발 1팀</span><i class="mdi mdi-chevron-right pull-right"></i></a>
							<ul class="xp-vertical-submenu">
								<li><a href="page-login.html"><i class="mdi mdi-account"></i> 안경훈</a></li>
								<li><a href="page-register.html"><i class="mdi mdi-account"></i> 정다운</a></li>
								<li><a href="page-forgotpsw.html"><i class="mdi mdi-account"></i> 김도성</a></li>
								<li><a href="page-lock-screen.html"><i class="mdi mdi-account"></i> 김유리</a></li>
								<li><a href="page-comingsoon.html"><i class="mdi mdi-account"></i> 서상권</a></li>
							</ul>
						</li>
						<li>
							<a href="javaScript:void();"><i class="mdi mdi-account-box-multiple"></i><span>개발 2팀</span><i class="mdi mdi-chevron-right pull-right"></i></a>
							<ul class="xp-vertical-submenu">
								<li><a href="page-login.html"><i class="mdi mdi-account"></i> 강태구</a></li>
								<li><a href="page-register.html"><i class="mdi mdi-account"></i> 박민규</a></li>
								<li><a href="page-forgotpsw.html"><i class="mdi mdi-account"></i> 조봉연</a></li>
							</ul>
						</li>
						<li>
							<a href="javaScript:void();"> <i class="mdi mdi-account-box-multiple"></i><span>디자인실</span><i class="mdi mdi-chevron-right pull-right"></i></a>
							<ul class="xp-vertical-submenu">
								<li><a href="page-login.html"><i class="mdi mdi-account"></i> 여민하</a></li>
								<li><a href="page-register.html"><i class="mdi mdi-account"></i> 이지윤</a></li>
							</ul>
						</li>
						<li class="xp-vertical-header">프로젝트</li>
						<li>
							<a href="javaScript:void();"> <i class="mdi mdi-code-greater-than-or-equal"></i><span>java</span><i class="mdi mdi-chevron-right pull-right"></i></a>
							<ul class="xp-vertical-submenu">
								<li><a href="page-login.html">자연재해저감(fmps)</a></li>
								<li><a href="page-register.html">매핑</a></li>
								<li><a href="page-forgotpsw.html">공간정보(sdesign)</a></li>
								<li><a href="page-lock-screen.html">표준화(ADVIS)</a></li>
								<li><a href="page-comingsoon.html">메타데이터(남양주)</a></li>
								<li><a href="page-maintenance.html">SBB</a></li>
								<li><a href="page-404.html">NODD</a></li>
								<li><a href="page-404.html">DSAS</a></li>
							</ul>
						</li>
						<li>
							<a href="javaScript:void();"><i class="mdi mdi-code-greater-than-or-equal"></i><span>c#</span><i class="mdi mdi-chevron-right pull-right"></i></a>
							<ul class="xp-vertical-submenu">
								<li><a href="page-starter.html">건설기준코드 - 관리자</a></li>
								<li><a href="page-timeline.html">건설기준코드</a></li>
							</ul>
						</li>
						<li class="xp-vertical-header">업무</li>
						<li><a href="/prj/diary"><i class="mdi mdi-file-document"></i><span>업무일지</span></a></li>
						<li><a href="/prj/schedule"><i class="mdi mdi-calendar-today"></i><span>스케쥴</span></a></li>
					</ul>
				</div>
			</div>
		</div>
		<div class="xp-rightbar">
			<div class="xp-topbar">
				<div class="row">
					<div class="col-2 col-md-1 col-lg-1 order-2 order-md-1 align-self-center">
						<div class="xp-menubar">
							<a class="xp-menu-hamburger" href="javascript:void();">
								<i class="mdi mdi-sort-variant font-24 text-white"></i>
							</a>
						</div>
					</div>
                    <div class="col-md-5 col-lg-3 order-3 order-md-2"></div>
                    <div class="col-10 col-md-6 col-lg-8 order-1 order-md-3">
                    	<%@include file="../base/admin/inc/inc_top.jsp"%>
                    </div>
				</div>
			</div>
			<div class="xp-breadcrumbbar text-center">
				<h4 class="page-title">시스템 사업본부</h4>
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="#">인원</a></li>
					<li class="breadcrumb-item"><a href="#">프로젝트</a></li>
				</ol>           
            </div>    
            <div class="xp-contentbar">
                <div class="row">
                    <div class="col-md-6 col-lg-6 col-xl-3">
                    	 
                    </div>                    
                </div>
            </div>
            <%@include file="../base/admin/inc/inc_bottom.jsp"%>
        </div>
    </div>    
    <%@include file="../base/admin/inc/inc_header2.jsp"%>
</body>
</html>