package com.scaler.productservicefeb25.Inheritance.mappedSuperClass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "msc_mentors")
public class Mentor extends User{
    private String companyName;
    private Double avgRating;
}
