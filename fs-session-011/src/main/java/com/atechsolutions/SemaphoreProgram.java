package com.atechsolutions;

import java.util.Random;
import java.util.Stack;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreProgram {

    public static void main(String[] args) {
        GasStation gasStation = new GasStation(5);
        ExecutorService service = Executors.newFixedThreadPool(10);
        for(int i=0; i<25; i++) {
            service.execute(new BathroomUser(gasStation));
        }


    }
}


class BathroomUser extends Thread {
    private static Random random = new Random();
    private GasStation gasStation;

    public BathroomUser(GasStation gasStation) {
        this.gasStation = gasStation;
    }

    @Override
    public void run() {
        try {
            Bathroom bathroom = gasStation.accessBathroom();
            bathroom.setState(BathroomState.INUSE);

            Thread.sleep(random.nextInt(5000));
            gasStation.flushToilet(bathroom);

        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }
}

class GasStation {
    private String names [] = new String[]{"Vladimir", "Jerome", "Heidi", "Akshat", "Logan"};
    private final Semaphore permits;
    private final Stack<Bathroom> bathrooms = new Stack<>();

    public GasStation(int numberOfBathrooms) {
        this.permits = new Semaphore(numberOfBathrooms, true);
        for (int i = 0; i < numberOfBathrooms; i++) {
            bathrooms.add(new Bathroom(names[i]));
        }
    }

    public Bathroom accessBathroom() throws InterruptedException {
        permits.acquire();
        synchronized (this) {
            Bathroom bathroom = findByState(BathroomState.FREE);

            System.out.println("I'm using to harry potty" + bathroom);
            return bathroom;

        }
    }

    public void flushToilet(Bathroom bathroom) {
        if (doFlush(bathroom)) {
            permits.release();
            System.out.println(bathroom + "Oh relief!! ");
        }
    }

    public boolean doFlush(Bathroom bathroom) {
        bathroom.setState(BathroomState.FREE);
        return true;
    }

    public Bathroom findByState(BathroomState state) {
        for (Bathroom bathroom : bathrooms) {
            if (state.equals(bathroom.getState())) {
                return bathroom;
            }
        }

        return null;
    }
}

class Bathroom {
    private BathroomState state = BathroomState.FREE;
    private String name;

    public Bathroom(String name) {
        this.name = name;
    }
    public BathroomState getState() {
        return this.state;
    }

    public void setState(BathroomState state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Bathroom{" +
                "name='" + name + '\'' +
                '}';
    }
}

enum BathroomState {
    FREE, INUSE;
}
