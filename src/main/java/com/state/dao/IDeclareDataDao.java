package com.state.dao;

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
	public void insertDeclData(DeclareDataPo declareDataPo);
	
	
	/**
	 * 根据参数查找申请主表
	 * @param declareDataDao
	 */
	public DeclareDataPo getDeclDataById(Map<String,String> param);
	
}
