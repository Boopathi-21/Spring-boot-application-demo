package com.altimetrikbanktransaction.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="ALT_BANK")
public class AccountEntity {
	@Id
	@Column(name ="EMP_ID")
	private int emplId;
	@Column(name ="EMPLOYEE_NAME")
	private String employeeName;
	public int getEmplId() {
		return emplId;
	}

	public void setEmplId(int emplId) {
		this.emplId = emplId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Column(name ="BALANCE")
	private double balance;
	
	public AccountEntity() {
		
	}
	public AccountEntity(int emplId, String employeeName, double balance) {
		super();
		this.emplId = emplId;
		this.employeeName = employeeName;
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "AccountEntity [emplId=" + emplId + ", employeeName=" + employeeName + ", balance=" + balance + "]";
	}
	
	
	

}
