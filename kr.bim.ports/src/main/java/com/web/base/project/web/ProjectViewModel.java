package com.web.base.project.web;

import java.util.List;

import com.web.base.BaseViewModel;
import com.web.base.project.dao.ProjectCategoryDto;
import com.web.base.project.dao.ProjectMasterDto;
import com.web.base.project.dao.ProjectUsersDto;

public class ProjectViewModel extends BaseViewModel {
	private List<ProjectMasterDto> listProjects;
	private ProjectMasterDto detailProject;
	private List<ProjectCategoryDto> listProjectCategory;
	private List<ProjectUsersDto> listUsers;
	private ProjectUsersDto detailUser;
	

	public ProjectUsersDto getDetailUser() {
		return detailUser;
	}
	public void setDetailUser(ProjectUsersDto detailUser) {
		this.detailUser = detailUser;
	}
	public List<ProjectUsersDto> getListUsers() {
		return listUsers;
	}
	public void setListUsers(List<ProjectUsersDto> listUsers) {
		this.listUsers = listUsers;
	}
	public List<ProjectMasterDto> getListProjects() {
		return listProjects;
	}
	public void setListProjects(List<ProjectMasterDto> listProjects) {
		this.listProjects = listProjects;
	}
	public ProjectMasterDto getDetailProject() {
		return detailProject;
	}
	public void setDetailProject(ProjectMasterDto detailProject) {
		this.detailProject = detailProject;
	}
	public List<ProjectCategoryDto> getListProjectCategory() {
		return listProjectCategory;
	}
	public void setListProjectCategory(List<ProjectCategoryDto> listProjectCategory) {
		this.listProjectCategory = listProjectCategory;
	}
	
	
	
	
}