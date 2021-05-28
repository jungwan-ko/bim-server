<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="xp-profilebar text-right">
	<ul class="list-inline mb-0">
		<li class="list-inline-item"></li>
		<li class="list-inline-item"></li>
		<li class="list-inline-item mr-0">
			<div class="dropdown xp-userprofile">
				<a class="dropdown-toggle user-profile-img" href="#" role="button" id="xp-userprofile" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><img src="${pageContext.request.contextPath}/static/design_templates/vertical/assets/images/topbar/user.jpg" alt="user-profile" class="rounded-circle img-fluid"><span class="xp-user-live"></span></a>
				<div class="dropdown-menu dropdown-menu-right" aria-labelledby="xp-userprofile">
					<a class="dropdown-item" href="#">Welcome, John Doe</a>
					<a class="dropdown-item" href="/system/manage/default"><i class="mdi mdi-account mr-2"></i> 관리자</a>
					<a class="dropdown-item" href="#"><i class="mdi mdi-credit-card mr-2"></i> Billing</a>
					<a class="dropdown-item" href="#"><i class="mdi mdi-settings mr-2"></i> Setting</a>
					<a class="dropdown-item" href="#"><i class="mdi mdi-lock mr-2"></i> Lock Screen</a>
					<a class="dropdown-item" href="/account/logout?returnURI=/"><i class="mdi mdi-logout mr-2"></i> Logout</a>
				</div>
			</div>
		</li>
	</ul>
</div>