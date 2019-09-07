package com.bank.transact.checktransact.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.transact.checktransact.dao.CheckTransacDao;
import com.bank.transact.checktransact.model.CheckTransactModel;

@Service
public class CheckTransactServiceImpl implements CheckTransactService{
	
	@Autowired
     private CheckTransacDao checkTransacDao;
	@Override
	public List<CheckTransactModel> getAll() {
		// TODO Auto-generated method stub
		return checkTransacDao.getAll();
	}

	@Override
	public void insert(CheckTransactModel data) {
		// TODO Auto-generated method stub
		checkTransacDao.insert(data);
		
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
		checkTransacDao.delete();
		
	}

}
