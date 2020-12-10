package com.atechsolutions;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankAccountApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Account> accounts = loadBank(scanner);

        System.out.println("Here is a list of the accounts " + accounts);
        if(accounts.size() >= 2) {
            doBanking(scanner, accounts);
        }

        System.out.println(accounts);
    }

    public static List<Account> loadBank(Scanner scanner) {
        boolean requestingAccountCreation = true;
        List<Account> accounts = new ArrayList<>();

        while(requestingAccountCreation) {
            System.out.println("Would you like to create a new account?");

            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("yes")) {
                accounts.add(createAccount(scanner));
            } else {
                System.out.println("Thank you have a nice day!!");
                requestingAccountCreation = false;
            }
        }

        return accounts;
    }
    public static void doBanking(Scanner scanner, List<Account> accounts) {
        System.out.println("What is your account number? ");
        String accountNumber = scanner.nextLine();

        System.out.println("How much money would you like to transfer today? ");
        String money = scanner.nextLine();

        System.out.println("What account would you like to transfer it to? ");
        String transferAccount = scanner.nextLine();

        transfer(lookup(accounts, accountNumber), lookup(accounts, transferAccount), Double.valueOf(money));
    }

    public static void transfer(Account from, Account to, double money) {
        from.balance -= money;
        to.balance += money;
    }

    public static Account lookup(List<Account> accounts, String accountNumber) {
        for(Account account : accounts) {
            if(account.accountNumber.equalsIgnoreCase(accountNumber))
                return account;
        }

        throw new IllegalArgumentException("Invalid account passed: " + accountNumber);
    }

    public static Account createAccount(Scanner scanner) {
        System.out.println("What is your name? ");
        String name = scanner.nextLine();

        System.out.println("What account type do you want? ");
        String accountType = scanner.nextLine();

        System.out.println("How much money do you have? ");
        Double money = Double.valueOf(scanner.nextLine());

        return new Account(name, accountType, money);
    }
}

class Account {
    String accountNumber;
    String name;
    String accountType;
    double balance;

    public Account(String name, String accountType, double balance) {
        this.accountNumber = RandomStringUtils.randomAlphabetic(5);
        this.accountType = accountType;
        this.name = name;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return new org.apache.commons.lang3.builder.ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("accountNumber", accountNumber)
                .append("name", name)
                .append("accountType", accountType)
                .append("balance", balance)
                .toString();
    }
}
