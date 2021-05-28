package com.web.base.bbs.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.web.base.BaseDao;
@Repository("bbsCommentDao")
public class BBSCommentDao extends BaseDao {
	public int create(BBSCommentDto paramBean) {
		return update("bbsComment.create",paramBean);
	}
	public List<BBSCommentDto> list(HashMap<String,Object> paramMap){
		return selectList("bbsComment.list",paramMap);
	}
	public int update(BBSCommentDto paramBean) {
		return update("bbsComment.update",paramBean);
	}
	public int drop(HashMap<String,Object> paramMap) {
		return update("bbsComment.delete",paramMap);
	}
}
