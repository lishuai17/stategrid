package com.state.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.state.po.DeclarePo;
import com.state.service.IDeclareService;

@Controller
@RequestMapping("/declare")
public class DeclareController {
	private static final transient Logger log = Logger
			.getLogger(DeclareController.class);

	@Autowired
	private IDeclareService declareService;
	
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
