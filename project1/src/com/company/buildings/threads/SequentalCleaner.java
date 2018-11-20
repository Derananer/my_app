package com.company.buildings.threads;

import com.company.buildings.Building;
import com.company.buildings.Floor;
import com.company.buildings.Space;

import java.util.concurrent.Semaphore;

public class SequentalCleaner implements Runnable{

    private MySemaphore enterSemaphore;
    private MySemaphore leaveSemaphore;
    private Building building;

    public SequentalCleaner(Building building, MySemaphore enterSemaphore, MySemaphore leaveSemaphore) {
        this.enterSemaphore = enterSemaphore;
        this.leaveSemaphore = leaveSemaphore;
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
                    enterSemaphore.acquire();
                    System.out.println("Cleaning space number " +  i++ + " with total area " + space.getSquare() + " square meters");
                    leaveSemaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
