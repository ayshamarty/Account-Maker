package com.bae.accountmaker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bae.accountmaker.persistence.domain.Account;
import com.bae.accountmaker.persistence.domain.AccountToQueue;
import com.bae.accountmaker.persistence.repository.AccountRepository;

@Service
public class AccountServiceImplementation implements AccountService {

	private AccountRepository repository;
	private RestTemplate restTemplate;
	private JmsTemplate jmsTemplate;

	@Autowired
	public AccountServiceImplementation(AccountRepository repository, RestTemplate restTemplate,
			JmsTemplate jmsTemplate) {
		this.repository = repository;
		this.restTemplate = restTemplate;
		this.jmsTemplate = jmsTemplate;
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
		String number = getNumber();
		String prize = getPrize(number);
		account.setAccountNumber(number);
		account.setPrize(prize);
		sendToQueue(account);
		return repository.save(account);
	}

	private void sendToQueue(Account account) {
		AccountToQueue accountToStore = new AccountToQueue(account);
		jmsTemplate.convertAndSend("AccountQueue", accountToStore);
	}

	public String getNumber() {
		ResponseEntity<String> generatedAccountNumber = restTemplate.exchange("http://localhost:8081/getAccountNumber",
				HttpMethod.GET, null, String.class);
		String generatedNumber = generatedAccountNumber.getBody();
		return generatedNumber;

	}

	public String getPrize(String generatedNumber) {
		ResponseEntity<String> generatedPrize = restTemplate
				.exchange("http://localhost:8082/getPrize/" + generatedNumber, HttpMethod.GET, null, String.class);
		String prize = generatedPrize.getBody();
		return prize;
	}

}
