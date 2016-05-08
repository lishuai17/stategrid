package com.state.service;

import java.util.List;

import com.state.po.PathDefinePo;

public interface IPathService {

	/**
	 * 获取所有的通道定义数据
	 * @return
	 */
	public List<PathDefinePo> getAllPath();

	/**
	 * 根据通道名判断通道是否存在
	 * @param mpath
	 * @return
	 */
	public boolean existsPath(String mpath);

	/**
	 * 添加通道定义
	 * @param pathDefine
	 */
	public void addPath(PathDefinePo pathDefine);
	
	/**
	 * 删除通道
	 * @param mpath
	 */
	public void deletePath(String mpath);

	
	
}
