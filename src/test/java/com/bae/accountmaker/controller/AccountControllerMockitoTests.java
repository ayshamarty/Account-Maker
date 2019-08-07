package com.bae.accountmaker.controller;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bae.accountmaker.persistence.domain.Account;
import com.bae.accountmaker.service.AccountService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountControllerMockitoTests {

	@InjectMocks
	AccountController controller;

	@Mock
	AccountService service;

	private static final Account MOCK_ACCOUNT_1 = new Account(1L, "test1", "test1");
	private static final Account MOCK_ACCOUNT_2 = new Account(2L, "test2", "test2");

	private List<Account> MOCK_LIST = new ArrayList<>();

	@Test
	public void getAllAccountsTest() {
		MOCK_LIST.add(MOCK_ACCOUNT_1);
		MOCK_LIST.add(MOCK_ACCOUNT_2);
		Mockito.when(service.getAllAccounts()).thenReturn(MOCK_LIST);
		assertEquals(MOCK_LIST, controller.getAllAccounts().getBody());
		Mockito.verify(service).getAllAccounts();
	}

	@Test
	public void getAllAccountsEmptyTest() {
		Mockito.when(service.getAllAccounts()).thenReturn(MOCK_LIST);
		assertEquals(MOCK_LIST, controller.getAllAccounts().getBody());
		Mockito.verify(service).getAllAccounts();
	}

	@Test
	public void getAnAccountTest() {
		Mockito.when(service.getAccount(2L)).thenReturn(MOCK_ACCOUNT_2);
		assertEquals(MOCK_ACCOUNT_2, controller.getAccount(2L).getBody());
	}

	@Test
	public void CreateAccountTest() {
		Mockito.when(service.createAccount(MOCK_ACCOUNT_1)).thenReturn(MOCK_ACCOUNT_1);
		assertEquals("Account Created", controller.createAccount(MOCK_ACCOUNT_1).getBody());
		Mockito.verify(service).createAccount(MOCK_ACCOUNT_1);
	}

}
