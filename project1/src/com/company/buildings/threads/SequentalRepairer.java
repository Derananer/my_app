package com.company.buildings.threads;

import com.company.buildings.Building;
import com.company.buildings.Floor;
import com.company.buildings.Space;

import java.util.concurrent.Semaphore;

public class SequentalRepairer implements Runnable {

    private Semaphore enterSemaphore;
    private Semaphore leaveSemaphore;
    private Building building;

    public SequentalRepairer(Building building, Semaphore enterSemaphore, Semaphore leaveSemaphore) {
        this.enterSemaphore = enterSemaphore;
        this.leaveSemaphore = leaveSemaphore;
        this.building = building;
    }


    @Override
    public void run() {
        int i = 0;
        for (Floor floor :
                this.building
                ) {
            for (Space space :
                    floor
                    ) {
                try {
                    enterSemaphore.acquire();
                    System.out.println("Repairing space number " + i++ + " with total area " + space.getSquare() + " square meters");
                    leaveSemaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}


