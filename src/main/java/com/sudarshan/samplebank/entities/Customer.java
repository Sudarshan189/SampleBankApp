package com.sudarshan.sudarshan.entities;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

public class Customer {

	@NotNull
	@Length(min=5)
	private String customerName;
	private long customerId;
	private String emailId;
	private String address;
	private String password;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateOfBirth;
	private BankAccount account;

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(String customerName, long customerId, String emailId, String address, String password,
			LocalDate dateOfBirth, BankAccount account) {
		super();
		this.customerName = customerName;
		this.customerId = customerId;
		this.emailId = emailId;
		this.address = address;
		this.password = password;
		this.dateOfBirth = dateOfBirth;
		this.account = account;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public BankAccount getAccount() {
		return account;
	}

	public void setAccount(BankAccount account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "Customer [customerName=" + customerName + ", customerId=" + customerId + ", emailId=" + emailId
				+ ", address=" + address + ", password=" + password + ", dateOfBirth=" + dateOfBirth + ", account="
				+ account + "]";
	}

}
