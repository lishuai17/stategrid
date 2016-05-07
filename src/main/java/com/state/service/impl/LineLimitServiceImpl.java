package com.state.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.state.dao.IDeclareDao;
import com.state.dao.IDeclareDataDao;
import com.state.dao.LineLimitDao;
import com.state.po.DeclareDataPo;
import com.state.po.DeclarePo;
import com.state.service.IDeclareService;
import com.state.service.LineLimitService;
import com.state.util.DateUtil;

@Service
@Transactional
public class LineLimitServiceImpl implements LineLimitService{
	
	@Autowired
	private LineLimitDao lineLimieDao;
	
	@Autowired
	private IDeclareDataDao declareDataDao;

	public void saveDeclare(DeclarePo declare) {
		
		lineLimieDao.insertDeclare(declare);
		
		List<DeclareDataPo> declareDatas = declare.getDeclareDatas();
		for (DeclareDataPo declareDataPo : declareDatas) {
			declareDataPo.setSheetId(declare.getId());
			declareDataDao.insertDeclData(declareDataPo);
		}
	}

	public boolean existsDeclare(Integer id) {

		return lineLimieDao.countDeclareById(id) > 0;
	}

	public void deleteDeclare(Integer id) {
		
		declareDataDao.deleteDeclareData(id);
		
		lineLimieDao.deleteDeclare(id);
	}

	public List<DeclarePo> getDeclares(String area,String date) {
		if(null == date){
			Date today = new Date();
			date = DateUtil.format(new Date(today.getTime()+1000*60*60*24), "yyyyMMdd");
		}
		return lineLimieDao.selectDeclareByParam(area, date, null);
	}

	public DeclareDataPo getDeclareData(Integer id, String dtype) {
		// TODO Auto-generated method stub
//		declareDataDao.getDeclDataById(param)
		return null;
	}

}
