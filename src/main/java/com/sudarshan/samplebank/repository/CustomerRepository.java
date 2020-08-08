package com.sudarshan.sudarshan.repository;

import org.springframework.dao.DataAccessException;

import com.sudarshan.sudarshan.entities.Customer;

public interface CustomerRepository {

	public Customer updateAccount(Customer customer) throws DataAccessException;

	public Customer addCustomer(Customer customer);

	public Customer getCustomer(long customerId);

	public boolean changePassword(Customer customer, String oldPassword, String newPassword) throws DataAccessException;

	public Customer authenticateCustomer(Customer customer) throws DataAccessException;

}
