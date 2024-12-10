package com.rossie.E_Commerce.Product.Management.System.dto;

import java.util.Set;

public record CategoryResponseDto(
        Long categoryId,
        String categoryName,
        String description,
        Set<ProductResponseDto> products
) {
}
