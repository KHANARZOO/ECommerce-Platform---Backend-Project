package com.scaler.productservicefeb25.Repositories;

import com.scaler.productservicefeb25.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

//springDataJPA --> provides JPA support along with hibernate support
//All the methods will be provided by JPA interface but implemented by hibernate (ORM)
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Override
    Optional<Product> findById(Long productId);
    //select * from products where id = products
    //Optional:- Optional<T> is a container object that may or may not contain a non-null value.
    // If the product exists → Optional contains the product.
    //If the product does not exist → Optional is empty (avoids NullPointerException).
    //Spring Data JPA never returns null for collections—always an empty list.
    //If findById(id) returned Product directly and the product didn’t exist, it would return null.
    //Accessing null.getSomething() would throw a NullPointerException.

    //If product with ID 100L does not exist, findById() will return:
    //It will return - Optional.empty() // Represents absence of a value
    // It will NOT return null, but an Optional wrapper with no value inside.


    @Override
    List<Product> findAll();
    //Why no optional here?
    //Optional is for Single Objects, Not Collections
    //Optional<T> is designed to handle a single value that may or may not be present.
    //List<Product> is never null in Spring Data JPA—it returns an empty list ([]) if no records are found.
    //Wrapping a list in Optional (Optional<List<Product>>) is unnecessary because an empty list already conveys "no data."
    //It adds unnecessary complexity (List is already a container).

    Optional<Product> findByTitleContains(String title);
    //select * from products where title like '%title%'

    Optional<Product> findByCategory_Id(Long categoryId);
    //kind of join query

}
//JpaRepository<T, ID> is an interface in Spring Data JPA that provides built-in methods for database
// operations like CRUD (Create, Read, Update, Delete) without writing boilerplate code.

//T → Entity class type (e.g., User).--> Models
//ID → Type of the primary key (e.g., Long, UUID, Integer).

//Commonly Used Methods in JpaRepository
//Method	Description
//save(T entity)	Saves or updates an entity
//findById(ID id)	Finds an entity by primary key
//findAll()	Retrieves all records
//delete(T entity)	Deletes an entity
//deleteById(ID id)	Deletes an entity by ID
//existsById(ID id)	Checks if an entity exists by ID
//count()	Returns the count of records