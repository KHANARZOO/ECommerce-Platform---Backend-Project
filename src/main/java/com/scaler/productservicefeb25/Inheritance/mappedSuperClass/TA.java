package com.scaler.productservicefeb25.Inheritance.mappedSuperClass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "msc_ta ")
public class TA extends User{
    private int numberOfHelpRequest;
}
