package com.web.base.meta.service;

import java.util.List;

import com.web.base.meta.dao.MetaAdmDTO;

public interface IMetaAdmService {
	
	public int creataData();
	
	public List<MetaAdmDTO> listSido();
	public List<MetaAdmDTO> listGungu(String paramSido);
	public List<MetaAdmDTO> listDong(String paramGungu);
}
