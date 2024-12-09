package com.rossie.E_Commerce.Product.Management.System.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rossie.E_Commerce.Product.Management.System.controller.ResponseHandler;
import com.rossie.E_Commerce.Product.Management.System.dto.ProductDto;
import com.rossie.E_Commerce.Product.Management.System.dto.ProductResponseDto;
import com.rossie.E_Commerce.Product.Management.System.exception.EntityExistsException;
import com.rossie.E_Commerce.Product.Management.System.model.Product;
import com.rossie.E_Commerce.Product.Management.System.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * The type Product service.
 */
@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ObjectMapper objectMapper;

    /**
     * Instantiates a new Product service.
     *
     * @param productRepository the product repository
     * @param objectMapper      the object mapper
     */
    public ProductServiceImpl(ProductRepository productRepository, ObjectMapper objectMapper) {
        this.productRepository = productRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public List<ProductResponseDto> getAllProducts() {
        return objectMapper.convertValue(productRepository.findAll(), new TypeReference<>() {
        });
    }

    @Override
    public ProductResponseDto getProductById(Long id) {
        Product product= productRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Product with id " + id + "does not exist"));
        return objectMapper.convertValue(product, ProductResponseDto.class);
    }

    @Override
    public ProductResponseDto addProduct(ProductDto productDto) {
        Optional<Product> productByName = productRepository.findProductByProductName(productDto.productName());
        if (productByName.isPresent()) {
            System.out.println("Product with name " + productDto.productName() + " already exists");
            throw new EntityExistsException("Product with name " + productDto.productName() + " already exists");
        }

        Product product = Product.builder()
                .productName(productDto.productName())
                .productDescription(productDto.productDescription())
                .productPrice(productDto.productPrice())
                .productStock(productDto.productStock())
                .createAt(LocalDateTime.from(Instant.now()))
                .build();
        productRepository.save(product);
        return objectMapper.convertValue(product, ProductResponseDto.class);
    }

    @Override
    public Object deleteProductById(Long id) {
       boolean exists = productRepository.existsById(id);
       if (!exists) {
           throw new EntityNotFoundException("Product with id " + id + " does not exist");
       }

       productRepository.deleteById(id);
       return ResponseHandler.success(productRepository.findProductByProductId(id), "Product Deleted!", HttpStatus.OK);
    }

    @Override
    public ProductResponseDto updateProductById(Long productId, ProductDto productDto) {
        Product product = productRepository.findProductByProductId(productId).orElseThrow(() -> new EntityNotFoundException("Product with id " + productId + "does not exist"));
        if (productDto.productName() != null && !productDto.productName().isEmpty() &&
                !Objects.equals(productDto.productName(), product.getProductName())) {
            product.setProductName(productDto.productName());
        }

        if (productDto.productDescription() != null && !productDto.productDescription().isEmpty() && !Objects.equals(productDto.productDescription(), product.getProductDescription())) {
            product.setProductDescription(productDto.productDescription());
        }

        productRepository.save(product);
        return objectMapper.convertValue(product, ProductResponseDto.class);
    }

}
