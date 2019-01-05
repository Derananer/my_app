package com.company.buildings.dwelling;

import com.company.buildings.Space;
import com.company.myExceptions.InvalidRoomsCountException;
import com.company.myExceptions.InvalidSpaceAreaException;
//import org.jetbrains.annotations.NotNull;

import java.io.Serializable;

public class Flat implements Space {
    private double square;
    private int roomCount;
    private final int ROOM_COUNT = 2;
    private final double FLAT_SQUARE = 50;
    public Flat(){
        roomCount = 2;
        square = 50;

    }
    public Flat(double square){
        roomCount = 2;
        this.square = square;

    }
    public Flat(int roomCount, double square){
        this.roomCount = roomCount;
        this.square = square;
    }
    public String toString(){
        String string = new String("Flat (" + this.getRoomCount() + ", " + this.getSquare() + ")");
        return string;
    }
    public int getRoomCount(){
        return roomCount;
    }

    public boolean equals(Object obj) {
        if(obj instanceof Flat){
            return ((Flat) obj).roomCount == this.roomCount &&
                    ((Flat) obj).square == this.square;
        }
        return false;
    }

    public int hashCode(){
        return this.roomCount ^ Double.hashCode(this.getSquare());
    }

    public double getSquare() {
        return square;
    }

    public void changeRoomCount(int newRoomCount)throws InvalidRoomsCountException {
        if (newRoomCount > 0) this.roomCount = newRoomCount;
        else throw new InvalidRoomsCountException("invalid argument");
    }

    public void changeSquare(double newSquare)throws InvalidSpaceAreaException {
        if(newSquare > 0) this.square = newSquare;
        else throw new InvalidSpaceAreaException("invalid space");
    }

    @Override
    public Object clone() {
        return new Flat(this.roomCount,this.square);
    }

    @Override
    public int compareTo(Space o) {
        return (int)(100 * o.getSquare() - 100 * this.getSquare());
    }

}
