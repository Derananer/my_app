package com.company.buildings.hotel;

import com.company.buildings.Building;
import com.company.buildings.BuildingFactory;
import com.company.buildings.Floor;
import com.company.buildings.Space;
import com.company.buildings.dwelling.Flat;

public class HotelFactory implements BuildingFactory {
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
        return new HotelFloor(spacesCount);
    }

    @Override
    public Floor createFloor(Space[] spaces) {
        return new HotelFloor(spaces);
    }

    @Override
    public Building createBuilding(int floorsCount, int[] spacesCounts) {
        return new HotelBuilding(floorsCount,spacesCounts);
    }

    @Override
    public Building createBuilding(Floor[] floors) {
        return new HotelBuilding(floors);
    }
}
