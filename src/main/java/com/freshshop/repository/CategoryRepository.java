package com.freshshop.repository;

import com.freshshop.model.Categories;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Categories, Integer> {
    @Query("select o from Categories o ")
    Page<Categories> getAllCategory(Pageable pageable);

    Categories findByCategoryId(int cateId);

    @Query("select o from Categories o where o.categoryName like %:categoryName%")
    Page<Categories> findByKeyword( Pageable pageable, @Param("categoryName") String categoryName);

    Categories findByCategoryName(String categoryName);

}
