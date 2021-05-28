package com.web.base.project.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.web.base.BaseController;
import com.web.base.project.dao.ProjectMasterDto;
import com.web.base.project.service.IProjectService;
@CrossOrigin(origins = "http://127.0.0.1:5500")
@Controller("projectController")
public class ProjectController extends BaseController {
	@Autowired 
	private IProjectService projectService;

	/**
	 * 로그인한 사용자의 프로젝트 목록
	 * @param vm
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/api/project/list",method=RequestMethod.GET)
	public @ResponseBody ProjectViewModel listProjectAction(ProjectViewModel vm) throws Exception{	
		vm.setListProjects(projectService.listMaster(getCommonParams().getLoginUserID()));
		return vm;
	}
	
	/**
	 * 프로젝트 생성
	 * @param vm
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/api/project/create",method=RequestMethod.POST)
	public @ResponseBody ProjectViewModel createProjectAction(@RequestBody ProjectViewModel vm) throws Exception{	
		vm.setResultCount(projectService.createMaster(vm.getDetailProject(),vm.getListProjectCategory(), getCommonParams()));
		vm.setListProjects(projectService.listMaster(getCommonParams().getLoginUserID()));
		return vm;
	}
	
	
	/**
	 * 프로젝트 상세
	 * @param vm
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/api/project/detail/{prj_id}",method=RequestMethod.GET)
	public @ResponseBody ProjectViewModel detailProjectAction(@PathVariable String prj_id, ProjectViewModel vm) throws Exception{	
		vm.setDetailProject(projectService.detailMaster(prj_id, getCommonParams()));
		vm.setListProjectCategory(projectService.listCategory(prj_id));
		vm.setListUsers(projectService.listUsers(prj_id));
		return vm;
	}
	
	/**
	 * 프로젝트 아이디  체크
	 * @param vm
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/api/project/check/id/{prj_id}",method=RequestMethod.GET)
	public @ResponseBody ProjectViewModel idCheckProjectAction(@PathVariable("prj_id") String prj_id,ProjectViewModel vm) throws Exception{	
		vm.setResultCount(projectService.detailMaster(prj_id)==null?0:1);
		return vm;
	}
	
	/**
	 * 프로젝트 승인/취소
	 * @param vm
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/api/project/update/confirm",method=RequestMethod.POST)
	public @ResponseBody ProjectViewModel confirmUpdateProjectAction(@RequestBody ProjectViewModel vm) throws Exception{
		vm.setResultCount(projectService.updateMaster(vm.getDetailProject().getPrj_id(),vm.getDetailProject().getConfirm_yn(),getCommonParams()));
		return vm;
	}
	
	/**
	 * 프로젝트 업데이트
	 * @param vm
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/api/project/update",method=RequestMethod.POST)
	public @ResponseBody ProjectViewModel updateProjectAction(@RequestBody ProjectViewModel vm) throws Exception{
		vm.setResultCount(projectService.updateMaster(vm.getDetailProject(),vm.getListProjectCategory(),getCommonParams()));
		return vm;
	}
	
	@RequestMapping(value="/api/project/{prj_id}/user/list",method=RequestMethod.GET)
	public @ResponseBody ProjectViewModel listUserProjectAction(@PathVariable String prj_id,ProjectViewModel vm) throws Exception{
		vm.setListUsers(projectService.listUsers(prj_id));
		return vm;
	}
	
	@RequestMapping(value="/api/project/user/create",method=RequestMethod.POST)
	public @ResponseBody ProjectViewModel createUserProjectAction(@RequestBody ProjectViewModel vm) throws Exception{
		vm.setResultCount(projectService.createUser(vm.getListUsers(),getCommonParams()));
		vm.setListUsers(projectService.listUsers(vm.getId()));
		return vm;
	}

	@RequestMapping(value="/api/project/user/owner/update",method=RequestMethod.POST)
	public @ResponseBody ProjectViewModel updateOwnerUserProjectAction(@RequestBody ProjectViewModel vm) throws Exception{
		vm.setResultCount(
				projectService.updateUserOwner(
				vm.getDetailUser().getPrj_id()
				,vm.getDetailUser().getUser_id()
				,vm.getDetailUser().getOwner_yn()
				,getCommonParams())
				);
		
		return vm;
	}
	@RequestMapping(value="/api/project/user/delete",method=RequestMethod.POST)
	public @ResponseBody ProjectViewModel deleteUserProjectAction(@RequestBody ProjectViewModel vm) throws Exception{
		vm.setResultCount(
				projectService.deleteUser(
				vm.getId()
				,vm.getDetailUser().getUser_id()
				,getCommonParams())
				);
		vm.setListUsers(projectService.listUsers(vm.getId()));
		
		return vm;
	}
}