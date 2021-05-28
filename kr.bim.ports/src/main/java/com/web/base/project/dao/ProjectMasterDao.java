package com.web.base.project.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.web.base.BaseDao;

@Repository("projectMasterDao")
public class ProjectMasterDao extends BaseDao {
	public int create(ProjectMasterDto paramBean) {
		return update("projectMaster.create",paramBean);
	}
	public int update(ProjectMasterDto paramBean) {
		return update("projectMaster.update",paramBean);
	}
	@SuppressWarnings("unchecked")
	public List<ProjectMasterDto> list(HashMap<String,Object> paramMap) {
		return selectList("projectMaster.list",paramMap);
	}
	@SuppressWarnings("unchecked")
	public List<ProjectMasterDto> listByUser(HashMap<String,Object> paramMap) {
		return selectList("projectMaster.listByUser",paramMap);
	}
	public ProjectMasterDto detail(HashMap<String,Object> paramMap) {
		return (ProjectMasterDto)selectOne("projectMaster.detail",paramMap);
	}
}