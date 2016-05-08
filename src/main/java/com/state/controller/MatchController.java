package com.state.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.state.po.PathDefinePo;
import com.state.po.PathResultPo;
import com.state.service.IPathService;
import com.state.service.MatchService;

/**
 * 撮合
 * 
 * @author 帅
 *
 */
@Controller
@RequestMapping("/match")
public class MatchController {
	private static final transient Logger log = Logger
			.getLogger(MatchController.class);

	@Autowired
	private MatchService matchService;

	@Autowired
	private IPathService pathService;

	/**
	 * 跳转撮合页面
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/init")
	public String init(HttpServletRequest request, HttpServletResponse response) {
		log.info("@ init match ");

		return "match";
	}

	/**
	 * 查询所有的通道
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getAllPath")
	public List<PathDefinePo> getAllPath(HttpServletRequest request,
			HttpServletResponse response) {
		log.info("@getAllPath ");

		return pathService.getAllPath();
	}

	/**
	 * 按通道名、类型查询通道结果
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getPathResult")
	public PathResultPo getPathResult(String mpath, String dtype) {
		log.info("@ getPathResult ");

		return matchService.getPathResult(mpath, dtype);
	}

	/**
	 * 撮合
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/matchData")
	public String match() {

		return "success";
	}

	/**
	 * 发布
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/issue")
	public String issue() {
		matchService.issue();
		return "success";
	}

}
