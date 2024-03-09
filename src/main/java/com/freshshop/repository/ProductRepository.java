package com.freshshop.repository;

import com.freshshop.model.Products;
import com.freshshop.model.Report;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Products,Integer> {

    @Query("select o from Products o")
    Page<Products> getAllProducts(Pageable pageable);

    @Query("SELECT p FROM Products p WHERE p.categories.categoryId = :categoryId")
    Page<Products> findByCategoryId(Pageable pageable, @Param("categoryId") int categoryId);

    @Query("SELECT p FROM Products p WHERE p.productName LIKE %:searchName% AND p.categories.categoryId = COALESCE(:categoryId, p.categories.categoryId)")
    Page<Products> readByNameAndCategoryId(Pageable pageable, @Param("searchName") String searchName,
                                           @Param("categoryId") String categoryId);

    Products findByProductName(String productName);

    List<Products> findTop3ByOrderByProductIdDesc();

    @Query("SELECT new com.freshshop.model.Report(CONCAT(FUNCTION('YEAR', p.createdAt), '-', FUNCTION('MONTH', p.createdAt)), COUNT(p)) " +
            "FROM Products p " +
            "GROUP BY CONCAT(FUNCTION('YEAR', p.createdAt), '-', FUNCTION('MONTH', p.createdAt)) " +
            "ORDER BY CONCAT(FUNCTION('YEAR', p.createdAt), '-', FUNCTION('MONTH', p.createdAt)) ASC")
    List<Report> getProductReports();



}
