package com.company.buildings.hotel;

import com.company.buildings.Space;
import com.company.buildings.dwelling.DwellingFloor;

public class HotelFloor extends DwellingFloor {



    private final int STAR = 1;
    private int hotelFloorStar;

    public HotelFloor(int spaceCount) {
        super(spaceCount);
        this.hotelFloorStar = STAR;
    }

    public HotelFloor(Space[] spaces) {
        super(spaces);
        this.hotelFloorStar = STAR;
    }

    public void setHotelFloorStar(int star) {
        if(star == 1 || star == 2 || star == 3 || star == 4 || star == 5)
            this.hotelFloorStar = star;
    }

    public int getHotelFloorStar() {
        return hotelFloorStar;
    }

    public boolean equals(Object object) {
        if (object instanceof HotelFloor) {
            if (this.getSpacesCount() == ((HotelFloor) object).getSpacesCount()) {
                for (int i = 0; i < this.getSpacesCount(); i++) {
                    if (this.getSpace(i).equals(((HotelFloor) object).getSpace(i)) == false &&
                            this.getHotelFloorStar() == ((HotelFloor) object).getHotelFloorStar()
                            )
                        return false;
                }
                return true;
            } else return false;
        } else return false;
    }

    public int hashCode(){
        return this.getHotelFloorStar()^super.hashCode();
    }


    @Override
    public String toString(){
        StringBuffer string = new StringBuffer("HotelFloor (");
        //String string = "OfficeFloor (" + this.getSpacesCount() ;+ " ";
        string.append("star : " + this.getHotelFloorStar());
        string.append(", ");
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


}
