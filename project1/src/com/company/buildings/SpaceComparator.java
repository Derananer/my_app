package com.company.buildings;

import java.util.Comparator;

public class SpaceComparator  implements Comparator<Space> {
    @Override
    public int compare(Space o1, Space o2) {
        return o1.getRoomCount()-o2.getRoomCount();
    }
}
