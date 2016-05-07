package com.state.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.state.dao.ILoginDao;
import com.state.po.UserPo;
import com.state.service.ILoginService;

@Service
@Transactional
public class LoginServiceImpl implements ILoginService{

	@Autowired
	private ILoginDao loginDao;
	
	public UserPo judgeUser(String user,String password) {
		return loginDao.judgeUser(user, password);
	}

}
