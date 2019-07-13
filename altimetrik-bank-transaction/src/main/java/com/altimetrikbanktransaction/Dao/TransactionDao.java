package com.altimetrikbanktransaction.Dao;

import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;

import com.altimetrikbanktransaction.Entity.AccountEntity;

@Primary
public interface TransactionDao  extends JpaRepository<AccountEntity,Integer>{

}
