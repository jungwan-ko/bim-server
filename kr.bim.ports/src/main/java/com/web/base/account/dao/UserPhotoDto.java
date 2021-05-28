package com.web.base.account.dao;

import com.web.base.BaseDTO;

public class UserPhotoDto extends BaseDTO  {
	private String user_id;
	private int file_seq;
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public int getFile_seq() {
		return file_seq;
	}
	public void setFile_seq(int file_seq) {
		this.file_seq = file_seq;
	}
	
	
}
