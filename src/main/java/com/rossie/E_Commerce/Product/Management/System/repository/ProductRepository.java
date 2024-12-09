package com.rossie.E_Commerce.Product.Management.System.repository;

import com.rossie.E_Commerce.Product.Management.System.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * The interface Product repository.
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    /**
     * Find product by product id optional.
     *
     * @param productId the product id
     * @return the optional
     */
    @Query
    Optional<Product> findProductByProductId(Long productId);

    /**
     * Find product by product name optional.
     *
     * @param productName the product name
     * @return the optional
     */
    @Query
    Optional<Product> findProductByProductName(String productName);

}
