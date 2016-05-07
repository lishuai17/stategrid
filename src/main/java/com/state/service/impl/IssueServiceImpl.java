package com.state.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.state.dao.IssueDao;
import com.state.po.ResultPo;
import com.state.service.IssueService;

@Service
@Transactional
public class IssueServiceImpl implements IssueService{
	
	@Autowired
	private IssueDao issueDao;


	public List<ResultPo> selectDeclareByParam(String area, String mdate,
			String mname) {
		// TODO Auto-generated method stub
		String dtype = null;
		return issueDao.selectResultByParam(area, mdate, mname,dtype);
	}


	public long insertResult(ResultPo resultPo) {
		// TODO Auto-generated method stub
		return 0;
	}


	public long deleteResultByDate(String mdate) {
		// TODO Auto-generated method stub
		return 0;
	}


	public List<String> selectSheetOfResultByArea(String area, String mdate) {
		// TODO Auto-generated method stub
		return null;
	}


	public List<ResultPo> selectResultByParam(String area, String mdate,
			String mname, String dtype) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
