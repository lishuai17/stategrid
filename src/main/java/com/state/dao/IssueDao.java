package com.state.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.state.po.DeclarePo;

public interface IssueDao {

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
	public List<DeclarePo> selectDeclareByParam(@Param("area")String area,@Param("mdate")String mdate
			,@Param("mname")String mname);
}
