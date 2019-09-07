package com.bank.transact.checktransact.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.bank.transact.checktransact.model.CheckTransactModel;

@Repository
public class CheckTransacDaoImpl implements CheckTransacDao{
	
	 List<CheckTransactModel> allData = new ArrayList<>();

	@Override
	public List<CheckTransactModel> getAll() {
		// TODO Auto-generated method stub
		
		return allData;
	}

	@Override
	public void insert(CheckTransactModel data) {
		// TODO Auto-generated method stub
		allData.add(data);
		
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		allData.clear();
		
	}
	

}
