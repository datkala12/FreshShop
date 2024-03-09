package com.freshshop.controller.UserController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.freshshop.implementation.CartImp;
import com.freshshop.model.Customer;
import com.freshshop.model.Products;
import com.freshshop.repository.CustomerRepository;
import com.freshshop.repository.ProductRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {
	@Autowired
	private CustomerRepository customerReponsitory;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private HttpServletRequest request;

	@Autowired
	private CartImp cartImp;

	@GetMapping({ "/", "/home" })
	public String getHome(Model model, Authentication authentication, HttpSession session) {
		int itemInCart = cartImp.getSize();
		session.setAttribute("itemInCart", itemInCart);
		List<Products> productsList = productRepository.findTop3ByOrderByProductIdDesc();
		model.addAttribute("productList", productsList);
		if (authentication == null) {
			return "User/index.html";
		}
		Customer customer = customerReponsitory.readByEmail(authentication.getName());
		if (customer != null && customer.getCustomerId() > 0) {
			model.addAttribute("userName", customer.getCustomerName());
			model.addAttribute("roles", authentication.getAuthorities().toString());
			session.setAttribute("loggingCustomer", customer);
			if(customer.getRoles().getRoleId() == 1) {
				 return "redirect:/admin/dashboard";
			}
		}
		return "User/index.html";
	}

}
