package com.web.base.bbs.service;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;
import com.web.base.BaseService;
import com.web.base.CommonParams;
import com.web.base.MessageStatus;
import com.web.base.bbs.dao.BBSCategoryDTO;
import com.web.base.bbs.dao.BBSCommentDao;
import com.web.base.bbs.dao.BBSCommentDto;
import com.web.base.bbs.dao.BBSContentDTO;
import com.web.base.bbs.dao.BBSLogDTO;
import com.web.base.bbs.dao.BBSMasterDTO;
import com.web.base.bbs.dao.BBSUserDTO;
import com.web.base.bbs.dao.IBBSContentDao;
import com.web.base.bbs.dao.IBBSLogDao;
import com.web.base.bbs.dao.IBBSMasterDao;
import com.web.base.bbs.dao.IBBSUserDao;
import com.web.base.file.dao.AttachFileDTO;
import com.web.base.file.service.IFileService;
import com.web.base.global.MessageKeyword;
import com.web.base.global.SysKeyword;
import com.web.base.utils.AES256Cipher;
import com.web.base.utils.Encryption;

@Service("bbsService")
public class BBSServiceImpl extends BaseService implements IBBSService {
	@Autowired
	private IBBSContentDao bbsContentDao;
	@Autowired
	private IBBSMasterDao bbsMasterDao;
	@Autowired
	private IBBSLogDao bbsLogDao;
	@Autowired
	private IBBSUserDao bbsUserDao;
	@Autowired
	private BBSCommentDao bbsCommentDao;
	@Autowired
	private IFileService fileService;

	@Value("${file.bbs.path}")
	private String fileProfilePath;

	@Override
	public List<BBSContentDTO> listContent(String paramBBSID, String paraCatSeq, String paramSearchTitle,
			String paramSearchContent, String paramSearchName, String paramSearchStDate, String paramSearchEnDate,
			String paramSpellKor, String paramSpellEn, int pageNo, int pageSize) {

		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("bbs_id", paramBBSID);
		paramMap.put("bbs_cont_title",
				paramSearchTitle == null || paramSearchTitle.isEmpty() ? null : paramSearchTitle);
		paramMap.put("bbs_cont",
				paramSearchContent == null || paramSearchContent.isEmpty() ? null : paramSearchContent);
		paramMap.put("user_name", paramSearchName);
		paramMap.put("category_seq",paraCatSeq==null || paraCatSeq.isEmpty() ? -1 : Integer.parseInt(paraCatSeq));
		paramMap.put("st_date", paramSearchStDate==null || paramSearchStDate.isEmpty() ? null : paramSearchStDate.replace("-", ""));
		paramMap.put("en_date", paramSearchEnDate==null || paramSearchEnDate.isEmpty() ? null : paramSearchEnDate.replace("-", ""));
		paramMap.put("spell_kor", paramSpellKor);
		paramMap.put("spell_en", paramSpellEn);

		addPageIndex(paramMap, pageNo, pageSize);
		List<BBSContentDTO> entities = bbsContentDao.list(paramMap);
		List<String> fileSeqs = new ArrayList<String>();

		for (BBSContentDTO bbsContentDTO : entities) {
			if (bbsContentDTO.getFile_grp_id() != null) {
				fileSeqs.add(bbsContentDTO.getFile_grp_id());
			}
		}
		if (fileSeqs.size() > 0) {
			List<AttachFileDTO> fileEntities = fileService.list(fileSeqs);
			for (BBSContentDTO bbsContentDTO : entities) {
				bbsContentDTO.setListFiles(new ArrayList<AttachFileDTO>());
				for (AttachFileDTO attachFileDTO : fileEntities) {
					if (bbsContentDTO.getFile_grp_id()!=null && bbsContentDTO.getFile_grp_id().equals(attachFileDTO.getFile_grp_id())) {
						bbsContentDTO.getListFiles().add(attachFileDTO);
					}
				}
				if (bbsContentDTO.getListFiles().size() == 1) {
					bbsContentDTO.setFileSeq(bbsContentDTO.getListFiles().get(0).getFile_seq());
				}
			}
		}

		return entities;
	}


