package kr.bim.ports.web.viewmodel;

import java.util.List;

import com.web.base.BaseViewModel;

import kr.bim.ports.category.dao.CategoryDTO;

public class CategoryViewModel extends BaseViewModel{
	private List<CategoryDTO> list ;
	private CategoryDTO category;
	
	public List<CategoryDTO> getList() {
		return list;
	}
	public void setList(List<CategoryDTO> list) {
		this.list = list;
	}
	public CategoryDTO getCategory() {
		return category;
	}
	public void setCategory(CategoryDTO category) {
		this.category = category;
	}
	
	
	

}
