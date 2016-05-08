package com.state.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSON;
import com.state.po.DeclarePo;
import com.state.po.ResultPo;
import com.state.po.UserPo;
import com.state.service.AreaService;
import com.state.service.IssueService;

@Controller
@RequestMapping("/issue")
public class IssueController {
	private static final transient Logger log = Logger
			.getLogger(IssueController.class);

	@Autowired
	private IssueService issueService;

	@Autowired
	private AreaService areaService;
	
	/**
	 * 跳转发布页面
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/init")
	public String init(Model model) {
		log.info("@ init issue ");
		model.addAttribute("areaList", JSON.toJSON(areaService.getAllArea()).toString());
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
		ResultPo r=issueService.getResultBySheetId(dsheet,dtype);
		return r;
	}
	
	
}
