package com.state.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.state.dao.LineDefineDao;
import com.state.dao.LineLimitDao;
import com.state.po.LineDefinePo;
import com.state.po.LineLimitPo;
import com.state.service.ILineService;
import com.state.util.DateUtil;

@Service
public class LineServiceImpl implements ILineService {

	@Autowired
	private LineDefineDao lineDefineDao;
	@Autowired
	private LineLimitDao lineLimitDao;
	
	/**
	 * 获取所有的联络线定义数据
	 * @return
	 */
	public List<LineDefinePo> getAllLine(){
		return lineDefineDao.getAllLine();
	}

	/**
	 * 根据联络线名判断联络线是否存在
	 * @param mcorhr
	 * @return
	 */
	public boolean existsLine(String mcorhr){
		return lineDefineDao.countLineByMcorhr(mcorhr) > 0;
	}
	
	/**
	 * 添加联络线
	 * @param lineDefine
	 */
	public void addLine(LineDefinePo lineDefine){
		lineDefineDao.insertLineDefine(lineDefine);
		
		Date today = new Date();
		Date tomorrow=new Date(today.getTime()+1000*60*60*24);
		
		LineLimitPo lineLimit1=new LineLimitPo();
		lineLimit1.setMcorhr(lineDefine.getMcorhr());
		lineLimit1.setMdate(DateUtil.format(tomorrow, "yyyyMMdd"));
		lineLimit1.setDtype("正向限额");
		lineLimitDao.insertLineLimit(lineLimit1);
		
		LineLimitPo lineLimit2=new LineLimitPo();
		lineLimit2.setMcorhr(lineDefine.getMcorhr());
		lineLimit2.setMdate(DateUtil.format(tomorrow, "yyyyMMdd"));
		lineLimit2.setDtype("反向限额");
		lineLimitDao.insertLineLimit(lineLimit2);
		
		LineLimitPo lineLimit3=new LineLimitPo();
		lineLimit3.setMcorhr(lineDefine.getMcorhr());
		lineLimit3.setMdate(DateUtil.format(tomorrow, "yyyyMMdd"));
		lineLimit3.setDtype("计划值");
		lineLimitDao.insertLineLimit(lineLimit3);
		
	}
	
	/**
	 * 删除联络线
	 * @param mcorhr
	 */
	public void deleteLine(String mcorhr){
		lineDefineDao.deleteLineDefine(mcorhr);
	}
}
