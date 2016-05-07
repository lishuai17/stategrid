package com.state.dao;

import org.apache.ibatis.annotations.Param;

import com.state.po.UserPo;

public interface ILoginDao {
	
	public UserPo judgeUser(@Param("user")String user,@Param("password")String password);

}
