package com.atechsolutions;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPoolProgram {
    public static void main(String[] args)throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(3);

        for(int i=0; i<5; i++) {
            service.execute(new Job());
        }



        service.shutdown();
        //service.awaitTermination(1, TimeUnit.MINUTES);

        System.out.println("Hello");
    }
}

class Job extends Thread {
    public void run() {
        //for(int i=0; i<10; i++) {
            try {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + " is eating corn");
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        //}
    }
}

