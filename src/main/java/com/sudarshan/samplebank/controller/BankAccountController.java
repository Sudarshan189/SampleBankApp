package com.sudarshan.sudarshan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.sudarshan.sudarshan.entities.Customer;
import com.sudarshan.sudarshan.service.BankAccountService;

@Controller
public class BankAccountController {

	@Autowired
	private BankAccountService bankAccountService;

	@RequestMapping(value = "/fundtransferPage", method = RequestMethod.GET)
	public String getfundTransferPage(@SessionAttribute("customer") Customer customer, Model model) {
		model.addAttribute("account", customer.getAccount());
		return "fundTransfer";
	}

	@RequestMapping(value = "/fundTransfer", method = RequestMethod.POST)
	public String transferFund(@RequestParam long fromAcc, @RequestParam long toAcc, @RequestParam long amount,
			Model model) {
		if (amount > 0 && bankAccountService.fundTransfer(fromAcc, toAcc, amount)) {
			model.addAttribute("success", true);

		} else {
			model.addAttribute("success", false);
			model.addAttribute("error", "amount entered in -ve ");
		}

		return "success";
	}
}
