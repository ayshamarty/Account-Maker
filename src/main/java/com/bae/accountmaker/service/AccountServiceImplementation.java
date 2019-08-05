package com.bae.accountmaker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.bae.accountmaker.entity.Account;
import com.bae.accountmaker.repository.AccountRepository;

public class AccountServiceImplementation implements AccountService {

	@Autowired
	AccountRepository repository;

	@Override
	public Optional<Account> getAccount(Long id) {
		return repository.findById(id);

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
