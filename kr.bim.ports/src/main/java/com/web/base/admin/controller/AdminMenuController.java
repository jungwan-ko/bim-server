package com.web.base.admin.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.web.base.BaseController;
import com.web.base.account.service.IAccountService;
import com.web.base.admin.viewmodel.AdminAccountViewModel;
import com.web.base.admin.viewmodel.AdminMenuViewModel;
import com.web.base.code.service.ICodeSysService;
import com.web.base.global.SysKeyword;
import com.web.base.menu.dao.MenuRoleDTO;
import com.web.base.menu.service.IMenuService;
import com.web.base.utils.DateHelper;
@Controller("adminMenuController")
public class AdminMenuController extends BaseController {
	@Autowired
	private IMenuService menuService;
	@Autowired
	private ICodeSysService codeService;
	@Autowired
	private IAccountService accountService;
	
	@RequestMapping(value="/api/system/admin/menu",method=RequestMethod.POST)
	public @ResponseBody AdminMenuViewModel manageMenuAction(@RequestBody AdminMenuViewModel vm,Model model)throws Exception{	
		vm.setListMenu(menuService.list(SysKeyword.COMMON_PARAM_USE_Y));
		return vm;
	}
	
	@RequestMapping(value="/api/system/admin/menu/role",method=RequestMethod.POST)
	public @ResponseBody AdminMenuViewModel roleMenuAction(@RequestBody AdminMenuViewModel vm,Model model)throws Exception{	
		vm.setListMenu(menuService.list(SysKeyword.COMMON_PARAM_USE_Y));
		vm.setListRole(accountService.listRoles());
		return vm;
	}
	
	@RequestMapping(value="/api/admin/menu/role/create",method=RequestMethod.POST)
	public @ResponseBody AdminMenuViewModel createRoleMenuAction(@RequestBody AdminMenuViewModel vm,Model model)throws Exception{	
		vm.setResultCount(menuService.createRole(vm.getParamMenuID(),vm.getParamRoles().split(",")));
		return vm;
	}
	
	@RequestMapping(value="/api/system/admin/menu/role/update",method=RequestMethod.POST)
	public @ResponseBody AdminMenuViewModel updateRoleMenuAction(@RequestBody AdminMenuViewModel vm,Model model)throws Exception{	
		vm.setResultCount(menuService.createRole(vm.getParamMenuID(),vm.getParamRoles().split(","),vm.getParamWriteRoles().split(",")));
		return vm;
	}
	
	@RequestMapping(value="/api/system/admin/menu/list",method=RequestMethod.POST)
	public @ResponseBody AdminMenuViewModel listMenuAction(@RequestBody AdminMenuViewModel vm,Model model)throws Exception{	
		vm.setListMenu(menuService.list(SysKeyword.COMMON_PARAM_USE_Y));
		return vm;
	}
	@RequestMapping(value="/api/system/admin/menu/create",method=RequestMethod.POST)
	public @ResponseBody AdminMenuViewModel createMenuAction(@RequestBody AdminMenuViewModel vm,Model model)throws Exception{	
		vm.setResultCount(menuService.create(vm.getDetailMenu(),getCommonParams()));
		vm.setListMenu(menuService.list(SysKeyword.COMMON_PARAM_USE_Y));
		return vm;
	}
	
	@RequestMapping(value="/api/system/admin/menu/update",method=RequestMethod.POST)
	public @ResponseBody AdminMenuViewModel updateMenuAction(@RequestBody AdminMenuViewModel vm,Model model)throws Exception{	
		vm.setResultCount(menuService.update(vm.getDetailMenu()));
		vm.setListMenu(menuService.list(SysKeyword.COMMON_PARAM_USE_Y));
		return vm;
	}
	
	@RequestMapping(value="/api/system/admin/menu/drop",method=RequestMethod.POST)
	public @ResponseBody AdminMenuViewModel dropMenuAction(@RequestBody AdminMenuViewModel vm,Model model)throws Exception{	
		vm.setResultCount(menuService.drop(vm.getId()));
		vm.setListMenu(menuService.list(SysKeyword.COMMON_PARAM_USE_Y));
		return vm;
	}
	
	@RequestMapping(value="/api/system/admin/menu/history/create",method=RequestMethod.POST)
	public @ResponseBody AdminMenuViewModel historyMenuAction(@RequestBody AdminMenuViewModel vm,Model model)throws Exception{	
		menuService.createLog(getCommonParams(), vm.getPg(), vm.getParamDurMils());
		return vm;
	}
	@RequestMapping(value="/api/system/admin/menu/history/list",method=RequestMethod.POST)
	public @ResponseBody AdminMenuViewModel listHistoryMenuAction(@RequestBody AdminMenuViewModel vm,Model model)throws Exception{	
//		vm.setListMenuLog( menuService.listVisitLog(vm.getParamStartDate(), vm.getParamEndDate()));
//		vm.setUser_tot_cnt(accountService.countTotalUser());
//		vm.setAvg_use_time(menuService.averageUseTime(vm.getParamStartDate(), vm.getParamEndDate()));
//		vm.setCur_user_cnt(menuService.countCurrentUser(vm.getParamAvgTime()));
		return vm;
	}
	
	@RequestMapping(value="/api/system/admin/menu/log/list",method=RequestMethod.POST)
	public @ResponseBody AdminMenuViewModel listLogMenuAction(@RequestBody AdminMenuViewModel vm,Model model)throws Exception{
//		vm.setTotalCount(menuService.totalCountLog(vm.getParamStartDate(), vm.getParamEndDate()));
//		vm.setListMenuLog( menuService.listLog(vm.getParamStartDate(), vm.getParamEndDate(),vm.getPageNo(),vm.getPageSize()));
//		vm.setParamStartDate( vm.getParamStartDate() ==null ? DateHelper.getNextMonthYYYYMMDD(-3).substring(0, 6)+"01":vm.getParamStartDate());
//	    vm.setParamEndDate( vm.getParamEndDate() ==null ? DateHelper.getCurrentYYYYMMDD():vm.getParamEndDate());
		return vm;
	}
	
	
}
