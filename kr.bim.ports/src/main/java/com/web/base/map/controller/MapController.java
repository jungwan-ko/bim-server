package com.web.base.map.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.web.base.BaseController;

@Controller("mapController")
public class MapController extends BaseController {
	@RequestMapping(value="/map/select/position",method=RequestMethod.GET)
	public String posSelectorView(){
		return "/base/map/posSelector";
	}
	@RequestMapping(value="/search/address",method=RequestMethod.GET)
	public String searchAddrAction(){
		return "/base/map/searchAddress";
	}
}