	@Override
	public int createContent(BBSContentDTO paramBean, CommonParams paramCommon) {
		int rs=0;
		
		if(stringIsNullOrEmpty(paramBean.getBbs_cont()) || 
				stringIsNullOrEmpty(paramBean.getBbs_cont_title()) ||
				stringIsNullOrEmpty(paramBean.getBbs_id()) 
			//	|| paramCommon==null 
			//	|| stringIsNullOrEmpty(paramCommon.getLoginUserID())
				
				) {
			return rs;
		}
		
		paramBean.setCreate_user_id(paramCommon.getLoginUserID());
		paramBean.setUpdate_user_id(paramCommon.getLoginUserID());
		paramBean.setCreate_ip(paramCommon.getRequestIP());
		
		paramBean.setFixed_yn(paramBean.getFixed_yn()==null?"N":paramBean.getFixed_yn());
		paramBean.setSecret_yn(paramBean.getSecret_yn()==null?"N":paramBean.getSecret_yn());
		paramBean.setUse_yn("Y");
		
		
	
		
		if (paramBean.getBbs_parent()>0) {
			HashMap<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("bbs_id", paramBean.getBbs_id());
			paramMap.put("bbs_seq", paramBean.getBbs_parent());
			BBSContentDTO parentEntity = bbsContentDao.detail(paramMap);
			paramBean.setBbs_sort(parentEntity.getBbs_sort() - 1);

			int stNo = paramBean.getBbs_sort();
			int endNo = (paramBean.getBbs_sort()) / 1000 * 1000;
			paramBean.setBbs_group(parentEntity.getBbs_group());
			paramBean.setBbs_level(parentEntity.getBbs_level() + 1);
			paramMap.put("startNo", stNo);
			paramMap.put("endNo", endNo + 1);
			rs+=bbsContentDao.updateSortNoBBSContent(paramMap);
			rs+=bbsContentDao.create(paramBean);
		} else {
			HashMap<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("bbs_id", paramBean.getBbs_id());
			paramBean.setBbs_sort(maxSort(paramMap) + 1000);
			paramBean.setBbs_group(paramBean.getBbs_sort());
			paramBean.setBbs_level(0);
			paramBean.setBbs_parent(0);
			rs+=bbsContentDao.create(paramBean);
		}
		createHistory(paramBean, SysKeyword.CODE_BBSLOG_TARGE_CREATE);
		return rs;
	}

	@Override
	public BBSContentDTO createContent(BBSContentDTO paramBean, CommonParams paramCommon,List<MultipartFile> paramFiles) {
		
		String fileGrpID = "";
		if(paramBean.getFile_grp_id()!=null && !paramBean.getFile_grp_id().isEmpty()){			
			fileGrpID = fileService.create(paramFiles, fileProfilePath + paramBean.getBbs_id(),paramBean.getFile_grp_id());
			fileGrpID=paramBean.getFile_grp_id();
		}else{
			fileGrpID = fileService.create(paramFiles,paramCommon, fileProfilePath + paramBean.getBbs_id());
		}
		if (fileGrpID != null) {
			paramBean.setFile_grp_id(fileGrpID);
			
		}
		if(!(paramBean.getBbs_cont_title() == null || paramBean.getBbs_cont_title().isEmpty() || "".equals(paramBean.getBbs_cont_title()))){
			createContent(paramBean, paramCommon);
		}
		//createContent(paramBean, paramCommon);

		return paramBean;
	}

	@Override
	public BBSContentDTO createContent(BBSContentDTO paramBean, CommonParams paramCommon,List<MultipartFile> paramFiles,String paramFilePath) {
		paramBean.setCreate_user_id(paramCommon.getLoginUserID());
		String fileGrpID = fileService.create(paramFiles,paramCommon, paramFilePath + paramBean.getBbs_id());
		
		if (fileGrpID != null) {
			paramBean.setFile_grp_id(fileGrpID);
			
		}
		if(!(paramBean.getBbs_cont_title() == null || paramBean.getBbs_cont_title().isEmpty() || "".equals(paramBean.getBbs_cont_title()))){
			createContent(paramBean, paramCommon);
		}
		return paramBean;
	}
	
