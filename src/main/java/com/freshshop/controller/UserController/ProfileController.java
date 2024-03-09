package com.freshshop.controller.UserController;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.freshshop.model.Address;
import com.freshshop.model.Customer;
import com.freshshop.model.Profile;
import com.freshshop.repository.CustomerRepository;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class ProfileController {
	@Autowired
	private CustomerRepository customerReponsitory;


	private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	@RequestMapping("/profile")
	public ModelAndView getProfile(Model model, HttpSession session) {

		ModelAndView modelAndView = new ModelAndView("User/profile.html");
		Customer customer = (Customer) session.getAttribute("loggingCustomer");
		Profile profile = new Profile();
		profile.setName(customer.getCustomerName());
		profile.setPhoneNumber(customer.getPhoneNumber());
		profile.setEmail(customer.getEmail());
		if (customer.getAddress() != null && customer.getAddress().getAddressId() >= 0) {
			profile.setAddress1(customer.getAddress().getAddress1());
			profile.setAddress2(customer.getAddress().getAddress2());
//			profile.setCity(customer.getAddress().getCity());
//			profile.setState(customer.getAddress().getState());
			profile.setZipCode(customer.getAddress().getZipCode());
		}
		modelAndView.addObject("profile", profile);
		return modelAndView;
	}

	@PostMapping("/updateProfile")
	public String updateProfile(Model model, @Valid @ModelAttribute("profile") Profile profile, Errors errors,
			HttpSession session, RedirectAttributes ra) {

		if (errors.hasErrors()) {
			return "User/profile.html";
		}
		Customer customer = (Customer) session.getAttribute("loggingCustomer");
		customer.setCustomerName(profile.getName());
		customer.setPhoneNumber(profile.getPhoneNumber());
		customer.setEmail(profile.getEmail());
		if (customer.getAddress() == null || customer.getAddress().getAddressId() <= 0) {
			customer.setAddress(new Address());
		}
		customer.getAddress().setAddress1(profile.getAddress1());
		customer.getAddress().setAddress2(profile.getAddress2());
//		customer.getAddress().setCity(profile.getCity());
//		customer.getAddress().setState(profile.getState());
		customer.getAddress().setZipCode(profile.getZipCode());
		customerReponsitory.save(customer);
		session.setAttribute("loggingCustomer", customer);
		ra.addFlashAttribute("message", "Update Successfully");
		return "redirect:/profile";
	}

	@PostMapping("/changePassword")
	public ResponseEntity<String> processChangePassword(@RequestParam("currentPassword") String currentPassword,
	        @RequestParam("newPassword") String newPassword, @RequestParam("confirmPassword") String confirmPassword,
	        HttpSession session, RedirectAttributes redirectAttributes) {
	    Customer customer = (Customer) session.getAttribute("loggingCustomer");
	    if (!passwordEncoder.matches(currentPassword, customer.getPwd())) {   	
	        redirectAttributes.addAttribute("error", "currentPassword");
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\": \"Current password is incorrect\"}");
	    }

	    if (!newPassword.equals(confirmPassword)) {
	        redirectAttributes.addAttribute("error", "newPasswordMismatch");
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\": \"New passwords do not match\"}");
	    }
	    String encodedNewPassword = passwordEncoder.encode(newPassword);
	    customer.setPwd(encodedNewPassword);
	    customerReponsitory.save(customer);

	    return ResponseEntity.ok().body("{\"message\": \"Password changed successfully\"}");
//	    return "redirect:/successPage";
	}


}
