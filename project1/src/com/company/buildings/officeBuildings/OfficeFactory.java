package com.company.buildings.officeBuildings;

import com.company.buildings.Building;
import com.company.buildings.BuildingFactory;
import com.company.buildings.Floor;
import com.company.buildings.Space;

public class OfficeFactory implements BuildingFactory {

    @Override
    public Space createSpace(double square) {
        return new Office(square);
    }

    @Override
    public Space createSpace(int roomsCount, double square) {
        return new Office(roomsCount, square);
    }

    @Override
    public Floor createFloor(int spacesCount) {
        return new OfficeFloor(spacesCount);
    }

    @Override
    public Floor createFloor(Space[] spaces) {
        return new OfficeFloor(spaces);
    }

    @Override
    public Building createBuilding(int floorsCount, int[] spacesCounts) {
        return new OfficeBuilding(floorsCount, spacesCounts);
    }

    @Override
    public Building createBuilding(Floor[] floors) {
        return new OfficeBuilding(floors);
    }
}
