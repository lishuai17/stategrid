package com.state.service;

import com.state.po.UserPo;




public interface ILoginService {
	
	/**
	 * 校验用户
	 * @param user,password
	 * @return
	 */
	public UserPo judgeUser(String user,String password);
	

}
