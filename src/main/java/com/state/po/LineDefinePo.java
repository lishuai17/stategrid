package com.state.po;

import org.apache.ibatis.type.Alias;

/**
 * 联络线定义表
 * 
 * @author jh
 *
 */
@SuppressWarnings("serial")
@Alias("LineDefinePo")
public class LineDefinePo extends BasePo {
	// 联络线名
	private String mcorhr;
	// 首端
	private String startArea;
	// 末端
	private String endArea;

	public String getMcorhr() {
		return mcorhr;
	}

	public void setMcorhr(String mcorhr) {
		this.mcorhr = mcorhr;
	}

	public String getStartArea() {
		return startArea;
	}

	public void setStartArea(String startArea) {
		this.startArea = startArea;
	}

	public String getEndArea() {
		return endArea;
	}

	public void setEndArea(String endArea) {
		this.endArea = endArea;
	}

}
