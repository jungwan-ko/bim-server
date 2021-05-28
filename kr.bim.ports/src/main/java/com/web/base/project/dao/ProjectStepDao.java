package com.web.base.project.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.web.base.BaseDao;
@Repository("projectStepDao")
public class ProjectStepDao extends BaseDao {
	public int create(ProjectStepDto paramBean) {
		
		return update("projectStep.create",paramBean);
	}
	public int update(ProjectStepDto paramBean) {
		int rs=0;
		return rs;
	}
	
	public int delete(ProjectStepDto paramBean) {
		int rs=0;
		return rs;
	}
	
	public List<ProjectStepDto> list(HashMap<String,Object> paramMap) {
		
		return selectList("projectStep.list",paramMap);
	}
	
	public ProjectStepDto detail(ProjectStepDto paramBean) {
		ProjectStepDto rs=null;
		return rs;
	}
	
}
