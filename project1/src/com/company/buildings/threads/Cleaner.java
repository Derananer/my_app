package com.company.buildings.threads;

import com.company.buildings.Building;
import com.company.buildings.Floor;
import com.company.buildings.Space;

public class Cleaner extends Thread{

    Building building;

    public Cleaner(Building building){
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
                System.out.println("Cleaning space number " +  i++ + " with total area " + space.getSquare() + " square meters");
            }
            
        }
    }
    

}
