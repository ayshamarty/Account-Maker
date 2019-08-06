package com.bae.accountmaker;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.bae.accountmaker.controller.AccountControllerMockitoTests;
import com.bae.accountmaker.controller.AccountControllerWebMockTest;
import com.bae.accountmaker.service.AccountServiceMockitoTests;

@RunWith(Suite.class)

@Suite.SuiteClasses({ AccountControllerWebMockTest.class, AccountControllerMockitoTests.class,
		AccountServiceMockitoTests.class

})

public class Runner {

}