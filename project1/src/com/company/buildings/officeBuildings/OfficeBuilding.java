package com.company.buildings.officeBuildings;

import com.company.buildings.Building;
import com.company.buildings.Floor;
import com.company.buildings.Space;
import com.company.buildings.SpaceComparator;
import com.company.myExceptions.FloorIndexOutOfBoundsException;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.Iterator;

public class OfficeBuilding implements Building{

    Floor[] floors;


    public OfficeBuilding(){ }

    public OfficeBuilding(int floorsCount, int... args) {
        floors = new Floor[floorsCount];
        int j = 0;
        for (int i : args
        ) {

            floors[j] = new OfficeFloor(i);
            j++;
        }

    }

    public OfficeBuilding(Floor[] floors) {
        this.floors = floors;
    }

    public int getFloorsCount() {
        return floors.length;
    }

    public int getSpacesCount() {
        int flatCount = 0;
        for (Floor i :
                floors
        ) {
            flatCount += i.getSpacesCount();

        }
        return flatCount;
    }

    public double getTotalSquare() {
        double totalSquare = 0;
        for (Floor i :
                floors
        ) {
            totalSquare += i.getTotalFloorSquare();

        }
        return totalSquare;
    }

    public int getTotalRoomCount() {
        int totalRoomCount = 0;
        for (Floor i :
                floors
        ) {
            totalRoomCount += i.getTotalRoomCount();

        }
        return totalRoomCount;
    }


    public Floor[] getFloors() {
        return floors;
    }


    public Floor getFloor(int index) {
        if (index >= 0 && index < this.getFloorsCount())return floors[index];
        else throw new FloorIndexOutOfBoundsException("Out of floors bound ...");
    }

    public void changeFloor(int index, Floor newDwellingFloor) {
        if (index >= 0 && index < this.getFloorsCount())floors[index] = newDwellingFloor;
        else throw new FloorIndexOutOfBoundsException("Out of floors bound ...");
    }


    public Space getSpace(int index) {
        int i = 0;
        while (index >= floors[i].getSpacesCount()) {
            index -= floors[i].getSpacesCount();
            i++;
        }
        return floors[i].getSpace(index);
    }

    public boolean equals(Object obj){
        if(obj instanceof OfficeBuilding){
            if(this.getFloorsCount() == ((OfficeBuilding) obj).getFloorsCount()){
                for(int i = 0 ; i < this.getFloorsCount() ; i++){
                    if(this.getFloor(i).equals(((OfficeBuilding) obj).getFloor(i)) == false)return false;
                }
                return true;
            }
            else return false;
        }
        else return false;
    }

    public void changeSpace(int index, Space newFlat) {
        int i = 0;
        while (index > floors[i].getSpacesCount()) {
            index -= floors[i].getSpacesCount();
            i++;
        }
        floors[i].getSpaces()[index] = newFlat;
    }

    public void insertSpace(int index, Space newFlat) {
        int i = 0;
        while (index > floors[i].getSpacesCount()) {
            index -= floors[i].getSpacesCount();
            i++;
        }
        floors[i].insertSpace(index, newFlat);
    }

    public String toString(){
        StringBuffer newString = new StringBuffer("OfficeBuilding (");
        newString.append(getFloorsCount());
        for (Floor floor:
                this.getFloors()
             ) {
            newString.append(",\n    ");
            newString.append(floor.toString());
        }
        newString.append("\n)");
        return newString.toString();
    }

    public int hashCode(){
        int value = this.getFloorsCount();
        for (Floor floor:
                this.getFloors()
        ) {
            value ^= floor.hashCode();
        }
        return value;
    }

    public void delSpace(int index) {

        int i = 0;
        while (index > floors[i].getSpacesCount()) {
            index -= floors[i].getSpacesCount();
            i++;
        }
        floors[i].delSpace(index);
    }

    public Space getBestSpace() {
        Space bestSpace = new Office();
        Space tmpSpace ;
        for (Floor i :
                floors
        ) {
            tmpSpace = i.getBestSpace();
            if (bestSpace.getSquare() < tmpSpace.getSquare()) {
                bestSpace = tmpSpace;
            }

        }
        return bestSpace;
    }


    public Object clone(){
        Floor[] newFloors = new Floor[this.getFloorsCount()];
        for(int i = 0 ; i < this.getFloorsCount() ; i++){
            newFloors[i] = (Floor)this.getFloor(i).clone();
        }
        return new OfficeBuilding(newFloors);
    }

    public Space[] getSortedSpaces() {
        Space[] arr = new Office[this.getSpacesCount()];
        int n = 0;
        for (Floor i :
                floors
        ) {
            System.arraycopy(i.getSpaces(), 0, arr, n, i.getSpacesCount());
            n += i.getSpacesCount();

        }
        /*class SpaceCompare implements Comparator<Space> {
            public int compare(Space a, Space b) {
                int comp = (int) (100 * a.getSquare() - 100 * b.getSquare());
                return comp;
            }

        }*/
        SpaceComparator comparator = new SpaceComparator();
        java.util.Arrays.sort(arr, comparator);
        return arr;
    }

    @NotNull
    @Override
    public Iterator<Floor> iterator() {
        return new OfficeBuildingIterator(this);
    }
}
