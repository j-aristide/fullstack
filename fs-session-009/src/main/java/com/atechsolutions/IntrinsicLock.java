package com.atechsolutions;

import java.util.Random;

public class IntrinsicLock {
    public static void main(String[] args)throws InterruptedException{
        Account account = new Account("123456789", 100000);



        long start = System.currentTimeMillis();
        PlusBanker plusBanker1 = new PlusBanker(account);
        PlusBanker plusBanker2 = new PlusBanker(account);

        MinusBanker minusBanker1 = new MinusBanker(account);
        MinusBanker minusBanker2 = new MinusBanker(account);

        plusBanker1.start();
        plusBanker2.start();

        minusBanker1.start();
        minusBanker2.start();


        plusBanker1.join();
        plusBanker2.join();
        minusBanker1.join();
        minusBanker2.join();

        long end = System.currentTimeMillis();


        System.out.println("Total execution time: " + (end-start));
        System.out.println("Final balance: " + account.getBalance());
    }

    static void delay(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MinusBanker extends Thread {
    Random random = new Random();
    Account account;

    MinusBanker(Account account) {
        this.account = account;
    }

    public void run() {
        account.debit(random.nextInt(15000));
    }
}

class PlusBanker extends Thread {
    Random random = new Random();
    Account account;

    PlusBanker(Account account) {
        this.account = account;
    }

    public void run() {
        account.credit(random.nextInt(15000));
    }
}

class Account {
    String number;
    double balance;
    double totalDebit;
    double totalCredit;

    Object credit = new Object();
    Object debit = new Object();

    Account(String number, double balance) {
        this.number = number;
        this.balance = balance;
    }

    void credit(double amount) {
        synchronized (credit) {
            IntrinsicLock.delay(1000);
            totalCredit += amount;

            System.out.println("Crediting account: " + amount + " Current Credit Total: " + totalCredit);
        }
    }

    void debit(double amount) {
        synchronized (debit) {
            IntrinsicLock.delay(750);
            totalDebit += amount;
            System.out.println("Debiting account: " + amount + " Current Debit Total: " + totalDebit);
        }
    }

    double getBalance() {
        return balance + (totalCredit - totalDebit);
    }


}
