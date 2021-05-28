package kr.bim.ports.category.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.base.BaseService;
import com.web.base.CommonParams;

import kr.bim.ports.category.dao.CategoryDAO;
import kr.bim.ports.category.dao.CategoryDTO;

@Service("categoryService")
public class CategoryServiceImpl extends BaseService implements ICategoryService{

	@Autowired
	private CategoryDAO categoryDAO; 
	
	/**
	 * 목록
	 */
	@Override
	public List<CategoryDTO> list() {
		return categoryDAO.list();
	}

	/**
	 * 등록
	 */
	/*
	 * @Override public int create(CategoryDTO categoryDTO) {
	 * categoryDTO.setUse_yn("Y"); //categoryDTO.setcre return
	 * categoryDAO.create(categoryDTO); }
	 */

	@Override
	public int create(CategoryDTO categoryDTO, CommonParams common) {
		categoryDTO.setUse_yn("Y");
		//categoryDTO.setcre
		categoryDTO.setCreate_user_id(common.getLoginUserID());//로그인유저아이디
		return categoryDAO.create(categoryDTO);
	}

	
	
	
	
	
	
	
	
	
	
	
}
