package com.bank.transact.checktransact.dao;

import java.util.List;

import com.bank.transact.checktransact.model.CheckTransactModel;

public interface CheckTransacDao {
	
	List<CheckTransactModel> getAll();
	 void insert(CheckTransactModel data);
	 void delete();

}
