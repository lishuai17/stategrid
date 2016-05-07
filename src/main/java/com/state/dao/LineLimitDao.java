package com.state.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.state.po.LineLimitPo;

public interface LineLimitDao {

	/**
	 * 增加联络线限额
	 * @param lineLimitPo
	 */
	public void insertLineLimit(LineLimitPo lineLimitPo);

	/**
	 * 更新联络线限额
	 * @param lineLimitPo 
	 */
	public void updateLineLimit(LineLimitPo lineLimitPo);
	
	/**
	 * 根据参数查找联络线限额
	 * @param mcorhr
	 * @param mdate
	 * @param dtype
	 * @return 联络线限额
	 */
	public LineLimitPo getLineLimit(@Param("mcorhr")String mcorhr,
			@Param("mdate")String mdate,@Param("dtype")String dtype);
	
	/**
	 * 根据参数查找联络线限额列表
	 * @param mcorhr
	 * @param mdate
	 * @return 联络线限额列表
	 */
	public List<LineLimitPo> selectLineLimitList(@Param("mcorhr")String mcorhr,@Param("mdate")String mdate);
	
	
}
