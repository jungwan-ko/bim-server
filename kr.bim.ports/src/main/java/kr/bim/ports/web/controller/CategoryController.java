package kr.bim.ports.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.web.base.BaseController;

import kr.bim.ports.category.service.ICategoryService;
import kr.bim.ports.web.viewmodel.CategoryViewModel;

@Controller
public class CategoryController extends BaseController{
	@Autowired
	private ICategoryService categoryService;
	
	/**
	 * 목록
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/cate/list", method=RequestMethod.GET)
	@ResponseBody
	public CategoryViewModel list(CategoryViewModel vm, Model model){
		
		vm.setList(categoryService.list());
		
		//System.out.println("list 호출");
		return vm;
	 }
	
	/**
	 * 등록처리
	 * @param categoryDTO
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/cate/create", method=RequestMethod.POST)
	@ResponseBody
	public CategoryViewModel create(@RequestBody CategoryViewModel vm, Model model) {
		vm.setResultCount(categoryService.create(vm.getCategory(),getCommonParams()));
		vm.setList(categoryService.list());
		return vm;
	}
	
	
	
	

}
