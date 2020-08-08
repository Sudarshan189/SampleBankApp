package com.sudarshan.sudarshan.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sudarshan.sudarshan.repository.BankAccountRepository;

@Repository
public class BankAccountRepositoryImpl implements BankAccountRepository {

	@Autowired
	private JdbcTemplate templet;

	@Override
	public double getBalance(long accountId) throws DataAccessException {
		try {
			double balance = templet.queryForObject("SELECT balance from bankaccounts where account_id=?",
					new Object[] { accountId }, Double.class);
			return balance;
		} catch (DataAccessException e) {
			e.initCause(new EmptyResultDataAccessException("Expected 1 actual 0", 1));
			throw e;
		}
	}

	@Override
	public double updateBalance(long accountId, double balance) throws DataAccessException {
		try {
			templet.update("UPDATE bankaccounts set balance=? where account_id=?", new Object[] { balance, accountId });

			return getBalance(accountId);

		} catch (DataAccessException e) {
			e.initCause(new EmptyResultDataAccessException("Expected 1 actual 0", 1));
			throw e;
		}
	}
}
