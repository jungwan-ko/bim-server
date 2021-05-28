package com.web.base.bbs.dao;

import java.util.List;

import com.web.base.BaseDTO;
import com.web.base.file.dao.AttachFileDTO;


public class BBSContentDTO extends BaseDTO {
	private int bbs_seq;
	private String bbs_id;
	private String bbs_cont;
	private String bbs_cont_title;
	private int bbs_group;
	private int  bbs_sort;
	private int  bbs_parent;
	private int bbs_level;
	private int bbs_read;
	private String file_grp_id;
	private String file_grp_id_now;
	private int category_seq;
	private String create_ip;
	private String category_title;
	private int fileSeq;
	private String fixed_yn;
	private String createUserID;
	private String bbs_title;
	private String edit_yn;
	private String read_yn;
	private String data_type;
	private int data_id;
	private List<AttachFileDTO> listFiles;
	private String secret_yn;
	private String mail_yn;
	
	private String user_id;
	private String user_email;
	
	private BBSCommentDto bbsCommentDto;
	private List<BBSCommentDto> listComment;
	private int cmmtCnt;
	private String url;
	
	
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
	public String getSecret_yn() {
		return secret_yn;
	}
	public void setSecret_yn(String secret_yn) {
		this.secret_yn = secret_yn;
	}
	public String getMail_yn() {
		return mail_yn;
	}
	public void setMail_yn(String mail_yn) {
		this.mail_yn = mail_yn;
	}
	public int getCmmtCnt() {
		return cmmtCnt;
	}
	public void setCmmtCnt(int cmmtCnt) {
		this.cmmtCnt = cmmtCnt;
	}
	public String getData_type() {
		return data_type;
	}
	public void setData_type(String data_type) {
		this.data_type = data_type;
	}
	public int getData_id() {
		return data_id;
	}
	public void setData_id(int data_id) {
		this.data_id = data_id;
	}
	public int getBbs_seq() {
		return bbs_seq;
	}
	public void setBbs_seq(int bbs_seq) {
		this.bbs_seq = bbs_seq;
	}
	public String getBbs_id() {
		return bbs_id;
	}
	public void setBbs_id(String bbs_id) {
		this.bbs_id = bbs_id;
	}
	public String getBbs_cont() {
		return bbs_cont;
	}
	public void setBbs_cont(String bbs_cont) {
		this.bbs_cont = bbs_cont;
	}
	public String getBbs_cont_title() {
		return bbs_cont_title;
	}
	public void setBbs_cont_title(String bbs_cont_title) {
		this.bbs_cont_title = bbs_cont_title;
	}
	public int getBbs_group() {
		return bbs_group;
	}
	public void setBbs_group(int bbs_group) {
		this.bbs_group = bbs_group;
	}
	public int getBbs_sort() {
		return bbs_sort;
	}
	public void setBbs_sort(int bbs_sort) {
		this.bbs_sort = bbs_sort;
	}
	public int getBbs_parent() {
		return bbs_parent;
	}
	public void setBbs_parent(int bbs_parent) {
		this.bbs_parent = bbs_parent;
	}
	public int getBbs_level() {
		return bbs_level;
	}
	public void setBbs_level(int bbs_level) {
		this.bbs_level = bbs_level;
	}
	public int getBbs_read() {
		return bbs_read;
	}
	public void setBbs_read(int bbs_read) {
		this.bbs_read = bbs_read;
	}
	public String getFile_grp_id() {
		return file_grp_id;
	}
	public void setFile_grp_id(String file_grp_id) {
		this.file_grp_id = file_grp_id;
	}
	public String getFile_grp_id_now() {
		return file_grp_id_now;
	}
	public void setFile_grp_id_now(String file_grp_id_now) {
		this.file_grp_id_now = file_grp_id_now;
	}
	public int getCategory_seq() {
		return category_seq;
	}
	public void setCategory_seq(int category_seq) {
		this.category_seq = category_seq;
	}
	public String getCreate_ip() {
		return create_ip;
	}
	public void setCreate_ip(String create_ip) {
		this.create_ip = create_ip;
	}
	public String getCategory_title() {
		return category_title;
	}
	public void setCategory_title(String category_title) {
		this.category_title = category_title;
	}
	public int getFileSeq() {
		return fileSeq;
	}
	public void setFileSeq(int fileSeq) {
		this.fileSeq = fileSeq;
	}
	public String getFixed_yn() {
		return fixed_yn;
	}
	public void setFixed_yn(String fixed_yn) {
		this.fixed_yn = fixed_yn;
	}
	public String getCreateUserID() {
		return createUserID;
	}
	public void setCreateUserID(String createUserID) {
		this.createUserID = createUserID;
	}
	public String getBbs_title() {
		return bbs_title;
	}
	public void setBbs_title(String bbs_title) {
		this.bbs_title = bbs_title;
	}
	public String getEdit_yn() {
		return edit_yn;
	}
	public void setEdit_yn(String edit_yn) {
		this.edit_yn = edit_yn;
	}
	public String getRead_yn() {
		return read_yn;
	}
	public void setRead_yn(String read_yn) {
		this.read_yn = read_yn;
	}
	public List<AttachFileDTO> getListFiles() {
		return listFiles;
	}
	public void setListFiles(List<AttachFileDTO> listFiles) {
		this.listFiles = listFiles;
	}
	public BBSCommentDto getBbsCommentDto() {
		return bbsCommentDto;
	}
	public void setBbsCommentDto(BBSCommentDto bbsCommentDto) {
		this.bbsCommentDto = bbsCommentDto;
	}
	public List<BBSCommentDto> getListComment() {
		return listComment;
	}
	public void setListComment(List<BBSCommentDto> listComment) {
		this.listComment = listComment;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
