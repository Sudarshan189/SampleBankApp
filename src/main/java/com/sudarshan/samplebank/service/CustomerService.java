package com.sudarshan.sudarshan.service;

import com.sudarshan.sudarshan.entities.Customer;
import com.sudarshan.sudarshan.exceptions.PasswordChangeFailedException;
import com.sudarshan.sudarshan.exceptions.SomeThingWentWrongException;
import com.sudarshan.sudarshan.exceptions.UpdationFailedException;
import com.sudarshan.sudarshan.exceptions.UserNotFoundException;

public interface CustomerService {

	public Customer updateAccount(Customer customer) throws UpdationFailedException;

	public Customer addCustomer(Customer customer);

	public Customer getCustomer(long customerId) throws SomeThingWentWrongException;

	public boolean changePassword(Customer customer, String oldPassword, String newPassword)
			throws PasswordChangeFailedException;

	public Customer authenticateCustomer(Customer customer) throws UserNotFoundException;

}
