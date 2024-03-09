package com.freshshop.controller.UserController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.freshshop.repository.CustomerRepository;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class LoginController {

	@Autowired
	CustomerRepository customerRepository;

	private final MessageSource messageSource;

	@Autowired
	public LoginController(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	@Autowired
	HttpSession session;

	@RequestMapping(value = "/login", method = { RequestMethod.GET, RequestMethod.POST })
	public String displayLoginPage(Model model, @RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout,
			@RequestParam(value = "register", required = false) String register) {

		String message = "";
		if (error != null) {
			message = messageSource.getMessage("login.failed", null, LocaleContextHolder.getLocale());
		}
		if (logout != null) {
			message = messageSource.getMessage("logout.success", null, LocaleContextHolder.getLocale());
		}
		if (register != null) {
			message = messageSource.getMessage("register.success", null, LocaleContextHolder.getLocale());
		}
		model.addAttribute("message", message);
		return "User/login.html";
	}

}
