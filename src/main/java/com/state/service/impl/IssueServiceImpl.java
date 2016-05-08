package com.state.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.state.dao.IssueDao;
import com.state.po.DeclarePo;
import com.state.po.ResultPo;
import com.state.service.IssueService;
import com.state.util.DateUtil;

@Service
@Transactional
public class IssueServiceImpl implements IssueService{
	
	@Autowired
	private IssueDao issueDao;


	/**
	 * 根据地区获取发布单列表
	 * @param area
	 * @return
	 */
	public List<DeclarePo> getResultNameList(String area){
		Date tomorrow=new Date((new Date()).getTime()+1000*60*60*24);
		return issueDao.selectSheetOfResultByArea(area, DateUtil.format(tomorrow, "yyyyMMdd"));
	}
	
	/**
	 * 根据申报单号、类型查找发布单
	 * @param dsheet
	 * @param dtype 
	 * @return
	 */
	public ResultPo getResultBySheetId(String dsheet, String dtype){
		return issueDao.getResultBySheetId(dsheet,dtype);
	}
	
}
