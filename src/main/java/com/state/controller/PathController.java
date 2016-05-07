package com.state.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.state.po.PathDefinePo;
import com.state.service.LineLimitService;

/**
 * 通道controller
 * @author 帅
 *
 */
@Controller
@RequestMapping("/path")
public class PathController {
	private static final transient Logger log = Logger
			.getLogger(PathController.class);

	@Autowired
	private LineLimitService lineLimitService;
	
	/**
	 * 跳转页面
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/init")
	public String init(HttpServletRequest request,HttpServletResponse response) {
		log.info("@ init limitLine ");
		
		return "limitLine";
	}
	
	@ResponseBody
	@RequestMapping(value = "/getAllPath")
	public String getAllPath(HttpServletRequest request,HttpServletResponse response) {
		log.info("@ init getAllPath ");
		
		return "limitLine";
	}
	
	@RequestMapping(value = "/getAllPath")
	public String updatePath(PathDefinePo pathDefine){
		return "success";
	}
	
	
	

}
