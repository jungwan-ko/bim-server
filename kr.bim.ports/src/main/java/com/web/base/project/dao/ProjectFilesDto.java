package com.web.base.project.dao;

import com.web.base.BaseDTO;

public class ProjectFilesDto extends BaseDTO {
	public 	int	file_seq	;
	public 	String	file_grp_id	;
	public 	String	file_sgrp_id	;
	public 	String	file_org_name	;
	public 	String	file_new_name	;
	public 	String	file_path	;
	public 	float	file_size	;
	public 	String	file_ext	;
	public 	String	file_title	;
	public 	String	prj_id	;
	public String version;
	public int category_seq;
	
	
	
		
	

	public int getCategory_seq() {
		return category_seq;
	}
	public void setCategory_seq(int category_seq) {
		this.category_seq = category_seq;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public int getFile_seq() {
		return file_seq;
	}
	public void setFile_seq(int file_seq) {
		this.file_seq = file_seq;
	}
	public String getFile_grp_id() {
		return file_grp_id;
	}
	public void setFile_grp_id(String file_grp_id) {
		this.file_grp_id = file_grp_id;
	}
	public String getFile_sgrp_id() {
		return file_sgrp_id;
	}
	public void setFile_sgrp_id(String file_sgrp_id) {
		this.file_sgrp_id = file_sgrp_id;
	}
	public String getFile_org_name() {
		return file_org_name;
	}
	public void setFile_org_name(String file_org_name) {
		this.file_org_name = file_org_name;
	}
	public String getFile_new_name() {
		return file_new_name;
	}
	public void setFile_new_name(String file_new_name) {
		this.file_new_name = file_new_name;
	}
	public String getFile_path() {
		return file_path;
	}
	public void setFile_path(String file_path) {
		this.file_path = file_path;
	}
	public float getFile_size() {
		return file_size;
	}
	public void setFile_size(float file_size) {
		this.file_size = file_size;
	}
	public String getFile_ext() {
		return file_ext;
	}
	public void setFile_ext(String file_ext) {
		this.file_ext = file_ext;
	}
	public String getFile_title() {
		return file_title;
	}
	public void setFile_title(String file_title) {
		this.file_title = file_title;
	}
	public String getPrj_id() {
		return prj_id;
	}
	public void setPrj_id(String prj_id) {
		this.prj_id = prj_id;
	}
	
	
}
