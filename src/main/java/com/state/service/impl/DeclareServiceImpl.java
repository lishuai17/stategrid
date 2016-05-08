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
import com.state.po.UserPo;
import com.state.service.IDeclareService;
import com.state.util.DateUtil;

@Service
@Transactional
public class DeclareServiceImpl implements IDeclareService{
	
	@Autowired
	private IDeclareDao declareDao;
	
	@Autowired
	private IDeclareDataDao declareDataDao;
	
	/**
	 * 新增申报单及数据
	 * @param user 用户
	 */
	public void createNewDeclare(UserPo user){
		Date today = new Date();
		Date tomorrow=new Date(today.getTime()+1000*60*60*24);
		DeclarePo declare=new DeclarePo();
		declare.setSheetName("未命名");
		declare.setMdate(DateUtil.format(tomorrow, "yyyyMMdd"));
		declare.setArea(user.getArea());
		declare.setDtime(DateUtil.format(tomorrow, "yyyy-MM-dd HH:mm:ss"));
		declare.setMname(user.getMname());
		declare.setDrloe(user.getDrole());
		declareDao.insertDeclare(declare);
		
		DeclareDataPo data1a=new DeclareDataPo();
		data1a.setId(declare.getId());
		data1a.setDtype("1a");
		declareDataDao.insertDeclData(data1a);
		
		DeclareDataPo data2a=new DeclareDataPo();
		data2a.setId(declare.getId());
		data2a.setDtype("2a");
		declareDataDao.insertDeclData(data2a);
		
		DeclareDataPo data3a=new DeclareDataPo();
		data3a.setId(declare.getId());
		data3a.setDtype("3a");
		declareDataDao.insertDeclData(data3a);
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
