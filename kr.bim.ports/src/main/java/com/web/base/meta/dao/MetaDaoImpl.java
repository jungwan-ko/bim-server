package com.web.base.meta.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.web.base.BaseDao;

@Repository("metaDao")
public class MetaDaoImpl extends BaseDao implements IMetaDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<MetaDTO> list(HashMap<String, Object> paramMap) {
		return selectList("meta.list", paramMap);
	}

	
}
