package com.state.po;

import java.util.List;

import org.apache.ibatis.type.Alias;

/**
 * 申报单子
 * 
 * @author 帅
 *
 */
@SuppressWarnings("serial")
@Alias("DeclarePo")
public class DeclarePo extends BasePo {
	// 申报单ID
	private long id;
	// 申报单名
	private String sheetName;
	// 备注
	private String descr;
	// 日期
	private String mdate;
	// 地区
	private String area;
	// 申报时间
	private String dtime;
	// 用户名
	private String mname;
	// 买卖类型
	private String drloe;

	// 申报数据
	private List<DeclareDataPo> declareDatas;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSheetName() {
		return sheetName;
	}

	public void setSheetName(String sheetName) {
		this.sheetName = sheetName;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public String getMdate() {
		return mdate;
	}

	public void setMdate(String mdate) {
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

	public List<DeclareDataPo> getDeclareDatas() {
		return declareDatas;
	}

	public void setDeclareDatas(List<DeclareDataPo> declareDatas) {
		this.declareDatas = declareDatas;
	}

}
