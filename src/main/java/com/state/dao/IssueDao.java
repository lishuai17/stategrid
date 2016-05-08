package com.state.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.state.po.ResultPo;
import com.state.vo.ResultNameVo;

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
	public List<ResultNameVo> selectSheetOfResultByArea(@Param("area")String area,@Param("mdate")String mdate);
	
	/**
	 * 根据参数查询结果数据
	 * @param param
	 * @return
	 */
	public List<ResultPo> selectResultByParam(@Param("area")String area,@Param("mdate")String mdate,
			@Param("mname")String mname, @Param("dtype")String dtype);

	/**
	 * 按照日期更新成交结果发布标志位
	 * @param mdate
	 * @param dprint
	 */
	public void updatePrint(@Param("mdate")String mdate, @Param("dprint")String dprint);

	/**
	 * 根据申报单号、类型查找发布单
	 * @param dsheet
	 * @return
	 */
	public ResultPo getResultBySheetId(@Param("dsheet")String dsheet, @Param("dtype")String dtype);
	
}
