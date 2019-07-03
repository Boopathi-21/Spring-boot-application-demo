package com.spring.boot.registration.application.serviceImpl;

import java.util.List;

import javax.servlet.Registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.registration.application.dao.RegistrationDao;
import com.spring.boot.registration.application.model.RegisterForm;
import com.spring.boot.registration.application.service.RegistrationService;

@Service
public class RegistrationServiceImpl implements RegistrationService {

	@Autowired
	RegistrationDao registrationDao;
	
	public void insertRecord(RegisterForm data) {
		registrationDao.insertRecord(data);
				
	}

	public List<RegisterForm> getAll() {
		return registrationDao.getAll();
	}

}
