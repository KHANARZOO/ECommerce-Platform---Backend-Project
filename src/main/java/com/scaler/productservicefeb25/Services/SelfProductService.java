package com.scaler.productservicefeb25.Services;

import com.scaler.productservicefeb25.Exceptions.ProductNotFoundException;
import com.scaler.productservicefeb25.Models.Category;
import com.scaler.productservicefeb25.Models.Product;
import com.scaler.productservicefeb25.Projections.ProductWithTitleAndPrice;
import com.scaler.productservicefeb25.Repositories.CategoryRepository;
import com.scaler.productservicefeb25.Repositories.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("selfProductService")
//@Primary
public class SelfProductService implements ProductService {

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    public SelfProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }
    @Override
    public Product getProductById(Long productId) throws ProductNotFoundException {

        Optional<Product> optionalProduct = productRepository.findById(productId);
        if(optionalProduct.isEmpty()){
            throw new ProductNotFoundException("Prouduct with id " + productId + " not found");
        }
        return optionalProduct.get();
    }


//Without pageable
//    @Override
//    public List<Product> getAllProducts() throws ProductNotFoundException {
//        List<Product> products = productRepository.findAll();
//        if(products.isEmpty()){
//            throw new ProductNotFoundException("Product list is empty");
//        }
//        return products;
//    }

//With pageable
    @Override
    public Page<Product> getAllProducts(int pageNumber, int pageSize) throws ProductNotFoundException {
        return productRepository.findAll(
            PageRequest.of(pageNumber, pageSize, Sort.by("title").descending())
        );
    }
    @Override
    public Product createProduct(Product product) {
        Category category = product.getCategory();
        Optional<Category> optionalCategory = categoryRepository.findByName(category.getName());
        //Checks if the product's category already exists in the database.
        if(optionalCategory.isEmpty()){
//            It searches the database for a category with the same name using categoryRepository.findByName(category.getName()).
//            This returns an Optional<Category>, meaning:
//            If the category exists, it will contain the category.
//            If the category does not exist, it will be empty.

                    category = categoryRepository.save(category);
        }else{
            category = optionalCategory.get();
            //The get() method retrieves the value inside the Optional, returning an instance of Category
        }
        product.setCategory(category);
        return productRepository.save(product);

    }

    @Override
    public Product replaceProduct(Long productId, Product product) throws ProductNotFoundException{
        Optional<Product> optionalProduct = productRepository.findById(productId);

        if(optionalProduct.isEmpty()){
            throw new ProductNotFoundException("Product with ID "+" "+productId+" "+"doesn't exists");
        }else{

            Product productFromDB = optionalProduct.get();
            productFromDB.setTitle(product.getTitle());
            productFromDB.setDescription(product.getDescription());
            productFromDB.setPrice(product.getPrice());
            productFromDB.setImageUrl(product.getImageUrl());

            Category category = product.getCategory();
            if(category.getId() == null){
                category = categoryRepository.save(category);
            }
            productFromDB.setCategory(category);
            return productRepository.save(productFromDB);
        }

    }

    @Override
    public void deleteProduct(Long productId) throws ProductNotFoundException {
        Optional<Product> optionalProduct = productRepository.findById(productId);

        if(optionalProduct.isEmpty()){
            throw new ProductNotFoundException("Product with ID "+productId+" not found");
        }
        productRepository.deleteById(productId);
    }

    @Override
    public List<ProductWithTitleAndPrice> getProductWithTitleAndPrice(String title, String price) throws ProductNotFoundException {
        return productRepository.getProductTitleAndPrice(title, price);
    }


    //Step 1: Spring scans for repository interfaces.
    //ProductRepository and CategoryRepository are interfaces extending JpaRepository, so Spring automatically provides implementations at runtime.
    //Step 2: Spring registers them as Beans.
    //These implementations are stored in Spring’s Application Context (a container that manages beans).
    //Step 3: Spring injects them into SelfProductService using Constructor Injection.
    //When SelfProductService is created, Spring checks for required dependencies and injects the available beans.
}
