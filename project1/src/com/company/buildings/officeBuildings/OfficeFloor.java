package com.company.buildings.officeBuildings;

import com.company.buildings.Floor;
import com.company.buildings.Space;
import com.company.myExceptions.SpaceIndexOutOfBoundsException;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.Iterator;


public class OfficeFloor implements Floor, Serializable,Cloneable {

    Space[] offices;

    public OfficeFloor(int flatsCount) {
        this.offices = new Space[flatsCount];

    }

   public  OfficeFloor(Space[] offices) {
        this.offices = offices;
    }

    public Space[] getSpaces() {
        return this.offices;
    }

    public int getSpacesCount() {
        return this.offices.length;
    }

    public double getTotalFloorSquare() {
        double totalSquare = 0;
        for (Space i :
                offices
        ) {
            totalSquare += i.getSquare();

        }
        return totalSquare;
    }

    public int getTotalRoomCount() {
        int totalRoomCount = 0;
        for (Space i :
                offices
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
        return new OfficeFloor(newSpaces);
    }


    public String toString(){
        StringBuffer string = new StringBuffer("OfficeFloor (");
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
        if(obj instanceof OfficeFloor){
            if(this.getSpacesCount() == ((OfficeFloor) obj).getSpacesCount()){
                for(int i = 0 ; i < this.getSpacesCount() ; i++){
                    if(this.getSpace(i).equals(((OfficeFloor) obj).getSpace(i)) == false)return false;
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

    public Space getSpace(int index)throws SpaceIndexOutOfBoundsException {
        if (index < offices.length && index >= 0) return offices[index];
        else throw new SpaceIndexOutOfBoundsException("Out of spaces bound ...");

    }

    public void changeSpace(int index, Space newFlat)throws SpaceIndexOutOfBoundsException {
        if (index < offices.length && index >= 0) offices[index] = newFlat;
        else throw new SpaceIndexOutOfBoundsException("Out of spaces bounds ...", offices.length);
    }

    public void insertSpace(int index, Space newFlat)throws SpaceIndexOutOfBoundsException {
        if (index < offices.length && index >= 0) offices[index] = newFlat;
        else throw new SpaceIndexOutOfBoundsException("Out of spaces bounds ...", offices.length);

    }

    public void delSpace(int index)throws SpaceIndexOutOfBoundsException {
        if (index < offices.length && index >= 0) offices[index] = null;
        else throw new SpaceIndexOutOfBoundsException("Out of spaces bounds ...", offices.length);
    }

    public Space getBestSpace() {
        double maxSquare = 0;
        Space bestSpace = new Office(0,0);
        for (Space i :
                offices
        ) {
            if (maxSquare < i.getSquare()) bestSpace = i;
        }

        return bestSpace;
    }


    @NotNull
    @Override
    public Iterator<Space> iterator() {
        return new OfficeFloorIterator(this);
    }

    @Override
    public int compareTo(@NotNull Floor o) {
        return o.getSpacesCount() - this.getSpacesCount();
    }
}
