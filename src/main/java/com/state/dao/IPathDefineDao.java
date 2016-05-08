package com.state.dao;

import java.util.List;

import com.state.po.PathDefinePo;

public interface IPathDefineDao {

	/**
	 * 查询所有的通道
	 * @return 通道列表
	 */
	public List<PathDefinePo> selectPathALL();
	
	/**
	 * 根据通道名查询通道
	 * @param mpath
	 * @return 通道
	 */
	public PathDefinePo getPathByName(String mpath);

	/**
	 * 更新通道定义
	 * @param pathDefinePo
	 */
	public void updatePathDefine(PathDefinePo pathDefinePo);
	
	/**
	 * 删除通道定义
	 * @param mpath
	 */
	public void deletePathDefine(String mpath);
	
	/**
	 * 插入通道定义
	 * @param pathDefinePo
	 */
	public void insertPathDefine(PathDefinePo pathDefinePo);

	/**
	 * 根据通道名称查询通道个数
	 * @param mpath
	 * @return
	 */
	public int countPathByName(String mpath);
	
}
