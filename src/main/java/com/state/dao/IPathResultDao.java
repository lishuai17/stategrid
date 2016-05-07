package com.state.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.state.po.PathResultPo;

public interface IPathResultDao {

	/**
	 * 查询通道结果列表（不指定类型）
	 * @param mdate 日期
	 * @param mpath 通道名称
	 * @return 通道结果列表
	 */
	public List<PathResultPo> getPathResultList(@Param("mdate")String mdate,@Param("mpath")String mpath);
	
	/**
	 * 根据参数查询通道结果
	 * @param mdate 日期
	 * @param mpath 通道名称
	 * @param dtype 通道结果类型
	 * @return 通道结果
	 */
	public PathResultPo getPathResult(@Param("mdate")String mdate,@Param("mpath")String mpath,@Param("dtype")String dtype);
	
	/**
	 * 插入通道结果
	 * @param pathResultPo
	 */
	public void insertPathResult(PathResultPo pathResultPo);

	/**
	 * 更新通道结果
	 * @param pathResultPo
	 */
	public void updatePathResult(PathResultPo pathResultPo);
	
	/**
	 * 根据通道名称删除通道所有相关结果
	 * @param String 
	 */
	//public void deletePathResultByName(String  mpath);
	
	/**
	 * 删除通道结果
	 * @param String 
	 */
	//public void deletePathResult(String  mpath);
	
	
}
