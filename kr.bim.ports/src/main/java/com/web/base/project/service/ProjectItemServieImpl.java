package com.web.base.project.service;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.base.BaseService;
import com.web.base.CommonParams;
import com.web.base.MessageStatus;
import com.web.base.global.SysKeyword;
import com.web.base.project.dao.ProjectItemsDao;
import com.web.base.project.dao.ProjectItemsDto;
import com.web.base.project.dao.ProjectItemsExtDto;
import com.web.base.project.dao.ProjectStepDao;
import com.web.base.project.dao.ProjectStepDto;
@Service("projectItemServie")
public class ProjectItemServieImpl extends BaseService implements IProjectItemService {
	@Autowired
	private ProjectItemsDao projectItemsDao;
	@Autowired
	private ProjectStepDao projectStepDao;
	
	@Override
	public int createItem(ProjectItemsDto paramBean, List<ProjectStepDto> paramListStep, CommonParams common) {
		int rs=0;
		
		if(paramListStep==null || paramListStep.size()==0) return MessageStatus.VALID_REQUIRED.value();
		if(stringIsNullOrEmpty(paramBean.getTitle()) || stringIsNullOrEmpty(paramBean.getCont()) ) return MessageStatus.VALID_REQUIRED.value();
		if(common==null || stringIsNullOrEmpty(common.getLoginUserID())) return MessageStatus.VALID_REQUIRED.value();
		
		int seq=maxSort(paramBean.getPrj_id());
		paramBean.setSort(seq+100);
		paramBean.setGrp(paramBean.getSort());
		paramBean.setCreate_user_id(common.getLoginUserID());
		paramBean.setUpdate_user_id(common.getLoginUserID());
		paramBean.setCreate_ip(common.getRequestIP());
		paramBean.setUse_yn("Y");
		paramBean.setComplete_yn("N");
		
		Object obj=projectItemsDao.create(paramBean);
		Collections.sort(paramListStep,(d1,d2)->{ return d1.getCategory_seq()-d2.getCategory_seq();});	
		int i=0;
		for (ProjectStepDto projectStepDto : paramListStep) {
			projectStepDto.setStep_yn("N");
			if(i==0)projectStepDto.setStep_yn("Y");
			projectStepDto.setConfirm_yn("N");
			projectStepDto.setPrj_id(paramBean.getPrj_id());
			projectStepDto.setItems_seq(paramBean.getSeq());
			projectStepDto.setProcess_code(SysKeyword.CODE_PRC_STUS_01);
			projectStepDto.setCreate_user_id(common.getLoginUserID());
			projectStepDto.setUpdate_user_id(common.getLoginUserID());
			rs+=projectStepDao.create(projectStepDto);
			i++;
		}
		return rs;
	}
	@Override
	public int maxSort(String paramPrjId) {
		HashMap<String,Object> paramMap=new HashMap<String,Object>();
		paramMap.put("prj_id",paramPrjId);
		return projectItemsDao.maxSort(paramMap);
		
	}
	@Override
	public List<ProjectItemsDto> list(String paramPrjId,int paramCategorySeq,int pageNum,int rowSize) {
		HashMap<String,Object> paramMap=new HashMap<String,Object>();
		paramMap.put("prj_id",paramPrjId);
		paramMap.put("category_seq",paramCategorySeq);
		addPageIndex(paramMap, pageNum, rowSize);

		List<ProjectItemsDto> rs=projectItemsDao.list(paramMap);
		
		List<ProjectStepDto> steps=projectStepDao.list(paramMap);
		for (ProjectItemsDto projectItemsDto : rs) {
			ProjectItemsExtDto item= (ProjectItemsExtDto)projectItemsDto;
			List<ProjectStepDto> itemSteps=new ArrayList<ProjectStepDto>();
			for (ProjectStepDto projectStepDto : steps) {
				if(projectItemsDto.getSeq()==projectStepDto.getItems_seq()) {
					itemSteps.add(projectStepDto);
				}
			}
			item.setListStep(itemSteps);
		}
		return rs;
	}

}
