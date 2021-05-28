package com.web.base.web.viewmodel;

import java.util.List;

import com.web.base.BaseViewModel;
import com.web.base.account.dao.UserDTO;

public class UserViewModel extends BaseViewModel{
	private List<UserDTO> list;

	public List<UserDTO> getList() {
		return list;
	}

	public void setList(List<UserDTO> list) {
		this.list = list;
	}
	
}
