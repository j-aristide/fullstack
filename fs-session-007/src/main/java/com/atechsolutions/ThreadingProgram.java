package com.atechsolutions;

public class ThreadingProgram {
    public static void main(String[] args)throws InterruptedException {
        Thread runner1 = new Thread(new Runner(), "julio");
        Thread runner2 = new Thread(new Runner(), "chavez");

        runner2.start();
        runner1.start();
    }
}

class Walking extends Thread {
    @Override
    public void run() {
        for (int i=0; i< 10; i++) {
            try {
                System.out.println(Thread.currentThread().getName() + " Keep walking .....");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


class Runner implements Runnable {
    @Override
    public void run() {
        for (int i=0; i< 10; i++) {
            try {
                System.out.println(Thread.currentThread().getName() + " Keep running .....");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}