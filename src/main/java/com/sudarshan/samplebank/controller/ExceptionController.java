package com.sudarshan.sudarshan.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.sudarshan.sudarshan.exceptions.LowBalanceException;
import com.sudarshan.sudarshan.exceptions.PasswordChangeFailedException;
import com.sudarshan.sudarshan.exceptions.SomeThingWentWrongException;
import com.sudarshan.sudarshan.exceptions.UpdationFailedException;
import com.sudarshan.sudarshan.exceptions.UserNotFoundException;
import com.mysql.jdbc.MysqlDataTruncation;

@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler(value = UserNotFoundException.class)
	public String handlheError(HttpServletRequest request, UserNotFoundException exception) {
		System.out.println(exception);
		// exception.printStackTrace();
		request.setAttribute("success", false);
		request.setAttribute("error", exception);
		System.out.println(exception.getCause());
		return "success";
	}

	@ExceptionHandler(value = LowBalanceException.class)
	public String handlheErrorf(HttpServletRequest request, LowBalanceException exception) {
		System.out.println(exception);
		// exception.printStackTrace();
		request.setAttribute("success", false);
		request.setAttribute("error", exception);
		System.out.println(exception.getCause());
		return "success";
	}

	@ExceptionHandler(value = PasswordChangeFailedException.class)
	public String handlheErrorf(HttpServletRequest request, PasswordChangeFailedException exception) {
		System.out.println(exception);
		request.setAttribute("success", false);
		request.setAttribute("error", exception);
		System.out.println(exception.getCause());
		return "success";
	}

	@ExceptionHandler(value = UpdationFailedException.class)
	public String handlheErrorf(HttpServletRequest request, UpdationFailedException exception) {
		System.out.println(exception);
		request.setAttribute("success", false);
		request.setAttribute("error", exception);
		System.out.println(exception.getCause());
		return "success";
	}

	@ExceptionHandler(value = SQLException.class)
	public String handlheErrorf(HttpServletRequest request, SQLException exception) {
		System.out.println(exception);
		exception.printStackTrace();
		request.setAttribute("success", false);
		request.setAttribute("error", exception);
		System.out.println(exception.getCause());
		return "success";
	}

	@ExceptionHandler(value = MysqlDataTruncation.class)
	public String handlheErrorf(HttpServletRequest request, MysqlDataTruncation exception) {
		System.out.println(exception);
		// exception.printStackTrace();
		request.setAttribute("success", false);
		request.setAttribute("error", exception);
		System.out.println(exception.getCause());
		return "success";
	}

	@ExceptionHandler(value = SomeThingWentWrongException.class)
	public String handlheErrorf(HttpServletRequest request, SomeThingWentWrongException exception) {
		System.out.println(exception);
		// exception.printStackTrace();
		request.setAttribute("success", false);
		request.setAttribute("error", exception);
		System.out.println(exception.getCause());
		return "success";
	}
	// SomeThingWentWrongException
}
