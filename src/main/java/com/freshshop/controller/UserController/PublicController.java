package com.freshshop.controller.UserController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.freshshop.model.Customer;
import com.freshshop.repository.CustomerRepository;
import com.freshshop.service.CustomerService;
import com.freshshop.service.MailService;

import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/public")
public class PublicController {
	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private CustomerService customerService;

	@Autowired
	private MailService mailService;

	private final MessageSource messageSource;

	public PublicController(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	@GetMapping("/register")
	public String displayRegisterPage(Model model) {
		model.addAttribute("customer", new Customer());
		return "User/register.html";
	}

	@GetMapping("/logout")
	public String displayLogOut(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/login?logout=true";
	}

	@GetMapping("/forget")
	public String displayForgetPage(Model model) {
		return "User/forget.html";
	}

	@PostMapping("/resetPassword")
	public String resetPassword(Model model, @RequestParam("email") String email, RedirectAttributes red)
			throws MessagingException {
		Customer customer = customerRepository.readByEmail(email);
		if (customer == null) {
			String notFoundEmail = messageSource.getMessage("notFoundEmail", new Object[] { email },
					LocaleContextHolder.getLocale());
			red.addFlashAttribute("notFoundEmail", notFoundEmail);
			return "redirect:/public/forget";
		}
		if (customerService.updatePassword(customer)) {
			String emailFrom = "tuvps24890@fpt.edu.vn";
			String emailTo = email;
			mailService.sendEmail(customer, emailFrom, emailTo);
			String emailUpdate = messageSource.getMessage("emailUpdate", null, LocaleContextHolder.getLocale());
			red.addFlashAttribute("emailUpdate", emailUpdate);
			return "redirect:/public/forget";
		}
		return "redirect:/public/forget";
	}

}
