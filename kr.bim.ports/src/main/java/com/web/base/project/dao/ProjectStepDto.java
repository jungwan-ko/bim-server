package com.web.base.project.dao;

import java.util.Date;

import com.web.base.BaseDTO;

/**
 * @author injeinc
 *
 */
public class ProjectStepDto extends BaseDTO {
	private 	int	items_seq	;
	private 	int	category_seq	;
	private 	String	user_id	;
	private 	String	confirm_yn	;
	private 	String	prj_id	;
	private String step_yn;
	private String mng_user_name;
	private String category_title;
	private Date confirm_date;
	private String process_code;
	private String process_code_title;
	
	public String getProcess_code_title() {
		return process_code_title;
	}
	public void setProcess_code_title(String process_code_title) {
		this.process_code_title = process_code_title;
	}
	public Date getConfirm_date() {
		return confirm_date;
	}
	public void setConfirm_date(Date confirm_date) {
		this.confirm_date = confirm_date;
	}
	public String getProcess_code() {
		return process_code;
	}
	public void setProcess_code(String process_code) {
		this.process_code = process_code;
	}
	public int getItems_seq() {
		return items_seq;
	}
	public void setItems_seq(int items_seq) {
		this.items_seq = items_seq;
	}
	public int getCategory_seq() {
		return category_seq;
	}
	public void setCategory_seq(int category_seq) {
		this.category_seq = category_seq;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getConfirm_yn() {
		return confirm_yn;
	}
	public void setConfirm_yn(String confirm_yn) {
		this.confirm_yn = confirm_yn;
	}
	public String getPrj_id() {
		return prj_id;
	}
	public void setPrj_id(String prj_id) {
		this.prj_id = prj_id;
	}
	public String getStep_yn() {
		return step_yn;
	}
	public void setStep_yn(String step_yn) {
		this.step_yn = step_yn;
	}
	public String getMng_user_name() {
		return mng_user_name;
	}
	public void setMng_user_name(String mng_user_name) {
		this.mng_user_name = mng_user_name;
	}
	public String getCategory_title() {
		return category_title;
	}
	public void setCategory_title(String category_title) {
		this.category_title = category_title;
	}
	
	
	
}
