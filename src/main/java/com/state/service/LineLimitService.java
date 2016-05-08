package com.state.service;

import java.util.List;

import com.state.po.LineLimitPo;
import com.state.po.PathDefinePo;



/**
 * 联络线service
 * @author 帅
 *
 */
public interface LineLimitService {
	
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
	public LineLimitPo getLineLimit(String mcorhr,
			String mdate,String dtype);
	
	/**
	 * 根据参数查找联络线限额列表
	 * @param mcorhr
	 * @param mdate
	 * @return 联络线限额列表
	 */
	public List<LineLimitPo> selectLineLimitList(String mcorhr,String mdate);

	

}
