package com.freshshop.controller.AdminController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.freshshop.model.Customer;
import com.freshshop.model.Roles;
import com.freshshop.repository.CustomerRepository;
import com.freshshop.repository.RoleRepository;
import com.freshshop.service.CustomerService;

@Controller
@RequestMapping("/admin")
public class AdminCustomerController {

	@Autowired
	CustomerService customerService;

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	RoleRepository rolesRepository;

	@GetMapping("/viewCustomer/{page}")
	public String showCustomer(Model model, @PathVariable("page") int page, @RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir, @RequestParam("searchName") String searchName) {
		model.addAttribute("customer", new Customer());
		Page<Customer> customerPage = null;
		if (searchName.equals("none") || searchName.equals("")) {
			customerPage = customerService.findAllCustomer(page, sortField, sortDir);
			searchName = "";
		} else {
			customerPage = customerService.findByCustomerName(page, sortField, sortDir, searchName);
		}
		List<Customer> listCustomers = customerPage.getContent();
		model.addAttribute("currentPage", page);
		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("searchName", searchName);
		model.addAttribute("totalPages", customerPage.getTotalPages());
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
		model.addAttribute("listCustomer", listCustomers);
		return "Admin/admin-Customer.html";
	}

	@GetMapping("/updateCustomer")
	public String updateCustomer(Model model, @ModelAttribute("customer") Customer customer,
			@RequestParam("role") String roleName, @RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir) {
		Optional<Customer> customer_id = customerRepository.findById(customer.getCustomerId());
		Roles roles = rolesRepository.findByRoleName(roleName);
		roles.setRoleName(roleName);
		if (customer_id != null) {
			Customer ctm = customer_id.get();
			ctm.setStatus(customer.getStatus());
			ctm.setRoles(roles);
			customerRepository.save(ctm);
			model.addAttribute("message", "Update Successfully");
		} else {
			model.addAttribute("message", "Update Failed");
		}
		return "redirect:/admin/viewCustomer/1?sortField=" + sortField + "&sortDir=" + sortDir + "&searchName=none";
	}

	@GetMapping("/deleteCustomer")
	public String deleteCustomer(Model model, @ModelAttribute("customer") Customer customer,
			@RequestParam("sortField") String sortField, @RequestParam("sortDir") String sortDir) {
		Optional<Customer> customer_id = customerRepository.findById(customer.getCustomerId());
		if (customer_id != null) {
			customerRepository.delete(customer);
			model.addAttribute("message", "Delete Successfully");
		} else {
			model.addAttribute("message", "Delete Failed");
		}
		return "redirect:/admin/viewCustomer/1?sortField=" + sortField + "&sortDir=" + sortDir + "&searchName=none";
	}

	@GetMapping("/searchNameCustomer")
	public String searchNameCustomer(Model model, @RequestParam("searchName") String searchName,
			@RequestParam("sortField") String sortField, @RequestParam("sortDir") String sortDir) {
		if (searchName.equals("none")) {
			return "redirect:/admin/viewCustomer/1?sortField=" + sortField + "&sortDir=" + sortDir + "&searchName=none";
		} else {
			return "redirect:/admin/viewCustomer/1?sortField=" + sortField + "&sortDir=" + sortDir + "&searchName="
					+ searchName;
		}
	}

}
