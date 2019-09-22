package com.scb.bank.management.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import com.scb.bank.management.entity.ScbBankManagementEntity;

/*
 * @author boopathi.r
 */

public interface ScbBankManagementRepository extends JpaRepository<ScbBankManagementEntity, Integer> {
	
}
