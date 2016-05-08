package com.state.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.state.po.LineDefinePo;
import com.state.po.PathDefinePo;
import com.state.service.ILineService;
import com.state.service.IPathService;

/**
 * 通道controller
 * @author 帅
 *
 */
@Controller
@RequestMapping("/path")
public class PathController {
	private static final transient Logger log = Logger
			.getLogger(PathController.class);

	@Autowired
	private ILineService lineService;
	
	@Autowired
	private IPathService pathService;
	
	/**
	 * 跳转页面
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/init")
	public String init(HttpServletRequest request,HttpServletResponse response) {
		log.info("@ init limitLine ");
		
		return "limitLine";
	}
	
	/**
	 * 查询所有的通道
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getAllPath")
	public List<PathDefinePo> getAllPath(HttpServletRequest request,HttpServletResponse response) {
		log.info("@ init getAllPath ");
		
		return pathService.getAllPath();
	}
	
	/**
	 * 查询所有的通道
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getAllLine")
	public List<LineDefinePo> getAllLine(HttpServletRequest request,HttpServletResponse response) {
		log.info("@ init getAllLine ");
		
		return lineService.getAllLine();
	}
	
	/**
	 * 添加通道
	 * @param pathDefine
	 * @return
	 */
	@RequestMapping(value = "/addPath")
	public String addPath(PathDefinePo pathDefine){
		
		if(pathService.existsPath(pathDefine.getMpath())){
			return "通道已经存在";
		}
		try {
			pathService.addPath(pathDefine);
		} catch (Exception e) {
			log.error("add pathDefine fail !",e);
			return "fail";
		}
		return "success";
	}
	
	/**
	 * 添加联络线
	 * @param lineDefine
	 * @return
	 */
	@RequestMapping(value = "/addLine")
	public String addLine(LineDefinePo lineDefine){
		
		if(lineService.existsLine(lineDefine.getMcorhr())){
			return "联络线已经存在";
		}
		try {
			lineService.addLine(lineDefine);
		} catch (Exception e) {
			log.error("add lineDefine fail !",e);
			return "fail";
		}
		return "success";
	}
	
	/**
	 * 删除通道
	 * @param mpath
	 * @return
	 */
	@RequestMapping(value = "/deletePath")
	public String deletePath(String mpath){
		
		if(!pathService.existsPath(mpath)){
			return "通道不存在";
		}
		try {
			pathService.deletePath(mpath);
		} catch (Exception e) {
			log.error("delete pathDefine fail !",e);
			return "fail";
		}
		return "success";
	}
	
	/**
	 * 删除联络线
	 * @param mcorhr
	 * @return
	 */
	@RequestMapping(value = "/deleteLine")
	public String deleteLine(String mcorhr){
		
		if(!lineService.existsLine(mcorhr)){
			return "联络线不存在";
		}
		try {
			lineService.deleteLine(mcorhr);
		} catch (Exception e) {
			log.error("delete lineDefine fail !",e);
			return "fail";
		}
		return "success";
	}
	

}
