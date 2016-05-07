package com.state.dao;

import com.state.po.LineDefinePo;

public interface LineDefineDao {

	/**
	 * 根据联络线名查询联络线
	 * @param lineLimitPo
	 */
	public LineDefinePo getLineDefine(String mcorhr);

	
}
