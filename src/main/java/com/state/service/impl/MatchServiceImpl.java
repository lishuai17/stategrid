package com.state.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.state.dao.IPathResultDao;
import com.state.dao.IssueDao;
import com.state.dao.MatchDao;
import com.state.po.PathResultPo;
import com.state.service.MatchService;
import com.state.util.DateUtil;

@Service
@Transactional
public class MatchServiceImpl implements MatchService{
	
	@Autowired
	private MatchDao matchDao;
	
	@Autowired
	private IPathResultDao pathResultDao;

	@Autowired
	private IssueDao issueDao;

	/**
	 * 根据通道名、类型查询通道结果
	 * @param mpath
	 * @param dtype
	 * @return
	 */
	public PathResultPo getPathResult(String mpath, String dtype){
		Date tomorrow=new Date((new Date()).getTime()+1000*60*60*24);
		return pathResultDao.getPathResult(DateUtil.format(tomorrow, "yyyyMMdd"), mpath, dtype);
	}
	
	/**
	 * 一键发布
	 */
	public void issue(){
		Date tomorrow=new Date((new Date()).getTime()+1000*60*60*24);
		pathResultDao.updatePrint(DateUtil.format(tomorrow, "yyyyMMdd"),"1");
		issueDao.updatePrint(DateUtil.format(tomorrow, "yyyyMMdd"),"1");
	}
}
