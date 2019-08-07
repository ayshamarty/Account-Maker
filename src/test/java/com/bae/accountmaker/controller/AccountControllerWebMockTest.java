package com.bae.accountmaker.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.bae.accountmaker.persistence.domain.Account;
import com.bae.accountmaker.service.AccountService;

@RunWith(SpringRunner.class)
@WebMvcTest(AccountController.class)
@AutoConfigureMockMvc
public class AccountControllerWebMockTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private AccountService service;

	private static final Account MOCK_ACCOUNT_1 = new Account(1L, "test1", "test1");
	private static final Account MOCK_ACCOUNT_2 = new Account(2L, "test2", "test2");

	@Ignore
	@Test
	public void getAllAccountsTest() throws Exception {
		List<Account> MOCK_LIST = new ArrayList<>();
		MOCK_LIST.add(MOCK_ACCOUNT_1);
		MOCK_LIST.add(MOCK_ACCOUNT_2);

		when(service.getAllAccounts()).thenReturn(MOCK_LIST);

		mockMvc.perform(get("/Account/getAllAccounts")).andExpect(content().string(containsString("test1")));
	}

}
