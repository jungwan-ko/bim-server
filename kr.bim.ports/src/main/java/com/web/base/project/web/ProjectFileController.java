package com.web.base.project.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.web.base.BaseController;
import com.web.base.BaseViewModel;
import com.web.base.file.dao.AttachFileDTO;
import com.web.base.project.dao.ProjectFilesDto;
import com.web.base.project.service.IProjectFileService;
@Controller("projectFileController")
public class ProjectFileController extends BaseController {

	
	@Autowired
	private IProjectFileService projectFileService;
	
	@RequestMapping(value = "/api/project/cde/file/upload", method = RequestMethod.POST)
	@ResponseBody
	public HashMap<String, String> uploadFileAction(ProjectFileViewModel vm, ModelMap model) throws Exception {
		
		List<ProjectFilesDto> saveFileInfo=projectFileService.createFile(vm.getUploadFiles(),vm.getListCategoryIds(),getCommonParams());
		projectFileService.create(saveFileInfo, vm.getId()) ;
		String filGrpId=saveFileInfo==null || saveFileInfo.size()==0?null:saveFileInfo.get(0).getFile_grp_id();
		HashMap<String, String> rs=new HashMap<String, String>();
		rs.put("file_grp_id", filGrpId);
		return rs;
	}
	
	@RequestMapping(value="/api/project/item/file/list",method=RequestMethod.GET)
	public @ResponseBody ProjectFileViewModel listFileItemProjectAction(ProjectFileViewModel vm) throws Exception{	
		vm.setList(projectFileService.list(vm.getFileGroup()));
		return vm;
	} 
	
	
	
}
