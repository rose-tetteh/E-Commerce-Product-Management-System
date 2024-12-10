package com.rossie.E_Commerce.Product.Management.System.controller;

import com.rossie.E_Commerce.Product.Management.System.dto.ProductDto;
import com.rossie.E_Commerce.Product.Management.System.service.ProductService;
import com.rossie.E_Commerce.Product.Management.System.service.ProductServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * The type Product controller.
 */
@RestController
@RequestMapping(path = "/api/")
public class ProductController {
    private final ProductServiceImpl productServiceImpl;

    /**
     * Instantiates a new Product controller.
     *
     * @param productServiceImpl the product service
     */
    public ProductController(ProductServiceImpl productServiceImpl) {
        this.productServiceImpl = productServiceImpl;
    }


    /**
     * Gets all products.
     *
     * @return the all products
     */
    @GetMapping("v1/products")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Object> getAllProducts() {
        return ResponseHandler.success(productServiceImpl.getAll(), "All Products", HttpStatus.OK);
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
        return ResponseHandler.success(productServiceImpl.add(productDto), "Product Added", HttpStatus.CREATED);
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
        return ResponseHandler.success(productServiceImpl.getById(productId), "Product Found", HttpStatus.OK);
    }

    /**
     * Gets product by name.
     *
     * @param productName the product name
     * @return the product by name
     */
    @GetMapping("v1/products/{productName}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Object> getProductByName(@PathVariable(value = "productName") String productName) {
        return ResponseHandler.success(productServiceImpl.getByName(productName), "Product Found", HttpStatus.OK);
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
        return ResponseHandler.success(productServiceImpl.deleteById(productId), "Product Deleted", HttpStatus.OK);
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
        return ResponseHandler.success(productServiceImpl.updateById(productId, productDto), "Product Updated", HttpStatus.OK);
    }

    /**
     * Gets products by category id.
     *
     * @param categoryId the category id
     * @return the products by category id
     */
    @GetMapping("/products/{categoryId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Object> getProductsByCategoryId(@PathVariable(value = "categoryId") Long categoryId) {
        return ResponseHandler.success(productServiceImpl.getProductsByCategory(categoryId), "Products in Category", HttpStatus.OK);
    }



}
