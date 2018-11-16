package com.company.buildings;

public interface  Space extends Cloneable, Comparable<Space> {
    int getRoomCount();
    void changeRoomCount(int newRoomCount);
    double getSquare();
    String toString();
    void changeSquare(double newSquare);
    Object clone();
    int hashCode();
    boolean equals(Object object);

}
