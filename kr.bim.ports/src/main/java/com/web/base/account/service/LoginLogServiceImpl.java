package com.web.base.account.service;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.base.BaseService;
import com.web.base.BaseSysKeyword;
import com.web.base.CommonParams;
import com.web.base.MessageStatus;
import com.web.base.account.dao.ILoginLogDao;
import com.web.base.account.dao.IRoleDao;
import com.web.base.account.dao.IUserDao;
import com.web.base.account.dao.LoginLogDTO;
import com.web.base.account.dao.RoleDTO;
import com.web.base.account.dao.UserDTO;
import com.web.base.bbs.dao.BBSUserDTO;
import com.web.base.bbs.dao.BBSUserRoleDTO;
import com.web.base.bbs.dao.IBBSUserDao;
import com.web.base.bbs.service.IBBSService;
import com.web.base.code.dao.CodeGrpDTO;
import com.web.base.code.dao.CodeSysDTO;
import com.web.base.code.dao.ICodeSysDao;
import com.web.base.global.MessageKeyword;
import com.web.base.global.SysKeyword;
import com.web.base.menu.dao.IMenuDao;
import com.web.base.menu.dao.MenuDTO;
import com.web.base.utils.AES256Cipher;
import com.web.base.utils.DateHelper;
import com.web.base.utils.Encryption;

import egovframework.let.uss.umt.service.EgovMberManageService;

@Service("loginLogService")
public class LoginLogServiceImpl extends BaseService implements ILoginLogService {
	
	@Autowired
	private ILoginLogDao loginLogDao;

	@Override
	public int listLoginLog(String paramDateS, String paramDataE,String userId) {
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("startDate", paramDateS);
		paramMap.put("endDate", paramDataE);
		paramMap.put("userId", userId);
		return loginLogDao.count(paramMap);
	}

	@Override
	public int count(String paramDateS, String paramDataE,String userId, String userName) {
		paramDateS=paramDateS ==null ? DateHelper.getFirstDayYYYYMMDD():paramDateS;
		paramDataE=paramDataE ==null ? DateHelper.getCurrentYYYYMMDD():paramDataE;
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("startDate", paramDateS.replace("/","").replace("-",""));
		paramMap.put("endDate", paramDataE.replace("/","").replace("-",""));
		paramMap.put("userId", userId);
		paramMap.put("userName", userName);
		return loginLogDao.count(paramMap);
	}
	@Override
	public int totalCount(String paramDateS, String paramDataE,String userId, String userName) {
		paramDateS=paramDateS ==null ? DateHelper.getFirstDayYYYYMMDD():paramDateS;
		paramDataE=paramDataE ==null ? DateHelper.getCurrentYYYYMMDD():paramDataE;
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("startDate", paramDateS.replace("/","").replace("-",""));
		paramMap.put("endDate", paramDataE.replace("/","").replace("-",""));
		paramMap.put("userId", userId);
		paramMap.put("userName", userName);
		return loginLogDao.totalCount(paramMap);
	}
	@Override
	public List<LoginLogDTO> list(String paramDateS, String paramDataE,String userId, String userName, int pageNo, int pageSize) {
		paramDateS=paramDateS ==null ? DateHelper.getFirstDayYYYYMMDD():paramDateS;
		paramDataE=paramDataE ==null ? DateHelper.getCurrentYYYYMMDD():paramDataE;
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("startDate", paramDateS.replace("/","").replace("-",""));
		paramMap.put("endDate", paramDataE.replace("/","").replace("-",""));
		paramMap.put("userId", userId);
		paramMap.put("userName", userName);
		addPageIndex(paramMap, pageNo, pageSize);
		return loginLogDao.list(paramMap);
	}
	@Override
	public List<LoginLogDTO> list(String paramDateS, String paramDataE,String userId, int pageNo, int pageSize) {
		paramDateS=paramDateS ==null ? DateHelper.getFirstDayYYYYMMDD():paramDateS;
		paramDataE=paramDataE ==null ? DateHelper.getCurrentYYYYMMDD():paramDataE;
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("startDate", paramDateS.replace("/","").replace("-",""));
		paramMap.put("endDate", paramDataE.replace("/","").replace("-",""));
		paramMap.put("userId", userId);
		addPageIndex(paramMap, pageNo, pageSize);
		return loginLogDao.list(paramMap);
	}
	@Override
	public List<LoginLogDTO> detail(String paramDateS,String paramDataE) {
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("startDate", paramDateS.replace("/","").replace("-",""));
		paramMap.put("endDate", paramDataE.replace("/","").replace("-",""));
		return loginLogDao.detail(paramMap);
	}

	@Override
	public LoginLogDTO curTime() {
		return loginLogDao.curTime();
	}
	@Override
	public int detailTotalCount(String paramDateS, String paramDataE,String userId, String userName) {
		paramDateS=paramDateS ==null ? DateHelper.getFirstDayYYYYMMDD():paramDateS;
		paramDataE=paramDataE ==null ? DateHelper.getCurrentYYYYMMDD():paramDataE;
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("startDate", paramDateS.replace("/","").replace("-",""));
		paramMap.put("endDate", paramDataE.replace("/","").replace("-",""));
		paramMap.put("userId", userId);
		paramMap.put("userName", userName);
		return loginLogDao.detailTotalCount(paramMap);
	}
	@Override
	public List<LoginLogDTO> detail(String paramDateS, String paramDataE,String paramUserId, int pageNo, int pageSize) {
		paramDateS=paramDateS ==null ? DateHelper.getFirstDayYYYYMMDD():paramDateS;
		paramDataE=paramDataE ==null ? DateHelper.getCurrentYYYYMMDD():paramDataE;
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("startDate", paramDateS.replace("/","").replace("-",""));
		paramMap.put("endDate", paramDataE.replace("/","").replace("-",""));
		paramMap.put("userId", paramUserId);
		addPageIndex(paramMap, pageNo, pageSize);
		List<LoginLogDTO> result = loginLogDao.detail(paramMap);
		return result;
	}

	@Override
	public List<LoginLogDTO> detail(String paramDateS, String paramDataE,String paramUserId) {
		paramDateS=paramDateS ==null ? DateHelper.getFirstDayYYYYMMDD():paramDateS;
		paramDataE=paramDataE ==null ? DateHelper.getCurrentYYYYMMDD():paramDataE;
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("startDate", paramDateS.replace("/","").replace("-",""));
		paramMap.put("endDate", paramDataE.replace("/","").replace("-",""));
		paramMap.put("userId", paramUserId);
		List<LoginLogDTO> result = loginLogDao.detail(paramMap);
		return result;
	}

	@Override
	public int detailConnTotalCount(String paramDateS, String paramDataE,String paramUserId) {
		paramDateS=paramDateS ==null ? DateHelper.getFirstDayYYYYMMDD():paramDateS;
		paramDataE=paramDataE ==null ? DateHelper.getCurrentYYYYMMDD():paramDataE;
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("startDate", paramDateS.replace("/","").replace("-",""));
		paramMap.put("endDate", paramDataE.replace("/","").replace("-",""));
		paramMap.put("userId", paramUserId);
		return loginLogDao.detailConnTotalCount(paramMap);
	}

	

}
