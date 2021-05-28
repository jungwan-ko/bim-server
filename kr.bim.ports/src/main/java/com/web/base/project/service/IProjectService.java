package com.web.base.project.service;

import java.util.HashMap;
import java.util.List;
import com.web.base.CommonParams;
import com.web.base.project.dao.ProjectCategoryDto;
import com.web.base.project.dao.ProjectMasterDto;
import com.web.base.project.dao.ProjectUsersDto;

public interface IProjectService {
	public ProjectMasterDto detailMaster(String paramId);
    /**
     * 로그인한 사용자가 속해있을 경우만 리턴
     * @param paramId
     * @param paramCommon
     * @return
     */
    public ProjectMasterDto detailMaster(String paramId,CommonParams paramCommon);
	public List<ProjectMasterDto> listMaster();
	public List<ProjectMasterDto> listMaster(String paramUserId);
	public int createMaster(ProjectMasterDto paramBean,CommonParams common);
	public int createMaster(ProjectMasterDto paramBean,List<ProjectCategoryDto> paramCategoryTitles,CommonParams common);
	public int updateMaster(ProjectMasterDto paramBean,List<ProjectCategoryDto> paramCategoryTitles,CommonParams common);
	public int updateMaster(String paramPrjId,String paramConfirmYn,CommonParams common);
	
	
	public int createCategory(ProjectCategoryDto paramBean);
	public int deleteCategory(int paramSeq);
	public int deleteCategory(String paramPrjId);
	public List<ProjectCategoryDto> listCategory(String projectId);
	
	public int createUser(ProjectUsersDto paramBean, CommonParams paramCommon);
	public int createUser(List<ProjectUsersDto> paramList, CommonParams paramCommon);
	public List<ProjectUsersDto> listUsers(String projectId);
	public List<ProjectUsersDto> listUsersWithDelete(String projectId);
	public int updateUser(ProjectUsersDto paramBean, CommonParams paramCommon);
	public int updateUserOwner(String paramPrjId,String paramUserId,String paramOwnerYn, CommonParams paramCommon);
	public int deleteUser(String projectId, String paramUserId, CommonParams paramCommon);
	public ProjectUsersDto detailUser(String projectId,String paramUserId);
	
	
	
	
	
	
}