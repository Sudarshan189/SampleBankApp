package com.sudarshan.sudarshan.repository;

import org.springframework.dao.DataAccessException;

public interface BankAccountRepository {

	public double getBalance(long accountId);

	public double updateBalance(long accountId, double balance) throws DataAccessException;
}
