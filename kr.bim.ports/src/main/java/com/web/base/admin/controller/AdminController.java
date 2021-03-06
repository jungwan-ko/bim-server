package com.web.base.admin.controller;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.RSAPublicKeySpec;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.web.base.AdminViewModel;
import com.web.base.Authorize;
import com.web.base.BaseAccountViewModel;
import com.web.base.BaseController;
import com.web.base.BaseSysKeyword;
import com.web.base.ProgramID;
import com.web.base.account.dao.UserDTO;
import com.web.base.account.service.IAccountService;
import com.web.base.admin.viewmodel.AdminCodeViewModel;
import com.web.base.bbs.service.IBBSService;
import com.web.base.global.RsaKeyGen;
import com.web.base.global.RsaKeyModel;
import com.web.base.global.SysKeyword;
import com.web.base.menu.service.IMenuService;
import com.web.base.sec.service.JwtService;
import com.web.base.utils.CookieHelper;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@Controller("adminController")
public class AdminController extends BaseController {
	@Autowired
	private IAccountService accountService;
	@Autowired
	private IMenuService menuService;
	@Autowired
	private IBBSService bbsService;
	@Autowired
	private JwtService jwtService;
	
	
	@RequestMapping(value = "/system/admin/viewCode", method = RequestMethod.GET)
	public String predictrainView(AdminCodeViewModel vm, Model model) throws Exception {

		model.addAttribute("vm", vm);
		return "/base/admin/codeList";
	}

	@RequestMapping(value = "/api/system/admin/signin", method = RequestMethod.POST)
	public @ResponseBody BaseAccountViewModel signinAdminAction(@RequestBody BaseAccountViewModel vm, Model model)
			throws Exception {

		  UserDTO userDto=accountService.detail(vm.getParamUserID(),vm.getParamPwd());
		  if(userDto!=null) {
			  String rs=jwtService.createToken(
					   userDto.getUser_id()
					  ,userDto.getUser_name()
					  ,userDto.getUser_email()
					  ,userDto.getUser_roles()); 
			  vm.setJwtTocken(rs);
		  }
			 
		 
		return vm;
	}

	@RequestMapping(value = "/system/manage/login", method = RequestMethod.GET)
	public String indexView(AdminViewModel vm, Model model, HttpServletResponse response, HttpServletRequest request)
			throws Exception {

		RsaKeyModel keyModel = RsaKeyGen.getInstance().createRsaKeys();
		request.getSession().setAttribute(BaseSysKeyword.PRIVATE_KEY, keyModel.privateKey);
		vm.setKeyExponent(keyModel.getKeyExponent());
		vm.setKeyModule(keyModel.getKeyModule());
		return "/base/admin/login";
	}

	@RequestMapping(value = "/system/manage/login", method = RequestMethod.POST)
	public String logInAction(AdminViewModel vm, HttpServletResponse response, HttpServletRequest request)
			throws Exception {

		UserDTO detail = accountService.detail(vm.getDetailUser().getUser_id(), vm.getDetailUser().getUser_pwd());
		if (detail != null) {
			request.getSession().setAttribute(SysKeyword.SESSION_USER_ID, detail.getUser_id());
			request.getSession().setAttribute(SysKeyword.SESSION_USER_EMAIL, detail.getUser_email());
			request.getSession().setAttribute(SysKeyword.SESSION_USER_NAME, detail.getUser_name());
			request.getSession().setAttribute(SysKeyword.SESSION_USER_ROLE, detail.getUser_roles());
			request.getSession().setAttribute(SysKeyword.SESSION_ACC_TYPE, detail.getUser_type_code());
			request.getSession().setAttribute(SysKeyword.SESSION_ACC_TITLE, detail.getUser_type_title());
			Cookie cookie = null;
			if (vm.getRememberMeYn() != null && vm.getRememberMeYn().equals("Y")) {
				cookie = new Cookie(SysKeyword.COOKIE_NAME_KEEP, detail.getUser_id());
				cookie.setMaxAge(60 * 60 * 24 * 365);
				cookie.setPath("/");
				response.addCookie(cookie);
			} else {
				CookieHelper cookieHelper = new CookieHelper(request.getCookies());
				cookieHelper.clear(response, SysKeyword.COOKIE_NAME_KEEP);
			}

			return "redirect:/system/manage/default";
		} else {
			UserDTO paramBean = new UserDTO();
			paramBean.setUser_id(vm.getDetailUser().getUser_id());
			accountService.updateFailCnt(paramBean);
		}
		return "redirect:/system/manage/login";
	}

	@Authorize
	// @ProgramID(id="SYS0000")
	@RequestMapping(value = "/system/manage/default", method = RequestMethod.GET)
	public String defaultView(AdminViewModel vm, Model model) {
		model.addAttribute("vm", vm);
		return "/www/views/admin/index.html#/manage/project/list";
	}

	// @Authorize
	// @ProgramID(id="SYS0000")
	@RequestMapping(value = "/api/system/manage/default/load", method = RequestMethod.POST)
	public @ResponseBody AdminViewModel loadDefaultAction(@RequestBody AdminViewModel vm, Model model) {
		vm.setListVisitMenuLog(menuService.listVisitLog(vm.getParamStartDate(), vm.getParamEndDate()));
		vm.setListMenuLog(menuService.listLog(vm.getParamStartDate(), vm.getParamEndDate(), 1, 10));
		/*
		 * vm.setUser_tot_cnt(accountService.countTotalUser());
		 * vm.setAvg_use_time(menuService.averageUseTime(vm.getParamStartDate(),
		 * vm.getParamEndDate()));
		 * vm.setCur_user_cnt(menuService.countCurrentUser(vm.getParamAvgTime()));
		 */
		vm.setListBbsContent(bbsService.listRecentContent(vm.getId(), vm.getPageNo(), vm.getPageSize()));
		return vm;
	}

}
