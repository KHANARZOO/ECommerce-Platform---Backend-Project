package com.scaler.productservicefeb25.Services;

import com.scaler.productservicefeb25.Exceptions.ProductNotFoundException;
import com.scaler.productservicefeb25.Models.Product;
import com.scaler.productservicefeb25.Projections.ProductWithTitleAndPrice;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {

    Product getProductById(Long productId) throws ProductNotFoundException;

//    List<Product> getAllProducts() throws ProductNotFoundException;

    Page<Product> getAllProducts(int pageNumber, int pageSize) throws ProductNotFoundException;

    Product createProduct(Product product);

    //You provide a Product object as a parameter.
    //The method processes it (e.g., saves it to the database).
    //It returns the saved Product object, usually with an auto-generated ID if it's being saved in a database.

    //The method receives newProduct, which does not have an ID yet.
    //productRepository.save(product) saves the product in the database.
    //The database generates an ID (e.g., id = 1).
    //The saved product with the generated ID is returned.

    //If product already has an ID, it updates the existing record and returns the updated product.

    Product replaceProduct(Long productId, Product product) throws ProductNotFoundException;

    void deleteProduct(Long productId) throws ProductNotFoundException;

    List<ProductWithTitleAndPrice> getProductWithTitleAndPrice(String title, String price) throws ProductNotFoundException;
}
