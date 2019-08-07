package com.bae.accountmaker.persistence.domain;

public class AccountToQueue {

	private String firstName;
	private String lastName;
	private String accountNumber;
	private String prize;

	public AccountToQueue(Account account) {
		this.accountNumber = account.getAccountNumber();
		this.firstName = account.getFirstName();
		this.lastName = account.getLastName();
		this.prize = account.getPrize();

	}

	public AccountToQueue() {
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getPrize() {
		return prize;
	}

	public void setPrize(String prize) {
		this.prize = prize;
	}

}
