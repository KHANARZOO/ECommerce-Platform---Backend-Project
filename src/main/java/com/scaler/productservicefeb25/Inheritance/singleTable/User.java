package com.scaler.productservicefeb25.Inheritance.singleTable;

import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class User {
    private Long id;
    private String name;
    private String email;
    private String password;
}
