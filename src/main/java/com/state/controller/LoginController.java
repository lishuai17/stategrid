package com.state.controller;


import java.util.Date;
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

import com.state.po.AreaPo;
import com.state.po.UserPo;
import com.state.service.AreaService;
import com.state.service.ILoginService;
import com.state.util.DateUtil;

@Controller
@RequestMapping("/login")
public class LoginController {
	//By：JinHang 2016年5月6日 20:13:46
	private static final transient Logger log = Logger
			.getLogger(DeclareController.class);
	
	@Autowired
	private ILoginService loginService;
	
	@Autowired
	private AreaService areaService;

	@RequestMapping(value = "/login")
	public String login(HttpServletRequest request, HttpServletResponse response) {
		log.info("跳转到登录页面");
		return "login";
	}
	
	@RequestMapping(value = "/register")
	public String register(HttpServletRequest request, HttpServletResponse response,Model model) {
		log.info("跳转到注册页面");
		List<AreaPo> allArea =areaService.getAllArea();
		model.addAttribute("allArea",allArea);
		return "register";
	}
	
	@RequestMapping(value = "/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		request.getSession().invalidate();
		log.info("退出登录");
		return "login";
	}
	
	@ResponseBody
	@RequestMapping(value = "/validLogin",method=RequestMethod.POST)
	public String validLogin(HttpServletRequest request,String user,String password) {
		log.info("校验并返回结果");
		//校验用户
		UserPo pd=loginService.judgeUser(user, password);
		if(pd!=null){
			List<Map<String,String>> bill = loginService.selectBill(pd.getMname());
			Date tomorrow=new Date((new Date()).getTime()+1000*60*60*24);
			String matchDate=DateUtil.format(tomorrow, "yyyy年MM月dd日");
			pd.setMatchDate(matchDate);
			if("1".equals(pd.getIslogin())){
				request.getSession().setAttribute("userInfo", pd);
				request.getSession().setAttribute("bill", bill);
				return "success";
			}else{
				return "sucnoauthor";
			}
		}else{
			return "fail";
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/containUser",method=RequestMethod.POST)
	public String containUser(String user) {
		log.info("注册时检查是否存在用户");
		//注册检查用户
		UserPo pd=loginService.containUser(user);
		if(pd!=null){
			if("0".equals(pd.getIslogin())){
				//未审批
				return "noapprove";
			}else{
				return "fail";//用户已存在
			}
		}
		return "success";
	}
	
	@ResponseBody
	@RequestMapping(value = "/registerUser",method=RequestMethod.POST)
	public String registerUser(String user,String password,String area,String sf) {
		log.info("注册用户");
		try{
			loginService.saveUser(user, password, area,sf);
		}catch (Exception e) {
			log.error("注册失败",e);
			return "fail";
		}
		return "success";
	}
	
}
