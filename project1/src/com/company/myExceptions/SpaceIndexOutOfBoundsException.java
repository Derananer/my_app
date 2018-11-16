package com.company.myExceptions;

public class SpaceIndexOutOfBoundsException extends IndexOutOfBoundsException{


    String boundMessage;

    public SpaceIndexOutOfBoundsException(String mes){
        super(mes);
    }
    public SpaceIndexOutOfBoundsException(String mes,int bound){
        super(mes);
        this.boundMessage = "bounds : 0 ... " + Integer.toString(bound);

    }
    public String showBounds(){
        return this.boundMessage;
    }
}
