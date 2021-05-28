package com.web.base.project.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.base.BaseService;
import com.web.base.CommonParams;
import com.web.base.MessageStatus;
import com.web.base.project.dao.ProjectCategoryDao;
import com.web.base.project.dao.ProjectCategoryDto;
import com.web.base.project.dao.ProjectMasterDao;
import com.web.base.project.dao.ProjectMasterDto;
import com.web.base.project.dao.ProjectUsersDao;
import com.web.base.project.dao.ProjectUsersDto;
@Service("projectService")
public class ProjectServiceImpl extends BaseService implements IProjectService {

	@Autowired
	private ProjectMasterDao projectMasterDao;
	@Autowired
	private ProjectUsersDao projectUsersDao;
	@Autowired
	private ProjectCategoryDao projectCategoryDao;
	
	@Override
	public ProjectMasterDto detailMaster(String paramId) {
		HashMap<String,Object> paramMap=new HashMap<String,Object>();
		paramMap.put("prj_id",paramId);
		ProjectMasterDto rs=projectMasterDao.detail(paramMap);
		return rs;
	}

	@Override
	public ProjectMasterDto detailMaster(String paramId, CommonParams paramCommon) {
		ProjectMasterDto rs=null;
		HashMap<String,Object> paramMap=new HashMap<String,Object>();
		paramMap.put("user_id",paramCommon.getLoginUserID());
		paramMap.put("prj_id",paramId);
		ProjectUsersDto projectUsersDto =projectUsersDao.detail(paramMap);
		if(projectUsersDto!=null) {
			rs=projectMasterDao.detail(paramMap);
		}
		return rs;
	}

	@Override
	public List<ProjectMasterDto> listMaster() {
		
		List<ProjectMasterDto> rs=projectMasterDao.list(null);
		return rs;
	}
	@Override
	public List<ProjectMasterDto> listMaster(String paramUserId) {
		if(stringIsNullOrEmpty(paramUserId))
			return null;
		
		HashMap<String,Object> paramMap=new HashMap<String, Object>();
		paramMap.put("user_id",paramUserId);
		List<ProjectMasterDto> rs=projectMasterDao.listByUser(paramMap);
		return rs;
	}
	@Override
	public int createMaster(ProjectMasterDto paramBean, CommonParams common) {
		if(stringIsNullOrEmpty(paramBean.getPrj_title()) || stringIsNullOrEmpty(paramBean.getPrj_id())) {
			return  MessageStatus.VALID_REQUIRED.value();
		}
		paramBean.setStart_date(stringIsNullOrEmpty(paramBean.getStart_date())? null :paramBean.getStart_date().substring(0,10));
		paramBean.setEnd_date(stringIsNullOrEmpty(paramBean.getEnd_date())? null :paramBean.getEnd_date().substring(0,10));
		paramBean.setSetup_date(stringIsNullOrEmpty(paramBean.getSetup_date())? null :paramBean.getSetup_date().substring(0,10));
		paramBean.setCreate_user_id(common.getLoginUserID());
		paramBean.setUpdate_user_id(common.getLoginUserID());
		return projectMasterDao.create(paramBean);
	}

	@Override
	public int updateMaster(ProjectMasterDto paramBean,List<ProjectCategoryDto> paramCategoryTitles, CommonParams common) {
		if(stringIsNullOrEmpty(paramBean.getPrj_title()) || stringIsNullOrEmpty(paramBean.getPrj_id())) {
			return  MessageStatus.VALID_REQUIRED.value();
		}
		ProjectMasterDto  projectMasterDto=detailMaster(paramBean.getPrj_id());
		
		if(stringIsNullOrEmpty(paramBean.getConfirm_yn())) {
			paramBean.setConfirm_yn(projectMasterDto.getConfirm_yn());
		}
		if(stringIsNullOrEmpty(paramBean.getUse_yn())) {
			paramBean.setUse_yn(projectMasterDto.getUse_yn());
		}
		
		if(stringIsNullOrEmpty(paramBean.getOpen_yn())) {
			paramBean.setOpen_yn(projectMasterDto.getOpen_yn());
		}
		if(stringIsNullOrEmpty(paramBean.getManage_user_id())) {
			paramBean.setManage_user_id(projectMasterDto.getManage_user_id());
		}
		paramBean.setStart_date(stringIsNullOrEmpty(paramBean.getStart_date())? null :paramBean.getStart_date().substring(0,10));
		paramBean.setEnd_date(stringIsNullOrEmpty(paramBean.getEnd_date())? null :paramBean.getEnd_date().substring(0,10));
		paramBean.setSetup_date(stringIsNullOrEmpty(paramBean.getSetup_date())? null :paramBean.getSetup_date().substring(0,10));
		paramBean.setUpdate_user_id(common.getLoginUserID());
		
		int rs=0;
		rs+=findAndDeleteCategories(paramCategoryTitles, paramBean.getPrj_id());
		rs+=findAndUpdateCategories(paramCategoryTitles, paramBean.getPrj_id());

		rs+=projectMasterDao.update(paramBean);
		return rs;
	}





