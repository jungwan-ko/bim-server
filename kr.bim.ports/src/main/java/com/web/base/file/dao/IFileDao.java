package com.web.base.file.dao;

import java.util.HashMap;
import java.util.List;

public interface IFileDao {
	public int create(AttachFileDTO paramBean);
	public int delete(HashMap<String,Object> paramMap);
	public AttachFileDTO detail(HashMap<String,Object> paramMap);
	public List<AttachFileDTO> list(HashMap<String,Object> paramMap);
	public List<DBInfoDTO> dbList();
	public int update(AttachFileDTO paramBean);
	public int updateFileGrp(HashMap<String, Object> paramMap);
}
