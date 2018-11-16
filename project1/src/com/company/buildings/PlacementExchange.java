package com.company.buildings;

import com.company.myExceptions.FloorIndexOutOfBoundsException;
import com.company.myExceptions.InexchangeableFloorsException;
import com.company.myExceptions.InexchangeableSpaceException;
import com.company.myExceptions.SpaceIndexOutOfBoundsException;

public class PlacementExchange {

    public static boolean exchangeSpaceOpportunity(Space space1, Space space2){

        return space1.getRoomCount()==space2.getRoomCount() && space1.getSquare() == space2.getRoomCount();

    }

    public static boolean exchangeFloorOpportunity(Floor floor1, Floor floor2){

        return floor1.getTotalFloorSquare() == floor2.getTotalFloorSquare() &&
                floor1.getSpacesCount() == floor2.getSpacesCount();
    }


    public static void exchangeSpaces(Floor floor1, int index1 , Floor floor2, int index2)
            throws InexchangeableSpaceException, SpaceIndexOutOfBoundsException {

        if(exchangeSpaceOpportunity(floor1.getSpace(index1),floor2.getSpace(index2))){
            Space tmp = floor1.getSpace(index1);
            floor1.changeSpace(index1,floor2.getSpace(index2));
            floor2.changeSpace(index2,tmp);
        }
        else throw new InexchangeableSpaceException("невозможно обменять ...");
    }


    public static void exchangeFloors(Building building1,int index1, Building building2,int index2)
            throws InexchangeableFloorsException, FloorIndexOutOfBoundsException {

        if(exchangeFloorOpportunity(building1.getFloor(index1),building2.getFloor(index2))){
            Floor tmp = building1.getFloor(index1);
            building1.changeFloor(index1,building2.getFloor(index2));
            building2.changeFloor(index2,tmp);
        }
        else throw new InexchangeableFloorsException("невозможно обменять ...");

    }



}
