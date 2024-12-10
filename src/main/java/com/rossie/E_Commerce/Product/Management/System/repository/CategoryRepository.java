package com.rossie.E_Commerce.Product.Management.System.repository;

import com.rossie.E_Commerce.Product.Management.System.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    Optional<Category> findByCategoryName(String categoryName);
    Optional<Category> findByCategoryId(Long categoryId);
}
