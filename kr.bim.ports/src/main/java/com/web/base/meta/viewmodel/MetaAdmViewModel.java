package com.web.base.meta.viewmodel;

import java.util.List;

import com.web.base.BaseViewModel;
import com.web.base.meta.dao.MetaAdmDTO;

public class MetaAdmViewModel extends BaseViewModel {
	private List<MetaAdmDTO> list;
	private int paramAdmSeq;
	
	
	public int getParamAdmSeq() {
		return paramAdmSeq;
	}

	public void setParamAdmSeq(int paramAdmSeq) {
		this.paramAdmSeq = paramAdmSeq;
	}

	public List<MetaAdmDTO> getList() {
		return list;
	}

	public void setList(List<MetaAdmDTO> list) {
		this.list = list;
	}
	
	
}
