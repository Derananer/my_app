package com.company.buildings;

import com.company.myExceptions.SpaceIndexOutOfBoundsException;

import java.util.Iterator;

public class SynchronizedFloor implements Floor {


    private Floor floor;

    public SynchronizedFloor(Floor floor){
        this.floor = floor;
    }

    @Override
    public synchronized int getSpacesCount() {
        return floor.getSpacesCount();
    }

    @Override
    public synchronized double getTotalFloorSquare() {
        return floor.getTotalFloorSquare();
    }

    @Override
    public synchronized String toString(){
        return floor.toString();
    }

    @Override
    public synchronized int hashCode(){
        return floor.hashCode();
    }

    @Override
    public synchronized int getTotalRoomCount() {
        return floor.getTotalRoomCount();
    }

    @Override
    public synchronized Space[] getSpaces() {
        return floor.getSpaces();
    }

    @Override
    public synchronized Object clone() {
        return floor.clone();
    }

    @Override
    public synchronized Iterator iterator() {
        return floor.iterator();
    }

    @Override public synchronized boolean equals(Object obj){
        if(obj instanceof SynchronizedFloor)return floor.equals(((SynchronizedFloor) obj).floor);
        return floor.equals(obj);
    }

    @Override
    public synchronized Space getSpace(int index) throws SpaceIndexOutOfBoundsException {
        return floor.getSpace(index);
    }

    @Override
    public synchronized void changeSpace(int index, Space newSpace) throws SpaceIndexOutOfBoundsException {
        floor.changeSpace(index, newSpace);
    }

    @Override
    public synchronized void insertSpace(int index, Space newSpace) throws SpaceIndexOutOfBoundsException {
        floor.insertSpace(index, newSpace);
    }

    @Override
    public synchronized void delSpace(int index) throws SpaceIndexOutOfBoundsException {
        floor.delSpace(index);
    }

    @Override
    public synchronized Space getBestSpace() {
        return floor.getBestSpace();
    }

    @Override
    public synchronized int compareTo(Floor o) {
        return floor.compareTo(o);
    }
}
