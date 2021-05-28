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
                    	<h6 class="dark"><b>자연재해저감 종합계획시스템</b><a href="http://61.105.196.70:10001/" target="_blank"><i class="mdi mdi-open-in-new pull-right"></i></a></h6>
                        <div class="card m-b-30">
                            <img class="card-img-top" src="${pageContext.request.contextPath}/contents/img_file/10001.PNG" alt="Card image cap" style="border: 1px solid rgb(0, 0, 0);">
                            <div class="card-body">
                                <ul class="nav nav-tabs mb-3" id="defaultTab" role="tablist">
                                  <li class="nav-item">
                                    <a class="nav-link active" id="home-tab" data-toggle="tab" href="#home10001" role="tab" aria-controls="home10001" aria-selected="true">Info</a>
                                  </li>
                                  <li class="nav-item">
                                    <a class="nav-link" id="profile-tab" data-toggle="tab" href="#profile10001" role="tab" aria-controls="profile10001" aria-selected="false">Technics</a>
                                  </li>
                                  <li class="nav-item">
                                    <a class="nav-link" id="contact-tab" data-toggle="tab" href="#contact10001" role="tab" aria-controls="contact10001" aria-selected="false">developer</a>
                                  </li>
                                </ul>
                                <div class="tab-content" id="defaultTabContent" style="height: 150px;overflow: auto;">
                                  <div class="tab-pane fade show active" id="home10001" role="tabpanel" aria-labelledby="home-tab">
                                      <div class="card-body" style="padding-top: 5px;padding-bottom: 5px">
                                      	<p class="card-text">용역<br>재난안전연구원 <br></p>
                                      </div>
                                      <ul class="list-group list-group-flush">
			                                <li class="list-group-item">Vestibulum at eros</li>
			                            </ul>
                                  </div>
                                  <div class="tab-pane fade" id="profile10001" role="tabpanel" aria-labelledby="profile-tab">
                                      <p>Java 1.8 / postgresql / angularjs</p>
                                  </div>
								<div class="tab-pane fade" id="contact10001" role="tabpanel" aria-labelledby="contact-tab">
									<div class="row" style="margin-left: 0px;margin-right: 0px;">
										<div class="col-md-6 col-lg-6">
											<p><img class="card-img-top" src="${pageContext.request.contextPath}/contents/img_file/akh.png" alt="" style="border: 1px solid rgb(0, 0, 0);width: 50px;height: 50px"> 안경훈</p>
										</div>
										<div class="col-md-6 col-lg-6">
											<p><img class="card-img-top" src="${pageContext.request.contextPath}/contents/img_file/jdw.png" alt="" style="border: 1px solid rgb(0, 0, 0);width: 50px;height: 50px"> 정다운</p>
										</div>
										<div class="col-md-6 col-lg-6">
											<p><img class="card-img-top" src="${pageContext.request.contextPath}/contents/img_file/ssk.png" alt="" style="border: 1px solid rgb(0, 0, 0);width: 50px;height: 50px"> 서상권</p>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>  
                    </div>

                    <div class="col-md-6 col-lg-6 col-xl-3">
                        <h6><b>재난현장 지원 매핑서비스</b><a href="http://61.105.196.70:10002/" target="_blank"><i class="mdi mdi-open-in-new pull-right"></i></a></h6>
                        <div class="card m-b-30">
                            <img class="card-img-top" src="${pageContext.request.contextPath}/contents/img_file/10002.PNG" alt="Card image cap" style="border: 1px solid rgb(0, 0, 0);">
                            <div class="card-body">
                                <ul class="nav nav-tabs mb-3" id="defaultTab" role="tablist">
                                  <li class="nav-item">
                                    <a class="nav-link active" id="home-tab" data-toggle="tab" href="#home10002" role="tab" aria-controls="home10002" aria-selected="true">Info</a>
                                  </li>
                                  <li class="nav-item">
                                    <a class="nav-link" id="profile-tab" data-toggle="tab" href="#profile10002" role="tab" aria-controls="profile10002" aria-selected="false">Technics</a>
                                  </li>
                                  <li class="nav-item">
                                    <a class="nav-link" id="contact-tab" data-toggle="tab" href="#contact10002" role="tab" aria-controls="contact10002" aria-selected="false">developer</a>
                                  </li>
                                </ul>
                                <div class="tab-content" id="defaultTabContent" style="height: 150px;overflow: auto;">
                                  <div class="tab-pane fade show active" id="home10002" role="tabpanel" aria-labelledby="home-tab">
                                      <div class="card-body" style="padding-top: 5px;padding-bottom: 5px">
                                      	<p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                                      </div>
                                      <ul class="list-group list-group-flush">
			                                <li class="list-group-item">Dapibus ac facilisis in</li>
			                            </ul>
                                  </div>
                                  <div class="tab-pane fade" id="profile10002" role="tabpanel" aria-labelledby="profile-tab">
                                      <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.</p>
                                  </div>
                                  <div class="tab-pane fade" id="contact10002" role="tabpanel" aria-labelledby="contact-tab">
                                  	<div class="row" style="margin-left: 0px;margin-right: 0px;">
										<div class="col-md-6 col-lg-6">
											<p><img class="card-img-top" src="${pageContext.request.contextPath}/contents/img_file/ktg.png" alt="" style="border: 1px solid rgb(0, 0, 0);width: 50px;height: 50px"> 강태구</p>
										</div>
										<div class="col-md-6 col-lg-6">
											<p><img class="card-img-top" src="${pageContext.request.contextPath}/contents/img_file/pmg.png" alt="" style="border: 1px solid rgb(0, 0, 0);width: 50px;height: 50px"> 박민규</p>
										</div>
										<div class="col-md-6 col-lg-6">
											<p><img class="card-img-top" src="${pageContext.request.contextPath}/contents/img_file/jby.png" alt="" style="border: 1px solid rgb(0, 0, 0);width: 50px;height: 50px"> 조봉연</p>
										</div>
									</div>
                                  </div>
                                </div>
                            </div>
                        </div>  
                    </div>
					<div class="col-md-6 col-lg-6 col-xl-3">
						<h6><b>실감형 콘텐츠 융복합 기술개발 사업</b><a href="http://61.105.196.70:10003/" target="_blank"><i class="mdi mdi-open-in-new pull-right"></i></a></h6>
                        <div class="card m-b-30">
                            <img class="card-img-top" src="${pageContext.request.contextPath}/contents/img_file/10003.PNG" alt="Card image cap" style="border: 1px solid rgb(0, 0, 0);">
                            <div class="card-body">
                                <ul class="nav nav-tabs mb-3" id="defaultTab" role="tablist">
                                  <li class="nav-item">
                                    <a class="nav-link active" id="home-tab" data-toggle="tab" href="#home10003" role="tab" aria-controls="home10003" aria-selected="true">Info</a>
                                  </li>
                                  <li class="nav-item">
                                    <a class="nav-link" id="profile-tab" data-toggle="tab" href="#profile10003" role="tab" aria-controls="profile10003" aria-selected="false">Technics</a>
                                  </li>
                                  <li class="nav-item">
                                    <a class="nav-link" id="contact-tab" data-toggle="tab" href="#contact10003" role="tab" aria-controls="contact10003" aria-selected="false">developer</a>
                                  </li>
                                </ul>
                                <div class="tab-content" id="defaultTabContent" style="height: 150px;overflow: auto;">
                                  <div class="tab-pane fade show active" id="home10003" role="tabpanel" aria-labelledby="home-tab">
                                      <div class="card-body" style="padding-top: 5px;padding-bottom: 5px">
                                      	<p class="card-text">연구과제<br>ETRI</p>
                                      </div>
                                      <ul class="list-group list-group-flush">
			                                <li class="list-group-item">Dapibus ac facilisis in</li>
			                            </ul>
                                  </div>
                                  <div class="tab-pane fade" id="profile10003" role="tabpanel" aria-labelledby="profile-tab">
                                      <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.</p>
                                  </div>
                                  <div class="tab-pane fade" id="contact10003" role="tabpanel" aria-labelledby="contact-tab">
                                      <div class="row" style="margin-left: 0px;margin-right: 0px;">
										<div class="col-md-6 col-lg-6">
											<p><img class="card-img-top" src="${pageContext.request.contextPath}/contents/img_file/akh.png" alt="" style="border: 1px solid rgb(0, 0, 0);width: 50px;height: 50px"> 안경훈</p>
										</div>
										<div class="col-md-6 col-lg-6">
											<p><img class="card-img-top" src="${pageContext.request.contextPath}/contents/img_file/jdw.png" alt="" style="border: 1px solid rgb(0, 0, 0);width: 50px;height: 50px"> 정다운</p>
										</div>
										<div class="col-md-6 col-lg-6">
											<p><img class="card-img-top" src="${pageContext.request.contextPath}/contents/img_file/ssk.png" alt="" style="border: 1px solid rgb(0, 0, 0);width: 50px;height: 50px"> 서상권</p>
										</div>
									</div>
                                  </div>
                                </div>
                            </div>
                        </div>  
                    </div>
                    <div class="col-md-6 col-lg-6 col-xl-3">
                        <h6><b>표준화(ADVIS)</b><a href="http://61.105.196.70:10004/" target="_blank"><i class="mdi mdi-open-in-new pull-right"></i></a></h6>
                        <div class="card m-b-30">
                            <img class="card-img-top" src="${pageContext.request.contextPath}/contents/img_file/10004.PNG" alt="Card image cap" style="border: 1px solid rgb(0, 0, 0);">
                            <div class="card-body">
                                <ul class="nav nav-tabs mb-3" id="defaultTab" role="tablist">
                                  <li class="nav-item">
                                    <a class="nav-link active" id="home-tab" data-toggle="tab" href="#home10004" role="tab" aria-controls="home10004" aria-selected="true">Info</a>
                                  </li>
                                  <li class="nav-item">
                                    <a class="nav-link" id="profile-tab" data-toggle="tab" href="#profile10004" role="tab" aria-controls="profile10004" aria-selected="false">Technics</a>
                                  </li>
                                  <li class="nav-item">
                                    <a class="nav-link" id="contact-tab" data-toggle="tab" href="#contact10004" role="tab" aria-controls="contact10004" aria-selected="false">developer</a>
                                  </li>
                                </ul>
                                <div class="tab-content" id="defaultTabContent" style="height: 150px;overflow: auto;">
                                  <div class="tab-pane fade show active" id="home10004" role="tabpanel" aria-labelledby="home-tab">
                                      <div class="card-body" style="padding-top: 5px;padding-bottom: 5px">
                                      	<p class="card-text">연구과제<br></p>
                                      </div>
                                      <ul class="list-group list-group-flush">
			                                <li class="list-group-item">Dapibus ac facilisis in</li>
			                            </ul>
                                  </div>
                                  <div class="tab-pane fade" id="profile10004" role="tabpanel" aria-labelledby="profile-tab">
                                      <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.</p>
                                  </div>
                                  <div class="tab-pane fade" id="contact10004" role="tabpanel" aria-labelledby="contact-tab">
                                      <div class="row" style="margin-left: 0px;margin-right: 0px;">
										<div class="col-md-6 col-lg-6">
											<p><img class="card-img-top" src="${pageContext.request.contextPath}/contents/img_file/kjw.png" alt="" style="border: 1px solid rgb(0, 0, 0);width: 50px;height: 50px"> 고정완</p>
										</div>
										<div class="col-md-6 col-lg-6">
											<p><img class="card-img-top" src="${pageContext.request.contextPath}/contents/img_file/kyr.png" alt="" style="border: 1px solid rgb(0, 0, 0);width: 50px;height: 50px"> 김유리</p>
										</div>
									</div>
                                  </div>
                                </div>
                            </div>
                        </div>  
                    </div>
                    <div class="col-md-6 col-lg-6 col-xl-3">
                    	<h6><b>메타데이터 관리시스템(남양주)</b><a href="http://61.105.196.70:10005/" target="_blank"><i class="mdi mdi-open-in-new pull-right"></i></a></h6>
                        <div class="card m-b-30">
                            <img class="card-img-top" src="${pageContext.request.contextPath}/contents/img_file/10005.PNG" alt="Card image cap" style="border: 1px solid rgb(0, 0, 0);">
                            <div class="card-body">
                                <ul class="nav nav-tabs mb-3" id="defaultTab" role="tablist">
                                  <li class="nav-item">
                                    <a class="nav-link active" id="home-tab" data-toggle="tab" href="#home10005" role="tab" aria-controls="home10005" aria-selected="true">Info</a>
                                  </li>
                                  <li class="nav-item">
                                    <a class="nav-link" id="profile-tab" data-toggle="tab" href="#profile10005" role="tab" aria-controls="profile10005" aria-selected="false">Technics</a>
                                  </li>
                                  <li class="nav-item">
                                    <a class="nav-link" id="contact-tab" data-toggle="tab" href="#contact10005" role="tab" aria-controls="contact10005" aria-selected="false">developer</a>
                                  </li>
                                </ul>
                                <div class="tab-content" id="defaultTabContent" style="height: 150px;overflow: auto;">
                                  <div class="tab-pane fade show active" id="home10005" role="tabpanel" aria-labelledby="home-tab">
                                      <div class="card-body" style="padding-top: 5px;padding-bottom: 5px">
                                      	<p class="card-text">용역<br>남양주시청</p>
                                      </div>
                                      <ul class="list-group list-group-flush">
			                                <li class="list-group-item">Dapibus ac facilisis in</li>
			                            </ul>
                                  </div>
                                  <div class="tab-pane fade" id="profile10005" role="tabpanel" aria-labelledby="profile-tab">
                                      <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.</p>
                                  </div>
                                  <div class="tab-pane fade" id="contact10005" role="tabpanel" aria-labelledby="contact-tab">
                                      <div class="row" style="margin-left: 0px;margin-right: 0px;">
										<div class="col-md-6 col-lg-6">
											<p><img class="card-img-top" src="${pageContext.request.contextPath}/contents/img_file/akh.png" alt="" style="border: 1px solid rgb(0, 0, 0);width: 50px;height: 50px"> 안경훈</p>
										</div>
										<div class="col-md-6 col-lg-6">
											<p><img class="card-img-top" src="${pageContext.request.contextPath}/contents/img_file/jdw.png" alt="" style="border: 1px solid rgb(0, 0, 0);width: 50px;height: 50px"> 정다운</p>
										</div>
									</div>
                                  </div>
                                </div>
                            </div>
                        </div>  
                    </div>
					<div class="col-md-6 col-lg-6 col-xl-3">
						<h6><b>스마트재난상황관리시스템</b><a href="http://61.105.196.70:10006/" target="_blank"><i class="mdi mdi-open-in-new pull-right"></i></a></h6>
                        <div class="card m-b-30">
                            <img class="card-img-top" src="${pageContext.request.contextPath}/contents/img_file/10006.PNG" alt="Card image cap" style="border: 1px solid rgb(0, 0, 0);">
                            <div class="card-body">
                                <ul class="nav nav-tabs mb-3" id="defaultTab" role="tablist">
                                  <li class="nav-item">
                                    <a class="nav-link active" id="home-tab" data-toggle="tab" href="#home10006" role="tab" aria-controls="home10006" aria-selected="true">Info</a>
                                  </li>
                                  <li class="nav-item">
                                    <a class="nav-link" id="profile-tab" data-toggle="tab" href="#profile10006" role="tab" aria-controls="profile10006" aria-selected="false">Technics</a>
                                  </li>
                                  <li class="nav-item">
                                    <a class="nav-link" id="contact-tab" data-toggle="tab" href="#contact10006" role="tab" aria-controls="contact10006" aria-selected="false">developer</a>
                                  </li>
                                </ul>
                                <div class="tab-content" id="defaultTabContent" style="height: 150px;overflow: auto;">
                                  <div class="tab-pane fade show active" id="home10006" role="tabpanel" aria-labelledby="home-tab">
                                      <div class="card-body">
                                      	<p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                                      </div>
                                      <ul class="list-group list-group-flush">
			                                <li class="list-group-item">Dapibus ac facilisis in</li>
			                            </ul>
                                  </div>
                                  <div class="tab-pane fade" id="profile10006" role="tabpanel" aria-labelledby="profile-tab">
                                      <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.</p>
                                  </div>
                                  <div class="tab-pane fade" id="contact10006" role="tabpanel" aria-labelledby="contact-tab">
                                      <div class="row" style="margin-left: 0px;margin-right: 0px;">
										<div class="col-md-6 col-lg-6">
											<p><img class="card-img-top" src="${pageContext.request.contextPath}/contents/img_file/ktg.png" alt="" style="border: 1px solid rgb(0, 0, 0);width: 50px;height: 50px"> 강태구</p>
										</div>
										<div class="col-md-6 col-lg-6">
											<p><img class="card-img-top" src="${pageContext.request.contextPath}/contents/img_file/pmg.png" alt="" style="border: 1px solid rgb(0, 0, 0);width: 50px;height: 50px"> 박민규</p>
										</div>
										<div class="col-md-6 col-lg-6">
											<p><img class="card-img-top" src="${pageContext.request.contextPath}/contents/img_file/jby.png" alt="" style="border: 1px solid rgb(0, 0, 0);width: 50px;height: 50px"> 조봉연</p>
										</div>
									</div>
                                  </div>
                                </div>
                            </div>
                        </div>  
                    </div>
					<div class="col-md-6 col-lg-6 col-xl-3">
						<h6><b>NODD</b><a href="http://61.105.196.70:10007/" target="_blank"><i class="mdi mdi-open-in-new pull-right"></i></a></h6>
                        <div class="card m-b-30">
                            <img class="card-img-top" src="${pageContext.request.contextPath}/contents/img_file/10007.PNG" alt="Card image cap" style="border: 1px solid rgb(0, 0, 0);">
                            <div class="card-body">
                                <ul class="nav nav-tabs mb-3" id="defaultTab" role="tablist">
                                  <li class="nav-item">
                                    <a class="nav-link active" id="home-tab" data-toggle="tab" href="#home10007" role="tab" aria-controls="home10007" aria-selected="true">Info</a>
                                  </li>
                                  <li class="nav-item">
                                    <a class="nav-link" id="profile-tab" data-toggle="tab" href="#profile10007" role="tab" aria-controls="profile10007" aria-selected="false">Technics</a>
                                  </li>
                                  <li class="nav-item">
                                    <a class="nav-link" id="contact-tab" data-toggle="tab" href="#contact10007" role="tab" aria-controls="contact10007" aria-selected="false">developer</a>
                                  </li>
                                </ul>
                                <div class="tab-content" id="defaultTabContent" style="height: 150px;overflow: auto;">
                                  <div class="tab-pane fade show active" id="home10007" role="tabpanel" aria-labelledby="home-tab">
                                      <div class="card-body" style="padding-top: 5px;padding-bottom: 5px">
                                      	<p class="card-text">자체프로젝트<br></p>
                                      </div>
                                      <ul class="list-group list-group-flush">
			                                <li class="list-group-item">Dapibus ac facilisis in</li>
			                            </ul>
                                  </div>
                                  <div class="tab-pane fade" id="profile10007" role="tabpanel" aria-labelledby="profile-tab">
                                      <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.</p>
                                  </div>
                                  <div class="tab-pane fade" id="contact10007" role="tabpanel" aria-labelledby="contact-tab">
                                  	<div class="row" style="margin-left: 0px;margin-right: 0px;">
                                  		<div class="col-md-6 col-lg-6">
											<p><img class="card-img-top" src="${pageContext.request.contextPath}/contents/img_file/kjw.png" alt="" style="border: 1px solid rgb(0, 0, 0);width: 50px;height: 50px"> 고정완</p>
										</div>
										<div class="col-md-6 col-lg-6">
											<p><img class="card-img-top" src="${pageContext.request.contextPath}/contents/img_file/akh.png" alt="" style="border: 1px solid rgb(0, 0, 0);width: 50px;height: 50px"> 안경훈</p>
										</div>
										<div class="col-md-6 col-lg-6">
											<p><img class="card-img-top" src="${pageContext.request.contextPath}/contents/img_file/jdw.png" alt="" style="border: 1px solid rgb(0, 0, 0);width: 50px;height: 50px"> 정다운</p>
										</div>
										<div class="col-md-6 col-lg-6">
											<p><img class="card-img-top" src="${pageContext.request.contextPath}/contents/img_file/kyr.png" alt="" style="border: 1px solid rgb(0, 0, 0);width: 50px;height: 50px"> 김유리</p>
										</div>
										<div class="col-md-6 col-lg-6">
											<p><img class="card-img-top" src="${pageContext.request.contextPath}/contents/img_file/pmg.png" alt="" style="border: 1px solid rgb(0, 0, 0);width: 50px;height: 50px"> 박민규</p>
										</div>
									</div>
                                  </div>
                                </div>
                            </div>
                        </div>  
                    </div>
                    <div class="col-md-6 col-lg-6 col-xl-3">
						<h6><b>재해상황분석시스템</b><a href="http://61.105.196.70:10008/" target="_blank"><i class="mdi mdi-open-in-new pull-right"></i></a></h6>
                        <div class="card m-b-30">
                            <img class="card-img-top" src="${pageContext.request.contextPath}/contents/img_file/10008.PNG" alt="Card image cap" style="border: 1px solid rgb(0, 0, 0);">
                            <div class="card-body">
                                <ul class="nav nav-tabs mb-3" id="defaultTab" role="tablist">
                                  <li class="nav-item">
                                    <a class="nav-link active" id="home-tab" data-toggle="tab" href="#home10008" role="tab" aria-controls="home10008" aria-selected="true">Info</a>
                                  </li>
                                  <li class="nav-item">
                                    <a class="nav-link" id="profile-tab" data-toggle="tab" href="#profile10008" role="tab" aria-controls="profile10008" aria-selected="false">Technics</a>
                                  </li>
                                  <li class="nav-item">
                                    <a class="nav-link" id="contact-tab" data-toggle="tab" href="#contact10008" role="tab" aria-controls="contact10008" aria-selected="false">developer</a>
                                  </li>
                                </ul>
                                <div class="tab-content" id="defaultTabContent" style="height: 150px;overflow: auto;">
                                  <div class="tab-pane fade show active" id="home10008" role="tabpanel" aria-labelledby="home-tab">
                                      <div class="card-body">
                                      	<p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                                      </div>
                                      <ul class="list-group list-group-flush">
			                                <li class="list-group-item">Dapibus ac facilisis in</li>
			                            </ul>
                                  </div>
                                  <div class="tab-pane fade" id="profile10008" role="tabpanel" aria-labelledby="profile-tab">
                                      <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.</p>
                                  </div>
                                  <div class="tab-pane fade" id="contact10008" role="tabpanel" aria-labelledby="contact-tab">
                                      <div class="row" style="margin-left: 0px;margin-right: 0px;">
										<div class="col-md-6 col-lg-6">
											<p><img class="card-img-top" src="${pageContext.request.contextPath}/contents/img_file/kjw.png" alt="" style="border: 1px solid rgb(0, 0, 0);width: 50px;height: 50px"> 고정완</p>
										</div>
										<div class="col-md-6 col-lg-6">
											<p><img class="card-img-top" src="${pageContext.request.contextPath}/contents/img_file/kds.png" alt="" style="border: 1px solid rgb(0, 0, 0);width: 50px;height: 50px"> 김도성</p>
										</div>
									</div>
                                  </div>
                                </div>
                            </div>
                        </div>  
                    </div>
                    <div class="col-md-6 col-lg-6 col-xl-3">
						<h6><b>건설기준코드 - 관리자</b><a href="http://61.105.196.70:20001/" target="_blank"><i class="mdi mdi-open-in-new pull-right"></i></a></h6>
                        <div class="card m-b-30">
                            <img class="card-img-top" src="${pageContext.request.contextPath}/contents/img_file/20001.PNG" alt="Card image cap" style="border: 1px solid rgb(0, 0, 0);">
                            <div class="card-body">
                                <ul class="nav nav-tabs mb-3" id="defaultTab" role="tablist">
                                  <li class="nav-item">
                                    <a class="nav-link active" id="home-tab" data-toggle="tab" href="#home20001" role="tab" aria-controls="home20001" aria-selected="true">Info</a>
                                  </li>
                                  <li class="nav-item">
                                    <a class="nav-link" id="profile-tab" data-toggle="tab" href="#profile20001" role="tab" aria-controls="profile20001" aria-selected="false">Technics</a>
                                  </li>
                                  <li class="nav-item">
                                    <a class="nav-link" id="contact-tab" data-toggle="tab" href="#contact20001" role="tab" aria-controls="contact20001" aria-selected="false">developer</a>
                                  </li>
                                </ul>
                                <div class="tab-content" id="defaultTabContent" style="height: 150px;overflow: auto;">
                                  <div class="tab-pane fade show active" id="home20001" role="tabpanel" aria-labelledby="home-tab">
                                      <div class="card-body" style="padding-top: 5px;padding-bottom: 5px">
                                      	<p class="card-text">용역<br>건설기준연구원 / 관리자</p>
                                      </div>
                                      <ul class="list-group list-group-flush">
			                                <li class="list-group-item">Dapibus ac facilisis in</li>
			                            </ul>
                                  </div>
                                  <div class="tab-pane fade" id="profile20001" role="tabpanel" aria-labelledby="profile-tab">
                                      <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.</p>
                                  </div>
                                  <div class="tab-pane fade" id="contact20001" role="tabpanel" aria-labelledby="contact-tab">
                                      <div class="row" style="margin-left: 0px;margin-right: 0px;">
										<div class="col-md-6 col-lg-6">
											<p><img class="card-img-top" src="${pageContext.request.contextPath}/contents/img_file/kjw.png" alt="" style="border: 1px solid rgb(0, 0, 0);width: 50px;height: 50px"> 고정완</p>
										</div>
										<div class="col-md-6 col-lg-6">
											<p><img class="card-img-top" src="${pageContext.request.contextPath}/contents/img_file/kyr.png" alt="" style="border: 1px solid rgb(0, 0, 0);width: 50px;height: 50px"> 김유리</p>
										</div>
									</div>
                                  </div>
                                </div>
                            </div>
                        </div>  
                    </div>
                    <div class="col-md-6 col-lg-6 col-xl-3">
						<h6><b>건설기준코드</b><a href="http://61.105.196.70:20002/" target="_blank"><i class="mdi mdi-open-in-new pull-right"></i></a></h6>
                        <div class="card m-b-30">
                            <img class="card-img-top" src="${pageContext.request.contextPath}/contents/img_file/20002.PNG" alt="Card image cap" style="border: 1px solid rgb(0, 0, 0);">
                            <div class="card-body">
                                <ul class="nav nav-tabs mb-3" id="defaultTab" role="tablist">
                                  <li class="nav-item">
                                    <a class="nav-link active" id="home-tab" data-toggle="tab" href="#home20002" role="tab" aria-controls="home20002" aria-selected="true">Info</a>
                                  </li>
                                  <li class="nav-item">
                                    <a class="nav-link" id="profile-tab" data-toggle="tab" href="#profile20002" role="tab" aria-controls="profile20002" aria-selected="false">Technics</a>
                                  </li>
                                  <li class="nav-item">
                                    <a class="nav-link" id="contact-tab" data-toggle="tab" href="#contact20002" role="tab" aria-controls="contact20002" aria-selected="false">developer</a>
                                  </li>
                                </ul>
                                <div class="tab-content" id="defaultTabContent" style="height: 150px;overflow: auto;">
                                  <div class="tab-pane fade show active" id="home20002" role="tabpanel" aria-labelledby="home-tab">
                                      <div class="card-body" style="padding-top: 5px;padding-bottom: 5px">
                                      	<p class="card-text">용역<br>건설기준연구원 / 일반사용자</p>
                                      </div>
                                      <ul class="list-group list-group-flush">
			                                <li class="list-group-item">Dapibus ac facilisis in</li>
			                            </ul>
                                  </div>
                                  <div class="tab-pane fade" id="profile20002" role="tabpanel" aria-labelledby="profile-tab">
                                      <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.</p>
                                  </div>
                                  <div class="tab-pane fade" id="contact20002" role="tabpanel" aria-labelledby="contact-tab">
                                      <div class="row" style="margin-left: 0px;margin-right: 0px;">
										<div class="col-md-6 col-lg-6">
											<p><img class="card-img-top" src="${pageContext.request.contextPath}/contents/img_file/kjw.png" alt="" style="border: 1px solid rgb(0, 0, 0);width: 50px;height: 50px"> 고정완</p>
										</div>
										<div class="col-md-6 col-lg-6">
											<p><img class="card-img-top" src="${pageContext.request.contextPath}/contents/img_file/kyr.png" alt="" style="border: 1px solid rgb(0, 0, 0);width: 50px;height: 50px"> 김유리</p>
										</div>
									</div>
                                  </div>
                                </div>
                            </div>
                        </div>  
                    </div>
                </div>
            </div>
            <%@include file="../base/admin/inc/inc_bottom.jsp"%>
        </div>
    </div>    
    <%@include file="../base/admin/inc/inc_header2.jsp"%>
