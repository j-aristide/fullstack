package com.atechsolutions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;

public class CyclicalBarrierProgram {
    public static void main(String[] args)throws InterruptedException {
        CyclicBarrier barrier = new CyclicBarrier(2, new Runnable() {
            @Override
            public void run() {
                System.out.println("Open the door");
            }
        });

        List<PartyGoer> partyGoerList = new ArrayList<>();
        for(int i=0; i<10; i++) {
            partyGoerList.add(new PartyGoer(barrier));
        }

        for (PartyGoer pg: partyGoerList) {
            pg.start();
            Thread.sleep(15000);
        }


    }
}

class PartyGoer extends Thread {
    CyclicBarrier barrier;
    public PartyGoer(CyclicBarrier barrier) {
        this.barrier = barrier;
    }

    public void run() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Knock knock ... Who is there?");
            String userName = scanner.nextLine();

            barrier.await();
            System.out.println("I hope you brought a gift " + userName);
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
