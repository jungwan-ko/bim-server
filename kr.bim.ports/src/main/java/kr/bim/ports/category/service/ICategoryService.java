package kr.bim.ports.category.service;

import java.util.List;

import com.web.base.CommonParams;

import kr.bim.ports.category.dao.CategoryDTO;

public interface ICategoryService {

	//목록
	public List<CategoryDTO> list();
	// 등록
	public int create(CategoryDTO categoryDTO,CommonParams common);
	
}
