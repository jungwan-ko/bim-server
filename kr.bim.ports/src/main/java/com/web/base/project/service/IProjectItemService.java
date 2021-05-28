package com.web.base.project.service;

import java.util.List;

import com.web.base.CommonParams;
import com.web.base.project.dao.ProjectItemsDto;
import com.web.base.project.dao.ProjectStepDto;

public interface IProjectItemService {
	public int createItem(ProjectItemsDto paramItem,List<ProjectStepDto> parmListStep,CommonParams common);
	public int maxSort(String paramPrjId);
	public List<ProjectItemsDto> list(String paramPrjId,int paramCategorySeq,int pageNo,int pageSize);
}
