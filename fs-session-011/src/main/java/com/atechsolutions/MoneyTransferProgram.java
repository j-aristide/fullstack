package com.atechsolutions;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MoneyTransferProgram {
    private Random random = new Random();
    private Account account1 = new Account("Vladimir Eugene", 100000);
    private Account account2 = new Account("Jerome Fluellen", 100000);
    private Lock lock1 = new ReentrantLock();
    private Lock lock2 = new ReentrantLock();

    public static void main(String[] args)throws InterruptedException {
        MoneyTransferProgram program = new MoneyTransferProgram();
        System.out.println("Beginning Total Balance: " + (program.account1.balance + program.account2.balance));

        System.out.println("Starting 1");
        program.firstThread();


        System.out.println("Starting 2");
        program.secondThread();

        System.out.println("Account1: " + program.account1);
        System.out.println("Account2: " + program.account2);
        System.out.println("Ending Total Balance: " + (program.account1.balance + program.account2.balance));

    }

    public void firstThread()throws InterruptedException {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock1) {
                    chill(1000);
                    synchronized (lock2) {

                        for(int i=0; i<1000; i++) {
                            chill(1);
                            Account.transfer(account1, account2, random.nextInt(1000));
                        }



                    }
                }}});

        t.start();
        t.join();

    }

    public void secondThread()throws InterruptedException {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock2) {
                    chill(1000);
                    synchronized (lock1) {
                        for (int i = 0; i < 1000; i++) {
                            chill(1);
                            Account.transfer(account1, account2, random.nextInt(1000));
                        }


                    }}}});

        t.start();
        t.join();

    }

    void chill(long value) {
        try {
            Thread.sleep(value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

class Account {
    double balance;
    String accountHolder;

    Account(String accountHolder, double balance) {
        this.balance = balance;
        this.accountHolder = accountHolder;
    }

    void debit(double amount) {
        this.balance-=amount;
    }

    void credit(double amount) {
        this.balance+=amount;

    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("balance", balance)
                .append("accountHolder", accountHolder)
                .toString();
    }

    static void transfer(Account donor, Account recipient, double amount) {
        donor.debit(amount);
        recipient.credit(amount);

    }
}
