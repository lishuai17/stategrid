package com.state.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.state.po.UserPo;
import com.state.service.ILoginService;

@Controller
@RequestMapping("/manager")
public class UserManagerController {
	//By：JinHang 2016年5月8日 17:08:48
	private static final transient Logger log = Logger
			.getLogger(DeclareController.class);
	
	@Autowired
	private ILoginService loginService;

	@RequestMapping(value = "/init")
	public ModelAndView init(HttpServletRequest request, HttpServletResponse response,Model model) {
		log.info("跳转到用户管理界面");
		List<UserPo> nopass = loginService.selectNopass();
		List<UserPo> pass = loginService.selectPass();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("nopass", nopass);
		map.put("pass", pass);
		model.addAttribute(nopass);
		model.addAttribute(pass);
		ModelAndView view = new ModelAndView("usermanager",map);
		return view;
	}
	
	@ResponseBody
	@RequestMapping(value = "/approveUser",method=RequestMethod.POST)
	public String approveUser(String user) {
		log.info("审批用户及分配菜单权限");
		try{
			loginService.approve(user);//审批
			loginService.allotBill(user);//分配菜单权限
		}catch (Exception e) {
			log.error("审批失败",e);
			return "fail";
		}
		return "success";
	}
}
