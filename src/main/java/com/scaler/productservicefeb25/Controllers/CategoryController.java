package com.scaler.productservicefeb25.Controllers;

import com.scaler.productservicefeb25.Exceptions.CategoryNotFoundException;
import com.scaler.productservicefeb25.Models.Category;
import com.scaler.productservicefeb25.Services.CategoryService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    CategoryService categoryService;

    public CategoryController(@Qualifier("categoryService") CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable("id") Long categoryId) throws CategoryNotFoundException {
        categoryService.deleteCategory(categoryId);
    }

    @GetMapping("/{id}")
    public Category getCategory(@PathVariable("id") Long categoryId) throws CategoryNotFoundException {
        return categoryService.findCategoryById(categoryId);
    }
}
