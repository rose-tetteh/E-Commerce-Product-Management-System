package com.rossie.E_Commerce.Product.Management.System.dto;

import java.math.BigDecimal;

public record ProductResponseDto(
        Long id,
        String productName,
        String productDescription,
        BigDecimal productPrice,
        int ptoductStock
) {}
