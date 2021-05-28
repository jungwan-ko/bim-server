package com.web.base;

import java.lang.reflect.Method;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;


import com.web.base.account.dao.UserDTO;
import com.web.base.account.service.IAccountService;
import com.web.base.global.GlobalService;
import com.web.base.global.MessageKeyword;
import com.web.base.global.SysKeyword;
import com.web.base.sec.service.JwtService;
import com.web.base.utils.CookieHelper;
@CrossOrigin(origins = "http://127.0.0.1:5500")
@Controller
public class BaseController {
	protected static final Logger logger = LoggerFactory
			.getLogger(BaseController.class);
	
	@Autowired
	private GlobalService globalService;
	@Autowired 
	private JwtService jwtService;
	//private CommonParams commonParams;
	private String menus;

	public String getMenus() {
		return menus;
	}

	public void setMenus(String menus) {
		this.menus = menus;
	}

	public CommonParams getCommonParams() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
		HttpSession session =request.getSession();
		String userId=null;
		String userEmail=null;
		String userRoles=null;
		String userName=null;
		String token=jwtService.resolveToken(request);
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
		comm.setDeviceType(request.getHeader("User-Agent"));
		
		if(request.getHeader("User-Agent").indexOf("Android") > -1 || request.getHeader("User-Agent").indexOf("iPhone") > -1 || request.getHeader("User-Agent").indexOf("iPad") > -1) {
			comm.setIsMobilYN("Y");      
		}else{
			comm.setIsMobilYN("N");
		}
	
		return comm;
	}

	

	@ExceptionHandler(Exception.class)
	public ModelAndView handleException(HttpServletRequest req,	HttpServletResponse response, Exception ex) {
		
	
		ModelAndView model = new ModelAndView("/base/error");

		String contentType = req.getHeader("Content-Type");
		String reason = HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase();
		String exType=ex.getClass().getSimpleName();
		
		int statusCode = HttpStatus.INTERNAL_SERVER_ERROR.value();
	
		logger.error(reason, ex);
		addModelAttr(model,reason,Integer.toString(statusCode),ex.getMessage(),exType);
		
		if (contentType != null && MediaType.APPLICATION_JSON_VALUE.equals(contentType.split(";")[0])) {
			MappingJackson2JsonView jsonView = new MappingJackson2JsonView();
			Throwable e = ex.getCause();
			String exMessage= ex.getMessage();
			
			if (ex instanceof AuthorizeException) {
				AuthorizeException target = (AuthorizeException) ex;
				if (target.getIsDeny()) {
					exMessage=target.getMessage();
					
				}
				if (target.getIsLogin()) {
					exMessage=target.getMessage();
				}
				reason="Authorize error";
				exType=target.getClass().getSimpleName();
				
				model = new ModelAndView(jsonView, "errorCode",target.getErrorCode());
			}else {
				model = new ModelAndView(jsonView, "error",exMessage);
				ResponseStatus annotation = ex.getClass().getAnnotation(ResponseStatus.class);
				if (annotation != null) {
					reason = annotation.reason();
					statusCode = annotation.value().value();
				}
				addModelAttr(model,reason,Integer.toString(statusCode),exMessage,exType);
			}
			return model;

		} else {
			Throwable e = ex.getCause();
			if (e instanceof AuthorizeException) {
				AuthorizeException target = (AuthorizeException) e;
				if (target.getIsDeny()) {
					model = new ModelAndView(target.getView());
					
					statusCode = target.getErrorCode();
					addModelAttr(model,"access deny",Integer.toString(statusCode),target.getMessage(),exType);
					response.setStatus(statusCode);
				}
				if (target.getIsLogin()) {
					model = new ModelAndView("redirect:" + target.getView());
				}

			}else{
				model = new ModelAndView("redirect:/error");
				
			}

			return model;
		}

	}
	
	private void addModelAttr(ModelAndView model,String reason,String statusCode,String  message,String exType){
		model.addObject("reason",reason);
		model.addObject("statusCode",statusCode);
		//model.addObject("message",message);
		model.addObject("exType",exType);
		
	}

}