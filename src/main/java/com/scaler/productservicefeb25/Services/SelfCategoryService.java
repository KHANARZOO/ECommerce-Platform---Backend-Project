package com.scaler.productservicefeb25.Services;

import com.scaler.productservicefeb25.Repositories.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class SelfCategoryService implements CategoryService {

    private CategoryRepository categoryRepository;

    public SelfCategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void deleteCategory(Long categoryId) {
        categoryRepository.deleteById(categoryId);
    }
}
