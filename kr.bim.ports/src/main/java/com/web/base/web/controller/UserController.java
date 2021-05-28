package com.web.base.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.web.base.BaseController;
import com.web.base.account.service.IAccountService;
import com.web.base.web.viewmodel.UserViewModel;
@Controller("userController")
public class UserController extends BaseController {

	@Autowired
	private IAccountService accountService;
	
	@RequestMapping(value="/api/user/list",method=RequestMethod.GET)
	public @ResponseBody UserViewModel listUserAction(UserViewModel vm,Model model)throws Exception{	
		vm.setList(accountService.list(null,null,null,null,null	,null,null,vm.getPageNo(),vm.getPageSize()));
		vm.setTotalCount(accountService.totalCount(null,null,null,null,null,null,null));
		return vm;
	}
	
}
