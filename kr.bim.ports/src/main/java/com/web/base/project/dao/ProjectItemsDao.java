package com.web.base.project.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.web.base.BaseDao;
@Repository("projectItemsDao")
public class ProjectItemsDao extends BaseDao {
	public int create(ProjectItemsDto paramBean) {
		
		return update("projectItems.create",paramBean);
	}

	
	public int delete(ProjectItemsDto paramBean) {
		return update("projectItems.delete",paramBean);
	}
	
	public List<ProjectItemsDto> list(HashMap<String,Object> paramMap) {
	
		return selectList("projectItems.list",paramMap);
	}
	public int maxSort(HashMap<String,Object> paramMap) {
		
		return (Integer)selectOne("projectItems.maxSort",paramMap);
	}
	
}