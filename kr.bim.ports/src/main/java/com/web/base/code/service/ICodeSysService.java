package com.web.base.code.service;

import java.util.HashMap;
import java.util.List;

import com.web.base.CommonParams;
import com.web.base.code.dao.CodeGrpDTO;
import com.web.base.code.dao.CodeSysDTO;

public interface ICodeSysService {
	public List<CodeSysDTO> list(String paramCodeGrp);
	public List<CodeSysDTO> list(String[] paramCodeGrp);
	public List<CodeGrpDTO> listGrp();
	public int createCodeGrp(CodeGrpDTO paramBean);
	public int createCodeGrp(CodeGrpDTO paramBean,CommonParams common);
	public int createCodeSys(CodeSysDTO paramBean);
	public int createCodeSys(CodeSysDTO paramBean,CommonParams common);
	public int dropCodeGrp(String paramCodeGrp);
	public int dropCodeSys(String paramCodeSys);
}
	
