package com.altimetrikbanktransaction.Controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.altimetrikbanktransaction.Entity.AccountEntity;
import com.altimetrikbanktransaction.Exception.AltiException;
import com.altimetrikbanktransaction.model.SendForm;

@RestController
public class AltimetrikTransaction  {
	
	
	@Autowired(required =true)
	private JpaRepository<AccountEntity, Integer> jpa;
	
	@Autowired(required =true)
	private JpaRepository<AccountEntity, Integer> jpan;
	
	
	@Autowired
	private EntityManager entityManager;
	
	@PostMapping("/insert")
     public String  insert() {
		AccountEntity record =  new AccountEntity(1001, "boo1", 200.20);
		try {
		List<AccountEntity> all = Arrays.asList(
				new AccountEntity(1002, "boo2", 20.20),
				new AccountEntity(1003, "boo3", 2000.20)
				);
		jpa.saveAll(all);
		return "inserted successfully";
		}
		catch(Exception e) {
			return e.getMessage();
		}
		
	}
	@PostMapping("/delete")
    public String  delete() {
		jpa.deleteById(1003);
		return "delete success";
		}
	@PostMapping("/transact")
	public String Transaction(@RequestBody SendForm sendForm) {
		List<AccountEntity> tranEntity = new ArrayList<>();
		AccountEntity fromAcc =entityManager.find(AccountEntity.class,sendForm.getFromId());
		AccountEntity toAcc =entityManager.find(AccountEntity.class,sendForm.getToId());
		try {
		if(Objects.isNull(fromAcc) || Objects.isNull(toAcc)) {
			throw new AltiException("Account not found");
		}
		else {
			double actualAmount = fromAcc.getBalance();
			if(actualAmount>  1  && actualAmount> sendForm.getAmount()) {
				actualAmount = fromAcc.getBalance() - sendForm.getAmount();
			fromAcc.setBalance(actualAmount);
			toAcc.setBalance(sendForm.getAmount() + toAcc.getBalance());
			tranEntity.add(fromAcc);
			tranEntity.add(toAcc);
	         jpa.saveAll(tranEntity);
	         
		}
			else {
				throw new AltiException("The fund is not sufficient");
			}
		}
		}
		catch(Exception e) {
			return e.getMessage().toString();
		}
		return "Transaction succesfully";
		
	}

}
