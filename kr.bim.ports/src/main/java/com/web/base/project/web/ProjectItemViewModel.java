package com.web.base.project.web;

import java.util.List;

import com.web.base.BaseViewModel;
import com.web.base.project.dao.ProjectItemsDto;
import com.web.base.project.dao.ProjectStepDto;

public class ProjectItemViewModel extends BaseViewModel {
	private List<ProjectItemsDto> listProjectItems;
	private ProjectItemsDto detailProjectItem;
	private List<ProjectStepDto> listItemStep;
	
	private int paramStep;
	
	
	public int getParamStep() {
		return paramStep;
	}
	public void setParamStep(int paramStep) {
		this.paramStep = paramStep;
	}
	public List<ProjectItemsDto> getListProjectItems() {
		return listProjectItems;
	}
	public void setListProjectItems(List<ProjectItemsDto> listProjectItems) {
		this.listProjectItems = listProjectItems;
	}
	public ProjectItemsDto getDetailProjectItem() {
		return detailProjectItem;
	}
	public void setDetailProjectItem(ProjectItemsDto detailProjectItem) {
		this.detailProjectItem = detailProjectItem;
	}
	public List<ProjectStepDto> getListItemStep() {
		return listItemStep;
	}
	public void setListItemStep(List<ProjectStepDto> listItemStep) {
		this.listItemStep = listItemStep;
	}
	
	
	
	
	
	
	
}
