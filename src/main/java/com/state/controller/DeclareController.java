package com.state.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.state.po.DeclareDataPo;
import com.state.po.DeclarePo;
import com.state.po.UserPo;
import com.state.service.IDeclareService;

@Controller
@RequestMapping("/declare")
public class DeclareController {
	private static final transient Logger log = Logger
			.getLogger(DeclareController.class);

	@Autowired
	private IDeclareService declareService;
	
	//跳转申报页面
	@RequestMapping(value = "/init", method = RequestMethod.POST)
	public String init(HttpServletRequest request,HttpServletResponse response) {
		log.info("@ init declare ");
		
		return "declare";
	}

	/**
	 * 获取所有单子
	 * @param request
	 * @param response
	 * @return
	 */
	public List<DeclarePo> getDeclare(HttpServletRequest request,HttpServletResponse response){
		UserPo user = (UserPo)request.getSession().getAttribute("userInfo");
//		Date date=new Date();
		
		
		return null; //declareService.getDeclare(declare);
	}
	
	/**
	 * 获取申报数据
	 * @param request
	 * @param response
	 * @param id 单子id
	 * @param type 申报类型 全天，高峰，低谷
	 * @return
	 */
	public DeclareDataPo getDeclareData(HttpServletRequest request,HttpServletResponse response,Integer id,String type){
		
//		Date date=new Date();
		
		
		return null; //declareService.getDeclare(declare);
	}
	
	//增加申报
	@ResponseBody
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addDeclare( DeclarePo declare) {
		log.info("@ add declare ");
		if(null == declare){
			return "申报单为空";
		}
		try {
			declareService.saveDeclare(declare);
		} catch (Exception e) {
			log.error("add declare fail !",e);
			return "fail";
		}
		return "success";
	}
	
	/**
	 * 删除申报
	 * @param classCode
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String deleteDeclare(Integer id) {
		if(!declareService.existsDeclare(id)){
			return "申报单不存在";
		}
		try {
			declareService.deleteDeclare(id);
		} catch (Exception e) {
			log.error("delete declare fail !",e);
			return "fail";
		}
		return "success";
	}
	
	/**
	 * 更改申报
	 * @param classCode
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateDeclare(String classCode, Model model, HttpServletRequest request,
			HttpServletResponse response) {
		return "";
	}
}
