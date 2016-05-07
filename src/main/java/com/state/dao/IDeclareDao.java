package com.state.dao;

import java.util.Map;

import com.state.po.DeclarePo;

public interface IDeclareDao {

	public void deleteDeclare(Integer id);

	public void insertDeclare(DeclarePo declarePo);
	
	public void selectDeclareByParam(Map<String,String> param);
}
