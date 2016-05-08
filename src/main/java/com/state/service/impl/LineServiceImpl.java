package com.state.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.state.dao.LineDefineDao;
import com.state.po.LineDefinePo;
import com.state.service.ILineService;

@Service
public class LineServiceImpl implements ILineService {

	@Autowired
	private LineDefineDao lineDefineDao;
	
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
	}
	
	/**
	 * 删除联络线
	 * @param mcorhr
	 */
	public void deleteLine(String mcorhr){
		lineDefineDao.deleteLineDefine(mcorhr);
	}
}