	@Override
	public int updateContent(BBSContentDTO paramBean, CommonParams paramCommon) {
		int rs = 0;
		
		BBSContentDTO bbsContentDTO=detailContent(paramBean.getBbs_id(), paramBean.getBbs_seq());
		bbsContentDTO.setFile_grp_id(paramBean.getFile_grp_id());
		bbsContentDTO.setCategory_seq(paramBean.getCategory_seq());
		bbsContentDTO.setBbs_cont(paramBean.getBbs_cont());
		bbsContentDTO.setBbs_cont_title(paramBean.getBbs_cont_title());
		bbsContentDTO.setFixed_yn(paramBean.getFixed_yn());
		bbsContentDTO.setUpdate_user_id(paramCommon.getLoginUserID());
		bbsContentDTO.setUpdate_user_ip(paramCommon.getRequestIP());
	
		rs = bbsContentDao.update(bbsContentDTO);
		createHistory(paramBean, SysKeyword.CODE_BBSLOG_TARGE_UPDATE);
		return rs;
	}

	@Override
	public int updateContent(BBSContentDTO paramBean, CommonParams paramCommon, List<MultipartFile> paramFiles) {
		int rs = 0;
		String fileGrpID = null;
		BBSContentDTO bbsContentDTO = detailContent(paramBean.getBbs_id(), paramBean.getBbs_seq());
		if (bbsContentDTO.getFile_grp_id() != null && !bbsContentDTO.getFile_grp_id().isEmpty())
			fileGrpID = fileService.create(paramFiles, fileProfilePath + paramBean.getBbs_id(),
					bbsContentDTO.getFile_grp_id());
		else
			fileGrpID = fileService.create(paramFiles,paramCommon, fileProfilePath + paramBean.getBbs_id());

		paramBean.setFile_grp_id(fileGrpID);
		paramBean.setCreate_user_id(paramCommon.getLoginUserID());
		paramBean.setUpdate_user_id(paramCommon.getLoginUserID());
		rs = bbsContentDao.update(paramBean);
		createHistory(paramBean, SysKeyword.CODE_BBSLOG_TARGE_UPDATE);
		return rs;
	}
	@Override
	public int updateBBSContent(BBSContentDTO paramBean,CommonParams paramCommon, List<MultipartFile> paramFiles) {
		
		int rs = 0;
		String fileGrpID = null;
		
		if(paramBean.getFile_grp_id()!=null && !paramBean.getFile_grp_id().equals("")){			
			fileGrpID = fileService.create(paramFiles, fileProfilePath + paramBean.getBbs_id(),paramBean.getFile_grp_id());
			fileGrpID=paramBean.getFile_grp_id();
		}else{
			fileGrpID = fileService.create(paramFiles,paramCommon, fileProfilePath + paramBean.getBbs_id());
		}
		
		if (fileGrpID != null && !fileGrpID.equals("")) {
			paramBean.setFile_grp_id(fileGrpID);
		}
		
		if(paramBean.getFile_grp_id_now()!=null && !paramBean.getFile_grp_id_now().equals("")){//????????? ????????? ???????????? tb_attach ??? ????????? ??????????????? ?????? ???????????? ??????
			fileService.updateFileGrp(paramBean.getFile_grp_id_now(),fileGrpID);
		}
		
		/*BBSContentDTO bbsContentDTO = detailContent(paramBean.getBbs_id(), paramBean.getBbs_seq());
		if (paramFiles != null && !paramFiles.isEmpty())
			fileGrpID = fileService.create(paramFiles, fileProfilePath + paramBean.getBbs_id(),
					bbsContentDTO.getFile_grp_id());
		else
			fileGrpID = fileService.create(paramFiles, fileProfilePath + paramBean.getBbs_id());*/

		if(paramBean.getFixed_yn()==null){
			paramBean.setFixed_yn("N");
		}
		if(paramBean.getSecret_yn()==null){
			paramBean.setSecret_yn("N");
		}
		
		paramBean.setCreate_user_id(paramCommon.getLoginUserID());
		paramBean.setUpdate_user_id(paramCommon.getLoginUserID());
		rs = bbsContentDao.update(paramBean);
		createHistory(paramBean, SysKeyword.CODE_BBSLOG_TARGE_UPDATE);
		return rs;
	}
	@Override
	public int updateFile(String paramBBSID, int paramSeq) {
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("bbs_id", paramBBSID);
		paramMap.put("bbs_seq", paramSeq);
		
		return bbsContentDao.updateFile(paramMap);
	}
	@Override
	public int maxSort(HashMap<String, Object> paramMap) {

		return bbsContentDao.maxSort(paramMap);
	}

