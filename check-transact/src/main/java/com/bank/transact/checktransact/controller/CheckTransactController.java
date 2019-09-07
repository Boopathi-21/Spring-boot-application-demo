package com.bank.transact.checktransact.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bank.transact.checktransact.model.CheckTransactModel;
import com.bank.transact.checktransact.service.CheckTransactService;

@RestController
public class CheckTransactController {
	
	 @Autowired
	private CheckTransactService checkTransactService;
	
	@GetMapping("/show")
	public ResponseEntity<String> showAllData() {
		return new ResponseEntity<>(checkTransactService.getAll().toString(),HttpStatus.OK);
	}
	
	@DeleteMapping("/remove")
	public ResponseEntity<String> deleteAllData() {
		checkTransactService.delete();
		return new ResponseEntity<>("deleted successfully",HttpStatus.OK);
	}
	@PostMapping("/insert")
	public ResponseEntity<String> insetNewData() {
		CheckTransactModel one = new CheckTransactModel("new ", "empId",00);
		checkTransactService.insert(one);;
		return new ResponseEntity<>("inserted successfully",HttpStatus.BAD_GATEWAY);
	}
	
	@PostMapping("/insertBody")
	public ResponseEntity<String> insetNewBodyData(@RequestBody CheckTransactModel bodyData) {
		String name =bodyData.getName();
		String id =bodyData.getEmpId();
		int bal =bodyData.getBal();
		CheckTransactModel one = new CheckTransactModel(name,id,bal);
		checkTransactService.insert(one);;
		return new ResponseEntity<>("created successfully",HttpStatus.CREATED);
	}

}
