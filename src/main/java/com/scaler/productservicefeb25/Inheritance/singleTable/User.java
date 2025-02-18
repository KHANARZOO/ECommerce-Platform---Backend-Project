package com.scaler.productservicefeb25.Inheritance.singleTable;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "st_users")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//When multiple entity classes inherit from a common base entity, they are stored in a
//single database table. To distinguish between different subclasses, Hibernate uses a discriminator column.
@DiscriminatorColumn(
        name = "user_type",
        discriminatorType = DiscriminatorType.INTEGER
)
@DiscriminatorValue(value = "0")
public class User {
    @Id
    private Long id;
    private String name;
    private String email;
    private String password;
}
//In Single Table Inheritance, all entities in an inheritance hierarchy are stored in one database table.
//A discriminator column is used to differentiate between different entity types (subclasses).
//Advantage: Efficient because only one table is created.
//Disadvantage: Columns that are specific to a subclass will have NULL values for other subclasses.

//Default Behavior
//If @DiscriminatorColumn is not provided:
//JPA uses a default discriminator column named DTYPE.
//The default type is STRING, but it can be changed to INTEGER or CHAR.