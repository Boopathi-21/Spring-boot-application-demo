package com.scb.bank.management.serviceImpl;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scb.bank.management.dao.ScbBankManagementRepository;
import com.scb.bank.management.entity.ScbBankManagementEntity;
import com.scb.bank.management.exception.ScbBankManagementException;
import com.scb.bank.management.model.AccountInfo;
import com.scb.bank.management.service.ScbBankManagementService;

/*
 * @author boopathi.r
 */
@Service
public class ScbBankManagementServiceImpl implements ScbBankManagementService {
	
	
	@Autowired
	private ScbBankManagementRepository scbBankManagementDao;
	
	@Autowired
    private EntityManager entityManager;
	
	@Override
	public void createAccount(AccountInfo accountInfo) {
		ScbBankManagementEntity scbBankManagementEntity = new ScbBankManagementEntity();
		scbBankManagementEntity.setId(accountInfo.getId());
		scbBankManagementEntity.setFullName(accountInfo.getFullName());
		scbBankManagementEntity.setBalance(accountInfo.getBalance());
		scbBankManagementDao.save(scbBankManagementEntity);
	
	}

	@Override
	public List<ScbBankManagementEntity> getAllAccountList() {
		// TODO Auto-generated method stub
		return scbBankManagementDao.findAll();
	}

	@Override
	public void sendMoney(int fromAccountId, int toAccountId, double amount) throws ScbBankManagementException {
		// TODO Auto-generated method stub
		    addAmount(toAccountId, amount);
	        addAmount(fromAccountId, -amount);
		
	}
	
	@Override
	public void deleteAccount(int accountId) throws ScbBankManagementException {
		// TODO Auto-generated method stub
		if(scbBankManagementDao.existsById(accountId)) {
			scbBankManagementDao.deleteById(accountId);	
		}
		else {
			 throw new ScbBankManagementException("Account not found " + accountId);	
		}
		
	}

	private void addAmount(int id, double amount) throws ScbBankManagementException {
		// TODO Auto-generated method stub
           ScbBankManagementEntity account = this.getAccountById(id);
	        if (account == null) {
	            throw new ScbBankManagementException("Account not found " + id);
	        }
	        double newBalance = account.getBalance() + amount;
	        if (account.getBalance() + amount < 0) {
	            throw new ScbBankManagementException(
	                    "The money in the account '" + id + "' is not enough (" + account.getBalance() + ")");
	        }
	        account.setBalance(newBalance);
	}
	
	private ScbBankManagementEntity getAccountById(int id) {
		return entityManager.find(ScbBankManagementEntity.class,id);
	}

	@Override
	public void depositMoney(int fromAccountId, double amount) throws ScbBankManagementException {
		// TODO Auto-generated method stub
		
		ScbBankManagementEntity scbBankManagementEntity =
				entityManager.find(ScbBankManagementEntity.class,fromAccountId);
		 if (scbBankManagementEntity == null) {
	            throw new ScbBankManagementException("Account not found " + fromAccountId);
	        }
		scbBankManagementEntity.setBalance(amount);
		scbBankManagementDao.save(scbBankManagementEntity);
		}

}
