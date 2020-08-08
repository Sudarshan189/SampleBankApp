package com.sudarshan.sudarshan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.sudarshan.sudarshan" })
public class HdfcbankApplication {
	public static void main(String[] args) {
		SpringApplication.run(HdfcbankApplication.class, args);
	}
}
