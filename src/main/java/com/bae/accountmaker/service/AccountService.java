package com.bae.accountmaker.service;

import java.util.List;
import java.util.Optional;

import com.bae.accountmaker.entity.Account;

public interface AccountService {
	Optional<Account> getAccount(Long id);

	List<Account> getAllAccounts();

	Account createAccount(Account account);

};
