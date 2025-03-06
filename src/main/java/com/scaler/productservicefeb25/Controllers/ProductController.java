package com.scaler.productservicefeb25.Controllers;

import com.scaler.productservicefeb25.Exceptions.ProductNotFoundException;
import com.scaler.productservicefeb25.Models.Product;
import com.scaler.productservicefeb25.Projections.ProductWithTitleAndPrice;
import com.scaler.productservicefeb25.Repositories.ProductRepository;
import com.scaler.productservicefeb25.Services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductRepository productRepository;
    private ProductService productService;

    public ProductController(@Qualifier("selfProductService") ProductService productService, ProductRepository productRepository) {
        // Ambiguity Error: Which bean should be injected?
        this.productService = productService;
        this.productRepository = productRepository;
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
    //without pagination
//    @GetMapping()
//    public List<Product> getAllProducts() throws ProductNotFoundException {
//        return productService.getAllProducts();
//    }
    //with Pagination
    @GetMapping
    public Page<Product> getAllProducts(@RequestParam("pageNumber") int pageNumber, @RequestParam("pageSize") int pageSize) throws ProductNotFoundException {
        return productService.getAllProducts(pageNumber, pageSize);
    }


    @PostMapping
    public Product saveProduct(@RequestBody Product product) throws ProductNotFoundException {
        return productService.createProduct(product);
    }

    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable("id") Long productId,
                                  @RequestBody Product product) throws ProductNotFoundException {
        return productService.replaceProduct(productId, product);
    }
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long productId) throws ProductNotFoundException {
        productService.deleteProduct(productId);
    }

    @GetMapping("/title/{title}/price/{price}")
    public List<ProductWithTitleAndPrice> getProductWithTitleAndPrice(@PathVariable("title") String title, @PathVariable("price") String price) throws ProductNotFoundException {
        return productService.getProductWithTitleAndPrice(title, price);
    }
}
//Hibernate(ORM) will write the queries on our behalf based on the function name
//Declared queries:- No need to write queries by our own.
//Just give a method name & ORM will create a query based on the method name
//Ex: countByTitleContains(String title)
//Select * from products where title like '%iphone%'