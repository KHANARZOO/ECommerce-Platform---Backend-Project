package com.scaler.productservicefeb25.Inheritance.tablePerClass;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Mentor extends User {
    private String companyName;
    private Double avgRating;
}
