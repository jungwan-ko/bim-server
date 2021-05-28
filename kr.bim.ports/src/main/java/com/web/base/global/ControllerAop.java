package com.web.base.global;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.web.base.Authorize;
import com.web.base.AuthorizeException;
import com.web.base.BaseViewModel;
import com.web.base.CommonParams;
import com.web.base.MessageStatus;
import com.web.base.ProgramID;
import com.web.base.account.dao.UserDTO;
import com.web.base.account.service.IAccountService;
import com.web.base.menu.dao.MenuDTO;
import com.web.base.sec.service.JwtService;
import com.web.base.utils.CookieHelper;
@Aspect
public class ControllerAop {
	private static final Logger logger = LoggerFactory.getLogger(ControllerAop.class);
	@Autowired
	private GlobalService globalService;
	@Autowired
	private IAccountService accountService;
	@Autowired 
	private JwtService jwtService;
	 

	@Before("execution(* com.web.base..*Controller.*Action(..)) "
			+ "|| execution(* com.web.base..*Controller.*View(..)) "
			+ "|| execution(* kr.bim.ports..*Controller.*Action(..)) "
			+ "|| execution(* kr.bim.ports..*Controller.*View(..)) "
			)
	public void preAction(JoinPoint joinPoint) throws Throwable {
		
		
		String tocken=jwtService.resolveToken(getRequest());
		HttpServletRequest request = getRequest();
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();
		
		
		
		ProgramID progrmID = method.getAnnotation(ProgramID.class);
		String prgID = progrmID == null ? "" : progrmID.id();
		Authorize authFilter = method.getAnnotation(Authorize.class);
		
		
		//로그인 사용자만 접근 가능한 기능이라면 권한 체크도 함께 한다.
		 if (authFilter != null) {
			 boolean isValidJwt=jwtService.validateToken(tocken);
			  if(tocken!=null &&isValidJwt) {
				  if (!globalService.hasRole(prgID, jwtService.getInfo(tocken, SysKeyword.JWT_KEY_ROLES))) {
					  throw new AuthorizeException(MessageStatus.AUTH_DENY.value(),true,false,"/base/error");
				  }
			  }else {
				  throw new AuthorizeException(MessageStatus.AUTH_REQUIRED.value(),false,true,"/account/login");
			  }
		  }
		 
		 prePushViewModel(joinPoint,prgID,authFilter,tocken);
	}

	@After("execution(* com.web.base..*Controller.*Action(..)) "
			+ "|| execution(* com.web.base..*Controller.*View(..)) "
			+ "|| execution(* kr.bim.ports..*Controller.*Action(..)) "
			+ "|| execution(* kr.bim.ports..*Controller.*View(..)) "
			)
	public void aftAction(JoinPoint joinPoint) throws Throwable {
		logger.info("test aft aop");
		aftPushViewModel(joinPoint);
	}

	private CommonParams getCommonParams(JoinPoint joinPoint) {
		CommonParams p = null;
		try {
			HttpServletRequest request = getRequest();
		
			HttpSession session = getSession();
			Object sessionUserID = session.getAttribute(SysKeyword.SESSION_USER_ID);
			Object sessionUserName = session.getAttribute(SysKeyword.SESSION_USER_NAME);
			Object sessionUserRole=session.getAttribute(SysKeyword.SESSION_USER_ROLE);
			Object sessionAccType=session.getAttribute(SysKeyword.SESSION_ACC_TYPE);
			Object sessionAccTitle=session.getAttribute(SysKeyword.SESSION_ACC_TITLE);
			String userID =sessionUserID == null ?  null: sessionUserID.toString();
			String userName=sessionUserName == null ? null : sessionUserName.toString();
			String userRole= sessionUserRole==null?null:sessionUserRole.toString();
			String accType= sessionAccType==null?null:sessionAccType.toString();
			String accTitle= sessionAccTitle==null?null:sessionAccTitle.toString();
			p = new CommonParams();

			Method targetMethod = joinPoint.getTarget().getClass().getMethod("setCommonParams", p.getClass());
			p.setSessID(session.getId());
			p.setDeviceType(request.getHeader("User-Agent"));
			if(request.getHeader("User-Agent").indexOf("Android") > -1 || request.getHeader("User-Agent").indexOf("iPhone") > -1 || request.getHeader("User-Agent").indexOf("iPad") > -1) {
				p.setIsMobilYN("Y");      
			}else{
				p.setIsMobilYN("N");
			}
			p.setRequestIP(request.getRemoteHost());
			p.setRequestDate(new Date());
			p.setLoginUserName(userName);
			p.setLoginUserID(userID);
			p.setUserRole(userRole);
			p.setUserRole(userRole);
			p.setAccType(accType);
			p.setAccTitle(accTitle);
			targetMethod.invoke(joinPoint.getTarget(), p);
		} catch (Exception ex) {
			logger.debug(ex.getMessage());
		}
		return p;
	}


	private void prePushViewModel(JoinPoint joinPoint,String prgID,Authorize authFilter,String tocken) {
		try {
			Object[] signatureArgs = joinPoint.getArgs();
			
			
			
			for (Object signatureArg : signatureArgs) {
				if (signatureArg instanceof BaseViewModel) {
					HttpServletRequest request = getRequest();
					BaseViewModel vm = (BaseViewModel) signatureArg;
					vm.setRequestIP(request.getRemoteAddr());
					long time = System.currentTimeMillis();
					vm.setRequestTime(new Date(time));
					if (request.getContentType() == null) {
						vm.setMenus(globalService.instance().getListMenu());
						if(prgID!=null){
							vm.setMenuDetail(globalService.instance().getMapMenu().get(prgID));
						}
					}
					if(prgID!=null && authFilter!=null){
						
						if(tocken !=null && jwtService.validateToken(tocken)) {
							if (globalService.hasWriteRole(prgID, jwtService.getInfo(tocken, SysKeyword.JWT_KEY_ROLES))) {
								vm.setEnableWriteYN(true);
							}
						}
					}
					break;
				}
			}
		} catch (Exception ex) {
			logger.debug(ex.getMessage());
		}
	}

