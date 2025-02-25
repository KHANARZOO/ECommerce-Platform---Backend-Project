package com.scaler.productservicefeb25.Services;

import com.scaler.productservicefeb25.Exceptions.CategoryNotFoundException;
import com.scaler.productservicefeb25.Exceptions.ProductNotFoundException;
import com.scaler.productservicefeb25.Models.Category;
import com.scaler.productservicefeb25.Repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("categoryService")
public class SelfCategoryService implements CategoryService {

    private CategoryRepository categoryRepository;

    public SelfCategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void deleteCategory(Long categoryId) throws CategoryNotFoundException {
        categoryRepository.deleteById(categoryId);
    }

    @Override
    public Category findCategoryById(Long categoryId) throws CategoryNotFoundException {
        Optional<Category> optionalCategory =categoryRepository.findById(categoryId);

        if(optionalCategory.isEmpty()){
            throw new CategoryNotFoundException("Category with ID:- "+ categoryId+" doesn't exists");
        }
        return optionalCategory.get();
    }
}
