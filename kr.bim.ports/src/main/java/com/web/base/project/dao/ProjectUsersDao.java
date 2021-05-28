package com.web.base.project.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.web.base.BaseDao;
@Repository("projectUsersDao")
public class ProjectUsersDao extends BaseDao {
	public int create(ProjectUsersDto paramBean) {
		return update("projectUsers.create",paramBean);
	}
	public int createSubgrp(ProjectUsersDto paramBean) {
		return update("projectUsers.createSubgrp",paramBean);
	}
	public int update(ProjectUsersDto paramBean) {
		return update("projectUsers.update",paramBean);
	}
	
	public int delete(HashMap<String,Object> paramMap) {
		return update("projectUsers.delete",paramMap);
	}
	
	public List<ProjectUsersDto> list(HashMap<String,Object> paramMap) {
		return selectList("projectUsers.list",paramMap);
	}
	public List<ProjectUsersDto> listAll(HashMap<String,Object> paramMap) {
		return selectList("projectUsers.listAll",paramMap);
	}
	public ProjectUsersDto detail(HashMap<String,Object> paramMap) {
		return (ProjectUsersDto)selectOne("projectUsers.detail",paramMap);
	}
	
}