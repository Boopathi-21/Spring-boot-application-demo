package com.altimetrikbanktransaction.Dao;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;

import com.altimetrikbanktransaction.Entity.AccountEntity;
import com.altimetrikbanktransaction.Entity.BankEntity;

public interface BankDao extends JpaRepository<BankEntity,Integer>{

}
