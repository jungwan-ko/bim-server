<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<%@include file="../base/admin/inc/inc_header.jsp"%>
</head>
<body class="xp-vertical">
	<div class="xp-authenticate-bg"></div>
	<div id="xp-container" class="xp-container" v-cloak>
        <div class="container">
        	<div class="row vh-100 align-items-center">
        		<div class="col-lg-12 ">
        			<div class="row">
        				<div class="col-md-6 col-lg-6 col-xl-3">
        					<div class="card bg-primary m-b-30">
        						<div class="card-body" onclick="login('bonanza')">
        							<div class="xp-widget-box">
        								<div class="float-left">
        									<h4 class="xp-counter text-white">고정완</h4>
        									<p class="mb-0 text-white">이사</p>
        								</div>
        								<div class="float-right">
        									<img class="card-img-top" src="${pageContext.request.contextPath}/contents/img_file/kjw.png" alt="" style="border: 1px solid rgb(0, 0, 0);width: 60px;height: 60px;border-radius: 50%;">
        								</div>
        								<div class="clearfix"></div>
        							</div>
        						</div>
        					</div>
        				</div>
                        <div class="col-md-6 col-lg-6 col-xl-3">
        					<div class="card bg-secondary m-b-30">
        						<div class="card-body" onclick="login('isyan79')">
        							<div class="xp-widget-box">
        								<div class="float-left">
        									<h4 class="xp-counter text-white">안경훈</h4>
        									<p class="mb-0 text-white">차장</p>
        								</div>
        								<div class="float-right">
        									<img class="card-img-top" src="${pageContext.request.contextPath}/contents/img_file/akh.png" alt="" style="border: 1px solid rgb(0, 0, 0);width: 60px;height: 60px;border-radius: 50%;">
        								</div>
        								<div class="clearfix"></div>
        							</div>
        						</div>
        					</div>
        				</div>
        				<div class="col-md-6 col-lg-6 col-xl-3">
        					<div class="card bg-success m-b-30">
        						<div class="card-body" onclick="login('ktg')">
        							<div class="xp-widget-box">
        								<div class="float-left">
        									<h4 class="xp-counter text-white">강태구</h4>
        									<p class="mb-0 text-white">과장</p>
        								</div>
        								<div class="float-right">
        									<img class="card-img-top" src="${pageContext.request.contextPath}/contents/img_file/ktg.png" alt="" style="border: 1px solid rgb(0, 0, 0);width: 60px;height: 60px;border-radius: 50%;">
        								</div>
        								<div class="clearfix"></div>
        							</div>
        						</div>
        					</div>
        				</div>
        				<div class="col-md-6 col-lg-6 col-xl-3">
        					<div class="card bg-warning m-b-30">
        						<div class="card-body" onclick="login('jdw')">
        							<div class="xp-widget-box">
        								<div class="float-left">
        									<h4 class="xp-counter text-white">정다운</h4>
        									<p class="mb-0 text-white">대리</p>
        								</div>
        								<div class="float-right">
        									<img class="card-img-top" src="${pageContext.request.contextPath}/contents/img_file/jdw.png" alt="" style="border: 1px solid rgb(0, 0, 0);width: 60px;height: 60px;border-radius: 50%;">
        								</div>
        								<div class="clearfix"></div>
        							</div>
        						</div>
        					</div>
        				</div>
        				<div class="col-md-6 col-lg-6 col-xl-3">
        					<div class="card bg-warning m-b-30">
        						<div class="card-body" onclick="login('islandcastle88')">
        							<div class="xp-widget-box">
        								<div class="float-left">
        									<h4 class="xp-counter text-white">김도성</h4>
        									<p class="mb-0 text-white">대리</p>
        								</div>
        								<div class="float-right">
        									<img class="card-img-top" src="${pageContext.request.contextPath}/contents/img_file/kds.png" alt="" style="border: 1px solid rgb(0, 0, 0);width: 60px;height: 60px;border-radius: 50%;">
        								</div>
        								<div class="clearfix"></div>
        							</div>
        						</div>
        					</div>
        				</div>
        				<div class="col-md-6 col-lg-6 col-xl-3">
        					<div class="card bg-warning m-b-30">
        						<div class="card-body" onclick="login('kyr6886')">
        							<div class="xp-widget-box">
        								<div class="float-left">
        									<h4 class="xp-counter text-white">김유리</h4>
        									<p class="mb-0 text-white">대리</p>
        								</div>
        								<div class="float-right">
        									<img class="card-img-top" src="${pageContext.request.contextPath}/contents/img_file/kyr.png" alt="" style="border: 1px solid rgb(0, 0, 0);width: 60px;height: 60px;border-radius: 50%;">
        								</div>
        								<div class="clearfix"></div>
        							</div>
        						</div>
        					</div>
        				</div>
        				<div class="col-md-6 col-lg-6 col-xl-3">
        					<div class="card bg-info m-b-30">
        						<div class="card-body" onclick="login('sakwon')">
        							<div class="xp-widget-box">
        								<div class="float-left">
        									<h4 class="xp-counter text-white">서상권</h4>
        									<p class="mb-0 text-white">주임</p>
        								</div>
        								<div class="float-right">
        									<img class="card-img-top" src="${pageContext.request.contextPath}/contents/img_file/ssk.png" alt="" style="border: 1px solid rgb(0, 0, 0);width: 60px;height: 60px;border-radius: 50%;">
        								</div>
        								<div class="clearfix"></div>
        							</div>
        						</div>
        					</div>
        				</div>
        				<div class="col-md-6 col-lg-6 col-xl-3">
        					<div class="card bg-info m-b-30">
        						<div class="card-body" onclick="login('park9831')">
        							<div class="xp-widget-box">
        								<div class="float-left">
        									<h4 class="xp-counter text-white">박민규</h4>
        									<p class="mb-0 text-white">주임</p>
        								</div>
        								<div class="float-right">
        									<img class="card-img-top" src="${pageContext.request.contextPath}/contents/img_file/pmg.png" alt="" style="border: 1px solid rgb(0, 0, 0);width: 60px;height: 60px;border-radius: 50%;">
        								</div>
        								<div class="clearfix"></div>
        							</div>
        						</div>
        					</div>
        				</div>
        				<div class="col-md-6 col-lg-6 col-xl-3">
        					<div class="card bg-info m-b-30">
        						<div class="card-body" onclick="login('vermouth')">
        							<div class="xp-widget-box">
        								<div class="float-left">
        									<h4 class="xp-counter text-white">조봉연</h4>
        									<p class="mb-0 text-white">주임</p>
        								</div>
        								<div class="float-right">
        									<img class="card-img-top" src="${pageContext.request.contextPath}/contents/img_file/jby.png" alt="" style="border: 1px solid rgb(0, 0, 0);width: 60px;height: 60px;border-radius: 50%;">
        								</div>
        								<div class="clearfix"></div>
        							</div>
        						</div>
        					</div>
        				</div>
                    </div>
                    <!-- End XP Auth Box --></div>
                <!-- End XP Col -->
            </div>
            <!-- End XP Row -->
        </div>
        <!-- End Container -->
    </div>
    <form method="post" name="mainForm"	action="<c:url value="/account/login"/>">
										<input type="hidden" id="keyM" name="loginInfo.keyModule" value="${vm.keyModule }" />
										<input type="hidden" id="keyEx" name="loginInfo.keyExponent" value="${vm.keyExponent }"/>
										<input type="hidden" id="encUserID" name="loginInfo.id" value=""/>
										<input type="hidden" id="encUserPwd" name="loginInfo.password" value=""/>
									</form>
    
	
    <%@include file="../base/admin/inc/inc_header2.jsp"%>
    <script	src="${pageContext.request.contextPath}/contents/noaa/js/utils/rsa/jsbn.js"></script>
	<script	src="${pageContext.request.contextPath}/contents/noaa/js/utils/rsa/rsa.js"></script>
	<script	src="${pageContext.request.contextPath}/contents/noaa/js/utils/rsa/prng4.js"></script>
	<script	src="${pageContext.request.contextPath}/contents/noaa/js/utils/rsa/rng.js"></script>
    <script type="text/javascript">
    function login(parmaId){
    	$.confirm({
            title: 'PASSWORD',
            content: '' +
            '<form action="<c:url value="/account/login"/>" class="formName">' +
            '<div class="form-group">' +
            '<label>비밀번호를 입력해주세요!</label>' +
            '<input type="password" placeholder="password" id="pass" class="name form-control" required  />' +
            '</div>' +
            '</form>',
            buttons: {
                formSubmit: {
                    text: 'Submit',
                    btnClass: 'btn-blue',
                    action: function () {
                    	
                    	var vm = this;

                    	var keyEx = $("#keyEx").val();
                    	var keyM = $("#keyM").val();
                    	var rsa = new RSAKey();
                        rsa.setPublic(keyM,keyEx);
                        var encID = rsa.encrypt(parmaId);
                        var encPwd = rsa.encrypt($("#pass").val());
                        $("#encUserID").val(encID);
                        $("#encUserPwd").val(encPwd);
                        console.log($("#encUserID").val());
                        console.log($("#encUserPwd").val());
                        document.forms["mainForm"].submit();
                    	
                    	
                    	
                    	
                    	
                        /* var name = this.$content.find('.name').val();
                        if(!name){
                            $.alert('provide a valid name');
                            return false;
                        }
                        $.alert('Your name is ' + name); */
                        //location.href="/dashboard";
                        
                        
                        
                    }
                },
                cancel: function () {
                    //close
                },
            },
            onContentReady: function () {
                // bind to events
                var jc = this;
                this.$content.find('form').on('submit', function (e) {
                    // if the user submits the form by pressing enter in the field.
                    e.preventDefault();
                    jc.$$formSubmit.trigger('click'); // reference the button and click it
                });
            }
        })
    }
    </script>
</body>
</html>