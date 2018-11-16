package com.company.buildings.dwelling;

import com.company.buildings.Floor;
import com.company.buildings.Space;
import com.company.myExceptions.SpaceIndexOutOfBoundsException;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.Iterator;

public class DwellingFloor implements Floor, Serializable,Cloneable {
    Space[] flats;
    public DwellingFloor(int flatsCount ){
        this.flats = new Space[flatsCount];
    }
    public DwellingFloor(Space[] flats){
        this.flats = flats;
    }

    public Space[] getSpaces() {
        return flats;
    }

    public int getSpacesCount(){
        return flats.length;
    }

     public double getTotalFloorSquare(){
        double totalSquare = 0;
         for (Space i:
                 flats
              ) {
             totalSquare += i.getSquare();

         }
         return totalSquare;
     }

    public int getTotalRoomCount(){
        int totalRoomCount = 0;
        for (Space i:
                flats
        ) {
            totalRoomCount += i.getRoomCount();

        }
        return totalRoomCount;
    }


    public Object clone(){
        Space[] newSpaces = new Space[this.getSpacesCount()];
        for (int i = 0 ; i < this.getSpacesCount() ; i++){
            newSpaces[i] = (Space)this.getSpace(i).clone();
        }
        return new DwellingFloor(newSpaces);
    }

    @Override
    public Iterator iterator() {
        return new DwellingFloorIterator(this);
    }


    public String toString(){
        StringBuffer string = new StringBuffer("DwellingFloor (");
        //String string = "OfficeFloor (" + this.getSpacesCount() ;+ " ";
        string.append(this.getSpacesCount());
        for (Space space:
                this.getSpaces()
        ) {
            string.append(",\n        ");
            string.append(space.toString());
        }
        string.append("\n    )");
        return string.toString();
    }

    public boolean equals(Object obj){
        if(obj instanceof DwellingFloor){
            if(this.getSpacesCount() == ((DwellingFloor) obj).getSpacesCount()){
                for(int i = 0 ; i < this.getSpacesCount() ; i++){
                    if(this.getSpace(i).equals(((DwellingFloor) obj).getSpace(i)) == false)return false;
                }
                return true;
            }
            else return false;
        }
        else return false;
    }

    public int hashCode(){
        int value = this.getSpacesCount();
        for (Space space:
                this.getSpaces()
             ) {
            value ^= space.hashCode();
        }
        return value;
    }

    public Space getSpace(int index)throws SpaceIndexOutOfBoundsException{
        if (index < flats.length && index >= 0)   return flats[index];
        else throw new SpaceIndexOutOfBoundsException("Out of spaces bounds ...");



    }

    public void changeSpace(int index, Space newFlat){
        if (index < flats.length && index >= 0) flats[index] = newFlat;
        else throw new SpaceIndexOutOfBoundsException("Out of spaces bounds ...");
    }

    public void insertSpace (int index, Space newFlat) throws SpaceIndexOutOfBoundsException{
            if (index < flats.length && index >= 0) flats[index] = newFlat;
            else throw new SpaceIndexOutOfBoundsException("Out of spaces bounds ...");
    }

    public void delSpace(int index) throws SpaceIndexOutOfBoundsException{
        if (index < flats.length && index >= 0) this.flats[index] = null;
        else throw new SpaceIndexOutOfBoundsException("Out of spaces bounds ...");
    }

    public Space getBestSpace() {
        double maxSquare = 0;
        Space bestSpace = null;
        for (Space i :
                flats
        ) {
            if (maxSquare < i.getSquare()) bestSpace = i;
        }

        return bestSpace;
    }

    @Override
    public int compareTo(@NotNull Floor o) {
        return o.getSpacesCount() - this.getSpacesCount();
    }
}
