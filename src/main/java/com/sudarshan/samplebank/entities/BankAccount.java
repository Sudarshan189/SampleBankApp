package com.sudarshan.sudarshan.entities;

public class BankAccount {

	private long accountId;
	private double balance;
	private String accountType;

	public BankAccount(long accountId, double balance, String accountType) {
		super();
		this.accountId = accountId;
		this.balance = balance;
		this.accountType = accountType;
	}

	public BankAccount() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public long getAccountId() {
		return accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	@Override
	public String toString() {
		return "BankAccount [accountType=" + accountType + ", balance=" + balance + ", accountId=" + accountId + "]";
	}

}
