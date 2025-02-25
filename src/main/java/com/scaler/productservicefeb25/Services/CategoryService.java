package com.scaler.productservicefeb25.Services;

import com.scaler.productservicefeb25.Exceptions.CategoryNotFoundException;
import com.scaler.productservicefeb25.Models.Category;

public interface CategoryService {

    public void deleteCategory(Long categoryId) throws CategoryNotFoundException;

    public Category findCategoryById(Long categoryId) throws CategoryNotFoundException;
}
