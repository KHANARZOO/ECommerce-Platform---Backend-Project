package com.scaler.productservicefeb25.Inheritance.joinedTable;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "jt_users")
@Inheritance(strategy = InheritanceType.JOINED)
//The @Inheritance(strategy = InheritanceType.JOINED) annotation in JPA is used to map an inheritance hierarchy to multiple database tables, where
// each subclass has its own table and is linked to the parent table using a foreign key.
public class User {
    @Id
    private Long id;
    private String name;
    private String email;
    private String password;
}
