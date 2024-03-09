package com.freshshop.controller.AdminController;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.freshshop.model.Categories;
import com.freshshop.repository.CategoryRepository;
import com.freshshop.service.CategoryService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/admin")
@Slf4j
public class AdminCategoryController {
	@Autowired
	CategoryService categoryService;
	@Autowired
	CategoryRepository categoryRepository;

	@RequestMapping("/category")
	public String showCategory(Model model, @RequestParam("pageSize") Optional<Integer> pageSize,
			@RequestParam("currentPage") Optional<Integer> currentPage, Optional<String> keyword) {
		Categories categories = new Categories();
		model.addAttribute("category", categories);
		model.addAttribute("page",
				categoryService.getCategoryByKeyword(currentPage.orElse(0), pageSize.orElse(10), keyword.orElse("%")));
		model.addAttribute("currentPage", currentPage.orElse(0));
		model.addAttribute("pageSize", pageSize.orElse(10));
		model.addAttribute("keyword", keyword.orElse(""));
		return "Admin/admin-Cate.html";
	}

	@RequestMapping("/createCate")
	public String createCate(Model model, RedirectAttributes redirectAttributes,
			@RequestParam("cateId") Optional<String> cateId, @RequestParam("categoryName") String categoryName) {
		System.out.println(categoryName);
		Categories categories = categoryRepository.findByCategoryName(categoryName);
		if (categoryName.trim().equals("")) {
			redirectAttributes.addFlashAttribute("message", "Category Name must not be empty");
			return "redirect:/admin/category";
		}
		if (categories != null) {
			redirectAttributes.addFlashAttribute("message",
					"The category Name : " + categoryName + " had been existed!");
			return "redirect:/admin/category";
		}
		categories = new Categories();
		categories.setCategoryName(categoryName);
		System.out.println("ok");
		System.out.println(categories.toString());
		boolean isCreated = categoryService.saveCategory(categories);
		if (isCreated) {
			redirectAttributes.addFlashAttribute("message", "Create sucessfully!");
			return "redirect:/admin/category";
		} else {
			redirectAttributes.addFlashAttribute("message", "Create Failed!");
			return "redirect:/admin/category";
		}

	}

	@RequestMapping("/updateCate")
	public String updateCate(Model model, RedirectAttributes redirectAttributes,
			@RequestParam("cateId") Optional<Integer> cateId, @RequestParam("categoryName") String categoryName) {
		Integer cateIdUpdate = cateId.orElse(0);
		Categories categories = new Categories();
		categories = categoryRepository.findByCategoryId(cateIdUpdate);
		if (categoryName.trim().equals("")) {
			redirectAttributes.addFlashAttribute("message", "Category Name must not be empty");
			return "redirect:/admin/category";
		}
		categories = categoryRepository.findByCategoryName(categoryName);
		if (categories == null) {
			categories.setCategoryName(categoryName);
			boolean isSaved = categoryService.saveCategory(categories);
			if (isSaved) {
				redirectAttributes.addFlashAttribute("message", "Update sucessfully!");
				return "redirect:/admin/category";
			} else {
				redirectAttributes.addFlashAttribute("message", "Update failed!");
				return "redirect:/admin/category";
			}
		} else {
			redirectAttributes.addFlashAttribute("message",
					"The category Name : " + categoryName + " had been existed!");
			return "redirect:/admin/category";
		}
	}

	@RequestMapping("/deleteCate")
	public String deleteCate(Model model, RedirectAttributes redirectAttributes, @RequestParam("cateId") int cateId) {
		categoryRepository.deleteById(cateId);
		redirectAttributes.addFlashAttribute("message", "Delete sucessfully!");
		return "redirect:/admin/category";
	}

}
