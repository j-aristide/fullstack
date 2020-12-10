package com.atechsolutions;

import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) throws Exception{
        long start = System.currentTimeMillis();
        Greeter greeter1 = new Greeter("Trump");
        Greeter greeter2 = new Greeter("Biden");

        String people[] = {"Arishkin", "Oybek", "Angel", "Nathaniel", "Jean", "Sowmya", "Ricky", "Whithedel"};

        greeter1.start();
        greeter2.start();

        for(int i=0; i<people.length; i++) {
            if(i%2 == 0)
                greeter1.greet();
            else
                greeter2.greet();
        }

        long end = System.currentTimeMillis();

        greeter1.join();
        greeter2.join();
        System.out.println("Time taken " + (end-start) + " ms");
    }

    public static void timer() {
        try {
            sleep(2000);
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }
}


class Greeter extends Thread {
    private String greeter;
    public Greeter(String greeter) {
        this.greeter = greeter;
    }

    public void run() {
        greet();
    }

    public void greet() {
        Main.timer();
        System.out.printf("Hello from %s!\n", greeter);
    }
}