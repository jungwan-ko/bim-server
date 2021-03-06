package com.web.base.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.web.base.BaseController;
import com.web.base.admin.viewmodel.AdminMetaViewModel;
import com.web.base.meta.service.IMetaAdmService;
import com.web.base.meta.service.IMetaService;

@Controller("adminMetaController")
public class AdminMetaController extends BaseController {
	
	@Autowired
	private IMetaService metaService;
	
	/**
	 * @param vm
	 * @param model
	 * @return 전체 meta 데이타
	 * @throws Exception
	 */
	@RequestMapping(value="/api/system/admin/meta/list",method=RequestMethod.POST)
	public @ResponseBody AdminMetaViewModel listGrpMetaAdminAction(@RequestBody AdminMetaViewModel vm,Model model)throws Exception{	
		vm.setListMeta(metaService.list());
		return vm;
	}
	
	/**
	 * @param vm.getParamMetaId : 메타 테이블 명
	 * @param model
	 * @return 생성완료 cnt
	 */
	@RequestMapping(value="/api/system/admin/meta/create",method=RequestMethod.POST)
	public @ResponseBody AdminMetaViewModel createMetaAdminAction(@RequestBody AdminMetaViewModel vm,Model model){
		vm.setResultCount(metaService.createMeta(vm.getParamMetaId()));
		metaService.createMetaData(vm.getParamMetaId());
		return vm;
	}

}