</body>
<!-- The core Firebase JS SDK is always required and must be listed first -->
<!-- <script src="https://www.gstatic.com/firebasejs/7.12.0/firebase-app.js"></script>

<script type="text/javascript" src="https://www.gstatic.com/firebasejs/7.12.0/firebase-messaging.js"></script>

<script>
  // Your web app's Firebase configuration
 
  
  const tokenDivId = 'token_div';
  const permissionDivId = 'permission_div';
  
  
  
  
  var firebaseConfig = {
		  apiKey: "AIzaSyDBpsKnbTl0va5g083qHTJXuFeV4_x0hRA",
		    authDomain: "noaa-snc.firebaseapp.com",
		    databaseURL: "https://noaa-snc.firebaseio.com",
		    projectId: "noaa-snc",
		    storageBucket: "noaa-snc.appspot.com",
		    messagingSenderId: "498985106271",
		    appId: "1:498985106271:web:946f20a15c15efa32b54ea",
		    measurementId: "G-77BK21606N"
  };
  // Initialize Firebase
  firebase.initializeApp(firebaseConfig);
  //firebase.analytics();
  const messaging = firebase.messaging()
  messaging.usePublicVapidKey("BKZibrjdaZcU0ms4rJMXzuCZCLSWrxZSK0OfaW0xkBErZGD2AbmwJsZdWMc_1baMkcuLOiKdE4tYxy_pjFwqCEA");
  Notification.requestPermission().then(function(permission) {
    if (permission === 'granted') {
      console.log('Notification permission granted.');
    } else {
      console.log('Unable to get permission to notify.');
    }
  });
  
  messaging.getToken().then(function(token) {
	    console.log("Got device token: ", token);
	});
  
  
</script> -->
</html>