package com.freshshop.service;

import com.freshshop.model.Categories;
import com.freshshop.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public Page<Categories> getAllCategory(int currentPage, int pageSize) {
        Pageable pageable = getPageable(currentPage, pageSize);
        Page<Categories> categoriesPage = categoryRepository.getAllCategory(pageable);
        return categoriesPage;
    }
    public Page<Categories> getCategoryByKeyword(int currentPage, int pageSize, String keyword) {
        Pageable pageable = getPageable(currentPage, pageSize);
        Page<Categories> categoriesPage = categoryRepository.findByKeyword(pageable, keyword);
        return categoriesPage;
    }


    public static Pageable getPageable(int currentPage, int pageSize) {
        Pageable pageable = PageRequest.of(currentPage, pageSize, Sort.by("categoryId").ascending());
        return pageable;
    }

    public boolean saveCategory(Categories categories) {
        boolean isCreated = false;
        categories.setCategoryName(categories.getCategoryName());
        Categories createCategory = categoryRepository.save(categories);
        if (createCategory != null && createCategory.getCategoryId() > 0) {
            isCreated = true;
        }
        return isCreated;
    }
}