	@Override
	public int totalCountBBSContent(String paramBBSID, String paraCatSeq, String paramSearchTitle,
			String paramSearchContent, String paramSearchName, String paramStDate, String paramEnDate,
			String paramSpellKor, String paramSpellEn) {
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("bbs_id", paramBBSID);
		paramMap.put("bbs_cont_title", paramSearchTitle);
		paramMap.put("bbs_cont", paramSearchContent);
		paramMap.put("user_name", paramSearchName);
		paramMap.put("category_seq",paraCatSeq==null|| paraCatSeq.isEmpty() ? -1 : Integer.parseInt(paraCatSeq));
		paramMap.put("st_date",paramStDate==null|| paramStDate.isEmpty() ? null : paramStDate.replace("-", ""));
		paramMap.put("en_date",paramEnDate==null|| paramEnDate.isEmpty() ? null : paramEnDate.replace("-", ""));
		paramMap.put("spell_kor", paramSpellKor);
		paramMap.put("spell_en", paramSpellEn);
		return bbsContentDao.totalCount(paramMap);
	}

	@Override
	public BBSMasterDTO detailMaster(String paramBBSID) {
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("bbs_id", paramBBSID);
		
		BBSMasterDTO paramBean=bbsMasterDao.detail(paramMap);
		paramBean.setListCate(bbsMasterDao.listCategory(paramMap));
		//paramBean.setBbs_info_html(paramBean.getBbs_info_html().replace("&lt;","<").replace("&gt;", ">"));
		return paramBean;
	}

	@Override
	public List<BBSCategoryDTO> listCategory(String paramBBSID) {
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("bbs_id", paramBBSID);
		return bbsMasterDao.listCategory(paramMap);
	}

	                                                                                                         
	
	@Override
	public BBSContentDTO detailContent(String paramBBSID, int paramBBSSeq) {
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("bbs_id", paramBBSID);
		paramMap.put("bbs_seq", paramBBSSeq);
		BBSContentDTO entity = bbsContentDao.detail(paramMap);

		List<String> fileSeqs = new ArrayList<String>();
		if (entity.getFile_grp_id() != null && !entity.getFile_grp_id().isEmpty()) {
			fileSeqs.add(entity.getFile_grp_id());
			if (fileSeqs.size() > 0) {
				List<AttachFileDTO> fileEntities = fileService.list(fileSeqs);
				for (AttachFileDTO attachFileDTO : fileEntities) {
					attachFileDTO.setFile_path(null);
					attachFileDTO.setFile_new_name(null);
					
				}
				entity.setListFiles(fileEntities);
				if (entity.getListFiles().size() == 1) {
					entity.setFileSeq(entity.getListFiles().get(0).getFile_seq());
				}
			}
		}
		int rowCnt = createHistory(entity, SysKeyword.CODE_BBSLOG_TARGE_READ);
		if (rowCnt > 0) {
			entity.setBbs_read(entity.getBbs_read() + 1);
			bbsContentDao.update(entity);
		}

		return entity;
	}
	
