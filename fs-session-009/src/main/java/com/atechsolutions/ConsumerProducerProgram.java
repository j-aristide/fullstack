package com.atechsolutions;

import java.util.Random;
import java.util.Scanner;

public class ConsumerProducerProgram {
    public static void main(String[] args)throws InterruptedException {
        final Random random = new Random();
        final BankAccount account1 = new BankAccount("123456789", 1000000.00);


        //final BankAccount account2 = new BankAccount("987654321", 1000000.00);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<10; i++) {
                    try {
                        account1.debit(random.nextInt(15000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });


        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<10; i++) {
                    try {
                        account1.credit(random.nextInt(15000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Done: " + account1.balance);
    }
}


class BankAccount {
    String number;
    double balance;

    BankAccount(String number, double initialBalance) {
        this.number = number;
        this.balance = initialBalance;
    }

    void debit(double amount)throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        //chill(1000);

        synchronized (this) {
            balance -= amount;

            System.out.println("Debiting..." + balance);
            notify();
            chill(1000);
            System.out.println("Debited....");
        }
    }

    void credit(double amount)throws InterruptedException {
        System.out.println("Performing credit");
        synchronized (this) {
            chill(1000);

            System.out.println("About to credit current balance is" + balance);
            wait();
            balance += amount;

            System.out.println("Performed credit " + balance);
        }
    }

    void chill(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }
}
