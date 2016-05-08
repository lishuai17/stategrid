package com.state.service;

import java.util.List;

import com.state.po.ResultPo;
import com.state.vo.ResultNameVo;



/**
 * 发布service
 * @author 帅
 *
 */
public interface IssueService {
	
	/**
	 * 根据地区获取发布单列表
	 * @param area
	 * @return
	 */
	public List<ResultNameVo> getResultNameList(String area);

	/**
	 * 根据申报单号、类型查找发布单
	 * @param dsheet
	 * @param dtype 
	 * @return
	 */
	public ResultPo getResultBySheetId(String dsheet, String dtype);
	
}