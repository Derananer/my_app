package com.company.buildings.dwelling;

import com.company.buildings.Floor;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DwellingIterator implements Iterator<Floor> {

    Dwelling dwelling;
    int indexOfCurrentFloor;

    public DwellingIterator(Dwelling dwelling){
        this.dwelling = dwelling;
        this.indexOfCurrentFloor = 0;
    }


    @Override
    public boolean hasNext() {
        return indexOfCurrentFloor < this.dwelling.getFloorsCount();
    }

    @Override
    public Floor next() throws NoSuchElementException{
        if(hasNext())return this.dwelling.getFloor(indexOfCurrentFloor++);
        else throw new NoSuchElementException();
    }
}
