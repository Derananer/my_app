package com.company.myExceptions;

public  class InvalidRoomsCountException extends IllegalArgumentException{
    public InvalidRoomsCountException(String mes){
        super(mes);
    }

}
