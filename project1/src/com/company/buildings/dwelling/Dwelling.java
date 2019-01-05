package com.company.buildings.dwelling;

import com.company.buildings.Building;
import com.company.buildings.Floor;
import com.company.buildings.Space;
import com.company.buildings.SpaceComparator;
import com.company.myExceptions.FloorIndexOutOfBoundsException;
import com.company.myExceptions.SpaceIndexOutOfBoundsException;
//import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Iterator;

public class Dwelling implements Building{

    Floor[] floors ;

    public Dwelling(){}

    public Dwelling(int floorsCount, int [] flatsCount){
        floors = new Floor[floorsCount];
        for (int i = 0 ; i < 0 ; i++){
            floors[i] = new DwellingFloor(flatsCount[i]);
        }
    }

    public Dwelling(Floor [] floors){
        this.floors = floors;
    }

    public int getFloorsCount(){
        return floors.length;
    }

    public int getSpacesCount(){
        int flatCount = 0;
        for (Floor i :
                floors
             ) {
            flatCount += i.getSpacesCount();

        }
        return flatCount;
    }

    public double getTotalSquare(){
        double totalSquare = 0;
        for (Floor i :
                floors
             ) {
            totalSquare += i.getTotalFloorSquare();

        }
        return totalSquare;
    }

    public String toString(){
        StringBuffer newString = new StringBuffer("Dwelling (");
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

    public Object clone(){
        Floor[] newFloors = new Floor[this.getFloorsCount()];
        for(int i = 0 ; i < this.getFloorsCount() ; i++){
            newFloors[i] = (Floor)this.getFloor(i).clone();
        }
        return new Dwelling(newFloors);
    }

    public boolean equals(Object obj){
        if(obj instanceof Dwelling){
            if(this.getFloorsCount() == ((Dwelling) obj).getFloorsCount()){
                for(int i = 0 ; i < this.getFloorsCount() ; i++){
                    if(this.getFloor(i).equals(((Dwelling) obj).getFloor(i)) == false)return false;
                }
                return true;
            }
            else return false;
        }
        else return false;
    }

    public int getTotalRoomCount(){
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


    public int hashCode(){
        int value = this.getFloorsCount();
        for (Floor floor:
                this.getFloors()
             ) {
            value ^= floor.hashCode();
        }
        return value;
    }
    
    public Floor getFloor(int index)throws FloorIndexOutOfBoundsException{
        if (index >= 0 && index < floors.length) return floors[index];
        else throw new FloorIndexOutOfBoundsException("Out of bound ...");
    }

    public void changeFloor(int index, Floor newDwellingFloor){
        this.floors[index] = newDwellingFloor;
    }


    public Space getSpace(int index){
        int i = 0;
        while(index >= floors[i].getSpacesCount()){
            index -= floors[i].getSpacesCount();
            i++;
        }
        return floors[i].getSpaces()[index];
    }

    public void changeSpace(int index, Space newFlat){
        int i = 0;
        while(index > floors[i].getSpacesCount()){
            index -= floors[i].getSpacesCount();
            i++;
        }
        floors[i].getSpaces()[index] = newFlat;
    }

    public void insertSpace(int index, Space newFlat) throws SpaceIndexOutOfBoundsException {
        int i = 0;
        while(index > floors[i].getSpacesCount()){
            index -= floors[i].getSpacesCount();
            i++;
        }
        floors[i].insertSpace(index,newFlat);
    }

    public void delSpace(int index) {

         int i = 0;
         while (index > floors[i].getSpacesCount()) {
             index -= floors[i].getSpacesCount();
             i++;
         }
         floors[i].delSpace(index);
     }

    public Space getBestSpace(){
        Space bestSpace = null;
        Space tmpSpace = null;
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

    public Space [] getSortedSpaces(){
        Space [] arr = new Space[this.getSpacesCount()];
        int n = 0;
        for (Floor i :
                floors
             ) {
            System.arraycopy(i,0,arr,n,i.getSpacesCount());
            n += i.getSpacesCount();

        }
        /*class FlatCompare implements Comparator<Space>{
             public int compare(Space a, Space b){
                 int comp = (int)(100*a.getSquare()-100*b.getSquare());
                  return comp;
             }

        }*/
        SpaceComparator comparator = new SpaceComparator() ;
        java.util.Arrays.sort(arr,comparator);
        return arr;
    }


    @Override
    public Iterator<Floor> iterator() {
        return new DwellingIterator(this);
    }
}
