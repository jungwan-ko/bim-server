package com.web.base.account.dao;

import java.util.HashMap;

import org.springframework.stereotype.Repository;

import com.web.base.BaseDao;
@Repository("userPhotoDao")
public class UserPhotoDao extends BaseDao {
	
	public int create(HashMap<String,Object>  paramMap) {
		return update("userPhoto.create",paramMap);
	}
	public int delete(HashMap<String,Object>  paramMap) {
		return update("userPhoto.delete",paramMap);
	}
	public UserPhotoDto detail(HashMap<String,Object>  paramMap) {
		return (UserPhotoDto)selectOne("userPhoto.detail",paramMap);
	}
}
