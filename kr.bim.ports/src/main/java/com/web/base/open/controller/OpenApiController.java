package com.web.base.open.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.web.base.BaseController;
import com.web.base.open.rss.service.IWetherRssService;
import com.web.base.open.viewmodel.WetherViewModel;
@Controller("openApiController")
public class OpenApiController extends BaseController {
	@Autowired
	private IWetherRssService wetherRssService;
	
	@RequestMapping(value="/api/rss/wether/detail/{id}" , method = RequestMethod.GET)
	public @ResponseBody WetherViewModel detailWetherAction(WetherViewModel vm,Model model){
		vm.setListWetherRss(wetherRssService.list(vm.getId()));
		return vm;
	}
}
