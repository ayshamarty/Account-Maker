package com.bae.accountmaker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bae.accountmaker.persistence.entity.Account;
import com.bae.accountmaker.persistence.repository.AccountRepository;

@Service
public class AccountServiceImplementation implements AccountService {

	private AccountRepository repository;
	private RestTemplate restTemplate;

	@Autowired
	public AccountServiceImplementation(AccountRepository repository, RestTemplate restTemplate) {
		this.repository = repository;
		this.restTemplate = restTemplate;
	}

	@Override
	public Account getAccount(Long id) {
		Account accountToGet = repository.findById(id).get();
		return accountToGet;
	}

	@Override
	public List<Account> getAllAccounts() {
		return repository.findAll();
	}

	@Override
	public Account createAccount(Account account) {
		ResponseEntity<String> generatedAccountNumber = restTemplate.exchange("http://localhost:8081/getAccountNumber",
				HttpMethod.GET, null, String.class);
		account.setAccountNumber(generatedAccountNumber.getBody());
		ResponseEntity<String> generatedPrize = restTemplate.exchange(
				"http://localhost:8082/getPrize/" + generatedAccountNumber.getBody(), HttpMethod.GET, null,
				String.class);
		account.setPrize(generatedPrize.getBody());
		return repository.save(account);
	}

}
