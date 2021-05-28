package com.web.base.admin.viewmodel;

import java.util.List;

import com.web.base.BaseViewModel;
import com.web.base.file.dao.DBInfoDTO;

public class SystemViewModel extends BaseViewModel {
	private List<DBInfoDTO> dbList;

	public List<DBInfoDTO> getDbList() {
		return dbList;
	}

	public void setDbList(List<DBInfoDTO> dbList) {
		this.dbList = dbList;
	}
	
	

}
