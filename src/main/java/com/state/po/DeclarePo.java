package com.state.po;

import java.util.List;

import org.apache.ibatis.type.Alias;

/**
 * 申报单子
 * @author 帅
 *
 */
@SuppressWarnings("serial")
@Alias("DeclarePo")
public class DeclarePo extends BasePo {
	
	//唯一值
	private int id;
	// 日期
	private double mdate;
	// 地区
	private String area;
	// 申报时间
	private String dtime;
	// 用户名
	private String mname;
	// 买卖类型
	private String drloe;
	// 申报单号
	private String dsheet;
	
	//申报数据
	private List<DeclareDataPo> declareDatas;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getMdate() {
		return mdate;
	}
	public void setMdate(double mdate) {
		this.mdate = mdate;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getDtime() {
		return dtime;
	}
	public void setDtime(String dtime) {
		this.dtime = dtime;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getDrloe() {
		return drloe;
	}
	public void setDrloe(String drloe) {
		this.drloe = drloe;
	}
	public String getDsheet() {
		return dsheet;
	}
	public void setDsheet(String dsheet) {
		this.dsheet = dsheet;
	}
	public List<DeclareDataPo> getDeclareDatas() {
		return declareDatas;
	}
	public void setDeclareDatas(List<DeclareDataPo> declareDatas) {
		this.declareDatas = declareDatas;
	}
	
	
}
