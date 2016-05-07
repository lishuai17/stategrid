package com.state.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.state.dao.IDeclareDao;
import com.state.dao.IDeclareDataDao;
import com.state.po.DeclareDataPo;
import com.state.po.DeclarePo;
import com.state.service.IDeclareService;
import com.state.util.DateUtil;

@Service
@Transactional
public class DeclareServiceImpl implements IDeclareService{
	
	@Autowired
	private IDeclareDao declareDao;
	
	@Autowired
	private IDeclareDataDao declareDataDao;

	public void saveDeclare(DeclarePo declare) {
		
		declareDao.insertDeclare(declare);
		
		List<DeclareDataPo> declareDatas = declare.getDeclareDatas();
		for (DeclareDataPo declareDataPo : declareDatas) {
			declareDataPo.setSheetId(declare.getId());
			declareDataDao.insertDeclData(declareDataPo);
		}
	}

	public boolean existsDeclare(Integer id) {

		return declareDao.countDeclareById(id) > 0;
	}

	public void deleteDeclare(Integer id) {
		
		declareDataDao.deleteDeclareData(id);
		
		declareDao.deleteDeclare(id);
	}

	public List<DeclarePo> getDeclares(String area,String date) {
		if(null == date){
			date = DateUtil.format(new Date(), "yyyyMMdd");
		}
		return declareDao.selectDeclareByParam(area, date, null);
	}

	public DeclareDataPo getDeclareData(Integer id, String dtype) {
		// TODO Auto-generated method stub
//		declareDataDao.getDeclDataById(param)
		return null;
	}

}
