package com.company.buildings;

import java.util.Comparator;

public class FloorComparator implements Comparator<Floor> {

    @Override
    public int compare(Floor o1, Floor o2) {
        return (int)(100*o1.getTotalFloorSquare()-100*o2.getTotalFloorSquare());
    }
}
