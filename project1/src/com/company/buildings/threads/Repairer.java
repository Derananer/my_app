package com.company.buildings.threads;

import com.company.buildings.Building;
import com.company.buildings.Floor;
import com.company.buildings.Space;

public class Repairer extends Thread{

    Building building;

    public Repairer(Building building){
        this.building = building;
    }

    @Override
    public void run(){
        int i = 0;
        for (Floor floor:
                this.building
                ) {
            for (Space space :
                    floor
                    ) {
                System.out.println("Repairing space number " +  i++ + " with total area " + space.getSquare() + " square meters");
            }

        }
    }


}
