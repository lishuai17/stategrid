package com.state.po;

import org.apache.ibatis.type.Alias;

/**
 * 用户表
 */
@SuppressWarnings("serial")
@Alias("UserPo")
public class UserPo extends BasePo {
	/**
	 * 用户名
	 */
	private String mname;

	/**
	 * 地区
	 */
	private String area;

	/**
	 * 密码
	 */
	private String mkey;

	/**
	 * 属性
	 */
	private String dtype;

	/**
	 * 备注
	 */
	private String descr;

	/**
	 * 登录时间
	 */
	private String intime;

	/**
	 * 登出时间
	 */
	private String outtime;
	
	/**
	 * 登出时间
	 */
	private String drole;
	
	/**
	 * 是否允许登录
	 */
	private String islogin;
	
	/**
	 * 交易日期
	 */
	private String matchDate;

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getMkey() {
		return mkey;
	}

	public void setMkey(String mkey) {
		this.mkey = mkey;
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

	public String getIntime() {
		return intime;
	}

	public void setIntime(String intime) {
		this.intime = intime;
	}

	public String getOuttime() {
		return outtime;
	}

	public void setOuttime(String outtime) {
		this.outtime = outtime;
	}

	public String getIslogin() {
		return islogin;
	}

	public void setIslogin(String islogin) {
		this.islogin = islogin;
	}

	public String getDrole() {
		return drole;
	}

	public void setDrole(String drole) {
		this.drole = drole;
	}

	public String getMatchDate() {
		return matchDate;
	}

	public void setMatchDate(String matchDate) {
		this.matchDate = matchDate;
	}
	
	

}
