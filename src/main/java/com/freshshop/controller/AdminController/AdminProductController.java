package com.freshshop.controller.AdminController;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.freshshop.model.Categories;
import com.freshshop.model.Products;
import com.freshshop.repository.CategoryRepository;
import com.freshshop.repository.ProductRepository;
import com.freshshop.service.FileUploadService;
import com.freshshop.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/admin")
public class AdminProductController {

	@Autowired
	ProductService productService;

	@Autowired
	public FileUploadService fileUploadService;

	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	ProductRepository productRepository;

	@GetMapping("/product")
	public String showFormProduct(Model model, @RequestParam("pageSize") Optional<Integer> pageSize,
			@RequestParam("currentPage") Optional<Integer> currentPage,
			@RequestParam("keywords") Optional<String> keywords, @RequestParam("category") Optional<String> category,
			@ModelAttribute("product") Products product, Optional<String> error, Optional<String> success) {
		// Phần sort cho sản phẩm
		Sort sort = Sort.by(Direction.ASC, "productName");
		String kw = keywords.orElse("%");
		String cateId = category.orElse("0");
		if (cateId.toString().trim().equals("0")) {
			cateId = null;
		}
		// Phần phân trang cho sản phẩm
		Pageable pageable = PageRequest.of(currentPage.orElse(0), pageSize.orElse(10), sort);
		Page<Products> page = productRepository.readByNameAndCategoryId(pageable, kw, cateId);
		// Hiển thị category cho form sản phẩm
		List<Categories> categories = categoryRepository.findAll();

		model.addAttribute("page", page);
		model.addAttribute("categories", categories);
		model.addAttribute("currentPage", currentPage.orElse(0));
		model.addAttribute("pageSize", pageSize.orElse(10));
		model.addAttribute("keywords", keywords.orElse(""));
//		model.addAttribute("category", category.orElse("all"));
		model.addAttribute("category", category.map(Integer::parseInt).orElse(0));
		model.addAttribute("error", error.orElse(""));
		model.addAttribute("success", success.orElse(""));

		return "Admin/admin-Products.html";
	}

	@PostMapping("/createProduct")
	public String createProduct(Model model, RedirectAttributes attributes,
			@Validated @ModelAttribute("product") Products product, Errors errors,
			@RequestParam("selectedCategory") int selectedCategoryId, @RequestParam("product_image") MultipartFile file)
			throws IOException {

		if (selectedCategoryId == 0) {
			return "redirect:/admin/product?error=Create Failed: Please enter all fields";
		}
		if (file == null) {
			return "redirect:/admin/product?error=Create Failed: Please enter all fields";
		}
		Products pr = productRepository.findByProductName(product.getProductName().trim());
		if (pr != null) {
			return "redirect:/admin/product?error=Create Failed: Product name already exists";
		}
		List<Categories> listCategories = categoryRepository.findAll();
		Categories categories = null;
		for (Categories category : listCategories) {
			if (category.getCategoryId() == selectedCategoryId) {
				categories = category;
			}
		}
		product.setCategories(categories);
		String fileURL = fileUploadService.uploadFile(file);
		product.setProduct_img(fileURL);
		product.setCreatedAt(LocalDateTime.now());
		product.setCreatedBy(null);
		productRepository.save(product);
		return "redirect:/admin/product?success=Create Success";
	}

	@PostMapping("/updateProduct")
	public String updateProduct(Model model, @Validated @ModelAttribute("product") Products product, Errors errors,
			@RequestParam("selectedCategory") int selectedCategoryId, @RequestParam("product_image") MultipartFile file)
			throws IOException {
		if (selectedCategoryId == 0) {
			return "redirect:/admin/product?error=Create Failed: Please enter all fields";
		}
//		if (product.getProduct_img().equals("") || file == null) {
//			return "redirect:/admin/product?error=Create Failed: Please enter all fields";
//		}
		List<Categories> listCategories = categoryRepository.findAll();
		Categories categories = null;
		for (Categories category : listCategories) {
			if (category.getCategoryId() == selectedCategoryId) {
				categories = category;
			}
		}
		String fileURL = "";
		if (product.getProduct_img() == null || product.getProduct_img().equals("")) {
			fileURL = fileUploadService.uploadFile(file);
		} else {
			fileURL = product.getProduct_img();
		}
		product.setCategories(categories);
		product.setProduct_img(fileURL);
		product.setCreatedAt(LocalDateTime.now());
		product.setCreatedBy(null);
		product.setUpdatedBy(null);
		productRepository.save(product);
		return "redirect:/admin/product?success=Update Success";
	}

	@PostMapping("/deleteProduct")
	public String deleteProduct(Model model, @Validated @ModelAttribute("product") Products product, Errors errors) {
		productRepository.delete(product);
		return "redirect:/admin/product?success=Delete Success";
	}

}
