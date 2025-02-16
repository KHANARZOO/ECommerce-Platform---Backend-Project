package com.scaler.productservicefeb25.Models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class BaseModel {
    @Id //@Id → Marks a field as the primary key.
    @GeneratedValue(strategy = GenerationType.IDENTITY)// Lets the database auto-generate the ID using auto-increment.
    private Long id;
}
