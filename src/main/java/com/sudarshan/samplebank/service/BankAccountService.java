package com.sudarshan.sudarshan.service;

import com.sudarshan.sudarshan.exceptions.LowBalanceException;
import com.sudarshan.sudarshan.exceptions.UserNotFoundException;

public interface BankAccountService {

	public double getBalance(long accountId) throws UserNotFoundException;

	public double withdraw(long accountId, double balance) throws LowBalanceException;

	public double deposit(long accountId, double balance) throws LowBalanceException;

	public boolean fundTransfer(long fromAcc, long toAcc, double balance);

}
