package com.web.base;

import java.util.List;

import com.web.base.account.dao.UserDTO;
import com.web.base.bbs.dao.BBSContentDTO;
import com.web.base.menu.dao.MenuLogDTO;

public class AdminViewModel extends BaseViewModel {
	private UserDTO detailUser;
	private List<MenuLogDTO> listMenuLog;
	private List<MenuLogDTO> listVisitMenuLog;
	private List<BBSContentDTO> listBbsContent;
	private String paramStartDate;
	private String paramEndDate;
	
	
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

	public List<BBSContentDTO> getListBbsContent() {
		return listBbsContent;
	}

	public void setListBbsContent(List<BBSContentDTO> listBbsContent) {
		this.listBbsContent = listBbsContent;
	}

	public List<MenuLogDTO> getListVisitMenuLog() {
		return listVisitMenuLog;
	}

	public void setListVisitMenuLog(List<MenuLogDTO> listVisitMenuLog) {
		this.listVisitMenuLog = listVisitMenuLog;
	}

	public List<MenuLogDTO> getListMenuLog() {
		return listMenuLog;
	}

	public void setListMenuLog(List<MenuLogDTO> listMenuLog) {
		this.listMenuLog = listMenuLog;
	}

	public UserDTO getDetailUser() {
		return detailUser;
	}

	public void setDetailUser(UserDTO detailUser) {
		this.detailUser = detailUser;
	}
	
}