	@Override
	public int createCategory(ProjectCategoryDto paramBean) {
		
		return projectCategoryDao.create(paramBean);
	}

	@Override
	public int deleteCategory(int paramSeq) {
		HashMap<String,Object> paramMap=new HashMap<String, Object>();
		paramMap.put("category_seq",paramSeq);
		return projectCategoryDao.delete(paramMap);
	}
	@Override
	public int deleteCategory(String paramPrjId) {
		HashMap<String,Object> paramMap=new HashMap<String, Object>();
		paramMap.put("prj_id",paramPrjId);
		return projectCategoryDao.delete(paramMap);
	}
	@Override
	public List<ProjectCategoryDto> listCategory(String projectId) {
		HashMap<String,Object> paramMap=new HashMap<String, Object>();
		paramMap.put("prj_id",projectId);
		return projectCategoryDao.list(paramMap);
	}

	@Override
	public int createUser(ProjectUsersDto paramBean, CommonParams paramCommon) {
		int rs=0;
		if(stringIsNullOrEmpty(paramBean.getUser_id())
			//	||stringIsNullOrEmpty(paramBean.getUser_email())
				||stringIsNullOrEmpty(paramBean.getPrj_id())
				) {
			return MessageStatus.VALID_REQUIRED.value();
		} 
		paramBean.setCreate_user_id(paramCommon.getLoginUserID());
		paramBean.setUpdate_user_id(paramCommon.getLoginUserID());
		paramBean.setUse_yn("Y");
		

		
		rs+=projectUsersDao.create(paramBean);
		return rs;
	}

	@Override
	public List<ProjectUsersDto> listUsers(String projectId) {
		List<ProjectUsersDto> rs=null;
		HashMap<String,Object> paramMap=new HashMap<String,Object>();
		paramMap.put("prj_id",projectId);
		rs=projectUsersDao.list(paramMap);
		
		return rs;
	}

	@Override
	public int updateUser(ProjectUsersDto paramBean, CommonParams paramCommon) {
		int rs=0;
		if(stringIsNullOrEmpty(paramBean.getUser_id())
				//||stringIsNullOrEmpty(paramBean.getUser_email())
				||stringIsNullOrEmpty(paramBean.getPrj_id())
				) {
			return MessageStatus.VALID_REQUIRED.value();
		} 
		paramBean.setCreate_user_id(paramCommon.getLoginUserID());
		paramBean.setUpdate_user_id(paramCommon.getLoginUserID());
		paramBean.setUse_yn("Y");
		rs+=projectUsersDao.update(paramBean);
		return rs;
	}

	@Override
	public int deleteUser(String projectId, String paramUserId, CommonParams paramCommon) {
		int rs=0;
		HashMap<String,Object> paramMap=new HashMap<String,Object>();
		paramMap.put("prj_id",projectId);
		paramMap.put("user_id",paramUserId);
		paramMap.put("update_user_id", paramCommon.getLoginUserID());
		rs+=projectUsersDao.delete(paramMap);
		return rs;
	}

	@Override
	public int createMaster(ProjectMasterDto paramBean, List<ProjectCategoryDto> paramCategoryTitles, CommonParams common) {
		int rs=0;
		if(paramCategoryTitles!=null && paramCategoryTitles.size()>0) {
			paramBean.setManage_user_id(common.getLoginUserID());
			paramBean.setConfirm_yn("N");
			rs+=createMaster(paramBean, common);
			
			ProjectUsersDto projectUser=new ProjectUsersDto();
			projectUser.setPrj_id(paramBean.getPrj_id());
			projectUser.setUser_id(common.getLoginUserID());
			projectUser.setUser_email(common.getLoginUserEmail());
			projectUser.setCreate_user_ip(common.getRequestIP());
			projectUser.setUser_name(common.getLoginUserName());
			projectUser.setOwner_yn("Y");
			
			rs+=createUser(projectUser, common);
			rs+=deleteCategory(paramBean.getPrj_id());
			
			for (ProjectCategoryDto projectCategoryDto : paramCategoryTitles) {
				projectCategoryDto.setPrj_id(paramBean.getPrj_id());
				rs+=createCategory(projectCategoryDto);
			}
		}
		return rs;
	}

	@Override
	public int updateMaster(String paramPrjId, String paramConfirmYn, CommonParams common) {
		ProjectMasterDto projectMasterDto=detailMaster(paramPrjId);
		projectMasterDto.setConfirm_yn(paramConfirmYn);
		projectMasterDto.setUpdate_user_id(common.getLoginUserID());
		return projectMasterDao.update(projectMasterDto);
	}

