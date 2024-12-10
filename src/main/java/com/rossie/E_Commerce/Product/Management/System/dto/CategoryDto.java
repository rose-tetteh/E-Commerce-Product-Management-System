package com.rossie.E_Commerce.Product.Management.System.dto;

import com.rossie.E_Commerce.Product.Management.System.model.Product;

import java.time.LocalDateTime;
import java.util.Set;

public record CategoryDto(
        String categoryName,
        String description,
        Set<Product> products,
        LocalDateTime createdAt) {
}
