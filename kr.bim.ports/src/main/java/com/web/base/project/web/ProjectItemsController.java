package com.web.base.project.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.web.base.BaseController;
import com.web.base.project.service.IProjectFileService;
import com.web.base.project.service.IProjectItemService;
import com.web.base.project.service.IProjectService;
@Controller("projectItemsController")
public class ProjectItemsController extends BaseController {
	@Autowired 
	private IProjectItemService projectItemServie;
	@Autowired
	private IProjectFileService projectFileService;
	/**
	 * 로그인한 사용자의 프로젝트 목록
	 * @param vm
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/api/project/{prj_id}/cde/list",method=RequestMethod.GET)
	public @ResponseBody ProjectItemViewModel listProjectAction(@PathVariable String prj_id,ProjectItemViewModel vm) throws Exception{	
		vm.setListProjectItems(projectItemServie.list(prj_id,vm.getParamStep(),vm.getPageNo(),vm.getPageSize()));
		return vm;
	}
	
	@RequestMapping(value="/api/project/item/create",method=RequestMethod.POST)
	public @ResponseBody ProjectItemViewModel craeteItemProjectAction(@RequestBody ProjectItemViewModel vm) throws Exception{	
		vm.setResultCount(projectItemServie.createItem(vm.getDetailProjectItem(), vm.getListItemStep(), getCommonParams()));
		vm.setListProjectItems(projectItemServie.list(vm.getDetailProjectItem().getPrj_id(),vm.getParamStep(),vm.getPageNo(),vm.getPageSize()));
		return vm;
	} 
	

	
	
}
