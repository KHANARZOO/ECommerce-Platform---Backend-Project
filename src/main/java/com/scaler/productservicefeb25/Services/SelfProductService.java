package com.scaler.productservicefeb25.Services;

import com.scaler.productservicefeb25.Exceptions.ProductNotFoundException;
import com.scaler.productservicefeb25.Models.Product;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("selfProductService")
//@Primary
public class SelfProductService implements ProductService {

    @Override
    public Product getProductById(Long productId) throws ProductNotFoundException {
        return new Product();
    }

    @Override
    public List<Product> getAllProducts() throws ProductNotFoundException {
        return List.of();
    }
}
