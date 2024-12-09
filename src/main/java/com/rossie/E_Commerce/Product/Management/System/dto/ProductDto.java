package com.rossie.E_Commerce.Product.Management.System.dto;

import java.math.BigDecimal;

public record ProductDto(
        String productName,
        String productDescription,
        BigDecimal productPrice,
        int productStock
) {}
