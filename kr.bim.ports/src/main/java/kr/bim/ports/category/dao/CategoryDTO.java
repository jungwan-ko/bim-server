package kr.bim.ports.category.dao;

import java.util.Date;

public class CategoryDTO {
	
//	org_item_seq, org_item_cont, org_item_group, org_item_sort, org_item_parent, org_item_level, file_grp_id, 
//	org_item_title, update_date, create_date, update_user_id, create_user_id, create_ip, use_yn, org_id, org_item_type
	
	
	private int org_item_seq;
	private String org_item_cont;
	private int org_item_group;
	private int org_item_sort;
	private int org_item_parent;
	private int org_item_level;
	private String file_grp_id;
	private String org_item_title;
	private Date update_date;
	private Date create_date;
	private String update_user_id;
	private String create_user_id;
	private String create_ip;
	private String use_yn;
	private String org_id;
	private String org_item_type;
	
	public int getOrg_item_seq() {
		return org_item_seq;
	}
	public void setOrg_item_seq(int org_item_seq) {
		this.org_item_seq = org_item_seq;
	}
	public String getOrg_item_cont() {
		return org_item_cont;
	}
	public void setOrg_item_cont(String org_item_cont) {
		this.org_item_cont = org_item_cont;
	}
	public int getOrg_item_group() {
		return org_item_group;
	}
	public void setOrg_item_group(int org_item_group) {
		this.org_item_group = org_item_group;
	}
	public int getOrg_item_sort() {
		return org_item_sort;
	}
	public void setOrg_item_sort(int org_item_sort) {
		this.org_item_sort = org_item_sort;
	}
	public int getOrg_item_parent() {
		return org_item_parent;
	}
	public void setOrg_item_parent(int org_item_parent) {
		this.org_item_parent = org_item_parent;
	}
	public int getOrg_item_level() {
		return org_item_level;
	}
	public void setOrg_item_level(int org_item_level) {
		this.org_item_level = org_item_level;
	}
	public String getFile_grp_id() {
		return file_grp_id;
	}
	public void setFile_grp_id(String file_grp_id) {
		this.file_grp_id = file_grp_id;
	}
	public String getOrg_item_title() {
		return org_item_title;
	}
	public void setOrg_item_title(String org_item_title) {
		this.org_item_title = org_item_title;
	}
	public Date getUpdate_date() {
		return update_date;
	}
	public void setUpdate_date(Date update_date) {
		this.update_date = update_date;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	public String getUpdate_user_id() {
		return update_user_id;
	}
	public void setUpdate_user_id(String update_user_id) {
		this.update_user_id = update_user_id;
	}
	public String getCreate_user_id() {
		return create_user_id;
	}
	public void setCreate_user_id(String create_user_id) {
		this.create_user_id = create_user_id;
	}
	public String getCreate_ip() {
		return create_ip;
	}
	public void setCreate_ip(String create_ip) {
		this.create_ip = create_ip;
	}
	public String getUse_yn() {
		return use_yn;
	}
	public void setUse_yn(String use_yn) {
		this.use_yn = use_yn;
	}
	public String getOrg_id() {
		return org_id;
	}
	public void setOrg_id(String org_id) {
		this.org_id = org_id;
	}
	public String getOrg_item_type() {
		return org_item_type;
	}
	public void setOrg_item_type(String org_item_type) {
		this.org_item_type = org_item_type;
	}
	
}
