package com.state.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.state.po.DeclarePo;

public interface IDeclareDao {

	/**
	 * 根据ID删除申报主表
	 * @param id
	 */
	public void deleteDeclare(Long id);

	/**
	 * 插入申报主表  
	 * @param declarePo
	 * @return 影响行数，取ID使用declarePo.getId()方法
	 */
	public long insertDeclare(DeclarePo declarePo);
	
	/**
	 * 根据ID查找申报主表是否存在
	 * @param id
	 * @return
	 */
	public int countDeclareById(Long id);
	
	/**
	 * 更新申报主表
	 * @param id
	 * @return
	 */
	public void updateDeclare (DeclarePo declarePo);
	
	/**
	 * 根据参数查询申报主表
	 * @param param
	 * @return
	 */
	public List<DeclarePo> selectDeclareByParam(@Param("area")String area,@Param("mdate")String mdate
			,@Param("mname")String mname);
}
