package com.rossie.E_Commerce.Product.Management.System.controller;

import com.rossie.E_Commerce.Product.Management.System.dto.CategoryDto;
import com.rossie.E_Commerce.Product.Management.System.service.CategoryServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * The type Category controller.
 */
@RestController
@RequestMapping(path = "/api/v1/")
public class CategoryController {
    private final CategoryServiceImpl categoryService;

    /**
     * Instantiates a new Category controller.
     *
     * @param categoryService the category service
     */
    public CategoryController(CategoryServiceImpl categoryService) {
        this.categoryService = categoryService;
    }

    /**
     * Gets categories.
     *
     * @return the categories
     */
    @GetMapping("categories")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Object> getCategories() {
        return ResponseHandler.success(categoryService.getAll(), "All Categories", HttpStatus.OK);
    }

    /**
     * Create category response entity.
     *
     * @param category the category
     * @return the response entity
     */
    @PostMapping("createCategory")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> createCategory(@RequestBody CategoryDto category) {
        return ResponseHandler.success(categoryService.add(category), "Category Created", HttpStatus.CREATED);
    }

    /**
     * Gets category by id.
     *
     * @param id the id
     * @return the category by id
     */
    @GetMapping("category/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Object> getCategoryById(@PathVariable("id") Long id) {
        return ResponseHandler.success(categoryService.getById(id), "Category Found", HttpStatus.OK);
    }

    /**
     * Delete category by id response entity.
     *
     * @param id the id
     * @return the response entity
     */
    @DeleteMapping("category/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Object> deleteCategoryById(@PathVariable("id") Long id) {
        return ResponseHandler.success(categoryService.deleteById(id), "Category Deleted", HttpStatus.OK);
    }

    /**
     * Gets category by name.
     *
     * @param name the name
     * @return the category by name
     */
    @GetMapping("category/{name}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Object> getCategoryByName(@PathVariable("name") String name) {
        return ResponseHandler.success(categoryService.getByName(name), "Category Found", HttpStatus.OK);
    }

    /**
     * Update category response entity.
     *
     * @param id       the id
     * @param category the category
     * @return the response entity
     */
    @PutMapping("category/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Object> updateCategory(@PathVariable("id") Long id, @RequestBody CategoryDto category) {
        return ResponseHandler.success(categoryService.updateById(id, category), "Category Updated", HttpStatus.OK);
    }
}
