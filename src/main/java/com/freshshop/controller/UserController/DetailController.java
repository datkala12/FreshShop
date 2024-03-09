package com.freshshop.controller.UserController;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.freshshop.model.Products;
import com.freshshop.repository.ProductRepository;

@Controller
public class DetailController {
	@Autowired
	private ProductRepository productRepository;

	@GetMapping("/displayDetail")
	public ModelAndView displayDetail(Model model, @RequestParam("productId") String productId) {
		ModelAndView modelAndView = new ModelAndView("User/shop-detail.html");
		Optional<Products> product = productRepository.findById(Integer.parseInt(productId));
		if (product.isPresent()) {
			modelAndView.addObject("product", product.get());
		}
		return modelAndView;

	}
}
