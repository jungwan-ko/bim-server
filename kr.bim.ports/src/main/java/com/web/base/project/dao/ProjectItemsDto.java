package com.web.base.project.dao;

import java.util.Date;

import com.web.base.BaseDTO;

public class ProjectItemsDto extends BaseDTO{
	public 	int	seq	;
	public 	String	cont	;
	public 	int	grp	;
	public 	int	sort	;
	public 	int	parent_seq	;
	public 	int	lvl	;
	public 	String	file_grp_id	;
	public 	String	title	;
	public 	int	read_cnt	;
	public 	int	category_seq	;
	public 	String	complete_yn	;
	public 	String	create_ip	;
	public 	String	prj_id	;
	public String bim_build_code;
	public String etc;
	public String bim_build_code_title;
	public String category_title;
	
	
	
	
	public String getCategory_title() {
		return category_title;
	}
	public void setCategory_title(String category_title) {
		this.category_title = category_title;
	}
	public String getBim_build_code_title() {
		return bim_build_code_title;
	}
	public void setBim_build_code_title(String bim_build_code_title) {
		this.bim_build_code_title = bim_build_code_title;
	}
	public String getBim_build_code() {
		return bim_build_code;
	}
	public void setBim_build_code(String bim_build_code) {
		this.bim_build_code = bim_build_code;
	}
	public String getEtc() {
		return etc;
	}
	public void setEtc(String etc) {
		this.etc = etc;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getCont() {
		return cont;
	}
	public void setCont(String cont) {
		this.cont = cont;
	}
	public int getGrp() {
		return grp;
	}
	public void setGrp(int grp) {
		this.grp = grp;
	}
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}
	public int getParent_seq() {
		return parent_seq;
	}
	public void setParent_seq(int parent_seq) {
		this.parent_seq = parent_seq;
	}
	public int getLvl() {
		return lvl;
	}
	public void setLvl(int lvl) {
		this.lvl = lvl;
	}
	public String getFile_grp_id() {
		return file_grp_id;
	}
	public void setFile_grp_id(String file_grp_id) {
		this.file_grp_id = file_grp_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getRead_cnt() {
		return read_cnt;
	}
	public void setRead_cnt(int read_cnt) {
		this.read_cnt = read_cnt;
	}
	public int getCategory_seq() {
		return category_seq;
	}
	public void setCategory_seq(int category_seq) {
		this.category_seq = category_seq;
	}
	public String getComplete_yn() {
		return complete_yn;
	}
	public void setComplete_yn(String complete_yn) {
		this.complete_yn = complete_yn;
	}
	public String getCreate_ip() {
		return create_ip;
	}
	public void setCreate_ip(String create_ip) {
		this.create_ip = create_ip;
	}
	public String getPrj_id() {
		return prj_id;
	}
	public void setPrj_id(String prj_id) {
		this.prj_id = prj_id;
	}
	
}
