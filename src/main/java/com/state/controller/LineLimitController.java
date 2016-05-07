package com.state.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.state.po.DeclareDataPo;
import com.state.po.DeclarePo;
import com.state.po.UserPo;
import com.state.service.LineLimitService;

@Controller
@RequestMapping("/lineLimit")
public class LineLimitController {
	private static final transient Logger log = Logger
			.getLogger(LineLimitController.class);

	@Autowired
	private LineLimitService lineLimitService;
	
	/**
	 * 跳转申报页面
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/init")
	public String init(HttpServletRequest request,HttpServletResponse response) {
		log.info("@ init limitLine ");
		
		return "limitLine";
	}

}
