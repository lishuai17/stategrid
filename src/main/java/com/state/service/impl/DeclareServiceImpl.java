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

	public boolean existsDeclare(Long id) {

		return declareDao.countDeclareById(id) > 0;
	}

	public void deleteDeclare(Long id) {
		
		declareDataDao.deleteDeclareData(id);
		
		declareDao.deleteDeclare(id);
	}

	public List<DeclarePo> getDeclares(String area,String date) {
		if(null == date){
			Date today = new Date();
			date = DateUtil.format(new Date(today.getTime()+1000*60*60*24), "yyyyMMdd");
		}
		return declareDao.selectDeclareByParam(area, date, null);
	}

	public DeclareDataPo getDeclareData(Long id, String dtype) {
		List<DeclareDataPo> list=declareDataDao.getDeclDataById(id,dtype);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	public void updateDeclare(DeclarePo declarePo) {
		
		declareDao.updateDeclare(declarePo);
		
		List<DeclareDataPo> declareDatas = declarePo.getDeclareDatas();
		for (DeclareDataPo declareDataPo : declareDatas) {
			declareDataDao.updateDeclData(declareDataPo);
		}
	}

}