	private void aftPushViewModel(JoinPoint joinPoint) {
		HttpServletRequest request=getRequest();
		
		
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();
		ProgramID progrmID = method.getAnnotation(ProgramID.class);
		logger.info("aft");
		String prgID = progrmID == null ? "" : progrmID.id();
		Object[] signatureArgs = joinPoint.getArgs();
		
		
		String userId=null;
		String userEmail=null;
		String userRoles=null;
		String userName=null;
		String token=jwtService.resolveToken(getRequest());
		if(token!=null && jwtService.validateToken(token)) {
			userId=jwtService.getId(token);
			userEmail=jwtService.getInfo(token, SysKeyword.JWT_KEY_EMAIL);
			userRoles=jwtService.getInfo(token, SysKeyword.JWT_KEY_ROLES);
			userName=jwtService.getInfo(token, SysKeyword.JWT_KEY_NAME);
		}
		CommonParams comm = new CommonParams();
		comm.setSessID(userId);
		comm.setDeviceType(request.getHeader("User-Agent"));
		comm.setRequestDate(new Date());
		comm.setLoginUserName(userName);
		comm.setLoginUserID(userId);
		comm.setUserRole(userRoles);
		
		for (Object signatureArg : signatureArgs) {
			if (signatureArg instanceof BaseViewModel) {
				BaseViewModel vm = (BaseViewModel) signatureArg;
				vm.setPg(prgID);
				 if(comm!=null){
					 comm.setSessID(null);
					 vm.setCommonParams(comm);
				 }
				if(MessageStatus.valueOf(vm.getResultCount())!=null)
					vm.setResultMessage(MessageStatus.valueOf(vm.getResultCount()).getReasonPhrase());
			
			
			}
			
			/*
			 * if (signatureArg instanceof Model) {
			 * 
			 * Model model = (Model) signatureArg; boolean
			 * isRedirect=model.containsAttribute("redirect");
			 * logger.info(request.getContentType()); if (method.getName().indexOf("View") >
			 * -1) { if(comm!=null && comm.getLoginUserID()!=null){
			 * accountService.createLoginLog(comm, request.getSession().getId()); }
			 * model.addAttribute("userId", comm==null?null: comm.getLoginUserID());
			 * model.addAttribute("userName",comm==null?null:comm.getLoginUserName());
			 * model.addAttribute("userRole",comm==null?null:comm.getUserRole()); //
			 * model.addAttribute("accType",comm==null?null:comm.getAccType());
			 * model.addAttribute("common",comm); }else
			 * if(method.getName().indexOf("Action") > -1){ if(isRedirect){
			 * model.asMap().clear(); } } if (progrmID != null && prgID!=null &&
			 * method.getName().indexOf("View") > -1) { HashMap<String, MenuDTO>
			 * menuDto=globalService.instance().getMapMenu(); if(!isRedirect&&menuDto!=null
			 * && menuDto.get(prgID)!=null){
			 * model.addAttribute("title",globalService.instance().getMapMenu().get(prgID).
			 * getMenu_title());
			 * model.addAttribute("menuID",globalService.instance().getMapMenu().get(prgID).
			 * getMenu_id());
			 * model.addAttribute("menuGRP",globalService.instance().getMapMenu().get(prgID)
			 * .getMenu_group()); } } } if(signatureArg instanceof ModelAndView){
			 * 
			 * ModelAndView model = (ModelAndView) signatureArg;
			 * logger.info(request.getContentType()); if (method.getName().indexOf("View") >
			 * -1) {
			 * 
			 * String refer=request.getHeader("refere"); String requestUri =
			 * request.getRequestURI();
			 * 
			 * 
			 * 
			 * model.addObject("userId", comm.getLoginUserID());
			 * model.addObject("userName",comm.getLoginUserName());
			 * model.addObject("userRole",comm.getUserRole());
			 * //model.addObject("accType",comm.getAccType());
			 * model.addObject("common",comm); } if (progrmID != null) {
			 * model.addObject("title",globalService.instance().getMapMenu().get(prgID).
			 * getMenu_title());
			 * model.addObject("menuID",globalService.instance().getMapMenu().get(prgID).
			 * getMenu_id());
			 * model.addObject("menuGRP",globalService.instance().getMapMenu().get(prgID).
			 * getMenu_group()); } }
			 */

		}
		
	}

	private void setSession(UserDTO userEntity) {

		HttpSession session = getSession();
		session.setAttribute(SysKeyword.SESSION_USER_ID, userEntity.getUser_id());
		session.setAttribute(SysKeyword.SESSION_USER_NAME, userEntity.getUser_name());
		session.setAttribute(SysKeyword.SESSION_USER_EMAIL, userEntity.getUser_email());
		session.setAttribute(SysKeyword.SESSION_USER_ROLE, userEntity.getUser_roles());
		session.setAttribute(SysKeyword.SESSION_ACC_TYPE, userEntity.getUser_type_code());
		session.setAttribute(SysKeyword.SESSION_ACC_TITLE, userEntity.getUser_type_title());
	    
	}

	private HttpSession getSession() {
		HttpServletRequest request = getRequest();
		return request.getSession();
	}

	private Cookie[] getCookie() {
		HttpServletRequest request = getRequest();
		return request.getCookies();
	}

	private HttpServletRequest getRequest() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
		logger.info("contentType:" + request.getContentType());
		return request;
	}

	
}