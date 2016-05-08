package com.state.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.state.po.LineDefinePo;
import com.state.po.LineLimitPo;
import com.state.po.TypePo;
import com.state.service.IDeclareService;
import com.state.service.ILineService;
import com.state.service.LineLimitService;

@Controller
@RequestMapping("/lineLimit")
public class LineLimitController {
	private static final transient Logger log = Logger
			.getLogger(LineLimitController.class);

	@Autowired
	private LineLimitService lineLimitService;
	
	@Autowired
	private IDeclareService declareService;
	
	@Autowired
	private ILineService lineService;
	
	/**
	 * 跳转联络线限额
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/init")
	public String init(Model model) {
		log.info("@ init limitLineR ");
		TypePo timeType=declareService.getTimeType();
		timeType.countType();
		model.addAttribute("timeType", JSON.toJSON(timeType).toString());
		return "limitLine";
	}
	
	/**
	 * 查询所有的联络线
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getAllLine")
	public List<LineDefinePo> getAllLine(HttpServletRequest request,HttpServletResponse response) {
		log.info("@ getAllLine ");
		
		return lineService.getAllLine();
	}
	
	/**
	 * 查询指定类型的联络线限额
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getLineLimit")
	public LineLimitPo getLineLimit(String mcorhr,String dtype) {
		log.info("@ getLineLimit");
		
		return lineLimitService.selectLineLimitList(mcorhr, dtype);
	}
	
	/**
	 * 更新联络线
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/updateLineLimit")
	public String updateLineLimit(String lineLimitStr) {
		log.info("@ updateLineLimit ");
		JSONObject bean = com.alibaba.fastjson.JSONObject.parseObject(lineLimitStr);
		LineLimitPo lineLimit = JSONObject.toJavaObject(bean, LineLimitPo.class);
		lineLimitService.updateLineLimit(lineLimit);
		return "success";
	}

}
