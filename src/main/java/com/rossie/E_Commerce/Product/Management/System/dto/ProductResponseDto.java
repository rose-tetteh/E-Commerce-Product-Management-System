package com.rossie.E_Commerce.Product.Management.System.dto;

import com.rossie.E_Commerce.Product.Management.System.model.Category;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ProductResponseDto(
        Long productId,
        String productName,
        String productDescription,
        BigDecimal productPrice,
        int productStock,
        Category category,
        LocalDateTime createdAt
) {}
