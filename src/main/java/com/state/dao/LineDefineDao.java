package com.state.dao;

import java.util.List;

import com.state.po.LineDefinePo;

public interface LineDefineDao {

	/**
	 * 根据联络线名查询联络线
	 * @param lineLimitPo
	 */
	public LineDefinePo getLineDefine(String mcorhr);
	
	/**
	 * 获取所有的联络线
	 * @return
	 */
	public List<LineDefinePo> getAllLine();
	
	/**
	 * 根据联络线名查询联络线个数
	 * @param mcorhr
	 * @return
	 */
	public int countLineByMcorhr(String mcorhr);
	
	/**
	 * 插入联络线
	 * @param lineDefine
	 */
	public void insertLineDefine(LineDefinePo lineDefine);
	
	/**
	 * 删除联络线
	 * @param mcorhr
	 */
	public void deleteLineDefine(String mcorhr);

	
}
