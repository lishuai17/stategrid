package com.state.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.state.dao.IDeclareDataDao;
import com.state.dao.IssueDao;
import com.state.po.DeclareDataPo;
import com.state.po.DeclarePo;
import com.state.service.IssueService;
import com.state.util.DateUtil;

@Service
@Transactional
public class IssueServiceImpl implements IssueService{
	
	@Autowired
	private IssueDao IssueDao;
	
	@Autowired
	private IDeclareDataDao declareDataDao;

	public void saveDeclare(DeclarePo declare) {
		
		IssueDao.insertDeclare(declare);
		
		List<DeclareDataPo> declareDatas = declare.getDeclareDatas();
		for (DeclareDataPo declareDataPo : declareDatas) {
			declareDataPo.setSheetId(declare.getId());
			declareDataDao.insertDeclData(declareDataPo);
		}
	}

	public boolean existsDeclare(Integer id) {

		return IssueDao.countDeclareById(id) > 0;
	}

	public void deleteDeclare(Integer id) {
		
		declareDataDao.deleteDeclareData(id);
		
		IssueDao.deleteDeclare(id);
	}

	public List<DeclarePo> getDeclares(String area,String date) {
		if(null == date){
			Date today = new Date();
			date = DateUtil.format(new Date(today.getTime()+1000*60*60*24), "yyyyMMdd");
		}
		return IssueDao.selectDeclareByParam(area, date, null);
	}

	public DeclareDataPo getDeclareData(Integer id, String dtype) {
		// TODO Auto-generated method stub
//		declareDataDao.getDeclDataById(param)
		return null;
	}

}
