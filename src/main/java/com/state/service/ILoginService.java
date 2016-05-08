package com.state.service;

import java.util.List;
import java.util.Map;

import com.state.po.UserPo;




public interface ILoginService {
	
	/**
	 * 校验用户
	 * @param user,password
	 * @return
	 */
	public UserPo judgeUser(String user,String password);
	
	/**
	 * 注册检查
	 * @param user
	 * @return
	 */
	public UserPo containUser(String user);
	
	/**
	 * 注册用户
	 * @param user,password,area
	 */
	public void saveUser(String user,String password,String area);
	
	/**
	 * 查询已有权限的菜单
	 * @param user
	 */
	public List<Map<String,String>> selectBill(String user);

}
