package com.company.myExceptions;

public class InvalidSpaceAreaException extends IllegalArgumentException{
    public InvalidSpaceAreaException(String mes){
        super(mes);
    }

}
