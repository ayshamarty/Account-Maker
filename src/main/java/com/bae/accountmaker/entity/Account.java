package com.bae.accountmaker.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Account {

	@Id
	@GeneratedValue
	private Long accountID;

	private String firstName;
	private String lastName;
	private String accountNumber;
	private String prize;

	public Account(String firstName) {
		this.firstName = firstName;
	}

	public Account(Long accountID, String firstName, String lastName, String accountNumber, String prize) {
		super();
		this.accountID = accountID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.accountNumber = accountNumber;
		this.prize = prize;
	}

	public Account(Long accountID, String firstName, String lastName) {
		super();
		this.accountID = accountID;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Long getAccountID() {
		return accountID;
	}
	// getters and setters

	public void setAccountID(Long accountID) {
		this.accountID = accountID;
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
