package com.company.buildings.threads;

public class MySemaphore {

    private int count;

    public MySemaphore(int count){
        this.count = count;
    }

    public synchronized void acquire() throws InterruptedException {
        if(this.count <= 0 )this.wait();
        count --;
    }


    public synchronized void release() {
        this.count++;
        this.notify();


    }

}
