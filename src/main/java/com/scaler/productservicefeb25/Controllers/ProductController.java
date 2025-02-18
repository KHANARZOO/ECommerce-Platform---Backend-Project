package com.scaler.productservicefeb25.Controllers;

import com.scaler.productservicefeb25.Exceptions.ProductNotFoundException;
import com.scaler.productservicefeb25.Models.Product;
import com.scaler.productservicefeb25.Services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    public ProductController(@Qualifier("selfProductService") ProductService productService) {
        // Ambiguity Error: Which bean should be injected?
        this.productService = productService;
    }
    //Beans:
    // SelfProductService (SelfProductService. java) and fakeStoreProductService (FakeStoreProductService. java)
    // There are 2 classes which implements ProductService interface
    // Spring will iterate over the special classes(classes which have annotations)
    // Create beans(objects) and stores them in applicationContext
    // 1- ProductService ps1 = new FakeStoreProductService();
    // 2- ProductService ps2 = new SelfProductService();
    // when we are injecting the object of ProductService in controller
    // public ProductController(ProductService productService){}
    // spring will confuse which object to store in ProductService reference as
    // multiple classes are implementing the ProductService

    //Now comes the concept of @Primary & @Qualifier when there are multiple beans to inject, which one to choose
    // At a time in one reference we can store only one object

    //@Primary - >You can have multiple beans of the same type, but only one can be marked as @Primary.
    //If you try to mark multiple beans with @Primary, Spring will throw an error.

    //@Qualifier -> When multiple beans implement the same interface, Spring doesn’t know which one to inject, leading to an ambiguity error.
    //@Primary can set a default bean, but @Qualifier allows explicit selection of a specific bean.
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Long productId) throws ProductNotFoundException {
        return productService.getProductById(productId);
    }

    // http://localhost:8080/products
    @GetMapping()
    public List<Product> getAllProducts() throws ProductNotFoundException {
        return productService.getAllProducts();
    }
}
