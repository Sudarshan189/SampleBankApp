package com.sudarshan.sudarshan;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sudarshan.sudarshan.controller.CustomerController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HdfcbankApplicationTests {

	@Test
	public void contextLoads() {
		CustomerController customerController = new CustomerController();
		String result = customerController.editPasswordPage();
		assertEquals(result, "changePassword");

	}

}
