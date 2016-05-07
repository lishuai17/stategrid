package com.state.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.state.po.UserPo;
import com.state.service.ILoginService;

@Controller
@RequestMapping("/login")
public class LoginController {
	//By：JinHang 2016年5月6日 20:13:46
	private static final transient Logger log = Logger
			.getLogger(DeclareController.class);
	
	@Autowired
	private ILoginService loginService;

	@RequestMapping(value = "/login")
	public String login(HttpServletRequest request, HttpServletResponse response) {
		log.info("跳转到登录页面");
		return "login";
	}
	
	@RequestMapping(value = "/register")
	public String register(HttpServletRequest request, HttpServletResponse response) {
		log.info("跳转到注册页面");
		return "register";
	}

	@ResponseBody
	@RequestMapping(value = "/validLogin",method=RequestMethod.POST)
	public String validLogin(HttpServletRequest request,String user,String password) {
		log.info("校验并返回结果");
		//校验用户
		UserPo pd=loginService.judgeUser(user, password);
		if(pd!=null){
			if("1".equals(pd.getIslogin())){
				request.getSession().setAttribute("userInfo", pd);
				return "success";
			}else{
				return "sucnoauthor";
			}
		}else{
			return "fail";
		}
	}
}