    private int findAndDeleteCategories(List<ProjectCategoryDto> paramCategories,String paramPrjId) {
    	int rs=0;
    	List<ProjectCategoryDto> target=new ArrayList<ProjectCategoryDto>();
    	
    	List<ProjectCategoryDto> listCategories=listCategory(paramPrjId);
    	for (ProjectCategoryDto oldCategories : listCategories) {
    		boolean isTarget=true;
    		for (ProjectCategoryDto newCategories:paramCategories ) {
    			if(newCategories.category_seq==oldCategories.category_seq) {
    				isTarget=false;
    			}
    		}
    		if(isTarget) target.add(oldCategories);
    		
		}
    	
    	for (ProjectCategoryDto projectCategoryDto : target) {
    		rs+=deleteCategory(projectCategoryDto.getCategory_seq());
		}
    	return rs;
    }

    private int findAndUpdateCategories(List<ProjectCategoryDto> paramCategories,String paramPrjId) {
    	int rs=0;
    	List<ProjectCategoryDto> updateTarget=new ArrayList<ProjectCategoryDto>();
    	List<ProjectCategoryDto> createTarget=new ArrayList<ProjectCategoryDto>();
    	
    	List<ProjectCategoryDto> listCategories=listCategory(paramPrjId);
    	for (ProjectCategoryDto newCategories : paramCategories) {
    		boolean isCreateTarget=true;
    		for (ProjectCategoryDto oldCategories : listCategories) {
    			if(newCategories.category_seq==oldCategories.category_seq) {
    				updateTarget.add(newCategories);
    				isCreateTarget=false;
    			}
    		}
    		if(isCreateTarget) createTarget.add(newCategories);
		}
    	
    	for (ProjectCategoryDto projectCategoryDto : updateTarget) {
    		HashMap<String,Object> paramMap=new HashMap<String, Object>();
    		paramMap.put("category_seq",projectCategoryDto.getCategory_seq());
    		paramMap.put("category_title",projectCategoryDto.getCategory_title());
    		rs+=projectCategoryDao.update(paramMap);
		}
    	
    	for (ProjectCategoryDto projectCategoryDto : createTarget) {
    		projectCategoryDto.setPrj_id(paramPrjId);
    		rs+=createCategory(projectCategoryDto);
		}
    	return rs;
    }

	@Override
	public int createUser(List<ProjectUsersDto> paramList, CommonParams paramCommon) {
		int rs=0;
		
		List<ProjectUsersDto> updateUsers=new ArrayList<ProjectUsersDto>();
		List<ProjectUsersDto> createUsers=new ArrayList<ProjectUsersDto>();
		
		List<ProjectUsersDto> listProjectUser=listUsersWithDelete(paramList.get(0).getPrj_id());
		for (ProjectUsersDto projectUsersDto : paramList) {
			if(stringIsNullOrEmpty(projectUsersDto.getUser_id())
					//	||stringIsNullOrEmpty(paramBean.getUser_email())
						||stringIsNullOrEmpty(projectUsersDto.getPrj_id())
						) {
					rs= MessageStatus.VALID_REQUIRED.value();
					break;
				} 
				projectUsersDto.setCreate_user_id(paramCommon.getLoginUserID());
				projectUsersDto.setUpdate_user_id(paramCommon.getLoginUserID());
				projectUsersDto.setUse_yn("Y");
				boolean isUpdate=false;
				for (ProjectUsersDto  preProjectUsersDto : listProjectUser) {
					if(preProjectUsersDto.getUser_id().equals(projectUsersDto.getUser_id())) {
						isUpdate=true;
						preProjectUsersDto.setUse_yn("Y");
						updateUsers.add(preProjectUsersDto);
						break;
					}
				}
				
				if(!isUpdate) {
					createUsers.add(projectUsersDto);
				}
		}
		
		
		for (ProjectUsersDto projectUsersDto : createUsers) {
			rs+=projectUsersDao.create(projectUsersDto);
		}
		for (ProjectUsersDto projectUsersDto : updateUsers) {
			rs+=projectUsersDao.update(projectUsersDto);
		}
		return rs;
	}

	@Override
	public int updateUserOwner(String paramPrjId, String paramUserId, String paramOwnerYn, CommonParams paramCommon) {
		ProjectUsersDto projectUsersDto=detailUser(paramPrjId,paramUserId);
		projectUsersDto.setOwner_yn(paramOwnerYn);
		return updateUser(projectUsersDto, paramCommon);
	}

	@Override
	public ProjectUsersDto detailUser(String projectId, String paramUserId) {
		ProjectUsersDto rs=null;
		HashMap<String,Object> paramMap=new HashMap<String,Object>();
		paramMap.put("prj_id",projectId);
		paramMap.put("user_id",paramUserId);
		rs=projectUsersDao.detail(paramMap);
		return rs;
	
	}

	@Override
	public List<ProjectUsersDto> listUsersWithDelete(String projectId) {
		HashMap<String,Object> paramMap=new HashMap<String,Object>();
		paramMap.put("prj_id",projectId);
		return projectUsersDao.listAll(paramMap);
	}

}