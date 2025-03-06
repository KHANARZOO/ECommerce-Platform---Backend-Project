package com.scaler.productservicefeb25.Models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "products")
public class Product extends BaseModel{
    private String title;
    private String description;
    private String imageUrl;
    private double price;

    //Define cardinality
    // 1 Product --> 1 Category
    // M Product <--  1 Category
    // ManyToOne
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private Category category;
}
