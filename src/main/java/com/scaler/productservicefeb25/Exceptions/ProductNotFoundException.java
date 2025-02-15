package com.scaler.productservicefeb25.Exceptions;

public class ProductNotFoundException extends Exception{
    public ProductNotFoundException(String message){
        //In Java, super is a keyword used to refer to the parent class (superclass) of a class. It is commonly used for
        //Calling the parent class constructor
        super(message);
    }
}
