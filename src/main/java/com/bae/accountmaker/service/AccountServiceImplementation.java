package com.bae.accountmaker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bae.accountmaker.entity.Account;
import com.bae.accountmaker.repository.AccountRepository;

@Service
public class AccountServiceImplementation implements AccountService {

	@Autowired
	AccountRepository repository;

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
		return repository.save(account);
	}

}
