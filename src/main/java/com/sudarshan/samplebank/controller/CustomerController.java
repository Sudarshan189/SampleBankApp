package com.sudarshan.sudarshan.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.sudarshan.sudarshan.entities.Customer;
import com.sudarshan.sudarshan.service.CustomerService;

@Controller
@SessionAttributes("customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@RequestMapping(value = "/")
	public String getIndexPage(HttpServletRequest request, HttpServletResponse response, Model model) {
		model.addAttribute("customer", new Customer());
		return "index";
	}

	@RequestMapping(value = "/login")
	public String authenticate(Model model, @ModelAttribute("customer") Customer customer) {

		System.out.println(customer.hashCode());
		Customer c = customerService.authenticateCustomer(customer);
		System.out.println(customer.hashCode());

		if (c.getEmailId() != null) {
			customer.setAccount(c.getAccount());
			customer.setAddress(c.getAddress());
			customer.setEmailId(c.getEmailId());
			customer.setCustomerName(c.getCustomerName());
			customer.setDateOfBirth(c.getDateOfBirth());
			return "forward:/account";
		}
		return "index";

	}

	@RequestMapping(value = "/account")
	public String viewAccount(Model model, @SessionAttribute("customer") Customer customer) {
		System.out.println(customer);
		return "accountDetails";
	}

	@RequestMapping(value = "/editCustomer")
	public String editProfilePage(@SessionAttribute("customer") Customer customer, Model model) {
		model.addAttribute("customer", customer);
		return "editCustomer";
	}

	@RequestMapping(value = "/editprofile", method = RequestMethod.POST)
	public String editProfile(Model model, @ModelAttribute Customer customer) {
		customerService.updateAccount(customer);
		model.addAttribute("success", true);
		return "forward:/editCustomer";
	}

	@RequestMapping(value = "/editPasswordPage")
	public String editPasswordPage() {
		return "changePassword";
	}

	@RequestMapping(value = "/changePassword")
	public String editPassword(HttpSession session, @RequestParam String oldPassword, @RequestParam String newPassword,
			HttpServletRequest request, @RequestParam String confirmPassword) {
		session = request.getSession();
		Customer customer = (Customer) session.getAttribute("customer");
		if (oldPassword.equals(newPassword) && customerService.changePassword(customer, oldPassword, newPassword)) {
			session.setAttribute("customer", customer);
			request.setAttribute("success", true);
		} else {
			request.setAttribute("success", false);
			request.setAttribute("error", "Sorry failed to  update");
		}
		return "success";

	}

	@RequestMapping(value = "/logout")
	public String logout(HttpSession session, HttpServletRequest request) {
		session = request.getSession();
		session.invalidate();
		request.setAttribute("logout", true);
		return "redirect:/";
	}

}
