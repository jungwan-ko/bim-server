package kr.bim.ports.category.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.web.base.BaseDao;

@Repository("categoryDAO")
public class CategoryDAO extends BaseDao{
	
	//<select id="list" resultType="categoryDTO">
	//목록
	public List<CategoryDTO> list(){
		return selectList("orgMapper.list");
	}
	
	//<insert id="create" parameterType="kr.bim.ports.category.dao.CategoryDTO">
	// 등록
	public int create(CategoryDTO categoryDTO) {
//		return (int) insert("orgMapper.create", categoryDTO);
		return update("orgMapper.create", categoryDTO);
	}
	
}
