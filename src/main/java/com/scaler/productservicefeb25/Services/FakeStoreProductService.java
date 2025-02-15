package com.scaler.productservicefeb25.Services;

import com.scaler.productservicefeb25.Exceptions.ProductNotFoundException;
import com.scaler.productservicefeb25.Models.Product;

public class FakeStoreProductService implements ProductService{
    @Override
    public Product getProductById(Long productId) throws ProductNotFoundException {
        return null;
    }
}
