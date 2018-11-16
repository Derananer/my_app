package com.company.buildings;

import com.company.myExceptions.FloorIndexOutOfBoundsException;
import com.company.myExceptions.SpaceIndexOutOfBoundsException;

public interface Building extends Iterable<Floor>{

    int getFloorsCount();
    int getSpacesCount();
    String toString();
    double getTotalSquare();
    int getTotalRoomCount();
    Floor[] getFloors();
    boolean equals(Object obj);
    int hashCode();
    Object clone();
    Floor getFloor(int index)throws FloorIndexOutOfBoundsException;
    void changeFloor(int index,Floor newFloor)throws FloorIndexOutOfBoundsException;
    Space getSpace(int index)throws SpaceIndexOutOfBoundsException;
    void changeSpace(int index, Space newSpace)throws SpaceIndexOutOfBoundsException;
    void delSpace(int index)throws SpaceIndexOutOfBoundsException;
    void insertSpace(int index,Space newSpace)throws SpaceIndexOutOfBoundsException;
    Space getBestSpace();
    Space[] getSortedSpaces();
}
