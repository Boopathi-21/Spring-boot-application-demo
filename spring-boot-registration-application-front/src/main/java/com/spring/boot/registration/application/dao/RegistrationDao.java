package com.spring.boot.registration.application.dao;

import java.util.List;

import com.spring.boot.registration.application.model.RegisterForm;

public interface RegistrationDao {
	
	void insertRecord(RegisterForm data);
	List<RegisterForm> getAll();

}
