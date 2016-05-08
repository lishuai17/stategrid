package com.state.service;

import java.util.List;

import com.state.po.DeclareDataPo;
import com.state.po.DeclarePo;
import com.state.po.TypePo;
import com.state.po.UserPo;



/**
 * 申报service
 * @author 帅
 *
 */
public interface IDeclareService {
	
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
	public DeclareDataPo getDeclareData(Long id,String dtype);
	
	/**
	 * 新增申报单及数据
	 * @param user 用户
	 */
	public void createNewDeclare(UserPo user);
	
	/**
	 * 是否存在申报单
	 * @param id
	 * @return
	 */
	public boolean existsDeclare(Long id);
	
	/**
	 * 删除申报单
	 * @param id
	 */
	public void deleteDeclare(Long id);
	
	/**
	 * 更新申报主表
	 * @param id
	 * @return
	 */
	public void updateDeclare (DeclarePo declarePo);

	/**
	 * 查询时段类型
	 * @return
	 */
	public TypePo getTimeType();

}
