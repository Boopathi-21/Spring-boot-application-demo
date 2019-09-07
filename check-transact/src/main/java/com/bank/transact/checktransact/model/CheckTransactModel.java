package com.bank.transact.checktransact.model;


public class CheckTransactModel {
	
	private String name;
	private String empId;
	private int bal;
	
	public CheckTransactModel(String name, String empId, int bal) {
		super();
		this.name = name;
		this.empId = empId;
		this.bal = bal;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public int getBal() {
		return bal;
	}
	public void setBal(int bal) {
		this.bal = bal;
	}
	@Override
	public String toString() {
		return "CheckTransactModel [name=" + name + ", empId=" + empId + ", bal=" + bal + "]";
	}

}
