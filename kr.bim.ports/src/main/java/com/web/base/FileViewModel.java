package com.web.base;

import java.util.List;

import com.web.base.file.dao.AttachFileDTO;

public class FileViewModel extends BaseViewModel
{
	private List<AttachFileDTO> listFiles;

	public List<AttachFileDTO> getListFiles() {
		return listFiles;
	}

	public void setListFiles(List<AttachFileDTO> listFiles) {
		this.listFiles = listFiles;
	}
	
}
