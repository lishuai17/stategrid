package com.state.service.impl;

import java.util.List;
import java.util.Map;

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
	
	public UserPo containUser(String user){
		return loginDao.containUser(user);
	}
	
	public void saveUser(String user,String password,String area,String sf){
		loginDao.saveUser(user, password, area,sf); 
	}
	
	public List<Map<String,String>> selectBill(String user){
		return loginDao.selectBill(user);
	}
	
	public List<UserPo> selectNopass(){
		return loginDao.selectNopass();
	}

	public List<UserPo> selectPass(){
		return loginDao.selectPass();
	}

	public void approve(String user){
		loginDao.approve(user);
	}
	
	public void allotBill(String user){
		for(int i=1;i<=3;i++){
			loginDao.allotBill(user,i);
		}
	}

}
