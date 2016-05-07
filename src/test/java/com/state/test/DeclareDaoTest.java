package com.state.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.state.dao.IDeclareDao;
import com.state.test.base.BaseSpringContextTest;

public class DeclareDaoTest extends BaseSpringContextTest{
	
	@Autowired
	private IDeclareDao declareDao;

	@Override
	public void setup() {
		// TODO Auto-generated method stub
		
	}
	
	@Test
	public void testCountDeclareById(){
		int id = 1;
		int countDeclareById = declareDao.countDeclareById(id);
		System.out.println(countDeclareById);
	}

}
