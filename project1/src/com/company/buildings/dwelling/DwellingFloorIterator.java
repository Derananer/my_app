package com.company.buildings.dwelling;

import com.company.buildings.Space;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DwellingFloorIterator implements Iterator<Space> {

    DwellingFloor dwellingFloor;
    int indexOfCurrentSpace;

    public DwellingFloorIterator(DwellingFloor dwellingFloor){
        this.dwellingFloor = dwellingFloor;
        indexOfCurrentSpace = 0;
    }

    @Override
    public boolean hasNext() {
        return indexOfCurrentSpace < this.dwellingFloor.getSpacesCount();
    }

    @Override
    public Space next()throws NoSuchElementException {
        if(hasNext()) return this.dwellingFloor.getSpace(indexOfCurrentSpace++);
        else throw new NoSuchElementException();
    }
}