	@Override
	public BBSContentDTO detailContent(String paramBBSID,int paramBBSSeq,CommonParams paramCommons){
		BBSMasterDTO master=detailMaster(paramBBSID);
		
		BBSContentDTO rs=detailContent(paramBBSID,paramBBSSeq);
		
		

		if(master.getRead_role_id()!=null){
			String[] readRoles=master.getRead_role_id().split(",");
			if(paramCommons!=null){
				String[] userRoles=paramCommons.getUserRole().split(",");
				
				for(int i=0;i<readRoles.length;i++){
					boolean isReadAble=false;
					for(int k=0;k<userRoles.length;k++){
						if(readRoles[i].equals(userRoles[k])){
							isReadAble=true;
							break;
						}
					}	
					
					rs.setRead_yn(isReadAble?"Y":"N");
					if(isReadAble) break;
				}
				
			}
		}
		if(master.getWrite_role_id()!=null){
			String[] writeRoles=master.getWrite_role_id().split(",");
			if(paramCommons!=null && paramCommons.getUserRole()!=null){
				
				String[] userRoles=paramCommons.getUserRole().split(",");
				
				for(int i=0;i<writeRoles.length;i++){
					boolean isReadAble=false;
					for(int k=0;k<userRoles.length;k++){
						if(writeRoles[i].equals(userRoles[k])){
							isReadAble=true;
							break;
						}
					}	
					
					rs.setEdit_yn(isReadAble?"Y":"N");
					if(isReadAble) break;
				}
				
			}else{
				rs.setEdit_yn("N");
			}
		}
				
		if(paramCommons!=null && rs.getCreate_user_id().equals(paramCommons.getLoginUserID())){
			rs.setEdit_yn("Y");
		}
		rs.setListComment(listComment(rs.getBbs_seq()));
		
		return rs;
	}
	
	
	@Override
	public int deleteContent(String paramBBSID, int paramBBSSeq, CommonParams paramCommon) {
		int rs = 0;
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("bbs_id", paramBBSID);
		paramMap.put("bbs_seq", paramBBSSeq);
		paramMap.put("create_user_id", paramCommon.getLoginUserID());
		paramMap.put("update_user_id", paramCommon.getLoginUserID());
		rs = bbsContentDao.delete(paramMap);
		BBSContentDTO log = new BBSContentDTO();
		log.setBbs_seq(paramBBSSeq);
		log.setCreate_user_id(paramCommon.getLoginUserID());
		createHistory(log, SysKeyword.CODE_BBSLOG_TARGE_DELETE);
		return rs;
	}

	@Override
	public List<BBSLogDTO> listHistory(int paramBBSSeq, String paramUserID) {
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("bbs_seq", paramBBSSeq);
		paramMap.put("create_user_id", paramUserID);

		return bbsLogDao.list(paramMap);
	}
          
	@Override
	public BBSLogDTO detailHistory(int paramBBSSeq, String paramUserID, String paramTargetCode) {
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("bbs_seq", paramBBSSeq);
		paramMap.put("create_user_id", paramUserID);
		paramMap.put("log_target_code", paramTargetCode);
		return bbsLogDao.detail(paramMap);
	}

	@Override
	public int createHistory(BBSContentDTO paramBean, String paramLogType) {
		int rs = 0;
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("create_user_id", paramBean.getCreate_user_id());
		paramMap.put("bbs_seq", paramBean.getBbs_seq());
		paramMap.put("log_target_code", paramLogType);
		BBSLogDTO logEntity = bbsLogDao.detail(paramMap);
		if (logEntity == null) {
			logEntity = new BBSLogDTO();
			logEntity.setBbs_seq(paramBean.getBbs_seq());
			logEntity.setCreate_user_id(paramBean.getCreate_user_id());
			logEntity.setLog_target_code(paramLogType);
			rs = bbsLogDao.create(logEntity);
		}
		return rs;
	}

		

	@Override
	public List<BBSMasterDTO> listMaster() {
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		List<BBSMasterDTO> rs=bbsMasterDao.list(paramMap);
		List<BBSCategoryDTO>  listCategories=listCategory(null);
		for (BBSMasterDTO bbsMasterDTO : rs) {
			List<BBSCategoryDTO> listTemp=new ArrayList<BBSCategoryDTO>();
			for (BBSCategoryDTO bbsCategoryDTO : listCategories) {
				if(bbsMasterDTO.getBbs_id().equals(bbsCategoryDTO.getBbs_id())) {
					if(!stringIsNullOrEmpty(bbsCategoryDTO.getCategory_title())){
						listTemp.add(bbsCategoryDTO);
					}
				}
			}
			if(listTemp.size()>0) {
				bbsMasterDTO.setListCate(listTemp);
			}
		}
		return bbsMasterDao.list(paramMap);
	}

