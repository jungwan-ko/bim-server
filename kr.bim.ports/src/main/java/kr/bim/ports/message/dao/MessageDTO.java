package kr.bim.ports.message.dao;

import java.util.List;

public class MessageDTO {
	

	//tb_message
	private int seq;
	private String from_user_id;
	private String to_user_id;
	private String create_date;
	private String read_yn;
	private String message_content;
	private String app_type;
	private String prj_id;
	private List<String> targets;
	
	
	public List<String> getTargets() {
		return targets;
	}
	public void setTargets(List<String> targets) {
		this.targets = targets;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getFrom_user_id() {
		return from_user_id;
	}
	public void setFrom_user_id(String from_user_id) {
		this.from_user_id = from_user_id;
	}
	public String getTo_user_id() {
		return to_user_id;
	}
	public void setTo_user_id(String to_user_id) {
		this.to_user_id = to_user_id;
	}
	public String getCreate_date() {
		return create_date;
	}
	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}
	public String getRead_yn() {
		return read_yn;
	}
	public void setRead_yn(String read_yn) {
		this.read_yn = read_yn;
	}
	public String getMessage_content() {
		return message_content;
	}
	public void setMessage_content(String message_content) {
		this.message_content = message_content;
	}
	public String getApp_type() {
		return app_type;
	}
	public void setApp_type(String app_type) {
		this.app_type = app_type;
	}
	public String getPrj_id() {
		return prj_id;
	}
	public void setPrj_id(String prj_id) {
		this.prj_id = prj_id;
	}
	
	
	
	
	
}
