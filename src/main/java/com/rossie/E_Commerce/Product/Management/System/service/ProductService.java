package com.rossie.E_Commerce.Product.Management.System.service;


import com.rossie.E_Commerce.Product.Management.System.dto.ProductDto;
import com.rossie.E_Commerce.Product.Management.System.dto.ProductResponseDto;

import java.util.List;

public interface ProductService{
    List<ProductResponseDto> getProductsByCategory(Long categoryId);
}