	@Override
	public int createMaster(BBSMasterDTO paramBean) {
		
		paramBean.setUse_yn(paramBean.getUse_yn()==null?"Y":paramBean.getUse_yn());
		paramBean.setBbs_pub_yn(paramBean.getBbs_pub_yn()==null?"Y":paramBean.getBbs_pub_yn());
		
		if(paramBean.getBbs_id()==null || paramBean.getBbs_id().isEmpty()) return MessageStatus.VALID_REQUIRED.value();
		else if(paramBean.getBbs_title()==null || paramBean.getBbs_title().isEmpty()) return MessageStatus.VALID_REQUIRED.value();
		
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("bbs_id", paramBean.getBbs_id());
		BBSMasterDTO dto = bbsMasterDao.detail(paramMap);
		
		if(dto != null && paramBean.getBbs_id().equals(dto.getBbs_id())) return MessageStatus.KEY_DUPLICATED.value();
		if(paramBean.getListCate()!=null){
			for (int i = 0; i < paramBean.getListCate().size(); i++) {
				BBSCategoryDTO temp = new BBSCategoryDTO();
				temp.setBbs_id(paramBean.getBbs_id());
				temp.setCategory_title(paramBean.getListCate().get(i).getCategory_title());
				bbsMasterDao.createCategory(temp);
			}
		}
		return bbsMasterDao.create(paramBean);		
	}

	//@Transactional
	@Override
	public int createMaster(BBSMasterDTO paramBean, String[] paramCategoies) {
		if(paramBean.getBbs_id()==null || paramBean.getBbs_id().isEmpty()) return MessageStatus.VALID_REQUIRED.value();
		else if(paramBean.getBbs_title()==null || paramBean.getBbs_title().isEmpty()) return MessageStatus.VALID_REQUIRED.value();
		
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("bbs_id", paramBean.getBbs_id());
		BBSMasterDTO dto = bbsMasterDao.detail(paramMap);
		
		if(dto != null && paramBean.getBbs_id().equals(dto.getBbs_id())) return MessageStatus.KEY_DUPLICATED.value();
		if (paramCategoies != null) {
			for (int i = 0; i < paramCategoies.length; i++) {
				if(paramCategoies[i]!=null && paramCategoies[i]!=""){
				BBSCategoryDTO temp = new BBSCategoryDTO();
				temp.setBbs_id(paramBean.getBbs_id());
				temp.setCategory_title(paramCategoies[i]);
				bbsMasterDao.createCategory(temp);
				}
			}
		}
		
		
		paramBean.setUse_yn(paramBean.getUse_yn()==null?"Y":paramBean.getUse_yn());
		paramBean.setBbs_pub_yn(paramBean.getBbs_pub_yn()==null?"Y":paramBean.getBbs_pub_yn());
		return bbsMasterDao.create(paramBean);
	}
	
	@Override
	public int updateMaster(BBSMasterDTO paramBean,CommonParams common) {
		int rs=0;
		paramBean.setUpdate_user_id(common.getLoginUserID());
		if(paramBean.getBbs_title() == null || paramBean.getBbs_title().isEmpty()){
			return MessageStatus.VALID_REQUIRED.value();
		}else{
			rs+=bbsMasterDao.update(paramBean);
			HashMap<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("bbs_id",paramBean.getBbs_id());
			bbsMasterDao.dropCategory(paramMap);			
			if(paramBean.getListCate()!=null){
				for (int i = 0; i < paramBean.getListCate().size(); i++) {
					BBSCategoryDTO temp = new BBSCategoryDTO();
					temp.setBbs_id(paramBean.getBbs_id());
					temp.setCategory_title(paramBean.getListCate().get(i).getCategory_title());
					bbsMasterDao.createCategory(temp);
				}
			}
			return rs;
		}
	}

