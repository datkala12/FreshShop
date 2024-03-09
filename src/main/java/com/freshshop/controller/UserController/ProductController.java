package com.freshshop.controller.UserController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import com.freshshop.model.Categories;
import com.freshshop.model.Products;
import com.freshshop.repository.CategoryRepository;
import com.freshshop.service.CategoryService;
import com.freshshop.service.ProductService;

@Controller

public class ProductController {
	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProductService productService;

	@Autowired
	private CategoryService categoryService;

	private final MessageSource messageSource;

	public ProductController(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	@GetMapping("/shop/page/{pageNumber}")
	public ModelAndView displayCategory(Model model, @PathVariable(name = "pageNumber") int pageNumber,
			@RequestParam(name = "cateId") String cateId, @RequestParam(name = "searchName") String searchName) {
		ModelAndView modelAndView = new ModelAndView("User/shop.html");
		List<Categories> listCate = categoryRepository.findAll();
		modelAndView.addObject("listCate", listCate);
		Page<Products> productPage = null;

		if (cateId.equals("all")) {
			if (searchName.equals("none")) {
				productPage = productService.getAllProduct(pageNumber);
			} else if (searchName != null) {
				productPage = productService.searchProductByNameAndCate(pageNumber, searchName, null);

			}
		} else {
			if (searchName.equals("none")) {
				productPage = productService.getProductByCate(pageNumber, Integer.parseInt(cateId));
			} else if (searchName != null) {
				productPage = productService.searchProductByNameAndCate(pageNumber, searchName, cateId);
			}
		}

		List<Products> listProduct = productPage.getContent();
		modelAndView.addObject("listProduct", listProduct);

		if (productPage.getTotalPages() == 0) {
			String notFoundMessage = messageSource.getMessage("notFound", new Object[] { searchName },
					LocaleContextHolder.getLocale());
			model.addAttribute("notFound", notFoundMessage);
		}
		model.addAttribute("totalPages", productPage.getTotalPages());
		model.addAttribute("currentPage", pageNumber);
		model.addAttribute("cateId", cateId);
		model.addAttribute("searchName", searchName);
		return modelAndView;
	}

	@RequestMapping(value = "getProductsByCate", method = RequestMethod.GET)
	public String getProductByCate(Model model, @RequestParam(value = "cateId") String cateId) {

		if (cateId != null) {
			Optional<Categories> categories = categoryRepository.findById(Integer.parseInt(cateId));
			if (categories.isPresent()) {
				return "redirect:/shop/page/1?cateId=" + cateId + "&&searchName=none";
			}
		}
		return "User/index.html";

	}

	@GetMapping("/searchProduct")
	public String searchProductByName(Model model, @RequestParam("searchName") String searchName,
			@RequestParam("cateId") String cateId, @RequestParam("currentPage") String currentPage) {
		if (searchName.trim().equals("")) {
			return "redirect:/shop/page/" + currentPage + "?cateId=" + cateId + "&&searchName=none";
		}
		String encodedSearchName = UriComponentsBuilder.fromUriString(searchName).build().encode().toUriString();

		return "redirect:/shop/page/1?cateId=" + cateId + "&&searchName=" + encodedSearchName;
	}
}
