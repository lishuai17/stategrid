package com.state.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.state.po.DeclarePo;
import com.state.service.IDeclareService;

@Service
@Transactional
public class DeclareServiceImpl implements IDeclareService{

	public void saveDeclare(DeclarePo declare) {
		// TODO Auto-generated method stub
		
	}

	public boolean existsDeclare(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	public void deleteDeclare(Integer id) {
		// TODO Auto-generated method stub
		
	}

}
