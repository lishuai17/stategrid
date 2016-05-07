package com.state.service;

import java.util.List;

import com.state.po.DeclarePo;



/**
 * 发布service
 * @author 帅
 *
 */
public interface IssueService {
	
	/**
	 * 根据ID查找申报主表是否存在
	 * @param id
	 * @return
	 */
	public int countDeclareById(long id);
	
	/**
	 * 根据参数查询申报主表
	 * @param param
	 * @return
	 */
	public List<DeclarePo> selectDeclareByParam(String area,String mdate
			,String mname);}
