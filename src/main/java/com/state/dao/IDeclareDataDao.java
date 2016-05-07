package com.state.dao;

public interface IDeclareDataDao {
	/**
	 * 根据申报主表ID删除申报子表数据
	 * @param declareId
	 */
	public void deleteDeclareData(Integer declareId);
}
