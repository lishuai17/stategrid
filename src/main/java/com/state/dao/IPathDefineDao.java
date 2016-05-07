package com.state.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.state.po.DeclarePo;
import com.state.po.PathDefinePo;

public interface IPathDefineDao {

	/**
	 * 查询所有的通道
	 * @return 通道列表
	 */
	public List<PathDefinePo> selectPathALL();

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
	public int countDeclareById(long id);
	
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
