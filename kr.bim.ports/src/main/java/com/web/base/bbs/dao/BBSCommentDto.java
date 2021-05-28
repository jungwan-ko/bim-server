package com.web.base.bbs.dao;

import java.util.Date;

import com.web.base.BaseDTO;

public class BBSCommentDto extends BaseDTO{
	private int seq;
	private int bbs_seq;
	private String bbs_id;
	private String cmmt_content;
	private Date create_date;
	private String create_user_id;
	private Date update_date;
	private String update_user_id;
	private String use_yn;
	private String create_user_name;
	
	
	public String getBbs_id() {
		return bbs_id;
	}
	public void setBbs_id(String bbs_id) {
		this.bbs_id = bbs_id;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public int getBbs_seq() {
		return bbs_seq;
	}
	public void setBbs_seq(int bbs_seq) {
		this.bbs_seq = bbs_seq;
	}
	public String getCmmt_content() {
		return cmmt_content;
	}
	public void setCmmt_content(String cmmt_content) {
		this.cmmt_content = cmmt_content;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	public String getCreate_user_id() {
		return create_user_id;
	}
	public void setCreate_user_id(String create_user_id) {
		this.create_user_id = create_user_id;
	}
	public Date getUpdate_date() {
		return update_date;
	}
	public void setUpdate_date(Date update_date) {
		this.update_date = update_date;
	}
	public String getUpdate_user_id() {
		return update_user_id;
	}
	public void setUpdate_user_id(String update_user_id) {
		this.update_user_id = update_user_id;
	}
	public String getUse_yn() {
		return use_yn;
	}
	public void setUse_yn(String use_yn) {
		this.use_yn = use_yn;
	}
	public String getCreate_user_name() {
		return create_user_name;
	}
	public void setCreate_user_name(String create_user_name) {
		this.create_user_name = create_user_name;
	}
	
	
	
	
	
}
