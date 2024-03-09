package com.freshshop.controller.UserController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.freshshop.model.ContactUs;
import com.freshshop.service.ContactUsService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ContactUsController {
	@Autowired
	public ContactUsService contactUsService;

	@RequestMapping("/contact-us")
	public String getContactUs(Model model) {
		model.addAttribute("contactUs", new ContactUs());
		return "User/contact-us.html";
	}

	@PostMapping(value = "/saveMsg")
	public String saveMsg(@Valid @ModelAttribute("contactUs") ContactUs contactUs, Errors errors) {
		if (errors.hasErrors()) {
			log.error("Contact form validation failed due to : " + errors.toString());
			return "User/contact-us.html";
		}
		contactUsService.saveMsgDetail(contactUs);
		return "redirect:/contact-us";
	}

}
