package com.scaler.productservicefeb25.Models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "categories")
public class Category extends BaseModel {
    private String name;

    @OneToMany(mappedBy = "category", cascade = {CascadeType.PERSIST}, fetch = FetchType.LAZY)
    private List<Product> products;
}
