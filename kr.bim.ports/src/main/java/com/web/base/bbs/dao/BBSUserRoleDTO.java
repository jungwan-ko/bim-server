package com.web.base.bbs.dao;

import com.web.base.BaseDTO;

public class BBSUserRoleDTO extends BaseDTO {
	private int role_id;
	private String user_id;
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
	
}
