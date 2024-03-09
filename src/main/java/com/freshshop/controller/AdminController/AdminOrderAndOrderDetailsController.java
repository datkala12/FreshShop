package com.freshshop.controller.AdminController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.freshshop.constant.FreshShopConstants;
import com.freshshop.model.Customer;
import com.freshshop.model.OrderDetails;
import com.freshshop.model.OrderDetailsDTO;
import com.freshshop.model.Orders;
import com.freshshop.repository.ContactUsRepository;
import com.freshshop.repository.OrderDetailRepository;
import com.freshshop.repository.OrderRepository;
import com.freshshop.repository.ProductRepository;
import com.freshshop.service.ContactUsService;
import com.freshshop.service.CustomerService;
import com.freshshop.service.OrderDetailService;
import com.freshshop.service.OrderService;
import com.freshshop.service.ProductService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminOrderAndOrderDetailsController {
	@Autowired
	ContactUsService contactUsService;

	@Autowired
	ContactUsRepository contactUsRepository;

	@Autowired
	OrderService orderService;

	@Autowired
	OrderRepository orderRepository;

	@Autowired
	private OrderDetailRepository orderDetailRepository;

	@Autowired
	OrderDetailService orderDetailService;

	@Autowired
	ProductService productService;

	@Autowired
	ProductRepository productRepository;

	@Autowired
	CustomerService customerService;

	@GetMapping("/order/{currentPage}")
	public String displayOrder(Model model, @PathVariable("currentPage") int currentPage,
			@RequestParam("statusOrder") String status, @RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir,
			@RequestParam(name = "searchName", required = false) String searchName) {
		Page<Orders> orderPage = null;
		if (searchName.equals("none") || searchName.equals("")) {
			searchName = "";
		}	
		orderPage = orderService.getAllOrder(status, currentPage, sortField, sortDir, searchName);
		List<Orders> listOrder = orderPage.getContent();
		List<Orders> listOrderStatus = orderRepository.findAll();
		double profit = 0;
		for (Orders order : listOrderStatus) {
			profit += order.getTotalAmount();
		}
//        model.addAttribute("myLocale", Locale.US);
		model.addAttribute("profit", profit);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
//		model.addAttribute("currentStatus", status);
		model.addAttribute("searchName", searchName);
		model.addAttribute("status", status);
		model.addAttribute("totalPages", orderPage.getTotalPages());
		model.addAttribute("sortDir", "asc");
		model.addAttribute("listOrder", listOrder);

		return "Admin/admin-Order.html";
	}

	@RequestMapping(value = "/closeOrder/{currentPage}", method = RequestMethod.GET)
	public String closeOrder(@RequestParam("orderId") int orderId, @PathVariable("currentPage") int currentPage,
			@RequestParam("sortField") String sortField, @RequestParam("sortDir") String sortDir,
			@RequestParam("status") String status, RedirectAttributes ra) {
		orderService.updateOrderStatus(FreshShopConstants.CLOSE, orderId);
		ra.addFlashAttribute("message", "Close Successfully");
		return "redirect:/admin/order/" + currentPage + "?sortField=" + sortField + "&sortDir=" + sortDir + "&status="
				+ status;

	}

	@GetMapping("/orderDetail")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> getOrderDetails(@RequestParam("orderId") int orderId,
			HttpSession session) {
		Customer customer = (Customer) session.getAttribute("loggingCustomer");
		List<OrderDetails> listOrderDetailDetail = orderDetailRepository.findOrderDetailsByOrderId(orderId);

		Optional<Orders> option = orderRepository.findById(orderId);
		Orders order = option.orElse(null);

		List<OrderDetailsDTO> listOrderDetailsDTO = new ArrayList<>();
		Map<String, Object> response = new HashMap<>();
		response.put("orderId", order.getOrderId());
		response.put("orderFullName", order.getFullName());
		response.put("orderEmail", "user@gmail.com");
		response.put("orderPhoneNumber", order.getPhoneNumber());
		response.put("orderAddress", order.getAddress());
		response.put("orderToltalAmount", order.getTotalAmount());
		response.put("orderSubToltal", order.getTotalAmount() - order.getTotalAmount() * 0.1);
		response.put("orderDiscount", (order.getTotalAmount() - order.getTotalAmount() * 0.9));
		response.put("orderStatus", order.getStatus());

		for (OrderDetails orderDetails : listOrderDetailDetail) {

			OrderDetailsDTO orderDetailsDTO = new OrderDetailsDTO();
			orderDetailsDTO.setProductName(orderDetails.getProduct().getProductName());
			orderDetailsDTO.setQuantity(orderDetails.getQuantity());
			orderDetailsDTO.setAmount(orderDetails.getProduct().getPrice() * orderDetails.getQuantity());
			orderDetailsDTO.setProductImage(orderDetails.getProduct().getProduct_img());
			orderDetailsDTO.setDate(orderDetails.getCreatedAt());
			orderDetailsDTO.setPrice(orderDetails.getProduct().getPrice());
			listOrderDetailsDTO.add(orderDetailsDTO);
		}

		response.put("listOrderDetailsDTO", listOrderDetailsDTO);
		return ResponseEntity.ok(response);
	}

	@PostMapping("/order/updateStatus")
	public String updateOrderStatus(@RequestParam("orderId") int orderId, @RequestParam("newStatus") String newStatus) {
		orderService.updateOrderStatus(orderId, newStatus);
		return "redirect:/admin/order/1?sortField=status&&sortDir=asc&&status=all";
	}

	@GetMapping("/order/searchNameCustomer")
	public String searchNameCustomer(Model model, @RequestParam("statusOrder") String status,
			@RequestParam(name = "searchName", required = false) String searchName,
			@RequestParam("sortField") String sortField, @RequestParam("sortDir") String sortDir) {
		if (searchName.equals("none") || searchName.equals("")) {
			return "redirect:/admin/order/1?sortField=" + sortField + "&sortDir=" + sortDir + "&statusOrder=" + status
					+ "&searchName=" + "none";
		} else {
			return "redirect:/admin/order/1?sortField=" + sortField + "&sortDir=" + sortDir + "&statusOrder=" + status
					+ "&searchName=" + searchName;
		}
	}

}
