package com.company.buildings.dwelling;

import com.company.buildings.Building;
import com.company.buildings.BuildingFactory;
import com.company.buildings.Floor;
import com.company.buildings.Space;

public class DwellingFactory implements BuildingFactory {
    @Override
    public Space createSpace(double square) {
        return new Flat(square);
    }

    @Override
    public Space createSpace(int roomsCount, double square) {
        return new Flat(roomsCount, square);
    }

    @Override
    public Floor createFloor(int spacesCount) {
        return new DwellingFloor(spacesCount);
    }

    @Override
    public Floor createFloor(Space[] spaces) {
        return new DwellingFloor(spaces);
    }

    @Override
    public Building createBuilding(int floorsCount, int[] spacesCounts) {
        return new Dwelling(floorsCount, spacesCounts);
    }

    @Override
    public Building createBuilding(Floor[] floors) {
        return new Dwelling(floors);
    }
}