	//@Transactional
	@Override
	public int updateMaster(BBSMasterDTO paramBean, String[] paramCategoies,CommonParams common) {
		
	
		
		int rs=0;
		paramBean.setUpdate_user_id(common.getLoginUserID());
		if(paramBean.getBbs_title() == null || paramBean.getBbs_title().isEmpty()){
			return MessageStatus.VALID_REQUIRED.value();
		}else{
			rs+=bbsMasterDao.update(paramBean);
			HashMap<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("bbs_id",paramBean.getBbs_id());
			bbsMasterDao.dropCategory(paramMap);
			if (paramCategoies != null) {
				for (String title : paramCategoies) {
					if(title.isEmpty()) break;
					BBSCategoryDTO bbsCategoryDto=new BBSCategoryDTO();
					bbsCategoryDto.setBbs_id(paramBean.getBbs_id());
					bbsCategoryDto.setCategory_title(title);
					
					bbsMasterDao.createCategory(bbsCategoryDto);
				}
			}
			return rs;
		}
	}


	@Override
	public List<BBSContentDTO> listRecentContent(String paramBBSID, int pageNo,int pageSize) {
		HashMap<String, Object> paramMap=new HashMap<String, Object>();
		paramMap.put("bbs_id", paramBBSID);
		addPageIndex(paramMap, pageNo, pageSize);
		return bbsContentDao.listRecent(paramMap);
	}


	@Override
	public BBSMasterDTO detailMaster(String paramBBSID, CommonParams paramCommon) {
		boolean enable=false;
		BBSMasterDTO bbsMasterDTO=detailMaster(paramBBSID);
		if(bbsMasterDTO.getRead_role_id() !=null && !bbsMasterDTO.getRead_role_id().isEmpty() ){
			if(paramCommon!=null && paramCommon.getUserRole()!=null){
				String[] bbsReadRoles=bbsMasterDTO.getRead_role_id().split(",");
				String[] usrRoles=paramCommon.getUserRole().split(",");
				for (String bbsRole : bbsReadRoles) {
					for (String userRole : usrRoles) {
						if(bbsRole.equals(userRole)){
							enable=true;
							break;
						}
					}
					if(enable) break;
				}
			}
		}else{
			enable=true;
		}
		if(enable){
			bbsMasterDTO.setEnableReadYN("Y");
			bbsMasterDTO.setEnableWriteYN(checkWriteRole(bbsMasterDTO,paramCommon)?"Y":"N");	
		}
		else{
			bbsMasterDTO=new BBSMasterDTO();
			bbsMasterDTO.setEnableReadYN("N");
			
		}
	
		return bbsMasterDTO;
	}


	private boolean checkWriteRole(BBSMasterDTO bbsMasterDTO,CommonParams paramCommon)
	{
		boolean rs=false;
		if(bbsMasterDTO.getWrite_role_id() !=null){
			if(paramCommon!=null && paramCommon.getUserRole()!=null){
				String[] bbsWriteRoles=bbsMasterDTO.getWrite_role_id().split(",");
				String[] usrRoles=paramCommon.getUserRole().split(",");
				for (String bbsRole : bbsWriteRoles) {
					for (String userRole : usrRoles) {
						if(bbsRole.equals(userRole)){
							rs=true;
							break;
						}
					}
					if(rs) break;
				}
			}
		}else{
			rs=true;
		}
		return rs;
	}


	@Override
	public BBSContentDTO createReply(BBSContentDTO paramBean, CommonParams paramCommon,List<MultipartFile> paramFiles) {
		
		String fileGrpID = "";
		if(paramBean.getFile_grp_id()!=null && !paramBean.getFile_grp_id().equals("")){			
			fileGrpID = fileService.create(paramFiles, fileProfilePath + paramBean.getBbs_id(),paramBean.getFile_grp_id());
			fileGrpID=paramBean.getFile_grp_id();
		}else{
			if(paramFiles!=null) fileGrpID = fileService.create(paramFiles,paramCommon, fileProfilePath + paramBean.getBbs_id());
		}
		if (fileGrpID != null && !fileGrpID.equals("")) {
			paramBean.setFile_grp_id(fileGrpID);
			
		}
		if(!(paramBean.getBbs_cont_title() == null || paramBean.getBbs_cont_title().isEmpty() || "".equals(paramBean.getBbs_cont_title()))){
			createReplyContent(paramBean, paramCommon);
		}
		//createContent(paramBean, paramCommon);

		return paramBean;
	}

