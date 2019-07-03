package com.spring.boot.registration.application.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.spring.boot.registration.application.model.RegisterForm;
import com.spring.boot.registration.application.service.RegistrationService;

@RestController
public class RegistrationLoginFormController {

	@Autowired
	RegistrationService registrationService;
	
	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public ModelAndView hello(ModelAndView model) {
		model.setViewName("login");
		return model;
	}
	
	@RequestMapping(value ="/{result}" )
	public ModelAndView success(@PathVariable String result,
			ModelAndView model) {
		model.setViewName(result);
		return model;
	}
	@RequestMapping(value = { "/checkData" }, method = RequestMethod.POST)
	public String checkData(@RequestBody RegisterForm data ) {
		List<RegisterForm> allRecord =registrationService.getAll();
		List<String> userNameList = new ArrayList<>();
		for(RegisterForm name : allRecord) {
			userNameList.add(name.getName());
		}
		if(!userNameList.contains(data.getName())){
			registrationService.insertRecord(data);
			return "2";
			
		}
		else {

			return "404";
			}
	}
	
}
