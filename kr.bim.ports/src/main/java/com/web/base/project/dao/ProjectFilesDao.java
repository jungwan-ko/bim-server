package com.web.base.project.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.web.base.BaseDao;
@Repository("projectFileDao")
public class ProjectFilesDao extends BaseDao {
	public int create(ProjectFilesDto paramBean) {
		
		return update("projectFile.create",paramBean);
	}
	public int update(ProjectFilesDto paramBean) {
		int rs=0;
		return rs;
	}
	
	public int delete(ProjectFilesDto paramBean) {
		int rs=0;
		return rs;
	}
	
	public List<ProjectFilesDto> list(HashMap<String,Object> paramMap) {
		
		return selectList("projectFile.list",paramMap);
	}
	
	public ProjectFilesDto detail(ProjectFilesDto paramBean) {
		ProjectFilesDto rs=null;
		return rs;
	}
}