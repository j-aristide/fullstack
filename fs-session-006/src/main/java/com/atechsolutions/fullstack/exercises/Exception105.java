package com.atechsolutions.fullstack.exercises;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Exception105 {
    public static void main(String[] args)throws AccountNotFoundException {
        // At times it may be necessary to introduce custom exception to communicate when an undesired result occurs.
        // In the following example we are rethrowing a custom checked exception (Note: a custom unchecked exception can
        // be created by extending the RuntimeException class.
        readAccountInfo("path to text file here");
    }

    public static void readAccountInfo (String path) throws AccountNotFoundException {
        try {

            String line;
            BufferedReader reader = new BufferedReader(new FileReader(new File(path)));
            while ((line = reader.readLine()) != null) {
                System.out.println(line);

            }
        } catch (ArithmeticException | IOException ie) {
            throw new AccountNotFoundException("Sorry joe the ... not exist", ie);
        }
    }
}

class AccountNotFoundException extends Exception {
    public AccountNotFoundException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
