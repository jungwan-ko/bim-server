package com.web.base.admin.viewmodel;

import java.util.List;

import com.web.base.BaseViewModel;
import com.web.base.account.dao.RoleDTO;
import com.web.base.menu.dao.MenuDTO;
import com.web.base.menu.dao.MenuLogDTO;
import com.web.base.menu.dao.MenuRoleDTO;

public class AdminMenuViewModel extends BaseViewModel {
	private List<MenuDTO> listMenu;
	private MenuDTO detailMenu;
	private List<RoleDTO> listRole;
	private List<MenuLogDTO> listMenuLog;
	
	private String paramMenuID;
	private String paramRoles;
	private String paramWriteRoles;
	private int paramDurMils;
	

	public String getParamWriteRoles() {
		return paramWriteRoles;
	}
	public void setParamWriteRoles(String paramWriteRoles) {
		this.paramWriteRoles = paramWriteRoles;
	}
	public List<MenuLogDTO> getListMenuLog() {
		return listMenuLog;
	}
	public void setListMenuLog(List<MenuLogDTO> listMenuLog) {
		this.listMenuLog = listMenuLog;
	}
	public int getParamDurMils() {
		return paramDurMils;
	}
	public void setParamDurMils(int paramDurMils) {
		this.paramDurMils = paramDurMils;
	}
	public String getParamRoles() {
		return paramRoles;
	}
	public void setParamRoles(String paramRoles) {
		this.paramRoles = paramRoles;
	}
	public String getParamMenuID() {
		return paramMenuID;
	}
	public void setParamMenuID(String paramMenuID) {
		this.paramMenuID = paramMenuID;
	}
	public List<RoleDTO> getListRole() {
		return listRole;
	}
	public void setListRole(List<RoleDTO> listRole) {
		this.listRole = listRole;
	}
	public List<MenuDTO> getListMenu() {
		return listMenu;
	}
	public void setListMenu(List<MenuDTO> listMenu) {
		this.listMenu = listMenu;
	}
	public MenuDTO getDetailMenu() {
		return detailMenu;
	}
	public void setDetailMenu(MenuDTO detailMenu) {
		this.detailMenu = detailMenu;
	}
	
	
	
}
