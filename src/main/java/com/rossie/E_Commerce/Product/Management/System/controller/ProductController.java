package com.rossie.E_Commerce.Product.Management.System.controller;

import com.rossie.E_Commerce.Product.Management.System.dto.ProductDto;
import com.rossie.E_Commerce.Product.Management.System.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/")
public class ProductController {
    private final ProductService productService;

    /**
     * Instantiates a new Product controller.
     *
     * @param productService the product service
     */
    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    /**
     * Gets all products.
     *
     * @return the all products
     */
    @GetMapping("v1/products")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Object> getAllProducts() {
        return ResponseHandler.success(productService.getAllProducts(), "All Products", HttpStatus.OK);
    }

    /**
     * Add product response entity.
     *
     * @param productDto the product dto
     * @return the response entity
     */
    @PostMapping("v1/addProduct")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> addProduct(@RequestBody ProductDto productDto) {
        return ResponseHandler.success(productService.addProduct(productDto), "Product Added", HttpStatus.CREATED);
    }

    /**
     * Gets product by id.
     *
     * @param productId the product id
     * @return the product by id
     */
    @GetMapping("v1/products/{productId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Object> getProductById(@PathVariable(value = "productId") Long productId) {
        return ResponseHandler.success(productService.getProductById(productId), "Product Found", HttpStatus.OK);
    }

    /**
     * Delete product response entity.
     *
     * @param productId the product id
     * @return the response entity
     */
    @DeleteMapping("v1/product/{productId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Object> deleteProduct(@PathVariable(value = "productId") Long productId) {
        return ResponseHandler.success(productService.deleteProductById(productId), "Product Deleted", HttpStatus.OK);
    }

    /**
     * Update product response entity.
     *
     * @param productId  the product id
     * @param productDto the product dto
     * @return the response entity
     */
    @PutMapping("v1/project/{productId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Object> updateProduct(@PathVariable("productId") Long productId,@RequestBody ProductDto productDto) {
        return ResponseHandler.success(productService.updateProductById(productId, productDto), "Product Updated", HttpStatus.OK);
    }

}
