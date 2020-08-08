package com.sudarshan.sudarshan;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.sudarshan.sudarshan.controller.CustomerController;
import com.sudarshan.sudarshan.entities.BankAccount;
import com.sudarshan.sudarshan.entities.Customer;
import com.sudarshan.sudarshan.service.CustomerService;

@RunWith(MockitoJUnitRunner.class)
public class CustomerControllerTest {

	@Mock
	CustomerService customerService;

	@InjectMocks
	CustomerController customerController;
	MockMvc mockMvc;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();
	}

	@Test
	public void testAuthentication() throws Exception {
		Customer cust = new Customer();
		cust.setCustomerId(12345);
		cust.setPassword("12");
		Customer customer = new Customer("Sudarshan", 12345, "sasd", "asdhaf", "12", LocalDate.now(),
				new BankAccount());
		Customer customer1 = new Customer("Sudarshan", 12345, null, null, "12", LocalDate.now(), new BankAccount());

		when(customerService.authenticateCustomer(cust)).thenReturn(customer);
		when(customerService.authenticateCustomer(customer1)).thenReturn(customer1);

		mockMvc.perform(post("/login").flashAttr("customer", cust)).andExpect(view().name("forward:/account"))
				.andExpect(status().isOk());

		mockMvc.perform(post("/login").flashAttr("customer", customer1)).andExpect(view().name("index"))
				.andExpect(status().isOk());
	}
	
	@Test
	public void testLogout() throws Exception {
		mockMvc.perform(get("/logout")).andExpect(view().name("index"));
	}
	
	

}
