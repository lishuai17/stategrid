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
	public void saveUser(String user,String password,String area,String sf);
	
	/**
	 * 查询已有权限的菜单
	 * @param user
	 */
	public List<Map<String,String>> selectBill(String user);
	
	/**
	 * 查询未审核用户
	 * @param user
	 */
	public List<UserPo> selectNopass();
	
	/**
	 * 查询已审核用户
	 * @param user
	 */
	public List<UserPo> selectPass();
	
	/**
	 * 审批用户
	 * @param user
	 */
	public void approve(String user);
	
	/**
	 * 给用户分配菜单
	 * @param user
	 */
	public void allotBill(String user);

}
