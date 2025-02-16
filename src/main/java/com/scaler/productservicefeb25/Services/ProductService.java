package com.scaler.productservicefeb25.Services;

import com.scaler.productservicefeb25.Exceptions.ProductNotFoundException;
import com.scaler.productservicefeb25.Models.Product;

public interface ProductService {

    Product getProductById(Long productId) throws ProductNotFoundException;
}
