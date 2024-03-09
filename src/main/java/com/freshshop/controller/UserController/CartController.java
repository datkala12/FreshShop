package com.freshshop.controller.UserController;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.freshshop.implementation.CartImp;
import com.freshshop.model.Customer;
import com.freshshop.model.Products;
import com.freshshop.repository.ProductRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class CartController {
	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CartImp cartImp;

	@Autowired
	private HttpSession session;

	private final MessageSource messageSource;

	public CartController(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	@GetMapping("/viewCart")
	public String displayCartPage(Model model) {
		Collection<Products> productList = cartImp.getProducts();
		if (productList.isEmpty()) {
			return "User/cart.html";
		}
		model.addAttribute("cartProducts", cartImp.getProducts());
		model.addAttribute("count", cartImp.getCount());
		model.addAttribute("totalAmount", cartImp.getAmount());
		return "User/cart.html";
	}

	@GetMapping("/addToCart")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> addToCart(Model model, @RequestParam("productId") int productId,
			@RequestParam(name = "quantity", required = false) String quantity) {
		Customer customer = (Customer) session.getAttribute("loggingCustomer");
		if (customer == null) {
			return ResponseEntity.badRequest().body(Collections.singletonMap("error",
					messageSource.getMessage("pleaseLogin", null, LocaleContextHolder.getLocale())));
		}

		Optional<Products> product = productRepository.findById(productId);

		if (product.isPresent()) {
			if (quantity != null) {
				int qty = Integer.parseInt(quantity);
				cartImp.add(product.get(), qty);
			} else {
				cartImp.add(product.get(), 1);
			}
			session.setAttribute("itemInCart", cartImp.getSize());

			// Create a response map with the localized message and itemInCart value
			Map<String, Object> response = new HashMap<>();
			String message = messageSource.getMessage("itemAddedToCart", null, LocaleContextHolder.getLocale());
			response.put("message", message);
			response.put("itemInCart", cartImp.getSize());

			return ResponseEntity.ok(response);
		}

		return ResponseEntity.notFound().build();
	}

	@GetMapping("/deleteItemInCard")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> deleteItemInCard(Model model, @RequestParam("productId") int productId) {
		cartImp.remove(productId);
		session.setAttribute("itemInCart", cartImp.getSize());
		Map<String, Object> response = new HashMap<>();
		
		double totalAmount = cartImp.getAmount();
		response.put("totalAmount", totalAmount);
		response.put("message", "Delete successfully");
		response.put("itemInCart", cartImp.getSize());
		return ResponseEntity.ok(response);
	}

	@PostMapping("/decreaseQuantity")
	@ResponseBody
	public Map<String, Object> decreaseQuantity(Model model, @RequestParam("productId") int productId) {
		Map<String, Object> map = new HashMap<>();
		Products product = null;
		for (Products pr : cartImp.getProducts()) {
			if (pr.getProductId() == productId) {
				product = pr;
				break;
			}
		}
		if (product != null) {
			int currentQuantity = product.getQuantity();
			if (currentQuantity > 1) {
				product.setQuantity(currentQuantity - 1);
			}
			double amount = product.getPrice() * product.getQuantity();
			double totalAmount = cartImp.getAmount();
			map.put("amount", amount);
			map.put("totalAmount", totalAmount);
			map.put("quantity", product.getQuantity());
			return map;
		}
		return null;
	}

	@PostMapping("/increaseQuantity")
	@ResponseBody
	public Map<String, Object> increaseQuantity(Model model, @RequestParam("productId") int productId) {
		Map<String, Object> map = new HashMap<>();
		Products product = null;
		for (Products pr : cartImp.getProducts()) {
			if (pr.getProductId() == productId) {
				product = pr;
				break;
			}
		}
		if (product != null) {
			int currentQuantity = product.getQuantity();
			product.setQuantity(currentQuantity + 1);
			double amount = product.getPrice() * product.getQuantity();
			double totalAmount = cartImp.getAmount();
			map.put("amount", amount);
			map.put("totalAmount", totalAmount);
			map.put("quantity", product.getQuantity());
			return map;
		}
		return null;
	}
}
