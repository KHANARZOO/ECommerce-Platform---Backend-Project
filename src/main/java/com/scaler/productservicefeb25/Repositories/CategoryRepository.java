package com.scaler.productservicefeb25.Repositories;

import com.scaler.productservicefeb25.Models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    Optional<Category> findByName(String categoryName);

    @Override
    Category save(Category category);

//JpaRepository is a Spring Data JPA interface that provides built-in methods like save(), findById(), etc
//Spring Boot Automatically Creates an Implementation
//Spring scans for interfaces that extend JpaRepository.
//At runtime, it creates a proxy class that implements ProductRepository.
//This proxy class is registered as a Spring Bean.
// When SelfProductService is created, Spring injects the proxy object (the real implementation) for ProductRepository and CategoryRepository
// Spring does NOT inject the interface itself. Instead, it injects an auto-generated class that implements the interface.

    //✅ Interfaces cannot be instantiated directly.
    //✅ Spring Boot automatically creates a proxy implementation for ProductRepository and CategoryRepository.
    //✅ Spring injects these proxy objects into SelfProductService using Dependency Injection (DI).
    //✅ You don’t have to manually implement repository interfaces—Spring Data JPA does it for you.

}
