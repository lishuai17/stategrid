package com.state.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.state.po.DeclarePo;
import com.state.po.ResultPo;

public interface IssueDao {

//	/**
//	 * 根据ID查找结果数据是否存在
//	 * @param id
//	 * @return
//	 */
//	public int countResultById(long id);
	
	
	/**
	 * 插入结果数据  
	 * @param ResultPo
	 * @return 影响行数
	 */
	public long insertResult(ResultPo resultPo);
	
	
	/**
	 * 按地区查询结果中的所有单号
	 * @param param
	 * @return
	 */
	public List<ResultPo> selectSheetOfResultByArea(@Param("area")String area,@Param("mdate")String mdate);
	
	/**
	 * 根据参数查询结果数据
	 * @param param
	 * @return
	 */
	public List<ResultPo> selectResultByParam(@Param("area")String area,@Param("mdate")String mdate,@Param("mname")String mname);
}
