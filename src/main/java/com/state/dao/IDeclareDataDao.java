package com.state.dao;

import java.util.List;
import java.util.Map;

import com.state.po.DeclareDataPo;

public interface IDeclareDataDao {
	/**
	 * 根据申报主表ID删除申报子表数据
	 * @param declareId
	 */
	public void deleteDeclareData(Integer declareId);
	
	/**
	 * 增加申请主表
	 * @param declareDataDao
	 */
	public void insertDeclData(DeclareDataPo declareData);
	
	
	/**
	 * 根据参数查找申请子表
	 * @param declareDataDao
	 */
	public List<DeclareDataPo> getDeclDataById(Map<String,String> param);
	
}
