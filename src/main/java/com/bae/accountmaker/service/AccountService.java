package com.bae.accountmaker.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bae.accountmaker.persistence.entity.Account;

@Service
public interface AccountService {
	Account getAccount(Long id);

	List<Account> getAllAccounts();

	Account createAccount(Account account);

};
