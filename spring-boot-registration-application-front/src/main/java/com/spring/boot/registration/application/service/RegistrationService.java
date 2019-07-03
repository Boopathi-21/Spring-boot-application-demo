package com.spring.boot.registration.application.service;

import java.util.List;

import javax.servlet.Registration;

import com.spring.boot.registration.application.model.RegisterForm;

public interface RegistrationService {
	void insertRecord(RegisterForm data);
	List<RegisterForm> getAll();

}
