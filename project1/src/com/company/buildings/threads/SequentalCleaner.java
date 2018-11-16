package com.company.buildings.threads;

import com.company.buildings.Building;
import com.company.buildings.Floor;
import com.company.buildings.Space;

import java.util.concurrent.Semaphore;

public class SequentalCleaner implements Runnable{

    private Semaphore semaphore;
    private Building building;

    public SequentalCleaner(Building building, Semaphore semaphore){
        this.semaphore = semaphore;
        this.building = building;
    }


    @Override
    public void run() {
        int i = 0;
        for (Floor floor:
                this.building
                ) {
            for (Space space :
                    floor
                    ) {
                try {
                    semaphore.acquire();
                    System.out.println("Cleaning space number " +  i++ + " with total area " + space.getSquare() + " square meters");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
