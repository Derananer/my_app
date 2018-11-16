package com.company.buildings.officeBuildings;

import com.company.buildings.Space;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class OfficeFloorIterator implements Iterator<Space> {

    private OfficeFloor officeFloor;
    private int indexOfCurrentSpace;

    public OfficeFloorIterator(OfficeFloor officeFloor){
        this.officeFloor = officeFloor;
        this.indexOfCurrentSpace = 0;
    }

    @Override
    public boolean hasNext() {
       return indexOfCurrentSpace < this.officeFloor.getSpacesCount();
    }

    @Override
    public Space next() throws NoSuchElementException{
        if(hasNext()) return this.officeFloor.getSpace(indexOfCurrentSpace++);
        else throw new NoSuchElementException();
    }
}
