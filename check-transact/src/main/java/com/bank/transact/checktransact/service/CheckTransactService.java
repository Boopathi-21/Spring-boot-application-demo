package com.bank.transact.checktransact.service;

import java.util.List;

import com.bank.transact.checktransact.model.CheckTransactModel;

public interface CheckTransactService {

	List<CheckTransactModel> getAll();
	 void insert(CheckTransactModel data);
	 void delete();
	

}
