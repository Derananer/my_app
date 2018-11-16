package com.company.buildings;

import com.company.myExceptions.SpaceIndexOutOfBoundsException;

import java.io.Serializable;

public interface Floor extends Iterable<Space>, Comparable<Floor>, Serializable, Cloneable{
    int getSpacesCount();
    double getTotalFloorSquare();
    int getTotalRoomCount();
    Space[] getSpaces();
    String toString();
    int hashCode();
    Object clone();
    java.util.Iterator iterator();
    boolean equals(Object obj);
    Space getSpace(int index)throws SpaceIndexOutOfBoundsException;
    void changeSpace(int index, Space newSpace)throws SpaceIndexOutOfBoundsException;
    void insertSpace(int index, Space newSpace)throws SpaceIndexOutOfBoundsException;
    void delSpace(int index)throws SpaceIndexOutOfBoundsException;
    Space getBestSpace();
}
