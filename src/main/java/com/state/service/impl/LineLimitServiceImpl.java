package com.state.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.state.dao.LineLimitDao;
import com.state.po.LineLimitPo;
import com.state.service.LineLimitService;

@Service
@Transactional
public class LineLimitServiceImpl implements LineLimitService{
	
	@Autowired
	private LineLimitDao lineLimitDao;

	public void insertLineLimit(LineLimitPo lineLimitPo) {
		// TODO Auto-generated method stub
		lineLimitDao.insertLineLimit(lineLimitPo);
	}

	public void updateLineLimit(LineLimitPo lineLimitPo) {
		// TODO Auto-generated method stub
		lineLimitDao.updateLineLimit(lineLimitPo);
	}

	public LineLimitPo getLineLimit(String mcorhr, String mdate, String dtype) {
		// TODO Auto-generated method stub
		return lineLimitDao.getLineLimit(mcorhr, mdate, dtype);
	}

	public List<LineLimitPo> selectLineLimitList(String mcorhr, String mdate) {
		// TODO Auto-generated method stub
		return lineLimitDao.selectLineLimitList(mcorhr, mdate);
	}
	
	
}
