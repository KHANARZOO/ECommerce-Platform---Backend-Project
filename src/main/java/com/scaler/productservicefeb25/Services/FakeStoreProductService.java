package com.scaler.productservicefeb25.Services;

import com.scaler.productservicefeb25.Dtos.FakeStoreProductDto;
import com.scaler.productservicefeb25.Exceptions.ProductNotFoundException;
import com.scaler.productservicefeb25.Models.Category;
import com.scaler.productservicefeb25.Models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

//Serialization	Converting a Java object → JSON
//Deserialization	Converting JSON → Java object
@Service("fakeStoreProductService")//The @Service annotation is a specialized version of @Component used in Spring Boot to indicate that a class contains business logic (service layer).
public class FakeStoreProductService implements ProductService{

    //Key Features of RestTemplate
    // Sends HTTP Requests (GET, POST, PUT, DELETE, etc.)
    // Receives Responses and Converts Them into Java objects
    // Handles HTTP Headers & Parameters easily
    // Supports Serialization & Deserialization (JSON, XML)
    RestTemplate restTemplate;

    //Dependency Injection (DI) is a design pattern where Spring injects
    // dependencies (objects) automatically, so we don’t manually create them using new
    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        // Here, RestTemplate is injected into the class through the constructor.
        // The object is not created manually (new RestTemplate()), but instead provided by Spring.
    }
    public Product convertFakeStoreProductDtoToProduct(FakeStoreProductDto fakeStoreProductDto){
        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setImageUrl(fakeStoreProductDto.getImage());
        Category category = new Category();
        category.setName(fakeStoreProductDto.getCategory());
        product.setCategory(category);
        return product;
    }
    @Override
    public Product getProductById(Long productId) throws ProductNotFoundException {
        FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject(
                "https://fakestoreapi.com/products/" + productId,
                FakeStoreProductDto.class
        );

        //getForObject() - Parameters:
        //url → The URL of the API you are calling.
        //responseType → The class type to map the response into.
        //uriVariables (Optional) → URL path variables if needed.
        //Returns:
        //The response mapped to the specified class type.
        //getForObject()
        //Feature	Details
        //Usage	Fetches data from an API
        //Returns	Response mapped to a class (String, Java object, Array, etc.)
        //Automatic JSON to Object?	✅ Yes, if class matches JSON structure
        //Supports Path Variables?	✅ Yes, via {} placeholders
        //Supports Query Params?	✅ Yes, via {} placeholders
        if(fakeStoreProductDto==null){
            throw new ProductNotFoundException("Product with id " + productId + " not found");
        }
        return convertFakeStoreProductDtoToProduct(fakeStoreProductDto);
    }

    @Override
    public List<Product> getAllProducts() throws ProductNotFoundException {
        //Jackson (default JSON parser in Spring) needs a concrete type to deserialize JSON properly.
        //Generics (List<T>) cause type erasure at runtime, meaning Java loses type information.
        //Using an array (FakeStoreProductDto[]) preserves type information and allows Jackson to correctly map JSON.
        FakeStoreProductDto[] fakeStoreProductDto = restTemplate.getForObject(
                "https://fakestoreapi.com/products",
                FakeStoreProductDto[].class
        );
        List<Product> products = new ArrayList<>();
        for(FakeStoreProductDto fakeStoreProductDto1 : fakeStoreProductDto){
            products.add(convertFakeStoreProductDtoToProduct(fakeStoreProductDto1));
        }
        return products;
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public Product replaceProduct(Long productId, Product product) {
        return null;
    }

    @Override
    public void deleteProduct(Long productId) throws ProductNotFoundException {
    }
}
