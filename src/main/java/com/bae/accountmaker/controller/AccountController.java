package com.bae.accountmaker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bae.accountmaker.persistence.domain.Account;
import com.bae.accountmaker.service.AccountService;

@RestController
@RequestMapping("/Account")
public class AccountController {

	private AccountService service;

	public AccountController() {
	}

	// field injection of AccountService
	@Autowired
	public AccountController(AccountService service) {
		this.service = service;
	}

	@GetMapping("/getAllAccounts")
	public ResponseEntity<Object> getAllAccounts() {
		return new ResponseEntity<>(service.getAllAccounts(), HttpStatus.OK);
	}

	@GetMapping("/getAccount/{id}")
	public ResponseEntity<Object> getAccount(@PathVariable Long id) {
		return new ResponseEntity<>(service.getAccount(id), HttpStatus.OK);
	}

	@PostMapping("/postAccount")
	public ResponseEntity<Object> createAccount(@RequestBody Account account) {
		service.createAccount(account);
		return new ResponseEntity<>(account, HttpStatus.CREATED);
	}

}
