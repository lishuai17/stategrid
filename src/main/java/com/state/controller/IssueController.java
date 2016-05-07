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
import com.state.service.IssueService;

@Controller
@RequestMapping("/issue")
public class IssueController {
	private static final transient Logger log = Logger
			.getLogger(IssueController.class);

	@Autowired
	private IssueService issueService;
	
	/**
	 * 跳转申报页面
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/init")
	public String init(HttpServletRequest request,HttpServletResponse response) {
		log.info("@ init declare ");
		
		return "issue";
	}

	/**
	 * 获取申报单子列表
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/getDeclareList", method = RequestMethod.POST)
	public List<DeclarePo> getDeclare(HttpServletRequest request,HttpServletResponse response,String date){
		UserPo user = (UserPo)request.getSession().getAttribute("userInfo");
		
		return issueService.selectDeclareByParam(user.getArea(),(StringUtils.hasText(date) ? date : null),null);
	}
	
	
}
