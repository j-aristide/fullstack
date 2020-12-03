package com.atechsolutions.fullstack.exercises;

import java.io.*;

public class Exception102 {
    public static void main(String[] args)throws FileNotFoundException, IOException {
        // All Exceptions are derived from an Exception class please review API documentation
        // Exceptions fall under to main categories (Checked vs Unchecked)

        // ArrayIndexOutOfBoundsException is an example of an Unchecked exception -- no action is required and they extend RuntimeException class
        // An FileNotFoundException, IOException are examples of  checked exceptions


        readAccountInfo("path to text file here");

        // Notice the FileNotFoundException and IOException are explicitly mentioned as part of the method declaration.  This is one
        // way Java allows you to manage checked exceptions.  The checked exception must be addressed.
        // Here we are essentially passing the responsibility of handling the exception to
        // the calling function.  In this this case the calling function is this main() function.
        // The main() function is doing the same by rethrowing the same exception.

    }

    // Two exceptions are being thrown, however, since FileNotFoundException is an extension of IOException, the FileNotFoundException can be omitted from
    // the method declaration as it becomes redundant.  FileNotFoundException is also an IOException.
    public static void readAccountInfo(String path)throws FileNotFoundException, IOException {
        String line;
        BufferedReader reader = new BufferedReader(new FileReader(new File(path)));
        while ((line = reader.readLine()) != null) {
            System.out.println(line);

        }
    }
}
