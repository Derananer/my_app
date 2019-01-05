package com.company.buildings.officeBuilding;

import com.company.buildings.Space;
import com.company.myExceptions.InvalidRoomsCountException;
import com.company.myExceptions.InvalidSpaceAreaException;
//import org.jetbrains.annotations.NotNull;


public class Office implements Space{
    private double square;
    private int roomCount;
    private final int ROOM_COUNT = 2;
    private final double OFFICE_SQUARE = 50;

    public Office() {
        roomCount = ROOM_COUNT;
        square = OFFICE_SQUARE;

    }

    public Object clone(){
        return new Office(this.roomCount,this.square);
    }

    public Office(double square) {
        roomCount = ROOM_COUNT;
        this.square = square;

    }

    public Office(int roomCount, double square) {
        this.roomCount = roomCount;
        this.square = square;
    }

    public String toString(){
        String string = new String("Office (" + this.getRoomCount() + ", " + this.getSquare() + ")");
        return string;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Office){
            return ((Office) obj).roomCount == this.roomCount &&
                    ((Office) obj).square == this.square;
        }
        return false;
    }

    public int hashCode(){
        return this.roomCount ^ Double.hashCode(this.square);
    }

    public int getRoomCount() {
        return roomCount;
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
    public int compareTo(Space o) {
        return (int)(100 * o.getSquare() - 100 * this.getSquare());
    }
}
