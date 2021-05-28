<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="xp-navigationbar">
	<ul class="xp-vertical-menu">
		<li class="xp-vertical-header">manage</li>
		<li>
			<a href="javaScript:void();"><i class="mdi mdi-desktop-mac-dashboard"></i><span>HOME</span></a>
		</li>
		<li>
			<a href="javaScript:void();"><i class="mdi mdi-code-greater-than-or-equal"></i><span>코드</span><i class="mdi mdi-chevron-right pull-right"></i></a>
			<ul class="xp-vertical-submenu">
				<li><router-link to="/codeList" class="nav-link">코드관리</router-link></li>
			</ul>
		</li>
		<li>
			<a href="javaScript:void();"><i class="mdi mdi-account"></i><span>사용자</span><i class="mdi mdi-chevron-right pull-right"></i></a>
			<ul class="xp-vertical-submenu">
				<li><router-link to="/userList" class="nav-link">사용자관리</router-link></li>
				<li><router-link to="/userLogList" class="nav-link">접속현황</router-link></li>
			</ul>
		</li>
		<li>
			<a href="javaScript:void();"><i class="mdi mdi-menu"></i><span>메뉴</span><i class="mdi mdi-chevron-right pull-right"></i></a>
			<ul class="xp-vertical-submenu">
				<li><router-link to="/menuList" class="nav-link">메뉴관리</router-link></li>
				<li><router-link to="/menuRoleMng" class="nav-link">권한관리</router-link></li>
			</ul>
		</li>
		<li>
			<a href="javaScript:void();"><i class="mdi mdi-bulletin-board"></i><span>게시판</span><i class="mdi mdi-chevron-right pull-right"></i></a>
			<ul class="xp-vertical-submenu">
				<li><router-link to="/bbsList" class="nav-link">게시판관리</router-link></li>
				<li><router-link to="/bbsContentList" class="nav-link">게시물관리</router-link></li>
			</ul>
		</li>
		<li class="xp-vertical-header">project</li>
		<li>
			<a href="javaScript:void();"> <i class="mdi mdi-security"></i><span>Authenication</span><i class="mdi mdi-chevron-right pull-right"></i></a>
			<ul class="xp-vertical-submenu">
				<li><a href="page-login.html">Login</a></li>
				<li><a href="page-register.html">Register</a></li>
				<li><a href="page-forgotpsw.html">Forgot Password</a></li>
				<li><a href="page-lock-screen.html">Lock Screen</a></li>
				<li><a href="page-comingsoon.html">Coming Soon</a></li>
				<li><a href="page-maintenance.html">Maintenance</a></li>
				<li><a href="page-404.html">Error 404</a></li>
				<li><a href="page-403.html">Error 403</a></li>
				<li><a href="page-500.html">Error 500</a></li>
				<li><a href="page-503.html">Error 503</a></li>
			</ul></li>
		<li>
			<a href="javaScript:void();"><i class="mdi mdi-book-open-page-variant"></i><span>Extra Pages</span><i class="mdi mdi-chevron-right pull-right"></i></a>
			<ul class="xp-vertical-submenu">
				<li><a href="page-starter.html">Starter Page</a></li>
				<li><a href="page-timeline.html">Timeline</a></li>
				<li><a href="page-pricing.html">Pricing</a></li>
				<li><a href="page-invoice.html">Invoice</a></li>
				<li><a href="page-faq.html">FAQ</a></li>
			</ul>
		</li>
	</ul>
</div>