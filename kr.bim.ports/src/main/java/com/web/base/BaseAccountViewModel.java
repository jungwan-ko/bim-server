package com.web.base;

import java.util.List;

import com.web.base.account.dao.RoleDTO;
import com.web.base.account.dao.UserDTO;

import egovframework.com.cmm.LoginVO;

public class BaseAccountViewModel extends BaseViewModel{
	private String paramUserID;
	private String paramPwd;
	private String paramOldPwd;
	private String paramEmail;
	private String paramPhone;
	private String paramUserType;
	private String paramUserStatus;
	private String paramAdmCode;
	private String paramOption;
	private String paramText;
	private UserDTO detailUser;
	private String paramStartDate;
	private String paramEndDate;
	private List<UserDTO> list;
	private List<RoleDTO> listRoles;
	private String returnURI;
	private String loginView;
	private String defaultView;
	
	//---[egov]
	private LoginVO loginInfo;
	//[egove]

	public String getParamUserID() {
		return paramUserID;
	}

	public void setParamUserID(String paramUserID) {
		this.paramUserID = paramUserID;
	}

	public String getParamPwd() {
		return paramPwd;
	}

	public void setParamPwd(String paramPwd) {
		this.paramPwd = paramPwd;
	}

	public String getParamOldPwd() {
		return paramOldPwd;
	}

	public void setParamOldPwd(String paramOldPwd) {
		this.paramOldPwd = paramOldPwd;
	}

	public String getParamEmail() {
		return paramEmail;
	}

	public void setParamEmail(String paramEmail) {
		this.paramEmail = paramEmail;
	}

	public String getParamPhone() {
		return paramPhone;
	}

	public void setParamPhone(String paramPhone) {
		this.paramPhone = paramPhone;
	}

	public String getParamUserType() {
		return paramUserType;
	}

	public void setParamUserType(String paramUserType) {
		this.paramUserType = paramUserType;
	}

	public String getParamUserStatus() {
		return paramUserStatus;
	}

	public void setParamUserStatus(String paramUserStatus) {
		this.paramUserStatus = paramUserStatus;
	}

	public String getParamAdmCode() {
		return paramAdmCode;
	}

	public void setParamAdmCode(String paramAdmCode) {
		this.paramAdmCode = paramAdmCode;
	}

	public String getParamOption() {
		return paramOption;
	}

	public void setParamOption(String paramOption) {
		this.paramOption = paramOption;
	}

	public String getParamText() {
		return paramText;
	}

	public void setParamText(String paramText) {
		this.paramText = paramText;
	}

	public UserDTO getDetailUser() {
		return detailUser;
	}

	public void setDetailUser(UserDTO detailUser) {
		this.detailUser = detailUser;
	}

	public String getParamStartDate() {
		return paramStartDate;
	}

	public void setParamStartDate(String paramStartDate) {
		this.paramStartDate = paramStartDate;
	}

	public String getParamEndDate() {
		return paramEndDate;
	}

	public void setParamEndDate(String paramEndDate) {
		this.paramEndDate = paramEndDate;
	}

	public List<UserDTO> getList() {
		return list;
	}

	public void setList(List<UserDTO> list) {
		this.list = list;
	}

	public List<RoleDTO> getListRoles() {
		return listRoles;
	}

	public void setListRoles(List<RoleDTO> listRoles) {
		this.listRoles = listRoles;
	}

	public String getReturnURI() {
		return returnURI;
	}

	public void setReturnURI(String returnURI) {
		this.returnURI = returnURI;
	}

	public String getLoginView() {
		return loginView;
	}

	public void setLoginView(String loginView) {
		this.loginView = loginView;
	}

	public String getDefaultView() {
		return defaultView;
	}

	public void setDefaultView(String defaultView) {
		this.defaultView = defaultView;
	}

	public LoginVO getLoginInfo() {
		return loginInfo;
	}

	public void setLoginInfo(LoginVO loginInfo) {
		this.loginInfo = loginInfo;
	}
	
	
}
