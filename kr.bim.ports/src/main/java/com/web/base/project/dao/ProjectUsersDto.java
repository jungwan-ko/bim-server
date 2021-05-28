package com.web.base.project.dao;

import com.web.base.BaseDTO;

public class ProjectUsersDto extends BaseDTO {
	public 	String	user_id	;
	public 	String	user_email	;
	public 	String	owner_yn	;
	public 	String	prj_id	;
	public 	String	user_name	;
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getOwner_yn() {
		return owner_yn;
	}
	public void setOwner_yn(String owner_yn) {
		this.owner_yn = owner_yn;
	}
	public String getPrj_id() {
		return prj_id;
	}
	public void setPrj_id(String prj_id) {
		this.prj_id = prj_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	
	
}
