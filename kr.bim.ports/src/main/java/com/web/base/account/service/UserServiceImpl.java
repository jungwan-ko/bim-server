package com.web.base.account.service;

import java.util.Arrays;
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
import com.web.base.utils.Encryption;

import egovframework.let.uss.umt.service.EgovMberManageService;

@Service("userService")
public class UserServiceImpl extends BaseService implements IUserService {
	
	@Autowired
	private IUserDao userDao;

	@Override
	public int totalCount(String paramUsrId, String paramUserName,String paramTypeCode, String paramStatusCode,String paramStDate,String paramEnDate) {
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("userId", paramUsrId);
		paramMap.put("userName", paramUserName);
		paramMap.put("typeCode", paramTypeCode);
		paramMap.put("statusCode", paramStatusCode);
		paramMap.put("stDate", paramStDate);
		paramMap.put("enDate", paramEnDate);
		return userDao.totalCount(paramMap);
	}
	

}
