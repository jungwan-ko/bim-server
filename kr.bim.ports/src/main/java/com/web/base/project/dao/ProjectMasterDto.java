package com.web.base.project.dao;

import java.util.Date;

import com.web.base.BaseDTO;

public class ProjectMasterDto extends BaseDTO {
	private 	String	prj_id	;
	private 	String	prj_title	;
	private 	String	read_role_id	;
	private 	String	write_role_id	;
	private 	String	manage_user_id	;
	private 	String	use_yn	;
	private 	String	org_code	;
	private 	String	prj_commt	;
	private 	String	prj_exp	;
	private 	String	start_date	;
	private 	String	end_date	;
	private 	String	req_commt	;
	private 	String	build_title	;
	private 	String	port_title	;
	private 	String	port_detail_title	;
	private 	String	build_code	;
	private 	String	mng_code	;
	private 	String	mng_org_code	;
	private 	String	setup_date	;
	private 	String	open_yn	;
	private 	String	sea_code	;
	private 	String	build_type_code	;
	private 	String	etc_mnt	;
	private 	String	admin_commt	;
	private 	String	addr	;
	private 	String	point_xy	;
	private 	String	confirm_yn	;
	private 	String	 sea_title ;
	private 	String	 mng_org_title ;
	private 	String	 mng_title;
	private 	String	 org_title;
	private 	String	 build_type_title;
	private 	String	 build_code_title;
	private String user_name;
	public String getPrj_id() {
		return prj_id;
	}
	public void setPrj_id(String prj_id) {
		this.prj_id = prj_id;
	}
	public String getPrj_title() {
		return prj_title;
	}
	public void setPrj_title(String prj_title) {
		this.prj_title = prj_title;
	}
	public String getRead_role_id() {
		return read_role_id;
	}
	public void setRead_role_id(String read_role_id) {
		this.read_role_id = read_role_id;
	}
	public String getWrite_role_id() {
		return write_role_id;
	}
	public void setWrite_role_id(String write_role_id) {
		this.write_role_id = write_role_id;
	}
	public String getManage_user_id() {
		return manage_user_id;
	}
	public void setManage_user_id(String manage_user_id) {
		this.manage_user_id = manage_user_id;
	}
	public String getUse_yn() {
		return use_yn;
	}
	public void setUse_yn(String use_yn) {
		this.use_yn = use_yn;
	}
	public String getOrg_code() {
		return org_code;
	}
	public void setOrg_code(String org_code) {
		this.org_code = org_code;
	}
	public String getPrj_commt() {
		return prj_commt;
	}
	public void setPrj_commt(String prj_commt) {
		this.prj_commt = prj_commt;
	}
	public String getPrj_exp() {
		return prj_exp;
	}
	public void setPrj_exp(String prj_exp) {
		this.prj_exp = prj_exp;
	}
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	public String getReq_commt() {
		return req_commt;
	}
	public void setReq_commt(String req_commt) {
		this.req_commt = req_commt;
	}
	public String getBuild_title() {
		return build_title;
	}
	public void setBuild_title(String build_title) {
		this.build_title = build_title;
	}
	public String getPort_title() {
		return port_title;
	}
	public void setPort_title(String port_title) {
		this.port_title = port_title;
	}
	public String getPort_detail_title() {
		return port_detail_title;
	}
	public void setPort_detail_title(String port_detail_title) {
		this.port_detail_title = port_detail_title;
	}
	public String getBuild_code() {
		return build_code;
	}
	public void setBuild_code(String build_code) {
		this.build_code = build_code;
	}
	public String getMng_code() {
		return mng_code;
	}
	public void setMng_code(String mng_code) {
		this.mng_code = mng_code;
	}
	public String getMng_org_code() {
		return mng_org_code;
	}
	public void setMng_org_code(String mng_org_code) {
		this.mng_org_code = mng_org_code;
	}
	public String getSetup_date() {
		return setup_date;
	}
	public void setSetup_date(String setup_date) {
		this.setup_date = setup_date;
	}
	public String getOpen_yn() {
		return open_yn;
	}
	public void setOpen_yn(String open_yn) {
		this.open_yn = open_yn;
	}
	public String getSea_code() {
		return sea_code;
	}
	public void setSea_code(String sea_code) {
		this.sea_code = sea_code;
	}
	public String getBuild_type_code() {
		return build_type_code;
	}
	public void setBuild_type_code(String build_type_code) {
		this.build_type_code = build_type_code;
	}
	public String getEtc_mnt() {
		return etc_mnt;
	}
	public void setEtc_mnt(String etc_mnt) {
		this.etc_mnt = etc_mnt;
	}
	public String getAdmin_commt() {
		return admin_commt;
	}
	public void setAdmin_commt(String admin_commt) {
		this.admin_commt = admin_commt;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getPoint_xy() {
		return point_xy;
	}
	public void setPoint_xy(String point_xy) {
		this.point_xy = point_xy;
	}
	public String getConfirm_yn() {
		return confirm_yn;
	}
	public void setConfirm_yn(String confirm_yn) {
		this.confirm_yn = confirm_yn;
	}
	public String getSea_title() {
		return sea_title;
	}
	public void setSea_title(String sea_title) {
		this.sea_title = sea_title;
	}
	public String getMng_org_title() {
		return mng_org_title;
	}
	public void setMng_org_title(String mng_org_title) {
		this.mng_org_title = mng_org_title;
	}
	public String getMng_title() {
		return mng_title;
	}
	public void setMng_title(String mng_title) {
		this.mng_title = mng_title;
	}
	public String getOrg_title() {
		return org_title;
	}
	public void setOrg_title(String org_title) {
		this.org_title = org_title;
	}
	public String getBuild_type_title() {
		return build_type_title;
	}
	public void setBuild_type_title(String build_type_title) {
		this.build_type_title = build_type_title;
	}
	public String getBuild_code_title() {
		return build_code_title;
	}
	public void setBuild_code_title(String build_code_title) {
		this.build_code_title = build_code_title;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	
	
	
}