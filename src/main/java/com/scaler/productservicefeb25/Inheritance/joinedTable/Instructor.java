package com.scaler.productservicefeb25.Inheritance.joinedTable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Instructor extends User {
    private String specialization;
    private Double avgRating;
}
