package com.web.base.project.dao;

import java.util.List;

public class ProjectItemsExtDto extends ProjectItemsDto {
	private List<ProjectStepDto> listStep;
	
	public List<ProjectStepDto> getListStep() {
		return listStep;
	}

	public void setListStep(List<ProjectStepDto> listStep) {
		this.listStep = listStep;
	}
	
}
