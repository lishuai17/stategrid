package com.state.service;

import java.util.List;

import com.state.po.DeclareDataPo;
import com.state.po.DeclarePo;



/**
 * 申报service
 * @author 帅
 *
 */
public interface IssueService {
	
	/**
	 * 查询所有单子
	 * @param area
	 * @return
	 */
	public List<DeclarePo> getDeclares(String area,String date);
	
	/**
	 * 查询申报数据
	 * @param id
	 * @param dtype
	 * @return
	 */
	public DeclareDataPo getDeclareData(Integer id,String dtype);
	
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
