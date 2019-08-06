package com.bae.accountmaker.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bae.accountmaker.persistence.entity.Account;
import com.bae.accountmaker.persistence.repository.AccountRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountServiceMockitoTests {

	@InjectMocks
	AccountServiceImplementation service;

	@Mock
	AccountRepository repository;

	private static final Account MOCK_ACCOUNT_1 = new Account(1L, "test1", "test1");
	private static final Account MOCK_ACCOUNT_2 = new Account(2L, "test2", "test2");

	private List<Account> MOCK_LIST = new ArrayList<>();

	@Test
	public void getAllAccountsTest() {
		MOCK_LIST.add(MOCK_ACCOUNT_1);
		MOCK_LIST.add(MOCK_ACCOUNT_2);
		Mockito.when(repository.findAll()).thenReturn(MOCK_LIST);
		assertEquals(MOCK_LIST, service.getAllAccounts());
		Mockito.verify(repository).findAll();
	}

	@Test
	public void getAllAccountsEmptyTest() {
		Mockito.when(repository.findAll()).thenReturn(MOCK_LIST);
		assertEquals(MOCK_LIST, service.getAllAccounts());
		Mockito.verify(repository).findAll();
	}

	@Test
	public void getAnAccountTest() {
		Optional<Account> opt = Optional.of(MOCK_ACCOUNT_1);
		when(repository.findById(1L)).thenReturn(opt);
		assertEquals(opt.get(), service.getAccount(1L));
		Mockito.verify(repository).findById(1L);
	}

	@Test
	public void CreateAccountTest() {
		Mockito.when(repository.save(MOCK_ACCOUNT_1)).thenReturn(MOCK_ACCOUNT_1);
		assertEquals(MOCK_ACCOUNT_1, service.createAccount(MOCK_ACCOUNT_1));
		Mockito.verify(repository).save(MOCK_ACCOUNT_1);
	}

}
