package com.scaler.productservicefeb25.Services;

import com.scaler.productservicefeb25.Dtos.FakeStoreProductDto;
import com.scaler.productservicefeb25.Exceptions.ProductNotFoundException;
import com.scaler.productservicefeb25.Models.Category;
import com.scaler.productservicefeb25.Models.Product;
import org.springframework.web.client.RestTemplate;

//Serialization	Converting a Java object → JSON
//Deserialization	Converting JSON → Java object
public class FakeStoreProductService implements ProductService{

    //Key Features of RestTemplate
    // Sends HTTP Requests (GET, POST, PUT, DELETE, etc.)
    // Receives Responses and Converts Them into Java objects
    // Handles HTTP Headers & Parameters easily
    // Supports Serialization & Deserialization (JSON, XML)
    RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    public Product convertFakeStoreProductDtoToProduct(FakeStoreProductDto fakeStoreProductDto){
        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setPrice(fakeStoreProductDto.getPrice());

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
            throw new ProductNotFoundException("Product with id" + productId + "not found");
        }
        return convertFakeStoreProductDtoToProduct(fakeStoreProductDto);
    }
}
