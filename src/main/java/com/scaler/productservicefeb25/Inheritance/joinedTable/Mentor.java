package com.scaler.productservicefeb25.Inheritance.joinedTable;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "jt_mentors")
@PrimaryKeyJoinColumn(name = "user_id")
public class Mentor extends User {
    private String companyName;
    private Double avgRating;
}
