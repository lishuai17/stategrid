package com.state.service;

import com.state.po.PathResultPo;



/**
 * 申报service
 * @author 帅
 *
 */
public interface MatchService {
	
	/**
	 * 根据通道名、类型查询通道结果
	 * @param mpath
	 * @param dtype
	 * @return
	 */
	public PathResultPo getPathResult(String mpath, String dtype);

	/**
	 * 一键发布
	 */
	public void issue();

}
