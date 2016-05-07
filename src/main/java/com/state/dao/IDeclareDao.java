package com.state.dao;

import java.util.List;
import java.util.Map;

import com.state.po.DeclarePo;

public interface IDeclareDao {

	/**
	 * 根据ID删除申报主表
	 * @param id
	 */
	public void deleteDeclare(Integer id);

	/**
	 * 插入申报主表
	 * @param declarePo
	 */
	public void insertDeclare(DeclarePo declarePo);
	
	/**
	 * 根据ID查找申报主表是否存在
	 * @param id
	 * @return
	 */
	public int countDeclareById(long id);
	
	/**
	 * 根据参数查询申报主表
	 * @param param
	 * @return
	 */
	public List<DeclarePo> selectDeclareByParam(Map<String,String> param);
}
