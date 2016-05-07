package com.state.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.state.po.DeclarePo;
import com.state.po.ResultPo;

public interface IssueDao {

	/**
	 * 插入结果数据  
	 * @param ResultPo
	 * @return 影响行数
	 */
	public long insertResult(ResultPo resultPo);
	
	/**
	 * 删除指定日期的所有结果数据  
	 * @param 日期
	 * @return 影响行数
	 */
	public long deleteResultByDate(@Param("mdate")String mdate);
	
	
	/**
	 * 按地区查询结果中的所有单号
	 * @param param
	 * @return 所有单子名称
	 */
	public List<String> selectSheetOfResultByArea(@Param("area")String area,@Param("mdate")String mdate);
	
	/**
	 * 根据参数查询结果数据
	 * @param param
	 * @return
	 */
	public List<ResultPo> selectResultByParam(@Param("area")String area,@Param("mdate")String mdate,
			@Param("mname")String mname, @Param("dtype")String dtype);
}
