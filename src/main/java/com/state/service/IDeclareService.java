package com.state.service;

import com.state.po.DeclarePo;



public interface IDeclareService {
	
	/**
	 * 保存申报单及数据
	 * @param declare
	 */
	public void saveDeclare(DeclarePo declare);
	
	/**
	 * 是否存在申报单
	 * @param id
	 * @return
	 */
	public boolean existsDeclare(Integer id);
	
	/**
	 * 删除申报单
	 * @param id
	 */
	public void deleteDeclare(Integer id);

}
