package com.rossie.E_Commerce.Product.Management.System.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rossie.E_Commerce.Product.Management.System.controller.ResponseHandler;
import com.rossie.E_Commerce.Product.Management.System.dto.CategoryDto;
import com.rossie.E_Commerce.Product.Management.System.dto.CategoryResponseDto;
import com.rossie.E_Commerce.Product.Management.System.exception.EntityExistsException;
import com.rossie.E_Commerce.Product.Management.System.model.Category;
import com.rossie.E_Commerce.Product.Management.System.repository.CategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * The type Category service.
 */
@Service
public class CategoryServiceImpl implements GenericService<CategoryResponseDto, Long> {
    private final CategoryRepository categoryRepository;
    private final ObjectMapper objectMapper;

    /**
     * Instantiates a new Category service.
     *
     * @param categoryRepository the category repository
     * @param objectMapper       the object mapper
     */
    public CategoryServiceImpl(CategoryRepository categoryRepository, ObjectMapper objectMapper) {
        this.categoryRepository = categoryRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public List<CategoryResponseDto> getAll() {
        return objectMapper.convertValue(categoryRepository.findAll(), new TypeReference<>(){});
    }

    @Override
    public CategoryResponseDto getById(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Category not found"));
        return objectMapper.convertValue(category, CategoryResponseDto.class);
    }

    @Override
    public CategoryResponseDto getByName(String name) {
        Category category= categoryRepository.findByCategoryName(name).orElseThrow(() -> new EntityNotFoundException("Category with name " + name + "does not exist"));
        return objectMapper.convertValue(category, CategoryResponseDto.class);
    }

    @Override
    public CategoryResponseDto add(Object dto) {
        CategoryDto category =  (CategoryDto) dto;
        Optional<Category> categoryByName = categoryRepository.findByCategoryName(category.categoryName());
        if (categoryByName.isPresent()) {
            throw new EntityExistsException("Category with name " + category.categoryName() + " already exists");
        }

        Category newCategory = Category.builder()
                .categoryName(category.categoryName())
                .description(category.description())
                .products(category.products())
                .createdAt(LocalDateTime.ofInstant(Instant.now(), ZoneId.systemDefault()))
                .build();
        categoryRepository.save(newCategory);
        return objectMapper.convertValue(newCategory, CategoryResponseDto.class);
    }

    @Override
    public Object deleteById(Long id) {
        boolean exists = categoryRepository.existsById(id);
        if (exists) {
            throw new EntityNotFoundException("Category with id " + id + " does not exist");
        }
        categoryRepository.deleteById(id);
        return ResponseHandler.success(categoryRepository.findByCategoryId(id), "Category Deleted", HttpStatus.OK);
    }

    @Override
    public CategoryResponseDto updateById(Long id, Object dto) {
        CategoryDto categoryDto = (CategoryDto) dto;
        Category category = categoryRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Category not found"));
        if(categoryDto.categoryName() != null && !categoryDto.categoryName().isEmpty() && !Objects.equals(categoryDto.categoryName(), category.getCategoryName())) {
            category.setCategoryName(categoryDto.categoryName());
        }

        if(categoryDto.description() != null && !categoryDto.description().isEmpty() && !Objects.equals(categoryDto.description(), category.getDescription())) {
            category.setDescription(categoryDto.description());
        }
        categoryRepository.save(category);
        return objectMapper.convertValue(category, CategoryResponseDto.class);
    }
}
