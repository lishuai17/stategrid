package com.state.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.state.dao.IssueDao;
import com.state.po.DeclarePo;
import com.state.service.IssueService;

@Service
@Transactional
public class IssueServiceImpl implements IssueService{
	
	@Autowired
	private IssueDao issueDao;

	public int countDeclareById(long id) {
		// TODO Auto-generated method stub
		return issueDao.countDeclareById(id);
	}

	public List<DeclarePo> selectDeclareByParam(String area, String mdate,
			String mname) {
		// TODO Auto-generated method stub
		return issueDao.selectDeclareByParam(area, mdate, mname);
	}
	
	
}
