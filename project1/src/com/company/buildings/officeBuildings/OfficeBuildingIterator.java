package com.company.buildings.officeBuildings;

import com.company.buildings.Floor;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class OfficeBuildingIterator implements Iterator<Floor> {

    OfficeBuilding officeBuilding;
    int indexOfCurrentFloor;

    public OfficeBuildingIterator(OfficeBuilding officeBuilding){
        this.officeBuilding = officeBuilding;
        this.indexOfCurrentFloor = 0;
    }

    @Override
    public boolean hasNext() {
        return this.indexOfCurrentFloor < this.officeBuilding.getFloorsCount();
    }

    @Override
    public Floor next() throws NoSuchElementException {
        if(hasNext()) return this.officeBuilding.getFloor(indexOfCurrentFloor++);
        else throw new NoSuchElementException();
    }
}