	@Override
	public BBSContentDTO createReplyContent(BBSContentDTO paramBean, CommonParams paramCommon) {
		int rs = 0;
		//paramBean.setCreate_user_id(paramCommon.getLoginUserID());
		paramBean.setUpdate_user_id(paramCommon.getLoginUserID());
		paramBean.setCreate_ip(paramCommon.getRequestIP());
		
		paramBean.setFixed_yn(paramBean.getFixed_yn()==null?"N":paramBean.getFixed_yn());
		paramBean.setSecret_yn(paramBean.getSecret_yn()==null?"N":paramBean.getSecret_yn());
		paramBean.setMail_yn(paramBean.getMail_yn()==null?"N":paramBean.getMail_yn());
		paramBean.setUse_yn("Y");

		if (paramBean.getBbs_parent()>0) {
			HashMap<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("bbs_id", paramBean.getBbs_id());
			paramMap.put("bbs_seq", paramBean.getBbs_parent());
			BBSContentDTO parentEntity = bbsContentDao.detail(paramMap);
			paramBean.setBbs_sort(parentEntity.getBbs_sort() - 1);
			paramBean.setCreate_user_id(parentEntity.getCreate_user_id());
			int stNo = paramBean.getBbs_sort();
			int endNo = (paramBean.getBbs_sort()) / 1000 * 1000;
			paramBean.setBbs_group(parentEntity.getBbs_group());
			paramBean.setBbs_level(parentEntity.getBbs_level() + 1);
			paramMap.put("startNo", stNo);
			paramMap.put("endNo", endNo + 1);
			bbsContentDao.updateSortNoBBSContent(paramMap);
			rs = bbsContentDao.create(paramBean);
		}
		createHistory(paramBean, SysKeyword.CODE_BBSLOG_TARGE_CREATE);
		
		return paramBean;
	}
	
	@Override
	public int createComment(BBSCommentDto paramBean,CommonParams paramCommon) {
		int rs=0;
		
		if(stringIsNullOrEmpty(paramBean.getCmmt_content())){
			return rs;
		}
		paramBean.setCreate_user_id(paramCommon.getLoginUserID());
		paramBean.setUpdate_user_id(paramCommon.getLoginUserID());
		paramBean.setCreate_user_ip(paramCommon.getRequestIP());
		paramBean.setUpdate_user_ip(paramCommon.getRequestIP());
		rs=bbsCommentDao.create(paramBean);
		return rs;
		
	}


	@Override
	public int deleteComment(int paramSeq,CommonParams paramCommon) {
		int rs=0;
		HashMap<String,Object> paramMap=new HashMap<String, Object>();
		paramMap.put("seq",paramSeq);
		paramMap.put("update_user_id",paramCommon.getLoginUserID());
		paramMap.put("update_user_ip",paramCommon.getRequestIP());
		
		rs=bbsCommentDao.drop(paramMap);
		return rs;
	}


	@Override
	public int updateComment(BBSCommentDto paramBean, CommonParams paramCommon) {
		int rs=0;
		if(stringIsNullOrEmpty(paramBean.getCmmt_content())){
			return rs;
		}
		paramBean.setUpdate_user_id(paramCommon.getLoginUserID());
		paramBean.setUpdate_user_ip(paramCommon.getRequestIP());
		
		rs=bbsCommentDao.update(paramBean);
		return rs;
	}


	@Override
	public List<BBSCommentDto> listComment(int paramBbsSeq) {
		List<BBSCommentDto> rs=null;
		if(paramBbsSeq<=0) return rs;
		HashMap<String,Object> paramMap=new HashMap<String, Object>();
		paramMap.put("bbs_seq",paramBbsSeq);
		rs=bbsCommentDao.list(paramMap);
		
		
		return rs;
	}

}
