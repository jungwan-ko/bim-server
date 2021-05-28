package com.web.base.project.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.web.base.BaseDao;
@Repository("projectCategoryDao")
public class ProjectCategoryDao extends BaseDao  {
	public int create(ProjectCategoryDto paramBean) {
	
		return update("projectCategory.create",paramBean);
	}
	public int update(HashMap<String,Object> paramBean) {
		return update("projectCategory.update",paramBean);
	}
	
	public int delete(HashMap<String,Object> paramMap) {
		return update("projectCategory.delete",paramMap);
	}
	
	public List<ProjectCategoryDto> list(HashMap<String,Object> paramMap) {
		return selectList("projectCategory.list",paramMap);
	}

	

}