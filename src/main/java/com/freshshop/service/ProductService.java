package com.freshshop.service;

import com.freshshop.model.Products;
import com.freshshop.repository.CategoryRepository;
import com.freshshop.repository.ProductRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    ResourceLoader resourceLoader;

    public Page<Products> getAllProduct(int pageNumber){
        Pageable pageable = getPageable(pageNumber);
        Page<Products> productPage = productRepository.getAllProducts(pageable);
        return productPage;
    }


    private static Pageable getPageable(int pageNumber) {
        int pageSize = 9;
        Pageable pageable = PageRequest.of(pageNumber -1, pageSize, Sort.by("productName").descending());
        return pageable;
    }

    public Page<Products> getProductByCate(int pageNumber, int cateId){
        Pageable pageable = getPageable(pageNumber);
        Page<Products> productPage = productRepository.findByCategoryId(pageable, cateId);
        return productPage;
    }
    public Page<Products> searchProductByNameAndCate(int pageNumber, String searchName, String cateId){
        Pageable pageable = getPageable(pageNumber);
        Page<Products> productPage = productRepository.readByNameAndCategoryId(pageable,searchName,cateId);
        return productPage;
    }

    public String getImageName(Model model, @RequestParam("product_img") MultipartFile file) {
        String filename = "";
        try {
            String uploadRootPath = resourceLoader.getResource("classpath:static/product_img/").getFile()
                    .getAbsolutePath();

            if (!Files.exists(Paths.get(uploadRootPath))) {
                Files.createDirectories(Paths.get(uploadRootPath));
            }

            filename = file.getOriginalFilename();
            Path filePath = Paths.get(uploadRootPath, filename);
            Files.write(filePath, file.getBytes());
            // Kiểm tra định dạng của tệp
            boolean isImage = Files.probeContentType(filePath).startsWith("image");

            if (!isImage) {
                model.addAttribute("error", "Không phải định dạng hình ảnh");
            }
            return filename;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return filename;
    }


}
