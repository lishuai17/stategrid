package com.state.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.state.po.AreaPo;
import com.state.service.AreaService;

@Controller
@RequestMapping("/area")
public class AreaController {
	
	@Autowired
	private AreaService areaService;
	
	@ResponseBody
	@RequestMapping(value="/getAllArea",method=RequestMethod.POST)
	public List<AreaPo> getAllArea(){
		
		return areaService.getAllArea();
	}

}
