package com.state.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.state.po.UserPo;

public interface ILoginDao {
	
	public UserPo judgeUser(@Param("user")String user,@Param("password")String password);
	
	public UserPo containUser(@Param("user")String user);

	public void saveUser(@Param("user")String user,@Param("password")String password,@Param("area")String area,@Param("sf")String sf);
	
	public List<Map<String,String>> selectBill(@Param("user")String user);
	
	public List<UserPo> selectNopass();

	public List<UserPo> selectPass();
	
	public void approve(@Param("user")String user);
	
	public void allotBill(@Param("user")String user,@Param("num")int num);
}
