package com.scaler.productservicefeb25.Inheritance.joinedTable;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "jt_ta")
@PrimaryKeyJoinColumn(name = "user_id")
public class TA extends User {
    private int numberOfHelpRequest;
}
//@PrimaryKeyJoinColumn in JPA
//The @PrimaryKeyJoinColumn annotation in JPA is used when using
// @Inheritance(strategy = InheritanceType.JOINED). It ensures that the primary
// key of a subclass is also a foreign key referencing the parent table's primary key.
//
//When to Use @PrimaryKeyJoinColumn?
// When using JOINED inheritance strategy (InheritanceType.JOINED).
// When you want subclass tables to use the same primary key as the parent table.
