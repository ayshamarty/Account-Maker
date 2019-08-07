package com.bae.accountmaker.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bae.accountmaker.persistence.domain.Account;

@Service
public interface AccountService {
	Account getAccount(Long id);

	List<Account> getAllAccounts();

	Account createAccount(Account account);

};
