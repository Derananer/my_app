package com.company.buildings;

import java.io.Serializable;

public interface  Space extends Cloneable, Comparable<Space>,Serializable {
    int getRoomCount();
    void changeRoomCount(int newRoomCount);
    double getSquare();
    String toString();
    void changeSquare(double newSquare);
    Object clone();
    int hashCode();
    boolean equals(Object object);

}
