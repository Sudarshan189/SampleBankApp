package com.sudarshan.sudarshan.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.sudarshan.sudarshan.entities.BankAccount;
import com.sudarshan.sudarshan.entities.Customer;
import com.sudarshan.sudarshan.repository.CustomerRepository;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Customer updateAccount(Customer customer) throws DataAccessException {

		try {
			jdbcTemplate.update("UPDATE customers SET customer_name=?,customer_address=?" + " WHERE customer_id=?",
					new Object[] { customer.getCustomerName(), customer.getAddress(), customer.getCustomerId() });
			return customer;
		} catch (DataAccessException e) {
			if (e instanceof EmptyResultDataAccessException) {
				e.initCause(new EmptyResultDataAccessException(1));
			}
			throw e;
		}

	}

	@Override
	public Customer addCustomer(Customer customer) {
		int count = jdbcTemplate.update("INSERT into customers VALUES(?,?,?,?,?,?)",
				new Object[] { customer.getCustomerId(), customer.getCustomerName(), customer.getPassword(),
						customer.getEmailId(), customer.getAddress(), customer.getDateOfBirth() });

		if (count != 0)
			return customer;
		return null;
	}

	@Override
	public Customer getCustomer(long customerId) {
		try {

			return jdbcTemplate.queryForObject(
					"select * from customers inner join bankaccounts"
							+ " on customers.customer_id=bankaccounts.customer_id where " + "customers.customer_id=?",
					new Object[] { customerId }, new CustomerRowMapper());

		} catch (DataAccessException e) {

			if (e instanceof EmptyResultDataAccessException) {
				e.initCause(new EmptyResultDataAccessException("Empty user not found", 1));
			}
			throw e;
		}
	}

	@Override
	public boolean changePassword(Customer customer, String oldPassword, String newPassword)
			throws DataAccessException {
		try {
			int i = jdbcTemplate.update(
					"UPDATE customers SET customer_password=? WHERE customer_id=? AND customer_password=?",
					new Object[] { newPassword, customer.getCustomerId(), oldPassword });
			System.out.println("data     " + i);
			return i == 1 ? true : false;

		} catch (DataAccessException e) {
			if (e instanceof EmptyResultDataAccessException) {
				e.initCause(new EmptyResultDataAccessException("Updateion failed", 1));
			}
			throw e;
		}
	}

	@Override
	public Customer authenticateCustomer(Customer customer) throws DataAccessException {
		try {

			return jdbcTemplate.queryForObject(
					"select * from customers inner join bankaccounts"
							+ " on customers.customer_id=bankaccounts.customer_id where "
							+ "customers.customer_id=? and customers.customer_password=?",
					new Object[] { customer.getCustomerId(), customer.getPassword() }, new CustomerRowMapper());

		} catch (DataAccessException e) {

			if (e instanceof EmptyResultDataAccessException) {
				e.initCause(new EmptyResultDataAccessException("Empty user not found", 1));
			}
			throw e;
		}
	}

	private class CustomerRowMapper implements RowMapper<Customer> {

		public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
			Customer customer = new Customer();
			customer.setCustomerId(rs.getInt(1));
			customer.setCustomerName(rs.getString(2));
			customer.setPassword(rs.getString(3));
			customer.setEmailId(rs.getString(4));
			customer.setAddress(rs.getString(5));
			customer.setDateOfBirth(rs.getDate(6).toLocalDate());
			customer.setAccount(new BankAccount(rs.getLong(8), rs.getDouble(10), rs.getString(9)));
			return customer;
		}
	}
}
