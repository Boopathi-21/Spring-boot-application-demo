package com.scb.bank.management.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.scb.bank.management.entity.ScbBankManagementEntity;
import com.scb.bank.management.exception.ScbBankManagementException;
import com.scb.bank.management.model.AccountInfo;
import com.scb.bank.management.model.SendMoneyForm;
import com.scb.bank.management.service.ScbBankManagementService;


/*
 * @author boopathi.r
 */

@RestController
public class ScbBankManagementController {
	
	@Autowired
	private ScbBankManagementService scbBankManagementService;
	
	@RequestMapping(value = "/ReadAllData", method = RequestMethod.GET)
	public String frontPage() throws JsonProcessingException {
		List<ScbBankManagementEntity> accountInfoList = scbBankManagementService.getAllAccountList();
		ObjectMapper mapper = new ObjectMapper();
		String newJsonData = mapper.writeValueAsString(accountInfoList);
		return newJsonData;
	}
	
	@RequestMapping(value = "/updateAccount", method = RequestMethod.PUT)
	public ResponseEntity<String> updateAccount(@RequestBody AccountInfo accountInfo,Model model) throws JsonProcessingException {
		scbBankManagementService.createAccount(accountInfo);
		List<ScbBankManagementEntity> accountInfoList = scbBankManagementService.getAllAccountList();
		model.addAttribute("accountInfos", accountInfoList);
		ObjectMapper mapper = new ObjectMapper();
		String newJsonData = mapper.writeValueAsString(accountInfoList);
		return new ResponseEntity<String>(newJsonData, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/createAccount", method = RequestMethod.POST)
	public ResponseEntity<String> createAccount(@RequestBody AccountInfo accountInfo,Model model) throws JsonProcessingException {
		scbBankManagementService.createAccount(accountInfo);
		List<ScbBankManagementEntity> accountInfoList = scbBankManagementService.getAllAccountList();
		model.addAttribute("accountInfos", accountInfoList);
		ObjectMapper mapper = new ObjectMapper();
		String newJsonData = mapper.writeValueAsString(accountInfoList);
		return new ResponseEntity<String>(newJsonData, HttpStatus.CREATED);
	}
	@RequestMapping(value = "/deleteAccount", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteAccount(@RequestBody AccountInfo accountInfo,Model model) throws ScbBankManagementException, JsonProcessingException {
		scbBankManagementService.deleteAccount(accountInfo.getId());
		List<ScbBankManagementEntity> accountInfoList = scbBankManagementService.getAllAccountList();
		model.addAttribute("accountInfos", accountInfoList);
		ObjectMapper mapper = new ObjectMapper();
		String newJsonData = mapper.writeValueAsString(accountInfoList);
		return new ResponseEntity<String>(newJsonData, HttpStatus.NO_CONTENT);
	}
	@RequestMapping(value = "/sendMoney", method = RequestMethod.GET)
    public ModelAndView SendMoneyPage(ModelAndView model) {
        SendMoneyForm form = new SendMoneyForm(32,42,10.0);
        model.addObject("sendMoneyForm", form);
		model.setViewName("sendMoneyPage");
        return model;
    }
	
	@RequestMapping(value = "/sendMoney", method = RequestMethod.POST)
	    public ModelAndView processSendMoney(ModelAndView model, SendMoneyForm sendMoneyForm) {
	        try {
	        	scbBankManagementService.sendMoney(sendMoneyForm.getFromAccountId(), //
	                    sendMoneyForm.getToAccountId(), //
	                    sendMoneyForm.getAmount());
	        } catch (ScbBankManagementException e) {
	            model.addObject("errorMessage", "Error: " + e.getMessage());
	            model.setViewName("sendMoneyPage");
	            return model;
	        }
	        model.setViewName("redirect:/menu");
	        return model;
	    }
	 
	 

}
