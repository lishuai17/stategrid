package com.state.po;

import org.apache.ibatis.type.Alias;

/**
 * 地区表
 * 
 * @author jh
 *
 */
@Alias("AreaPo")
public class AreaPo extends BasePo {
	private static final long serialVersionUID = 1L;
	// 地区
	private String area;
	// 简称
	private String dcode;
	// 类型
	private String dtype;
	// 备注
	private String descr;

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getDcode() {
		return dcode;
	}

	public void setDcode(String dcode) {
		this.dcode = dcode;
	}

	public String getDtype() {
		return dtype;
	}

	public void setDtype(String dtype) {
		this.dtype = dtype;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

}
