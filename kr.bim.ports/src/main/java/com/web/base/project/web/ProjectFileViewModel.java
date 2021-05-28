package com.web.base.project.web;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.web.base.BaseViewModel;
import com.web.base.project.dao.ProjectFilesDto;

public class ProjectFileViewModel extends BaseViewModel {
	
	private List<ProjectFileCategoryViewModel> listFileCategory;
	private List<ProjectFilesDto> list;
	private List<String> listCategoryIds;
	private String version;
	private String separator;
	
	
	
	public List<String> getListCategoryIds() {
		return listCategoryIds;
	}
	public void setListCategoryIds(List<String> listCategoryIds) {
		this.listCategoryIds = listCategoryIds;
	}
	public List<ProjectFilesDto> getList() {
		return list;
	}
	public void setList(List<ProjectFilesDto> list) {
		this.list = list;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getSeparator() {
		return separator;
	}
	public void setSeparator(String separator) {
		this.separator = separator;
	}
	
	public List<ProjectFileCategoryViewModel> getListFileCategory() {
		return listFileCategory;
	}
	public void setListFileCategory(List<ProjectFileCategoryViewModel> listFileCategory) {
		this.listFileCategory = listFileCategory;
	}
	
	
}
