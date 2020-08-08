package com.sudarshan.sudarshan.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.sudarshan.sudarshan.entities.Customer;
import com.sudarshan.sudarshan.exceptions.PasswordChangeFailedException;
import com.sudarshan.sudarshan.exceptions.SomeThingWentWrongException;
import com.sudarshan.sudarshan.exceptions.UpdationFailedException;
import com.sudarshan.sudarshan.exceptions.UserNotFoundException;
import com.sudarshan.sudarshan.repository.CustomerRepository;
import com.sudarshan.sudarshan.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customer updateAccount(Customer customer) throws UpdationFailedException {

		try {
			return customerRepository.updateAccount(customer);
		} catch (DataAccessException e) {
			UpdationFailedException updationFailedException = new UpdationFailedException(
					"failed to update the customer details");
			updationFailedException.initCause(e);
			throw updationFailedException;
		}

	}

	@Override
	public Customer addCustomer(Customer customer) {

		return customerRepository.addCustomer(customer);
	}

	@Override
	public Customer getCustomer(long customerId) throws SomeThingWentWrongException {

		try {
			return customerRepository.getCustomer(customerId);
		} catch (DataAccessException e) {
			SomeThingWentWrongException someThingWentWrongException = new SomeThingWentWrongException(
					"Some thing went wrong");
			someThingWentWrongException.initCause(e);
			throw someThingWentWrongException;
		}

	}

	@Override
	public boolean changePassword(Customer customer, String oldPassword, String newPassword)
			throws PasswordChangeFailedException {
		try {
			return customerRepository.changePassword(customer, oldPassword, newPassword);
		} catch (DataAccessException e) {
			PasswordChangeFailedException passwordChangeFailedException = new PasswordChangeFailedException(
					"Failed to change the password");
			passwordChangeFailedException.initCause(e);
			throw e;
		}

	}

	@Override
	public Customer authenticateCustomer(Customer customer) throws UserNotFoundException {

		try {
			return customerRepository.authenticateCustomer(customer);
		} catch (DataAccessException e) {
			UserNotFoundException u = new UserNotFoundException("No user Found");
			u.initCause(e);
			throw u;
		}

	}

}
