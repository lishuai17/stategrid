package com.state.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.state.po.DeclarePo;
import com.state.po.ResultPo;
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
	 * 跳转发布页面
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/init")
	public String init(HttpServletRequest request,HttpServletResponse response) {
		log.info("@ init issue ");
		
		return "issue";
	}

	/**
	 * 获取发布单列表
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/getResultList", method = RequestMethod.POST)
	public List<DeclarePo> getResultList(HttpServletRequest request,String area){
		
		if(area==null||"".equals(area)){
			UserPo user = (UserPo)request.getSession().getAttribute("userInfo");
			area=user.getArea();
		}
		return issueService.getResultNameList(area);
	}
	
	/**
	 * 根据申报单号、类型查找发布单
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/getResult", method = RequestMethod.POST)
	public ResultPo getResult(String dsheet,String dtype){
		
		return issueService.getResultBySheetId(dsheet,dtype);
	}
	
	
}
