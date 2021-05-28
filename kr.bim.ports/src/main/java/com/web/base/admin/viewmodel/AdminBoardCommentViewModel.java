package com.web.base.admin.viewmodel;

import java.util.List;

import com.web.base.BaseViewModel;
import com.web.base.bbs.dao.BBSCommentDto;

public class AdminBoardCommentViewModel extends BaseViewModel {
	private List<BBSCommentDto> list;
	private BBSCommentDto detail;
	public List<BBSCommentDto> getList() {
		return list;
	}
	public void setList(List<BBSCommentDto> list) {
		this.list = list;
	}
	public BBSCommentDto getDetail() {
		return detail;
	}
	public void setDetail(BBSCommentDto detail) {
		this.detail = detail;
	}
	
	

}
