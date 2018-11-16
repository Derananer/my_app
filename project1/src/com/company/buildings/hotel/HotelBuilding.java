package com.company.buildings.hotel;
import com.company.buildings.Floor;
import com.company.buildings.Space;
import com.company.buildings.dwelling.Dwelling;

public class HotelBuilding extends Dwelling {

    private final double COEFF_1_STAR = 0.25;
    private final double COEFF_2_STAR = 0.5;
    private final double COEFF_3_STAR = 1;
    private final double COEFF_4_STAR = 1.25;
    private final double COEFF_5_STAR = 1.5;

    private int hotelStar;

    public HotelBuilding(int floorCount, int[] spacesCount) {
        super(floorCount, spacesCount);
    }

    public HotelBuilding(Floor[] floors) {
        super(floors);


    }

    public void setHotelStar(int hotelStar) {
        this.hotelStar = hotelStar;
    }

    public int getHotelStar() {
        return hotelStar;
    }

    @Override
    public Space getBestSpace() {
        Space bestSpace = null;
        Space tmpSpace;
        double bestSpaceSquare = 0;
        double tmpSpaceSquare = 0;
        for (Floor floor :
                this.getFloors()
        ) {
            if (floor instanceof HotelFloor) {
                tmpSpace = floor.getBestSpace();
                switch (((HotelFloor) floor).getHotelFloorStar()) {
                    case 1:
                        tmpSpaceSquare = tmpSpace.getSquare() * this.COEFF_1_STAR;
                        break;
                    case 2:
                        tmpSpaceSquare = tmpSpace.getSquare() * this.COEFF_2_STAR;
                        break;
                    case 3:
                        tmpSpaceSquare = tmpSpace.getSquare() * this.COEFF_3_STAR;
                        break;
                    case 4:
                        tmpSpaceSquare = tmpSpace.getSquare() * this.COEFF_4_STAR;
                        break;
                    case 5:
                        tmpSpaceSquare = tmpSpace.getSquare() * this.COEFF_5_STAR;
                        break;
                }
                if (tmpSpaceSquare > bestSpaceSquare) bestSpace = tmpSpace;
            }
        }
        return bestSpace;
    }

    public int hashCode(){
        return this.getHotelStar()^super.hashCode();
    }

    public boolean equals(Object object) {
        if (object instanceof HotelBuilding) {
            if (this.getFloorsCount() == ((HotelBuilding) object).getFloorsCount()) {
                for (int i = 0; i < this.getFloorsCount(); i++) {
                    if (this.getSpace(i).equals(((HotelBuilding) object).getSpace(i)) == false) return false;
                }
                return true;
            } else return false;
        } else return false;
    }

    public String toString(){
        StringBuffer newString = new StringBuffer("HotelBuilding (");
        newString.append("star : " + this.getHotelStar());
        newString.append(", ");
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
}
